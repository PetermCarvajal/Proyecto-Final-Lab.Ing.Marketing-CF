package logica.Aplication.Interfaces;

import logica.Aplication.Entity.Reservas;
import java.util.*;

public interface ReservasRepository {
    void crear(Reservas reserva);
    Reservas leer(Long id);
    void actualizar(Reservas reserva);
    void eliminar(Long id);
    List<Reservas> leerTodos();
}
