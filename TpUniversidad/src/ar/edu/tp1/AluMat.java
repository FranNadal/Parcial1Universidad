package ar.edu.tp1;

import java.util.ArrayList;
import java.util.Objects;

public class AluMat {
private Alumno alumno;
private Materia materia;
private Integer nota;
private ArrayList<AluMat>notas;
public AluMat(Alumno alumno, Materia materia, Integer nota) {
	super();
	this.alumno = alumno;
	this.materia = materia;
	this.nota = nota;

}
public Alumno getAlumno() {
	return alumno;
}
public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
}
public Materia getMateria() {
	return materia;
}
public void setMateria(Materia materia) {
	this.materia = materia;
}
public Integer getNota() {
	return nota;
}
public void setNota(Integer nota) {
	this.nota = nota;
}
public ArrayList<AluMat> getNotas() {
	return notas;
}
public void setNotas(ArrayList<AluMat> notas) {
	this.notas = notas;
}
@Override
public int hashCode() {
	return Objects.hash(alumno, materia, nota, notas);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AluMat other = (AluMat) obj;
	return Objects.equals(alumno, other.alumno) && Objects.equals(materia, other.materia)
			&& Objects.equals(nota, other.nota) && Objects.equals(notas, other.notas);
}
@Override
public String toString() {
	return "AluMat [alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + ", notas=" + notas + "]";
}

}
