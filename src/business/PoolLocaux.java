package business;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PoolLocaux {
	private List<Local> lstLocal;
	
    public PoolLocaux(List<Local> lstLocal)
    {
        this.lstLocal = lstLocal;
    }
    
	public List<Local> getLstLocaux()
    {
		return this.lstLocal;
	}

    public List<Local> trouverLocauxParCapaciteMax()
    {
        return new ArrayList<Local>();
    }

    public List<Local> trouverLocauxParCapaciteMin(int capaciteLocal)
    {
        return this.lstLocal.stream().filter(l -> l.getCapacite() >= capaciteLocal).collect(Collectors.toList());
    }
}
