package business;

import java.util.Date;

public class PlageHoraire {
	private Date date;
	private double debut;

	public PlageHoraire(Date date, double debut){
		this.date = date;
		this.debut = debut;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public double getDebut(){
		return this.debut;
	}
}
