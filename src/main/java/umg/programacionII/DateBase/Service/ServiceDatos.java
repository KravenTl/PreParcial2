package umg.programacionII.DateBase.Service;

import umg.programacionII.DateBase.Dao.DaoDatos;
import umg.programacionII.DateBase.Model.ModelDatos;

import java.sql.SQLException;
import java.util.List;

public class ServiceDatos {

    private DaoDatos daoDatos=new DaoDatos();

    // Lógica de negocio para insertar datos
    public void insertar(ModelDatos datos) throws SQLException {
        daoDatos.insertar(datos);
    }

    // Lógica de negocio para actualizar datos
    public void actualizar(ModelDatos datos) throws SQLException {
        daoDatos.actualizar(datos);
    }

    // Lógica de negocio para eliminar datos
    public void eliminar(int codigo) throws SQLException {
        daoDatos.eliminar(codigo);
    }

    // Lógica de negocio para obtener datos por ID
    public ModelDatos obtenerPorId(int codigo) throws SQLException {
        return daoDatos.obtenerPorId(codigo);
    }

    // Lógica de negocio para obtener todos los registros
    public List<ModelDatos> obtenerTodos() throws SQLException {
        return daoDatos.obtenerTodos();
    }
}
