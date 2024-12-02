/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.View;

public class Plantilla extends javax.swing.JPanel {

    public Plantilla() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        PanelSuperior = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        TContainer = new javax.swing.JPanel();
        TContainer1 = new javax.swing.JPanel();
        TContainer2 = new javax.swing.JPanel();
        TContainer3 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
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
        RegistrarUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LNombres = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Nombres = new javax.swing.JTextArea();
        RegContrasena = new javax.swing.JPasswordField();
        LContra = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Apellidos = new javax.swing.JTextArea();
        LApellidos = new javax.swing.JLabel();
        LEdad = new javax.swing.JLabel();
        EdadSelector = new javax.swing.JComboBox<>();
        UserSelector = new javax.swing.JLabel();
        SelectorUser = new javax.swing.JComboBox<>();

        Fondo.setBackground(new java.awt.Color(0, 25, 128));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/logoxue.png"))); // NOI18N

        TContainer.setBackground(new java.awt.Color(0, 25, 128));
        TContainer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        TContainer1.setBackground(new java.awt.Color(255, 0, 0));
        TContainer1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        TContainer2.setBackground(new java.awt.Color(0, 51, 255));
        TContainer2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        TContainer3.setBackground(new java.awt.Color(100, 153, 255));
        TContainer3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Titulo.setText("LABORATORIO MARKETING");

