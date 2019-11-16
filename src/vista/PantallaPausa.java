package vista;

import processing.core.PApplet;
import processing.core.PImage;

public class PantallaPausa {


	PImage pantallaTres;
	PApplet app;
	boolean letrero;
	public PantallaPausa(PApplet app) {
		  this.pantallaTres =  app.loadImage("../data/Pausado.png");;
	        this.app=app;
	        this.letrero=false;
	}
	
	public void pintarPantalla() {
	if (this.letrero ==true) {
		  app.imageMode(app.CENTER);
		  app.image(this.pantallaTres,   app.width / 2,   app.height / 2, 600, 400);
		   
	}
	}

	public PImage getPantallaTres() {
		return pantallaTres;
	}

	public void setPantallaTres(PImage pantallaTres) {
		this.pantallaTres = pantallaTres;
	}


	public boolean isLetrero() {
		return letrero;
	}

	public void setLetrero(boolean letrero) {
		this.letrero = letrero;
	}

}
