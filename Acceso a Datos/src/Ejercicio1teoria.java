import java.io.File;
import java.io.IOException;

public class Ejercicio1teoria {

	public static void main(String[] args) {
		File dir = new File("C:\\Users\\PC33\\Desktop\\ejer1teoria\\Directorio1");
		File dir2 = new File("C:\\Users\\PC33\\Desktop\\ejer1teoria\\Directorio2");
		File file1 = new File("C:\\Users\\PC33\\Desktop\\ejer1teoria\\Directorio1\\fichero1.txt");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dir.mkdir();
		dir2.mkdir();
		
		
		file1 = new File("C:\\Users\\PC33\\Desktop\\ejer1teoria\\Directorio1\\fichero2.txt");
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		file1 = new File("C:\\Users\\PC33\\Desktop\\ejer1teoria\\Directorio2\\fichero1.txt");
		
	
	}
	
}
