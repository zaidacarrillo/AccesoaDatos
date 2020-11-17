package Modelo;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * Clase apoyo para el procesamiento de ficheros mediante JAXB, declaraci�n externa de el elemento ra�z de la estrucutra XML.
 *
 */
@XmlRootElement(name="listaAsignaturas")
public class Libros {
	private List<Libro> listaLibros;

	public List<Libro> getListaLibros() {
		return listaLibros;
	}
/**
 * Declaraci�n de el elemento hijo de "libros" 
 * 
 */
@XmlElement(name="asignatura")
	public void setListaLibros(List<Libro> listaLibros2) {
		this.listaLibros = listaLibros2;
	}

}
