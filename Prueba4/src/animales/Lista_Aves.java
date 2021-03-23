package animales;

import java.util.*;

public class Lista_Aves {
	

	//ATRIBUTOS
	private static Lista_Aves pA = new Lista_Aves();
	
	private ArrayList<Aves> lista = new ArrayList<Aves>();

	public Lista_Aves() {

	}

	//GETTER - getInstances
	public static Lista_Aves getInstances() {
		return pA;
	}
	
	//GETTER - getLista()
	public ArrayList<Aves> getLista(){
		return this.lista;
	}

	//METODO - escribirAnimal()
	public String escribirAnimal(ArrayList<Aves> array) {
		String s = "";	
		
		if(array.size()> 0) {
			for (int i = 0; i < 1; i++) {
				s+= array.get(0).Desplazarse(toString())+"\n\n";
			}
		}
	
		for (int i = 0; i < array.size(); i++) {

			s += "  "+ (i + 1) 
			+ String.format("%25s", " Nombre Cientifico: ") + array.get(i).getNombrecientifico() +"\n"
			+ String.format("%28s", " Nombre Comun: ")+ array.get(i).getNombrecomun() +"\n"
			+ String.format("%40s", " Edad: ")+ array.get(i).getEdad()+"\n";
			
					
			s += "  ------------------------------------------------------------"
					+ "---------------------------------------------------------"
					+ "----------------------\n";	
			}
		
		return s;



}
	}
