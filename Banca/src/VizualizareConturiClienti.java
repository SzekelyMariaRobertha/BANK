import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VizualizareConturiClienti extends JFrame {

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

    public VizualizareConturiClienti(String userses) throws SQLException {
        setBounds(180, 50, 1000, 700);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JLabel cnp = new JLabel("Introduceți CNP: ");
        cnp.setBounds(100, 120, 300, 40);
        cnp.setFont(new Font("Impact", Font.PLAIN, 40));
        cnp.setBackground(Color.BLUE);
        cnp.setBorder(null);
        cnp.setVisible(true);
        cnp.setForeground(Color.WHITE);
        contentPane.add(cnp);

        JTextField cnpp = new JTextField();
        cnpp.setBounds(400, 120, 300, 40);
        cnpp.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(cnpp);
        cnpp.setColumns(10);

        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 40));
        btnNewButtonOk.setBounds(750, 120, 200, 40);
        contentPane.add(btnNewButtonOk);
        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");
                    String sql = "SELECT nume, prenume, cnp, detaliiCont FROM utilizator where cnp = ? ";
                    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, cnpp.getText());
                        ResultSet rs = stmt.executeQuery();
                        int y = 120;
                        while (rs.next()) {
                            y += 70;

                            String nume = rs.getString("nume");
                            JTextField numee = new JTextField(nume);
                            numee.setBounds(200, y, 100, 40);
                            numee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                            numee.setBackground(Color.BLUE);
                            numee.setBorder(null);
                            numee.setVisible(true);
                            numee.setForeground(Color.white);
                            contentPane.add(numee);

                            String prenume = rs.getString("prenume");
                            JTextField prenumee = new JTextField(prenume);
                            prenumee.setBounds(400, y, 100, 40);
                            prenumee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                            prenumee.setBackground(Color.BLUE);
                            prenumee.setBorder(null);
                            prenumee.setVisible(true);
                            prenumee.setForeground(Color.white);
                            contentPane.add(prenumee);

                            String cnp = rs.getString("cnp");
                            JTextField cnpp = new JTextField(cnp);
                            cnpp.setBounds(550, y, 200, 40);
                            cnpp.setFont(new Font("Rockwell", Font.PLAIN, 20));
                            cnpp.setBackground(Color.BLUE);
                            cnpp.setBorder(null);
                            cnpp.setVisible(true);
                            cnpp.setForeground(Color.white);
                            contentPane.add(cnpp);

                            String detalii = rs.getString("detaliiCont");
                            JTextField detaliii = new JTextField(detalii);
                            detaliii.setBounds(800, y, 100, 40);
                            detaliii.setFont(new Font("Rockwell", Font.PLAIN, 20));
                            detaliii.setBackground(Color.BLUE);
                            detaliii.setBorder(null);
                            detaliii.setVisible(true);
                            detaliii.setForeground(Color.white);
                            contentPane.add(detaliii);

                            int delay = 6000;
                            ActionListener task = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    numee.setText("");
                                    prenumee.setText("");
                                    cnpp.setText("");
                                    detaliii.setText("");
                                }
                            };
                            Timer timer  = new Timer(delay, task);
                            timer.start();

                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
