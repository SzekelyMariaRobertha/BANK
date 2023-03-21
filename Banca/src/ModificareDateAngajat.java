import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ModificareDateAngajat extends JFrame {

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

    public ModificareDateAngajat(String userses) throws SQLException {
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

        JButton btnsucursala = new JButton("Modifică sucursala");
        btnsucursala.setFont(new Font("Impact", Font.PLAIN, 40));
        btnsucursala.setBounds(250, 120, 500, 50);
        contentPane.add(btnsucursala);
        btnsucursala.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaSucursala ah = null;
                try {
                    ah = new ModificaSucursala(userses);
                    ah.setTitle("Modifică sucursala");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnnorma = new JButton("Modifică norma");
        btnnorma.setFont(new Font("Impact", Font.PLAIN, 40));
        btnnorma.setBounds(250, 190, 500, 50);
        contentPane.add(btnnorma);
        btnnorma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaNorma ah = null;
                try {
                    ah = new ModificaNorma(userses);
                    ah.setTitle("Modifică norma");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btnsalariu = new JButton("Modifică salariu");
        btnsalariu.setFont(new Font("Impact", Font.PLAIN, 40));
        btnsalariu.setBounds(250, 260, 500, 50);
        contentPane.add(btnsalariu);
        btnsalariu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaSalariu ah = null;
                try {
                    ah = new ModificaSalariu(userses);
                    ah.setTitle("Modifică salariu");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton btndepartament = new JButton("Modifică departament");
        btndepartament.setFont(new Font("Impact", Font.PLAIN, 40));
        btndepartament.setBounds(250, 330, 500, 50);
        contentPane.add(btndepartament);
        btndepartament.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModificaDepartament ah = null;
                try {
                    ah = new ModificaDepartament(userses);
                    ah.setTitle("Modifică departament");
                    ah.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}