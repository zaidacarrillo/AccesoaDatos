package Negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Modelo.Libro;

public class ProcesamientoFicheroXMLSAX extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero(String ruta) {

		return null;
	}

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
		File file = new File(ruta);
		if (!file.exists()) {
			
		}
	}
}
