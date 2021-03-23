package animales;

public class Mamiferos extends Animal{

	public Mamiferos(String edad, String nombrecientifico, String nombrecomun) {
		super(edad, nombrecientifico, nombrecomun);
		
	}

	@Override
	public String getEdad() {
		// TODO Auto-generated method stub
		return super.getEdad();
	}

	@Override
	public String getNombrecientifico() {
		// TODO Auto-generated method stub
		return super.getNombrecientifico();
	}

	@Override
	public String getNombrecomun() {
		// TODO Auto-generated method stub
		return super.getNombrecomun();
	}

	@Override
	public void setEdad(String edad) {
		// TODO Auto-generated method stub
		super.setEdad(edad);
	}

	@Override
	public void setNombrecientifico(String nombrecientifico) {
		// TODO Auto-generated method stub
		super.setNombrecientifico(nombrecientifico);
	}

	@Override
	public void setNombrecomun(String nombrecomun) {
		// TODO Auto-generated method stub
		super.setNombrecomun(nombrecomun);
	}

	@Override
	public String Desplazarse(String string) {
		
		return super.Desplazarse("\nDesplazamiento: Estos caminan excepto los mamiferos acuáticos como las ballenas y los delfines");
	}



	

	
	
	
}
