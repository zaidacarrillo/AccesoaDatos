package Modelo;

public class Personaje {
	private String nombre;
	private String importancia;
	
	public Personaje(String nombre, String importancia) {
		this.nombre =  nombre;
		this.importancia =  importancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	
	

}
