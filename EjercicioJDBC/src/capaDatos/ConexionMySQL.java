package capaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL implements IConexion {

	@Override
	public Connection creacionConexion() {
		CargarDriver();
		String url = "jdbc:mysql://127.0.0.1:3306/ejercicioJDBC";
		String usuario= "root";
		String pass = "";
		
		Connection c= null;
		try {
			c = DriverManager.getConnection(url, usuario, pass);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return c;

	}

	@Override
	public void cerrarConexion(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	private void CargarDriver() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

	}

}
