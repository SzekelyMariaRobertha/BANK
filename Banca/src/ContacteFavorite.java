import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ContacteFavorite extends JFrame {

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

    public static void viewDetails(Connection con, JPanel contentPane, String username) throws SQLException {
        String query = "select u.contIban, u.cnp from contacteFavorite left join utilizator u on " +
                "u.idUtilizator = contacteFavorite.idContacteFavorite left join utilizator u2 on u2.idUtilizator = contacteFavorite.utilizator_id where u2.nrContract = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            int y = 0;
            while(rs.next()){
                y = y+70;
                int x = 100;
                String favorit01 = rs.getString("contIban");
                JButton ffavorit01 = new JButton(favorit01);
                ffavorit01.setBounds(x, y, 300, 50);
                ffavorit01.setFont(new Font("Impact", Font.PLAIN, 40));
                ffavorit01.setBorder(null);
                ffavorit01.setVisible(true);
                ffavorit01.setForeground(Color.white);
                ffavorit01.setBackground(Color.BLUE);
                ffavorit01.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TransferFavorite bo  = null;
                        try {
                            bo = new TransferFavorite(username, favorit01);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        bo.setTitle("");
                        bo.setVisible(true);
                    }
                });
                contentPane.add(ffavorit01);

                x += 300;
                String favorit02 = rs.getString("cnp");
                JButton ffavorit02 = new JButton(favorit02);
                ffavorit02.setBounds(x, y, 300, 50);
                ffavorit02.setFont(new Font("Impact", Font.PLAIN, 40));
                ffavorit02.setBorder(null);
                ffavorit02.setVisible(true);
                ffavorit02.setForeground(Color.white);
                ffavorit02.setBackground(Color.BLUE);
                ffavorit02.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TransferFavorite bo  = null;
                        try {
                            bo = new TransferFavorite(username, favorit01);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        bo.setTitle("");
                        bo.setVisible(true);
                    }
                });
                contentPane.add(ffavorit02);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ContacteFavorite(String username) throws SQLException {
        setBounds(180, 150, 1000, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                "root", "Cureamov1!");
        viewDetails(connection, contentPane, username);

    }
}