package umg.programacionII.DateBase.Service;

import umg.programacionII.DateBase.Dao.DaoChampions;
import umg.programacionII.DateBase.Model.ModelChampions;

import java.util.List;

public class ServiceChampions {
    private DaoChampions daoChampions;

    public ServiceChampions() {
        this.daoChampions = new DaoChampions();
    }

    public boolean agregarEquipo(ModelChampions equipo) {
        return daoChampions.agregarEquipo(equipo);
    }

    public List<ModelChampions> obtenerEquipos() {
        return daoChampions.obtenerEquipos();
    }

    public ModelChampions obtenerEquipoPorId(int idEquipo) {
        return daoChampions.obtenerEquipoPorId(idEquipo);
    }

    public boolean actualizarEquipo(ModelChampions equipo) {
        return daoChampions.actualizarEquipo(equipo);
    }

    public boolean eliminarEquipo(int idEquipo) {
        return daoChampions.eliminarEquipo(idEquipo);
    }
}