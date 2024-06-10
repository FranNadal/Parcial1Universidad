package ar.edu.tp1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

public class TestUniversidad {

	
	@Test
	public void queSePuedaAgregarUnaMateriaConIdUnicoAUnaUniversidad() {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idMateria=1;
		String nombre="matematica";
		Materia matematica= new Materia(idMateria,nombre);
		Materia matematica2= new Materia(idMateria,nombre);
		Boolean sePudo2=universidad.agregarMateria(matematica2);
		Boolean sePudo=universidad.agregarMateria(matematica);
		
		
		assertTrue(sePudo2);
		assertFalse(sePudo);
	}
	
	
	@Test
	public void queSePuedaAgregarUnAlumnoConIdUnicoAUnaUniversidad() {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idAlumno=1;
		String nombre="Franco Nadal";
		String fechaNac="1/1/2005";
		String fechaIngre="1/1/2005";
		
		Alumno alumno = new Alumno(idAlumno,nombre,fechaNac,fechaIngre);
		Alumno alumno2 = new Alumno(idAlumno,nombre,fechaNac,fechaIngre);
		
		Boolean sePudo=universidad.agregarAlumno(alumno);
		Boolean noSePudo = universidad.agregarAlumno(alumno2);
		
		assertTrue(sePudo);
		assertFalse(noSePudo);
	}
	
	@Test
	
	public void queSePuedaCrearCicloLectivo() {
		Universidad universidad = new Universidad("Unlam");
		Integer idCiclo=1;
		String FInicio="14/10/1990";
		String FInicioInscri="14/10/1990";
		String FFin="14/10/1990";
		String FfinIncri="14/10/1990";
		CicloLectivo ciclo=new CicloLectivo(idCiclo,FInicio,FInicioInscri,FFin,FfinIncri);
		CicloLectivo ciclo2=new CicloLectivo(idCiclo,FInicio,FInicioInscri,FFin,FfinIncri);
		
		Boolean sePudo= universidad.crearCiclo(ciclo);
		Boolean noSePudo=universidad.crearCiclo(ciclo2);
		
		
		assertTrue(sePudo);
		assertFalse(noSePudo);
	}
	
	@Test
	public void queSePuedaBuscarUnaMateriaPorId() {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idMateria=1;
		String nombre="matematica";
		Materia matematica= new Materia(idMateria,nombre);
		Materia matematica2= new Materia(2,nombre);
		universidad.agregarMateria(matematica2);
		universidad.agregarMateria(matematica);
		
		Materia materiaEncontrada=universidad.buscarMateria(idMateria);
		
		assertEquals(matematica, materiaEncontrada);
	}
	@Test
	public void queSePuedaBuscarUnCicloLectivoPorId() {
		Universidad universidad = new Universidad("Unlam");
		Integer idCiclo=1;
		String FInicio="14/10/1990";
		String FInicioInscri="14/10/1990";
		String FFin="14/10/1990";
		String FfinIncri="14/10/1990";
		CicloLectivo ciclo=new CicloLectivo(idCiclo,FInicio,FInicioInscri,FFin,FfinIncri);
		CicloLectivo ciclo2=new CicloLectivo(2,FInicio,FInicioInscri,FFin,FfinIncri);
		
		universidad.crearCiclo(ciclo);
		universidad.crearCiclo(ciclo2);
		
		CicloLectivo cicloEncontrado=universidad.buscarCiclo(idCiclo);
		
		assertEquals(ciclo, cicloEncontrado);
	}
	
	
	@Test
	
