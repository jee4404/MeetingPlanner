package controleurs;

import business.*;
import dbmanager.OrganisateurDBManager;
import dbmanager.ParticipantDBManager;
import dbmanager.ReservationEquipementDBManager;
import dbmanager.ReunionDBManager;
import view.frames.FenetreReunion;

import java.util.List;
import java.sql.SQLException;

public class ControleurPlanifierReunion {
    private static ControleurPlanifierReunion controleurPlanifierReunion = new ControleurPlanifierReunion( );
    /* A private Constructor prevents any other
    * class from instantiating.
    */
	private ControleurPlanifierReunion(){}

    public static ControleurPlanifierReunion getInstance( ) {
	      return controleurPlanifierReunion;
	   }

    public void afficheCreerReunion() throws SQLException
    {
        Reunion reunion = new Reunion();
        // TODO cast employe -> organisateur plus élégant
        reunion.setOrganisateur(OrganisateurDBManager.getInstance().trouverOrganisateur(SessionManager.getInstance().getEmploye().getId()));
        FenetreReunion fenetreReunion = new FenetreReunion(reunion);
    }

    public void creerReunion(Reunion reunion) throws SQLException
    {
        //teste si la reunion existe en base, on update
        if(reunion.getId() != -1 )
        {
            ReunionDBManager.getInstance().updateReunion(reunion);
        }
        else // sinon on crée
        {
            // on persiste la reunion en base de données
            ReunionDBManager.getInstance().creerReunion(reunion);
            // on notifie la liste "mes reunions" qu'une nouvelle reunion est disponible
            // il faut ajouter la reunion a la liste sur laquelle est lié le table model
            // ensuite on notifie que la source de donnée a changée
            SessionManager.getInstance().getListeMesReunions().add(reunion);
            SessionManager.getInstance().getListeMesReunionsTableModel().fireTableDataChanged();
        }

        // on met la liste des participants à jour
        // on commence par supprimer ceux  qui ne sont plus la
        this.updateParticipants(reunion);
        this.updateReservationEquipement(reunion);
    }

    public void afficheModifierReunion(int idReunion)
    {
        try
        {
            Reunion reunion = ReunionDBManager.getInstance().trouverReunion(idReunion);
            reunion.setListeParticipants(new ListeParticipants(ParticipantDBManager.getInstance().trouverParticipantParReunion(idReunion)));
            reunion.setListeEquipement(new ListeEquipement(ReservationEquipementDBManager.getInstance().trouverEquipementsParReunion(idReunion)));
            // TODO : meme chose pour liste equipement

            if (reunion == null)
                throw new RuntimeException("reunion introuvable");

            FenetreReunion fenetreReunion = new FenetreReunion(reunion);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    //public List<Local> getLstLocauxDispos(Date date,Time heure, Time durée,int nbParticipants){
    public List<Local> getLstLocauxDispos(int nbParticipants){
    	List<Local> lstLocauxDispo = SessionManager.getInstance().getPoolLocaux().trouverLocauxParCapaciteMin(nbParticipants);
    	return lstLocauxDispo;
    }

    private void updateParticipants(Reunion reunion) throws SQLException
    {
        List<Participant> participantsEnBase = ParticipantDBManager.getInstance().trouverParticipantParReunion(reunion.getId());
        for (int i = 0; i < participantsEnBase.size(); i++) {
            // on teste si le participant en base en encore dans la liste des paritcipant :
            Participant participantEnBase = participantsEnBase.get(i);
            if (reunion.getListeParticipants().trouverParticipantParIDEmploye(participantEnBase.getIdEmploye()).getIdEmploye() == -1) {
                // le participant n'a pas été trouvé dans la liste des participants de la réunion
                ParticipantDBManager.getInstance().supprimerParticipant(participantEnBase);
            }
        }

        // on ajoute ceux qui ne sont pas en base
        for (int i = 0; i < reunion.getListeParticipants().getParticipants().size(); i++) {
            Participant participant = reunion.getListeParticipants().getParticipants().get(i);
            if (participantsEnBase.stream().filter(p -> p.getIdEmploye() == participant.getIdEmploye()).findFirst().orElse(new Participant()).getIdEmploye() == -1) {
                // le participant 'a pas été trouvé en base, on peut donc le créer
                ParticipantDBManager.getInstance().creerParticipant(participant);
            }
        }
    }

    private void updateReservationEquipement(Reunion reunion) throws SQLException
    {
        // mise a jour des réservations d'équipement dans la base

        // on commence par vérifier ceux qui ne sont plus dans la liste de réservation de la réunion
        // et on les supprime
        List<ReservationEquipement> reservationsEnBase = ReservationEquipementDBManager.getInstance().trouverEquipementsParReunion(reunion.getId());
        for( ReservationEquipement reservationEnBase : reservationsEnBase )
        {
            if(reunion.getListeEquipement().trouverReservationParIdEquipement(reservationEnBase.getEquipement().getId() ) == null)
            {
                // la réservation, na pas été trouvée, elle à été supprimée
                // on met la base de onnée à jour
                ReservationEquipementDBManager.getInstance().supprimerReservation(reservationEnBase);
            }
        }

        // ensuite, on verifie ceux qui ne sont pas en base mais qui sont dans la liste de réservation
        for( ReservationEquipement reservationEquipementReunion : reunion.getListeEquipement().getReservationEquipements())
        {
            if( reservationEquipementReunion.getId() == -1 )
            {
                // la réservation n'a jamais été enregistrée
                ReservationEquipementDBManager.getInstance().creerReservation(reservationEquipementReunion);
            }
        }
    }
}
