package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class OrganismoUno  extends Organismo implements Runnable{
	
	private PImage orgaUno;
	//private PApplet app;
	private int velX, velY;
	
	//private	boolean isAlive=true ;
	
	public OrganismoUno(int tipo , String estado, int edad, String sexo, int velocidad, int posX, int posY, PApplet app,int nacimiento ) {
		// TODO Auto-generated constructor stub
		super( tipo ,  estado,  edad,  sexo,  velocidad,  posX,  posY, app, nacimiento );
		
		this.orgaUno =  app.loadImage("../data/organismo1.png");
        //this.app=app;
        new Thread(this).start();
      //  this.velocidad=10;
        this.velX=10;
        this.velY=10;
       
	}

	
	public PImage getOrgaUno() {
		return orgaUno;
	}


	public void setOrgaUno(PImage orgaUno) {
		this.orgaUno = orgaUno;
	}


	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}




	public void pintarOrganismo() {
		  app.imageMode(app.CENTER);
		  app.image(this.orgaUno, posX, posY, 41, 41);
		  app.textSize(20);
		  app.fill(255);
		  app.text(sexo, posX, posY+30);
		  
		
	}
	
	public void run () {
		//mover
		while(isAlive) {
			mover();
		try {
			Thread.sleep(20);
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
