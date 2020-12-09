package capaVista.Presentacion;

public class AsignaturaVO {
	
	private String nombre;
	private int horasSemanales;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHorasSemanales() {
		return horasSemanales;
	}
	public void setHorasSemanales(int horasSemanales) {
		this.horasSemanales = horasSemanales;
	}
	@Override
	public String toString() {
		return "AsignaturaVO [nombre=" + nombre + ", horasSemanales=" + horasSemanales + "]";
	}
	public AsignaturaVO(String nombre, int horasSemanales) {
		super();
		this.nombre = nombre;
		this.horasSemanales = horasSemanales;
	}
	

}
