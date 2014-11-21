package view.components;

import java.awt.Dimension;

import javax.swing.JButton;

public class Bouton extends JButton{
	Dimension dimBouton = new Dimension(150,25);
	public Bouton(String titre){
		this.setPreferredSize(dimBouton);
		this.setText(titre);
	}
}
