package modelo;

import processing.core.PApplet;

public class Organismo {
	protected int posX;
	protected int posY;
	protected int tipo;
	protected int velocidad;
	public int edad;
	protected String sexo;
	protected String estado;
	protected PApplet app;
	public int nacimiento;
	public boolean isAlive;
	public Organismo(int tipo, String estado, int edad, String sexo, int velocidad, int posX, int posY,PApplet app,int nacimiento) {
		this.tipo=tipo;
		this.estado=estado;
		this.edad=edad;
		this.sexo=sexo;
		this.velocidad=velocidad;
		this.posX=posX;
		this.posY=posY;
	    this.nacimiento=nacimiento;
	    this.isAlive=true;
		this.app=app;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(int nacimiento) {
		this.nacimiento = nacimiento;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}
	

	public boolean isAlive() {
		return isAlive;
	}


	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}



}
