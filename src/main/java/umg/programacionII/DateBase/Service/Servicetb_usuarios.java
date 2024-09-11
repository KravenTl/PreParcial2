package umg.programacionII.DateBase.Service;

import umg.programacionII.DateBase.Dao.Daotb_usuarios;
import umg.programacionII.DateBase.Model.Modeltb_usuarios;

import java.sql.SQLException;
import java.util.List;

public class Servicetb_usuarios {
    private Daotb_usuarios daoUsuario;

    // Constructor
    public Servicetb_usuarios() {
        this.daoUsuario = new Daotb_usuarios();
    }

    // Obtener todos los usuarios
    public List<Modeltb_usuarios> obtenerTodosUsuarios() {
        return daoUsuario.listarUsuarios();
    }

    // Guardar o actualizar un usuario
    public boolean guardarOActualizarUsuario(Modeltb_usuarios usuario) {
        // Verificar si el correo ya existe
        if (daoUsuario.existeCorreo(usuario.getCorreo(), usuario.getIdusuario())) {
            throw new IllegalArgumentException("El correo ya está en uso por otro usuario");
        }

        if (usuario.getIdusuario() == 0) {
            // Si el ID es 0, significa que es un nuevo usuario, entonces lo insertamos
            return daoUsuario.insertarUsuario(usuario);
        } else {
            // Si el ID no es 0, actualizamos el usuario existente
            return daoUsuario.actualizarUsuario(usuario);
        }
    }

    // Eliminar un usuario por ID
    public boolean eliminarUsuario(int idusuario) {
        return daoUsuario.eliminarUsuario(idusuario);
    }

    // Obtener un usuario por ID (puedes agregar este método si es necesario)
    public Modeltb_usuarios obtenerUsuarioPorId(int idusuario) {
        List<Modeltb_usuarios> usuarios = daoUsuario.listarUsuarios();
        for (Modeltb_usuarios usuario : usuarios) {
            if (usuario.getIdusuario() == idusuario) {
                return usuario;
            }
        }
        return null; // Retorna null si no se encuentra el usuario
    }
}
