package logica.Aplication.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservas")
@EntityListeners(ReservasLista.class)
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipo_id", insertable = false, updatable = false)
    private Long equipoId;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Column(name = "fechaReserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;

    @Column(name = "idReserva")
    private Long idReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private EquiposHerramientas equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Reservas() {
    }
    @Column(name = "lunes", nullable = false, columnDefinition = "boolean default false")
    private boolean lunes = false;

    @Column(name = "martes", nullable = false, columnDefinition = "boolean default false")
    private boolean martes = false;

    @Column(name = "miercoles", nullable = false, columnDefinition = "boolean default false")
    private boolean miercoles = false;

    @Column(name = "jueves", nullable = false, columnDefinition = "boolean default false")
    private boolean jueves = false;

    @Column(name = "viernes", nullable = false, columnDefinition = "boolean default false")
    private boolean viernes = false;

    @Column(name = "sabado", nullable = false, columnDefinition = "boolean default false")
    private boolean sabado = false;

    public Reservas(Long equipoId, Date fechaReserva, Long idReserva, Long userId) {
        this.equipoId = equipoId;
        this.fechaReserva = fechaReserva;
        this.idReserva = idReserva;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Long equipoId) {
        this.equipoId = equipoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
    this.fechaReserva = fechaReserva;
}
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public EquiposHerramientas getEquipo() {
        return equipo;
    }

    public void setEquipo(EquiposHerramientas equipo) {
        this.equipo = equipo;
        if (equipo != null) {
            this.equipoId = equipo.getId();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            this.userId = user.getId();
        }
    }

    @Column(name = "duracion")
    private Integer duracionHoras;

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
    @Override
    public String toString() {
return String.format("""
                     
                     Id : %d
                     Id del Equipo: %d
                     Id del Usuario: %d
                     Fecha Reserva: %s
                     ID Reserva: %s
                     Horas de Reserva: %d
                     """,id,equipoId,userId,fechaReserva,idReserva,duracionHoras);
    }
}