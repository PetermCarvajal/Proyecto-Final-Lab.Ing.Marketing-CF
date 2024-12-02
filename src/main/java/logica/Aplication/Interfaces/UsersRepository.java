package logica.Aplication.Interfaces;

import logica.Aplication.Entity.User;

import java.util.List;

public interface UsersRepository {
    void crear(User user);
void actualizar(User user);
void eliminar(Long id);
List<User> leerTodos();
User leer(Long id);
boolean validarCredenciales(String usuario, String contraseña);
}
