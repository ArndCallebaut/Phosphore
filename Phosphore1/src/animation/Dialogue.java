package animation;

import physique.Tangible;

public class Dialogue extends Motion {
	
	protected String blabla;
	protected String affiched;
	
	protected Tangible tan;
	protected int timer;

	public Dialogue(String blabla,Tangible tan) {
		super();
		this.blabla = blabla;
		this.tan = tan;
		
		this.affiched="";
	}

	@Override
	public boolean update() {
		
		if (this.duration==this.localDuration) {
			this.tan.setVoice("");
			return true;
		}
		else {
			
			this.affiched += blabla.charAt(localDuration-1);
			this.localDuration ++;
			this.tan.setVoice(this.affiched);
			return false;
		}
		
		
	}
}