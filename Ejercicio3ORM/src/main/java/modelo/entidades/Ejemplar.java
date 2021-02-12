package modelo.entidades;
// Generated 9 feb. 2021 10:03:18 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Ejemplar generated by hbm2java
 */
public class Ejemplar implements java.io.Serializable {

	private int idEjemplar;
	private Libro libro;
	private Integer numEjemplar;
	private String estado;
	private Set prestamosForIdUsuario = new HashSet(0);
	private Set prestamosForIdEjemplar = new HashSet(0);

	public Ejemplar() {
	}

	public Ejemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public Ejemplar(int idEjemplar, Libro libro, Integer numEjemplar, String estado, Set prestamosForIdUsuario,
			Set prestamosForIdEjemplar) {
		this.idEjemplar = idEjemplar;
		this.libro = libro;
		this.numEjemplar = numEjemplar;
		this.estado = estado;
		this.prestamosForIdUsuario = prestamosForIdUsuario;
		this.prestamosForIdEjemplar = prestamosForIdEjemplar;
	}

	public int getIdEjemplar() {
		return this.idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Integer getNumEjemplar() {
		return this.numEjemplar;
	}

	public void setNumEjemplar(Integer numEjemplar) {
		this.numEjemplar = numEjemplar;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set getPrestamosForIdUsuario() {
		return this.prestamosForIdUsuario;
	}

	public void setPrestamosForIdUsuario(Set prestamosForIdUsuario) {
		this.prestamosForIdUsuario = prestamosForIdUsuario;
	}

	public Set getPrestamosForIdEjemplar() {
		return this.prestamosForIdEjemplar;
	}

	public void setPrestamosForIdEjemplar(Set prestamosForIdEjemplar) {
		this.prestamosForIdEjemplar = prestamosForIdEjemplar;
	}

}
