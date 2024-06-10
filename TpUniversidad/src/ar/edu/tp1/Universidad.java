package ar.edu.tp1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

public class Universidad  implements IUniversidad{
private String nombre;
public HashSet<Materia>materias;
private HashSet<Alumno>alumnos;
private HashSet<CicloLectivo>ciclos;
private HashSet<Comision>comisiones;
public HashSet<AluMat>notas;
public HashSet<AluMat>info;

public Universidad(String nombre) {

	this.nombre = nombre;
	this.materias= new HashSet<>();
	this.alumnos= new HashSet<>();
	this.ciclos= new HashSet<>();
	this.comisiones= new HashSet<>();
	this.notas= new HashSet<>();
	this.info= new HashSet<>();
}



public Boolean agregarMateria(Materia materia) {
	return materias.add(materia);

}


@Override
public Boolean agregarAlumno(Alumno alumno) {
	// TODO Auto-generated method stub
	return alumnos.add(alumno);
}


@Override
public Boolean crearCiclo(CicloLectivo ciclo) {
	
	return ciclos.add(ciclo);
}


public Materia buscarMateria(Integer idMateria) {
	for (Materia materia : materias) {
		if(materia.getId().equals(idMateria)) {
			return materia;
		}
	}
	return null;
}


public CicloLectivo buscarCiclo(Integer idCiclo) {
	for (CicloLectivo ciclo : ciclos) {
		if(ciclo.getId().equals(idCiclo)) {
			return ciclo;
		}
	}
	return null;
}


public Boolean agregarComision(Comision comision) {
	
	return comisiones.add(comision);
}


public Boolean asignarCorrelativa(Integer idMateria, Integer idMateriaCorrelativa) {
	// TODO Auto-generated method stub
	Materia Principal= buscarMateria(idMateria);
	Materia Correlativa=buscarMateria(idMateriaCorrelativa);
	

		if(materias.contains(Principal)&&materias.contains(Correlativa)) {
			
		Principal.agregarMateriaCorrelativa(Correlativa);
		
		return true;
		
	}
	return null;
}


public Boolean eliminarCorrelativa(Integer idMateria, Integer idMateriaCorrelativa) throws Exception {
	Materia Principal= buscarMateria(idMateria);
	Materia Correlativa=buscarMateria(idMateriaCorrelativa);
	if(Principal.buscarCorrelativa(idMateriaCorrelativa).equals(Correlativa)){
		Principal.eliminarCorrelativa(Correlativa);
		return true;
	}
	throw new Exception("no eciste esa correlativa");
}

public Alumno buscarAlumno(Integer idAlumno) {
	for (Alumno alumno : alumnos) {
		if(alumno.getId().equals(idAlumno)) {
			return alumno;
		}
	}
	return null;
}

public Comision buscarComision(Integer idComision) {
	for (Comision comision : comisiones) {
		if(comision.getIdComision().equals(idComision)) {
			return comision;
		}
	}
	return null;
}

public Boolean agregarAlumnoAComision(Integer idAlumno, Integer idComision) {
	Alumno alumnoAagregar=buscarAlumno(idAlumno);
	Comision comision=buscarComision(idComision);
	
	if(alumnoAagregar!=null&&comision!=null) {
		return comision.agregarAlumno(alumnoAagregar);
	}
	return null;
}



public Boolean agregarNota(Integer idAlumno, Integer idMateria, Integer nota) {
	Alumno alumno=buscarAlumno(idAlumno);
	Materia materia=buscarMateria(idMateria);
	
	if(alumno!=null&&materia!=null) {
		AluMat info= new AluMat(alumno, materia, nota);
		return notas.add(info);
	}
	return null;
}



public Boolean agregarAlumnoAComision(AluMat info,Integer idComision) {
	Comision comision = buscarComision(idComision);
	if(notas.contains(info)&&info.getNota()>=4) {
		return comision.agregarAlumno(info.getAlumno());
	}
	return null;
}



public ArrayList<Materia> obtenerMateriasAprobadasPorUnAlumno(Integer idAlumno) {
	ArrayList<Materia>materiasaprobadas = new ArrayList<>();
	for (AluMat alumno : info) {
		if(alumno.getAlumno().getId().equals(idAlumno)&&alumno.getNota()>= 4) {
			materiasaprobadas.add(alumno.getMateria());
		}
	}
	return materiasaprobadas;
}

public Boolean AgregarAluMatALaUni(AluMat infoo) {
	
	return info.add(infoo);
	
}
}
