package capaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import capaModelo.IAsignaturaDAO;
import capaModelo.ICicloDAO;
import capaModelo.Entidades.Asignatura;
import capaModelo.Entidades.Ciclo;

public class AsignaturaDAO implements IAsignaturaDAO {

	@Override
	public void insertar(Asignatura asignatura) {
		ConexionMySQL con = new ConexionMySQL();

		Connection c = con.creacionConexion();

		String consulta = "INSERT INTO ASIGNATURA" + "(NOMBRE, HORAS, IDCICLO) VALUES" + "(?, ?, ?);";

		try {
			PreparedStatement ps = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getHoras());
			ps.setInt(3, asignatura.getIdCiclo());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id= rs.getInt(1);
			asignatura.setId(id);
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta insertar objeto asignatura.");
			e.printStackTrace();
		} finally {
			try {
				if (c != null && !c.isClosed()) {
					con.cerrarConexion(c);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar la conexi�n.");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void insertarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL con = new ConexionMySQL();

		Connection c = con.creacionConexion();

		String consulta = "INSERT INTO ASIGNATURA" + "(NOMBRE, HORAS, IDCICLO) VALUES" + "(?, ?, ?);";
		try {
			PreparedStatement psMultiple = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			for (Asignatura a : listaAsignaturas) {

				psMultiple.setString(1, a.getNombre());
				psMultiple.setInt(2, a.getHoras());
				psMultiple.setInt(3, a.getIdCiclo());
				psMultiple.addBatch();
			}
			psMultiple.executeBatch();
			
			ResultSet rs = psMultiple.getGeneratedKeys();
			for(Asignatura a: listaAsignaturas) {
				rs.next();
				a.setId(rs.getInt(1));
			}
			psMultiple.close();
		} catch (SQLException e1) {
			System.out.println("Error en la ejecuci�n de la consulta insertar m�ltiples objetos de tipo asignatura.");
			e1.printStackTrace();
		} finally {
			try {
				if (c != null && !c.isClosed()) {
					con.cerrarConexion(c);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar la conexi�n.");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void eliminar(Asignatura asignatura) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();

		String consulta = "DELETE FROM ASIGNATURA WHERE ID = ?" ;
		try {
			PreparedStatement psEliminar = c.prepareStatement(consulta);
			psEliminar.setInt(1, asignatura.getId());
			psEliminar.execute();
			psEliminar.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta borrar registros de tipo id.(ASIGNATURAS)");
			e.printStackTrace();
		}

	}

	@Override
	public void eliminarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();

		String consulta = "DELETE FROM ASIGNATURA WHERE ID = ?";
		try {
			PreparedStatement pseliminarMultiples = c.prepareStatement(consulta);
			for(Asignatura a : listaAsignaturas) {
				pseliminarMultiples.setInt(1, a.getId());
				pseliminarMultiples.addBatch();
			}
			pseliminarMultiples.executeBatch();
			pseliminarMultiples.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta borrar m�ltiples registros de tipo id.(ASIGNATURAS)");
			e.printStackTrace();
		}

	}

	@Override
	public void modificar(Asignatura asignatura) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();
		
		String consulta = "UPDATE ASIGNATURA SET nombre = ?, horas = ? WHERE id = ?";
		
		try {
			PreparedStatement psmodificar = c.prepareStatement(consulta);
			psmodificar.setString(1, asignatura.getNombre());
			psmodificar.setInt(2, asignatura.getHoras());
			psmodificar.setInt(3, asignatura.getId());
			psmodificar.execute();
			psmodificar.close();
		} catch (SQLException e) {
		System.out.println("");
			e.printStackTrace();
		}

	}

	@Override
	public void modificarMultiple(ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();
		
		String consulta = "UPDATE ASIGNATURA SET nombre = ?, horas = ? WHERE id = ?";
		try {
			PreparedStatement psmodificarMultiple = c.prepareStatement(consulta);
			for(Asignatura a : listaAsignaturas) {
				psmodificarMultiple.setString(1, a.getNombre());
				psmodificarMultiple.setInt(2, a.getHoras());
				psmodificarMultiple.setInt(3, a.getId());
				psmodificarMultiple.addBatch();
			}
			
			psmodificarMultiple.executeBatch();
			psmodificarMultiple.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
