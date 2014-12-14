package business;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PoolLocaux {
	private List<Local> lstLocal;
	
    public PoolLocaux(List<Local> lstLocal)
    {
        this.lstLocal = lstLocal;
    }
    
	public List<Local> getLstLocaux()
    {
		return this.lstLocal;
	}

    public List<Local> trouverLocauxParCapaciteMax()
    {
        return new ArrayList<Local>();
    }

    public List<Local> trouverLocauxParCapaciteMin(int capaciteLocal)
    {
        return this.lstLocal.stream().filter(l -> l.getCapacite() >= capaciteLocal).collect(Collectors.toList());
    }
    
	
	public List<Local> getLocauxDisponibles(Date dateReunion, Date heureReunion,Date dureeReunion, int capaciteLocal)
	{
		List<Local> lstLocauxParCapacite = this.lstLocal.stream().filter(l -> l.getCapacite() >= capaciteLocal).collect(Collectors.toList());
		List<Local> lstLocauxDisponibles = new ArrayList();
		List<PlageHoraire> plagesHorairesRequises = getPlageHoraire(dateReunion,heureReunion,dureeReunion); 
		for (int i = 0;i<lstLocauxParCapacite.size();i++){
			if (lstLocauxParCapacite.get(i).getCalendrier().estDisponible(plagesHorairesRequises)){
				lstLocauxDisponibles.add(lstLocauxParCapacite.get(i));
			}
		}
		return lstLocauxDisponibles;
	}
	
	private static List<PlageHoraire> getPlageHoraire(Date date, Date heure,Date duree)
	{
		List<PlageHoraire> plagesHorairesRequises;
		Calendrier calendrier = new Calendrier();
		calendrier.addLstPlageHoraire(date,heure,duree);
		return plagesHorairesRequises = calendrier.getLstPlageHoraire();
	}

	private void reserverLocal(Local localChoisi, List<PlageHoraire> plageHoraire){
		
	}
}
