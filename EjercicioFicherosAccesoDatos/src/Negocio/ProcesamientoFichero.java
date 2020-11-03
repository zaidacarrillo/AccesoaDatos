package Negocio;

import java.io.File;

public abstract class ProcesamientoFichero implements IProcesamientoFichero{
	/**
	 * 
	 * @param ruta contiene la ruta de acceso del fichero.
	 * @return resultado.
	 */
	public boolean existeFichero(String ruta) {
		File fichero = new File(ruta);
		boolean resultado = false;
		if(fichero.exists()) {
			resultado = true;
		}else {
			resultado = false;
		}
		return resultado;
	}
	
	public boolean borrarFichero(String ruta) {
		File fichero = new File(ruta);
		boolean resultado =false;
		if(fichero.exists()) {
			resultado = true;
		}else {
			resultado = false;
		}
		
		
		return resultado;
		
	}
}
