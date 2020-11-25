package capaVista;

import java.util.ArrayList;

import capaDatos.AsignaturaDAO;
import capaDatos.CicloDAO;
import capaModelo.Entidades.Asignatura;
import capaModelo.Entidades.Ciclo;

public class Programa {

	public static void main(String[] args) {
					/*
					 * //Asignatura no VO
			AsignaturaVO asig = new AsignaturaVO();
			AsignaturaVO asig2 = new AsignaturaVO();
			AsignaturaVO asig3 = new AsignaturaVO();
			
			//Usar asignatura no VO
			ArrayList <AsignaturaVO> listaAsignaturas = new AsignaturaVO ();
			listaAsignaturas.add(asig);
			listaAsignaturas.add(asig2);
			listaAsignaturas.add(asig3);
			IAsignatura ias = new AsignaturaDAO();
					 */
		
		/*
		  Ciclo c = new Ciclo("DAM","SUP");	
		  cicloDAO.insertar(c);
		  c.setGrado("Superior");
		  cicloDAO.modificar(c);
		  
		  Asignatura a = new Asignatura("INTERFACES",180,c.getId());
		*/ 
		
		//INSERCIÓN.
		Ciclo cicloPrueba1 = new Ciclo("DAM","SUPERIOR");//
		Ciclo cicloPrueba2 = new Ciclo("INFORMATICA","BASICO");
		Ciclo cicloPrueba3 = new Ciclo("PRUEBA","MEDIO");
		
		CicloDAO cicDAO = new CicloDAO();
		//cicDAO.insertar(cicloPrueba1);*/
		
		Asignatura asignPrueba1 = new Asignatura("PROGRAMACIÓN",180, cicloPrueba1.getId());
		Asignatura asignPrueba2 = new Asignatura("ACCESO A DATOS",300,cicloPrueba2.getId());
		AsignaturaDAO asigDAO = new AsignaturaDAO();
		//asigDAO.insertar(asignPrueba1);
		
		//INSERCIÓN MÚLTIPLE.
		ArrayList<Ciclo> listaCiclos = new ArrayList();
		listaCiclos.add(new Ciclo("ASIR","SUPERIOR"));
		listaCiclos.add(new Ciclo("DAW","SUPERIOR"));
		listaCiclos.add(new Ciclo("SMR","MEDIO"));
		//cicDAO.insertarMultiple(listaCiclos);
		
		ArrayList<Asignatura> listaAsignaturas = new ArrayList();
		listaAsignaturas.add(new Asignatura("PROGRAMACIÓN",200,listaCiclos.get(0).getId()));
		listaAsignaturas.add(new Asignatura("PSP",200,listaCiclos.get(1).getId()));
		listaAsignaturas.add(new Asignatura("INTERFACES",200,listaCiclos.get(2).getId()));
		//asigDAO.insertarMultiple(listaAsignaturas);  
		
		//DELETE.
		asignPrueba1.setId(5);
		asigDAO.eliminar(asignPrueba1);
		cicDAO.eliminar(cicloPrueba1);
		
		//DELETE MÚLTIPLE.
		listaAsignaturas.get(0).setId(6);
		listaAsignaturas.get(1).setId(7);
		listaAsignaturas.get(2).setId(8);
		asigDAO.eliminarMultiple(listaAsignaturas);
		
		//MODIFICAR.
		asignPrueba2.setId(9);
		asigDAO.modificar(asignPrueba2);
		
		//MODIFICAR MÚLTIPLE.
		ArrayList<Asignatura> listaAsignaturas2 = new ArrayList();
		listaAsignaturas2.add(new Asignatura(9,"BASES DE DATOS",130, 14));
		listaAsignaturas2.add(new Asignatura(10,"LENGUAJES DE MARCAS",150, 18));
		asigDAO.modificarMultiple(listaAsignaturas2);
		
		ArrayList<Ciclo>listaCiclos2 = new ArrayList();
		listaCiclos2.add(new Ciclo(1,"NOMBRE FP","MEDIO"));
		listaCiclos2.add(new Ciclo(2,"ASIR","SUPERIOR"));
		cicDAO.modificarMultiple(listaCiclos2);
		
		//CREAR CICLO ASIGNATURAS.
	//	ArrayList<Asignatura>listaAsignaturas3
		cicDAO.crearCicloAsignaturas(cicloPrueba3, listaAsignaturas);
		
		
		
		
		
		
	
		
		
		
		
		
		 

	}

	
}
