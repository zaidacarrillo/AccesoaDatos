package capaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import capaModelo.ICicloDAO;
import capaModelo.Entidades.Asignatura;
import capaModelo.Entidades.Ciclo;

public class AsignaturaDAO implements ICicloDAO {

	@Override
	public void insertar(Ciclo ciclo) {
		ConexionMySQL con = new ConexionMySQL();

		Connection c = con.creacionConexion();

		String consulta = "INSERT INTO CICLO" 
						+ "(NOMBRE, GRADO) VALUES" 
						+ "(?, ?);";
		try {
			PreparedStatement ps = c.prepareStatement(consulta);

			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
			ps.addBatch();
			ps.executeBatch();

		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta insertar objeto ciclo.");
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
	public void insertarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();

		String consulta = "INSERT INTO CICLO" 
						+ "(NOMBRE, GRADO) VALUES" 
						+ "(?, ?);";
		try {
			PreparedStatement psMultiple = c.prepareStatement(consulta);
			for (Ciclo ci : listaCiclos) {
				psMultiple.setString(1, ci.getNombre());
				psMultiple.setString(2, ci.getGrado());
				psMultiple.addBatch();
			

			}

			psMultiple.executeBatch();
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta insertar m�ltiples objetos de tipo ciclo.");
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
	public void eliminar(Ciclo ciclo) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();

		String consulta = "DELETE FROM CICLO WHERE ID = ?" ;
		try {
			PreparedStatement psEliminar = c.prepareStatement(consulta);
			psEliminar.setInt(1, ciclo.getId());
			psEliminar.addBatch();
			psEliminar.executeBatch();
			
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta borrar registros de tipo id.");
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
	public void eliminarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();

		String consulta = "DELETE FROM CICLO WHERE ID = ?" ;
		try {
			PreparedStatement pseliminarMultiples = c.prepareStatement(consulta);
			for(Ciclo ci : listaCiclos) {
				pseliminarMultiples.setInt(1, ci.getId());
				pseliminarMultiples.addBatch();
			}
			
			pseliminarMultiples.executeBatch();
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta borrar m�ltiples registros de tipo id.");
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
	public void modificar(Ciclo ciclo) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();
		
		String consulta = "UPDATE CICLO SET nombre = ?, grado = ? WHERE id = ?";
		try {
			PreparedStatement psmodificar = c.prepareStatement(consulta);
			psmodificar.setString(1, ciclo.getNombre());
			psmodificar.setString(2, ciclo.getGrado());
			psmodificar.setInt(3, ciclo.getId());
			psmodificar.addBatch();
			psmodificar.executeBatch();
			
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta modificar un registro de tipo id.");
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
	public void modificarMultiple(ArrayList<Ciclo> listaCiclos) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();
		
		String consulta = "UPDATE CICLO SET nombre = ?, grado = ? WHERE id = ?";
		try {
			PreparedStatement psmodificarMultiple = c.prepareStatement(consulta);
			for(Ciclo ci : listaCiclos) {
				psmodificarMultiple.setString(1, ci.getNombre());
				psmodificarMultiple.setString(2, ci.getGrado());
				psmodificarMultiple.setInt(3, ci.getId());
				psmodificarMultiple.addBatch();
			}
			
			psmodificarMultiple.executeBatch();
		} catch (SQLException e) {
			
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
	public void crearCicloAsignaturas(Ciclo ciclo, ArrayList<Asignatura> listaAsignaturas) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();
		try {
			c.setAutoCommit(false);
			//INSERCI�N OBJETO CICLO EN TABLA CICLO 
			String consulta = "INSERT INTO CICLO (NOMBRE, GRADO) VALUES (?,?);";
			PreparedStatement ps = c.prepareStatement(consulta);
			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
		
			ps.executeUpdate();
			//Obtencion id ciclo
			
			
			//INSERCION ASIGNATURAS
			String consulta2 = "INSERT INTO ASIGNATURAS (ID, NOMBRE, HORAS) VALUES (?,?);";
			PreparedStatement ps2 = c.prepareStatement(consulta);
			
		
			for(Asignatura a : listaAsignaturas) {
				ps2.setInt(1, ciclo.getId());
				ps2.setString(2, a.getNombre());
				ps2.setInt(3, a.getHorasSemanales());
				ps2.addBatch();
			}
			ps2.executeBatch();
			
			c.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
				
		
		
	}

}
