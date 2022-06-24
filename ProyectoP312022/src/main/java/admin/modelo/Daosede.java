package admin.modelo;
import seguridad.modelo.*;
import admin.controlador.Clssede;
import seguridad.modelo.clsConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class Daosede {

    private static final String SQL_SELECT = "SELECT ID_SEDE, NOMBRE_SEDE, CAPACIDAD FROM sede_polideportivo";
    private static final String SQL_INSERT = "INSERT INTO SEDE_POLIDEPORTIVO(ID_SEDE, NOMBRE_SEDE, CAPACIDAD) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE sede_polideportivo SET ID_SEDE=?, NOMBRE_SEDE=?, CAPACIDAD=? WHERE ID_SEDE=?";
    private static final String SQL_DELETE = "DELETE FROM sede_polideportivo WHERE ID_SEDE=?";
    private static final String SQL_QUERY = "SELECT ID_SEDE, NOMBRE_SEDE, CAPACIDAD FROM sede_polideportivo WHERE ID_CAMPEONATO=?";
    private static final String SQL_QUERYN = "SELECT ID_SEDE, NOMBRE_SEDE, CAPACIDAD FROM sede_polideportivo WHERE ID_SEDE=?";    

    public List<Clssede> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clssede sedes = null;
        List<Clssede> sede = new ArrayList<Clssede>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("ID_SEDE");
                String nombre = rs.getString("NOMBRE_SEDE");
                int capacidad = rs.getInt("CAPACIDAD");
                
                sedes = new Clssede();
                sedes.setIdsede(ide);
                sedes.setNombresede(nombre);
                sedes.setCapacidadsede(capacidad);
                }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return sede;
    }

    public int insert(Clssede sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, sede.getIdsede());
            stmt.setString(1, sede.getNombresede());
            stmt.setInt(1,sede.getCapacidadsede());
            
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

    public int update(Clssede sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, sede.getIdsede());
            stmt.setString(1, sede.getNombresede());
            stmt.setInt(1,sede.getCapacidadsede());
            
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

    public int delete(Clssede sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, sede.getIdsede());
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

    public Clssede query(Clssede sede) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, sede.getIdsede());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("ID_SEDE");
                String nombre = rs.getString("NOMBRE_SEDE");
                int capacidad = rs.getInt("CAPACIDAD");
                
                sede = new Clssede();
                sede.setIdsede(ide);
                sede.setNombresede(nombre);
                sede.setCapacidadsede(capacidad);
                }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return sede;
    }
}
 