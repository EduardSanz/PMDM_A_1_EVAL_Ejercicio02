package com.cieep.ejercicio02.modelos;

import java.io.Serializable;

public class ContactoMatricula implements Serializable {
    private String nombreAlumno;
    private String ciclo;
    private String telefono;

    public ContactoMatricula(String nombreAlumno, String ciclo, String telefono) {
        this.nombreAlumno = nombreAlumno;
        this.ciclo = ciclo;
        this.telefono = telefono;
    }

    public ContactoMatricula() {
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ContactoMatricula{" +
                "nombreAlumno='" + nombreAlumno + '\'' +
                ", ciclo='" + ciclo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
