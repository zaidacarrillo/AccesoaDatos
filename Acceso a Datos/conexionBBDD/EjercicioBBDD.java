import java.sql.SQLException;

public class EjercicioBBDD {

	public static void main(String[] args) {
		PersistenciaBBDD pers = new PersistenciaBBDD();
		try {
			pers.obtenerConexion();
			pers.CargarDriver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
