package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class OrganismoDos extends Organismo implements Runnable{

	private PImage orgaDos;
	//private PApplet app;
	//private boolean isAlive=true ;
	
	private int velX, velY;
	
	public OrganismoDos(int tipo, String estado, int edad, String sexo, int velocidad, int posX, int posY, PApplet app,int nacimiento  ) {
		// TODO Auto-generated constructor stub
		super(tipo, estado, edad, sexo, velocidad, posX, posY , app, nacimiento);
		this.orgaDos =  app.loadImage("../data/organismo2.png");
        //this.app=app;
		 new Thread(this).start();
	    //this.velocidad=20;
	    this.velX=20;
        this.velY=20;
    
	}

	public void pintarOrganismo() {
		 app.imageMode(app.CENTER);
		  app.image(this.orgaDos, posX, posY, 48, 56);
		  app.textSize(20);
		  app.fill(255);
		  app.text(sexo, posX, posY+30);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
				while(isAlive) {
					mover();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				}
				
		
	}
public void mover() {
		
	
	posX+=velX;
	posY+=velY;
	if (posX<15 || posX> 1200-10) {
		velX*=-1;
	}
	if (posY<120 || posY> 800-20) {
		velY*=-1;
	}
	if (estado.equals("muerto")) {
		
		velX*=0;
		velY*=0;
	}

}
}