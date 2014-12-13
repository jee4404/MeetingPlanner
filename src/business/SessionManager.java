package business;

import dbmanager.*;
import view.tablemodels.ListeMesParticipationsTableModel;
import view.tablemodels.ListeMesReunionsTableModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rémy on 2014-12-04.
 * cette classe nous sert a garder des références
 * vers certains objets afin d'y accéder depuis n'importe
 * ou dans le code, notamment les contrôleur. Le but de cette classe
 * est surtout de limiter le couplage entre classe
 *
 * cet objet est un singleton
 */
public class SessionManager {
    private static SessionManager instance;
    private Employe employe;
    private ListeMesReunionsTableModel listeMesReunionsTableModel;
    private ListeMesParticipationsTableModel listeMesParticipationsTableModel;
    private List<Reunion> listeMesReunions;
    private List<Reunion> listeMesInvitations;
    private AnnuaireEmployes annuaireEmployes;
    private InventaireEquipement inventaireEquipement;
    private PoolLocaux poolLocaux;

    private SessionManager()
    {
        try
        {
            List<Employe> lstEmployes = EmployeDBManager.getInstance().trouverTousEmployes();
            List<Equipement> lstEquipement = EquipementDBManager.getInstance().trouverTousEquipements();
            List<Local> lstLocaux = LocalDBManager.getInstance().trouverTousLocaux();
            annuaireEmployes = new AnnuaireEmployes(lstEmployes);
            inventaireEquipement = new InventaireEquipement(lstEquipement);
            poolLocaux = new PoolLocaux(lstLocaux);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static SessionManager getInstance()
    {
        if( instance == null )
        {
            instance = new SessionManager();
        }
        return instance;
    }

    public Employe getEmploye()
    {
        return this.employe;
    }

    public AnnuaireEmployes getAnnuaireEmployes(){
        return annuaireEmployes;
    }

    public InventaireEquipement getInventaireEquipement(){
        return inventaireEquipement;
    }

    public PoolLocaux getPoolLocaux(){
        return poolLocaux;
    }

    public ListeMesParticipationsTableModel getListeMesParticipationsTableModel()
    {
        return this.listeMesParticipationsTableModel;
    }

    public ListeMesReunionsTableModel getListeMesReunionsTableModel()
    {
        return this.listeMesReunionsTableModel;
    }

    public List<Reunion> getListeMesReunions()
    {
        return this.listeMesReunions;
    }

    public List<Reunion> getListeMesInvitations()
    {
        return this.listeMesInvitations;
    }

    public void setEmploye(Employe employe)
    {
        this.employe = employe;
    }

    public void setListeMesParticipationsTableModel(ListeMesParticipationsTableModel listeMesParticipationsTableModel)
    {
        this.listeMesParticipationsTableModel = listeMesParticipationsTableModel;
    }

    public void setListeMesReunionsTableModel(ListeMesReunionsTableModel listeMesReunionsTableModel)
    {
        this.listeMesReunionsTableModel = listeMesReunionsTableModel;
    }

    public void setListeMesReunions(List<Reunion> listeMesReunions)
    {
        this.listeMesReunions = listeMesReunions;
    }

    public void setListeMesInvitations(List<Reunion> listeMesInvitations)
    {
        this.listeMesInvitations = listeMesInvitations;
    }

    public void initManager(Employe employe) throws SQLException
    {
        // employe connecte
        getInstance().setEmploye(employe);

        // reunions organisees par employe connecte + une reference vers le table model pour le mettre à jour depuis les controleurs
        getInstance().setListeMesReunions(ReunionDBManager.getInstance().trouverReunionParOrganisateur(employe.getId()));
        getInstance().setListeMesReunionsTableModel(new ListeMesReunionsTableModel(getInstance().getListeMesReunions()));

        // reunions auxquelles est invité employe connecte + une reference vers le table model pour le mettre à jour depuis les controleurs
        getInstance().setListeMesInvitations(ParticipantDBManager.getInstance().trouverMesInvitations(employe.getId()));
        getInstance().setListeMesParticipationsTableModel(new ListeMesParticipationsTableModel(getInstance().getListeMesInvitations()));
    }
}
