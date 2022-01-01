package animation;

import java.util.ArrayList;

public class MutipleMotions extends Motion {
	
	protected ArrayList<Motion> motions = new ArrayList<Motion>();

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		this.motions.forEach((single) -> single.update());
		return true;
	}

	
	
}
