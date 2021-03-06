package Prueba4;

public abstract class Animal implements Desplazamiento {
	
    private String nombrecientifico;
    private String nombrecomun;
    private int edad;
   
	public String getNombrecientifico() {
		return nombrecientifico;
	}

	public void setNombrecientifico(String nombrecientifico) {
		this.nombrecientifico = nombrecientifico;
	}

	public String getNombrecomun() {
		return nombrecomun;
	}

	public void setNombrecomun(String nombrecomun) {
		this.nombrecomun = nombrecomun;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();                                                                  
        sb.append("Nombre Cientifico: ");
        sb.append(nombrecientifico);
        sb.append("\nNombre Común: ");
        sb.append(nombrecomun);
        sb.append("\nEdad: ");
        sb.append(edad); 
        System.out.println(desplazamiento());
        return sb.toString();
    }
	
	@Override
	public String desplazamiento() {
		return "";

		
		
	}



}

