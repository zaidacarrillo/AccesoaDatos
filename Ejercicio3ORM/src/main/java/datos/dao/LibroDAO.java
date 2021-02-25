package datos.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.configuracion.Conexion;
import modelo.entidades.Autor;
import modelo.entidades.Libro;
import modelo.entidades.Prestamo;

public class LibroDAO {
	public void insertarLibro(Libro libro) {
		Transaction t = null;
		try (Session ses = Conexion.obtenerSesion()) {
			t = ses.beginTransaction();
			ses.saveOrUpdate(libro);

			t.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			if (t != null)
				t.rollback();
		}
	}

	/**
	 * 
	 * @param autor ha de ser un objeto persistente.
	 */
	public void modificarLibro(Libro libro) {
		Transaction t = null;
		try (Session ses = Conexion.obtenerSesion()) {
			t = ses.beginTransaction();
			Libro libroPersistente = obtenerPorId(libro.getCodLibro());
			if (libroPersistente != null) {
				ses.update(libro);

				System.out.println("Modificación completada.");
				t.commit();
			} else {
				System.out.println("El autor que quieres modificar no existe en base de datos");

			}

		} catch (Exception ex) {
			ex.printStackTrace();

			if (t != null)
				t.rollback();
		}
	}

	public void eliminar(Libro libro) {
		Transaction t = null;
		try (Session ses = Conexion.obtenerSesion()) {
			t = ses.beginTransaction();
			// Asegurar que está en estado persistido
			// Si está detached con el merge está persistent
			// Probar con saveOrUpdate para hacer siempre persistente el objeto
			ses.merge(libro);

			// Delete
			ses.delete(libro);

			t.commit();

		} catch (Exception ex) {
			ex.printStackTrace();

			if (t != null)
				t.rollback();
		}
	}

	public Libro obtenerPorId(String codLibro) {
		Libro libro = null;
		try (Session ses = Conexion.obtenerSesion()) {

			libro = ses.get(Libro.class, codLibro);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return libro;

	}
	
	
	public void ObtenerLibrosPrestamos() {
		Scanner sc = new Scanner(System.in);
		try (Session sesion = Conexion.obtenerSesion()) {
		System.out.println("Escribe dos fechas: \nFecha 1: \n");
		String userfecha1 = sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date fecha1 = sdf.parse(userfecha1);
			System.out.println("Fecha 2: \n");
			String userfecha2 = sc.nextLine();
			Date fecha2 = sdf.parse(userfecha2);
			//if(0<fecha1.compareTo(fecha2)){
				
			//} 
			Query<Prestamo> q = sesion.createQuery("FROM Prestamo WHERE FechaPrestamo between :fecha1 and :fecha2");
			q.setDate("fecha1", fecha1);
			q.setDate("fecha2", fecha2);
			List<Prestamo> listaPrestamos = q.getResultList();
			for (Prestamo p : listaPrestamos) {
				Libro l = p.getEjemplar().getLibro();
				System.out.println(l + "\n");
			}
			sc.close();
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
/*
	@SuppressWarnings("unchecked")
	public void librosPrestados() {
		try (Session sesion = Conexion.obtenerSesion()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Indica dos fechas: \nFecha 1: \n");
			String Sfecha1 = sc.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = sdf.parse(Sfecha1);
			System.out.println("Fecha 2: \n");
			String Sfecha2 = sc.nextLine();
			Date fecha2 = sdf.parse(Sfecha2);

			if (fecha.after(fecha2)) {
				Date aux = fecha2;
				fecha2 = fecha;
				fecha = aux;
			}

			Query<Prestamo> q = sesion.createQuery("FROM Prestamo p WHERE p.FechaPrestamo between :fecha and :fecha2");
			q.setDate("fecha", fecha);
			q.setDate("fecha2", fecha2);
			List<Prestamo> listaPrestamos = (List<Prestamo>) q.getResultList();

			for (Prestamo p : listaPrestamos) {
				Libro l = p.getEjemplar().getLibro();
				System.out.println(l + "\n");
			}
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public void autorLibro() {
		try (Session sesion = Conexion.obtenerSesion()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Indica el nombre del autor");
			String nombre = sc.nextLine();

			Query<Autor> q = sesion.createQuery("FROM Autor WHERE nombre like :nombreAutor");
			q.setParameter("nombreAutor", nombre);
			List<Autor> listaAutores = (List<Autor>) q.getResultList();

			for (Autor a : listaAutores) {
				Set<Libro> listaLibros = a.getLibros();
				for (Libro l : listaLibros) {
					System.out.println(l + "\n");
				}
			}
			sc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public void precioLibro() {
		try (Session sesion = Conexion.obtenerSesion()) {
			Query<Libro> q = sesion.createQuery("FROM Libro WHERE precio is null OR precio<20");
			List<Libro> listaLibros = (List<Libro>) q.getResultList();

			for (Libro l : listaLibros) {
				System.out.println(l + "\n");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
		
	}
	
}
