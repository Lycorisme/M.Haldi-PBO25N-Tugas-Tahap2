package gui;

public class mainFrame extends javax.swing.JFrame {
    // Custom colors
    private final java.awt.Color PRIMARY_COLOR = new java.awt.Color(47, 128, 237);
    private final java.awt.Color SECONDARY_COLOR = new java.awt.Color(240, 242, 245);
    private final java.awt.Color ACCENT_COLOR = new java.awt.Color(66, 153, 225);
    private final java.awt.Color TEXT_PRIMARY = new java.awt.Color(51, 51, 51);
    private final java.awt.Color TEXT_SECONDARY = new java.awt.Color(102, 102, 102);

    public mainFrame() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        customizeComponents();
        applyModernStyling();
    }

    private void customizeComponents() {
        jPanel1.setBackground(java.awt.Color.WHITE);
        jPanel2.setBackground(SECONDARY_COLOR);

        styleModernButton(jButton1, "Anggota", "Kelola data anggota");
        styleModernButton(jButton2, "Angsuran", "Kelola pembayaran angsuran");
        styleModernButton(jButton3, "Cicilan", "Kelola data cicilan");
        styleModernButton(jButton4, "Dana Operasional", "Kelola dana operasional");

        buttons().forEach(this::addModernHoverEffect);
    }

    private void applyModernStyling() {
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 42));
        jLabel1.setForeground(PRIMARY_COLOR);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", java.awt.Font.PLAIN, 20));
        jLabel2.setForeground(TEXT_SECONDARY);
        
        // Status bar modernization
        jPanel3.setBorder(createModernBorder());
        statusLabel.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));
        
        jPanel2.setBorder(createShadowBorder());
        
        jSeparator1.setForeground(ACCENT_COLOR);
        jSeparator1.setBackground(ACCENT_COLOR);
    }

    private void styleModernButton(javax.swing.JButton button, String text, String tooltip) {
        button.setFont(new java.awt.Font("Segoe UI Semibold", java.awt.Font.PLAIN, 16));
        button.setText(text.toUpperCase());
        button.setToolTipText(tooltip);
        button.setForeground(TEXT_PRIMARY);
        button.setBackground(java.awt.Color.WHITE);
        button.setBorder(createButtonBorder());
        button.setFocusPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    private void addModernHoverEffect(javax.swing.JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                animateButton(button, SECONDARY_COLOR, PRIMARY_COLOR);
                button.setBorder(createHoverButtonBorder());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                animateButton(button, java.awt.Color.WHITE, TEXT_PRIMARY);
                button.setBorder(createButtonBorder());
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_COLOR);
                button.setForeground(java.awt.Color.WHITE);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                button.setBackground(SECONDARY_COLOR);
                button.setForeground(PRIMARY_COLOR);
            }
        });
    }

    private void animateButton(javax.swing.JButton button, java.awt.Color bgColor, java.awt.Color fgColor) {
        javax.swing.Timer timer = new javax.swing.Timer(20, new java.awt.event.ActionListener() {
            int frame = 0;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (frame < 5) {
                    button.setBackground(bgColor);
                    button.setForeground(fgColor);
                    frame++;
                } else {
                    ((javax.swing.Timer)e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    private javax.swing.border.Border createButtonBorder() {
        return javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(new java.awt.Color(230, 230, 230), 1, true),
            javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25)
        );
    }

    private javax.swing.border.Border createHoverButtonBorder() {
        return javax.swing.BorderFactory.createCompoundBorder(
            new javax.swing.border.LineBorder(PRIMARY_COLOR, 1, true),
            javax.swing.BorderFactory.createEmptyBorder(15, 25, 15, 25)
        );
    }

    private javax.swing.border.Border createModernBorder() {
        return javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(230, 230, 230)),
            javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );
    }

    private javax.swing.border.Border createShadowBorder() {
        return new javax.swing.border.CompoundBorder(
            new javax.swing.border.EmptyBorder(5, 5, 5, 5),
            new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0, 20), 1, true)
        );
    }

    private java.util.List<javax.swing.JButton> buttons() {
        return java.util.Arrays.asList(jButton1, jButton2, jButton3, jButton4);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Manajemen Keuangan");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        // Header
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HALAMAN UTAMA");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(40, 0, 0, 0);
        jPanel2.add(jLabel1, gbc);

        // Subtitle
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sistem Manajemen Keuangan");
        gbc.gridy = 1;
        gbc.insets = new java.awt.Insets(10, 0, 30, 0);
        jPanel2.add(jLabel2, gbc);

        // Separator
        jSeparator1.setPreferredSize(new java.awt.Dimension(300, 2));
        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(0, 100, 40, 100);
        jPanel2.add(jSeparator1, gbc);

        // Button Panel
        javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(2, 2, 30, 30));
        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        buttonPanel.add(jButton4);

        gbc.gridy = 3;
        gbc.insets = new java.awt.Insets(0, 50, 40, 50);
        jPanel2.add(buttonPanel, gbc);

        // Status Panel
        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        
        statusLabel.setText("© 2024 Sistem Manajemen Keuangan");
        jPanel3.add(statusLabel);

        // Add components to main panel
        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);
        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        // Add action listeners
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        // Main frame layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new Frameanggota().setVisible(true);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        new Frameangsuran().setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        new Framecicilan().setVisible(true);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        new Framedanaoperasional().setVisible(true);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            mainFrame frame = new mainFrame();
            frame.setVisible(true);
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel statusLabel;
}