package logica.Aplication.Repository;

import logica.Aplication.Entity.EquiposHerramientas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import logica.Aplication.Interfaces.EquipoRepository;

import java.util.List;

public class EquipoRepositoryImpl implements EquipoRepository {

    private final EntityManagerFactory emf;

    public EquipoRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
        @Override
        public void crear(EquiposHerramientas equipo) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(equipo);
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
        public EquiposHerramientas leer(Long id) {
            EntityManager em = emf.createEntityManager();
            EquiposHerramientas equipo = null;
            try {
                equipo = em.find(EquiposHerramientas.class, id);
            } finally {
                em.close();
            }
            return equipo;
        }

        @Override
        public List<EquiposHerramientas> leerTodos() {
            EntityManager em = emf.createEntityManager();
            List<EquiposHerramientas> equipos = null;
            try {
                equipos = em.createQuery("SELECT e FROM EquiposHerramientas e", EquiposHerramientas.class).getResultList();
            } finally {
                em.close();
            }
            return equipos;
        }

        @Override
        public void actualizar(EquiposHerramientas equipo) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.merge(equipo);
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
                EquiposHerramientas equipo = em.find(EquiposHerramientas.class, id);
                if (equipo != null) {
                    em.remove(equipo);
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