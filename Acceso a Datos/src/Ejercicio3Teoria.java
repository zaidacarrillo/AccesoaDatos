import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio3Teoria {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//Obtención de variables.
//		String nombre = JOptionPane.showInputDialog("Introduce tu nombre, porfavor.");
//		String apellidos = JOptionPane.showInputDialog("Introduce tus apellidos, porfavor.");
//		int añodeNacimiento= Integer.parseInt(JOptionPane.showInputDialog("Introduce tu año de nacimiento, porfavor."));
//		int mesdeNacimiento= Integer.parseInt(JOptionPane.showInputDialog("Introduce tu mes de nacimiento, porfavor."));
//		int diadeNacimiento= Integer.parseInt(JOptionPane.showInputDialog("Introduce tu dia de nacimiento, porfavor."));
	 
		String nombre = "Zaida";
		String apellidos = "carrillo";
		int añodeNacimiento= 2001;
		int mesdeNacimiento= 4;
		int diadeNacimiento= 3;
		
		
		LocalDate fecha = LocalDate.of(añodeNacimiento, mesdeNacimiento,diadeNacimiento);
		//Declaración del objeto.
		Persona miPersona = new Persona (nombre, apellidos,fecha);
		
		//Declaro Array List para guardar la lista de personas.
		ArrayList <Persona> personas = new ArrayList<>();
		personas.add(miPersona);
		File fichero = new File("C:\\Users\\PC33\\Documents\\Ejercicio3teoria\\persona.txt");
		PersonaMapping.grabarFichero(personas, fichero );
		ArrayList <Persona> printFichero = PersonaMapping.leerFichero(fichero);
		
		PersonaMapping.mostrarDatos(printFichero);
		
				
				
		
	}

}
