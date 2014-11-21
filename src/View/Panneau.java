package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Marie Desaulniers
 */
public class Panneau extends JPanel {
	private String name;
	private GridBagConstraints gc;
	
	public Panneau(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.insets = new Insets(5, 5, 3, 3);
	}
	
	public void AddButton(JButton bouton, int x, int y){
		this.gc.gridx=x;
		this.gc.gridy=y;
		this.add(bouton, gc);
	}
	public String getName(){
		return this.name;
	}
	

}
