package controle;

public class Controle {

	public boolean right;
	public boolean left;
	public boolean up;
	public boolean down;
	public boolean interact;
	public boolean phosphore;
	public ControleClavier cc;
	
	public Controle() {
		this.cc = new ControleClavier(this);
		this.right = false;
		this.left = false;
		this.up = false;
		this.down = false;
		this.interact = false;
		this.phosphore = false;
		
	}
	
	public void cleanControle() {
		this.right = false;
		this.left = false;
		this.up = false;
		this.down = false;
		this.interact = false;
		this.phosphore = false;
		//this.cc = new ControleClavier();
	}
	public void makeRight() {
		System.out.println("RIGHT");
		//this.cleanControle();
		this.right = true;
	}
	public void makeLeft() {
		System.out.println("LEFT");
		//this.cleanControle();
		this.left = true;
	}
	public void makeUp() {
		System.out.println("UP");
		//this.cleanControle();
		this.up = true;
	}

	public void makeDown() {
		System.out.println("DOWN");
		//this.cleanControle();
		this.down = true;
	}
	public void makeInteract() {
		//this.cleanControle();
		this.interact = true;
	}
	public void makePhosphore() {
		//this.cleanControle();
		this.phosphore = true;
	}
	
	
	
	public void demakeRight() {
		System.out.println("NO RIGHT");
		//this.cleanControle();
		this.right = false;
	}
	public void demakeLeft() {
		System.out.println("NO LEFT");
		//this.cleanControle();
		this.left = false;
	}
	public void demakeUp() {
		System.out.println("NO UP");
		//this.cleanControle();
		this.up = false;
	}

	public void demakeDown() {
		System.out.println("NO DOWN");
		//this.cleanControle();
		this.down = false;
	}
	public void demakeInteract() {
		//this.cleanControle();
		this.interact = false;
	}
	public void demakePhosphore() {
		//this.cleanControle();
		this.phosphore = false;
	}
	
}
