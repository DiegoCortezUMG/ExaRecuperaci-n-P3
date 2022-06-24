/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info.deportes.controlador;

/**
 *
 * @author Usuario
 */
public class Clspartido {
    private int idpartido;
    private int idcampeonato;
    private String fechapartido;
    private int idlocal;
    private int idvisitante;
    private String marcador;
    private int idmejorjugador;
    private int faltas;
    private int estadopartido;

    public int getIdpartido() {
        return idpartido;
    }

    public int getIdcampeonato() {
        return idcampeonato;
    }

    public String getFechapartido() {
        return fechapartido;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public int getIdvisitante() {
        return idvisitante;
    }

    public String getMarcador() {
        return marcador;
    }

    public int getIdmejorjugador() {
        return idmejorjugador;
    }

    public int getFaltas() {
        return faltas;
    }

    public int getEstadopartido() {
        return estadopartido;
    }

    public void setIdpartido(int idpartido) {
        this.idpartido = idpartido;
    }

    public void setIdcampeonato(int idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public void setFechapartido(String fechapartido) {
        this.fechapartido = fechapartido;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public void setIdvisitante(int idvisitante) {
        this.idvisitante = idvisitante;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public void setIdmejorjugador(int idmejorjugador) {
        this.idmejorjugador = idmejorjugador;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void setEstadopartido(int estadopartido) {
        this.estadopartido = estadopartido;
    }

    @Override
    public String toString() {
        return "detalle_partido{" + "ID_PARTIDO=" + idpartido + ", ID_CAMPEONATO=" + idcampeonato + ", FECHA_PARTIDO=" + fechapartido + ", ID_LOCAL=" + idlocal + ", ID_VISITANTE=" + idvisitante + ", MARCADOR=" + marcador + ", ID_MEJOR_JUGADOR_FK=" + idmejorjugador + ", FALTAS=" + faltas + ", ID_ESTADO_PARTIDO_FK=" + estadopartido + '}';
    }
    
    
    
}
