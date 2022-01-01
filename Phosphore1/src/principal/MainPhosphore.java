package principal;

import java.awt.Graphics;

public class MainPhosphore {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Jeu jeu1 = new Jeu(); 
		
		boolean encore = true;
		
		while (encore) {
			long t1 = System.currentTimeMillis();
			jeu1.rewrite();
			jeu1.redraw();
			long t2 = System.currentTimeMillis();
			try {
				Thread.sleep(15+t1-t2);
				//System.out.println(t2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	

}

/*
	Jeu X;

	public static void main(String[] args) throws InterruptedException, IOException {
		launch(args);
	}

	public void start(Stage primeryStage) throws IOException, InterruptedException {
		
		this.X = new Jeu(primeryStage);
		this.X.rendering();
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15),ae -> {
			try {
				boucle();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
		//boucle();
	}
	
	public void boucle() throws InterruptedException { 
		X.update()
		this.X.rendering();
		System.out.println("Un tour !!");
		//Thread.sleep(100  - (System.currentTimeMillis()-count1));

	}
*/