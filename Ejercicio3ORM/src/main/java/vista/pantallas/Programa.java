package vista.pantallas;

import datos.dao.AutorDAO;
import datos.dao.LibroDAO;
import modelo.entidades.Autor;
import modelo.entidades.Libro;

public class Programa {

	public static void main(String[] args) {
		
		//Parte 7.1
			LibroDAO ldao = new LibroDAO();
			Libro l1 = new Libro("1b123fgh","Titulo_libro","Editorial", (float) 20);
			ldao.insertarLibro(l1);
			
			AutorDAO audao = new AutorDAO();
			Autor au = new  Autor(1,"Zaida","Carrillo");
			audao.insertarAutor(au);
			
	}

}
