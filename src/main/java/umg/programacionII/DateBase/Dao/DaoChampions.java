package umg.programacionII.DateBase.Dao;

import umg.programacionII.DateBase.DBConexion.DateBaseConexion;
import umg.programacionII.DateBase.Model.ModelChampions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoChampions {
    private Connection connection;

    public DaoChampions() {
        connection = DateBaseConexion.getConnection();
    }

    public boolean agregarEquipo(ModelChampions equipo) {
        String sql = "INSERT INTO equipos_champions (nombre, pais, ciudad, estadio, fundacion, entrenador, web_oficial, facebook, twitter, instagram, patrocinador_principal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getPais());
            stmt.setString(3, equipo.getCiudad());
            stmt.setString(4, equipo.getEstadio());
            stmt.setInt(5, equipo.getFundacion());
            stmt.setString(6, equipo.getEntrenador());
            stmt.setString(7, equipo.getWebOficial());
            stmt.setString(8, equipo.getFacebook());
            stmt.setString(9, equipo.getTwitter());
            stmt.setString(10, equipo.getInstagram());
            stmt.setString(11, equipo.getPatrocinadorPrincipal());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<ModelChampions> obtenerEquipos() {
        List<ModelChampions> listaEquipos = new ArrayList<>();
        String sql = "SELECT * FROM equipos_champions";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ModelChampions equipo = new ModelChampions(
                        rs.getInt("id_equipo"),
                        rs.getString("nombre"),
                        rs.getString("pais"),
                        rs.getString("ciudad"),
                        rs.getString("estadio"),
                        rs.getInt("fundacion"),
                        rs.getString("entrenador"),
                        rs.getString("web_oficial"),
                        rs.getString("facebook"),
                        rs.getString("twitter"),
                        rs.getString("instagram"),
                        rs.getString("patrocinador_principal"),
                        rs.getTimestamp("creado_en")
                );
                listaEquipos.add(equipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEquipos;
    }

    public ModelChampions obtenerEquipoPorId(int idEquipo) {
        String sql = "SELECT * FROM equipos_champions WHERE id_equipo = ?";
        ModelChampions equipo = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEquipo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    equipo = new ModelChampions(
                            rs.getInt("id_equipo"),
                            rs.getString("nombre"),
                            rs.getString("pais"),
                            rs.getString("ciudad"),
                            rs.getString("estadio"),
                            rs.getInt("fundacion"),
                            rs.getString("entrenador"),
                            rs.getString("web_oficial"),
                            rs.getString("facebook"),
                            rs.getString("twitter"),
                            rs.getString("instagram"),
                            rs.getString("patrocinador_principal"),
                            rs.getTimestamp("creado_en")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return equipo;
    }

    // Otros métodos como actualizarEquipo, eliminarEquipo, etc.
    public boolean actualizarEquipo(ModelChampions equipo) {
        String sql = "UPDATE equipos_champions SET nombre = ?, pais = ?, ciudad = ?, estadio = ?, fundacion = ?, entrenador = ?, web_oficial = ?, facebook = ?, twitter = ?, instagram = ?, patrocinador_principal = ? WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getPais());
            stmt.setString(3, equipo.getCiudad());
            stmt.setString(4, equipo.getEstadio());
            stmt.setInt(5, equipo.getFundacion());
            stmt.setString(6, equipo.getEntrenador());
            stmt.setString(7, equipo.getWebOficial());
            stmt.setString(8, equipo.getFacebook());
            stmt.setString(9, equipo.getTwitter());
            stmt.setString(10, equipo.getInstagram());
            stmt.setString(11, equipo.getPatrocinadorPrincipal());
            stmt.setInt(12, equipo.getIdEquipo());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEquipo(int idEquipo) {
        String sql = "DELETE FROM equipos_champions WHERE id_equipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEquipo);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
