package View;

import javax.swing.JButton;
import java.awt.Dimension;

/**
 * @author Marie Desaulniers
 * Bouton de dimension prédéterminée
 */
public class Bouton extends JButton{
	Dimension dimBouton = new Dimension(150,25);
	
	public  Bouton(String titre){
		this.setPreferredSize(dimBouton);
		this.setText(titre);
	}
}
