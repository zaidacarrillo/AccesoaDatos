package Modelo;

import java.io.Serializable;

public class Personaje implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String importancia;

	public Personaje(String nombre, String importancia) {
		this.nombre = nombre;
		this.importancia = importancia;
	}
	
	public Personaje () {
		
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

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", importancia=" + importancia + "]";
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

}
