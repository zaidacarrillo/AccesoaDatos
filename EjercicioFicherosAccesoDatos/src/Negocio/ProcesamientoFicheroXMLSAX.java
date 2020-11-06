package Negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import Modelo.Libro;
import Modelo.ParseadorLibrosSAX;

public class ProcesamientoFicheroXMLSAX extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
		ArrayList <Libro> listaLibros = new ArrayList();
		try {
			XMLReader lector = XMLReaderFactory.createXMLReader();
			ParseadorLibrosSAX parserSAX = new ParseadorLibrosSAX();
			lector.setContentHandler(parserSAX);
			InputSource fichero = new InputSource("C:\\Users\\PC33\\Documents\\prueba\\lecturaXMLSAX.xml");
			lector.parse(fichero);
			listaLibros = parserSAX.obtenerResultado();
		
		}catch (Exception ex) {
			System.out.println("Excepción en el procesamiento del XML");
			ex.printStackTrace();
		}

		return listaLibros;
	}

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
		/*
		 * 
		 * 
		 */
	}

	
}