	public void queSePuedaCrearUnaComision() {
		Universidad universidad = new Universidad("Unlam");
		Integer idComision=1;
		Turno turno=Turno.mañana;
		
		Integer idMateria=1;
		String nombre="matematica";
		Materia matematica= new Materia(idMateria,nombre);
		universidad.agregarMateria(matematica);
		Materia materiaEncontrada=universidad.buscarMateria(idMateria);
		
		Integer idCiclo=1;
		String FInicio="14/10/1990";
		String FInicioInscri="14/10/1990";
		String FFin="14/10/1990";
		String FfinIncri="14/10/1990";
		CicloLectivo ciclo=new CicloLectivo(idCiclo,FInicio,FInicioInscri,FFin,FfinIncri);
		universidad.crearCiclo(ciclo);
		CicloLectivo cicloEncontrado=universidad.buscarCiclo(idCiclo);
		
		
		Comision comision=new Comision(idComision,materiaEncontrada,cicloEncontrado,turno);
		Comision comision2=new Comision(2,materiaEncontrada,cicloEncontrado,turno);
		
		Boolean sePudo= universidad.agregarComision(comision);
		Boolean noSePudo=universidad.agregarComision(comision2);
		
		assertTrue(sePudo);
		assertFalse(noSePudo);
	}
	
	@Test
	
	public void queSePuedaAsignarUnaMateriaCorrelativaAUnaMateria() {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idMateria=1;
		String nombre="matematica";
		Materia matematica= new Materia(idMateria,nombre);
		Integer idMateriaCorrelativa=2;
		Materia matematica2= new Materia(idMateriaCorrelativa,nombre);
		universidad.agregarMateria(matematica);
		universidad.agregarMateria(matematica2);
		
		Boolean sePudo=universidad.asignarCorrelativa(idMateria,idMateriaCorrelativa);
		
		assertTrue(sePudo);
	}
	
	@Test 
	//aca agarro el throws para que compile pero en este test no ocurre una exception
	public void queSePuedaEliminarUnaMateriaCorrelativaDeUnaMateria() throws Exception {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idMateria=1;
		String nombre="matematica";
		Materia matematica= new Materia(idMateria,nombre);
		Integer idMateriaCorrelativa=2;
		Materia matematica2= new Materia(idMateriaCorrelativa,nombre);
		universidad.agregarMateria(matematica);
		universidad.agregarMateria(matematica2);
		
		universidad.asignarCorrelativa(idMateria,idMateriaCorrelativa);
		
		Boolean sePudo;
		
		sePudo = universidad.eliminarCorrelativa(idMateria,idMateriaCorrelativa);
		assertTrue(sePudo);
		
		
		
	}
	//el test me va a dar verde si ocurre una excepcion , yo la estoy esperando
	@Test (expected = Exception.class)
	
	public void queSeProduzcaUnaExcepcionSiNoExisteLaMateriaCorrelativa() throws Exception {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idMateria=1;
		String nombre="matematica";
		Materia matematica= new Materia(idMateria,nombre);
		Integer idMateriaCorrelativa=2;
		Materia matematica2= new Materia(idMateriaCorrelativa,nombre);
		universidad.agregarMateria(matematica);
		universidad.agregarMateria(matematica2);
		
		universidad.asignarCorrelativa(idMateria,idMateriaCorrelativa);
		
		Boolean sePudo = universidad.eliminarCorrelativa(idMateria,3);
		
		
	}
	//instaoff
	
	
	
	
	@Test 
	
	public void queSePuedaAsignarUnaNotaAAlumMat() {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idAlumno=1;
		String nombre="Franco Nadal";
		String fechaNac="1/1/2005";
		String fechaIngre="1/1/2005";
		Alumno alumno = new Alumno(idAlumno,nombre,fechaNac,fechaIngre);
		universidad.agregarAlumno(alumno);
		
		Integer idMateria=1;
		String nombree="matematica";
		Materia matematica= new Materia(idMateria,nombree);
		universidad.agregarMateria(matematica);
		
		Integer nota=7;
		
		Boolean sePudo=universidad.agregarNota(idAlumno,idMateria,nota);
		
		assertTrue(sePudo);
	}
	
	
	
	
	@Test
	
