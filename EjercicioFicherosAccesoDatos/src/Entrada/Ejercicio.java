package Entrada;
import java.time.LocalDate;
import java.util.ArrayList;

import Modelo.Libro;
import Modelo.Personaje;
import Negocio.IProcesamientoFichero;
import Negocio.ProcesamientoFichero;
import Negocio.ProcesamientoFicheroPlano;

public class Ejercicio {

	public static void main(String[] args) {
		int añodeNacimiento= 2001;
		int mesdeNacimiento= 4;
		int diadeNacimiento= 3;
		LocalDate fecha = LocalDate.of(añodeNacimiento, mesdeNacimiento,diadeNacimiento);
		/*ArrayList <Personaje> personajesPrincipales =  new ArrayList<>();
		Personaje personaje1 = new Personaje("Melody","femenino","PRINCIPAL");
		personajesPrincipales.add(personaje1);
		Libro miLibro = new Libro("Mildrelis","planeta","Anthony",fecha,"femenino");
		
		ArrayList <Libro> Libro1 = new ArrayList<>();
		Libro1.add(miLibro);*/
		
		IProcesamientoFichero proc = new ProcesamientoFicheroPlano();
		ArrayList <Personaje> personajesPrincipales =  new ArrayList<>();
		ArrayList<Libro> libros = new ArrayList <>();
		libros.add(new Libro ("hola","planeta","autor",fecha,"accion", personajesPrincipales));
		libros.add(new Libro ("hola","planeta","autor",fecha,"accion", personajesPrincipales));
		System.out.println("Se guardará un fichero de texto PLANO.");
		proc.guardarFichero(libros, "C:\\Users\\PC33\\Documents\\prueba");
		/*proc.leerFichero();*/
		
		

	}

}
