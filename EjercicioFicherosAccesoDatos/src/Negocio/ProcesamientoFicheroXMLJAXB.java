package Negocio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Modelo.Libro;
import Modelo.Libros;

public class ProcesamientoFicheroXMLJAXB extends ProcesamientoFichero{

	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
		if (existeFichero(ruta) == true) {
		
		}
		return null;
	}

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
		File file =  new File(ruta);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Libros.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Libros l1 = new Libros();
			l1.setListaLibros(listaLibros);
			jaxbMarshaller.marshal(l1, file);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
