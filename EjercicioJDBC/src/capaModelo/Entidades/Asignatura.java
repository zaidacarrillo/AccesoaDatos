package capaModelo.Entidades;

public class Asignatura {
	
	private int id;
	private String nombre;
	private int horas;
	

	public Asignatura(int id, String nombre, int horasSemanales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horasSemanales;
	}
	@Override
	public String toString() {
		return "AsignaturaDAO [id=" + id + ", nombre=" + nombre + ", horasSemanales=" + horas + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHorasSemanales() {
		return horas;
	}
	public void setHorasSemanales(int horasSemanales) {
		this.horas = horasSemanales;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
