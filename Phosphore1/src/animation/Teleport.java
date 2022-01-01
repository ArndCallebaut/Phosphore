package animation;

import physique.Positionnement;
import physique.Tangible;
import principal.Jeu;

public class Teleport extends Motion {
	
	protected Positionnement placementSujet;
	protected int carteCible;
	protected int Xcible;
	protected int Ycible;

	public Teleport(Positionnement sujet, int tempsAvantChangement, int carteCible, int Xcible,int Ycible) {
		super(tempsAvantChangement);
		this.placementSujet = sujet;
		this.carteCible = carteCible;
		this.Xcible = Xcible;
		this.Ycible = Ycible;
		
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		if (this.duration==this.localDuration) {
			//System.out.println("VENTILATEUUUUUR  "+numeroImage);
			Jeu.monde.setCurrentRegion(this.carteCible);
			this.placementSujet.setPosX(this.Xcible);
			this.placementSujet.setPosY(this.Ycible);
			return true;
		}
		else {
			this.localDuration ++;
			return false;
		}
		
	}

}
