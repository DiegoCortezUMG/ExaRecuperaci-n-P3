package admin.modelo;
import seguridad.modelo.*;
import info.deportes.controlador.Clspartido;
import seguridad.modelo.clsConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class Daopartido {

    private static final String SQL_SELECT = "SELECT ID_PARTIDO, ID_CAMPEONATO_FK, FECHA_PARTIDO,ID_LOCAL, ID_VISITANTE, MARCADOR, ID_MEJOR_JUGADOR_FK, FALTAS, ID_ESTADO_PARTIDO_FK FROM detalle_partido";
    private static final String SQL_INSERT = "INSERT INTO detalLe_partido(ID_PARTIDO, ID_CAMPEONATO_FK, FECHA_PARTIDO,ID_LOCAL, ID_VISITANTE, MARCADOR, ID_MEJOR_JUGADOR_FK, FALTAS, ID_ESTADO_PARTIDO_FK) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE detalle_parrtido SET ID_PARTIDO=?, ID_CAMPEONATO_FK=?, FECHA_PARTIDO=?,ID_LOCAL=?, ID_VISITANTE=?, MARCADOR=?, ID_MEJOR_JUGADOR_FK=?, FALTAS=?, ID_ESTADO_PARTIDO_FK=? WHERE ID_PARTIDO=?";
    private static final String SQL_DELETE = "DELETE FROM detale_partido WHERE ID_PARTIDO=?";
    private static final String SQL_QUERY = "SELECT ID_PARTIDO, ID_CAMPEONATO_FK, FECHA_PARTIDO,ID_LOCAL, ID_VISITANTE, MARCADOR, ID_MEJOR_JUGADOR_FK, FALTAS, ID_ESTADO_PARTIDO_FK FROM detalle_partido WHERE ID_PARTIDO=?";
    private static final String SQL_QUERYN = "SELECT ID_PARTIDO, ID_CAMPEONATO_FK, FECHA_PARTIDO,ID_LOCAL, ID_VISITANTE, MARCADOR, ID_MEJOR_JUGADOR_FK, FALTAS, ID_ESTADO_PARTIDO_FK FROM detalle_partido WHERE ID_PARTIDO=?";    

    public List<Clspartido> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clspartido partidos = null;
        List<Clspartido> partido = new ArrayList<Clspartido>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_PARTIDO");
                int id2 = rs.getInt("ID_CAMPEONATO_FK");
                String fecha = rs.getString("FECHA_PARTIDO");
                int idL  = rs.getInt("ID_LOCAL");
                int idV  = rs.getInt("ID_VISITANTE");
                String marcador = rs.getString("MARCADOR");                    
                int idM = rs.getInt("ID_MEJOR_JUGADOR_FK");
                int faltas = rs.getInt("FALTAS");
                int idE = rs.getInt("ID_ESTADO_PARTIDO");
                
                partidos = new Clspartido();
                partidos.setIdpartido(id);
                partidos.setIdcampeonato(id2);
                partidos.setFechapartido(fecha);
                partidos.setIdlocal(idL);
                partidos.setIdvisitante(idV);
                partidos.setMarcador(marcador);
                partidos.setFaltas(faltas);
                partidos.setIdmejorjugador(idM);
                partidos.setFaltas(faltas);
                partidos.setEstadopartido(idE);
                }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return partido;
    }

    public int insert(Clspartido partido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(0, partido.getIdpartido());
            stmt.setInt(1, partido.getIdcampeonato());
            stmt.setString(2, partido.getFechapartido());
            stmt.setInt(3,partido.getIdlocal());
            stmt.setInt(4,partido.getIdvisitante());
            stmt.setString(5,partido.getMarcador());
            stmt.setInt(6,partido.getIdmejorjugador());
            stmt.setInt(7,partido.getFaltas());
            stmt.setInt(8,partido.getEstadopartido());
            
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

    public int update(Clspartido partido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt.setInt(0, partido.getIdpartido());
            stmt.setInt(1, partido.getIdcampeonato());
            stmt.setString(2, partido.getFechapartido());
            stmt.setInt(3,partido.getIdlocal());
            stmt.setInt(4,partido.getIdvisitante());
            stmt.setString(5,partido.getMarcador());
            stmt.setInt(6,partido.getIdmejorjugador());
            stmt.setInt(7,partido.getFaltas());
            stmt.setInt(8,partido.getEstadopartido());
            
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

    public int delete(Clspartido partido) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, partido.getIdpartido());
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

    public Clspartido query(Clspartido partidos) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, partidos.getIdpartido());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_PARTIDO");
                int id2 = rs.getInt("ID_CAMPEONATO_FK");
                String fecha = rs.getString("FECHA_PARTIDO");
                int idL  = rs.getInt("ID_LOCAL");
                int idV  = rs.getInt("ID_VISITANTE");
                String marcador = rs.getString("MARCADOR");                    
                int idM = rs.getInt("ID_MEJOR_JUGADOR_FK");
                int faltas = rs.getInt("FALTAS");
                int idE = rs.getInt("ID_ESTADO_PARTIDO");
                
                partidos = new Clspartido();
                partidos.setIdpartido(id);
                partidos.setIdcampeonato(id2);
                partidos.setFechapartido(fecha);
                partidos.setIdlocal(idL);
                partidos.setIdvisitante(idV);
                partidos.setMarcador(marcador);
                partidos.setFaltas(faltas);
                partidos.setIdmejorjugador(idM);
                partidos.setFaltas(faltas);
                partidos.setEstadopartido(idE);
                }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return partidos;
    }
}
 