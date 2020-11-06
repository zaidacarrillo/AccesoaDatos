package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseadorLibrosSAX extends DefaultHandler{
	private ArrayList<Libro> listaLibros;
	private Libro libro;
	private Personaje p1;
	private ArrayList<Personaje> personajesPrincipales;
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
		PERSONAJE,
		IMPORTANCIA,
		NOMBRE
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
			case LIBRO:
				libro = new Libro();
				personajesPrincipales = new ArrayList <Personaje>();
				break;
			case PERSONAJE:
				 p1 = new Personaje();
				 break;
			case AUTOR:
				break;
			case EDITORIAL:
				break;
			case FECHADEPUBLICACION:
				break;
			case GENERO:
				break;
			case IMPORTANCIA:
				break;
			case NOMBRE:
				break;
			case LIBROS:
				break;
			case TITULO:
				break;
			default:
				break;
				}
			}
		}
		


	 
	 @Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName!=null) {
			switch(tiposNodos.valueOf(localName.toUpperCase())){
			case TITULO:
				libro.setTituloLibro(valorElemento);
				break;
			case EDITORIAL:
				libro.setEditorial(valorElemento);
				break;
			case AUTOR:
				libro.setAutor(valorElemento);
				break;
			case FECHADEPUBLICACION:
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
				//LocalDate fecha = libro.setFechaNacimiento(new LocalDate f()); 
			//	String fechaPublicacion = fecha.toString();
		//		fechaPublicacion = valorElemento;
				break;
			case GENERO:
				libro.setGenero(valorElemento);
				break;
			case NOMBRE:
				p1.setImportancia(valorElemento);
				break;
			case IMPORTANCIA:
				p1.setNombre(valorElemento);
				break;
			case LIBRO:
				libro.setPersonajesPrincipales(personajesPrincipales);
				listaLibros.add(libro);
				break;
			case LIBROS:
				break;
			case PERSONAJE:
				break;
			default:
				break;
			}
		}
		
	}
	 
	 @Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		valorElemento = new String(ch,start,length);
		
	}
	 
	public ArrayList<Libro> obtenerResultado(){
		return  listaLibros;
	}
}

