package ar.edu.tp1;

import java.util.Objects;

public class CicloLectivo {
Integer id;
String fInicio;
String ffin;
String fInicioIncs;
String ffinInscr;
public CicloLectivo(Integer id, String fInicio, String ffin, String fInicioIncs, String ffinInscr) {
	super();
	this.id = id;
	this.fInicio = fInicio;
	this.ffin = ffin;
	this.fInicioIncs = fInicioIncs;
	this.ffinInscr = ffinInscr;
}
@Override
public int hashCode() {
	return Objects.hash(id);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CicloLectivo other = (CicloLectivo) obj;
	return Objects.equals(id, other.id);
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getfInicio() {
	return fInicio;
}
public void setfInicio(String fInicio) {
	this.fInicio = fInicio;
}
public String getFfin() {
	return ffin;
}
public void setFfin(String ffin) {
	this.ffin = ffin;
}
public String getfInicioIncs() {
	return fInicioIncs;
}
public void setfInicioIncs(String fInicioIncs) {
	this.fInicioIncs = fInicioIncs;
}
public String getFfinInscr() {
	return ffinInscr;
}
public void setFfinInscr(String ffinInscr) {
	this.ffinInscr = ffinInscr;
}

}
