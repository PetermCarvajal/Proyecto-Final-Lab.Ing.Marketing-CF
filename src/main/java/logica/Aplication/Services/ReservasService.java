package logica.Aplication.Services;

import logica.Aplication.Entity.Reservas;
import logica.Aplication.Interfaces.ReservasRepository;
import java.util.List;

public class ReservasService {

        private final ReservasRepository reservaRepository;

        public ReservasService(ReservasRepository reservaRepository) {
            this.reservaRepository =reservaRepository;
        }

        public void crearReserva(Reservas reservas) {
            reservaRepository.crear(reservas);
        }

        public List<Reservas> listarReservas() {
            return reservaRepository.leerTodos();
        }

        public void eliminarReserva(Long id) {
            reservaRepository.eliminar(id);
        }

        public Reservas buscrReservaPorId(Long id) {
            return reservaRepository.leer(id);
        }

        public void actualizarReserva(Reservas reservas) {
            reservaRepository.actualizar(reservas);
        }

}
