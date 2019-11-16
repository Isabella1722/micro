package vista;

import modelo.Logica;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet  {
	
	Logica logica;

	//int pantalla;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
		

	}
	
	public void settings () {
		size(1200,800);
	}
	
	public void setup () {
		  logica =new Logica(this);
		///pantalla=0;
	}

	
	public void draw () {
		logica.pintarPantallas();

	}
	
	public void mousePressed() {
		System.out.print(mouseX + " " + mouseY + "\n");

		logica.evaluarPantallas();
		
	}
	
	
}
