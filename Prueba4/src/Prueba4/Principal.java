package Prueba4;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	 	private static int opcion = 0;

		static Scanner sc = new Scanner(System.in);
	 
	 	//Se crea un ArrayList para guardar objetos de tipo de Animal.
	    
	    static ArrayList <Mamiferos> mamifero = new ArrayList<Mamiferos>();
	    
	    static ArrayList <Reptiles> reptil = new ArrayList <Reptiles>();
	    
	    static ArrayList <Aves> aves = new ArrayList <Aves>();
	    
	    static ArrayList <Anfibios> anfibios = new ArrayList <Anfibios>();
	    
	    //método main
	    public static void main(String[] args) {
	    	menu();
	    } //fin método main
	    
	   public static void menu() {
		   do {
			   
		   System.out.println("\t\tZOOLOGICO");
		   System.out.println("1. Agregar Animal");
		   System.out.println("2. Mostrar lista de Animales por su clasificacion");
		   System.out.println("0. Salir");
		   opcion = sc.nextInt();
		   switch (opcion) {
		   case 1: leerAnimales();
		   break;
		   case 2:mostrarAnimales();
		   break;
		   }
		   }while(opcion!=0);System.out.println("El programa ha finalizado");
	   }
	   
	    //Método para leer animales e introducirlos en un array
	    public static void leerAnimales(){
	 
	        //Declaración de variables para leer los datos de los animales
	    	
	        String nombrecientifico;
	        String nombrecomun;
	        int edad;
	  
	        //Variable auxiliar que contendrá la referencia a cada animal nuevo.
	        
	        Animal aux;
	        int i, N;
	        
	        //se pide por teclado el número de animales a leer
	        
	        do {
	            System.out.println("Cuantos Animales desea agregar? ");
	            N = sc.nextInt();
	        } while (N < 0);
	        sc.nextLine(); //limpiar el intro
	  
	        //lectura de N animales
	        for (i = 1; i <= N; i++) {
	            //leer datos de cada animal
	        
	        	sc.nextLine();//limpiar el intro
	        	System.out.print("Nombre Cientifico: ");
	            nombrecientifico = sc.nextLine();          
	            System.out.print("Nombre Común: ");
	            nombrecomun = sc.nextLine();
	            System.out.print("Edad: ");
	            edad = sc.nextInt();
	            sc.nextLine(); //limpiar el intro

		    	System.out.println("\nClasificacion\n");
		    	System.out.println("1. Mamifero");
		    	System.out.println("2. Reptiles");
		    	System.out.println("3. Aves");
		    	System.out.println("4. Anfibios");
			
		    	opcion = sc.nextInt();
		    	
		    	switch (opcion) {
				case 1:
		            aux = new Mamiferos(); //Se crea un objeto Mamiferos y se asigna su referencia a aux                          
		            
		            //se asignan valores a los atributos del nuevo objeto

		            aux.setNombrecientifico(nombrecientifico);
		            aux.setNombrecomun(nombrecomun);
		            aux.setEdad(edad);
		 		    
		            //se añade el objeto al final del array
		            mamifero.add((Mamiferos) aux);
		            break;
				case 2:
		            aux = new Reptiles(); //Se crea un objeto reptil y se asigna su referencia a aux                          
		            
		            //se asignan valores a los atributos del nuevo objeto
		   
		            aux.setNombrecientifico(nombrecientifico);
		            aux.setNombrecomun(nombrecomun);
		            aux.setEdad(edad);
		                      
		            //se añade el objeto al final del array
		            reptil.add((Reptiles) aux);   
					break;
				case 3:
		            aux = new Aves(); //Se crea un objeto ave y se asigna su referencia a aux                          
		            
		            //se asignan valores a los atributos del nuevo objeto
		            
		            aux.setNombrecientifico(nombrecientifico);
		            aux.setNombrecomun(nombrecomun);
		            aux.setEdad(edad);
		                      
		            //se añade el objeto al final del array
		            aves.add((Aves) aux);
		            break;
				case 4:
		            aux = new Anfibios(); //Se crea un objeto Anfibio y se asigna su referencia a aux                          
		            
		            //se asignan valores a los atributos del nuevo objeto
		   
		            aux.setNombrecientifico(nombrecientifico);
		            aux.setNombrecomun(nombrecomun);
		            aux.setEdad(edad);
		                      
		            //se añade el objeto al final del array
		            anfibios.add((Anfibios) aux);   
					break;
				}

	        
		    	
	        }
	    } //fin método leerAnimales()
	

	    //Método para mostrar todos los animales por su clasificacion   
	    public static void mostrarAnimales(){  
 	
	    	System.out.println("1. Mostrar Lista de Mamifero");
	    	System.out.println("2. Mostrar Lista de Reptiles");
	    	System.out.println("3. Mostrar Lista de Aves");
	    	System.out.println("4. Mostrar Lista de Anfibios");
	    	
	    	opcion = sc.nextInt();
	    	switch (opcion) {
	    	case 1:
	    		System.out.println("\t\tMAMIFEROS");
	    		for(int i = 0; i< mamifero.size(); i++)
	    			System.out.println(mamifero.get(i));  //se invoca el método toString de la clase Animal  
	    		break;
	    	case 2:
	    		System.out.println("\t\tREPTILES");
	    		for(int i = 0; i< reptil.size(); i++)
	    			System.out.println(reptil.get(i));  //se invoca el método toString de la clase Animal        
	    		break;
	    	case 3:
	    		System.out.println("\t\tAVES");
	    		for(int i = 0; i< aves.size(); i++)
	    			System.out.println(aves.get(i));  //se invoca el método toString de la clase Animal        
	    		break;
	    	case 4:
	    		System.out.println("\t\tANFIBIOS");
	    		for(int i = 0; i< anfibios.size(); i++)
	    			System.out.println(anfibios.get(i));  //se invoca el método toString de la clase Animal      
	    		break;	
	    		
	    	}			

	    }

	

	} //fin de la clase principal
	
	
	

