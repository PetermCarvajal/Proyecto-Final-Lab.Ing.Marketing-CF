/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Imagenes;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
/**
 *
 * @author User
 */
public class Pantalla2 extends javax.swing.JFrame {
    
    private JComboBox<String> mainOptions;
    private JComboBox<String> subOptions;
    private JComboBox<String> typeOptions;
    private JComboBox<String> locationOptions;
    private JComboBox<String> floorOptions;    
    
public class Pantalla extends JFrame{
    private JComboBox <String> mainOptions;
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
    private JPanel areaPrincipal;  
    private CardLayout cardLayout;
    
    
    public Pantalla(){
    initComponents();
    }
    private void initComponents(){
        Fondo = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        TContainer = new javax.swing.JPanel();
        TContainer1 = new javax.swing.JPanel();
        TContainer2 = new javax.swing.JPanel();
        TContainer3 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ContainerLateral = new javax.swing.JPanel();
        ContainerLateral1 = new javax.swing.JPanel();
        ContainerLateral2 = new javax.swing.JPanel();
        BtnRegistrar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnListas = new javax.swing.JButton();
        BtnProximamente = new javax.swing.JButton();
        AreaPrincipal = new javax.swing.JPanel();
        AP1 = new javax.swing.JPanel();
        AP2 = new javax.swing.JPanel();
        PanelCambiante = new javax.swing.JPanel();
        ISUsuario = new javax.swing.JLabel();
        InicioSesion = new javax.swing.JLabel();
        ISContra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsuarioTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ContraTxt = new javax.swing.JPasswordField();
        PC1 = new javax.swing.JPanel();
        SeleccionEquipo = new javax.swing.JLabel();
        mainOptions = new javax.swing.JComboBox<>();
        SEspecificacion = new javax.swing.JLabel();
        subOptions = new javax.swing.JComboBox<>();
        STipo = new javax.swing.JLabel();
        typeOptions = new javax.swing.JComboBox<>();
        PC2 = new javax.swing.JPanel();
        SSede = new javax.swing.JLabel();
        locationOptions = new javax.swing.JComboBox<>();
        floorOptions = new javax.swing.JComboBox<>();
        SPiso = new javax.swing.JLabel();

        setTitle("Laboratorio de Pruebas"); 
        setSize(1550, 625); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
   
        Fondo = new JPanel(); 
        Fondo.setBackground(new java.awt.Color(0, 25, 128)); 
        Fondo.setLayout(new BorderLayout());
        
        PanelSuperior = new JPanel(); 
        PanelSuperior.setBackground(Color.WHITE); 
        PanelSuperior.setLayout(null);  
        
        Logo = new JLabel(new ImageIcon(getClass().getResource("/GUI/Imagenes/logoxue.png"))); 
        Logo.setBounds(0,20, 431, 127); 
        PanelSuperior.add(Logo);

        // Paneles TContainer 
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
        
        // Ajustar posiciones y tamaños de los contenedores  
        TContainer3.setBounds(10, 10, 1050, 105); 
        TContainer2.setBounds(10, 10, 1070, 125); 
        TContainer1.setBounds(10, 10, 1090, 145); 
        TContainer.setBounds(427, -5, 1100, 165); 
        
        // Anidar los paneles 
        TContainer2.add(TContainer3); 
        TContainer1.add(TContainer2); 
        TContainer.add(TContainer1); 
        PanelSuperior.add(TContainer); 
        PanelSuperior.setPreferredSize(new Dimension(300,170));
        
        // Agregar el PanelSuperior al panel principal Fondo 
        Fondo.add(PanelSuperior, BorderLayout.NORTH); 
        
        // ContainerLateral settings 
        ContainerLateral = new JPanel(); 
        ContainerLateral.setBackground(new Color(0, 50, 150)); 
        ContainerLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); 
        ContainerLateral.setLayout(null); 
        ContainerLateral.setBounds(10,20,200,0);//130 330
        ContainerLateral.setPreferredSize(new Dimension(200,0));
        
        ContainerLateral1=new JPanel();
        ContainerLateral1.setBackground(new Color(255,0,0));
        ContainerLateral1.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        ContainerLateral1.setLayout(null);
        ContainerLateral1.setBounds(10,10,220,600);//90 290
        ContainerLateral.setPreferredSize(new Dimension(180,600));
        
        ContainerLateral2=new JPanel();
        ContainerLateral2.setBackground(new Color(0, 51, 255));
        ContainerLateral2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        ContainerLateral2.setLayout(new GroupLayout(ContainerLateral2));

