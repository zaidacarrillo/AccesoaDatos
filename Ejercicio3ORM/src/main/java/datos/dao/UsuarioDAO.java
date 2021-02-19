package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;
import modelo.entidades.Usuario;

public class UsuarioDAO {
	
	public void insertarAutor(Autor autor) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			ses.saveOrUpdate(autor);
			
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
	public void modificarAutor(Autor autor) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			Autor autorPersistente = obtenerPorId(autor.getIdAutor());
			if(autorPersistente != null) {
				ses.update(autor);
				
				System.out.println("Modificaci�n completada.");
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
			//Asegurar que est� en estado persistido
			//Si est� detached con el merge est� persistent
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
	
	public Autor obtenerPorId(int idAutor) {
		Autor autor = null;
		try(Session ses = Conexion.obtenerSesion()){
			
			autor = ses.get(Autor.class, idAutor);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return autor;
		
	}
}

