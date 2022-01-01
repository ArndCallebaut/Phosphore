package physique;

import java.awt.event.KeyListener;
import java.util.ArrayList;

import controle.Controle;

public class Monde implements InterfaceCarte{
	
	protected ArrayList<Carte> cartes;
	protected int currentRegion;
	protected Controle controle;
	
	protected final int mesure = 12;
	
	public Monde() {
		this.currentRegion = 0;
		this.cartes = new ArrayList<Carte>();
		this.cartes.add(new Carte());
		this.controle = new Controle();
		}
 
	public Carte getCurrentMapFromWorld() {
		// TODO Auto-generated method stub
		return cartes.get(currentRegion);
	}
 
	public KeyListener getKL() {
		// TODO Auto-generated method stub
		return this.controle.cc;
	}
	
	public void actualise() {
		boolean locked = actualiseAnimation();
		if (!locked)
			applyControle();
	}
	
	public void applyControle() {
		Positionnement pp = getCurrentPositionPlayer();
		boolean immobile = true;
		
		if (controle.right == true) {
			pp.getTangible().setVersGauche(false);
			((Player) pp.getTangible()).etatis(1);
			if (pp.canWalk(mesure,0)){
				pp.addX(2);
			}
			immobile = false;
		}
		
		if (controle.left == true) {
			pp.getTangible().setVersGauche(true);
			((Player) pp.getTangible()).etatis(1);
			if (pp.canWalk(-mesure,0)){
				pp.addX(-2);
			}
			immobile = false;
		}
		
		if (controle.up==true) {
			((Player) pp.getTangible()).etatis(1);
			if (pp.canWalk(0,-mesure)){
				pp.addY(-2);
			}
			immobile = false;
			// pp.
		}
		
		if (controle.down==true) {
			((Player) pp.getTangible()).etatis(1);
			if (pp.canWalk(0,mesure)){
				pp.addY(2);
			}
			immobile = false;
			// pp.
		}
		
		if (immobile) {
			
			((Player) pp.getTangible()).etatis(0);
		}
		
		if (controle.interact==true) {
			
			//
			System.out.println("Walou");
			
			((Player) pp.getTangible()).etatis(0);
			pp.tryInteract();
			
			immobile = false;
			// pp.
		}
		
	}
	
	public boolean actualiseAnimation() {
		boolean locked = this.getCurrentMapFromWorld().loop();
		return locked;
	}
	
	//public void 
	
	public ArrayList<Positionnement> getPositionnements(){
		return this.getCurrentMapFromWorld().getContenus();
	}
	
	public Positionnement getCurrentPositionPlayer() {
		return this.getCurrentMapFromWorld().getJoueur();
	}

	public ArrayList<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}

	public int getCurrentRegion() {
		return currentRegion;
	}

	public void setCurrentRegion(int currentRegion) {
		this.currentRegion = currentRegion;
	}

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}

	public int getMesure() {
		return mesure;
	}
	
	

}
