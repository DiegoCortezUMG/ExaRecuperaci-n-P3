package seguridad.controlador;

import java.util.logging.Logger;

public class clsUsuario {
    private int usuid;
    private String usunombre;
    private String usucontrasena;
    public clsUsuario() {
    }

    public int getUsuid() {
        return usuid;
    }

    public String getUsunombre() {
        return usunombre;
    }

    public String getUsucontrasena() {
        return usucontrasena;
    }

    public void setUsuid(int usuid) {
        this.usuid = usuid;
    }

    public void setUsunombre(String usunombre) {
        this.usunombre = usunombre;
    }

    public void setUsucontrasena(String usucontrasena) {
        this.usucontrasena = usucontrasena;
    }

    
    @Override
    public String toString() {
        return "usuario{" + "ID_TIPO_USUARIO_FK=" + usuid + ", ID_USUARIO=" + usunombre + ", PASSWORD=" + usucontrasena + '}';
    }



}