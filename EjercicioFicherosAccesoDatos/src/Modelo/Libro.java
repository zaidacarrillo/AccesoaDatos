package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Libro {
	
	private String tituloLibro;
	private String editorial;
	private String autor;
	private LocalDate fechaNacimiento;
	private String genero;
	private ArrayList<Personaje> personajesPrincipales;
	
	
	public Libro(String tituloLibro, String editorial, String autor, LocalDate fecha, String genero, ArrayList<Personaje> personajesPrincipales) {
		this.tituloLibro = tituloLibro;
		this.editorial = editorial;
		this.fechaNacimiento = fecha;
		this.genero = genero;
		this.personajesPrincipales = personajesPrincipales;
	}

}
