package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Contactousuario;
import modelo.entidades.Usuario;

public class ContactoUsuarioDAO {
	public void insertarContactousuario(Contactousuario conUsuario) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			//ses.refresh(conUsuario);
			ses.save(conUsuario);
			
			t.commit();
			
			System.out.println("Contacto usuario insertado, correctamente.");
			
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
	public void modificarContactousuario(Contactousuario conUsuario) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			Contactousuario contacto_usuarioPersistente = obtenerPorId(conUsuario.getIdUsuario());
			if(contacto_usuarioPersistente != null) {
				ses.update(conUsuario);
				
				System.out.println("Modificación completada.");
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
	
	public void eliminar(Contactousuario conUsuario) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			//Asegurar que está en estado persistido
			//Si está detached con el merge está persistent
			//Probar con saveOrUpdate para hacer siempre persistente el objeto
			ses.merge(conUsuario);
			
			//Delete
			ses.delete(conUsuario);
			
			t.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			if(t!=null)
				t.rollback();
		}
	}
	
	public Contactousuario obtenerPorId(int idconUsuario) {
		Contactousuario conusuario = null;
		try(Session ses = Conexion.obtenerSesion()){
			
			conusuario = ses.get(Contactousuario.class, idconUsuario);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return conusuario;
		
	}
}


