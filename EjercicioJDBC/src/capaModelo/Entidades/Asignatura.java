package capaModelo.Entidades;

public class Asignatura {
	
	private int id;
	private int idCiclo;
	private String nombre;
	private int horas;
	
	
	
	public Asignatura(String nombre, int horasSemanales, int idCiclo) {
		super();
		this.nombre = nombre;
		this.horas = horasSemanales;
		this.idCiclo = idCiclo;
	}

	public Asignatura(int id, String nombre, int horasSemanales, int idCiclo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horasSemanales;
		this.idCiclo = idCiclo;
	}
	public int getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