	public void queSePuedaInscribirUnAlumnoAComision() {
		Universidad universidad = new Universidad("Unlam");
		
		Integer idAlumno=1;
		String nombre="Franco Nadal";
		String fechaNac="1/1/2005";
		String fechaIngre="1/1/2005";
		Alumno alumno = new Alumno(idAlumno,nombre,fechaNac,fechaIngre);
		universidad.agregarAlumno(alumno);
		
		Integer idMateria=1;
		String nombree="matematica";
		Materia matematica= new Materia(idMateria,nombree);
		universidad.agregarMateria(matematica);
		Integer idMateriaCorrelativa=2;
		String nombreee="matematica 2";
		Materia matematica2= new Materia(idMateriaCorrelativa,nombreee);
		universidad.agregarMateria(matematica2);
		
		universidad.asignarCorrelativa(idMateriaCorrelativa,idMateria);
		Integer nota=7;
		//franco tiene un 7 en matematica
		universidad.agregarNota(idAlumno,idMateria,nota);
	
		
		Integer idCiclo=1;
		String FInicio="14/10/1990";
		String FInicioInscri="14/10/1990";
		String FFin="14/10/1990";
		String FfinIncri="14/10/1990";
		CicloLectivo ciclo=new CicloLectivo(idCiclo,FInicio,FInicioInscri,FFin,FfinIncri);
		universidad.crearCiclo(ciclo);
		CicloLectivo cicloEncontrado=universidad.buscarCiclo(idCiclo);
		
		Integer idComision=1;
		Turno turno=Turno.mañana;
		Comision comision=new Comision(idComision,matematica2,cicloEncontrado,turno);
	
		universidad.agregarComision(comision);
		

		AluMat info = new AluMat(alumno, matematica, nota);
		
		Boolean sePudo=universidad.agregarAlumnoAComision(info,idComision);
		
		assertTrue(sePudo);
		
		System.out.println(info);
		System.out.println(comision);
	}
	
	
	
	
	
	//aca estoy agregando la info del alumno (su nota, su materia,alumno) a la universidad 
	@Test
	public void queSePuedaObtenerElListadoDeMateriasParaUnAlumnoOrdenadasPorNota() {
Universidad universidad = new Universidad("Unlam");
		
		Integer idAlumno=1;
		String nombre="Franco Nadal";
		String fechaNac="1/1/2005";
		String fechaIngre="1/1/2005";
		Alumno alumno = new Alumno(idAlumno,nombre,fechaNac,fechaIngre);
		universidad.agregarAlumno(alumno);
		
		Integer idMateria=1;
		String nombree="matematica";
		Materia matematica= new Materia(idMateria,nombree);
		universidad.agregarMateria(matematica);
		Integer idMateriaCorrelativa=2;
		String nombreee="matematica 2";
		Materia matematica2= new Materia(idMateriaCorrelativa,nombreee);
		universidad.agregarMateria(matematica2);
		
		universidad.asignarCorrelativa(idMateriaCorrelativa,idMateria);
		Integer nota=7;
		//franco tiene un 7 en matematica
		AluMat info = new AluMat(alumno, matematica, nota);
		AluMat info2 = new AluMat(alumno, matematica2, 3);
	universidad.AgregarAluMatALaUni(info);
	universidad.AgregarAluMatALaUni(info2);
	
		
		ArrayList<Materia>materiasAprobadasPorUnAlumno= universidad.obtenerMateriasAprobadasPorUnAlumno(idAlumno);
		int cantesperada=1;
		assertEquals(cantesperada, materiasAprobadasPorUnAlumno.size());
		
	}
	
	//de cada alumno decime sus notas
	public void deCadaAlumnoDecimeSusNotas() {
		//como key le voy a pasar el nombre del alumno y dps le voy a pasar un array unicamente de notas
		//mostrar los alumnos
	}
	@Test
	public void test() {
		//de tal vendedor decime sus ventas
		//es para reportes
		
		//treemap ordena
		//   key      value
		Map<String, ArrayList<String>>mapa = new HashMap<>();
				
		ArrayList<String>nombres= new ArrayList<>();
		
		nombres.add("franco");
		nombres.add("franco1");
		nombres.add("franco2");
		
		
		//      vanesatorres  ventas
		mapa.put("nombres", nombres);
		
		ArrayList<String>nombresobtenidos= mapa.get("nombres");
		
		System.out.println(nombresobtenidos);
				
	}
	
	
	@Test
	public void ordenarAlumnosPorCodigo() {
		//ver las fotos
		//treeset no permite duplicados
		//que vengan los alumnos desde un treeset y en la clase alumno decir como quiero que se comparen para que en el treeset ya lo ordene solo
		
		
	}
}
