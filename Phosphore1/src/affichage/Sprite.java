package affichage;

import java.io.File;
import java.io.IOException;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprite implements GIA{
	
	public Image img;
	
	public int schiftX;
	public int schiftY;
	
	


	// when rendering, use this image
	private BufferedImage worldRet = null;
	
	public Sprite() {
		super();
	}
	
	public Sprite(String name) {
		
		Image imag;
		
		try {
			imag = ImageIO.read(new File("ressources/"+name+".png"));
			int w= imag.getWidth(null);
			int h = imag.getHeight(null);
			//imag =  imag.getScaledInstance(w*MULTIPLICATOR, h*MULTIPLICATOR, Image.SCALE_DEFAULT);
			
			//this.img = imag;
			
			this.schiftY=-h*MULTIPLICATOR;
			this.schiftX=-(int)(w/2)*MULTIPLICATOR+1;
			
			
			BufferedImage res = new BufferedImage(w*MULTIPLICATOR, h*MULTIPLICATOR, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = res.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
			g2.drawImage(imag, 0, 0, w*MULTIPLICATOR, h*MULTIPLICATOR, null);
			g2.dispose();
			
			
			/*
		    AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		    tx.translate(-res.getWidth(null), 0);
		    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		    this.img = op.filter(res, null);
			*/
		    
		    this.img = res;
			//System.out.println("IMAGE CHARGEE");
			
		} catch (IOException e) {
			System.out.println("TEST ERROR IMAGE NON TROUVEE pour "+name);
			e.printStackTrace();
		}
	}
	
	public Sprite(String name, boolean agauche) {
		
		Image imag;
		
		try {
			imag = ImageIO.read(new File("ressources/"+name+".png"));
			int w= imag.getWidth(null);
			int h = imag.getHeight(null);
			
			this.schiftY=-h*MULTIPLICATOR;
			this.schiftX=-(int)(w/2)*MULTIPLICATOR+1;
			
			
			
			BufferedImage res = new BufferedImage(w*MULTIPLICATOR, h*MULTIPLICATOR, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = res.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
			g2.drawImage(imag, 0, 0, w*MULTIPLICATOR, h*MULTIPLICATOR, null);
			g2.dispose();
			
			if (agauche) {
				AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			    tx.translate(-res.getWidth(null), 0);
			    AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			    this.img = op.filter(res, null);
			}
			else {
				this.img=res;
			}
			
			//System.out.println("IMAGE CHARGEE");
			
		} catch (IOException e) {
			System.out.println("TEST ERROR IMAGE NON TROUVEE pour "+name);
			e.printStackTrace();
		}
		
	}


	/*
	public Image resample(Image input, int scaleFactor) {
		final int W = (int) input.getWidth(null);
		final int H = (int) input.getHeight(null);
		final int S = scaleFactor;

		//WritableImage output = new WritableImage(W * S, H * S);
		//PixelReader reader = input.getPixelReader();
		//PixelWriter writer = output.getPixelWriter();

		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				final int argb = reader.getArgb(x, y);
				for (int dy = 0; dy < S; dy++) {
					for (int dx = 0; dx < S; dx++) {
						writer.setArgb(x * S + dx, y * S + dy, argb);
					}
				}
			}
		}

		return output;
	}
	*/
	
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getSchiftX() {
		return schiftX;
	}

	public void setSchiftX(int schiftX) {
		this.schiftX = schiftX;
	}

	public int getSchiftY() {
		return schiftY;
	}

	public void setSchiftY(int schiftY) {
		this.schiftY = schiftY;
	}
}
