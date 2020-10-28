package Negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.JsonAdapter;

import Modelo.Libro;
import Modelo.LibroGSON;

public class ProcesamientoFicheroJSONGSON extends ProcesamientoFichero {

	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
	
		return null;
	}

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
	ArrayList <LibroGSON> listaLibrosGSON = new ArrayList<>();
		for(Libro l: listaLibros) {
			LibroGSON lGSON= (new LibroGSON(l.getTituloLibro(),l.getEditorial(),l.getAutor(),l.getFechaNacimiento(),l.getGenero(),l.getPersonajesPrincipales()));
			listaLibrosGSON.add(lGSON);
			listaLibrosGSON.add(lGSON);
		 
		}
	
		File file =  new File(ruta);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.setPrettyPrinting().registerTypeAdapter(LocalDate.class,new JsonAdapter()).create();
		String json = gson.toJson(listaLibrosGSON);
		
		FileWriter escribir = null;
		try {
			escribir = new FileWriter(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
				escribir.write(json);
			
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


