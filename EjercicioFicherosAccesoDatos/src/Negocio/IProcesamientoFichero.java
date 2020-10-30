package Negocio;
import java.util.ArrayList;
import java.util.List;
import Modelo.Personaje;
import Modelo.Libro;

public interface IProcesamientoFichero {
	
	/**
	 * 
	 * @param ruta ruta de acceso del fichero.
	 * @return guarda un Array de lista libros.
	 */
	public ArrayList<Libro> leerFichero(String ruta);

	public void guardarFichero(List<Libro> listaLibros, String ruta);

		
}

