package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Contactousuario;
import modelo.entidades.Ejemplar;

public class EjemplarDAO {
	
	public void insertarEjemplar(Ejemplar ejemplar) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			ses.saveOrUpdate(ejemplar);
			
			t.commit();
			System.out.println("Ejemplar insertado, correctamente.");
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
	public void modificarEjemplar(Ejemplar ejemplar) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			
			 Ejemplar ejemplarPersistente = obtenerPorId(ejemplar.getIdEjemplar());
			if(ejemplarPersistente != null) {
				ses.update(ejemplar);
				
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
	
	public void eliminar(Ejemplar ejemplar) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			//Asegurar que está en estado persistido
			//Si está detached con el merge está persistent
			//Probar con saveOrUpdate para hacer siempre persistente el objeto
			ses.merge(ejemplar);
			
			//Delete
			ses.delete(ejemplar);
			
			t.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			if(t!=null)
				t.rollback();
		}
	}
	
	public Ejemplar obtenerPorId(int idEjemplar) {
		Ejemplar ejemplar = null;
		try(Session ses = Conexion.obtenerSesion()){
			
			ejemplar = ses.get(Ejemplar.class, idEjemplar);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return ejemplar;
		
	}
}


