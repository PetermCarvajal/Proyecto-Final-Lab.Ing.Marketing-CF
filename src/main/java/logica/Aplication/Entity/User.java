package logica.Aplication.Entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String user;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String typeacc;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservas> reservas = new ArrayList<>();

    public User() {
    }

    public User(String name, String lastName, String user, String password, Integer age, String typeacc) {
        this.name = name;
        this.lastName = lastName;
        this.user = user;
        this.password = password;
        this.age = age;
        this.typeacc = typeacc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTypeacc() {
        return typeacc;
    }

    public void setTypeacc(String typeacc) {
        this.typeacc = typeacc;
    }

    public List<Reservas> getReservas() {
        return reservas;
    }

    public void addReserva(Reservas reserva) {
        reservas.add(reserva);
        reserva.setUser(this);
    }

    public void removeReserva(Reservas reserva) {
        reservas.remove(reserva);
        reserva.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", user='" + user + '\'' +
                ", age=" + age +
                ", typeacc='" + typeacc + '\'' +
                '}';
    }
    @Column(name = "replaceUser", nullable = false, columnDefinition = "boolean default false")
    private boolean replaceUser = false;
}
