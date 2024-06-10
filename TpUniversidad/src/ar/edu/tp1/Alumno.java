package ar.edu.tp1;

import java.util.Objects;

public class Alumno {
Integer id;
String nombre;
String fechanac;
String fechaIngre;
public Alumno(Integer id, String nombre, String fechanac, String fechaIngre) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.fechanac = fechanac;
	this.fechaIngre = fechaIngre;
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
public String getFechanac() {
	return fechanac;
}
public void setFechanac(String fechanac) {
	this.fechanac = fechanac;
}
public String getFechaIngre() {
	return fechaIngre;
}
public void setFechaIngre(String fechaIngre) {
	this.fechaIngre = fechaIngre;
}
@Override
public int hashCode() {
	return Objects.hash(fechaIngre, fechanac, id, nombre);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Alumno other = (Alumno) obj;
	return Objects.equals(fechaIngre, other.fechaIngre) && Objects.equals(fechanac, other.fechanac)
			&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
}
@Override
public String toString() {
	return "Alumno [id=" + id + ", nombre=" + nombre + ", fechanac=" + fechanac + ", fechaIngre=" + fechaIngre + "]";
}


}
