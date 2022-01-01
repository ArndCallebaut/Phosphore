package physique;

import java.util.ArrayList;

import affichage.GIA;
import affichage.Sprite;
import animation.ChangImage;
import animation.Dialogue;
import animation.Sequence;
import animation.Teleport;

public class Carte implements InterfaceCarte,GIA{

	private int mapXX;
	private int mapYY;
	private String mapName;
	private Case tab[][];
	protected boolean walkableTab[][];
	
	
	public Positionnement joueur;
	public ArrayList<Positionnement> contenus;
	public ArrayList<Sequence> sequences;
	


	public Carte() {
		 
		this.joueur = new Positionnement(100,100,this,true);
		this.contenus = new ArrayList<Positionnement>();
		this.sequences = new ArrayList<Sequence>();
		
		
		
		Tangible outil1 = new Tangible();
		Tangible outil2 = new Tangible();
		Tangible outil3 = new Tangible();
		
		Sequence sequenceOutil1 = new Sequence(true,false);
		sequenceOutil1.addMotion(new ChangImage(outil1,20,1));
		sequenceOutil1.addMotion(new ChangImage(outil1,20,2));
		sequenceOutil1.addMotion(new ChangImage(outil1,20,1));
		sequenceOutil1.addMotion(new ChangImage(outil1,20,0));
		outil1.setSequenceAuto(sequenceOutil1);
		
		Sequence sequenceTeleport = new Sequence(false,true);
		sequenceTeleport.addMotion(new Teleport(joueur,60,0,500,600));
		outil1.setDeclenchable(sequenceTeleport);
		
		Sequence sequenceOutil2 = new Sequence(true,false);
		sequenceOutil2.addMotion(new ChangImage(outil2,20,1));
		sequenceOutil2.addMotion(new ChangImage(outil2,20,2));
		sequenceOutil2.addMotion(new ChangImage(outil2,20,1));
		sequenceOutil2.addMotion(new ChangImage(outil2,20,0));
		outil2.setSequenceAuto(sequenceOutil2);
		
		Sequence blabla3 = new Sequence(false,false);
		blabla3.addMotion(new Dialogue("C'est cassé, non ?",outil3));
		outil3.setDeclenchable(blabla3);
		
		this.addPositionnement(new Positionnement(400,450,24,this,outil1));
		this.addPositionnement(new Positionnement(300,550,24,this,outil2));
		this.addPositionnement(new Positionnement(200,350,24,this,outil3));
		//this.contenus.add(new Positionnement(300,550,24,this,outil3));
		
		this.mapXX = 15;
		this.mapYY = 18;
		
		this.walkableTab = new boolean[mapXX*SIZE][mapYY*SIZE];
		
		this.mapName = "TestMap";
		this.tab = new Case[15][18];
		for (int i=0;14>=i;i++) {
			for (int j=0;17>=j;j++) {
				//System.out.println("LOOK ITS OKAY : "+i+" "+j);
				char x = baselevel.charAt(j*15+i);
				Case case1 = new Case(x);
				//System.out.println("PILOU");
				tab[i][j] = case1;
			}
		}
		this.refreshWalkable();
		System.out.println("Carte initialisée.");
	}
	
	public void refreshWalkable() {
	    for (int i = 0; i < mapXX; i++) { 		      
	    	for (int j = 0; j < mapYY; j++) { 
	    		//Pour chaque case...
	    		
	    		boolean caseWalkable = tab[i][j].isWalkable();
	    		
	    		for (int h = 0; h < SIZE; h++) { 		      
	    	    	for (int k = 0; k < SIZE; k++) {
	    	    		//System.out.println("OKOKOK LP = "+i+" "+j+" "+h+" "+k);
	    		    	this.walkableTab[i*SIZE+h][j*SIZE+k]=caseWalkable;
	    		    } 
	    	    }   
		    } 
	    }   
	}
	
