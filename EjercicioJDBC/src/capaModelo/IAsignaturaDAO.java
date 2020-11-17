package capaModelo;

import java.util.ArrayList;

import capaModelo.Entidades.Asignatura;

public interface IAsignaturaDAO {

	public void insertar(Asignatura asignatura);

	public void insertarMultiple(ArrayList<Asignatura> listaAsignaturas);

	public void eliminar(Asignatura asignatura);

	public void eliminarMultiple(ArrayList<Asignatura> listaAsignaturas);

	public void modificar(Asignatura asignatura);

	public void modificarMultiple(ArrayList<Asignatura> listaAsignaturas);
}
