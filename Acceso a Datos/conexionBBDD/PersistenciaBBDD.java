import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class PersistenciaBBDD {
	
	public void CargarDriver() throws ClassNotFoundException {
		Class.forName("org.mariadb.jdbc.Driver");
	}//Cargar Driver


	public Connection obtenerConexion() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/prueba";
		String usuario= "root";
		String pass = "";
		
		Connection c = DriverManager.getConnection(url, usuario, pass);
		return c;
		
		}
	
	}
