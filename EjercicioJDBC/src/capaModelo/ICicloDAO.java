package capaModelo;

import java.util.ArrayList;

import capaModelo.Entidades.Asignatura;
import capaModelo.Entidades.Ciclo;

public interface ICicloDAO {
	
	public void insertar(Ciclo ciclo);

	public void insertarMultiple(ArrayList<Ciclo> listaCiclos);

	public void eliminar(Ciclo ciclo);

	public void eliminarMultiple(ArrayList<Ciclo> listaCiclos);

	public void modificar(Ciclo ciclo);

	public void modificarMultiple(ArrayList<Ciclo> listaCiclos);

	public void crearCicloAsignaturas(Ciclo ciclo, ArrayList<Asignatura> listaAsignaturas);

}
