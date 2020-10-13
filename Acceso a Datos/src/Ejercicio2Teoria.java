import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Ejercicio2Teoria  extends Ejercicio2TeoriaDiseñador {

	public static void main(String rutaOrigen, String rutaDestino, JComboBox devuelveCodificacion){
		String opcionJCombo = devuelveCodificacion.getSelectedItem().toString();
		File archivo = null;
		FileInputStream fis = null;
		BufferedReader br = null;
		//rutaOrigen = "C:\\Users\\PC33\\Documents\\Ejercicio2Teoria\\PrimerFichero.txt";
		String datosPrimerFichero;
		//Compruebo que existe la carpeta creada por previamente
		File fichero1 = new File(rutaOrigen);
		String nombre = fichero1.getName();
		if (fichero1.exists()) {
			JOptionPane.showMessageDialog(null, "Comprobando que" + nombre + "existe...");
			 JOptionPane.showMessageDialog(null, "El fichero " + nombre + " existe"," Comprobacion realizada",JOptionPane.WARNING_MESSAGE);
			//System.out.println("el fichero" + fichero1.getName() + "existe");

		} else {
			JOptionPane.showMessageDialog(null, "Error " + nombre +" No existe"+"\n cerrando el programa, gracias...");
			//System.out.println("Error\n" + fichero1.getName() + "\nNo existe");
			System.exit(0);
		}

		//Creacion de un nuevo fichero
		
		File fichero2 = new File(rutaDestino);
		try {
			if (fichero2.exists()) {
				JOptionPane.showMessageDialog(null, "No ha podido ser creado el fichero");
				System.exit(0);
				//System.out.println("No ha podido ser creado el fichero");
			} else {
				fichero2.createNewFile();
				JOptionPane.showMessageDialog(null, "El fichero se ha creado correctamente");
				//System.out.println("El fichero se ha creado correctamente");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	    OutputStreamWriter osw = cambiarCodificacion(opcionJCombo, fichero2);
	    

		try {
			
			archivo = new File("C:\\Users\\PC33\\Documents\\Ejercicio2Teoria\\PrimerFichero.txt");
			//lectura del archivo
			fis = new FileInputStream(archivo);
			InputStreamReader isr= new InputStreamReader(fis,StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			
			//escritura del archivo
			//FileWriter textodeCopia = null;
			//textodeCopia = new FileWriter(fichero2);
			
			//Introduce en una varible que comienza en 0 datos "datosPrimerFichero", lo leído por bufferedReader y guardado en "br" 
			//bucle: mientras br sea igual a el archivo y no sea null
			while ((datosPrimerFichero = br.readLine()) != null) {
				//System.out.println("Datos:"+datosPrimerFichero);
				osw.write(datosPrimerFichero+"\n");
			}
			osw.close();
			//textodeCopia.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fis) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} 
		}
	}
	
	public static OutputStreamWriter cambiarCodificacion(String opcionJCombo, File fichero2) {
		OutputStreamWriter osw = null;
		if((opcionJCombo != null && opcionJCombo == "ASCII")) {
			FileOutputStream fos = null;
			
			try {
				fos =new FileOutputStream(fichero2.getPath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				 osw =new OutputStreamWriter(fos,StandardCharsets.US_ASCII);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return osw;
		
	}


}
	
