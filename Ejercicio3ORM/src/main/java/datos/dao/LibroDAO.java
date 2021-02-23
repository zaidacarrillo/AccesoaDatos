package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;
import modelo.entidades.Libro;

public class LibroDAO {
	public void insertarLibro(Libro libro) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			ses.saveOrUpdate(libro);
			
			t.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}if(t!=null)
			t.rollback();
	}
	
	/**
	 * 
	 * @param autor ha de ser un objeto persistente.
	 */
	public void modificarLibro(Libro libro) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			Libro libroPersistente = obtenerPorId(libro.getCodLibro());
			if(libroPersistente != null) {
				ses.update(libro);
				
				System.out.println("Modificación completada.");
				t.commit();
			}else {
				System.out.println("El autor que quieres modificar no existe en base de datos");
			
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}if(t!=null)
			t.rollback();
	}
	
	public void eliminar(Autor autor) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			//Asegurar que está en estado persistido
			//Si está detached con el merge está persistent
			//Probar con saveOrUpdate para hacer siempre persistente el objeto
			ses.merge(autor);
			
			//Delete
			ses.delete(autor);
			
			t.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}if(t!=null)
			t.rollback();
	}
	
	public Libro obtenerPorId(String codLibro) {
		Libro libro = null;
		try(Session ses = Conexion.obtenerSesion()){
			
			libro = ses.get(Libro.class, codLibro);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return libro;
		
	}

}
