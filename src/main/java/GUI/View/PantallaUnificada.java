package GUI.View;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Aplication.Controlador.ControladorPrincipal;
import logica.Aplication.Entity.EquiposHerramientas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.NoResultException;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.Aplication.Entity.User;
import logica.Aplication.Entity.Reservas;
import logica.Aplication.Entity.EquiposHerramientas;
import logica.Aplication.Controlador.ControladorPrincipal;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PantallaUnificada extends JFrame {
     private CardLayout cardLayout;
    private JPanel panelCambiante;
    private JPanel panelRegistro;
    private final ControladorPrincipal controlador;
    private final EntityManagerFactory emf;
    
    private void configurarEventos() {
    BtnRegistrar.addActionListener(e -> {
        String usuario = UsuarioTxt.getText().trim();
        String contraseña = new String(ContraTxt.getPassword()).trim();
        String horasSeleccionadas = horasComboBox.getSelectedItem().toString();

        if (usuario.isEmpty() || contraseña.isEmpty() || 
            horasSeleccionadas.equals("Seleccione...")) {
            
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos obligatorios incluyendo las horas",
                "Error de validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (Seleccion1.getSelectedIndex() == 0 || 
            Seleccion2.getSelectedIndex() == 0 || 
            Seleccion4.getSelectedIndex() == 0 || 
            Seleccion5.getSelectedIndex() == 0) {
            
            JOptionPane.showMessageDialog(this,
                "Por favor complete todos los campos obligatorios",
                "Error de validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            if (!controlador.validarUsuario(usuario, contraseña)) {
                JOptionPane.showMessageDialog(this,
                    "Credenciales inválidas",
                    "Error de autenticación",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            int horas = Integer.parseInt(horasSeleccionadas.split(" ")[0]);

            controlador.registrarEquipo(
                usuario,
                Seleccion1.getSelectedItem().toString(),
                Seleccion2.getSelectedItem().toString(),
                Seleccion3.getSelectedItem().toString().equals("Seleccione...") ? "" : Seleccion3.getSelectedItem().toString(),
                Seleccion4.getSelectedItem().toString(),
                Seleccion5.getSelectedItem().toString(),
                horas
            );
            
            resetearCampos();
            
            JOptionPane.showMessageDialog(this,
                "Equipo y reserva registrados exitosamente por " + horas + " hora(s)",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error al registrar el equipo: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    });

    BtnModificar.addActionListener(e -> {
        cardLayout.show(AP2, "modificar");
    });

    BtnListado.addActionListener(e -> {
        cardLayout.show(AP2, "Listado");
    });

    BtnRegistroUsuario.addActionListener(e -> {
        cardLayout.show(AP2, "registroUsuario");
    });

    Seleccion1Mod.addActionListener(e -> {
        String seleccion = (String) Seleccion1Mod.getSelectedItem();
        actualizarEspecificaciones(seleccion, Seleccion2Mod, Seleccion3Mod);
    });

    Seleccion1.addActionListener(e -> {
        String seleccion = (String) Seleccion1.getSelectedItem();
        actualizarEspecificaciones(seleccion, Seleccion2, Seleccion3);
    });

    btnModificarReserva.addActionListener(e -> {
        modificarReserva();
    });
}
private void inicializarComboBoxHoras() {
    String[] opcionesHoras = {"Seleccione...", "1 Hora", "2 Horas", "3 Horas", "4 Horas","5 Horas","6 Horas","7 Horas","8 Horas"};
    horasComboBox = new JComboBox<>(opcionesHoras);
    horasComboBoxMod = new JComboBox<>(opcionesHoras);
}
private void resetearCampos() {
    Seleccion1.setSelectedIndex(0);
    Seleccion2.setSelectedIndex(0);
    Seleccion3.setSelectedIndex(0);
    Seleccion4.setSelectedIndex(0);
    Seleccion5.setSelectedIndex(0);
    horasComboBox.setSelectedIndex(0);
    
    UsuarioTxt.setText("");
    ContraTxt.setText("");
    
    UsuarioTxt.updateUI();
    ContraTxt.updateUI();
    
    Seleccion1.requestFocus();
    
    actualizarEspecificaciones(
        Seleccion1.getSelectedItem().toString(),
        Seleccion2,
        Seleccion3
    );
}
private void resetearCamposModificar() {
    UsuarioTxtMod.setText("");
    ContraTxtMod.setText("");
    
    Seleccion1Mod.setSelectedIndex(0);
    Seleccion2Mod.setSelectedIndex(0);
    Seleccion3Mod.setSelectedIndex(0);
    Seleccion4Mod.setSelectedIndex(0);
    Seleccion5Mod.setSelectedIndex(0);
    horasComboBoxMod.setSelectedIndex(0);
    UsuarioTxtMod.updateUI();
    ContraTxtMod.updateUI();
    Seleccion1Mod.requestFocus();
}

   public PantallaUnificada() {
    this.emf = Persistence.createEntityManagerFactory("LabIngMarketingPU");
    this.controlador = new ControladorPrincipal(emf);


    SeccionFija();
    
    setTitle("Sistema de Reservas");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    cardLayout = new CardLayout();
    AP2.setLayout(cardLayout);
    
    jScrollPane1.setViewportView(UsuarioTxt);
    jScrollPane2.setViewportView(ContraTxt);
    jScrollPane1Mod.setViewportView(UsuarioTxtMod);
    jScrollPane2Mod.setViewportView(ContraTxtMod);
    
    Fondo.setLayout(new BorderLayout());
    AreaPrincipal.setLayout(new BorderLayout());
    
    Fondo.add(PanelSuperior, BorderLayout.NORTH);
    
    Fondo.add(ContainerLateral, BorderLayout.WEST);
    Fondo.add(AreaPrincipal, BorderLayout.CENTER);
    
    configurarComboBoxes();
    configurarPanelRegistro();
    configurarPanelRegistroUsuario();
    configurarPanelModificar();
    configurarComboBoxListeners();
    configurarEventos();
    configurarBotones();
    configurarPanelListado();
    cardLayout.show(AP2, "registro");
    
    setSize(1600, 620);
    setLocationRelativeTo(null);
    
    getContentPane().add(Fondo);
    
    setVisible(true);
    
    validate();
    repaint();
}
   private void hacerReserva(EquiposHerramientas equipo) {
    if (!equipo.isEstado()) {
        JOptionPane.showMessageDialog(null, "El equipo no está disponible para reserva.");
        return;
    }

    try {
        String horasSeleccionadas = horasComboBox.getSelectedItem().toString();
        int horas = Integer.parseInt(horasSeleccionadas.split(" ")[0]);
        
        Reservas reserva = new Reservas();
        reserva.setEquipo(equipo);
        
        reserva.setFechaReserva(new Date());
        
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(reserva);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null,
                "Reserva realizada exitosamente por " + horas + " hora(s)");
                
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
            "Error al realizar la reserva: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
   private void configurarComboBoxListeners(){
       Seleccion1.addActionListener (e->{
           String seleccion = (String) Seleccion1.getSelectedItem();
           actualizarEspecificaciones(seleccion,Seleccion2,Seleccion3);
           
       });
       Seleccion1Mod.addActionListener (e->{
           String seleccion = (String) Seleccion1Mod.getSelectedItem();
           actualizarEspecificaciones(seleccion,Seleccion2Mod,Seleccion3Mod);
           
       });
   }
   private void actualizarEspecificaciones(String equipoSeleccionado, JComboBox<String> especificacionCombo, JComboBox<String> tipoCombo) {
    especificacionCombo.removeAllItems();
    tipoCombo.removeAllItems();
    
    especificacionCombo.addItem("Seleccione...");
    tipoCombo.addItem("Seleccione...");
    
    if (equipoSeleccionado != null) {
        switch (equipoSeleccionado) {
            case "Computador":
                especificacionCombo.addItem("Computador de Escritorio");
                especificacionCombo.addItem("Portátil");
                break;
                
            case "Impresora":
                especificacionCombo.addItem("Impresora Monocromática");
                especificacionCombo.addItem("Impresora a Color");
                break;
                
            case "Cámara":
                especificacionCombo.addItem("Cámara Compacta");
                especificacionCombo.addItem("Cámara Reflex");
                especificacionCombo.addItem("Cámara Mirrorless");
                especificacionCombo.addItem("Cámara Bridge");
                especificacionCombo.addItem("Cámara de Acción");
                especificacionCombo.addItem("Cámara Instantánea");
                especificacionCombo.addItem("Cámara de Formato Medio");
                especificacionCombo.addItem("Cámara Gran Formato");
                break;
                
            case "Equipo de Grabación":
                especificacionCombo.addItem("Equipo de Grabación de Audio");
                especificacionCombo.addItem("Equipo de Grabación Visual");
                especificacionCombo.addItem("Equipo de Grabación AudioVisual");
                tipoCombo.addItem("Audio");
                tipoCombo.addItem("Visual");
                tipoCombo.addItem("AudioVisual");
                break;
                
            case "Espacio de Grabación":
                especificacionCombo.addItem("Estudio de Fotografía");
                especificacionCombo.addItem("Estudio de Video");
                especificacionCombo.addItem("Estudio de Audio");
                tipoCombo.addItem("Audio");
                tipoCombo.addItem("Visual");
                tipoCombo.addItem("AudioVisual");
                break;
        }
    }
}
   
   private void configurarComboBoxes() {
    String[] equipos = {"Seleccione...", "Computador", "Impresora", "Cámara", "Equipo de Grabación", "Espacio de Grabación"};
    String[] especificaciones = {"Seleccione...", "Computador de Escritorio", "Portátil", 
                               "Impresora Monocromática", "Impresora a Color",
                               "Cámara Compacta", "Cámara Reflex", "Cámara Mirrorless", 
                               "Cámara Bridge", "Cámara de Acción", "Cámara Instantánea",
                               "Cámara de Formato Medio", "Cámara Gran Formato",
                               "Equipo de Grabación de Audio", "Equipo de Grabación Visual",
                               "Equipo de Grabación AudioVisual"};
    String[] tipos = {"Seleccione...", "Audio", "Visual", "AudioVisual"};
    String[] sedes = {"Seleccione...", "Sede 1", "Sede 2", "Sede 3", "Sede 4", "Sede 5", "Sede 6", "Sede 7"};
    String[] pisos = {"Seleccione...", "Piso 1", "Piso 2", "Piso 3"};

    Seleccion1.setModel(new DefaultComboBoxModel<>(equipos));
    Seleccion2.setModel(new DefaultComboBoxModel<>(especificaciones));
    Seleccion3.setModel(new DefaultComboBoxModel<>(tipos));
    Seleccion4.setModel(new DefaultComboBoxModel<>(sedes));
    Seleccion5.setModel(new DefaultComboBoxModel<>(pisos));

    Seleccion1Mod.setModel(new DefaultComboBoxModel<>(equipos));
    Seleccion2Mod.setModel(new DefaultComboBoxModel<>(especificaciones));
    Seleccion3Mod.setModel(new DefaultComboBoxModel<>(tipos));
    Seleccion4Mod.setModel(new DefaultComboBoxModel<>(sedes));
    Seleccion5Mod.setModel(new DefaultComboBoxModel<>(pisos));
}

    private void SeccionFija() {
    Fondo = new JPanel();
    PanelSuperior = new JPanel();
    Logo = new JLabel();
    TContainer = new JPanel();
    TContainer1 = new JPanel();
    TContainer2 = new JPanel();
    TContainer3 = new JPanel();
    Titulo = new JLabel();
    ContainerLateral = new JPanel();
    ContainerLateral1 = new JPanel();
    ContainerLateral2 = new JPanel();
    BtnRegistrar = new JButton();
    BtnModificar = new JButton();
    BtnListado = new JButton();
    BtnRegistroUsuario = new JButton();
    AreaPrincipal = new JPanel();
    AP1 = new JPanel();
    AP2 = new JPanel();
    
    //Seccion "Registro"

        InicioSesion = new JLabel();
    ISUsuario = new JLabel();
    ISContra = new JLabel();
    UsuarioTxt = new JTextArea();
    ContraTxt = new JPasswordField();
    jScrollPane1 = new JScrollPane();
    jScrollPane2 = new JScrollPane();
    SEspecificacion = new JLabel();
    SPiso = new JLabel();
    SSede = new JLabel();
    STipo = new JLabel();
    SeleccionEquipo = new JLabel();
    Seleccion1 = new JComboBox<>();
    Seleccion2 = new JComboBox<>();
    Seleccion3 = new JComboBox<>();
    Seleccion4 = new JComboBox<>();
    Seleccion5 = new JComboBox<>();
    
    //Seccion "Modificar"
    
    InicioSesionMod = new JLabel();
    ISUsuarioMod = new JLabel();
    ISContraMod = new JLabel();
    SeleccionEquipoMod = new JLabel();
    SEspecificacionMod = new JLabel();
    STipoMod = new JLabel();
    SSedeMod = new JLabel();
    SPisoMod = new JLabel();
    UsuarioTxtMod = new JTextArea();
    ContraTxtMod = new JPasswordField();
    jScrollPane1Mod = new JScrollPane();
    jScrollPane2Mod = new JScrollPane();
    Seleccion1Mod = new JComboBox<>();
    Seleccion2Mod = new JComboBox<>();
    Seleccion3Mod = new JComboBox<>();
    Seleccion4Mod = new JComboBox<>();
    Seleccion5Mod = new JComboBox<>();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    Fondo.setBackground(new Color(0, 25, 128));

    PanelSuperior.setBackground(new Color(0, 25, 128));
PanelSuperior.setOpaque(true);

JPanel panelLogo = new JPanel(new GridBagLayout());
panelLogo.setBackground(Color.WHITE);
panelLogo.setPreferredSize(new Dimension(431, 100));
panelLogo.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

Logo = new JLabel();
Logo.setIcon(new ImageIcon(getClass().getResource("/GUI/Imagenes/logoxue.png")));
panelLogo.add(Logo);
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.weightx = 1.0;
gbc.weighty = 1.0;
gbc.anchor = GridBagConstraints.CENTER;

panelLogo.add(Logo, gbc);
    TContainer.setBackground(new Color(0, 25, 128));
    TContainer.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    TContainer1.setBackground(Color.RED);
    TContainer1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    TContainer2.setBackground(new Color(0, 51, 255));
    TContainer2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    TContainer3.setBackground(new Color(100, 153, 255));
    TContainer3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    Titulo.setFont(new Font("Arial", Font.BOLD, 48));
    Titulo.setText("LABORATORIO MARKETING");
    GroupLayout TContainer3Layout = new GroupLayout(TContainer3);
TContainer3.setLayout(TContainer3Layout);
TContainer3Layout.setHorizontalGroup(
    TContainer3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(TContainer3Layout.createSequentialGroup()
        .addGap(20, 20, 20)  
        .addComponent(Titulo, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE) 
        .addContainerGap(200, Short.MAX_VALUE)));
TContainer3Layout.setVerticalGroup(
    TContainer3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(TContainer3Layout.createSequentialGroup()
        .addGap(5, 5, 5)  
        .addComponent(Titulo, GroupLayout.DEFAULT_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
);

    GroupLayout TContainer2Layout = new GroupLayout(TContainer2);
    TContainer2.setLayout(TContainer2Layout);
    TContainer2Layout.setHorizontalGroup(
        TContainer2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(TContainer2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TContainer3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    TContainer2Layout.setVerticalGroup(
        TContainer2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(TContainer2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TContainer3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    GroupLayout TContainer1Layout = new GroupLayout(TContainer1);
    TContainer1.setLayout(TContainer1Layout);
    TContainer1Layout.setHorizontalGroup(
        TContainer1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(TContainer1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TContainer2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    TContainer1Layout.setVerticalGroup(
        TContainer1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(TContainer1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TContainer2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    GroupLayout TContainerLayout = new GroupLayout(TContainer);
    TContainer.setLayout(TContainerLayout);
    TContainerLayout.setHorizontalGroup(
        TContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, TContainerLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TContainer1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    TContainerLayout.setVerticalGroup(
        TContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(TContainerLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TContainer1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
GroupLayout PanelSuperiorLayout = new GroupLayout(PanelSuperior);
PanelSuperior.setLayout(PanelSuperiorLayout);
PanelSuperiorLayout.setHorizontalGroup(
    PanelSuperiorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(PanelSuperiorLayout.createSequentialGroup()
        .addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(TContainer, GroupLayout.PREFERRED_SIZE, 1090, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(10, Short.MAX_VALUE))
);
PanelSuperiorLayout.setVerticalGroup(
    PanelSuperiorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addComponent(panelLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    .addComponent(TContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
);
    ContainerLateral.setBackground(new Color(0, 50, 150));
    ContainerLateral.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    ContainerLateral1.setBackground(Color.RED);
    ContainerLateral1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    ContainerLateral2.setBackground(new Color(0, 50, 255));
    ContainerLateral2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    BtnRegistrar.setBackground(new Color(100, 153, 255));
    BtnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
    BtnRegistrar.setText("Registrar Reserva");
    BtnRegistrar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    BtnModificar.setBackground(new Color(100, 153, 255));
    BtnModificar.setFont(new Font("Arial", Font.BOLD, 12));
    BtnModificar.setText("Modificar Reserva");
    BtnModificar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    BtnListado.setBackground(new Color(100, 153, 255));
    BtnListado.setFont(new Font("Arial", Font.BOLD, 12));
    BtnListado.setText("Listado");
    BtnListado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    BtnRegistroUsuario.setBackground(new Color(100, 153, 255));
    BtnRegistroUsuario.setFont(new Font("Arial", Font.BOLD, 12));
    BtnRegistroUsuario.setText("Listado");
    BtnRegistroUsuario.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    GroupLayout ContainerLateral2Layout = new GroupLayout(ContainerLateral2);
    ContainerLateral2.setLayout(ContainerLateral2Layout);
    ContainerLateral2Layout.setHorizontalGroup(
        ContainerLateral2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, ContainerLateral2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(ContainerLateral2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(BtnRegistroUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnRegistrar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnModificar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnListado, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    ContainerLateral2Layout.setVerticalGroup(
        ContainerLateral2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(ContainerLateral2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(BtnRegistrar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(BtnModificar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(BtnListado, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
            .addComponent(BtnRegistroUsuario, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    GroupLayout ContainerLateral1Layout = new GroupLayout(ContainerLateral1);
    ContainerLateral1.setLayout(ContainerLateral1Layout);
    ContainerLateral1Layout.setHorizontalGroup(
        ContainerLateral1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(ContainerLateral1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(ContainerLateral2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    ContainerLateral1Layout.setVerticalGroup(
        ContainerLateral1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(ContainerLateral1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(ContainerLateral2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    GroupLayout ContainerLateralLayout = new GroupLayout(ContainerLateral);
    ContainerLateral.setLayout(ContainerLateralLayout);
    ContainerLateralLayout.setHorizontalGroup(
        ContainerLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(ContainerLateralLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(ContainerLateral1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    ContainerLateralLayout.setVerticalGroup(
        ContainerLateralLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(ContainerLateralLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(ContainerLateral1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    AreaPrincipal.setBackground(new Color(0, 50, 155));
    AreaPrincipal.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    AP1.setBackground(Color.RED);
    AP1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    AP2.setBackground(new Color(0, 50, 255));
    AP2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    cardLayout = new CardLayout();
    AP2.setLayout(cardLayout);

    GroupLayout AP1Layout = new GroupLayout(AP1);
    AP1.setLayout(AP1Layout);
    AP1Layout.setHorizontalGroup(
        AP1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(AP1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(AP2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    AP1Layout.setVerticalGroup(
        AP1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(AP1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(AP2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    GroupLayout AreaPrincipalLayout = new GroupLayout(AreaPrincipal);
    AreaPrincipal.setLayout(AreaPrincipalLayout);
    AreaPrincipalLayout.setHorizontalGroup(
        AreaPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(AreaPrincipalLayout.createSequentialGroup()
            .addContainerGap(20,20)
            .addComponent(AP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap(20,20))
    );
    AreaPrincipalLayout.setVerticalGroup(
        AreaPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(AreaPrincipalLayout.createSequentialGroup()
            .addContainerGap(20,20)
            .addComponent(AP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap(20,20))
    );

    GroupLayout FondoLayout = new GroupLayout(Fondo);
    Fondo.setLayout(FondoLayout);
    FondoLayout.setHorizontalGroup(
        FondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(PanelSuperior, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(FondoLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(ContainerLateral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(AreaPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
    );
    FondoLayout.setVerticalGroup(
        FondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(FondoLayout.createSequentialGroup()
            .addComponent(PanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(FondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(ContainerLateral, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AreaPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(Fondo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(Fondo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
        btnModificarReserva = new JButton("Modificar Reserva");
        btnModificarReserva.setBackground(new Color(0, 51, 255));
        btnModificarReserva.setForeground(Color.WHITE);
        btnModificarReserva.setFont(new Font("Arial", Font.BOLD, 14));
        btnModificarReserva.setFocusPainted(false);
        btnModificarReserva.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    pack();
    setLocationRelativeTo(null);
}
     private void configurarContenedoresTitulo() {
        TContainer.setBackground(new Color(0, 25, 128));
        TContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        
        TContainer1.setBackground(Color.RED);
        TContainer1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        
        TContainer2.setBackground(new Color(0, 51, 255));
        TContainer2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        
        TContainer3.setBackground(new Color(100, 153, 255));
        TContainer3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        
        Titulo.setFont(new Font("Arial", Font.BOLD, 48));
        Titulo.setText("LABORATORIO MARKETING");
        TContainer3.add(Titulo);
    }
     private void configurarPanelLateral() {
        ContainerLateral.setBackground(new Color(0, 50, 150));
        ContainerLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        ContainerLateral.setLayout(new BoxLayout(ContainerLateral, BoxLayout.Y_AXIS));
        
        BtnRegistrar = crearBoton("Registrar Reserva");
        BtnModificar = crearBoton("Modificar Reserva");
        BtnListado = crearBoton("Listado");
        BtnRegistroUsuario = crearBoton("Listado");
        
        ContainerLateral.add(Box.createVerticalStrut(10));
        ContainerLateral.add(BtnRegistrar);
        ContainerLateral.add(Box.createVerticalStrut(10));
        ContainerLateral.add(BtnModificar);
        ContainerLateral.add(Box.createVerticalStrut(10));
        ContainerLateral.add(BtnListado);
        ContainerLateral.add(Box.createVerticalStrut(10));
        ContainerLateral.add(BtnRegistroUsuario);
    }
      private void configurarCardLayout() {
        cardLayout = new CardLayout();
        AP2.setLayout(cardLayout);
    }

    

    private void configurarLayouts() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Fondo.setLayout(new BorderLayout(0, 0));
        Fondo.add(PanelSuperior, BorderLayout.NORTH);
        Fondo.add(ContainerLateral, BorderLayout.WEST);
        Fondo.add(AreaPrincipal, BorderLayout.CENTER);

        AreaPrincipal.setLayout(new BorderLayout(0, 0));
        AreaPrincipal.add(AP1, BorderLayout.NORTH);
        AreaPrincipal.add(AP2, BorderLayout.CENTER);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(100, 153, 255));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        
        JLabel loginTitle = new JLabel("Inicio de Sesión");
        loginTitle.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(loginTitle);
        
        return panel;
    }
    private JButton crearBoton(String texto) {
    JButton boton = new JButton(texto);
    boton.setBackground(new Color(100, 153, 255));
    boton.setForeground(Color.BLACK);
    boton.setFont(new Font("Arial", Font.BOLD, 12));
    boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
    boton.setPreferredSize(new Dimension(150, 70));
    boton.setMaximumSize(new Dimension(150, 70));
    return boton;
}

private void configurarBotones() {
    BtnRegistrar.addActionListener(e -> {
        cardLayout.show(AP2, "registro");
        resetearCampos();
        AP2.revalidate();
        AP2.repaint();
    });
    
    BtnModificar.addActionListener(e -> {
        cardLayout.show(AP2, "modificar");
        resetearCamposModificar();
        AP2.revalidate();
        AP2.repaint();
    });
    
    BtnListado.addActionListener(e -> {
        actualizarTablaReservas((DefaultTableModel) TablaReservas.getModel());
        cardLayout.show(AP2, "Listado");
        AP2.revalidate();
        AP2.repaint();
    });
    
    BtnRegistroUsuario.setText("Registrarse"); 
    BtnRegistroUsuario.addActionListener(e -> {
        cardLayout.show(AP2, "registroUsuario");
        AP2.revalidate();
        AP2.repaint();
    });

    BtnRegistrar.setBackground(new Color(100, 153, 255));
    BtnRegistrar.setForeground(Color.BLACK);
    BtnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
    BtnRegistrar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
    BtnRegistrar.setPreferredSize(new Dimension(150, 70));
    BtnRegistrar.setMaximumSize(new Dimension(150, 70));

    BtnModificar.setBackground(new Color(100, 153, 255));
    BtnModificar.setForeground(Color.BLACK);
    BtnModificar.setFont(new Font("Arial", Font.BOLD, 12));
    BtnModificar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
    BtnModificar.setPreferredSize(new Dimension(150, 70));
    BtnModificar.setMaximumSize(new Dimension(150, 70));

    BtnListado.setBackground(new Color(100, 153, 255));
    BtnListado.setForeground(Color.BLACK);
    BtnListado.setFont(new Font("Arial", Font.BOLD, 12));
    BtnListado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
    BtnListado.setPreferredSize(new Dimension(150, 70));
    BtnListado.setMaximumSize(new Dimension(150, 70));

    BtnRegistroUsuario.setBackground(new Color(100, 153, 255));
    BtnRegistroUsuario.setForeground(Color.BLACK);
    BtnRegistroUsuario.setFont(new Font("Arial", Font.BOLD, 12));
    BtnRegistroUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
    BtnRegistroUsuario.setPreferredSize(new Dimension(150, 70));
    BtnRegistroUsuario.setMaximumSize(new Dimension(150, 70));
}

private void resetOptions() {
    Seleccion1.setSelectedIndex(0);
    Seleccion2.removeAllItems();
    Seleccion2.addItem("Seleccione...");
    Seleccion3.removeAllItems();
    Seleccion3.addItem("Seleccione...");
    Seleccion4.setSelectedIndex(0);
    Seleccion5.setSelectedIndex(0);
    
    Seleccion1Mod.setSelectedIndex(0);
    Seleccion2Mod.removeAllItems();
    Seleccion2Mod.addItem("Seleccione...");
    Seleccion3Mod.removeAllItems();
    Seleccion3Mod.addItem("Seleccione...");
    Seleccion4Mod.setSelectedIndex(0);
    Seleccion5Mod.setSelectedIndex(0);
}

private void configurarPanelRegistro() {
    panelRegistro = new JPanel();
    panelRegistro.setBackground(new Color(0, 51, 255));
    panelRegistro.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    
    JPanel panelLogin = crearPanelLogin();
    JPanel panelEquipo = crearPanelEquipo();
    JPanel panelUbicacion = crearPanelUbicacion();
    
    Dimension panelSize = new Dimension(320, 350);
    panelLogin.setPreferredSize(panelSize);
    panelEquipo.setPreferredSize(panelSize);
    panelUbicacion.setPreferredSize(panelSize);
    
    JPanel contenedorHorizontal = new JPanel(new GridBagLayout());
    contenedorHorizontal.setBackground(new Color(0, 51, 255));
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(10, 10, 10, 10); // Espaciado uniforme
        gbc.gridx = 0;
    contenedorHorizontal.add(panelLogin, gbc);
    
    gbc.gridx = 1;
    contenedorHorizontal.add(panelEquipo, gbc);
    
    gbc.gridx = 2;
    contenedorHorizontal.add(panelUbicacion, gbc);
    
    panelRegistro.setLayout(new BorderLayout());
    panelRegistro.add(contenedorHorizontal, BorderLayout.CENTER);
    
    AP2.add(panelRegistro, "registro");
}

private JPanel crearPanelLogin() {
    JPanel panel = new JPanel();
    panel.setBackground(new Color(100, 153, 255));
    panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    panel.setPreferredSize(new Dimension(320, 250));  
    InicioSesion = new JLabel("Inicio de Sesion:");
    ISUsuario = new JLabel("Ingrese Su Usuario:");
    ISContra = new JLabel("Ingrese la Contraseña:");
    
    InicioSesion.setFont(new Font("Arial", Font.BOLD, 24));
    ISUsuario.setFont(new Font("Arial", Font.BOLD, 18));
    ISContra.setFont(new Font("Arial", Font.BOLD, 18));
    
    UsuarioTxt = new JTextArea();
    ContraTxt = new JPasswordField();
    jScrollPane1.setViewportView(UsuarioTxt);
    jScrollPane2.setViewportView(ContraTxt);
    
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(20)  
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(InicioSesion)
                .addComponent(ISUsuario)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(ISContra)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    
    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGap(15) 
        .addComponent(InicioSesion)
        .addGap(15)
        .addComponent(ISUsuario)
        .addGap(5)
        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addGap(15)
        .addComponent(ISContra)
        .addGap(5)
        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addContainerGap()
    );
    
    return panel;
}


private JPanel crearPanelEquipo() {
    JPanel panel = new JPanel();
    panel.setBackground(new Color(100, 153, 255));
    panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    panel.setPreferredSize(new Dimension(320, 250));
    
    SeleccionEquipo = new JLabel("Seleccione un Tipo de Equipo:");
    SEspecificacion = new JLabel("Seleccione una Especificacion:");
    STipo = new JLabel("Seleccione un Tipo(Si Corresponde)");
    
    SeleccionEquipo.setFont(new Font("Arial", Font.BOLD, 18));
    SEspecificacion.setFont(new Font("Arial", Font.BOLD, 18));
    STipo.setFont(new Font("Arial", Font.BOLD, 14));
    
    Seleccion1 = new JComboBox<>(new String[]{"Seleccione...", "Computador", "Impresora", "Cámara", "Equipo de Grabación", "Espacio de Grabación"});
    Seleccion2 = new JComboBox<>(new String[]{"Seleccione..."});
    Seleccion3 = new JComboBox<>(new String[]{"Seleccione..."});
    
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(20)  
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(SeleccionEquipo)
                .addComponent(Seleccion1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(SEspecificacion)
                .addComponent(Seleccion2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(STipo)
                .addComponent(Seleccion3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    
    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGap(15)  
        .addComponent(SeleccionEquipo)
        .addGap(5)
        .addComponent(Seleccion1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addGap(15)
        .addComponent(SEspecificacion)
        .addGap(5)
        .addComponent(Seleccion2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addGap(15)
        .addComponent(STipo)
        .addGap(5)
        .addComponent(Seleccion3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    ;
    
    return panel;
}
    private JPanel crearPanelUbicacion() {
    JPanel panel = new JPanel();
    panel.setBackground(new Color(100, 153, 255));
    panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    panel.setPreferredSize(new Dimension(320, 250));
    
    SSede = new JLabel("Seleccione la Sede:");
    SPiso = new JLabel("Seleccione el Piso:");
    JLabel HorarioEspecifico = new JLabel("Elija Numero de Horas:");
    
    SSede.setFont(new Font("Arial", Font.BOLD, 18));
    SPiso.setFont(new Font("Arial", Font.BOLD, 18));
    HorarioEspecifico.setFont(new Font("Arial", Font.BOLD, 18));
    
    Seleccion4 = new JComboBox<>(new String[]{
        "Seleccione...", "Sede 1", "Sede 2", "Sede 3", "Sede 4", "Sede 5", "Sede 6", "Sede 7"
    });
    
    Seleccion5 = new JComboBox<>(new String[]{
        "Seleccione...", "Piso 1", "Piso 2", "Piso 3"
    });
    
    horasComboBox = new JComboBox<>(new String[]{
        "Seleccione...", "1 Hora", "2 Horas", "3 Horas", "4 Horas", "5 Horas", "6 Horas", "7 Horas", "8 Horas"
    });
    
    btnRegistrarEquipo = new JButton("Registrar Equipo");
    btnRegistrarEquipo.setBackground(new Color(0, 51, 255));
    btnRegistrarEquipo.setForeground(Color.WHITE);
    btnRegistrarEquipo.setFont(new Font("Arial", Font.BOLD, 14));
    btnRegistrarEquipo.setPreferredSize(new Dimension(250, 30));
    btnRegistrarEquipo.setFocusPainted(false);
    btnRegistrarEquipo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    
    btnRegistrarEquipo.addActionListener(e -> {
        registrarEquipo();
    });
    
    Seleccion4.setPreferredSize(new Dimension(250, 30));
    Seleccion5.setPreferredSize(new Dimension(250, 30));
    horasComboBox.setPreferredSize(new Dimension(250, 30));
    
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(20) 
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(SSede)
                .addComponent(Seleccion4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(SPiso)
                .addComponent(Seleccion5, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(HorarioEspecifico)
                .addComponent(horasComboBox, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnRegistrarEquipo, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(20, Short.MAX_VALUE))
    );
    
    // Configuración vertical
    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGap(15) 
        .addComponent(SSede)
        .addGap(5)
        .addComponent(Seleccion4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addGap(15)
        .addComponent(SPiso)
        .addGap(5)
        .addComponent(Seleccion5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addGap(15)
        .addComponent(HorarioEspecifico)
        .addGap(5)
        .addComponent(horasComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addGap(15)
        .addComponent(btnRegistrarEquipo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(15, Short.MAX_VALUE)
    );
    
    return panel;
}
    private void registrarEquipo() {
  
    String usuario = UsuarioTxt.getText().trim();
    String contraseña = new String(ContraTxt.getPassword()).trim();
    String horasSeleccionadas = horasComboBox.getSelectedItem().toString();

    if (usuario.isEmpty() || contraseña.isEmpty() || 
        horasSeleccionadas.equals("Seleccione...")) {
        
        JOptionPane.showMessageDialog(this, 
            "Por favor complete todos los campos obligatorios incluyendo las horas",
            "Error de validación",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (Seleccion1.getSelectedIndex() == 0 || 
        Seleccion2.getSelectedIndex() == 0 || 
        Seleccion4.getSelectedIndex() == 0 || 
        Seleccion5.getSelectedIndex() == 0) {
        
        JOptionPane.showMessageDialog(this,
            "Por favor complete todos los campos obligatorios",
            "Error de validación",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        if (!controlador.validarUsuario(usuario, contraseña)) {
            JOptionPane.showMessageDialog(this,
                "Credenciales inválidas",
                "Error de autenticación",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        int horas = Integer.parseInt(horasSeleccionadas.split(" ")[0]);

        controlador.registrarEquipo(
            usuario,
            Seleccion1.getSelectedItem().toString(),
            Seleccion2.getSelectedItem().toString(),
            Seleccion3.getSelectedItem().toString().equals("Seleccione...") ? "" : Seleccion3.getSelectedItem().toString(),
            Seleccion4.getSelectedItem().toString(),
            Seleccion5.getSelectedItem().toString(),
            horas
        );
        
        resetearCampos();
        
        JOptionPane.showMessageDialog(this,
            "Equipo y reserva registrados exitosamente por " + horas + " hora(s)",
            "Registro exitoso",
            JOptionPane.INFORMATION_MESSAGE);
            
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al registrar el equipo: " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
private void registrarEquipo(String equipo, String tipoObjeto, String ubicacion) {
    try {
        EquiposHerramientas nuevoEquipo = new EquiposHerramientas();
        nuevoEquipo.setEquipo(equipo);
        nuevoEquipo.setTipoObjeto(tipoObjeto);
        nuevoEquipo.setUbicacion(ubicacion);
        nuevoEquipo.setEstado(true);
        
        String horasSeleccionadas = (String) horasComboBox.getSelectedItem();
        nuevoEquipo.setTypeacc(horasSeleccionadas);

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nuevoEquipo);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(this,
                "Equipo registrado exitosamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(this,
                "Error al registrar el equipo: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error inesperado: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

private void actualizarTablaEquipos(DefaultTableModel modelo) {
    modelo.setRowCount(0);
    
    EntityManager em = emf.createEntityManager();
    try {
        List<EquiposHerramientas> equipos = em.createQuery(
            "SELECT e FROM EquiposHerramientas e", 
            EquiposHerramientas.class)
            .getResultList();
        
        for (EquiposHerramientas equipo : equipos) {
            modelo.addRow(new Object[]{
                equipo.getId(),
                equipo.getEquipo(),
                equipo.getTipoObjeto(),
                equipo.getUbicacion(),
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error al cargar los equipos: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    } finally {
        em.close();
    }
}

private void configurarPanelModificar() {
    JPanel panelModificacion = new JPanel();
    panelModificacion.setBackground(new Color(0, 51, 255));
    panelModificacion.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    
    JPanel panelLogin = crearPanelLoginModificar();
    JPanel panelEquipo = crearPanelEquipoModificar();
    JPanel panelUbicacion = crearPanelUbicacionModificar();
    
    Dimension panelSize = new Dimension(320, 250);
    panelLogin.setPreferredSize(panelSize);
    panelEquipo.setPreferredSize(panelSize);
    panelUbicacion.setPreferredSize(panelSize);
    
    JPanel contenedorHorizontal = new JPanel();
    contenedorHorizontal.setBackground(new Color(0, 51, 255));
    contenedorHorizontal.setLayout(new GridBagLayout());
    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(5, 5, 5, 5);
    
    contenedorHorizontal.add(panelLogin, gbc);
    
    gbc.gridx = 1;
    contenedorHorizontal.add(panelEquipo, gbc);
    
    gbc.gridx = 2;
    contenedorHorizontal.add(panelUbicacion, gbc);
    
    panelModificacion.setLayout(new BorderLayout());
    panelModificacion.add(contenedorHorizontal, BorderLayout.CENTER);
    
    AP2.add(panelModificacion, "modificar");
}
private JPanel crearPanelLoginModificar() {
    JPanel panel = new JPanel();
    panel.setBackground(new Color(100, 153, 255));
    panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    
    InicioSesionMod.setFont(new Font("Arial", Font.BOLD, 24));
    InicioSesionMod.setText("Inicio de Sesion:");
    ISUsuarioMod.setFont(new Font("Arial", Font.BOLD, 18));
    ISUsuarioMod.setText("Ingrese Su Usuario:");
    ISContraMod.setFont(new Font("Arial", Font.BOLD, 18));
    ISContraMod.setText("Ingrese la Contraseña:");
    
    jScrollPane1Mod.setViewportView(UsuarioTxtMod);
    jScrollPane2Mod.setViewportView(ContraTxtMod);
    
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(InicioSesionMod)
                .addComponent(ISUsuarioMod)
                .addComponent(jScrollPane1Mod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(ISContraMod)
                .addComponent(jScrollPane2Mod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    
    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(InicioSesionMod)
        .addGap(20)
        .addComponent(ISUsuarioMod)
        .addGap(5)
        .addComponent(jScrollPane1Mod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addGap(20)
        .addComponent(ISContraMod)
        .addGap(5)
        .addComponent(jScrollPane2Mod, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    
    return panel;
}

private JPanel crearPanelEquipoModificar() {
    JPanel panel = new JPanel();
    panel.setBackground(new Color(100, 153, 255));
    panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    
    SeleccionEquipoMod = new JLabel("Seleccione un Tipo de Equipo:");
    SEspecificacionMod = new JLabel("Seleccione una Especificacion:");
    STipoMod = new JLabel("Seleccione un Tipo(Si Corresponde)");
    
    SeleccionEquipoMod.setFont(new Font("Arial", Font.BOLD, 18));
    SEspecificacionMod.setFont(new Font("Arial", Font.BOLD, 18));
    STipoMod.setFont(new Font("Arial", Font.BOLD, 14));
    
    String[] equipos = {"Seleccione...", "Computador", "Impresora", "Cámara", "Equipo de Grabación", "Espacio de Grabación"};
    Seleccion1Mod = new JComboBox<>(equipos);
    Seleccion2Mod = new JComboBox<>();
    Seleccion3Mod = new JComboBox<>();
    
    Seleccion2Mod.addItem("Seleccione...");
    Seleccion3Mod.addItem("Seleccione...");
    
    Seleccion1Mod.addActionListener(e -> {
        actualizarEspecificaciones(
            Seleccion1Mod.getSelectedItem().toString(),
            Seleccion2Mod,
            Seleccion3Mod
        );
    });
    
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(SeleccionEquipoMod)
                .addComponent(Seleccion1Mod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(SEspecificacionMod)
                .addComponent(Seleccion2Mod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(STipoMod)
                .addComponent(Seleccion3Mod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    
    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(SeleccionEquipoMod)
        .addGap(10)
        .addComponent(Seleccion1Mod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(20)
        .addComponent(SEspecificacionMod)
        .addGap(10)
        .addComponent(Seleccion2Mod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(20)
        .addComponent(STipoMod)
        .addGap(10)
        .addComponent(Seleccion3Mod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    
    return panel;
}

private JPanel crearPanelUbicacionModificar() {
    JPanel panel = new JPanel();
    panel.setBackground(new Color(100, 153, 255));
    panel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    
    JLabel mensajeModificacion = new JLabel("Por Favor Solo Modifique Las Opciones Que Correspondan");
    mensajeModificacion.setFont(new Font("Arial", Font.BOLD, 14));
    
    SSedeMod = new JLabel("Seleccione la Sede:");
    SPisoMod = new JLabel("Seleccione el Piso:");
    JLabel HorarioEspecificoMod = new JLabel("Elija Numero de Horas:");
    
    SSedeMod.setFont(new Font("Arial", Font.BOLD, 18));
    SPisoMod.setFont(new Font("Arial", Font.BOLD, 18));
    HorarioEspecificoMod.setFont(new Font("Arial", Font.BOLD, 18));
    
    Seleccion4Mod = new JComboBox<>(new String[]{
        "Seleccione...", "Sede 1", "Sede 2", "Sede 3", "Sede 4", "Sede 5","Sede 6","Sede 7"
    });
    
    Seleccion5Mod = new JComboBox<>(new String[]{
        "Seleccione...", "Piso 1", "Piso 2", "Piso 3"
    });
    
    horasComboBoxMod = new JComboBox<>(new String[]{
        "Seleccione...", "1 Hora", "2 Horas", "3 Horas", "4 Horas","5 Horas","6 Horas","7 Horas","8 Horas"
    });

    JButton btnModificarReserva = new JButton("Modificar Reserva");
    btnModificarReserva.setBackground(new Color(0, 51, 255));
    btnModificarReserva.setForeground(Color.WHITE);
    btnModificarReserva.setFont(new Font("Arial", Font.BOLD, 14));
    btnModificarReserva.setFocusPainted(false);
    btnModificarReserva.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    
    btnModificarReserva.addActionListener(e -> {
        modificarReserva();
    });
    
    GroupLayout layout = new GroupLayout(panel);
    panel.setLayout(layout);
    
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(mensajeModificacion)
                .addComponent(SSedeMod)
                .addComponent(Seleccion4Mod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(SPisoMod)
                .addComponent(Seleccion5Mod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(HorarioEspecificoMod)
                .addComponent(horasComboBoxMod, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnModificarReserva, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(53, Short.MAX_VALUE))
    );
    
    layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(mensajeModificacion)
        .addGap(12)
        .addComponent(SSedeMod)
        .addGap(10)
        .addComponent(Seleccion4Mod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(20)
        .addComponent(SPisoMod)
        .addGap(10)
        .addComponent(Seleccion5Mod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(20)
        .addComponent(HorarioEspecificoMod)
        .addGap(10)
        .addComponent(horasComboBoxMod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addGap(20)
        .addComponent(btnModificarReserva, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    
    Seleccion4Mod.addActionListener(e -> {
    });
    
    Seleccion5Mod.addActionListener(e -> {
    });
    
    horasComboBoxMod.addActionListener(e -> {
    });
    
    return panel;
}
private void configurarPanelRegistroUsuario() {
    panelRegistroUsuario = new JPanel();
    panelRegistroUsuario.setBackground(new Color(100, 153, 255));
    panelRegistroUsuario.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    
    JLabel lblBienvenida = new JLabel("Bienvenido Por Favor Registre Su Usuario");
    lblBienvenida.setFont(new Font("Arial", Font.BOLD, 24));
    
    JLabel lblNombres = new JLabel("Ingrese Sus Nombres");
    JLabel lblApellidos = new JLabel("Ingrese Sus Apellidos");
    JLabel lblContraseña = new JLabel("Contraseña");
    JLabel lblEdad = new JLabel("Edad (Años)");
    JLabel lblTipoIngreso = new JLabel("Seleccione Su Ingreso");
    
    JTextField txtNombres = new JTextField();
    JTextField txtApellidos = new JTextField();
    JPasswordField txtContraseña = new JPasswordField();
    JComboBox<Integer> cmbEdad = new JComboBox<>();
    JComboBox<String> cmbTipoIngreso = new JComboBox<>(new String[]{"Seleccione...", "Estudiante", "Profesor", "Administrativo"});
    
    for(int i = 5; i <= 100; i++) {
        cmbEdad.addItem(i);
    }
    
    JButton btnRegistrar = new JButton("Registrar");
    btnRegistrar.setBackground(new Color(0, 51, 255));
    btnRegistrar.setForeground(Color.WHITE);
    btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
    
    GroupLayout layout = new GroupLayout(panelRegistroUsuario);
    panelRegistroUsuario.setLayout(layout);
    
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(lblBienvenida)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombres)
                    .addComponent(lblApellidos)
                    .addComponent(lblContraseña)
                    .addComponent(lblEdad)
                    .addComponent(lblTipoIngreso))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombres, 200, 200, 200)
                    .addComponent(txtApellidos, 200, 200, 200)
                    .addComponent(txtContraseña, 200, 200, 200)
                    .addComponent(cmbEdad, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoIngreso, 200, 200, 200)))
            .addComponent(btnRegistrar)
    );
    
    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addComponent(lblBienvenida)
            .addGap(20)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNombres)
                .addComponent(txtNombres))
            .addGap(15)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblApellidos)
                .addComponent(txtApellidos))
            .addGap(15)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblContraseña)
                .addComponent(txtContraseña))
            .addGap(15)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblEdad)
                .addComponent(cmbEdad))
            .addGap(15)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblTipoIngreso)
                .addComponent(cmbTipoIngreso))
            .addGap(25)
            .addComponent(btnRegistrar)
    );
    
   btnRegistrar.addActionListener(e -> {
        String nombres = txtNombres.getText().trim();
        String apellidos = txtApellidos.getText().trim();
        String contraseña = new String(txtContraseña.getPassword()).trim();
        Integer edad = (Integer) cmbEdad.getSelectedItem();
        String tipoIngreso = (String) cmbTipoIngreso.getSelectedItem();

        if (nombres.isEmpty() || apellidos.isEmpty() || contraseña.isEmpty() || 
            tipoIngreso.equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this,
                "Por favor complete todos los campos",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            controlador.registrarUsuario(nombres, apellidos, contraseña, tipoIngreso, edad);
            
            String username = apellidos.toLowerCase().replaceAll("\\s+", "");
            JOptionPane.showMessageDialog(this,
                "Usuario registrado exitosamente\nSu nombre de usuario es: " + username,
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE);

            txtNombres.setText("");
            txtApellidos.setText("");
            txtContraseña.setText("");
            cmbEdad.setSelectedIndex(0);
            cmbTipoIngreso.setSelectedIndex(0);

            cardLayout.show(AP2, "registro");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error al registrar usuario: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    });
    
    AP2.add(panelRegistroUsuario, "registroUsuario");
}

private String generarUsername(String apellidos) {
    EntityManager em = emf.createEntityManager();
    try {
        String apellidoSinEspacios = apellidos.replaceAll(" ", "");
        
        Long count = em.createQuery("SELECT COUNT(u) FROM User u", Long.class)
            .getSingleResult();
        Long nextId = count + 1;
        
        return apellidoSinEspacios + "#" + nextId;
    } finally {
        em.close();
    }
}

private void modificarReserva() {
    String usuario = UsuarioTxtMod.getText().trim();
    String contraseña = new String(ContraTxtMod.getPassword()).trim();
    String horasSeleccionadas = horasComboBoxMod.getSelectedItem().toString();

    if (usuario.isEmpty() || contraseña.isEmpty() || horasSeleccionadas.equals("Seleccione...") ||
        Seleccion1Mod.getSelectedIndex() == 0 || 
        Seleccion2Mod.getSelectedIndex() == 0 || 
        Seleccion4Mod.getSelectedIndex() == 0 || 
        Seleccion5Mod.getSelectedIndex() == 0) {
        
        JOptionPane.showMessageDialog(this,
            "Por favor complete todos los campos obligatorios",
            "Error de validación",
            JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            User user = em.createQuery(
                "SELECT u FROM User u WHERE u.user = :usuario", User.class)
                .setParameter("usuario", usuario)
                .getSingleResult();
                
            if (user == null || !user.getPassword().equals(contraseña)) {
                throw new Exception("Usuario o contraseña incorrectos");
            }
            
            String equipoSeleccionado = Seleccion1Mod.getSelectedItem().toString();
            String tipoSeleccionado = Seleccion2Mod.getSelectedItem().toString();
            String ubicacion = "Piso " + Seleccion5Mod.getSelectedItem().toString() + 
                             ", Sede " + Seleccion4Mod.getSelectedItem().toString();
            
            Long equiposReservados = em.createQuery(
                "SELECT COUNT(e) FROM EquiposHerramientas e WHERE " +
                "e.equipo = :equipo AND e.tipoObjeto = :tipo AND " +
                "e.ubicacion = :ubicacion AND " +
                "e.id IN (SELECT r.equipo.id FROM Reservas r WHERE r.user != :user)",
                Long.class)
                .setParameter("equipo", equipoSeleccionado)
                .setParameter("tipo", tipoSeleccionado)
                .setParameter("ubicacion", ubicacion)
                .setParameter("user", user)
                .getSingleResult();

            if (equiposReservados > 0) {
                throw new Exception("El equipo seleccionado no está disponible en esta ubicación");
            }
            
            Reservas reservaActual = em.createQuery(
                "SELECT r FROM Reservas r WHERE r.user = :user ORDER BY r.fechaReserva DESC",
                Reservas.class)
                .setParameter("user", user)
                .setMaxResults(1)
                .getSingleResult();
            
            EquiposHerramientas equipoNuevo = new EquiposHerramientas();
            equipoNuevo.setEquipo(equipoSeleccionado);
            equipoNuevo.setTipoObjeto(tipoSeleccionado);
            equipoNuevo.setUbicacion(ubicacion);
            
            String tipo = Seleccion3Mod.getSelectedItem().toString();
            if (!tipo.equals("Seleccione...")) {
                equipoNuevo.setTypeacc(tipo);
            }
            
            String horasNumero = horasSeleccionadas.split(" ")[0];
            equipoNuevo.setTypeacc(horasNumero);
            
            em.persist(equipoNuevo);
            
            reservaActual.setEquipo(equipoNuevo);
            em.merge(reservaActual);
            
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(this,
                "Reserva modificada exitosamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
            
            resetearCamposModificar();
            cardLayout.show(AP2, "registro");
            
        } catch (NoResultException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Usuario no encontrado o sin reservas activas");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new Exception("Error al modificar la reserva: " + e.getMessage());
        } finally {
            em.close();
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al modificar reserva: " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
private void configurarPanelListado() {
    JPanel panelListado = new JPanel(new BorderLayout());
    panelListado.setBackground(new Color(0, 50, 255));
    panelListado.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));

    DefaultTableModel modeloTabla = new DefaultTableModel(
        new Object[][] {},
        new String[] {
            "ID", 
            "ID Equipo", 
            "ID Usuario", 
            "Equipo", 
            "Tipo", 
            "Ubicación",
            "Fecha Reservación",   
            "Horas Reservadas"      
        }
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    TablaReservas = new JTable(modeloTabla);
    TablaReservas.setBackground(new Color(100, 153, 255));
    TablaReservas.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    TablaReservas.setFocusable(false);
    TablaReservas.setGridColor(Color.BLACK);
    TablaReservas.setShowGrid(true);
    TablaReservas.setSelectionBackground(new Color(0, 120, 215));
    TablaReservas.setSelectionForeground(Color.WHITE);
    TablaReservas.setRowHeight(25);
    TablaReservas.setFont(new Font("Arial", Font.PLAIN, 12));

    TablaReservas.getTableHeader().setBackground(new Color(0, 51, 255));
    TablaReservas.getTableHeader().setForeground(Color.WHITE);
    TablaReservas.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
    TablaReservas.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    TablaReservas.getTableHeader().setReorderingAllowed(false); 

    JScrollPane scrollPane = new JScrollPane(TablaReservas);
    scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3, true));
    scrollPane.getViewport().setBackground(new Color(100, 153, 255));
    
    JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
    panelSuperior.setBackground(new Color(0, 51, 255));
    JLabel titulo = new JLabel("Listado de Reservas");
    titulo.setFont(new Font("Arial", Font.BOLD, 24));
    titulo.setForeground(Color.WHITE);
    panelSuperior.add(titulo);

    panelListado.add(panelSuperior, BorderLayout.NORTH);
    panelListado.add(scrollPane, BorderLayout.CENTER);

    JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    panelInferior.setBackground(new Color(0, 51, 255));
    
    JButton btnActualizar = new JButton("Actualizar Lista");
    btnActualizar.setBackground(new Color(100, 153, 255));
    btnActualizar.setForeground(Color.BLACK);
    btnActualizar.setFont(new Font("Arial", Font.BOLD, 12));
    btnActualizar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    btnActualizar.setFocusPainted(false);
    btnActualizar.addActionListener(e -> actualizarTablaReservas(modeloTabla));
    
    panelInferior.add(btnActualizar);
    panelListado.add(panelInferior, BorderLayout.SOUTH);

    AP2.add(panelListado, "Listado");

    actualizarTablaReservas(modeloTabla);
}

private void actualizarTablaReservas(DefaultTableModel modelo) {
    modelo.setRowCount(0);
    
    EntityManager em = emf.createEntityManager();
    try {
        List<Reservas> reservas = em.createQuery(
            "SELECT r FROM Reservas r JOIN FETCH r.equipo e JOIN FETCH r.user u", 
            Reservas.class
        ).getResultList();
        
        for (Reservas reserva : reservas) {
            String horasFormateadas = (reserva.getDuracionHoras() != null) ? 
                                    reserva.getDuracionHoras() + " Hora(s)" : 
                                    "1 Hora"; 
            
            modelo.addRow(new Object[]{
                reserva.getId(),
                reserva.getEquipo().getId(),
                reserva.getUser().getId(),
                reserva.getEquipo().getEquipo(),
                reserva.getEquipo().getTipoObjeto(),
                reserva.getEquipo().getUbicacion(),
                reserva.getFechaReserva(),
                horasFormateadas
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error al cargar las reservas: " + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    } finally {
        em.close();
    }
}
private void aplicarEstiloBold(JLabel label, int size) {
    label.setFont(new Font("Arial", Font.BOLD, size));
}

public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PantallaUnificada().setVisible(true);
            }
        });
    }

    // Variables declaration
private JPanel panelRegistroUsuario;
private JLabel lblBienvenida;
private JLabel lblUsuario;
private JLabel lblContraseña;
private JTextField txtUsuario;
private JPasswordField txtContraseña;
private JButton btnRegistrar;
private JPanel AP1;
private JPanel AP2;
private JPanel AreaPrincipal;
private JButton BtnListado;
private JButton BtnModificar;
private JButton BtnRegistroUsuario;
private JButton BtnRegistrar;
private JPanel ContainerLateral;
private JPanel ContainerLateral1;
private JPanel ContainerLateral2;
private JPasswordField ContraTxt;
private JPanel Fondo;
private JLabel ISContra;
private JLabel ISUsuario;
private JLabel InicioSesion;
private JLabel Logo;
private JPanel PanelSuperior;
private JLabel SEspecificacion;
private JLabel SPiso;
private JLabel SSede;
private JLabel STipo;
private JComboBox<String> Seleccion1;
private JComboBox<String> Seleccion2;
private JComboBox<String> Seleccion3;
private JComboBox<String> Seleccion4;
private JComboBox<String> Seleccion5;
private JLabel SeleccionEquipo;
private JPanel TContainer;
private JPanel TContainer1;
private JPanel TContainer2;
private JPanel TContainer3;
private JLabel Titulo;
private JTextArea UsuarioTxt;
private JScrollPane jScrollPane1;
private JScrollPane jScrollPane2;
private JLabel InicioSesionMod;
private JLabel ISUsuarioMod;
private JLabel ISContraMod;
private JLabel SeleccionEquipoMod;
private JLabel SEspecificacionMod;
private JLabel STipoMod;
private JLabel SSedeMod;
private JLabel SPisoMod;
private JTextArea UsuarioTxtMod;
private JPasswordField ContraTxtMod;
private JScrollPane jScrollPane1Mod;
private JScrollPane jScrollPane2Mod;
private JComboBox<String> Seleccion1Mod;
private JComboBox<String> Seleccion2Mod;
private JComboBox<String> Seleccion3Mod;
private JComboBox<String> Seleccion4Mod;
private JComboBox<String> Seleccion5Mod;
private JComboBox<String> horasComboBox;
private JComboBox<String> horasComboBoxMod;
private JButton btnModificarReserva;
private JButton btnRegistrarEquipo;
private JTable TablaReservas;
    // End of variables declaration
}