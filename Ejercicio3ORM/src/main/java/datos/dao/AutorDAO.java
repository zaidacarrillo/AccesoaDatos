package datos.dao;

import java.util.ArrayList;

import org.hibernate.Session;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;

public class AutorDAO {
	
	public void insertarAutor(Autor autor) {
		try(Session ses = Conexion.obtenerSesion()){
			ses.saveOrUpdate(autor);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void insertarAutores(ArrayList<Autor> listaAutores) {
		try(Session ses = Conexion.obtenerSesion()){
			for(Autor a: listaAutores) {
				ses.save(a);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
	
	public void modificarAutor(Autor autor) {
		try(Session ses = Conexion.obtenerSesion()){
			ses.saveOrUpdate(autor);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void modificarAutores(ArrayList<Autor> listaAutores) {
		try(Session ses = Conexion.obtenerSesion()){
			for(Autor a: listaAutores) {
				ses.save(a);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void eliminar(Autor autor) {
		try(Session ses = Conexion.obtenerSesion()){
			ses.delete(autor);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void eliminarVarios(ArrayList<Autor> listaAutores) {
		try(Session ses = Conexion.obtenerSesion()){
			
		}catch(Exception ex) {
			
		}
	}
}
