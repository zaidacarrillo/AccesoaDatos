package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import Negocio.LocalDateAdapterXML;

@XmlRootElement
@XmlType(propOrder={"tituloLibro", "editorial", "autor","fechaNacimiento","genero","personajesPrincipales"})
public class Libro implements Serializable {

	/**
	 * Estructura de Libro, getters, setters y constructor vacío.
	 */
	private static final long serialVersionUID = 1L;
	private String tituloLibro;
	private String editorial;
	private String autor;
	private LocalDate fechaPublicacion;
	private String genero;
	private ArrayList<Personaje> personajesPrincipales;
	
	
	public Libro(String tituloLibro, String editorial, String autor, LocalDate fecha, String genero,
			ArrayList<Personaje> personajesPrincipales) {
		this.tituloLibro = tituloLibro;
		this.editorial = editorial;
		this.fechaPublicacion = fecha;
		this.genero = genero;
		this.autor = autor;
		this.personajesPrincipales = personajesPrincipales;
	}
	public Libro() {
	
	}
	

	@Override
	public String toString() {
		return "Libro [tituloLibro=" + tituloLibro + ", editorial=" + editorial + ", autor=" + autor
				+ ", fechaNacimiento=" + fechaPublicacion + ", genero=" + genero + ", personajesPrincipales="
				+ personajesPrincipales + "]";
	}


	
	public String getTituloLibro() {
		return tituloLibro;
	}
	/**
	 * 
	 * @XmlElement como etiqueta elemento, en el procesamiento XMLJAXB.
	 */
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
		return fechaPublicacion;
	}
	@XmlElement(name="FechaDePublicacion")
	@XmlJavaTypeAdapter(value = LocalDateAdapterXML.class)
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaPublicacion = fechaNacimiento;
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
	/**
	 * 
	 * @XmlElementWrapper wrapper para elemento con name:personajesPrincipales que depende de @XmlElement name: personaje.
	 */
	@XmlElementWrapper(name="personajesPrincipales")
	@XmlElement(name="personaje")
	public void setPersonajesPrincipales(ArrayList<Personaje> personajesPrincipales) {
		this.personajesPrincipales = personajesPrincipales;
	}

}
