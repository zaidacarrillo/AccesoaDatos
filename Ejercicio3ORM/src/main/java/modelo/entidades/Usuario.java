package modelo.entidades;
// Generated 9 feb. 2021 10:03:18 by Hibernate Tools 5.4.21.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

	private int idUsuario;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private Contactousuario contactousuario;
	private Set prestamos = new HashSet(0);
	
	public Usuario() {
	}

	public Usuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario(int idUsuario, String nombre, String apellidos, Date fechaNacimiento,
			Contactousuario contactousuario) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.contactousuario = contactousuario;
	}

	
	public Set getPrestamos() {
		return prestamos;
	}

	public Usuario(String nombre, String apellidos, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setPrestamos(Set prestamos) {
		this.prestamos = prestamos;
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Contactousuario getContactousuario() {
		return this.contactousuario;
	}

	public void setContactousuario(Contactousuario contactousuario) {
		this.contactousuario = contactousuario;
	}

}
