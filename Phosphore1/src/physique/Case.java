package physique;

import affichage.Sprite;

public class Case extends Tangible {

	protected boolean walkable;
	protected Sprite sprite;
	
	public Case() {
		this.walkable = true;
		this.sprite = new Sprite();
	}
	
	public Case(char chary) {
		switch(chary) {
		    case 'W':
			    this.sprite = new Sprite("sol1");
			    this.walkable = false;
			    break;
		    case 'L':
		    	this.sprite = new Sprite("sol6");
		    	this.walkable = true;
		    	break;
		    case 'S':
		    	this.sprite = new Sprite("sol5");
		    	this.walkable = true;
		    	break;
		    default:
		    	this.sprite = new Sprite("sol3");
		    	this.walkable = true;
		}
		//System.out.println("CASE CREE");
		
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	
	
}
