package View;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Marie Desaulniers
 */
public class ListeDeroulante extends JScrollPane {
	Dimension dimListe;
	
	public ListeDeroulante(JTable tableau, int lg, int ht){
		this.dimListe = new Dimension(lg,ht);
		this.setPreferredSize(dimListe);
		this.getViewport().add(tableau);
		
	}
}
