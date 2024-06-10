package ar.edu.tp1;

import java.util.HashSet;
import java.util.Objects;

public class Comision {
Integer idComision;
Materia materia;
CicloLectivo ciclo;
Turno turno;
HashSet<Alumno>alumnos;
public Comision(Integer idComision, Materia materia, CicloLectivo ciclo, Turno turno) {
	super();
	this.idComision = idComision;
	this.materia = materia;
	this.ciclo = ciclo;
	this.turno = turno;
	this.alumnos= new HashSet<>();
}
public Integer getIdComision() {
	return idComision;
}
public void setIdComision(Integer idComision) {
	this.idComision = idComision;
}
public Materia getMateria() {
	return materia;
}
public void setMateria(Materia materia) {
	this.materia = materia;
}
public CicloLectivo getCiclo() {
	return ciclo;
}
public void setCiclo(CicloLectivo ciclo) {
	this.ciclo = ciclo;
}
public Turno getTurno() {
	return turno;
}
public void setTurno(Turno turno) {
	this.turno = turno;
}
@Override
public int hashCode() {
	return Objects.hash(ciclo, materia, turno);
}

public Boolean agregarAlumno(Alumno alumno) {
	return alumnos.add(alumno);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Comision other = (Comision) obj;
	return Objects.equals(ciclo, other.ciclo) && Objects.equals(materia, other.materia) && turno == other.turno;
}
@Override
public String toString() {
	return "Comision [idComision=" + idComision + ", materia=" + materia + ", ciclo=" + ciclo + ", turno=" + turno
			+ ", alumnos=" + alumnos + "]";
}

}
