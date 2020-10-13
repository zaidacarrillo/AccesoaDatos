import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PersonaMapping {

	private static final long serialVersionUID = 1L;

	public static void grabarFichero(ArrayList<Persona> personas, File fichero) {

		try {

			ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));

			for (Persona p : personas) {
				ficheroSalida.writeObject(p);
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

	public static ArrayList<Persona> leerFichero(File fichero) {
		ObjectInputStream ois = null;
		ArrayList<Persona> listaPers = new ArrayList<>();
		try {
			ois = new ObjectInputStream(new FileInputStream(fichero));

			// Mientras haya objetos
			while (true) {

				Persona miPersona = (Persona) ois.readObject();
				listaPers.add(miPersona);
			}
		} catch (ClassCastException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException exc) {
			// TODO Auto-generated catch block
			System.out.println("Ha llegado al final del fichero.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaPers;

	}

	public static void mostrarDatos(ArrayList<Persona> printFichero) {
		for (int i = 0; i < printFichero.size(); i++) {
			System.out.println(printFichero.get(i).toString());

		}
	}

}
