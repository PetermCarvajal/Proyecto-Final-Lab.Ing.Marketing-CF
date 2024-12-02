package GUI.Imagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pantalla1 extends JFrame {

    private JComboBox<String> mainOptions;
    private JComboBox<String> subOptions;
    private JComboBox<String> typeOptions;
    private JComboBox<String> locationOptions;
    private JComboBox<String> floorOptions;
    private JButton BtnRegistrar;
    private JButton BtnModificar;
    private JButton BtnListas;
    private JButton BtnProximamente;
    private JTextField UsuarioTxt;
    private JPasswordField ContraTxt;
    private JPanel Fondo;
    private JPanel PanelSuperior;
    private JLabel Logo;
    private JPanel TContainer;
    private JPanel TContainer1;
    private JPanel TContainer2;
    private JPanel TContainer3;
    private JLabel Titulo;
    private JPanel ContainerLateral;
    private JPanel ContainerLateral1;
    private JPanel ContainerLateral2;
    private JPanel AreaPrincipal;
    private JPanel AP1;
    private JPanel AP2;
    private JPanel PanelCambiante;
    private JLabel ISUsuario;
    private JLabel InicioSesion;
    private JLabel ISContra;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel PC1;
    private JPanel PC2;
    private JLabel SeleccionEquipo;
    private JLabel SEspecificacion;
    private JLabel STipo;
    private JLabel SSede;
    private JLabel SPiso;
    private CardLayout cardLayout;

    public Pantalla1() {
        initComponents();
        setTitle("Laboratorio de Marketing");
        setSize(1550, 625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        Fondo = new JPanel();
    Fondo.setBackground(new Color(0, 25, 128));
    Fondo.setLayout(new BorderLayout());

    PanelSuperior = new JPanel();
    PanelSuperior.setBackground(Color.WHITE);
    PanelSuperior.setLayout(null);

    Logo = new JLabel(new ImageIcon(getClass().getResource("/GUI/Imagenes/logoxue.png")));
    Logo.setBounds(0, 20, 431, 127);
    PanelSuperior.add(Logo);

    TContainer = new JPanel();
    TContainer.setBackground(new Color(0, 25, 128));
    TContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer.setLayout(null);

    TContainer1 = new JPanel();
    TContainer1.setBackground(new Color(255, 0, 0));
    TContainer1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer1.setLayout(null);

    TContainer2 = new JPanel();
    TContainer2.setBackground(new Color(0, 51, 255));
    TContainer2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer2.setLayout(null);

    TContainer3 = new JPanel();
    TContainer3.setBackground(new Color(100, 153, 255));
    TContainer3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer3.setLayout(new BorderLayout());

    Titulo = new JLabel("LABORATORIO MARKETING", SwingConstants.CENTER);
    Titulo.setFont(new Font("Segoe UI", Font.BOLD, 48));
    Titulo.setForeground(Color.BLACK);

    TContainer3.add(Titulo, BorderLayout.CENTER);

    TContainer3.setBounds(10, 10, 1050, 105);
    TContainer2.setBounds(10, 10, 1070, 125);
    TContainer1.setBounds(10, 10, 1090, 145);
    TContainer.setBounds(427, -5, 1120, 165);

    TContainer2.add(TContainer3);
    TContainer1.add(TContainer2);
    TContainer.add(TContainer1);
    PanelSuperior.add(TContainer);
    PanelSuperior.setPreferredSize(new Dimension(300, 155));

    Fondo.add(PanelSuperior, BorderLayout.NORTH);

     ContainerLateral = new JPanel();
    ContainerLateral.setBackground(new Color(0, 50, 150));
    ContainerLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    ContainerLateral.setLayout(null);
    ContainerLateral.setBounds(0, 155, 200, 470);

    ContainerLateral1 = new JPanel();
    ContainerLateral1.setBackground(new Color(255, 0, 0));
    ContainerLateral1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    ContainerLateral1.setLayout(null);
    ContainerLateral1.setBounds(10, 10, 180, 450);

    ContainerLateral2 = new JPanel();
    ContainerLateral2.setBackground(new Color(0, 51, 255));
    ContainerLateral2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    ContainerLateral2.setLayout(null);
    ContainerLateral2.setBounds(10, 10, 160, 430);

    // Inicialización de los botones
    BtnRegistrar = new JButton("Registrar Reserva");
    BtnModificar = new JButton("Modificar Reserva");
    BtnListas = new JButton("Listar Reservas");


    // Añadir botones al ContainerLateral2
    ContainerLateral2.add(BtnRegistrar);
    ContainerLateral2.add(BtnModificar);
    ContainerLateral2.add(BtnListas);

    // Añadir ContainerLateral2 a ContainerLateral1
    ContainerLateral1.add(ContainerLateral2, BorderLayout.CENTER);
    ContainerLateral.add(ContainerLateral1, BorderLayout.CENTER);

    Fondo.add(ContainerLateral, BorderLayout.WEST);

        AreaPrincipal = new JPanel();
        AreaPrincipal.setBackground(new Color(0, 50, 150));
        AreaPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

        AP1 = new JPanel();
        AP1.setBackground(new Color(255, 0, 0));
        AP1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

        AP2 = new JPanel();
        AP2.setBackground(new Color(0, 51, 255));
        AP2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

        PanelCambiante = new JPanel();
        PanelCambiante.setBackground(new Color(100, 153, 255));
        PanelCambiante.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

        ISUsuario = new JLabel("Ingrese Su Usuario:");
        ISUsuario.setFont(new Font("Segoe UI", Font.BOLD, 18));

        InicioSesion = new JLabel("Inicio de Sesion:");
        InicioSesion.setFont(new Font("Segoe UI", Font.BOLD, 24));

        ISContra = new JLabel("Ingrese la Contraseña:");
        ISContra.setFont(new Font("Segoe UI", Font.BOLD, 18));

        UsuarioTxt = new JTextField(20);
        jScrollPane1 = new JScrollPane(UsuarioTxt);

        ContraTxt = new JPasswordField(20);
        jScrollPane2 = new JScrollPane(ContraTxt);

        GroupLayout PanelCambianteLayout = new GroupLayout(PanelCambiante);
        PanelCambiante.setLayout(PanelCambianteLayout);
        PanelCambianteLayout.setHorizontalGroup(
            PanelCambianteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PanelCambianteLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelCambianteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(InicioSesion, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelCambianteLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(PanelCambianteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(ISUsuario, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelCambianteLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(PanelCambianteLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ISContra, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))))))
                    .addContainerGap(16, Short.MAX_VALUE))
        );
        PanelCambianteLayout.setVerticalGroup(
            PanelCambianteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PanelCambianteLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(InicioSesion)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(ISUsuario)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(ISContra)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(125, 125, 125))
        );

        PC1 = new JPanel();
        PC1.setBackground(new Color(100, 153, 255));
        PC1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

        SeleccionEquipo = new JLabel("Seleccione un Tipo de Equipo:");
        SeleccionEquipo.setFont(new Font("Segoe UI", Font.BOLD, 18));

        mainOptions = new JComboBox<>(new String[]{"Seleccione..", "Computadora", "Impresora", "Cámara", "Equipo de Grabación", "Espacio de Grabación"});
        mainOptions.setFont(new Font("Segoe UI", Font.BOLD, 12));
        mainOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mainOptionsActionPerformed(evt);
            }
        });

        SEspecificacion = new JLabel("Seleccione una Especificacion:");
        SEspecificacion.setFont(new Font("Segoe UI", Font.BOLD, 18));

        subOptions = new JComboBox<>(new String[]{"Seleccione..."});
        subOptions.setFont(new Font("Segoe UI", Font.BOLD, 12));

        STipo = new JLabel("Seleccione un Tipo(Si Corresponde)");
        STipo.setFont(new Font("Segoe UI", Font.BOLD, 14));

        typeOptions = new JComboBox<>(new String[]{"Seleccione..."});
        typeOptions.setFont(new Font("Segoe UI", Font.BOLD, 12));
        typeOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                typeOptionsActionPerformed(evt);
            }
        });

        GroupLayout PC1Layout = new GroupLayout(PC1);
        PC1.setLayout(PC1Layout);
        PC1Layout.setHorizontalGroup(
            PC1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PC1Layout.createSequentialGroup()
                    .addGroup(PC1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PC1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(SEspecificacion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(PC1Layout.createSequentialGroup()
                            .addGroup(PC1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(PC1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(PC1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(subOptions, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(typeOptions, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(PC1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(SeleccionEquipo, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
                                .addGroup(PC1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(mainOptions, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                .addGroup(PC1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(STipo)))
                            .addGap(0, 47, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        PC1Layout.setVerticalGroup(
            PC1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PC1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SeleccionEquipo)
                    .addGap(18, 18, 18)
                    .addComponent(mainOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(SEspecificacion)
                    .addGap(18, 18, 18)
                    .addComponent(subOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(STipo)
                    .addGap(18, 18, 18)
                    .addComponent(typeOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PC2 = new JPanel();
        PC2.setBackground(new Color(100, 153, 255));
        PC2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

        SSede = new JLabel("Seleccione la Sede:");
        SSede.setFont(new Font("Segoe UI", Font.BOLD, 18));

        locationOptions = new JComboBox<>(new String[]{"Seleccione...", "Sede 1", "Sede 2", "Sede 3", "Sede 4", "Sede 5", "Sede 6", "Sede 7"});
        locationOptions.setFont(new Font("Segoe UI", Font.BOLD, 12));
        locationOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                locationOptionsActionPerformed(evt);
            }
        });

        floorOptions = new JComboBox<>(new String[]{"Seleccione...", "Piso 1", "Piso 2", "Piso 3"});
        floorOptions.setFont(new Font("Segoe UI", Font.BOLD, 12));
        floorOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                floorOptionsActionPerformed(evt);
            }
        });

        SPiso = new JLabel("Seleccione el Piso:");
        SPiso.setFont(new Font("Segoe UI", Font.BOLD, 18));

        GroupLayout PC2Layout = new GroupLayout(PC2);
        PC2.setLayout(PC2Layout);
        PC2Layout.setHorizontalGroup(
            PC2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PC2Layout.createSequentialGroup()
                    .addGroup(PC2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PC2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(SSede, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
                        .addGroup(PC2Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(locationOptions, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                        .addGroup(PC2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(SPiso, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
                        .addGroup(PC2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(floorOptions, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(53, Short.MAX_VALUE))
        );
        PC2Layout.setVerticalGroup(
            PC2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(PC2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SSede)
                    .addGap(18, 18, 18)
                    .addComponent(locationOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(SPiso)
                    .addGap(18, 18, 18)
                    .addComponent(floorOptions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout AP2Layout = new GroupLayout(AP2);
        AP2.setLayout(AP2Layout);
        AP2Layout.setHorizontalGroup(
            AP2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(AP2Layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCambiante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(PC1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(PC2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12))
        );
        AP2Layout.setVerticalGroup(
            AP2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(AP2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(AP2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PC2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelCambiante, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PC1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
        );

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
                    .addContainerGap()
                    .addComponent(AP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        AreaPrincipalLayout.setVerticalGroup(
            AreaPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(AreaPrincipalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AP1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );

        Fondo.add(AreaPrincipal, BorderLayout.CENTER);
        getContentPane().add(Fondo);

        BtnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetOptions();
                mostrarPanel("PC2");
            }
        });

        mainOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSubOptions();
            }
        });

        subOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTypeOptions();
            }
        });
    }
    private void styleButton(JButton button) {
    button.setBackground(new Color(100, 153, 255));
    button.setFont(new Font("Segoe UI", Font.BOLD, 16));
    button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    button.setPreferredSize(new Dimension(180, 50));
}

    private void resetOptions() {
        mainOptions.setSelectedIndex(0);
        subOptions.setSelectedIndex(0);
        typeOptions.setSelectedIndex(0);
        locationOptions.setSelectedIndex(0);
        floorOptions.setSelectedIndex(0);
    }

    private void updateSubOptions() {
        String selected = (String) mainOptions.getSelectedItem();
        subOptions.removeAllItems();
        subOptions.addItem("Seleccione...");

        if ("Computadora".equals(selected)) {
            subOptions.addItem("Escritorio");
            subOptions.addItem("Portátil");
        } else if ("Impresora".equals(selected)) {
            subOptions.addItem("Impresora Láser");
            subOptions.addItem("Impresora de Inyección");
        } else if ("Cámara".equals(selected)) {
            subOptions.addItem("Cámara DSLR");
            subOptions.addItem("Cámara Compacta");
            subOptions.addItem("Cámara Reflex");
            subOptions.addItem("Cámara Mirrorless");
            subOptions.addItem("Cámara Brigde");
            subOptions.addItem("Cámara Acción");
            subOptions.addItem("Cámara Instantánea");
            subOptions.addItem("Cámara Formato Medio");
            subOptions.addItem("Cámara Gran Formato");
        } else if ("Equipo de Grabación".equals(selected)) {
            subOptions.addItem("Audio");
            subOptions.addItem("AudioVisual");
            subOptions.addItem("Equipo de Audio");
        } else if ("Espacio de Grabación".equals(selected)) {
            subOptions.addItem("Estudio Pequeño");
            subOptions.addItem("Estudio Grande");
        }
    }

    private void updateTypeOptions() {
        String selected = (String) subOptions.getSelectedItem();
        typeOptions.removeAllItems();
        typeOptions.addItem("Seleccione...");

        if ("Escritorio".equals(selected) || "Portátil".equals(selected)) {
            // No hay opciones adicionales específicas para este caso en este ejemplo
        } else if ("Impresora Láser".equals(selected)) {
            typeOptions.addItem("Color");
            typeOptions.addItem("Monocromática");
        }
        // Puedes añadir más casos según necesites
    }

    private void mostrarPanel(String nombrePanel) {
        CardLayout cl = (CardLayout) (PanelCambiante.getLayout());
        cl.show(PanelCambiante, nombrePanel);
    }

    private void realizarRegistro() {
        String tipoEquipo = (String) mainOptions.getSelectedItem();
        String especificacion = (String) subOptions.getSelectedItem();
        String tipo = (String) typeOptions.getSelectedItem();
        String sede = (String) locationOptions.getSelectedItem();
        String piso = (String) floorOptions.getSelectedItem();

        if (tipoEquipo.equals("Seleccione...") || especificacion.equals("Seleccione...") ||
            tipo.equals("Seleccione...") || sede.equals("Seleccione...") || piso.equals("Seleccione...")) {
            System.out.println("Por favor, complete todas las opciones.");
            UsuarioTxt.setText("Complete todas las opciones para registrar.");
            return;
        }
        String url = "jdbc:mysql://localhost:3306/lab_marketing";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO reservas (tipoEquipo, especificacion, tipo, sede, piso) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, tipoEquipo);
                statement.setString(2, especificacion);
                statement.setString(3, tipo);
                statement.setString(4, sede);
                statement.setString(5, piso);
                statement.executeUpdate();
                System.out.println("Registro guardado en la base de datos.");
                UsuarioTxt.setText("Registro completado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
        }
    }
    
    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void typeOptionsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void locationOptionsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void floorOptionsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void mainOptionsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Pantalla1().setVisible(true);
            }
        });
    }
}