package business;
import java.util.List;

public class AnnuaireEmployes {
	private List<Employe> lstEmploye;
	
    public AnnuaireEmployes(List<Employe> lstEmploye)
    {
        this.lstEmploye = lstEmploye;
    }
    
    public List<Employe> getLstEmploye()
    {
        return this.lstEmploye;
    }

    public Employe trouverEmploye(int idEmploye)
    {
        return this.lstEmploye.stream().filter(e -> e.getId() == idEmploye).findFirst().orElse(new Employe());
    }
}
