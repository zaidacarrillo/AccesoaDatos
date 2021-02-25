package modelo.entidades;
// Generated 9 feb. 2021 10:03:18 by Hibernate Tools 5.4.21.Final

/**
 * Contactousuario generated by hbm2java
 */
public class Contactousuario implements java.io.Serializable {

	@Override
	public String toString() {
		return "Contactousuario [idUsuario=" + idUsuario + ", email=" + email + ", telefonoMovil=" + telefonoMovil
				+ ", telefonoFijo=" + telefonoFijo + "]";
	}

	private int idUsuario;
	private Usuario usuario;
	private String email;
	private String telefonoMovil;
	private String telefonoFijo;

	public Contactousuario() {
	}

	public Contactousuario(String email, String telefonoMovil, String telefonoFijo) {
		super();
		this.email = email;
		this.telefonoMovil = telefonoMovil;
		this.telefonoFijo = telefonoFijo;
	}

	public Contactousuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Contactousuario(Usuario usuario, String email, String telefonoMovil, String telefonoFijo) {
		this.usuario = usuario;
		this.email = email;
		this.telefonoMovil = telefonoMovil;
		this.telefonoFijo = telefonoFijo;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoMovil() {
		return this.telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

}
