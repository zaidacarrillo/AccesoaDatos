package Modelo;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseadorLibrosSAX extends DefaultHandler{
	private ArrayList<Libro> listaLibros;
	private Libro libro;
	private Libro personajesPrincipales;
	private Libro titulo;
	private String valorElemento;
	
	enum tiposNodos{
		LIBROS,
		LIBRO,
		TITULO,
		EDITORIAL,
		AUTOR,
		FECHADEPUBLICACION,
		GENERO,
		PERSONAJESPRINCIPALES
	}
	
	 public ParseadorLibrosSAX() {
		 super();
	 }
	 
	 @Override
	public void startDocument() throws SAXException {
		  
		listaLibros = new ArrayList <Libro>();
	
	 }
	 
	 @Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(localName!= null) {
			switch(tiposNodos.valueOf(localName.toUpperCase())) {
			case LIBROS:
				listaLibros.add(libro);
				break;
			
			/* case PERSONAJESPRINCIPALES:
			 
				listaLibros.add(personajesPrincipales);
			*/
			}
		}
		
	}
	 
	 @Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName!=null) {
			switch(tiposNodos.valueOf(localName.toUpperCase())){
			case TITULO:
				/*titulo=valorElemento;*/
			case EDITORIAL:
				
			}
		}
		
	}
	 
	 @Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		super.characters(ch, start, length);
	}
	 
	public ArrayList<Libro> obtenerResultado(){
		return  listaLibros;
	}
}

