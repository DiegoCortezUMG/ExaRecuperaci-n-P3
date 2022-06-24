/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoUsuario {

    private static final String SQL_SELECT = "SELECT , ID_USUARIO, PASSWORD, ID_TIPO_USUARIO_FK FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(ID_USUARIO, PASSWORD, ID_TIPO_USUARIO_FK) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET ID_USUARIO=?, PASSWORD=?, ID_TIPO_USUARIO_FK=? WHERE ID_USUARIO= ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE ID_USUARIO=?";
    private static final String SQL_QUERY = "SELECT ID_USUARIO, PASSWORD, ID_TIPO_USUARIO_FK FROM usuario WHERE ID_USUARIO=?";
    private static final String SQL_QUERYN = "SELECT ID_USUARIO, PASSWORD, ID_TIPO_USUARIO_FK FROM usuario WHERE ID_USUARIO=?";    

    public List<clsUsuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsUsuario usuario = null;
        List<clsUsuario> usuarios = new ArrayList<clsUsuario>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_TIPO_USUARIO_FK");
                String nombre = rs.getString("ID_USUARIO");
                String contrasena = rs.getString("PASSWORD");
                
                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());
            
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

    public int update(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsunombre());
            stmt.setString(2, usuario.getUsucontrasena());
            stmt.setInt(9, usuario.getUsuid());

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

    public int delete(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getUsuid());
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

    public clsUsuario query(clsUsuario usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            List<clsUsuario> usuarios = new ArrayList<clsUsuario>();
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getUsuid());
            rs = stmt.executeQuery();
            while (rs.next()) {
            int id = rs.getInt("ID_TIPO_USUARIO_FK");
                String nombre = rs.getString("ID_USUARIO");
                String contrasena = rs.getString("PASSWORD");
                
                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuarios.add(usuario);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
public clsUsuario queryn(clsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            List<clsUsuario> usuarios = new ArrayList<clsUsuario>();
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getUsunombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_TIPO_USUARIO_FK");
                String nombre = rs.getString("ID_USUARIO");
                String contrasena = rs.getString("PASSWORD");
                
                usuario = new clsUsuario();
                usuario.setUsuid(id);
                usuario.setUsunombre(nombre);
                usuario.setUsucontrasena(contrasena);
                usuarios.add(usuario);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return usuario;
    }
    
}
