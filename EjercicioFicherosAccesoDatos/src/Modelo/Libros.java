package Modelo;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="libros")
public class Libros {
	private List<Libro> listaLibros;

	public List<Libro> getListaLibros() {
		return listaLibros;
	}
@XmlElement(name="libro")
	public void setListaLibros(List<Libro> listaLibros2) {
		this.listaLibros = listaLibros2;
	}

}
