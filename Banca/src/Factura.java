import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Factura extends JFrame {

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
    public static void viewDetails(Connection con, JPanel contentPane, String username, String furnizor, String codFactura, String detalii, String pret) throws SQLException {
        String query = "select nume, prenume, adresa, contIban from utilizator where nrContract = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JLabel furnizorr = new JLabel(furnizor);
                furnizorr.setBounds(100, 100, 300, 60);
                furnizorr.setFont(new Font("Rockwell", Font.PLAIN, 50));
                furnizorr.setBackground(Color.WHITE);
                furnizorr.setBorder(null);
                furnizorr.setVisible(true);
                furnizorr.setForeground(Color.BLACK);
                contentPane.add(furnizorr);

                JLabel codfacturaa = new JLabel(codFactura);
                codfacturaa.setBounds(500, 110, 200, 40);
                codfacturaa.setFont(new Font("Rockwell", Font.PLAIN, 30));
                codfacturaa.setBackground(Color.WHITE);
                codfacturaa.setBorder(null);
                codfacturaa.setVisible(true);
                codfacturaa.setForeground(Color.BLACK);
                contentPane.add(codfacturaa);

                JLabel detaliii = new JLabel(detalii);
                detaliii.setBounds(600, 250, 600, 60);
                detaliii.setFont(new Font("Rockwell", Font.PLAIN, 50));
                detaliii.setBackground(Color.WHITE);
                detaliii.setBorder(null);
                detaliii.setVisible(true);
                detaliii.setForeground(Color.BLACK);
                contentPane.add(detaliii);

                JLabel prett = new JLabel(pret);
                prett.setBounds(670, 360, 600, 60);
                prett.setFont(new Font("Rockwell", Font.PLAIN, 50));
                prett.setBackground(Color.WHITE);
                prett.setBorder(null);
                prett.setVisible(true);
                prett.setForeground(Color.BLACK);
                contentPane.add(prett);

                String nume = rs.getString("nume");
                JLabel numee = new JLabel(nume);
                numee.setBounds(800, 12, 190, 40);
                numee.setFont(new Font("Rockwell", Font.PLAIN, 30));
                numee.setBackground(Color.WHITE);
                numee.setBorder(null);
                numee.setVisible(true);
                numee.setForeground(Color.BLACK);
                contentPane.add(numee);

                String prenume = rs.getString("prenume");
                JLabel prenumee = new JLabel(prenume);
                prenumee.setBounds(780, 50, 190, 40);
                prenumee.setFont(new Font("Rockwell", Font.PLAIN, 30));
                prenumee.setBackground(Color.WHITE);
                prenumee.setBorder(null);
                prenumee.setVisible(true);
                prenumee.setForeground(Color.BLACK);
                contentPane.add(prenumee);

                String adresa = rs.getString("adresa");
                JLabel adresaa = new JLabel(adresa);
                adresaa.setBounds(780, 88, 190, 40);
                adresaa.setFont(new Font("Rockwell", Font.PLAIN, 30));
                adresaa.setBackground(Color.WHITE);
                adresaa.setBorder(null);
                adresaa.setVisible(true);
                adresaa.setForeground(Color.BLACK);
                contentPane.add(adresaa);

                String ContIban = rs.getString("contIban");
                JLabel ContIbann = new JLabel(ContIban);
                ContIbann.setBounds(780, 169, 190, 30);
                ContIbann.setFont(new Font("Rockwell", Font.PLAIN, 20));
                ContIbann.setBackground(Color.WHITE);
                ContIbann.setBorder(null);
                ContIbann.setVisible(true);
                ContIbann.setForeground(Color.BLACK);
                contentPane.add(ContIbann);

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                JLabel dtff = new JLabel(dtf.format(now));
                dtff.setBounds(450, 165, 200, 50);
                dtff.setFont(new Font("Rockwell", Font.PLAIN, 30));
                dtff.setBackground(new Color(236, 182, 4));
                dtff.setBorder(null);
                dtff.setVisible(true);
                dtff.setForeground(Color.BLACK);
                contentPane.add(dtff);

                JLabel crt = new JLabel("1");
                crt.setBounds(150, 250, 600, 60);
                crt.setFont(new Font("Rockwell", Font.PLAIN, 30));
                crt.setBackground(Color.WHITE);
                crt.setBorder(null);
                crt.setVisible(true);
                crt.setForeground(Color.BLACK);
                contentPane.add(crt);

                JLabel profile = new JLabel();
                profile.setBounds(0, 0, 1000, 450);
                contentPane.add(profile);
                ImageIcon MyImage = new ImageIcon("factura.jpg");
                Image img = MyImage.getImage();
                Image newImg = img.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                profile.setIcon(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Factura(String user, String furnizor, String codfactura, String detalii, String pret) throws SQLException {
        setBounds(180, 80, 1020, 490);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                "root", "Cureamov1!");
        viewDetails(connection, contentPane, user, furnizor, codfactura, detalii, pret);

    }
}