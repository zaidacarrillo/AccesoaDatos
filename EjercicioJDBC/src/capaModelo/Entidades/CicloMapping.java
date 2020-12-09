package capaModelo.Entidades;

import java.util.ArrayList;
import capaVista.Presentacion.CicloVO;

public class CicloMapping {

	public CicloVO crearCiclo(Ciclo ciclo) {
		CicloVO cicloVO = new CicloVO(ciclo.getNombre(),ciclo.getGrado()); 
		return cicloVO;
	}

	
	public ArrayList<CicloVO>listaCiclos (ArrayList<Ciclo> listaCiclos){
		ArrayList<CicloVO> listaCiclosVO = new ArrayList();
		for(Ciclo ci: listaCiclos) {
			CicloVO CicloVO = new CicloVO(ci.getNombre(),ci.getGrado());
			listaCiclosVO.add(CicloVO);
		}
		return listaCiclosVO;
	}
	
	
	public Ciclo crearCiclo(CicloVO ciclo) {
		Ciclo ciclo2 = new Ciclo(0,ciclo.getNombre(),ciclo.getGrado()); 
		return ciclo2;
	}

	
	public ArrayList<Ciclo>listaCiclo2 (ArrayList<CicloVO> listaCiclos){
		ArrayList<Ciclo> listaCiclos2= new ArrayList();
		for(CicloVO a: listaCiclos) {
			Ciclo ciclo = new Ciclo(1,a.getNombre(),a.getGrado());
			listaCiclos2.add(ciclo);
		}
		return listaCiclos2;
	}

}
