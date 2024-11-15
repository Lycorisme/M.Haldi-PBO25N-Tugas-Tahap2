package gui;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import config.KoneksiDB;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Framecicilan extends javax.swing.JFrame {
    private KoneksiDB crud;
    private String[] fieldSimpan = {"kodecicilan", "kodeangsuran", "tglbayar", "jumlah"};
    private String[] fieldEdit = {"kodeangsuran", "tglbayar", "jumlah"};

    public Framecicilan() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        crud = new KoneksiDB();
        customizeComponents();
    }

    private void customizeComponents() {
        this.setTitle("Sistem Informasi Cicilan");
        this.setBackground(new Color(245, 247, 250));
        
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        // Card Panel Styling
        formCard.setBackground(Color.WHITE);
        formCard.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(230, 230, 230), 1, true),
            BorderFactory.createEmptyBorder(25, 30, 25, 30)
        ));
        
        // Header Styling
        headerLabel.setFont(new Font("Cambria", Font.BOLD, 36));
        headerLabel.setForeground(new Color(51, 51, 51));
        headerLabel.setText("DATA CICILAN");
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Form Field Styling
        styleFormField(jLabel1, txtkodecicilan, "KODE CICILAN");
        styleFormField(jLabel2, txtkodeangsuran, "KODE ANGSURAN");
        styleFormField(jLabel3, txttglbayar, "TANGGAL BAYAR");
        styleFormField(jLabel4, txtjumlah, "JUMLAH");
        
        // Button Styling with Gradient
        styleButton(jButton1, "SIMPAN", new Color(0, 123, 255));
        styleButton(jButton2, "EDIT", new Color(40, 167, 69));
        styleButton(jButton3, "HAPUS", new Color(220, 53, 69));
    }

    private void styleFormField(JLabel label, JComponent field, String text) {
        label.setFont(new Font("Cambria", Font.BOLD, 14));
        label.setForeground(new Color(73, 80, 87));
        label.setText(text);
        
        field.setFont(new Font("Cambria", Font.PLAIN, 14));
        field.setPreferredSize(new Dimension(300, 40));
        
        if (field instanceof JTextField) {
            JTextField textField = (JTextField) field;
            textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(206, 212, 218), 1, true),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
            ));
            addTextFieldEffects(textField);
        }
    }

    private void addTextFieldEffects(JTextField textField) {
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(0, 123, 255), 2, true),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15)
                ));
            }
            
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                textField.setBorder(BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(206, 212, 218), 1, true),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15)
                ));
            }
        });
    }

    private void styleButton(JButton button, String text, Color color) {
        button.setText(text);
        button.setFont(new Font("Cambria", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setPreferredSize(new Dimension(120, 40));
        button.setBorder(new EmptyBorder(8, 15, 8, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addButtonHoverEffect(button, color);
    }

    private void addButtonHoverEffect(JButton button, Color baseColor) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(baseColor.darker());
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(baseColor);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        headerLabel = new JLabel();
        formCard = new JPanel();
        formPanel = new JPanel();
        buttonPanel = new JPanel();

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        txtkodecicilan = new JTextField();
        txtkodeangsuran = new JTextField();
        txttglbayar = new JTextField();
        txtjumlah = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setLayout(new BorderLayout(0, 30));

        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(245, 247, 250));
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        formCard.setLayout(new BorderLayout(0, 20));
        
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(jLabel1, gbc);
        gbc.gridx = 1; formPanel.add(txtkodecicilan, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; formPanel.add(jLabel2, gbc);
        gbc.gridx = 1; formPanel.add(txtkodeangsuran, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; formPanel.add(jLabel3, gbc);
        gbc.gridx = 1; formPanel.add(txttglbayar, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; formPanel.add(jLabel4, gbc);
        gbc.gridx = 1; formPanel.add(txtjumlah, gbc);

        formCard.add(formPanel, BorderLayout.CENTER);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        formCard.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(formCard, BorderLayout.CENTER);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        getContentPane().setBackground(new Color(245, 247, 250));
        getContentPane().add(mainPanel);
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (crud.duplicateKey("cicilan", "kodecicilan", txtkodecicilan.getText())) {
                showErrorMessage("Kode Cicilan sudah ada");
            } else {
                String[] isiField = {
                    txtkodecicilan.getText(),
                    txtkodeangsuran.getText(),
                    txttglbayar.getText(),
                    txtjumlah.getText()
                };
                crud.SimpanDinamis("cicilan", fieldSimpan, isiField);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String[] valueField = {
                txtkodeangsuran.getText(),
                txttglbayar.getText(),
                txtjumlah.getText()
            };
            crud.UbahDinamis("cicilan", "kodecicilan", txtkodecicilan.getText(), fieldEdit, valueField);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                crud.HapusDinamis("cicilan", "kodecicilan", txtkodecicilan.getText());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this,
            message,
            "Sukses",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Framecicilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Framecicilan().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtkodeangsuran;
    private javax.swing.JTextField txtkodecicilan;
    private javax.swing.JTextField txttglbayar;
    private JPanel mainPanel;
    private JPanel headerPanel;
    private JLabel headerLabel;
    private JPanel formCard;
    private JPanel formPanel;
    private JPanel buttonPanel;
    // End of variables declaration
}