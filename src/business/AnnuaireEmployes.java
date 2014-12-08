package business;
import java.util.List;

import business.Employe;

public class AnnuaireEmployes {
	private List<Employe> lstEmploye;
	
    public AnnuaireEmployes(List<Employe> lstEmploye){}
    
	public List<Employe> getLstEmploye(){
		return this.lstEmploye;
	}
}
