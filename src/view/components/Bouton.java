package view.components;

import java.awt.Dimension;

import javax.swing.JButton;

public class Bouton extends JButton{
	Dimension dimBouton = new Dimension();
	public Bouton(String titre, int dx, int dy){
		dimBouton.width = dx;
		dimBouton.height = dy;
		this.setPreferredSize(dimBouton);
		this.setText(titre);
	}
}
