package animales;

import java.util.*;

public class Lista_Anfibios {
	

	//ATRIBUTOS
	private static Lista_Anfibios pA = new Lista_Anfibios();
	
	private ArrayList<Anfibios> lista = new ArrayList<Anfibios>();

	public Lista_Anfibios() {

	}

	//GETTER - getInstances
	public static Lista_Anfibios getInstances() {
		return pA;
	}
	
	//GETTER - getLista()
	public ArrayList<Anfibios> getLista(){
		return this.lista;
	}

	//METODO - escribirAnimal()
	public String escribirAnimal(ArrayList<Anfibios> array) {
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
