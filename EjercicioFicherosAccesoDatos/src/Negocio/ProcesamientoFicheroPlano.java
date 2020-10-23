package Negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import Modelo.Libro;
import Modelo.Personaje;

public class ProcesamientoFicheroPlano extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
		if (existeFichero(ruta) == true) {
			File fichero = null;
		      FileReader fr = null;
		      BufferedReader br = null;

		      try {
		        
		         fichero = new File (ruta);
		         fr = new FileReader (fichero);
		         br = new BufferedReader(fr);
		         String autor;
		         String editorial;
		        
		         String linea;
		         while((linea=br.readLine())!=null) {
		        	 
		        	 String[] divisionpuntoComaLibros = linea.split(";");
		        	 
		  /*      	 
		        	 String personajes =  divisionpuntoComaLibros [5];
		        	 String[] divisionGuionPersonajes = personajes.split("-");
		        	 String divisionComa = divisionGuionPersonajes.toString();
		        	 String [] divisionComaPersonajes = divisionComa.split(",");
		        	 
		        	 ArrayList datosPersonaje = new ArrayList ();
		        	 datosPersonaje.add (autor = divisionpuntoComaLibros[0]);
		        	 datosPersonaje.add (editorial = divisionpuntoComaLibros[1]);
		        	 datosPersonaje.add ()
		        	 datosPersonaje.add ()
		        	 */
		        	 
		
		        	 
		        	 
		        	 
		         }
		              
		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		   
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		      }
		   }
	
		return null;

	}

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
		File archivo = new File(ruta);
		FileWriter escribir = null;
		String contenidoLibro = "";
		String contenidoPersonajes = "";
		String contenidolistaLibros="";

		try {
			escribir = new FileWriter(archivo);
		} catch (IOException e) {

			e.printStackTrace();
		}
		for (int i = 0; i < listaLibros.size(); i++) {
			Libro l = (listaLibros.get(i));
			 contenidoLibro = l.getTituloLibro() + ";" + l.getEditorial() + ";" + l.getAutor() + ";"
					+l.getFechaNacimiento()  + ";" + l.getGenero() + ";";
			ArrayList<Personaje> listaPersonajes = l.getPersonajesPrincipales();

			contenidoPersonajes="";
			for (int z = 0; z < listaPersonajes.size(); z++) {
				Personaje p = (listaPersonajes.get(z));
				contenidoPersonajes =  contenidoPersonajes + p.getNombre() + "," + p.getImportancia() + "-";
			}
			contenidolistaLibros = contenidolistaLibros+ contenidoLibro + contenidoPersonajes+"\n";
		}
		
		try {
			escribir.write(contenidolistaLibros);
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				escribir.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
