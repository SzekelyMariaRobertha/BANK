import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButtonClient;
    private JButton btnNewButtonAngajat;
    private JButton btnNewButtonAdmin;

    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */


    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(180, 80, 1000, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.BLUE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Bine ați venit!");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 46));
        lblNewLabel.setBounds(365, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textField.setBounds(355, 200, 281, 50);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Rockwell", Font.PLAIN, 40));
        passwordField.setBounds(355, 340, 281, 50);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Introduceți numărul de contract");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Impact", Font.PLAIN, 30));
        lblUsername.setBounds(300, 160, 500, 30);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Introduceți PIN-ul");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setFont(new Font("Impact", Font.PLAIN, 30));
        lblPassword.setBounds(380, 300, 300, 30);
        contentPane.add(lblPassword);

        JButton btnadaugare = new JButton("Creare client nou");
        btnadaugare.setFont(new Font("Impact", Font.PLAIN, 30));
        btnadaugare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdaugareClient ac = new AdaugareClient();
                try {
                    ac.adaugare("DA");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                ac.setTitle("Adaugare Client");
                ac.setVisible(true);

            }
        });
        btnadaugare.setBounds(730, 20, 250, 50);
        contentPane.add(btnadaugare);

        JButton btnfactura= new JButton("Plată factură");
        btnfactura.setFont(new Font("Impact", Font.PLAIN, 30));
        btnfactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select nrContract, pin from utilizator where nrContract=? and pin=?");

                    st.setString(1, userName);
                    st.setString(2, password);

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        PlataFactura ah = new PlataFactura(userName);
                        ah.setTitle("Plată factură");
                        ah.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(btnNewButtonClient, "Numar contract sau parola gresite");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        btnfactura.setBounds(70, 460, 250, 50);
        contentPane.add(btnfactura);

        // buton client
        btnNewButtonClient = new JButton("Client");
        btnNewButtonClient.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonClient.setBounds(360, 460, 162, 50);
        btnNewButtonClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select nrContract, pin from utilizator where nrContract=? and pin=?");

                    st.setString(1, userName);
                    st.setString(2, password);

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        ClientHome ah = new ClientHome(userName);
                        ah.setTitle("Client");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButtonClient, "Logare cu succes!");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButtonClient, "Numar contract sau parola gresite");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        contentPane.add(btnNewButtonClient);
        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);

        /// buton angajat
        btnNewButtonAngajat = new JButton("Angajat");
        btnNewButtonAngajat.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonAngajat.setBounds(560, 460, 162, 50);
        btnNewButtonAngajat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select nrContract, pin from utilizator where nrContract = ? and pin = ? ");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        AngajatHome ah = new AngajatHome(userName);
                        ah.setTitle("Angajat");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButtonAngajat, "Logare cu succes!");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButtonAngajat, "Numar contract sau parola gresite");
                    }
                    btnNewButtonAngajat.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String queryy = "select departament from utilizator where departament = ?";
                            try (PreparedStatement stmtt = connection.prepareStatement(queryy)) {
                                stmtt.setString(1, userName);
                                ResultSet rss = stmtt.executeQuery();

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        contentPane.add(btnNewButtonAngajat);
        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);


        /// buton admin
        btnNewButtonAdmin = new JButton("Admin");
        btnNewButtonAdmin.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonAdmin.setBounds(760, 460, 162, 50);
        btnNewButtonAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select nrContract, pin from utilizator where nrContract=? and pin=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        AdminHome ad = new AdminHome(userName);
                        ad.setTitle("Admin");
                        ad.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButtonAdmin, "Logare cu succes!");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButtonAdmin, "Numar contract sau parola gresite");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButtonAdmin);
        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}