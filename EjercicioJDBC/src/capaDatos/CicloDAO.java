package capaDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import capaModelo.ICicloDAO;
import capaModelo.Entidades.Asignatura;
import capaModelo.Entidades.Ciclo;

public class CicloDAO implements ICicloDAO{

	@Override
	public void insertar(Ciclo ciclo) {
		ConexionMySQL con = new ConexionMySQL();

		Connection c = con.creacionConexion();
		
		String consulta = "INSERT INTO CICLO" 
						+ "(NOMBRE, GRADO) VALUES" 
						+ "(?, ?);";
		try {
			c.setAutoCommit(false);
			PreparedStatement ps = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id= rs.getInt(1);
			ciclo.setId(id);
			c.commit();
			ps.close();
			c.close();
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
			PreparedStatement psMultiple = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			for (Ciclo ci : listaCiclos) {
				psMultiple.setString(1, ci.getNombre());
				psMultiple.setString(2, ci.getGrado());
				psMultiple.addBatch();
				
			}

			psMultiple.executeBatch();
			
			int cont=0;
			ResultSet rs = psMultiple.getGeneratedKeys();
			while(rs.next()) {
				listaCiclos.get(cont).setId(rs.getInt(1));
				 cont++;
			}
			
			//Otra forma de hacerlo:
			/*
			 * for(Ciclo c : listaCiclos){
			 * 		rs.next
			 * 		a.setId(rs.getInt(1));
			 * }
			 */
			psMultiple.close();
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
			psEliminar.execute();
			
	 	  /*ResultSet rs = psEliminar.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			ciclo.setId(id);*/
			psEliminar.close();
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta borrar registros de tipo id(CICLO).");
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
			
			//ResultSet rs = pseliminarMultiples.getGeneratedKeys();
			/*for(Ciclo ci : listaCiclos) {
				rs.next();
				ci.setId(rs.getInt(1));
			}*/
			
			pseliminarMultiples.close();
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta borrar m�ltiples registros de tipo id (CICLO).");
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
			psmodificar.execute();
			psmodificar.close();
			
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
			
		 /*ResultSet rs = psmodificarMultiple.getGeneratedKeys();
			for(Ciclo ci : listaCiclos) {
				rs.next();
				ci.setId(rs.getInt(1));
			}*/
			psmodificarMultiple.close();
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n (Eliminaci�n m�ltiple)");
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
			String consulta = "INSERT INTO CICLO (NOMBRE, GRADO) VALUES (?, ?);";
			PreparedStatement ps = c.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, ciclo.getNombre());
			ps.setString(2, ciclo.getGrado());
		
			ps.executeUpdate();
			//Obtencion id ciclo
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			ciclo.setId(id);
			ps.close();
			//INSERCION ASIGNATURAS
			String consulta2 = "INSERT INTO ASIGNATURA (ID, NOMBRE, HORAS, IDCICLO) VALUES (?,?,?,?);";
			PreparedStatement ps2 = c.prepareStatement(consulta2);
		
			for(Asignatura a : listaAsignaturas) {
				ps2.setInt(1, a.getId());
				ps2.setString(2, a.getNombre());
				ps2.setInt(3, a.getHoras());
				ps2.setInt(4, ciclo.getId());
				ps2.addBatch();
			}
			ps2.executeBatch();
			
			ResultSet rs2 = ps.getGeneratedKeys();
			for(Asignatura a: listaAsignaturas) {
				rs2.next();
				a.setId(rs.getInt(1));
			}
			
			c.commit();
			ps2.close();
		} catch (SQLException e) {
			System.out.println("Error en la ejecuci�n de la consulta crearCicloAsignaturas.");
			try {
				c.rollback();
			} catch (SQLException e1) {
			System.out.println("No ha sido posible realizar un rollback.");
				e1.printStackTrace();
			}
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
	
	public void deleteCiclo(Ciclo ciclo) {
		ConexionMySQL con = new ConexionMySQL();
		Connection c = con.creacionConexion();
		try {
			CallableStatement st = c.prepareCall("{ call deleteCiclo(?) }");
			st.setString(1, ciclo.getNombre());
			st.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
