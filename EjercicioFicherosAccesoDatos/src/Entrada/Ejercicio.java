package Entrada;

import java.time.LocalDate;
import java.util.ArrayList;

import Modelo.Libro;
import Modelo.LibroGSON;
import Modelo.Personaje;
import Negocio.IProcesamientoFichero;
import Negocio.ProcesamientoFichero;
import Negocio.ProcesamientoFicheroJSONGSON;
import Negocio.ProcesamientoFicheroObjetos;
import Negocio.ProcesamientoFicheroPlano;
import Negocio.ProcesamientoFicheroXMLDOM;
import Negocio.ProcesamientoFicheroXMLJAXB;

public class Ejercicio {

	public static void main(String[] args) {
		int añodeNacimiento = 2001;
		int mesdeNacimiento = 4;
		int diadeNacimiento = 3;
		LocalDate fecha = LocalDate.of(añodeNacimiento, mesdeNacimiento, diadeNacimiento);

		ArrayList<Personaje> personajesPrincipales = new ArrayList<>();
		personajesPrincipales.add(new Personaje("Mildrelis", "principal"));
		personajesPrincipales.add(new Personaje("Jerry", "secundario"));
		ArrayList<Libro> libros = new ArrayList<>();
		
		libros.add(new Libro("El planeta de los Simios", "planeta", "Carlos Martinez", fecha, "drama",
				personajesPrincipales));
		libros.add(new Libro("El principito", "planeta2", "Jesus Fernandez", fecha, "accion", personajesPrincipales));
		ArrayList<Libro> listaLibros = new ArrayList();
		
		IProcesamientoFichero proc = new ProcesamientoFicheroPlano();
		System.out.println("Se guardará un fichero de texto PLANO.");
		proc.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\prueba.txt");
		listaLibros = proc.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba.txt");

		IProcesamientoFichero proc2 = new ProcesamientoFicheroObjetos();
		proc2.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\prueba2.txt");
		listaLibros = proc2.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba2.txt");

		IProcesamientoFichero proc3 = new ProcesamientoFicheroXMLDOM();
		proc3.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\prueba3.txt");
		listaLibros = proc3.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba3.txt");

		IProcesamientoFichero proc4 = new ProcesamientoFicheroXMLJAXB();
		proc4.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\prueba4.txt");
		listaLibros = proc4.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba4.txt");
		
		IProcesamientoFichero proc5 = new ProcesamientoFicheroJSONGSON();
		proc5.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\prueba5.txt");
		listaLibros = proc5.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba5.txt");

		
		  //for(Libro p: listaLibros) { 
		//	  System.out.println(p.toString());
		  
		 // }
		 

	}

}
