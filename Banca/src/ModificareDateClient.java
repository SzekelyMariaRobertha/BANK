import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ModificareDateClient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblEnterNewPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public ModificareDateClient(String userses) throws SQLException {
        setBounds(180, 80, 1000, 600);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JButton btnnume = new JButton("Modifică numele");
        btnnume.setFont(new Font("Impact", Font.PLAIN, 40));
        btnnume.setBounds(250, 50, 500, 50);
        contentPane.add(btnnume);
        btnnume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaNumele ah = null;
                try {
                    ah = new ModificaNumele(userses);
                    ah.setTitle("Modifică numele");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnadresa = new JButton("Modifică adresa");
        btnadresa.setFont(new Font("Impact", Font.PLAIN, 40));
        btnadresa.setBounds(250, 120, 500, 50);
        contentPane.add(btnadresa);
        btnadresa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaAdresa ah = null;
                try {
                    ah = new ModificaAdresa(userses);
                    ah.setTitle("Modifică adresa");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnnrTelefon = new JButton("Modifică numărul de telefon");
        btnnrTelefon.setFont(new Font("Impact", Font.PLAIN, 40));
        btnnrTelefon.setBounds(250, 190, 500, 50);
        contentPane.add(btnnrTelefon);
        btnnrTelefon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaNrTelefon ah = null;
                try {
                    ah = new ModificaNrTelefon(userses);
                    ah.setTitle("Modifică numărul de telefon");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btndetaliicont = new JButton("Modifică detalii cont");
        btndetaliicont.setFont(new Font("Impact", Font.PLAIN, 40));
        btndetaliicont.setBounds(250, 260, 500, 50);
        contentPane.add(btndetaliicont);
        btndetaliicont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaDetaliiCont ah = null;
                try {
                    ah = new ModificaDetaliiCont(userses);
                    ah.setTitle("Modifică detalii cont");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnvenit = new JButton("Modifică venitul");
        btnvenit.setFont(new Font("Impact", Font.PLAIN, 40));
        btnvenit.setBounds(250, 330, 500, 50);
        contentPane.add(btnvenit);
        btnvenit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaVenit ah = null;
                try {
                    ah = new ModificaVenit(userses);
                    ah.setTitle("Modifică venitul");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}