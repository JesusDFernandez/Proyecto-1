package Prueba4;

public class Mamiferos extends Animal{

	@Override
	public int getEdad() {
		// TODO Auto-generated method stub
		return super.getEdad();
	}

	@Override
	public void setEdad(int edad) {
		// TODO Auto-generated method stub
		super.setEdad(edad);
	}

	@Override
	public String getNombrecomun() {
		// TODO Auto-generated method stub
		return super.getNombrecomun();
	}

	@Override
	public void setNombrecomun(String nombrecomun) {
		// TODO Auto-generated method stub
		super.setNombrecomun(nombrecomun);
	}

	@Override
	public String getNombrecientifico() {
		// TODO Auto-generated method stub
		return super.getNombrecientifico();
	}

	@Override
	public void setNombrecientifico(String nombrecientifico) {
		// TODO Auto-generated method stub
		super.setNombrecientifico(nombrecientifico);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public String desplazamiento() {
		// TODO Auto-generated method stub
		System.out.println("\nDesplazamiento: Estos caminan excepto los mamiferos acuáticos como las ballenas y los delfines");
		return super.desplazamiento();
		
		
	}

		
	
}
