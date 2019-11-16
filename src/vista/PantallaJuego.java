package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaJuego implements Runnable{


	PImage pantallaDos;
	PApplet app;
	public int tiempo;
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	private	boolean isRunning=true ;
	
	public PantallaJuego(PApplet app) {
        this.pantallaDos =  app.loadImage("../data/PantallaNormal.jpg");
        this.app=app;
        this.tiempo=0;
        new Thread(this).start();
	}
	
	public void pintarPantalla() {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaDos,   app.width / 2,   app.height / 2, 1200, 800);
	}
	
	 public void tiempo() {

	        this.tiempo = this.tiempo+1 ;
	    }
	
	 public void run () {
			//mover
			while(isRunning) {
				tiempo(); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			}
		}
    
    public void pintarTiempo() {
    	 app.fill(255);
         app.textSize(40);
         app.textAlign(app.CENTER);
         app.text(this.tiempo, 227, 82);
	}


}
