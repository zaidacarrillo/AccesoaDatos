package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;
import modelo.entidades.Usuario;

public class UsuarioDAO {
	
	public void insertarUsuario(Usuario usuario) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			//ses.refresh(usuario);
			ses.saveOrUpdate(usuario);
			
			t.commit();
			System.out.println("Usuario insertado correctamente.");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			if(t!=null)
				t.rollback();
		}
	}
	
	/**
	 * 
	 * @param autor ha de ser un objeto persistente.
	 */
	public void modificarUsuario(Usuario usuario) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			Usuario usuarioPersistente = obtenerPorId(usuario.getIdUsuario());
			if(usuarioPersistente != null) {
				
				ses.update(usuario);
				
				System.out.println("Modificaci�n completada.");
				t.commit();
			}else {
				System.out.println("El autor que quieres modificar no existe en base de datos");
			
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			if(t!=null)
				t.rollback();
		}
	}
	
	public void eliminar(Usuario usuario) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			//Asegurar que est� en estado persistido
			//Si est� detached con el merge est� persistent
			//Probar con saveOrUpdate para hacer siempre persistente el objeto
//			if(!ses.contains(usuario))
//				ses.merge(usuario);
			
			//Delete
			ses.refresh(usuario);
			ses.delete(usuario);
			
			t.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			if(t!=null)
				t.rollback();
		}
	}
	
	public Usuario obtenerPorId(int idUsuario) {
		Usuario usuario = null;
		try(Session ses = Conexion.obtenerSesion()){
			
			usuario = ses.get(Usuario.class, idUsuario);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return usuario;
		
	}
}

