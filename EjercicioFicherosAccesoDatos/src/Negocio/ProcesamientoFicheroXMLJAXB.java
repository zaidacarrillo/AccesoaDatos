package Negocio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Modelo.Libro;
import Modelo.Libros;

public class ProcesamientoFicheroXMLJAXB extends ProcesamientoFichero {
/**
 * Lectura de fichero mediante XMLJAXB
 */
	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
		List<Libro> libros = new ArrayList();

		if (existeFichero(ruta) == true) {

			if (existeFichero(ruta) == true) {
				File file = new File(ruta);
				if (file.exists()) {
					try {
						JAXBContext jaxbContext = JAXBContext.newInstance(Libros.class);
						Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

						Libros listaLibros = (Libros) jaxbUnmarshaller.unmarshal(file);
						libros = (listaLibros != null ? listaLibros.getListaLibros() : new ArrayList<Libro>());

					} catch (JAXBException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("El fichero no existe.");
				}

			}
		}
		return (ArrayList<Libro>) libros;
	}

	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
		File file = new File(ruta);

		if (!file.exists()) {
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
