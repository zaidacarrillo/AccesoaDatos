package vista.pantallas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;

import datos.dao.AutorDAO;
import datos.dao.ContactoUsuarioDAO;
import datos.dao.EjemplarDAO;
import datos.dao.LibroDAO;
import datos.dao.PrestamoDAO;
import datos.dao.UsuarioDAO;
import modelo.entidades.Autor;
import modelo.entidades.Contactousuario;
import modelo.entidades.Ejemplar;
import modelo.entidades.Libro;
import modelo.entidades.Prestamo;
import modelo.entidades.Usuario;

public class Programa {

	public static void main(String[] args) {
	/*
		//Relacion N:M
			//insertar libro
			LibroDAO ldao = new LibroDAO();
			Libro l1 = new Libro("1b123fgh","Titulo_libro","Editorial", (float) 20);
			ldao.insertarLibro(l1);
			//insertar autor
			AutorDAO audao = new AutorDAO();
			Autor au = new  Autor(1,"Zaida","Carrillo");
			audao.insertarAutor(au);
			
			//como inverse es igual a false en autor, autor domina la relación. Agrega una lista de libros.
			au.getLibros().add(l1);
			//se modifica autores para implementar ese libro de la lista.
			audao.modificarAutor(au);
			
	*/
	/*
		//Relacion 1:1 sin  existencia
			//insertar ejemplar de libro
			Libro l1 = new Libro("1FGJS23N","Los Pilares de la tierra", "Planeta", (float) 20);
			EjemplarDAO edao = new EjemplarDAO();
			Ejemplar ejemplar = new Ejemplar(1, 2, "ACTIVO");
			ejemplar.setLibro(l1);
			edao.insertarEjemplar(ejemplar);
			//intento de borrado de libro (da pete)
			LibroDAO ldao2 = new LibroDAO();
			ldao2.eliminar(l1);
	*/
	/*
		//Relacion 1:1 con existencia
			//insertar usuario 
			Date fechaNacimiento = new Date(03/04/2001);
			ContactoUsuarioDAO conuserdao = new ContactoUsuarioDAO();
			UsuarioDAO userdao = new UsuarioDAO();
			Contactousuario conuser = new Contactousuario("zaidacarrillovarela@gmail.com", "652148755","981536244");
			Usuario user = new Usuario("Zaida","Carrillo", fechaNacimiento);
			//userdao.insertarUsuario(user);
			conuser.setUsuario(user);
			conuserdao.insertarContactousuario(conuser);
			//delete usuario (usuario es cascade = all) ya que hay una relación de existencia
			//Usé refresh para que deletee el usuario con el conctado dado que accede a la base de datos directamente para pillar el usuario con contacto.
			userdao.eliminar(user);
	 */
	/*
		//Relacion N:M convertida en dos 1:N
			//crear usuario
			Date fechaNacimiento = new Date(16/9/2009);
			Usuario user2 = new Usuario("Inaya","Carrillo", fechaNacimiento);
			//crear contacto usuario
			Contactousuario conuser2 = new Contactousuario("iniwolf4@gmail.com", "652148755","981536244");
			UsuarioDAO userdao2 = new UsuarioDAO();
			//insertar usuario
			userdao2.insertarUsuario(user2);
			ContactoUsuarioDAO conuserdao2 = new ContactoUsuarioDAO();
			//insertar contactousuario
			conuser2.setUsuario(user2);
			conuserdao2.insertarContactousuario(conuser2);
			//creo libro
			Date fechaPrestamo = new Date(20/5/2019);
			Date fechaDevolucion = new Date(10/2/2020);
			Libro l = new Libro("1SJKBCKS","Infiltrada", "Garceta", (float) 30);
			LibroDAO ldao = new LibroDAO();
			ldao.insertarLibro(l);
			//para incluir a ejemplar
			Ejemplar ejemplar = new Ejemplar(2,l,3,"RETIRADO");
			//ejemplar.setLibro(l);
			EjemplarDAO ejemdao = new EjemplarDAO();
			ejemdao.insertarEjemplar(ejemplar);
			//creo prestamo
			Prestamo p = new Prestamo(user2, ejemplar, fechaPrestamo,null);
			PrestamoDAO prestamodao = new PrestamoDAO();
			//inserto prestamo
			prestamodao.insertarPrestamo(p);
			//obtener prestamos
			user2=userdao2.obtenerPorId(user2.getIdUsuario());
			user2.getPrestamos();
			Date fechaHoy = new java.sql.Date(new java.util.Date().getTime());
			Set <Prestamo> listaprestamos_usuario =  user2.getPrestamos();
			for(Prestamo u : listaprestamos_usuario)
			{
			if(u.getFechaDevolucion()== null) {
				u.setFechaDevolucion(fechaHoy);
				prestamodao.modificarPrestamo(u);
			}else {
				System.out.println("La fecha devolución ya estaba actualizada.");
			}
			
			
		}
	*/
		UsuarioDAO pruebasQuery1 = new UsuarioDAO();
		LibroDAO pruebasQuery2 = new LibroDAO();
		
	//	pruebasQuery1.ObtenerporDNI();
		
	//	pruebasQuery1.ObtenerUsuariosconLibrosPrestados();
		
		pruebasQuery1.ObtenerUsuariosMenoresdeEdad();
				
		
			
	}

}
