import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdminHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientHome frame = new ClientHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminHome() {

    }

    /**
     * Create the frame.
     */

    public AdminHome(String userSes) throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(180, 80, 1000, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.BLUE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                "root", "Cureamov1!");

        JButton btnNewButton = new JButton("Deconectare");
        btnNewButton.setForeground(new Color(204, 0, 0));
        btnNewButton.setFont(new Font("Impact", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Sunteți sigur/ă că doriți să vă deconectați?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(830, 5, 150, 30);
        contentPane.add(btnNewButton);

        JButton salarii = new JButton("Plată Salarii");
        salarii.setForeground(Color.BLACK);
        salarii.setFont(new Font("Impact", Font.PLAIN, 30));
        salarii.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    PlataSalarii sc = new PlataSalarii(userSes);
                    sc.setTitle("Plată Salarii");
                    sc.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        salarii.setBounds(250, 50, 500, 50);
        contentPane.add(salarii);

        JButton btnsterge = new JButton("Ștergere Client");
        btnsterge.setForeground(Color.BLACK);
        btnsterge.setFont(new Font("Impact", Font.PLAIN, 30));
        btnsterge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    StergereClient sc = new StergereClient(userSes);
                    sc.setTitle("Ștergere Client");
                    sc.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        btnsterge.setBounds(250, 120, 500, 50);
        contentPane.add(btnsterge);

        JButton btnmodificaredate = new JButton("Modificare date client");
        btnmodificaredate.setForeground(Color.BLACK);
        btnmodificaredate.setFont(new Font("Impact", Font.PLAIN, 30));
        btnmodificaredate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ModificareDateClient md = new ModificareDateClient(userSes);
                    md.setTitle("Modificare date client");
                    md.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        btnmodificaredate.setBounds(250, 190, 500, 50);
        contentPane.add(btnmodificaredate);

        JButton btnmodificaangajat = new JButton("Modificare date angajat");
        btnmodificaangajat.setForeground(Color.BLACK);
        btnmodificaangajat.setFont(new Font("Impact", Font.PLAIN, 30));
        btnmodificaangajat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ModificareDateAngajat ma = new ModificareDateAngajat(userSes);
                    ma.setTitle("Modificare date angajat");
                    ma.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        btnmodificaangajat.setBounds(250, 260, 500, 50);
        contentPane.add(btnmodificaangajat);

        JButton btncautaclient = new JButton("Caută client");
        btncautaclient.setForeground(Color.BLACK);
        btncautaclient.setFont(new Font("Impact", Font.PLAIN, 30));
        btncautaclient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CautaClient ca = new CautaClient(userSes);
                    ca.setTitle("Caută client");
                    ca.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        btncautaclient.setBounds(250, 330, 500, 50);
        contentPane.add(btncautaclient);

        JButton btncautaangajat = new JButton("Caută angajat");
        btncautaangajat.setForeground(Color.BLACK);
        btncautaangajat.setFont(new Font("Impact", Font.PLAIN, 30));
        btncautaangajat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CautaAngajat ca = new CautaAngajat(userSes);
                    ca.setTitle("Căutare angajat");
                    ca.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        btncautaangajat.setBounds(250, 400, 500, 50);
        contentPane.add(btncautaangajat);

        JButton btnfiltrare = new JButton("Filtrează utilizatori");
        btnfiltrare.setForeground(Color.BLACK);
        btnfiltrare.setFont(new Font("Impact", Font.PLAIN, 30));
        btnfiltrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FiltreazaUtilizatori ca = new FiltreazaUtilizatori(userSes);
                    ca.setTitle("Filtrează utilizatori");
                    ca.setVisible(true);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }

        });
        btnfiltrare.setBounds(250, 470, 500, 50);
        contentPane.add(btnfiltrare);


    }
}