package Negocio;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Modelo.Libro;
import Modelo.Personaje;

public class ProcesamientoFicheroXMLDOM extends ProcesamientoFichero {
/**
 * Lectura de fichero mediante el sistema XMLDOM.
 */
	@Override
	public ArrayList<Libro> leerFichero(String ruta) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		if (existeFichero(ruta) == true) {
			DocumentBuilder builder = null;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {
				builder = factory.newDocumentBuilder();
				Document document = builder.parse(new File(ruta));
				//Nodopadre libros que se iguala a document que obtiene el elemento libro
				NodeList nodeList = document.getDocumentElement().getChildNodes();

				//se recorre nodo padre
				for (int i = 0; i < nodeList.getLength(); i++) {
					//creo nodo libro (hijo de libros)
					//Un nodo que se actualiza en depende que posicion de la lista nodeList
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						//el nodo libro lo casteo a tipo elemento para poder usar metodos de tipo element
						//elemento padre de los hijos que se obtienen a continuacion
						Element eLLibro = (Element) node;

						String titulo = eLLibro.getElementsByTagName("Titulo").item(0).getChildNodes().item(0)
								.getNodeValue();
						String editorial = eLLibro.getElementsByTagName("Editorial").item(0).getChildNodes().item(0)
								.getNodeValue();
						String autor = eLLibro.getElementsByTagName("Autor").item(0).getChildNodes().item(0)
								.getNodeValue();
						String fechaPublicacion = eLLibro.getElementsByTagName("FechaDePublicacion").item(0)
								.getChildNodes().item(0).getNodeValue();
						String genero = eLLibro.getElementsByTagName("Genero").item(0).getChildNodes().item(0)
								.getNodeValue();
						
						Element personajes = (Element) eLLibro.getElementsByTagName("PersonajesPrincipales").item(0);
						//Nodopadre Personajes principales que se iguala a el elemento personajes creado en la linea anterior
						NodeList nodeListPersonajes = personajes.getChildNodes();
						ArrayList personaje = new ArrayList();
						for (int z = 0; z < nodeListPersonajes.getLength(); z++) {
							Node nodePersonaje = nodeListPersonajes.item(z);
							Personaje p = null;

							if (nodePersonaje.getNodeType() == Node.ELEMENT_NODE) {
								Element Personaje = (Element) nodePersonaje;

								String nombre = Personaje.getElementsByTagName("Nombre").item(0).getChildNodes().item(0)
										.getNodeValue();
								String importancia = Personaje.getElementsByTagName("Importancia").item(0)
										.getChildNodes().item(0).getNodeValue();
								//se crea un objeto de tipo personaje para guardar nombre y importancia
								p = new Personaje(nombre, importancia);
								//se agrega al arraylist personaje
								personaje.add(p);
							}

						}
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
						LocalDate localDate = LocalDate.parse(fechaPublicacion, formatter);
						Libro l1 = new Libro(titulo, editorial, autor, localDate, genero, personaje);
						libros.add(l1);
						return libros;
					}

				}

			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
/**
 * Guardado de fichero mediante el sistema XMLDOM, necesaria la declaración de elementos y nodos.
 */
	@Override
	public void guardarFichero(List<Libro> listaLibros, String ruta) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		String fecha;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			Element rootElement = doc.createElementNS(null, "Libros");
			doc.appendChild(rootElement);

			for (Libro l : listaLibros) {
				Element libro = doc.createElement("libro");

				Element node = doc.createElement("Titulo");
				node.appendChild(doc.createTextNode(l.getTituloLibro()));
				libro.appendChild(node);

				node = doc.createElement("Editorial");
				node.appendChild(doc.createTextNode(l.getEditorial()));
				libro.appendChild(node);

				node = doc.createElement("Autor");
				node.appendChild(doc.createTextNode(l.getAutor()));
				libro.appendChild(node);

				node = doc.createElement("FechaDePublicacion");
				node.appendChild(doc.createTextNode(l.getFechaNacimiento().toString()));
				libro.appendChild(node);

				node = doc.createElement("Genero");
				node.appendChild(doc.createTextNode(l.getGenero()));
				libro.appendChild(node);

				Element listaPers = doc.createElement("PersonajesPrincipales");

				for (Personaje p : l.getPersonajesPrincipales()) {

					Element personaje = doc.createElement("Personaje");
					listaPers.appendChild(personaje);

					node = doc.createElement("Nombre");
					node.appendChild(doc.createTextNode(p.getNombre()));
					personaje.appendChild(node);

					node = doc.createElement("Importancia");
					node.appendChild(doc.createTextNode(p.getImportancia()));
					personaje.appendChild(node);

					libro.appendChild(listaPers);
				}
				rootElement.appendChild(libro);
			} // for libros

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			StreamResult file = new StreamResult(new File(ruta));
			transformer.transform(source, file);

		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}

	}

}
