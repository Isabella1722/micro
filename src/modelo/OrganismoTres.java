package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class OrganismoTres extends Organismo implements Runnable {

	private PImage orgaTres;
	//private PApplet app;
    //private boolean isAlive=true ;
    
	private int velX, velY;
	public OrganismoTres(int tipo, String estado, int edad, String sexo, int velocidad, int posX, int posY, PApplet app,int nacimiento ) {
		// TODO Auto-generated constructor stub

		super(tipo, estado, edad, sexo, velocidad, posX, posY, app, nacimiento);
		this.orgaTres =  app.loadImage("../data/organismo3.png");
        //this.app=app;
		 new Thread(this).start();
	  //  this.velocidad=30;
	    this.velX=30;
        this.velY=30;
	}

	public void pintarOrganismo() {
		 app.imageMode(app.CENTER);
		  app.image(this.orgaTres, posX, posY, 67, 45);
		  app.textSize(20);
		  app.fill(255);
		  app.text(sexo, posX, posY+30);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//mover
				while(isAlive) {
					mover();
				try {
					Thread.sleep(60);
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

