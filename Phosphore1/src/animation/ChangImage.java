package animation;
import physique.Tangible;

public class ChangImage extends Motion{
	
	protected Tangible sujet;
	protected int numeroImage;

	public ChangImage(Tangible sujet, int tempsAvantChangement, int numeroImage) {
		super(tempsAvantChangement);
		this.sujet = sujet;
		this.numeroImage = numeroImage;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		if (this.duration==this.localDuration) {
			//System.out.println("VENTILATEUUUUUR  "+numeroImage);
			this.sujet.setCurrentSprite(numeroImage);
			return true;
		}
		else {
			this.localDuration ++;
			return false;
		}
		
	}

	
}
