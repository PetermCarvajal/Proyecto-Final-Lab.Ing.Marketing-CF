package logica.Aplication.Services;

import logica.Aplication.Entity.EquiposHerramientas;
import logica.Aplication.Interfaces.EquipoRepository;

import java.util.List;

public class EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public void crearEquipo(EquiposHerramientas equipo) {
        equipoRepository.crear(equipo);
    }

    public List<EquiposHerramientas> listarEquipos() {
        return equipoRepository.leerTodos();
    }

    public void eliminarEquipo(Long id) {
        equipoRepository.eliminar(id);
    }

    public EquiposHerramientas buscarEquipoPorId(Long id) {
        return equipoRepository.leer(id);
    }

    public void actualizarEquipo(EquiposHerramientas equipo) {
        equipoRepository.actualizar(equipo);
    }
}