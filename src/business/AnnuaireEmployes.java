package business;
import java.util.List;
import java.util.stream.Collectors;

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

    public Participant getParticipant(int idEmploye)
    {
        return this.lstEmploye.stream().filter(e -> e.getId() == idEmploye).findFirst().get().getParticipant();
    }
}
