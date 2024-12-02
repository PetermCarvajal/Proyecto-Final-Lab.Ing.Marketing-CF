    package logica.Aplication.Controlador;

    import java.util.List;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.EntityManagerFactory;
    import jakarta.persistence.NoResultException;
    import logica.Aplication.Entity.EquiposHerramientas;
    import logica.Aplication.Entity.Reservas;
    import logica.Aplication.Entity.User;
    import java.util.Date;
    import jakarta.persistence.Query;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.TypedQuery;
    import java.util.ArrayList;
    import jakarta.persistence.EntityManagerFactory;
    import logica.Aplication.Entity.EquiposHerramientas;
    import logica.Aplication.Entity.Reservas;
    import logica.Aplication.Entity.User;
    import logica.Aplication.Repository.EquipoRepositoryImpl;
    import logica.Aplication.Repository.ReservasRepositoryImpl;
    import logica.Aplication.Repository.UsersRepositoryImpl;
    import logica.Aplication.Interfaces.EquipoRepository;
    import logica.Aplication.Interfaces.ReservasRepository;
    import logica.Aplication.Interfaces.UsersRepository;
    import logica.Aplication.Interfaces.ReservasRepository;


    import javax.swing.JOptionPane;
    import java.util.Date;
    import java.util.List;


    public class ControladorPrincipal {
        private final EntityManagerFactory emf;
    private final ReservasRepository reservasRepository;


        public ControladorPrincipal(EntityManagerFactory emf) {
            this.emf = emf;
            this.reservasRepository = new ReservasRepositoryImpl(emf);

        }

        public boolean validarUsuario(String username, String password) {
    EntityManager em = emf.createEntityManager();
    try {
        User user = em.createQuery(
            "SELECT u FROM User u WHERE u.user = :username", User.class)
            .setParameter("username", username)
            .getSingleResult();
            
        return user != null && user.getPassword().equals(password);
    } catch (NoResultException e) {
        return false;
    } finally {
        em.close();
    }
}
        public void registrarEquipo(String usuario, String tipoEquipo, String especificacion, 
                          String tipo, String sede, String piso, int horas) throws Exception {
    EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        
        User user = em.createQuery(
            "SELECT u FROM User u WHERE u.user = :username", User.class)
            .setParameter("username", usuario)
            .getSingleResult();
            
        EquiposHerramientas equipo = new EquiposHerramientas();
        equipo.setEquipo(tipoEquipo);
        equipo.setTipoObjeto(especificacion);
        equipo.setUbicacion("Piso " + piso + ", Sede " + sede);
        equipo.setEstado(true);
        
        if (!tipo.isEmpty()) {
            equipo.setTypeacc(tipo);
        }
        
        em.persist(equipo);
        
        Reservas reserva = new Reservas();
        reserva.setUser(user);
        reserva.setEquipo(equipo);
        reserva.setFechaReserva(new Date());
        reserva.setDuracionHoras(horas);
        
        em.persist(reserva);
        
        em.getTransaction().commit();
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        throw new Exception("Error al registrar equipo: " + e.getMessage());
    } finally {
        em.close();
    }
}

   public void registrarUsuario(String nombres, String apellidos, String contraseña, 
                           String tipoIngreso, int edad) throws Exception {
    EntityManager em = emf.createEntityManager();
    try {
        String usernameBase = apellidos.toLowerCase().replaceAll("\\s+", "");
        
        List<User> usuariosSimilares = em.createQuery(
            "SELECT u FROM User u WHERE u.user LIKE :userBase", User.class)
            .setParameter("userBase", usernameBase + "%")
            .getResultList();
        
        String username = usernameBase;
        if (!usuariosSimilares.isEmpty()) {
            username = usernameBase + (usuariosSimilares.size() + 1);
        }
        
        em.getTransaction().begin();
        
        User nuevoUsuario = new User();
        nuevoUsuario.setName(nombres);
        nuevoUsuario.setLastName(apellidos);
        nuevoUsuario.setUser(username);
        nuevoUsuario.setPassword(contraseña);
        nuevoUsuario.setAge(edad);
        nuevoUsuario.setTypeacc(tipoIngreso);
        
        em.persist(nuevoUsuario);
        em.getTransaction().commit();
        
        System.out.println("Usuario registrado exitosamente con username: " + username);
        
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        throw new Exception("Error al registrar usuario: " + e.getMessage());
    } finally {
        em.close();
    }
}

