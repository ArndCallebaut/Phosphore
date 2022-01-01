package physique;

import java.util.ArrayList;

import affichage.Sprite;

public class Positionnement {

	protected int posX;
	protected int posY;
	
	protected int ray;
	
	protected Carte contenant;
	protected Tangible tangible;
	
	
	
	public Positionnement(int posX, int posY, int ray, Carte contenant, Tangible tangible) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.ray = ray;
		this.contenant = contenant;
		this.tangible = tangible;
	}
	
	public Positionnement(int posX, int posY, Carte contenant,boolean y) {
		//y = true donc player
		//y = false donc pas player
		
		super();
		this.posX = posX;
		this.posY = posY;
		this.ray = 24;
		this.contenant=contenant;
		
		if (y==true) {
			System.out.println("Wala");
			Player p = new Player();
			
			this.tangible = new Player();
		}
		if (y==false) {
			this.tangible = new Tangible();
		}
		
	}
	
	public boolean focusPointOn(int fX, int fY) {
		//System.out.println("Illion will never die !"+ray);
		//System.out.println("fX = "+fX+" posX="+posX+"... so :"+(Math.abs(fX-posX)));
		//System.out.println("fY = "+fY+" posY="+posY+"... so :"+(Math.abs(fY-posY)<ray));
		if((Math.abs(fX-this.posX)<ray)&&(Math.abs(fY-this.posY)<ray)) {
			System.out.println("Shall we dance ?!");
			return true;
		}
			
		return false;
	}
	
	public boolean canWalk(int X, int Y) {
		if (this.contenant.walkHere(X+posX, Y+posY)){
			//System.out.println("On peut aller en X="+(X+posX)+" Y="+(Y+posY));
		}
		return this.contenant.walkHere(X+posX, Y+posY);
	}
	
	public void addX(int ax) {
		this.posX = this.posX +ax;
		}
	public void addY(int ay) {
		this.posY = this.posY +ay;
	}
	
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getRay() {
		return ray;
	}
	public void setRay(int ray) {
		this.ray = ray;
	}
	public Carte getContenant() {
		return contenant;
	}
	public void setContenant(Carte contenant) {
		this.contenant = contenant;
	}
	public Tangible getTangible() {
		return tangible;
	}
	public void setTangible(Tangible tangible) {
		this.tangible = tangible;
	}
	
	public Sprite getSpriteFromTangible() {
		return this.tangible.getSprite();
	}

	public void tryInteract() {
		// TODO Auto-generated method stub
		this.contenant.activateInteraction(posX,posY, this.getTangible().getVersGauche());
	}

	
	
	
}
