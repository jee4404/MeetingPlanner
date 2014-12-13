package business;

import java.util.Date;

public class PlageHoraire {
	private Date date;
	private Date debut;

	public PlageHoraire(Date date, Date debut){
		this.date = date;
		this.debut = debut;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public Date getDebut(){
		return this.debut;
	}
}
