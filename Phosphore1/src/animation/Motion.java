package animation;

public abstract class Motion {
	
	protected int duration;
	protected int localDuration;
	
	public Motion(int duration) {
		super();
		this.duration = duration;
		this.localDuration = 1;
	}
	
	public Motion() {
		super();
		this.duration = 1;
		this.localDuration = 1;
	}
	
	public abstract boolean update();

	public void rollback() {
		this.localDuration = 1;  
		// TODO Auto-generated method stub
		
	}
	

}
