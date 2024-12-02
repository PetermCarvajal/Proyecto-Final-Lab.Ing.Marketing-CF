package logica.Aplication.Interfaces;

import logica.Aplication.Entity.EquiposHerramientas;
import java.util.*;

public interface EquipoRepository {
    void crear(EquiposHerramientas equipo);
    EquiposHerramientas leer(Long id);
    List<EquiposHerramientas> leerTodos();
    void actualizar(EquiposHerramientas equipo);
    void eliminar(Long id);
}

