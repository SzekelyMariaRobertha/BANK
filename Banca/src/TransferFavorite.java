import com.oracle.webservices.internal.impl.encoding.StreamDecoderImpl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TransferFavorite extends JFrame {

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

    public static void viewDetails(Connection con, JPanel contentPane, String userses, String iban) throws SQLException {
        String query = "select nume, prenume, contIban, nrContract from utilizator where nrContract = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, userses);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                JLabel lblNume = new JLabel("Numele titularului");
                lblNume.setBackground(Color.BLACK);
                lblNume.setForeground(Color.WHITE);
                lblNume.setFont(new Font("Impact", Font.PLAIN, 30));
                lblNume.setBounds(100, 50, 500, 30);
                contentPane.add(lblNume);

                String nume = rs.getString("nume");
                JTextField numee = new JTextField(nume);
                numee.setBounds(550, 40, 281, 50);
                numee.setFont(new Font("Rockwell", Font.PLAIN, 40));
                numee.setBackground(Color.BLUE);
                numee.setBorder(null);
                numee.setVisible(true);
                numee.setForeground(Color.white);
                contentPane.add(numee);

                JLabel lblPrenume = new JLabel("Prenumele titularului");
                lblPrenume.setForeground(Color.WHITE);
                lblPrenume.setBackground(Color.BLACK);
                lblPrenume.setFont(new Font("Impact", Font.PLAIN, 30));
                lblPrenume.setBounds(100, 140, 500, 30);
                contentPane.add(lblPrenume);

                String prenume = rs.getString("prenume");
                JTextField prenumee = new JTextField(prenume);
                prenumee.setBounds(550, 130, 281, 50);
                prenumee.setFont(new Font("Rockwell", Font.PLAIN, 40));
                prenumee.setBackground(Color.BLUE);
                prenumee.setBorder(null);
                prenumee.setVisible(true);
                prenumee.setForeground(Color.white);
                contentPane.add(prenumee);

                JLabel lblIban = new JLabel("Iban-ul titularului");
                lblIban.setForeground(Color.WHITE);
                lblIban.setBackground(Color.BLACK);
                lblIban.setFont(new Font("Impact", Font.PLAIN, 30));
                lblIban.setBounds(100, 230, 300, 30);
                contentPane.add(lblIban);

                String contIban= rs.getString("contIban");
                JTextField contIbann = new JTextField(contIban);
                contIbann.setBounds(550, 220, 350, 50);
                contIbann.setFont(new Font("Rockwell", Font.PLAIN, 40));
                contIbann.setBackground(Color.BLUE);
                contIbann.setBorder(null);
                contIbann.setVisible(true);
                contIbann.setForeground(Color.white);
                contentPane.add(contIbann);

                JLabel lblSuma = new JLabel("Introduceți suma");
                lblSuma.setBackground(Color.BLACK);
                lblSuma.setForeground(Color.WHITE);
                lblSuma.setFont(new Font("Impact", Font.PLAIN, 30));
                lblSuma.setBounds(100, 310, 500, 30);
                contentPane.add(lblSuma);

                JTextField textFieldSuma = new JTextField();
                textFieldSuma.setFont(new Font("Rockwell", Font.PLAIN, 40));
                textFieldSuma.setBounds(360, 300, 180, 50);
                contentPane.add(textFieldSuma);
                textFieldSuma.setColumns(10);

                JButton btnNewButtonOk = new JButton("OK");
                btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 30));
                btnNewButtonOk.setBounds(650, 300, 162, 50);
                btnNewButtonOk.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String line = contIbann.getText();
                        String[] arr = line.split("\\d+", 2);
                        String pt1 = arr[0].trim();
                        //System.out.println(pt1);

                        String pt11 = null;
                        String queryy = "select contIban, nrContract from utilizator where nrContract = ?";
                        try (PreparedStatement stmtt = con.prepareStatement(queryy)){
                            stmtt.setString(1, userses);
                            ResultSet rss = stmtt.executeQuery();
                            while(rss.next()){
                                String linee = rss.getString("contIban");
                                String[] arrr = linee.split("\\d+", 2);
                                pt11 = arrr[0].trim();
                                //System.out.println(pt11);

                            }
                        }catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        if(pt1.equals(pt11)){
                            Connection connection = null;
                            try {
                                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                                        "root", "Cureamov1!");

                                String s = "Update utilizator set valoareCont = valoareCont - ? where contIban = ?";
                                PreparedStatement p = connection.prepareStatement(s);
                                p.setDouble(1, Double.parseDouble(textFieldSuma.getText()));
                                p.setString(2,contIbann.getText());
                                p.executeUpdate();

                                String ss = "Update utilizator set valoareCont = valoareCont + ? where contIban = ?";
                                PreparedStatement pp = connection.prepareStatement(ss);
                                pp.setDouble(1, Double.parseDouble(textFieldSuma.getText()));
                                pp.setString(2, iban);
                                pp.executeUpdate();

                                JOptionPane.showMessageDialog(btnNewButtonOk, "Transfer efectuat cu succes!");
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }else{
                            Connection connection = null;
                            try {
                                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                                        "root", "Cureamov1!");
                                String s = "Update utilizator set valoareCont = valoareCont - (0.01 * ?) where contIban = ?";
                                PreparedStatement p = connection.prepareStatement(s);
                                p.setDouble(1, Double.parseDouble(textFieldSuma.getText()));
                                p.setString(2,contIbann.getText());
                                p.executeUpdate();

                                String ss = "Update utilizator set valoareCont = valoareCont + (0.01 * ?) where contIban = ?";
                                PreparedStatement pp = connection.prepareStatement(ss);
                                pp.setDouble(1, Double.parseDouble(textFieldSuma.getText()));
                                pp.setString(2, iban);
                                pp.executeUpdate();

                                JOptionPane.showMessageDialog(btnNewButtonOk, "Transfer efectuat cu succes!");

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                contentPane.add(btnNewButtonOk);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public TransferFavorite(String userses, String iban) throws SQLException {
        setBounds(180, 150, 1000, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                "root", "Cureamov1!");
        viewDetails(connection, contentPane, userses, iban);

    }
}