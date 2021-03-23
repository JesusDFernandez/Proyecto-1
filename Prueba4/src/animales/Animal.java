package animales;

public abstract class Animal implements Desplazamiento{
	
	//ATRIBUTOS
	private String nombrecientifico;
	private String nombrecomun;
	private String edad;
	
	public Animal(String edad, String nombrecientifico, String nombrecomun){
		this.edad = edad;
		this.nombrecientifico = nombrecientifico;
		this.nombrecomun = nombrecomun;
	}
	
	//.:SETTERS Y GETTERS:.
	
	//GETTERS:.
	//GETTER - getEdad()
	public String getEdad() {
		return this.edad;
	}
	
	//GETTER - getNombrecientifico()
	public String getNombrecientifico() {
		return this.nombrecientifico;
	}
	
	//GETTER - getNombrecomun()
	public String getNombrecomun() {
		return this.nombrecomun;
	}
	
	
	//SETTERS:.
	//SETTER - setEdad()
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	//SETTER - setNombrecientifico()
	public void setNombrecientifico(String nombrecientifico) {
		this.nombrecientifico = nombrecientifico;
	}
	
	//SETTER - setNombrecomun()
	public void setNombrecomun(String nombrecomun) {
		this.nombrecomun = nombrecomun;
	}

	@Override
	public String Desplazarse(String string) {
		return string ;		
	}


}