        ContainerLateral1.add(ContainerLateral2);
        ContainerLateral.add(ContainerLateral1);
        Fondo.add(ContainerLateral,BorderLayout.WEST);
        TContainer.setPreferredSize(new Dimension(450, 100));
        TContainer.setBounds(425, 0, 1111, 170); // Ajuste del tamaño y posición
        getContentPane().add(Fondo);
        
        BtnRegistrar = new JButton("Registrar Reserva"); 
        BtnModificar = new JButton("Modificar Reserva"); 
        BtnListas = new JButton("Listar Reservas"); 
        BtnProximamente = new JButton("Próximamente");
        BtnRegistrar.setBackground(new Color(100, 153, 255));
        BtnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        BtnRegistrar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        BtnRegistrar.setPreferredSize(new Dimension(140,40));
        styleButton(BtnRegistrar); 
        styleButton(BtnModificar); 
        styleButton(BtnListas); 
        styleButton(BtnProximamente); 
        
        ContainerLateral.setPreferredSize(new Dimension(200, 600));
ContainerLateral2.setLayout(new GroupLayout(ContainerLateral2));
GroupLayout containerLateral2Layout=new GroupLayout(ContainerLateral2);
ContainerLateral2.setLayout(containerLateral2Layout);
containerLateral2Layout.setHorizontalGroup(
    containerLateral2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(containerLateral2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(containerLateral2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(BtnRegistrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnModificar, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addComponent(BtnListas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnProximamente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
);
containerLateral2Layout.setVerticalGroup(
    containerLateral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(containerLateral2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(BtnListas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(BtnProximamente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
);

javax.swing.GroupLayout containerLateral1Layout = new javax.swing.GroupLayout(ContainerLateral1);
ContainerLateral1.setLayout(containerLateral1Layout);
containerLateral1Layout.setHorizontalGroup(
    containerLateral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(containerLateral1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(ContainerLateral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
);
containerLateral1Layout.setVerticalGroup(
    containerLateral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(containerLateral1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(ContainerLateral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
);

javax.swing.GroupLayout containerLateralLayout = new javax.swing.GroupLayout(ContainerLateral);
ContainerLateral.setLayout(containerLateralLayout);
containerLateralLayout.setHorizontalGroup(
    containerLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(containerLateralLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(ContainerLateral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
);
containerLateralLayout.setVerticalGroup(
    containerLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(containerLateralLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(ContainerLateral1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
);
ContainerLateral1.add(ContainerLateral2);
ContainerLateral.add(ContainerLateral1);
Fondo.add(ContainerLateral,BorderLayout.WEST);
getContentPane().add(Fondo);
AreaPrincipal.setBackground(new java.awt.Color(0, 50, 150));
        AreaPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        AP1.setBackground(new java.awt.Color(255, 0, 0));
        AP1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        AP2.setBackground(new java.awt.Color(0, 51, 255));
        AP2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        PanelCambiante.setBackground(new java.awt.Color(100, 153, 255));
        PanelCambiante.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        ISUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ISUsuario.setText("Ingrese Su Usuario:");

        InicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InicioSesion.setText("Inicio de Sesion:");

        ISContra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ISContra.setText("Ingrese la Contraseña:");

        UsuarioTxt.setColumns(20);
        jScrollPane1.setViewportView(UsuarioTxt);

        ContraTxt.setColumns(20);
        jScrollPane2.setViewportView(ContraTxt);

        javax.swing.GroupLayout PanelCambianteLayout = new javax.swing.GroupLayout(PanelCambiante);
        PanelCambiante.setLayout(PanelCambianteLayout);
        PanelCambianteLayout.setHorizontalGroup(
            PanelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambianteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCambianteLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PanelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ISUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelCambianteLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(PanelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ISContra, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PanelCambianteLayout.setVerticalGroup(
            PanelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCambianteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InicioSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ISUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ISContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
AP2.setLayout(new CardLayout());

        PC1.setBackground(new java.awt.Color(100, 153, 255));
        PC1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        
        SeleccionEquipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SeleccionEquipo.setText("Seleccione un Tipo de Equipo:");

        mainOptions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mainOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "Computadora", "Impresora", "Cámara", "Equipo de Grabación", "Espacio de Grabación" }));
        mainOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainOptionsActionPerformed(evt);
            }
        });
        SEspecificacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SEspecificacion.setText("Seleccione una Especificacion:");

        subOptions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        subOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));

        STipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        STipo.setText("Seleccione un Tipo(Si Corresponde)");

        typeOptions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        typeOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        typeOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeOptionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PC1Layout = new javax.swing.GroupLayout(PC1);
        PC1.setLayout(PC1Layout);
        PC1Layout.setHorizontalGroup(
            PC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PC1Layout.createSequentialGroup()
                .addGroup(PC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PC1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SEspecificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PC1Layout.createSequentialGroup()
                        .addGroup(PC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PC1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(PC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(subOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(typeOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PC1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(SeleccionEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PC1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(mainOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PC1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(STipo)))
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PC1Layout.setVerticalGroup(
            PC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PC1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SeleccionEquipo)
                .addGap(18, 18, 18)
                .addComponent(mainOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SEspecificacion)
                .addGap(18, 18, 18)
                .addComponent(subOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(STipo)
                .addGap(18, 18, 18)
                .addComponent(typeOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PC2.setBackground(new java.awt.Color(100, 153, 255));
        PC2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        SSede.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SSede.setText("Seleccione la Sede:");

        locationOptions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        locationOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Sede 1", " Sede 2", " Sede 3", " Sede 4", " Sede 5", " Sede 6", " Sede 7" }));
        locationOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationOptionsActionPerformed(evt);
            }
        });

        floorOptions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        floorOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Piso 1", "Piso 2", "Piso 3" }));
        floorOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floorOptionsActionPerformed(evt);
            }
        });

        SPiso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SPiso.setText("Seleccione el Piso:");

        javax.swing.GroupLayout PC2Layout = new javax.swing.GroupLayout(PC2);
        PC2.setLayout(PC2Layout);
        PC2Layout.setHorizontalGroup(
            PC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PC2Layout.createSequentialGroup()
                .addGroup(PC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PC2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SSede, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PC2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(locationOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PC2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PC2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(floorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        PC2Layout.setVerticalGroup(
            PC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PC2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SSede)
                .addGap(18, 18, 18)
                .addComponent(locationOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SPiso)
                .addGap(18, 18, 18)
                .addComponent(floorOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AP2Layout = new javax.swing.GroupLayout(AP2);
        AP2.setLayout(AP2Layout);
        AP2Layout.setHorizontalGroup(
            AP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AP2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        AP2Layout.setVerticalGroup(
            AP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AP2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelCambiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout AP1Layout = new javax.swing.GroupLayout(AP1);
        AP1.setLayout(AP1Layout);
        AP1Layout.setHorizontalGroup(
            AP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AP1Layout.setVerticalGroup(
            AP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AP1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AreaPrincipalLayout = new javax.swing.GroupLayout(AreaPrincipal);
        AreaPrincipal.setLayout(AreaPrincipalLayout);
        AreaPrincipalLayout.setHorizontalGroup(
            AreaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AreaPrincipalLayout.setVerticalGroup(
            AreaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PC1.setBackground(new java.awt.Color(100, 153, 255)); PC1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true)); // Configuración de `PC2` 
        PC2.setBackground(new java.awt.Color(100, 153, 255)); PC2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3,true)); 
        
        PanelCambiante.add(PC1, "PC1"); PanelCambiante.add(PC2, "PC2");
Fondo.add(AreaPrincipal);
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
CardLayout cl = (CardLayout)(PanelCambiante.getLayout());
cl.show(PanelCambiante, nombrePanel);
} 
    private void styleButton(JButton button) {
        button.setBackground(new Color(100, 153, 255));
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setPreferredSize(new Dimension(140,40));//160
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
    String username ="root";
    String password="";
    
    // Ejemplo de cómo almacenar los datos en la base de datos o mostrar en la interfaz
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
    e.printStackTrace(); System.out.println("Error al conectar a la base de datos.");
}}}
 
    private javax.swing.JPanel AP1;
    private javax.swing.JPanel AP2;
    private javax.swing.JPanel AreaPrincipal;
    private javax.swing.JLabel ISContra;
    private javax.swing.JLabel ISUsuario;
    private javax.swing.JLabel InicioSesion;
    private javax.swing.JPanel PC1;
    private javax.swing.JPanel PC2;
    private javax.swing.JPanel PanelCambiante;
    private javax.swing.JLabel SEspecificacion;
    private javax.swing.JLabel SPiso;
    private javax.swing.JLabel SSede;
    private javax.swing.JLabel STipo;
    private javax.swing.JLabel SeleccionEquipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel Mensaje1;
    private javax.swing.JLabel Mensaje2;

}