	public void addPositionnement(Positionnement positionnement) {
		System.out.println("Waaaaalah j'essaie");
		int taille = this.contenus.size();
		if (taille==0) {
			System.out.println("Waaaaalah j'avais rien ");
			this.contenus.add(positionnement);
		}
		else {
			int indicePosition = 0;
			int Ypos = positionnement.getPosY();
			boolean depasse = true;
			System.out.println("Waaaaalah presque");
			while (depasse && indicePosition<contenus.size()) {
				System.out.println("Y="+Ypos+" compare="+this.contenus.get(indicePosition).getPosY());
				if (Ypos >= this.contenus.get(indicePosition).getPosY()) {
					//System.out.println("WALAAA indice="+indicePosition);
					indicePosition ++; 
					
					
				}
				else 
					depasse = false;
			}
			
			this.contenus.add(indicePosition, positionnement);
		}
		
		System.out.println("Jusqu'à maintenant et dans l'ordre :");
	    for (int c = 0; c < this.contenus.size(); c++) { 		      
	    	System.out.println("Y="+this.contenus.get(c).getPosY());
	    }
		
		
	}
	
	public Carte(int mapXX, int mapYY, String mapName, Case[][] tab) {
		super();
		this.mapXX = mapXX;
		this.mapYY = mapYY;
		this.mapName = mapName;
		this.tab = tab;
	}
	
	public boolean walkHere(int x, int y) {
		return this.walkableTab[x-1][y-1];
	}

	public void activateInteraction(int posX,int posY, boolean versGauche) {
		
		int focusPointX = posX;
		int focusPointY = posY;
		
		if (versGauche)
			focusPointX -= SIZE;
		if (!versGauche)
			focusPointX += SIZE;
		
			for (int counter = 0; counter < contenus.size(); counter++) {
				System.out.println("OPOPO : "+counter);
				if (contenus.get(counter).focusPointOn(focusPointX,focusPointY)) {
					System.out.println("Interaction !!!");
					this.addSequence(contenus.get(counter).getTangible().getDeclenchable());
			
				}
			}
		
		
	}
	
	public void addSequence(Sequence seq) {
		System.out.println("Sequence is added B)");
		this.sequences.add(seq);
	}
	
	public int getMapXX() {
		return mapXX;
	}

	public void setMapXX(int mapXX) {
		this.mapXX = mapXX;
	}

	public int getMapYY() {
		return mapYY;
	}

	public void setMapYY(int mapYY) {
		this.mapYY = mapYY;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public Case[][] getTab() {
		return tab;
	}

	public void setTab(Case[][] tab) {
		this.tab = tab;
	}

	public boolean loop() {
		// TODO Auto-generated method stub
		boolean lockedplayer = false;
		
		for (int counter = 0; counter < sequences.size(); counter++) { 	
	    	if (sequences.get(counter)!=null)
	    		lockedplayer = (lockedplayer || sequences.get(counter).readSequence());
	    }
		
		for (int counter = 0; counter < contenus.size(); counter++) { 		      
	    	//System.out.println("VENTILATEUUUUUR");
	    	
	    	if (contenus.get(counter).getTangible().getSequenceAuto()!=null)
	    		lockedplayer = (lockedplayer || contenus.get(counter).getTangible().getSequenceAuto().readSequence());
	    }
		
		//Si l'une des sequence bloque le joueur, bah elle bloaque le joueur
		
		if(lockedplayer) {
			((Player) joueur.getTangible()).etatis(0);
		}
		
		
		if(!lockedplayer) {
			if (joueur.getTangible().getSequenceAuto()!=null)
		    		joueur.getTangible().getSequenceAuto().readSequence();
		}
		
		return lockedplayer;
	       
	}

	public int getposX() { 
		// TODO Auto-generated method stub
		return this.joueur.getPosX();
	}

	public int getposY() {
		// TODO Auto-generated method stub
		return this.joueur.getPosY();
	}
	public Positionnement getJoueur() {
		return joueur;
	}

	public void setJoueur(Positionnement joueur) {
		this.joueur = joueur;
	}

	public ArrayList<Positionnement> getContenus() {
		return contenus;
	}

	public void setContenus(ArrayList<Positionnement> contenus) {
		this.contenus = contenus;
	}	
	
	
	
}
