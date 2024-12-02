package logica.Aplication.Services;

import logica.Aplication.Entity.User;
import logica.Aplication.Interfaces.UsersRepository;
import java.util.List;

public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void crearEquipo(User user) {
        usersRepository.crear(user);
    }

    public List<User> listarUsers() {
        return usersRepository.leerTodos();
    }

    public void eliminarEquipo(Long id) {
        usersRepository.eliminar(id);
    }

    public User buscrEquipoPorId(Long id) {
        return usersRepository.leer(id);
    }

    public void actualizarEquipo(User user) {
        usersRepository.actualizar(user);
    }
}
