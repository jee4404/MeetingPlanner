package business;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * Created by Marie on 2014-12-12.
 */
@DatabaseTable(tableName = "plagehoraire")
public class PlageHoraire {
	@DatabaseField(generatedId = true, useGetSet =  true, canBeNull = false)
	private int id;
	@DatabaseField(useGetSet =  true, canBeNull = false)
	private Date date;
	@DatabaseField(useGetSet =  true, canBeNull = false)
	private Date debut;
	@DatabaseField(useGetSet =  true, canBeNull = false)
	private String codeLocal;
	
	public PlageHoraire()
	{
		
	}
	
	public PlageHoraire(Date date, Date debut, String codeLocal){
		this.date = date;
		this.debut = debut;
		this.codeLocal = codeLocal;
	}
	
	public void setId (int id)
	{
		this.id = id;
	}
	public void setDate(Date date){
		this.date = date;
	}
	
	public void setDebut(Date debut)
	{
		this.debut = debut;
	}
	
	public void setCodeLocal(String codeLocal)
	{
		this.codeLocal = codeLocal;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public Date getDebut(){
		return this.debut;
	}
	
	public String getCodeLocal()
	{
		return this.codeLocal;
	}
	
}
