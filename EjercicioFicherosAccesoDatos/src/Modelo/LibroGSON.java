package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import Negocio.LocalDateAdapterXML;

public class LibroGSON {
	/**
	 * Estructura de LibroGSON, aplicada a la lectura y escritira Json mediante gson.
	 * @SerializedName, etiqueta editificativa de elemento.
	 */
	@SerializedName(value = "tituloLibro")
	private String tituloLibro;
	@SerializedName(value = "editorial")
	private String editorial;
	@SerializedName(value = "autor")
	private String autor;
	@SerializedName("fechaDePublicacion")
	// @JsonAdapter(JsonAdapter.class)
	private LocalDate fechaNacimiento;
	@SerializedName(value = "genero")
	private String genero;
	@SerializedName(value = "personajesPrincipales")
	private ArrayList<Personaje> personajesPrincipales;

	public LibroGSON(String tituloLibro, String editorial, String autor, LocalDate fecha, String genero,
			ArrayList<Personaje> personajesPrincipales) {
		this.tituloLibro = tituloLibro;
		this.editorial = editorial;
		this.fechaNacimiento = fecha;
		this.genero = genero;
		this.autor = autor;
		this.personajesPrincipales = personajesPrincipales;
	}

	public LibroGSON() {

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
