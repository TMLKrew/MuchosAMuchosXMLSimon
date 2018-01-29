/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Simon
 */
public class Escritor implements Serializable{
    
    private Long idEscritor;
    private String nombre;
    private Set<Libro> libros;

    public Escritor() {
    }

    public Escritor(Long idEscritor, String nombre, Set<Libro> libros) {
        this.idEscritor = idEscritor;
        this.nombre = nombre;
        this.libros = libros;
    }
    
    

    public Long getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Long idEscritor) {
        this.idEscritor = idEscritor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
       
}
