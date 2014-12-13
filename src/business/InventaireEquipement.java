package business;

import java.util.List;

public class InventaireEquipement {
	private List<Equipement> lstEquipement;
	
    public InventaireEquipement(List<Equipement> lstEquipement)
    {
        this.lstEquipement = lstEquipement;
    }
    
	public List<Equipement> getLstEquipement(){
		return this.lstEquipement;
	}

    public Equipement trouverEquipementParID(int idEquipement)
    {
        return this.lstEquipement.stream().filter(eq -> eq.getId() == idEquipement).findFirst().orElse(new Equipement());
    }
}