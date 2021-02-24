package datos.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;
import modelo.entidades.Prestamo;

public class PrestamoDAO {
	public void insertarPrestamo(Prestamo prestamo) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			ses.saveOrUpdate(prestamo);
			
			t.commit();
			
			System.out.println("Prestamo insertado correctamente.");
			
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
	public void modificarPrestamo(Prestamo prestamo) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			Prestamo prestamoPersistente = obtenerPorId(prestamo.getIdPrestamo());
			if(prestamoPersistente != null) {
				ses.update(prestamo);
				
				
				t.commit();
				System.out.println("Modificación completada.");
			}else {
				System.out.println("El autor que quieres modificar no existe en base de datos");
			
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			if(t!=null)
				t.rollback();
		}
	}
	
	public void eliminar(Prestamo prestamo) {
		Transaction t = null;
		try(Session ses = Conexion.obtenerSesion()){
			t = ses.beginTransaction();
			//Asegurar que está en estado persistido
			//Si está detached con el merge está persistent
			//Probar con saveOrUpdate para hacer siempre persistente el objeto
			//ses.merge(prestamo);
			
			//Delete
			ses.delete(prestamo);
			
			t.commit();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			if(t!=null)
				t.rollback();
		}
	}
	
	public Prestamo obtenerPorId(int idPrestamo) {
		Prestamo prestamo = null;
		try(Session ses = Conexion.obtenerSesion()){
			
			prestamo = ses.get(Prestamo.class, idPrestamo);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return prestamo;
		
	}

}
