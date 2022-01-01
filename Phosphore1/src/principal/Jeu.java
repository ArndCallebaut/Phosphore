package principal;

import java.awt.Graphics;

import javax.swing.JFrame;

import affichage.Audio;
import affichage.GIA;
import affichage.Panneau;
import physique.Monde;

public class Jeu implements GIA {
	
	public JFrame fen;
	public static Monde monde = new Monde();
	public Panneau pan;
	
	public Jeu() throws InterruptedException {
		//this.monde = new Monde();
		this.fen = new JFrame();
		this.fen.setVisible(true);
		this.fen.setSize((CX*2+1)*SIZE,(CY*2+1)*SIZE);
		this.pan = new Panneau(monde);
		//Thread.sleep(10);
		fen.addKeyListener(monde.getKL());
		fen.setContentPane(pan);  
		
		// temporaire
		Audio son = new Audio();
		son.start();
	}
	
	
	public void rewrite() {
		// mise à jour du monde
		// et en particulier de la carte locale
		this.monde.actualise();
		
	}
	
	public void redraw() {
		// on redessine le bidule
		//System.out.println();
		pan.repaint();
	}

}
