package business;
/**
 * Created by Marie
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class Calendrier {
	private List<PlageHoraire> lstPlageHoraire;
	
	public Calendrier(){
		this.lstPlageHoraire = new ArrayList<PlageHoraire>();
	}

	public Calendrier( List<PlageHoraire> lstPlageHoraire)
	{
		this.lstPlageHoraire = lstPlageHoraire;
	}
	
	public List<PlageHoraire> getLstPlageHoraire(){
		return this.lstPlageHoraire;
	}
	
	public boolean estDisponible(List<PlageHoraire> horaireReunion){
		boolean disponibilite = true;
		int i,j;
		Date dateReunion;
		Date debutReunion;
		i = 0;
		while (disponibilite == true && i < horaireReunion.size()){
			dateReunion = horaireReunion.get(i).getDate();
			debutReunion = horaireReunion.get(i).getDebut();
			j = 0;
			while (disponibilite == true && j < lstPlageHoraire.size()){
				if (dateReunion.equals(lstPlageHoraire.get(j).getDate())){
					if (debutReunion.equals(lstPlageHoraire.get(j).getDebut())){
						disponibilite = false;
					}
				}
				j++;
			}
			i++;
		}
		return disponibilite;
	}
	
	   public void addLstPlageHoraire (Date date, Date heure, Date duree, String codeLocal){
	    	Date heureFin = ajouteTemps(heure,getHour(duree),getMin(duree));
	    	Date heurePlageHoraire = heure;
	    	while (heurePlageHoraire.compareTo(heureFin) < 0){
	    		PlageHoraire ph = new PlageHoraire(date, heurePlageHoraire, codeLocal);
	    		this.lstPlageHoraire.add(ph);
	    		heurePlageHoraire = ajouteTemps(heurePlageHoraire, 0, 30);
	    	}
	    }

	    private static Date ajouteTemps(Date heureDebut, int heure, int minute){
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTime(heureDebut);
	    	cal.add(Calendar.HOUR, heure);
	    	cal.add(Calendar.MINUTE, minute);
	    	return cal.getTime();
	    }
	    private static int getHour(Date date){
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTime(date);
	    	return cal.get(Calendar.HOUR_OF_DAY);
	    }
	    
	    private static int getMin(Date date){
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTime(date);
	    	return cal.get(Calendar.MINUTE);
	    }
	    public void addPlageHoraire(PlageHoraire ph)
	    {
	    	this.lstPlageHoraire.add(ph);
	    }
	
}
