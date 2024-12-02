package logica.Aplication.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="equipos")
@EntityListeners(EquiposLista.class)
public class EquiposHerramientas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String equipo;

    @Column
    private String typeacc;

    @Column(nullable=false)
    private String tipoObjeto;

    @Column(nullable=false)
    private String ubicacion;

    private boolean estado = false;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservas> reservas = new ArrayList<>();

    public EquiposHerramientas() {
    }

    public EquiposHerramientas(String equipo, String tipoObjeto, String ubicacion, boolean estado) {
        this.equipo = equipo;
        this.tipoObjeto = tipoObjeto;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }


    public String getTypeacc() {
        return typeacc;
    }

    public void setTypeacc(String typeacc) {
        this.typeacc = typeacc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Reservas> getReservas() {
        return reservas;
    }

    public String getEstadoString() {
        return estado ? "Disponible" : "No Disponible";
    }

    @Override
    public String toString() {
        return String.format("""
                Equipo / Herramientas:
                Equipo: %s
                Tipo: %s
                Ubicacion: %s
                Estado: %s
                Reservas: %s
                """,
                equipo,
                tipoObjeto,
                ubicacion,
                getEstadoString(),
                reservas);
    }
}