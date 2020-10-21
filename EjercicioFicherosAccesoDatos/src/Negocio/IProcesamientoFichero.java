package Negocio;
import java.util.ArrayList;
import java.util.List;
import Modelo.Personaje;
import Modelo.Libro;

public interface IProcesamientoFichero {
	
	public ArrayList<Libro> leerFichero(String ruta);

	public void guardarFichero(List<Libro> listaLibros, String ruta);

		
}

