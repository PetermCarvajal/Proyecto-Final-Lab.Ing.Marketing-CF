package logica.Aplication.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import logica.Aplication.Entity.User;
import logica.Aplication.Interfaces.UsersRepository;

import java.util.List;

public class UsersRepositoryImpl implements UsersRepository {

    private final EntityManagerFactory emf;

    public UsersRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public boolean validarCredenciales(String usuario, String contraseña) {
        EntityManager em = emf.createEntityManager();
        try {
            Long count = em.createQuery(
                            "SELECT COUNT(u) FROM User u WHERE u.user = :usuario AND u.password = :password",
                            Long.class)
                    .setParameter("usuario", usuario)
                    .setParameter("password", contraseña)
                    .getSingleResult();

            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
    @Override
    public void crear(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public User leer(Long id) {
        EntityManager em = emf.createEntityManager();
        User user = null;
        try {
            user = em.find(User.class, id);
        } finally {
            em.close();
        }
        return user;
    }

    @Override
    public List<User> leerTodos() {
        EntityManager em = emf.createEntityManager();
        List<User> users = null;
        try {
            users = em.createQuery("SELECT e FROM User e", User.class).getResultList();
        } finally {
            em.close();
        }
        return users;
    }

    @Override
    public void actualizar(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
