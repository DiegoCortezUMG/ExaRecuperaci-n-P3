/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin.controlador;

/**
 *
 * @author Usuario
 */
public class Clssede {
    private int idsede;
    private String nombresede;
    private int capacidadsede;

    public int getIdsede() {
        return idsede;
    }

    public String getNombresede() {
        return nombresede;
    }

    public int getCapacidadsede() {
        return capacidadsede;
    }

    public void setIdsede(int idsede) {
        this.idsede = idsede;
    }

    public void setNombresede(String nombresede) {
        this.nombresede = nombresede;
    }

    public void setCapacidadsede(int capacidadsede) {
        this.capacidadsede = capacidadsede;
    }

    @Override
    public String toString() {
        return "sede_polideportivo{" + "ID_SEDE=" + idsede + ", NOMBRE_SEDE=" + nombresede + ", CAPACIDAD=" + capacidadsede + '}';
    }
}
