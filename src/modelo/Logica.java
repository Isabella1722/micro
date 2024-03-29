package modelo;

import java.util.LinkedList;

import modelo.Lista;
import processing.core.PApplet;
import processing.core.PImage;
import vista.PantallaInicial;
import vista.PantallaJuego;
import vista.PantallaPausa;

public class Logica {
	// PANTALLAS
	private PantallaInicial pantallaInicio;
	private PantallaJuego pantallaJuego;
	private PantallaPausa pantallaPausa;
	private  OrganismoUno orgaUno;
	boolean correr; 
	private int pantalla = 0;
	private PApplet app;
	private String[] listaOrganismos;
	 private LinkedList <OrganismoUno> organismoUno;
	 private LinkedList <OrganismoDos> organismoDos;
	 private LinkedList <OrganismoTres> organismoTres;
	 
	 Thread hilo;
	//private OrganismoCompararEdad orgCompEdad;

	public Logica(PApplet app) {

		// CREACIÓN DE PANTALLAS
		pantallaInicio = new PantallaInicial(app);
		pantallaJuego = new PantallaJuego(app);
		pantallaPausa = new PantallaPausa(app);
		// CREACIÓN DE LIBRERÍA PROCESSING
		this.app = app;
		this.correr = true;
		// CARGAR LA LISTA DE STRINGS
		listaOrganismos = app.loadStrings("../data/lista.txt");
		// CREACIÓN DE LA LISTA
		//lista = new Lista();
	
		organismoUno = new LinkedList<OrganismoUno>();
		organismoDos = new LinkedList<OrganismoDos>();
		organismoTres = new LinkedList<OrganismoTres>();
		
		//orgCompEdad = new OrganismoCompararEdad();

		// GUARDAR LOS DATOS DE LA LISTA EN EL ORGANISMO
		for (int i = 0; i < listaOrganismos.length; i++) {
			String[] info = listaOrganismos[i].split(",");
			
			int posX=(int)app.random(50,920);
			int posY=(int)app.random(120,500);
			
			int tipo = Integer.parseInt(info[0]);
			String estado = info[1];
			int edad = Integer.parseInt(info[2]);
			String sexo = info[3];
			int velocidad = Integer.parseInt(info[4]);
			
			

			// CORREGIR ESTO PORQUE EL POX Y POSY DEBE SER GENERAL
			if (tipo==1) {
				//System.out.println(posX);
				
				organismoUno.add(new OrganismoUno(tipo, estado, edad, sexo, velocidad, posX, posY, app,0));
			}
			if (tipo==2) {
				organismoDos.add(new OrganismoDos(tipo, estado, edad, sexo, velocidad, posX, posY, app,0));
			}
			if (tipo==3) {
				organismoTres.add(new OrganismoTres(tipo, estado, edad, sexo, velocidad, posX, posY, app,0));
			}
			
			
		}
		
		for (int i = 0; i < organismoUno.size(); i++) {
			System.out.println(organismoUno.get(1).getVelocidad());
			
		}

	}

	public void pintarPantallas() {

		switch (pantalla) {

		case 0:
			// PINTAR PANTALLA INICIO DEL JUEGO
			this.pantallaInicio.pintarPantalla();

			break;

		case 1:
			// PINTAR PANTALLA DEL JUEGO
				this.pantallaJuego.pintarPantalla();
				pintarTiempo();
				pintarOrganismos();
						
			
			break;

		case 2:
			// PINTAR PANTALLA PAUSA
			this.pantallaPausa.pintarPantalla();
			break;

		}

	}
	
	public void validarEdad(Organismo obj) {
		int edad = obj.getEdad();
		int nacimiento = obj.getNacimiento();
		int tiempo_actual = pantallaJuego.getTiempo();
		int edad_actual = tiempo_actual-nacimiento;
		if(edad_actual>=edad) {
			obj.setAlive(false);
		}
	}
	
	public void pintarTiempo() {
		this.pantallaJuego.pintarTiempo();
	}
	
	public void pintarOrganismos() {
		
		
		
		for (int i = 0; i < organismoUno.size(); i++) {
			validarEdad(organismoUno.get(i));
			organismoUno.get(i).pintarOrganismo();
		//	new Thread(organismoUno.get(i)).start();
		}
		
		for (int i = 0; i < organismoDos.size(); i++) {
			
			organismoDos.get(i).pintarOrganismo();
		//	new Thread(organismoDos.get(i)).start();
		}
		
		for (int i = 0; i < organismoTres.size(); i++) {
			
			organismoTres.get(i).pintarOrganismo();
		//	new Thread(organismoTres.get(i)).start();
		}
	}

	public void evaluarPantallas() {
		switch (pantalla) {

		case 0:
			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE JUGAR
			if (app.mouseX >= 419 && app.mouseX <= 736 && app.mouseY >= 585 && app.mouseY <= 677) {
				app.cursor(app.HAND);
				this.pantalla = 1;
			}

			break;

		case 1:
			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE PAUSAR
			if (app.mouseX >= 564 && app.mouseX <= 622 && app.mouseY >= 36 && app.mouseY <= 90) {
				app.cursor(app.HAND);
				this.pantalla = 2;
				this.pantallaPausa.setLetrero(true);
			}
			
			if (app.mouseX >= 855 && app.mouseX <= 906 && app.mouseY >= 36 && app.mouseY <= 91) {
				app.cursor(app.HAND);
				this.pantalla = 0;
				
			}
			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE REANUDAR DE LA PAUSA
			
			if (app.mouseX >= 447 && app.mouseX <= 717 && app.mouseY >= 448 && app.mouseY <= 538) {
				app.cursor(app.HAND);
				this.pantalla = 0;
				this.pantallaPausa.setLetrero(false);
				
			}



			break;

		case 2:

			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE REINICIAR JUEGO

			// EVALUACIÓN ÁREA SENSIBLE DEL BOTÓN DE NUEVA LISTA

			break;

		default:
			break;
		}

	}

}
