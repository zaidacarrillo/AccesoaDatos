package Modelo;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * Clase apoyo para el procesamiento de ficheros mediante JAXB, declaración externa de el elemento raíz de la estrucutra XML.
 *
 */
@XmlRootElement(name="listaAsignaturas")
public class Libros {
	private List<Libro> listaLibros;

	public List<Libro> getListaLibros() {
		return listaLibros;
	}
/**
 * Declaración de el elemento hijo de "libros" 
 * 
 */
@XmlElement(name="asignatura")
	public void setListaLibros(List<Libro> listaLibros2) {
		this.listaLibros = listaLibros2;
	}

}
