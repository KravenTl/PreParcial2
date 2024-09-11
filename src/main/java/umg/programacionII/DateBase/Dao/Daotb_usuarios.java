package umg.programacionII.DateBase.Dao;


import umg.programacionII.DateBase.DBConexion.DateBaseConexion;
import umg.programacionII.DateBase.Model.Modeltb_usuarios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Daotb_usuarios {

    public List<Modeltb_usuarios> listarUsuarios() {
        List<Modeltb_usuarios> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_usuarios";

        try (Connection conn = DateBaseConexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Modeltb_usuarios usuario = new Modeltb_usuarios();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setCarne(rs.getString("carne"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setSeccion(rs.getString("seccion"));
                usuario.setTelegramid(rs.getLong("telegramid"));
                usuario.setActivo(rs.getString("activo"));
                lista.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean insertarUsuario(Modeltb_usuarios usuario) {
        String sql = "INSERT INTO tb_usuarios (carne, nombre, correo, seccion, telegramid, activo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DateBaseConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getCarne());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getSeccion());
            stmt.setObject(5, usuario.getTelegramid());
            stmt.setString(6, usuario.getActivo());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarUsuario(Modeltb_usuarios usuario) {

        String sql = "UPDATE tb_usuarios SET carne = ?, nombre = ?, correo = ?, seccion = ?, telegramid = ?, activo = ? WHERE idusuario = ?";
        try (Connection conn = DateBaseConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getCarne());
            stmt.setString(2, usuario.getNombre());
            stmt.setString(3, usuario.getCorreo());
            stmt.setString(4, usuario.getSeccion());
            stmt.setObject(5, usuario.getTelegramid());
            stmt.setString(6, usuario.getActivo());
            stmt.setInt(7, usuario.getIdusuario());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarUsuario(int idusuario) {
        String sql = "DELETE FROM tb_usuarios WHERE idusuario = ?";
        try (Connection conn = DateBaseConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idusuario);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean existeCorreo(String correo, int idusuario) {
        String sql = "SELECT COUNT(*) FROM tb_usuarios WHERE correo = ? AND idusuario != ?";
        try (Connection conn = DateBaseConexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setInt(2, idusuario); // Evitar conflicto con el propio usuario en caso de actualizar

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Si el conteo es mayor a 0, significa que el correo está en uso
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}