        javax.swing.GroupLayout TContainer3Layout = new javax.swing.GroupLayout(TContainer3);
        TContainer3.setLayout(TContainer3Layout);
        TContainer3Layout.setHorizontalGroup(
            TContainer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TContainer3Layout.createSequentialGroup()
                .addComponent(Titulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TContainer3Layout.setVerticalGroup(
            TContainer3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TContainer2Layout = new javax.swing.GroupLayout(TContainer2);
        TContainer2.setLayout(TContainer2Layout);
        TContainer2Layout.setHorizontalGroup(
            TContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TContainer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TContainer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TContainer2Layout.setVerticalGroup(
            TContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TContainer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TContainer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout TContainer1Layout = new javax.swing.GroupLayout(TContainer1);
        TContainer1.setLayout(TContainer1Layout);
        TContainer1Layout.setHorizontalGroup(
            TContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TContainer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TContainer1Layout.setVerticalGroup(
            TContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TContainer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TContainerLayout = new javax.swing.GroupLayout(TContainer);
        TContainer.setLayout(TContainerLayout);
        TContainerLayout.setHorizontalGroup(
            TContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        TContainerLayout.setVerticalGroup(
            TContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelSuperiorLayout = new javax.swing.GroupLayout(PanelSuperior);
        PanelSuperior.setLayout(PanelSuperiorLayout);
        PanelSuperiorLayout.setHorizontalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperiorLayout.createSequentialGroup()
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSuperiorLayout.setVerticalGroup(
            PanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContainerLateral.setBackground(new java.awt.Color(0, 50, 150));
        ContainerLateral.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        ContainerLateral1.setBackground(new java.awt.Color(255, 0, 0));
        ContainerLateral1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        ContainerLateral2.setBackground(new java.awt.Color(0, 50, 255));
        ContainerLateral2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        BtnRegistrar.setBackground(new java.awt.Color(100, 153, 255));
        BtnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnRegistrar.setText("Registrar Reserva");
        BtnRegistrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        BtnModificar.setBackground(new java.awt.Color(100, 153, 255));
        BtnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnModificar.setText("Modificar Reserva");
        BtnModificar.setToolTipText("");
        BtnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        BtnListas.setBackground(new java.awt.Color(100, 153, 255));
        BtnListas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnListas.setText("Listas");
        BtnListas.setToolTipText("");
        BtnListas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        BtnProximamente.setBackground(new java.awt.Color(100, 153, 255));
        BtnProximamente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnProximamente.setText("Proximamente");
        BtnProximamente.setToolTipText("");
        BtnProximamente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout ContainerLateral2Layout = new javax.swing.GroupLayout(ContainerLateral2);
        ContainerLateral2.setLayout(ContainerLateral2Layout);
        ContainerLateral2Layout.setHorizontalGroup(
            ContainerLateral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLateral2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContainerLateral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnProximamente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnListas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ContainerLateral2Layout.setVerticalGroup(
            ContainerLateral2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLateral2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnListas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(BtnProximamente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ContainerLateral1Layout = new javax.swing.GroupLayout(ContainerLateral1);
        ContainerLateral1.setLayout(ContainerLateral1Layout);
        ContainerLateral1Layout.setHorizontalGroup(
            ContainerLateral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLateral1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContainerLateral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ContainerLateral1Layout.setVerticalGroup(
            ContainerLateral1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLateral1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContainerLateral2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ContainerLateralLayout = new javax.swing.GroupLayout(ContainerLateral);
        ContainerLateral.setLayout(ContainerLateralLayout);
        ContainerLateralLayout.setHorizontalGroup(
            ContainerLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContainerLateral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ContainerLateralLayout.setVerticalGroup(
            ContainerLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContainerLateral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        AreaPrincipal.setBackground(new java.awt.Color(0, 50, 155));
        AreaPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        AP1.setBackground(new java.awt.Color(255, 0, 0));
        AP1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        AP2.setBackground(new java.awt.Color(0, 50, 255));
        AP2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        RegistrarUser.setBackground(new java.awt.Color(100, 153, 255));
        RegistrarUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Bienvenido Por Favor Registre Su Usuario ");

        LNombres.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LNombres.setText("Ingrese Sus Nombres");

        Nombres.setColumns(20);
        Nombres.setRows(5);
        jScrollPane1.setViewportView(Nombres);

        RegContrasena.setText("jPasswordField1");

        LContra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LContra.setText("Contraseña");

        Apellidos.setColumns(20);
        Apellidos.setRows(5);
        jScrollPane2.setViewportView(Apellidos);

        LApellidos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LApellidos.setText("Ingrese Sus Apellidos");

        LEdad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LEdad.setText("Edad (Años)");

        EdadSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "6", "7", "8", "9", "1", "0", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "21" }));

        UserSelector.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UserSelector.setText("Seleccione Su Ingreso");

        SelectorUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Profesor" }));

        javax.swing.GroupLayout RegistrarUserLayout = new javax.swing.GroupLayout(RegistrarUser);
        RegistrarUser.setLayout(RegistrarUserLayout);
        RegistrarUserLayout.setHorizontalGroup(
            RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegistrarUserLayout.createSequentialGroup()
                        .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LNombres)
                            .addComponent(LApellidos)
                            .addComponent(LContra, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LEdad))
                        .addGap(18, 18, 18)
                        .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(RegistrarUserLayout.createSequentialGroup()
                                .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(RegContrasena))
                                .addGap(38, 38, 38)
                                .addComponent(UserSelector)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SelectorUser, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EdadSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(234, Short.MAX_VALUE))
        );
        RegistrarUserLayout.setVerticalGroup(
            RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistrarUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LNombres)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UserSelector)
                        .addComponent(SelectorUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LApellidos))
                .addGap(23, 23, 23)
                .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LContra))
                .addGap(27, 27, 27)
                .addGroup(RegistrarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LEdad)
                    .addComponent(EdadSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AP2Layout = new javax.swing.GroupLayout(AP2);
        AP2.setLayout(AP2Layout);
        AP2Layout.setHorizontalGroup(
            AP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegistrarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AP2Layout.setVerticalGroup(
            AP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegistrarUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(AP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AreaPrincipalLayout.setVerticalGroup(
            AreaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AreaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContainerLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AreaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(PanelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContainerLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AreaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AP1;
    private javax.swing.JPanel AP2;
    private javax.swing.JTextArea Apellidos;
    private javax.swing.JPanel AreaPrincipal;
    private javax.swing.JButton BtnListas;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnProximamente;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JPanel ContainerLateral;
    private javax.swing.JPanel ContainerLateral1;
    private javax.swing.JPanel ContainerLateral2;
    private javax.swing.JComboBox<String> EdadSelector;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel LApellidos;
    private javax.swing.JLabel LContra;
    private javax.swing.JLabel LEdad;
    private javax.swing.JLabel LNombres;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextArea Nombres;
    private javax.swing.JPanel PanelSuperior;
    private javax.swing.JPasswordField RegContrasena;
    private javax.swing.JPanel RegistrarUser;
    private javax.swing.JComboBox<String> SelectorUser;
    private javax.swing.JPanel TContainer;
    private javax.swing.JPanel TContainer1;
    private javax.swing.JPanel TContainer2;
    private javax.swing.JPanel TContainer3;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel UserSelector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
