package affichage;

import javax.swing.JPanel;
import java.awt.Color;
import physique.Monde;

public class PanneauTexte extends JPanel implements GIA{
	
	public String texte;
	
	public PanneauTexte() {
		this.setBounds(10, 10, 100, 100);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.RED);
		this.texte = "" ; 
		// TODO Auto-generated constructor stub
	}
	

}
