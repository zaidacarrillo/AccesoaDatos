import java.io.File;

public class Ejercicio1teorianuevaversion {

	public static void main(String[] args) {
		
		String ruta="C:\\Users\\PC33\\Desktop\\ejer1teoria";
		crearDirectorio(ruta,"Directiorio1");
		crearDirectorio(ruta,"Directorio2");
		crearDirectorio(ruta,"Directorio3");
		
		
		
		crearFichero(ruta, "fichero.txt");

	}
	
	private static void crearFichero(String rutaPadre, String nombre) {
		File file1 = new File(rutaPadre, nombre);
		if(!file1.exists()) {
			System.out.println("No se ha podido crear el fichero"+nombre);
		}else {
			System.out.println("el fichero"+nombre+"ya existe");
		}
		
	}

	private static void crearDirectorio(String rutaPadre, String nombre) {
		File file1 = new File(rutaPadre, nombre);
		if(!file1.exists()) {
			file1.mkdir();
		}else {
			System.out.println("El directorio"+nombre+"ya existe");
		}
	}

}
