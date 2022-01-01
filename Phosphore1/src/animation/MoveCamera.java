package animation;

public class MoveCamera extends Motion {

	protected int TargetPosX;
	protected int TargetPosY;
	
	public MoveCamera(int duration, int targetPosX, int targetPosY) {
		super(duration);
		TargetPosX = targetPosX;
		TargetPosY = targetPosY;
	}



	@Override
	public boolean update() {
		return true;
		// TODO Auto-generated method stub
		
	}

}
