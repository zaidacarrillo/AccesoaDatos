package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tituloLibro;
	private String editorial;
	private String autor;
	private LocalDate fechaNacimiento;
	private String genero;
	private ArrayList<Personaje> personajesPrincipales;
	
	
	public Libro(String tituloLibro, String editorial, String autor, LocalDate fecha, String genero,
			ArrayList<Personaje> personajesPrincipales) {
		this.tituloLibro = tituloLibro;
		this.editorial = editorial;
		this.fechaNacimiento = fecha;
		this.genero = genero;
		this.autor = autor;
		this.personajesPrincipales = personajesPrincipales;
	}

	

	@Override
	public String toString() {
		return "Libro [tituloLibro=" + tituloLibro + ", editorial=" + editorial + ", autor=" + autor
				+ ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", personajesPrincipales="
				+ personajesPrincipales + "]";
	}


	
	public String getTituloLibro() {
		return tituloLibro;
	}
	@XmlElement(name="Titulo")
	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public String getEditorial() {
		return editorial;
	}
	@XmlElement(name="Editorial")
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getAutor() {
		return autor;
	}
	@XmlElement(name="Autor")
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	@XmlElement(name="FechaDePublicacion")
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}
	@XmlElement(name="Genero")
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ArrayList<Personaje> getPersonajesPrincipales() {
		return personajesPrincipales;
	}
	@XmlElementWrapper(name="PersonajesPrincipales")
	public void setPersonajesPrincipales(ArrayList<Personaje> personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}

}
