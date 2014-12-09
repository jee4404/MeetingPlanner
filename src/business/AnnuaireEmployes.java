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

    public Participant getParticipant(int idEmploye)
    {
        Participant retVal = null;
        for(int i = 0; i < this.lstEmploye.size(); i++)
        {
            if( this.lstEmploye.get(i).getId() == idEmploye)
            {
                retVal = (Participant) this.lstEmploye.get(i);
            }
        }
        return retVal;
    }
}
