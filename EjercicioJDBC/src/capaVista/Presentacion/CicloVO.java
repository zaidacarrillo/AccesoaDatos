package capaVista.Presentacion;

public class CicloVO {
	
	private String nombre;
	private String grado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public CicloVO(String nombre, String grado) {
		super();
		this.nombre = nombre;
		this.grado = grado;
	}
	

}
