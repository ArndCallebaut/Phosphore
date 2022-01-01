package animation;

import java.util.ArrayList;

public class Sequence {
	
	protected ArrayList<Motion> motions;
	protected int currentMotion;
	protected boolean loop;
	protected boolean lockPlayer;
	protected boolean activated;
	
	public Sequence() {
		this.activated = false;
	}
	
	public Sequence(boolean loop, boolean lockPlayer) {
		super();
		this.motions = new ArrayList<Motion>();
		this.currentMotion = 0;
		this.loop = loop;
		this.lockPlayer = lockPlayer;
		this.activated = true;
	}
	
	public Sequence(boolean loop, boolean lockPlayer, boolean activated) {
		super();
		this.motions = new ArrayList<Motion>();
		this.currentMotion = 0;
		this.loop = loop;
		this.lockPlayer = lockPlayer;
		this.activated = activated;
	}
	
	public void addMotion(Motion motion) {
		this.motions.add(motion);
	}
	
	public void rollbackSequence() {
		for (int counter = 0; counter < motions.size(); counter++) { 		      
	        motions.get(counter).rollback();
	    }   
	}

	public boolean readSequence() {
		
		if (this.activated) {
		// TODO Auto-generated method stub
			boolean reading = this.motions.get(currentMotion).update();
			if (reading) {
				this.currentMotion ++;
				if (this.currentMotion >= motions.size()) {
					if (this.loop) {
						rollbackSequence();
						this.currentMotion = 0;
					}
					else {
						this.activated = false;
					}
				}
			}
		}
		
		return (this.lockPlayer && this.activated);
		
	}
	

}


