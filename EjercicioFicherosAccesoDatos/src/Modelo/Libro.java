package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Libro {

	private String editorial;
	private String autor;
	private LocalDate fechaNacimiento;
	private String genero;
	private ArrayList<Personaje> personajesPrincipales;
	private String tituloLibro;
	
	
	public Libro(String tituloLibro, String editorial, String autor, LocalDate fecha, String genero, ArrayList<Personaje> personajesPrincipales) {
		this.tituloLibro = tituloLibro;
		this.editorial = editorial;
		this.fechaNacimiento = fecha;
		this.genero = genero;
		this.autor=autor;
		this.personajesPrincipales = personajesPrincipales;
	}
	
	
	public String getTituloLibro() {
		return tituloLibro;
	}


	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}


	public String getEditorial() {
		return editorial;
	}


	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public ArrayList<Personaje> getPersonajesPrincipales() {
		return personajesPrincipales;
	}


	public void setPersonajesPrincipales(ArrayList<Personaje> personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}

}
