import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EliberareCard extends JFrame {

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
        String query = "select nume, prenume, contIban, expirare from utilizator where nrContract = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nume = rs.getString("nume");
                JTextField numee = new JTextField(nume);
                numee.setBounds(20, 140, 60, 17);
                numee.setFont(new Font("Rockwell", Font.PLAIN, 15));
                numee.setBackground(new Color(236, 182, 4));
                numee.setBorder(null);
                numee.setVisible(true);
                numee.setForeground(Color.BLACK);
                contentPane.add(numee);

                String prenume = rs.getString("prenume");
                JTextField prenumee = new JTextField(prenume);
                prenumee.setBounds(numee.getX() + numee.getWidth(), numee.getY(), 60, 17);
                prenumee.setFont(new Font("Rockwell", Font.PLAIN, 15));
                prenumee.setBackground(new Color(236, 182, 4));
                prenumee.setBorder(null);
                prenumee.setVisible(true);
                prenumee.setForeground(Color.BLACK);
                contentPane.add(prenumee);

                String contIban = rs.getString("contIban");
                JTextField contIbann = new JTextField("IBAN   " + contIban);
                contIbann.setBounds(20, 100, 300, 25);
                contIbann.setFont(new Font("Rockwell", Font.PLAIN, 20));
                contIbann.setBackground(new Color(236, 182, 4));
                contIbann.setBorder(null);
                contIbann.setVisible(true);
                contIbann.setForeground(Color.BLACK);
                contentPane.add(contIbann);

                String exp = rs.getString("expirare");
                JLabel expirare = new JLabel(exp);
                expirare.setBounds(160, 140, 300, 17);
                expirare.setFont(new Font("Rockwell", Font.PLAIN, 15));
                expirare.setBackground(new Color(236, 182, 4));
                expirare.setBorder(null);
                expirare.setVisible(true);
                expirare.setForeground(Color.BLACK);
                contentPane.add(expirare);

                JLabel profile = new JLabel();
                profile.setBounds(10, 35, 70, 60);
                contentPane.add(profile);
                ImageIcon MyImage = new ImageIcon("cpp.png");
                Image img = MyImage.getImage();
                Image newImg = img.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                profile.setIcon(image);

                JLabel profilee = new JLabel();
                profilee.setBounds(65, 45, 60, 40);
                contentPane.add(profilee);
                ImageIcon MyImagee = new ImageIcon("contactless.png");
                Image imgg = MyImagee.getImage();
                Image newImgg = imgg.getScaledInstance(profilee.getWidth(), profilee.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imagee = new ImageIcon(newImgg);
                profilee.setIcon(imagee);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public EliberareCard(String name) throws SQLException {
        setBounds(730, 300, 330, 210);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        contentPane.setBackground(new Color(236, 182, 4));
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                "root", "Cureamov1!");
        viewDetails(connection, contentPane, name);

        JLabel lblNewLabel = new JLabel("CREDIT CARD");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 31));
        lblNewLabel.setBounds(150, 10, 273, 25);
        contentPane.add(lblNewLabel);
    }
}