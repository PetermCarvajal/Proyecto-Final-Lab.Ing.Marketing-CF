package logica.Aplication.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import logica.Aplication.Entity.Reservas;
import logica.Aplication.Interfaces.ReservasRepository;

import java.util.List;

public class ReservasRepositoryImpl implements ReservasRepository {

    private final EntityManagerFactory emf;

    public ReservasRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public void crear(Reservas reserva) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reserva);
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
    public Reservas leer(Long id) {
        EntityManager em = emf.createEntityManager();
        Reservas reserva = null;
        try {
            reserva = em.find(Reservas.class, id);
        } finally {
            em.close();
        }
        return reserva;
    }

    @Override
    public List<Reservas> leerTodos() {
        EntityManager em = emf.createEntityManager();
        List<Reservas> reserva = null;
        try {
            reserva = em.createQuery("SELECT e FROM Reservas e", Reservas.class).getResultList();
        } finally {
            em.close();
        }
        return reserva;
    }

    @Override
    public void actualizar(Reservas reserva) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(reserva);
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
            Reservas reserva = em.find(Reservas.class, id);
            if (reserva != null) {
                em.remove(reserva);
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
