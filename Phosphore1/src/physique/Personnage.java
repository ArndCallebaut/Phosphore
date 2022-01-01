package physique;

import java.util.ArrayList;

import affichage.Sprite;
import animation.ChangImage;
import animation.Sequence;

public class Personnage extends Tangible{
	
	protected ArrayList<Sprite> spritesVersGauche;
	
	protected boolean versGauche;
	protected Sequence marche;
	protected Sequence course;
	
	
	protected int etat;
	/*
	 * 0 - standing up
	 * 1 - marche
	 * 2 - course
	 * 3 - montrerPhosphore
	 */

	public Personnage() {
		this.etat = 0;
		this.versGauche = true;
		
		this.spritesVersGauche = new ArrayList<Sprite>();
		this.sprites = new ArrayList<Sprite>();
		this.currentSprite = 2;
		this.sequenceAuto= null;
		this.declenchable=null;
		//System.out.println(this.spritesVersGauche);
		
		this.marche = new Sequence(true,false);
		marche.addMotion(new ChangImage(this,10,1));
		marche.addMotion(new ChangImage(this,10,2));
		marche.addMotion(new ChangImage(this,10,3));
		//this.setSequenceAuto(sequenceOutil1);
		
		this.course = new Sequence(true,false);
		course.addMotion(new ChangImage(this,5,1));
		course.addMotion(new ChangImage(this,5,2));
		course.addMotion(new ChangImage(this,5,3));
	}
	
	public Sprite getSprite() {
		//return this.sprites.get(this.currentSprite);
		
		if (this.versGauche) {
			return this.spritesVersGauche.get(this.currentSprite);
		}
		else {
			return this.sprites.get(this.currentSprite);
		}
	}
	
	
	public void addSprite(String nom) {
		//System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
		this.sprites.add(new Sprite(nom,false));
		this.spritesVersGauche.add(new Sprite(nom,true));
	}
	
	
	
	public boolean getVersGauche() {
		return versGauche;
	}
	
	public void setVersGauche(boolean b) {
		this.versGauche=b;
	}
	
	public void makeImageVersGauche() {
		
	};
	
	public void etatis(int i) {
		if (this.etat!=i) {
			this.etat = i;
			if (i==0) {
				this.setCurrentSprite(2);
				this.setSequenceAuto(sequenceNulle);
			}
			if (i==1) {
				this.setSequenceAuto(marche);
			}
			if (i==2) {
				this.setSequenceAuto(course);
			}
		}
		
	}

	
}
