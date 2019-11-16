package modelo;

import java.util.Collections;
import java.util.LinkedList;


import modelo.OrganismoCompararEdad;
import modelo.Organismo;

public class Lista {
	private LinkedList <Organismo> listaOrganismo;
	private OrganismoCompararEdad orgCompEdad;
	
	
	public Lista() {
		// TODO Auto-generated constructor stub
		listaOrganismo = new LinkedList <Organismo>();
		orgCompEdad = new OrganismoCompararEdad();
	}
	

	public void addEst(Organismo organismo){
		listaOrganismo.add(organismo);
	}
	
	
	public void compararPorEdad() {
		Collections.sort(listaOrganismo, orgCompEdad);
	}


}
