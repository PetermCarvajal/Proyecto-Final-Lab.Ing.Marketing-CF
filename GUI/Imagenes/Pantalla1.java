private void configurarPanelSuperior() {
    // Panel Superior blanco
    PanelSuperior = new JPanel();
    PanelSuperior.setBackground(Color.WHITE);
    PanelSuperior.setLayout(null);  // Usando null layout para control preciso
    PanelSuperior.setPreferredSize(new Dimension(1550, 170));

    // Logo a la izquierda
    Logo = new JLabel(new ImageIcon(getClass().getResource("/GUI/Imagenes/logoxue.png")));
    Logo.setBounds(10, 20, 431, 127);
    PanelSuperior.add(Logo);

    // Contenedor del título con bordes anidados
    TContainer = new JPanel();
    TContainer.setLayout(null);
    TContainer.setBackground(new Color(0, 25, 128));
    TContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer.setBounds(450, 10, 1070, 150);

    TContainer1 = new JPanel();
    TContainer1.setLayout(null);
    TContainer1.setBackground(Color.RED);
    TContainer1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer1.setBounds(10, 10, 1050, 130);

    TContainer2 = new JPanel();
    TContainer2.setLayout(null);
    TContainer2.setBackground(new Color(0, 51, 255));
    TContainer2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer2.setBounds(10, 10, 1030, 110);

    TContainer3 = new JPanel(new BorderLayout());
    TContainer3.setBackground(new Color(100, 153, 255));
    TContainer3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    TContainer3.setBounds(10, 10, 1010, 90);

    // Título
    Titulo = new JLabel("LABORATORIO MARKETING", SwingConstants.CENTER);
    Titulo.setFont(new Font("Segoe UI", Font.BOLD, 48));
    Titulo.setForeground(Color.BLACK);
    TContainer3.add(Titulo, BorderLayout.CENTER);

    // Anidar los paneles
    TContainer2.add(TContainer3);
    TContainer1.add(TContainer2);
    TContainer.add(TContainer1);
    PanelSuperior.add(TContainer);
} 