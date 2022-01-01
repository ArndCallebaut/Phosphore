package affichage;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

import physique.Carte;
import physique.Monde;
import physique.Positionnement;

public class Panneau extends JPanel implements GIA{
	
	public Monde monde;
	public PanneauTexte panneautexte;
	protected int focaleX;
	protected int focaleY;
	protected int centreX;
	protected int centreY;
	
	protected TestPane tp;
	
	public Panneau(Monde monde) {
		super();
		this.monde = monde;
		
		this.focaleX = -7;
		this.focaleY = -22;
		this.centreX = (int)(CX+0.5)*SIZE+focaleX;
		this.centreY = (int)(CY+0.5)*SIZE+focaleY;
		
		this.setLayout(null);
		this.setBackground(Color.black);
		JLabel label = new JLabel("oooooo");
		
		
		Border border = BorderFactory.createLineBorder(Color.gray, 5);
        // set the border of this component
        label.setBorder(border);
		label.setForeground(Color.blue);
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setPreferredSize(new Dimension(200, 100));
		label.setBounds(100, 500, 800, 50);
		this.add(label);
		this.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//.dispose();
	    Carte carte = this.monde.getCurrentMapFromWorld();
	    int lenX = carte.getMapXX();
	    int lenY = carte.getMapYY();
	    
	    int x = carte.getposX()+this.focaleX*MULTIPLICATOR;
	    int y = carte.getposY()+this.focaleY*MULTIPLICATOR;
	    
	    int hx = x-centreX;
	    int hy = y-centreY;
	    
	    //System.out.println("Point haut gauche X="+hx+"  Y="+hy);
	   
	    for (int j=0;j<lenY;j++) { 

	    	for (int i=0;i<lenX;i++) {
	    		Sprite sprite = carte.getTab()[i][j].getSprite();
	  	        g.drawImage(sprite.img, i*SIZE-hx, j*SIZE-hy, this);
	  	        
	    	}
	    }
	    
	    ArrayList<Positionnement> current = this.monde.getPositionnements();
	    /*
	    for (int counter = 0; counter < current.size(); counter++) { 		      
	        Positionnement posi = current.get(counter);
	        Sprite sprite = current.get(counter).getSpriteFromTangible();
	        //System.out.println("J'affiche l'object en "+posi.getPosX());
	        g.drawImage(sprite.img, posi.getPosX()-hx+sprite.getSchiftX(),posi.getPosY()-hy+sprite.getSchiftY(), this);
	    }*/
	    
	    
	    int indiceAffichageTangibles = 0;
	    boolean joueurDessous = true;
	    int Yjoueur = carte.getJoueur().getPosY();
	    //System.out.println("***\n");
	    while (joueurDessous && indiceAffichageTangibles<current.size()) {
	    	//System.out.println("Joueur Y="+Yjoueur+" contre objetY="+carte.getContenus().get(indiceAffichageTangibles).getPosY());
	    	if (Yjoueur>carte.getContenus().get(indiceAffichageTangibles).getPosY()) {
	    		Positionnement posi = current.get(indiceAffichageTangibles);
		        Sprite sprite = current.get(indiceAffichageTangibles).getSpriteFromTangible();
		        //System.out.println("J'affiche l'object en "+posi.getPosX());
		        g.drawImage(sprite.img, posi.getPosX()-hx+sprite.getSchiftX(),posi.getPosY()-hy+sprite.getSchiftY(), this);
		        indiceAffichageTangibles ++;
	    	}
	    	else
	    		joueurDessous = false;	
	    }
	    
	    //System.out.println("****************************\n");
	    
	    Sprite sprite2 = carte.getJoueur().getSpriteFromTangible();
	    g.drawImage(sprite2.img,this.centreX+focaleX,this.centreY+focaleY, this);	    
	    
	    for (int counter = indiceAffichageTangibles; counter < current.size(); counter++) { 		      
	        Positionnement posi = current.get(counter);
	        Sprite sprite = current.get(counter).getSpriteFromTangible();
	        //System.out.println("J'affiche l'object en "+posi.getPosX());
	        g.drawImage(sprite.img, posi.getPosX()-hx+sprite.getSchiftX(),posi.getPosY()-hy+sprite.getSchiftY(), this);
	        
	        if (posi.getTangible().getVoice() != "") {
	        	System.out.println("HERE IS MY VOICE BABY");
	        	Font fonte = new Font("TimesRoman ",Font.BOLD,30);
	        	g.setFont(fonte);
	        	g.drawString("BONJOURRRRRR",posi.getPosX()-hx+sprite.getSchiftX()-20,posi.getPosY()-hy+sprite.getSchiftY());
	    
	        }
	        }
	    

	    //g.drawImage(sprite.img,this.getX()+focaleX,this.getY()+focaleY, this);
	    
	    //System.out.println("On a des coordonnées : X="+carte.getposX()+"    Y="+carte.getposY());
	/*
	    for (int i=1;i<carte.getContenus().size();i++) {
		    Sprite sprite1 = carte.getContenus().get(i).getSpriteFromTangible();
		    g.drawImage(sprite1.img, carte.getContenus().get(i).getPosX(),carte.getContenus().get(i).getPosY(), this);
		 
	    }
	*/
	//g.dispose();
	} 
	
	public void actualize() {
		repaint();
	}
	
	}
