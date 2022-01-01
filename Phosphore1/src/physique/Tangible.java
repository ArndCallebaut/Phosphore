package physique;
import java.util.ArrayList;

import affichage.GIA;
import affichage.Sprite;
import animation.Sequence;

public class Tangible implements GIA {
	
	protected ArrayList<Sprite> sprites;
	protected int currentSprite;
	private String voice;
	protected Sequence sequenceAuto;
	protected Sequence declenchable;
	protected static Sequence sequenceNulle = new Sequence();
	
	public Tangible() {
		
		this.setVoice("");
		this.sprites = new ArrayList<Sprite>();
		//this.addSprite("outil1");
		//this.addSprite("outil2");
		//this.addSprite("outil3");
		this.sprites.add(new Sprite("outil1"));	
		this.sprites.add(new Sprite("outil2"));	
		this.sprites.add(new Sprite("outil3"));	
		this.currentSprite = 2;
		this.sequenceAuto= null;
		this.declenchable=null;
		
	}
	
	public void addSprite(String nom) {
		this.sprites.add(new Sprite(nom));	 
	}
	
	public Sprite getSprite() {
		return this.sprites.get(this.currentSprite);
	}
	
	public void setCurrentSprite(int nb) {
		this.currentSprite=nb;
	}

	
	public Sequence getSequenceAuto() {
		return sequenceAuto;
	}

	public void setSequenceAuto(Sequence auto) {
		this.sequenceAuto = auto;
	}

	public Sequence getDeclenchable() {
		return declenchable;
	}

	public void setDeclenchable(Sequence declenchable) {
		this.declenchable = declenchable;
	}
	
	
	
	public boolean getVersGauche() {
		return false;
	}

	public void setVersGauche(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public String getVoice() {
		if (voice != "")
			System.out.println("EAR MY VOICE :"+(voice));
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}
	
}
