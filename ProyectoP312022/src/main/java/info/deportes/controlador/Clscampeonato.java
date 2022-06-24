/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info.deportes.controlador;

/**
 *
 * @author Usuario
 */
public class Clscampeonato {
    private int idcampeonato;
    private String nombrecampeonato;
    private int cantidadequipos;
    private int sedepoli;
 public Clscampeonato() {
    }    

    public int getIdcampeonato() {
        return idcampeonato;
    }

    public String getNombrecampeonato() {
        return nombrecampeonato;
    }

    public int getCantidadequipos() {
        return cantidadequipos;
    }

    public int getSedepoli() {
        return sedepoli;
    }

    public void setIdcampeonato(int idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public void setNombrecampeonato(String nombrecampeonato) {
        this.nombrecampeonato = nombrecampeonato;
    }

    public void setCantidadequipos(int cantidadequipos) {
        this.cantidadequipos = cantidadequipos;
    }

    public void setSedepoli(int sedepoli) {
        this.sedepoli = sedepoli;
    }

    @Override
    public String toString() {
        return "campeonato{" + "ID_CAMPEONATO=" + idcampeonato + ", NOMBRE_CAMPEONATO=" + nombrecampeonato + ", CANTIDAD_EQUIPOS=" + cantidadequipos + ", ID_SEDE_POLI_FK=" + sedepoli + '}';
    }
    
    
}

