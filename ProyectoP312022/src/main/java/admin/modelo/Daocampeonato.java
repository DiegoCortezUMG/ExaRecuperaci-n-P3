package admin.modelo;
import seguridad.modelo.*;
import info.deportes.controlador.Clscampeonato;
import seguridad.modelo.clsConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class Daocampeonato {

    private static final String SQL_SELECT = "SELECT ID_CAMPEONATO, NOMBRE_CAMPEONATO, CANTIDAD_EQUIPOS, ID_SEDE_POLI_FK FROM campeonato";
    private static final String SQL_INSERT = "INSERT INTO campeonato(ID_CAMPEONATO, NOMBRE_CAMPEONATO, CANTIDAD_EQUIPOS, ID_SEDE_POLI_FK) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE campeonato SET ID_CAMPEONATO=?, NOMBRE_CAMPEONATO=?, CANTIDAD_EQUIPOS=?, ID_SEDE_POLI_FK=? WHERE ID_CAMPEONATO=?";
    private static final String SQL_DELETE = "DELETE FROM campeonato WHERE ID_CAMPEONATO=?";
    private static final String SQL_QUERY = "SELECT ID_CAMPEONATO, NOMBRE_CAMPEONATO, CANTIDAD_EQUIPOS, ID_SEDE_POLI_FK FROM campeonato WHERE ID_CAMPEONATO=?";
    private static final String SQL_QUERYN = "SELECT ID_CAMPEONATO, NOMBRE_CAMPEONATO, CANTIDAD_EQUIPOS, ID_SEDE_POLI_FK FROM campeonato WHERE ID_CAMPEONATO=?";    

    public List<Clscampeonato> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clscampeonato campeonatos = null;
        List<Clscampeonato> campeonato = new ArrayList<Clscampeonato>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("ID_CAMPEONATO");
                String nombre = rs.getString("NOMBRE_CAMPEONATO");
                int cantidad = rs.getInt("CANTIDAD_EQUIPOS");
                int id2  = rs.getInt("ID_SEDE_POLI_FK");
                
                campeonatos = new Clscampeonato();
                campeonatos.setIdcampeonato(codigo);
                campeonatos.setNombrecampeonato(nombre);
                campeonatos.setCantidadequipos(cantidad);
                campeonatos.setSedepoli(id2);
                }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return campeonato;
    }

    public int insert(Clscampeonato campeonato) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(0, campeonato.getIdcampeonato());
            stmt.setString(1, campeonato.getNombrecampeonato());
            stmt.setInt(2,campeonato.getCantidadequipos());
            stmt.setInt(3, campeonato.getSedepoli()); 
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(Clscampeonato campeonato) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(0, campeonato.getIdcampeonato());
            stmt.setString(1, campeonato.getNombrecampeonato());
            stmt.setInt(2,campeonato.getCantidadequipos());
            stmt.setInt(3, campeonato.getSedepoli()); 
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(Clscampeonato campeonato) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, campeonato.getIdcampeonato());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public Clscampeonato query(Clscampeonato campeonato) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, campeonato.getIdcampeonato());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("ID_CAMPEONATO");
                String nombre = rs.getString("NOMBRE_CAMPEONATO");
                int cantidad = rs.getInt("CANTIDAD_EQUIPOS");
                int id2  = rs.getInt("ID_SEDE_POLI_FK");
                
                campeonato = new Clscampeonato();
                campeonato.setIdcampeonato(codigo);
                campeonato.setNombrecampeonato(nombre);
                campeonato.setCantidadequipos(cantidad);
                campeonato.setSedepoli(id2);
                }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return campeonato;
    }
}
 