private String generarUsernameUnico(String apellidos) {
    String baseUsername = apellidos.toLowerCase().replaceAll("\\s+", "");
    String username = baseUsername;
    int counter = 1;
    
    EntityManager em = emf.createEntityManager();
    try {
        while (true) {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.user = :username", 
                Long.class);
            query.setParameter("username", username);
            
            if (query.getSingleResult() == 0L) {
                return username;
            }
            
            username = baseUsername + counter;
            counter++;
        }
    } finally {
        em.close();
    }

}

        public void modificarReserva(String usuario, String contraseña, String tipoEquipo, 
                                String especificacion, String tipo, String sede, 
                                String piso, Integer horas) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            User user = em.createQuery(
                "SELECT u FROM User u WHERE u.usuario = :usuario", User.class)
                .setParameter("usuario", usuario)
                .getSingleResult();
                
            if (user == null || !user.getPassword().equals(contraseña)) {
                throw new Exception("Usuario o contraseña incorrectos");
            }
            
            Reservas reservaActual = em.createQuery(
                "SELECT r FROM Reservas r WHERE r.user = :user AND r.estado = true",
                Reservas.class)
                .setParameter("user", user)
                .getSingleResult();
                
            if (reservaActual == null) {
                throw new Exception("No se encontró una reserva activa");
            }
            
            EquiposHerramientas equipoNuevo = new EquiposHerramientas();
            equipoNuevo.setEquipo(tipoEquipo);
            equipoNuevo.setTipoObjeto(especificacion);
            equipoNuevo.setUbicacion("Piso " + piso + ", Sede " + sede);
            equipoNuevo.setEstado(true);
            if (!tipo.isEmpty()) {
                equipoNuevo.setTypeacc(tipo);
            }
            
            em.persist(equipoNuevo);
            
            EquiposHerramientas equipoAnterior = reservaActual.getEquipo();
            if (equipoAnterior != null) {
                equipoAnterior.setEstado(false);
                em.merge(equipoAnterior);
            }
            
            reservaActual.setEquipo(equipoNuevo);
            reservaActual.setDuracionHoras(horas);
            em.merge(reservaActual);
            
            em.getTransaction().commit();
            
        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Usuario no encontrado o sin reserva activa");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al modificar la reserva: " + e.getMessage());
        } finally {
            em.close();
        }
    }
        private boolean verificarDisponibilidadFecha(EquiposHerramientas equipo, Date fecha) {
    List<Reservas> reservasExistentes = reservasRepository.leerTodos();
    
    for (Reservas reserva : reservasExistentes) {
        if (reserva.getEquipo().equals(equipo) && 
            reserva.getFechaReserva().equals(fecha)) {
            return false;
        }
    }
    return true;
}
        public List<Reservas> obtenerReservasActivas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                "SELECT r FROM Reservas r WHERE r.estado = true", Reservas.class)
                .getResultList();
        } finally {
            em.close();
        }
    }

        
        public void verificarRegistros() {
    EntityManager em = emf.createEntityManager();
    try {
        List<EquiposHerramientas> equipos = em.createQuery(
            "SELECT e FROM EquiposHerramientas e", EquiposHerramientas.class)
            .getResultList();
        System.out.println("Equipos registrados: " + equipos.size());
        for (EquiposHerramientas e : equipos) {
            System.out.println("Equipo ID: " + e.getId() + ", Tipo: " + e.getEquipo());
        }

        List<Reservas> reservas = em.createQuery(
            "SELECT r FROM Reservas r", Reservas.class)
            .getResultList();
        System.out.println("Reservas registradas: " + reservas.size());
        for (Reservas r : reservas) {
            System.out.println("Reserva ID: " + r.getId() + 
                             ", Equipo: " + r.getEquipo().getEquipo() +
                             ", Usuario: " + r.getUser().getUser());
        }
    } finally {
        em.close();
    }
}
        public void verificarUsuarios() {
    EntityManager em = emf.createEntityManager();
    try {
        List<User> usuarios = em.createQuery("SELECT u FROM User u", User.class)
            .getResultList();
        
        System.out.println("\n=== Usuarios registrados: " + usuarios.size() + " ===");
        for (User u : usuarios) {
            System.out.println("ID: " + u.getId() + 
                             " | Usuario: " + u.getUser() +
                             " | Nombre: " + u.getName() +
                             " | Tipo: " + u.getTypeacc());
        }
    } catch (Exception e) {
        System.err.println("Error al verificar usuarios: " + e.getMessage());
        e.printStackTrace();
    } finally {
        em.close();
    }
}
    }