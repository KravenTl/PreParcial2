package umg.programacionII.DateBase.Dao;

import umg.programacionII.DateBase.DBConexion.DateBaseConexion;
import umg.programacionII.DateBase.Model.ModelDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoDatos {

    // Método para insertar un registro
    public void insertar(ModelDatos datos) throws SQLException {
        String query = "INSERT INTO tb_datos (nombre, apellido, departamento, fecha_nacimiento) VALUES (?, ?, ?, ?)";
        try (Connection connection = DateBaseConexion.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, datos.getNombre());
            stmt.setString(2, datos.getApellido());
            stmt.setString(3, datos.getDepartamento());
            stmt.setTimestamp(4, datos.getFechaNacimiento());
            stmt.executeUpdate();
        }
    }

    // Método para actualizar un registro
    public void actualizar(ModelDatos datos) throws SQLException {
        String query = "UPDATE tb_datos SET nombre = ?, apellido = ?, departamento = ?, fecha_nacimiento = ? WHERE codigo = ?";
        try (Connection connection = DateBaseConexion.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, datos.getNombre());
            stmt.setString(2, datos.getApellido());
            stmt.setString(3, datos.getDepartamento());
            stmt.setTimestamp(4, datos.getFechaNacimiento());
            stmt.setInt(5, datos.getCodigo());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un registro
    public void eliminar(int codigo) throws SQLException {
        String query = "DELETE FROM tb_datos WHERE codigo = ?";
        try (Connection connection = DateBaseConexion.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        }
    }

    // Método para obtener un registro por ID
    public ModelDatos obtenerPorId(int codigo) throws SQLException {
        String query = "SELECT * FROM tb_datos WHERE codigo = ?";
        try (Connection connection = DateBaseConexion.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ModelDatos(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("departamento"),
                            rs.getTimestamp("fecha_nacimiento")
                    );
                }
            }
        }
        return null;
    }

    // Método para obtener todos los registros
    public List<ModelDatos> obtenerTodos() throws SQLException {
        List<ModelDatos> listaDatos = new ArrayList<>();
        String query = "SELECT * FROM tb_datos";
        try (Connection connection = DateBaseConexion.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ModelDatos datos = new ModelDatos(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("departamento"),
                        rs.getTimestamp("fecha_nacimiento")
                );
                listaDatos.add(datos);
            }
        }
        return listaDatos;
    }
}
