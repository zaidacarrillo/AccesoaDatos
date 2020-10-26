package Entrada;

import java.time.LocalDate;
import java.util.ArrayList;

import Modelo.Libro;
import Modelo.Personaje;
import Negocio.IProcesamientoFichero;
import Negocio.ProcesamientoFichero;
import Negocio.ProcesamientoFicheroObjetos;
import Negocio.ProcesamientoFicheroPlano;

public class Ejercicio {

	public static void main(String[] args) {
		int a�odeNacimiento = 2001;
		int mesdeNacimiento = 4;
		int diadeNacimiento = 3;
		LocalDate fecha = LocalDate.of(a�odeNacimiento, mesdeNacimiento, diadeNacimiento);

		ArrayList<Personaje> personajesPrincipales = new ArrayList<>();
		personajesPrincipales.add(new Personaje("Mildrelis", "principal"));
		personajesPrincipales.add(new Personaje("Jerry", "secundario"));
		ArrayList<Libro> libros = new ArrayList<>();
		libros.add(new Libro("El planeta de los Simios", "planeta", "Carlos Martinez", fecha, "drama",
				personajesPrincipales));
		libros.add(new Libro("El principito", "planeta2", "Jesus Fernandez", fecha, "accion", personajesPrincipales));
		ArrayList<Libro> listaLibros = new ArrayList();

		IProcesamientoFichero proc = new ProcesamientoFicheroPlano();
		System.out.println("Se guardar� un fichero de texto PLANO.");
		proc.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba\\prueba.txt");
		listaLibros = proc.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba.txt");

		IProcesamientoFichero proc2 = new ProcesamientoFicheroObjetos();
		proc2.guardarFichero(listaLibros, "C:\\Users\\PC33\\Documents\\prueba\\prueba2.txt");
		listaLibros = proc2.leerFichero("C:\\Users\\PC33\\Documents\\prueba\\prueba2.txt");

	}

}