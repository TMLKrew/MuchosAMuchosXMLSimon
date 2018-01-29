/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.Set;

/**
 *
 * @author Simon
 */
public class Libro {
    
    private Long idLibro;
    private String titulo;
    private Set<Escritor> escritores;

    public Libro() {
    }

    public Libro(Long idLibro, String titulo, Set<Escritor> escritores) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.escritores = escritores;
    }
    
    

    public Set<Escritor> getEscritores() {
        return escritores;
    }

    public void setEscritores(Set<Escritor> escritores) {
        this.escritores = escritores;
    }
    
    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
