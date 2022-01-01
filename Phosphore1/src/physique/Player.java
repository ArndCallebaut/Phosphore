package physique;

import java.util.ArrayList;

import affichage.Sprite;
import animation.Sequence;

public class Player extends Personnage {
	
	protected Sequence montrerPhosphore;

	public Player()  {
		super();
		
		this.addSprite("Lhea1");
		this.addSprite("Lhea2");
		this.addSprite("Lhea3");
		this.addSprite("Lhea4");
		this.currentSprite=2;
	}

	
	
}
