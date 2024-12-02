package logica.Aplication.org.peterSolo;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import logica.Aplication.Services.EquipoService;
import logica.Aplication.Services.ReservasService;
import logica.Aplication.Services.UsersService;
import logica.Aplication.Repository.UsersRepositoryImpl;
import logica.Aplication.Repository.ReservasRepositoryImpl;
import logica.Aplication.Repository.EquipoRepositoryImpl;
import logica.Aplication.Interfaces.EquipoRepository;
import logica.Aplication.Interfaces.ReservasRepository;
import logica.Aplication.Interfaces.UsersRepository;

public class Main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabIngMarketingPU");

            UsersRepository usersRepository = new UsersRepositoryImpl(emf);
            UsersService usersService = new UsersService(usersRepository);

            EquipoRepository equipoRepository = new EquipoRepositoryImpl(emf);
            EquipoService equipoService = new EquipoService(equipoRepository);

            ReservasRepository reservasRepository = new ReservasRepositoryImpl(emf);
            ReservasService reservasService = new ReservasService(reservasRepository);
        });

    }
}
