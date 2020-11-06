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
import Negocio.ProcesamientoFicheroXMLSAX;

public class Ejercicio {

	public static void main(String[] args) {
		/**
		 * Clase main, entrada de programa.
		 */
		int añodeNacimiento = 2001;
		int mesdeNacimiento = 4;
		int diadeNacimiento = 3;
		/**
		 * Creación de objeto tipo LocalDate para aplicar fechas a los objetos tipo libro.
		 */
		LocalDate fecha = LocalDate.of(añodeNacimiento, mesdeNacimiento, diadeNacimiento);
		/**
		 * @parameter ArrayList<Personaje> personajesPrincipales contiene la lista de personajes.
		 */
		ArrayList<Personaje> personajesPrincipales = new ArrayList<>();
		personajesPrincipales.add(new Personaje("Mildrelis", "principal"));
		personajesPrincipales.add(new Personaje("Jerry", "secundario"));
		/**
		 * @parameter ArrayList<Libro> libros contiene los elementos de tipo libro con su lista de personajes en él.
		 */
		ArrayList<Libro> libros = new ArrayList<>();
		libros.add(new Libro("El planeta de los Simios", "planeta", "Carlos Martinez", fecha, "drama",
				personajesPrincipales));
		libros.add(new Libro("El principito", "planeta2", "Jesus Fernandez", fecha, "accion", personajesPrincipales));
		ArrayList<Libro> listaLibros = new ArrayList();
		/**
		 * Invocación de cada una de las clases "Procesamiento"
		 * @param lista libros, Array de recojida de datos de lectura
		 * @param libros, Array con datos para el guardado de los mismos.
		 */
		IProcesamientoFichero proc = new ProcesamientoFicheroPlano();
		proc.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\LibroenFicheroPlano.txt");
		listaLibros = proc.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba.txt");

		IProcesamientoFichero proc2 = new ProcesamientoFicheroObjetos();
		proc2.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\LibroenFicheroBinario.txt");
		listaLibros = proc2.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba2.txt");

		IProcesamientoFichero proc3 = new ProcesamientoFicheroXMLDOM();
		proc3.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\LibroenFicheroXMLDOM.txt");
		listaLibros = proc3.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba3.txt");

		IProcesamientoFichero proc4 = new ProcesamientoFicheroXMLJAXB();
		proc4.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\LibroenFicheroXMLJAXB.txt");
		listaLibros = proc4.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba4.txt");

		IProcesamientoFichero proc5 = new ProcesamientoFicheroJSONGSON();
		proc5.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\LibroenFicheroJSONGSON.txt");
		listaLibros = proc5.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba5.txt");
		
		IProcesamientoFichero proc6 = new ProcesamientoFicheroXMLSAX();
		listaLibros = proc6.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba6.txt");
		
		System.out.println("Guardado exitoso.");

	}

}
