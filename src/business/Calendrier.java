package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Calendrier {
	private List<PlageHoraire> lstPlageHoraire;
	
	public Calendrier(){
		this.lstPlageHoraire = new ArrayList();
	}
	
	public void addPlageHoraire(PlageHoraire plageHoraire){
		this.lstPlageHoraire.add(plageHoraire);
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
}
