package controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControleClavier implements KeyListener{

	protected Controle controle;
	
	public ControleClavier(Controle controle) {
		this.controle = controle;
		//addKeyListener(this);
	}
	
	
	public void keyPressed(KeyEvent e) {

	    int key = e.getKeyCode();

	    if (key == KeyEvent.VK_LEFT) {
	        controle.makeLeft();
	    }

	    if (key == KeyEvent.VK_RIGHT) {
	    	controle.makeRight();
	    }

	    if (key == KeyEvent.VK_UP) {
	    	controle.makeUp();
	    }

	    if (key == KeyEvent.VK_DOWN) {
	    	controle.makeDown();
	    }
	    
	    // KeyEvent.VK_A
	    
	    if (key == KeyEvent.VK_W) {
	    	controle.makeInteract();
	    }

	    if (key == KeyEvent.VK_X) {
	    	controle.makePhosphore();
	    }
	    
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	    int okey = arg0.getKeyCode();
	    System.out.println(okey);

	    if (okey == KeyEvent.VK_LEFT) {
	        controle.demakeLeft();
	    }

	    if (okey == KeyEvent.VK_RIGHT) {
	    	controle.demakeRight();
	    }

	    if (okey == KeyEvent.VK_UP) {
	    	controle.demakeUp();
	    }

	    if (okey == KeyEvent.VK_DOWN) {
	    	controle.demakeDown();
	    }
	    
	    if (okey == KeyEvent.VK_W) {
	    	controle.demakeInteract();
	    }

	    if (okey == KeyEvent.VK_X) {
	    	controle.demakePhosphore();
	    }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
