package capaModelo.Entidades;

import java.util.ArrayList;

import capaVista.Presentacion.AsignaturaVO;

public class AsignaturaMapping {
	
	public AsignaturaVO crearAsignatura(Asignatura asignatura) {
		AsignaturaVO asignaturaVO = new AsignaturaVO(asignatura.getNombre(),asignatura.getHoras()); 
		return asignaturaVO;
	}

	
	public ArrayList<AsignaturaVO>listaAsignaturas (ArrayList<Asignatura> listaAsignaturas){
		ArrayList<AsignaturaVO> listaAsignaturasVO = new ArrayList();
		for(Asignatura a: listaAsignaturas) {
			AsignaturaVO asignaturaVO = new AsignaturaVO(a.getNombre(),a.getHoras());
			listaAsignaturasVO.add(asignaturaVO);
		}
		return listaAsignaturasVO;
	}
	
	
	public Asignatura crearAsignatura(AsignaturaVO asignatura) {
		Asignatura asig = new Asignatura(0,asignatura.getNombre(),asignatura.getHorasSemanales(),0); 
		return asig;
	}

	
	public ArrayList<Asignatura>listaAsignaturas2 (ArrayList<AsignaturaVO> listaAsig){
		ArrayList<Asignatura> listaAsignaturas= new ArrayList();
		for(AsignaturaVO a: listaAsig) {
			Asignatura asignatura = new Asignatura(1,a.getNombre(),a.getHorasSemanales(),2);
			listaAsignaturas.add(asignatura);
		}
		return listaAsignaturas;
	}
	

}
