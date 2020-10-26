package Negocio;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Modelo.Libro;

public class ProcesamientoFicheroObjetos extends ProcesamientoFichero{

	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
		File fichero = new File(ruta);
		ObjectInputStream ois = null;
		ArrayList<Libro> listaLibro = new ArrayList<>();
		try {
			ois = new ObjectInputStream(new FileInputStream(fichero));

			// Mientras haya objetos
			while (true) {

				Libro l1 = (Libro) ois.readObject();
				listaLibro.add(l1);
			}
		} catch (ClassCastException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (EOFException exc) {
		
			System.out.println("Ha llegado al final del fichero.");
		} catch (IOException e) {
	
			e.printStackTrace();
		}

		try {
			ois.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return listaLibro;

	}
	

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
		File fichero = new File(ruta);
		try {

			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));

			for (Libro l : listaLibros) {
				ficheroSalida.writeObject(l);
			}
			ficheroSalida.flush();

			ficheroSalida.close();
			// JOptionPane.showMessageDialog(null, "Array guardado en el fichero
			// personas.txt correctamente.");

		} catch (FileNotFoundException fnfe) {

			System.out.println("Error: El fichero no existe. ");

		} catch (IOException ioe) {

			System.out.println("Error: Fallo en la escritura en el fichero. ");

		}

		
	}

}
