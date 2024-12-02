package logica.Aplication;

import javax.swing.*;
import java.util.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import logica.Aplication.Entity.EquiposHerramientas;
import logica.Aplication.Entity.Reservas;
import logica.Aplication.Entity.User;


public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabIngMarketingPU");
    static List<EquiposHerramientas> listaEquipos = new ArrayList<>();
    static List<User> listaUsuarios = new ArrayList<>();


    public static void main(String[] args) {

        int input=Integer.parseInt(JOptionPane.showInputDialog(null, """
                        ¿Dispone de un Usuario?
                        1. Si
                        2. No
                       
                        """));

        switch (input) {
            case 1:
                boolean acceso=gestionarAcceso();
                if (acceso==true){
                    int input1=Integer.parseInt(JOptionPane.showInputDialog(null, """
                    
                    Buenos Días que desea Hacer
                    1.  Solicitar un Equipo
                    2.  Mostrar Equipos Reservados
                    3.  Modificar una Reserva
                  
                    """));
                    switch (input1){

                        case 1->Registro();
                        case 2->mostrarEquiposRegistrados();
                        case 3->modificarReservas();
                        default -> JOptionPane.showMessageDialog(null, "Esa Opción no existe");
                    }
                }
            case 2:
                newUser();
                acceso=gestionarAcceso();
                if (acceso==true){
                    int input1=Integer.parseInt(JOptionPane.showInputDialog(null, """
                    
                    Buenos Días que desea Hacer
                    1.  Solicitar un Equipo
                    2.  Mostrar Equipos Reservados
                    3.  Modificar una Reserva
                  
                    """));
                    switch (input1){

                        case 1->Registro();
                        case 2->mostrarEquiposRegistrados();
                        case 3->modificarReservas();
                        default -> JOptionPane.showMessageDialog(null, "Esa Opción no existe");
                    }
                }
                break;}
    }
    public static String Registro() {
        int equipo = Integer.parseInt(JOptionPane.showInputDialog(null, """
                Buenos Días Bienvenido a Registro y control de Equipos y Herramientas del Laboratorio de Marketing.

                Por Favor Elija la Opción que Corresponda:

                1. Computador
                2. Impresora
                3. Cámara
                4. Equipo de Grabación
                5. Espacio de Grabación
                """));

        String tipoObjeto = "";
        String equipoNombre = "";

        switch (equipo) {
            case 1 -> {
                equipoNombre = "Computador";
                int tipoComputador = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Por Favor Elija el Tipo de Computador:
                        1. Computador de Escritorio
                        2. Portátil
                        """));
                tipoObjeto = (tipoComputador == 1) ? "Computador de Escritorio" : "Portátil";
            }
            case 2 -> {
                equipoNombre = "Impresora";
                int tipoImpresora = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Por Favor Elija el Tipo de Impresora:
                        1. Impresora Monocromática
                        2. Impresora a Color
                        """));
                tipoObjeto = (tipoImpresora == 1) ? "Impresora Monocromática" : "Impresora a Color";
            }
            case 3 -> {
                equipoNombre = "Cámara";
                int tipoCamara = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Por Favor Elija el Tipo de Cámara:
                        1. Cámara Compacta
                        2. Cámara Reflex
                        3. Cámara Mirrorless
                        4. Cámara Bridge
                        5. Cámara de Acción
                        6. Cámara Instantánea
                        7. Cámara de Formato Medio
                        8. Cámara Gran Formato
                        """));
                switch (tipoCamara) {
                    case 1 -> tipoObjeto = "Cámara Compacta";
                    case 2 -> tipoObjeto = "Cámara Reflex";
                    case 3 -> tipoObjeto = "Cámara Mirrorless";
                    case 4 -> tipoObjeto = "Cámara Bridge";
                    case 5 -> tipoObjeto = "Cámara de Acción";
                    case 6 -> tipoObjeto = "Cámara Instantánea";
                    case 7 -> tipoObjeto = "Cámara de Formato Medio";
                    case 8 -> tipoObjeto = "Cámara Gran Formato";
                }
            }
            case 4 -> {
                equipoNombre = "Equipo de Grabación";
                int tipoGrabacion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Por Favor Elija el Tipo de Equipo de Grabación:
                        1. Audio
                        2. Visual
                        3. AudioVisual
                        """));
                tipoObjeto = (tipoGrabacion == 1) ? "Equipo de Grabación de Audio" : "Equipo de Grabación Visual";
            }
            case 5 -> tipoObjeto = "Espacio de Grabación";
            default -> {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
                return null;
            }
        }

        String piso = JOptionPane.showInputDialog(null, """
                Por Favor Elija el Piso donde se encuentra:
                1. Piso 1
                2. Piso 2
                3. Piso 3
                """);

        String sede = JOptionPane.showInputDialog(null, """
                Por Favor Elija la Sede donde se encuentra:
                1. Sede 1
                2. Sede 2
                3. Sede 3
                4. Sede 4
                5. Sede 5
                6. Sede 6
                7. Sede 7
                """);

        EquiposHerramientas equipoHerramienta = new EquiposHerramientas(equipoNombre,tipoObjeto,"Piso " + piso + ", Sede " + sede,true);
        listaEquipos.add(equipoHerramienta);

        String resultado= """
                El Equipo Seleccionado es: %s
                                Ubicación: %s
                      Estado del Préstamo: %s
                """.formatted(equipoHerramienta.getTipoObjeto(),equipoHerramienta.getUbicacion(),(equipoHerramienta.isEstado()?"Disponible":"No Disponible"));
        tipoObjeto=(tipoObjeto.equals("A"))?"De Escritorio":(tipoObjeto.equals("Portatil")?"Portatil":"Mesa");

        return resultado;
    }

    public static void mostrarEquiposRegistrados() {
        StringBuilder equiposRegistrados = new StringBuilder("Equipos registrados:\n");

        for (EquiposHerramientas equipo : listaEquipos) {
            equiposRegistrados.append(equipo.getEquipo()).append(" - ").append(equipo.getTipoObjeto())
                    .append(" - Ubicación: ").append(equipo.getUbicacion())
                    .append(" - Estado: ").append(equipo.isEstado() ? "Disponible" : "No disponible").append("\n");
        }

        JOptionPane.showMessageDialog(null, equiposRegistrados.toString());
    }


    public static void hacerReserva(EquiposHerramientas equipo) {
        if (!equipo.isEstado()) {
            JOptionPane.showMessageDialog(null, "El equipo no está disponible para reserva.");
            return;
        }

        try {
            String fechaStr = JOptionPane.showInputDialog(null,
                    "Ingrese la fecha y hora de la reserva (formato: dd/MM/yyyy HH:mm)",
                    "Fecha de Reserva",
                    JOptionPane.QUESTION_MESSAGE);

            if (fechaStr == null || fechaStr.trim().isEmpty()) {
                return;
            }

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date fechaReserva = sdf.parse(fechaStr);

            Reservas reserva = new Reservas();
            reserva.setEquipo(equipo);
            reserva.setFechaReserva(fechaReserva);
            reserva.setIdReserva(System.currentTimeMillis());

            equipo.setEstado(false);
            equipo.getReservas().add(reserva);

            JOptionPane.showMessageDialog(null,
                    "Reserva realizada exitosamente para: " + sdf.format(fechaReserva));

        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(null,
                    "Formato de fecha inválido. Use dd/MM/yyyy HH:mm",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al realizar la reserva: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

public static void modificarReservas() {
    if (listaEquipos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay equipos registrados.");
        return;
    }

    StringBuilder equiposRegistrados = new StringBuilder("Equipos con reservas:\n");
    List<EquiposHerramientas> equiposConReservas = new ArrayList<>();
    
    for (EquiposHerramientas equipo : listaEquipos) {
        if (!equipo.getReservas().isEmpty()) {
            equiposConReservas.add(equipo);
            equiposRegistrados.append(equiposConReservas.size())
                .append(". ")
                .append(equipo.getEquipo())
                .append(" - ")
                .append(equipo.getTipoObjeto())
                .append(" - Ubicación: ")
                .append(equipo.getUbicacion())
                .append("\n");
        }
    }

    if (equiposConReservas.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay reservas activas para modificar.");
        return;
    }

    String seleccion = JOptionPane.showInputDialog(null,
        equiposRegistrados.toString() + "\nIngrese el número del equipo a modificar:");
    
    if (seleccion == null) {
        return;
    }

    try {
        int index = Integer.parseInt(seleccion) - 1;
        if (index < 0 || index >= equiposConReservas.size()) {
            JOptionPane.showMessageDialog(null, "Selección inválida.");
            return;
        }

        EquiposHerramientas equipoSeleccionado = equiposConReservas.get(index);
        Reservas reservaActual = equipoSeleccionado.getReservas().get(0);

        String fechaStr = JOptionPane.showInputDialog(null,
            "Ingrese la nueva fecha (dd/MM/yyyy HH:mm):", 
            "Modificar Reserva", 
            JOptionPane.QUESTION_MESSAGE);

        if (fechaStr == null || fechaStr.trim().isEmpty()) {
            return;
        }

        try {

            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date nuevaFecha = sdf.parse(fechaStr);
            
            reservaActual.setFechaReserva(nuevaFecha);

            JOptionPane.showMessageDialog(null, 
                "Reserva modificada exitosamente.\nNueva fecha: " + sdf.format(nuevaFecha));

        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(null, 
                "Formato de fecha inválido. Use dd/MM/yyyy HH:mm",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, 
            "Por favor ingrese un número válido.",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

    public static boolean gestionarAcceso() {
        int input = Integer.parseInt(JOptionPane.showInputDialog(null, """
            Bienvenido Por Favor Elija el Tipo de Acceso:
            1. Docente
            2. Estudiante
            """));
        String tipoUsuario = (input == 1) ? "Docente" : (input == 2) ? "Estudiante" : null;

        if (tipoUsuario == null) {
            JOptionPane.showMessageDialog(null, "Tipo de usuario no permitido.");
            return false;
        }

        String usuario = JOptionPane.showInputDialog(null, "Por Favor Ingrese Su Usuario");
        String pass = JOptionPane.showInputDialog(null, "Por Favor Ingrese Su Contraseña");
        for (User usuari : listaUsuarios) {
            if (usuari.getUser().equals(usuario) && usuari.getPassword().equals(pass) &&
                    usuari.getTypeacc().equals(tipoUsuario)) {
                JOptionPane.showMessageDialog(null, "Acceso concedido. Bienvenido " + usuario + " (" + tipoUsuario + ")");
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Acceso denegado: Usuario o contraseña incorrectos.");
        return false;
    }


    public  static void newUser(){

        String name=JOptionPane.showInputDialog(null,"Por Favor Ingrese Sus Nombres");
        String lastName=JOptionPane.showInputDialog(null,"Por Favor Ingrese Sus Apellidos");
        int age=Integer.parseInt(JOptionPane.showInputDialog(null,"Por Favor Ingrese Su Edad"));
        String password=JOptionPane.showInputDialog(null,"Por Favor Ingrese Su Contraseña");
        int tipoacceso=Integer.parseInt(JOptionPane.showInputDialog(null, """
                Por Favor indique su Posicion en la Universidad:
                1.Docente
                2.Estudiante"""));
        String TipoAcceso=(tipoacceso==1)?"Docente":"Estudiante";

        User push=new User();
        push.setName(name);
        push.setPassword(password);
        push.setLastName(lastName);
        push.setAge(age);
        push.setTypeacc(TipoAcceso);
        String replaceUser=push.getLastName().replaceAll(" ","");
        String user =replaceUser+push.getId();
        push.setUser(user);

             String result="""
                El Usuario se a creado con Exito:
                
                Nombres y apellidos del %s: %s %s
                Edad del Usuario: %d
                Usuario Aseignado: %s
                Contraseña del Usuario: *********
               
                """.formatted(push.getTypeacc(),push.getName(),push.getLastName(),push.getAge(),push.getUser());

             JOptionPane.showMessageDialog(null,result);
        listaUsuarios.add(push);
    }

}
