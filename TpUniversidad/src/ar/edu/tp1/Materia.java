package ar.edu.tp1;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {
private Integer id;
private String nombre;
private ArrayList<Materia>materiasCorrelativas;

public Materia(Integer id, String nombre) {
	
	this.id = id;
	this.nombre = nombre;
	this.materiasCorrelativas=new ArrayList<>();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
@Override
public int hashCode() {
	return Objects.hash(id, nombre);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Materia other = (Materia) obj;
	return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
}
public Boolean agregarMateriaCorrelativa(Materia materiaCorrelativa) {
	return materiasCorrelativas.add(materiaCorrelativa);
}

public Materia buscarCorrelativa(Integer idCorrelativa) {
	for (Materia materia : materiasCorrelativas) {
		if(materia.getId().equals(idCorrelativa)) {
			return materia;
		}
	}
	return null;
}

public Boolean eliminarCorrelativa(Materia materiaCorrelativa) {
	return materiasCorrelativas.remove(materiaCorrelativa);
}
@Override
public String toString() {
	return "Materia [id=" + id + ", nombre=" + nombre + ", materiasCorrelativas=" + materiasCorrelativas + "]";
}

}
