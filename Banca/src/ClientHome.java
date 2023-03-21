import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ClientHome extends JFrame {

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

    public ClientHome() {

    }

    /**
     * Create the frame.
     */

    public static void viewDetails(Connection con, JPanel contentPane, String username) throws SQLException {
        String query = "select nume, prenume, nrTelefon, email, contIban, nrContract, detaliiCont, adresa, valoareCont, cnp from utilizator  where nrContract = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nume = rs.getString("nume");
                JTextField numee = new JTextField("Nume --> " + nume);
                numee.setBounds(100, 200, 300, 30);
                numee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                numee.setBackground(Color.BLUE);
                numee.setBorder(null);
                numee.setVisible(true);
                numee.setForeground(Color.white);
                contentPane.add(numee);

                String prenume = rs.getString("prenume");
                JTextField prenumee = new JTextField("Prenume --> " + prenume);
                prenumee.setBounds(100, 230, 300, 30);
                prenumee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                prenumee.setBackground(Color.BLUE);
                prenumee.setBorder(null);
                prenumee.setVisible(true);
                prenumee.setForeground(Color.white);
                contentPane.add(prenumee);

                String nrTelefon = rs.getString("nrTelefon");
                JTextField nrTelefonn = new JTextField("Nr.Telefon --> " + nrTelefon);
                nrTelefonn.setBounds(100, 260, 300, 30);
                nrTelefonn.setFont(new Font("Rockwell", Font.PLAIN, 20));
                nrTelefonn.setBackground(Color.BLUE);
                nrTelefonn.setBorder(null);
                nrTelefonn.setVisible(true);
                nrTelefonn.setForeground(Color.white);
                contentPane.add(nrTelefonn);

                String email = rs.getString("email");
                JTextField emaill = new JTextField("Email --> " + email);
                emaill.setBounds(100, 290, 300, 30);
                emaill.setFont(new Font("Rockwell", Font.PLAIN, 20));
                emaill.setBackground(Color.BLUE);
                emaill.setBorder(null);
                emaill.setVisible(true);
                emaill.setForeground(Color.white);
                contentPane.add(emaill);

                String contIban = rs.getString("contIban");
                JTextField contIbann = new JTextField("Cont IBAN --> " + contIban);
                contIbann.setBounds(100, 320, 300, 30);
                contIbann.setFont(new Font("Rockwell", Font.PLAIN, 20));
                contIbann.setBackground(Color.BLUE);
                contIbann.setBorder(null);
                contIbann.setVisible(true);
                contIbann.setForeground(Color.white);
                contentPane.add(contIbann);

                String nrContract = rs.getString("nrContract");
                JTextField nrContarctt = new JTextField("Nr Contract --> " + nrContract);
                nrContarctt.setBounds(100, 350, 300, 30);
                nrContarctt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                nrContarctt.setBackground(Color.BLUE);
                nrContarctt.setBorder(null);
                nrContarctt.setVisible(true);
                nrContarctt.setForeground(Color.white);
                contentPane.add(nrContarctt);

                String detaliiCont = rs.getString("detaliiCont");
                JTextField detaliiContt = new JTextField("Tip Cont --> " + detaliiCont);
                detaliiContt.setBounds(100, 380, 300, 30);
                detaliiContt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                detaliiContt.setBackground(Color.BLUE);
                detaliiContt.setBorder(null);
                detaliiContt.setVisible(true);
                detaliiContt.setForeground(Color.white);
                contentPane.add(detaliiContt);

                String adresa = rs.getString("adresa");
                JTextField adresaa = new JTextField("Adresa --> " + adresa);
                adresaa.setBounds(100, 410, 300, 30);
                adresaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
                adresaa.setBackground(Color.BLUE);
                adresaa.setBorder(null);
                adresaa.setVisible(true);
                adresaa.setForeground(Color.white);
                contentPane.add(adresaa);

                String suma = rs.getString("valoareCont");
                JTextField sumaa = new JTextField("Valoare Cont --> " + suma);
                sumaa.setBounds(100, 440, 300, 30);
                sumaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
                sumaa.setBackground(Color.BLUE);
                sumaa.setBorder(null);
                sumaa.setVisible(true);
                sumaa.setForeground(Color.white);
                contentPane.add(sumaa);

                String cnp = rs.getString("cnp");
                JTextField cnpp = new JTextField("CNP --> " + cnp);
                cnpp.setBounds(100, 470, 300, 30);
                cnpp.setFont(new Font("Rockwell", Font.PLAIN, 20));
                cnpp.setBackground(Color.BLUE);
                cnpp.setBorder(null);
                cnpp.setVisible(true);
                cnpp.setForeground(Color.white);
                contentPane.add(cnpp);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClientHome(String userSes) throws SQLException {

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

        JLabel lblDetalii = new JLabel("Detalii cont:");
        lblDetalii.setForeground(Color.WHITE);
        lblDetalii.setBackground(Color.BLACK);
        lblDetalii.setFont(new Font("Impact", Font.PLAIN, 30));
        lblDetalii.setBounds(100, 150, 300, 30);
        contentPane.add(lblDetalii);
        viewDetails(connection, contentPane, userSes);

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

        JButton btnNewButtonCard = new JButton("Eliberare Card");
        btnNewButtonCard.setForeground(new Color(0, 0, 0));
        btnNewButtonCard.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                String query = "select idUtilizator from utilizator  where nrContract = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    stmt.setString(1, userSes);
                    ResultSet rs = stmt.executeQuery();
                    int idUtilizator = 0;
                    if (rs.next()) {
                        idUtilizator = Integer.parseInt(rs.getString("idUtilizator"));
                    }

                    String sql = "insert into cerere_angajat(denumireCerere, utilizator_idd) values (\"Solicitare Card\", ?)";
                    try (PreparedStatement st = connection.prepareStatement(sql)) {
                        st.setInt(1,(idUtilizator));
                        st.executeUpdate();
                    }

                    String sql1 = "SELECT  nume, prenume, contIban, denumireCerere FROM utilizator, cerere_angajat WHERE idUtilizator = ? ";
                    PreparedStatement ps = connection.prepareStatement(sql1);
                    ps.setInt(1, idUtilizator);
                    ResultSet rs1 = ps.executeQuery();
                    String nume = null;
                    String prenume = null;
                    String contIban = null;
                    String denumireCerere = null;

                    while (rs1.next()) {
                        nume = rs1.getString(1);
                        prenume = rs1.getString(2);
                        contIban = rs1.getString(3);
                        denumireCerere = rs1.getString(4);
                    }

                    String sql3 = "SELECT aprobare_angajat FROM cerere_angajat WHERE utilizator_idd = ?";
                    PreparedStatement ps1 = connection.prepareStatement(sql3);
                    ps1.setInt(1, idUtilizator);
                    ResultSet rs2 = ps1.executeQuery();
                    if(rs2.next()) {
                        String aprobare = rs2.getString(1);
                        if (aprobare.equals("True")) {
                            EliberareCard bo = null;
                            bo = new EliberareCard(userSes);
                            bo.setTitle("Card");
                            bo.setVisible(true);
                        }
                        if (aprobare.equals("False")) {
                           JOptionPane.showMessageDialog(btnNewButtonCard, "Cererea a fost respinsă!");
                        }
                        if(aprobare.equals("DA")) {
                            String sql2 = "INSERT INTO useless(id, nume, prenume, contiban, cerere) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement pstmt = connection.prepareStatement(sql2);
                            pstmt.setInt(1, (idUtilizator));

                            pstmt.setString(2, nume);
                            pstmt.setString(3, prenume);
                            pstmt.setString(4, contIban);
                            pstmt.setString(5, denumireCerere);
                            pstmt.executeUpdate();

                            JOptionPane.showMessageDialog(btnNewButtonCard, "Cererea este în așteptare!");
                        }
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButtonCard.setBounds(550, 150, 300, 50);
        contentPane.add(btnNewButtonCard);

        JButton btnNewButtonTransfer = new JButton("Transfer bancar");
        btnNewButtonTransfer.setForeground(new Color(0, 0, 0));
        btnNewButtonTransfer.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonTransfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TransferBancar bo = null;
                try {
                    bo = new TransferBancar(userSes);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                bo.setTitle("Transfer Bancar");
                bo.setVisible(true);
            }
        });
        btnNewButtonTransfer.setBounds(550, 210, 300, 50);
        contentPane.add(btnNewButtonTransfer);


        JButton btnNewButtonFavoriti = new JButton("Contacte favorite");
        btnNewButtonFavoriti.setForeground(new Color(0, 0, 0));
        btnNewButtonFavoriti.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonFavoriti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ContacteFavorite bo = null;
                try {
                    bo = new ContacteFavorite(userSes);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                bo.setTitle("Contacte favorite");
                bo.setVisible(true);
            }
        });
        btnNewButtonFavoriti.setBounds(550, 270, 300, 50);
        contentPane.add(btnNewButtonFavoriti);

        JButton btnvizualizareconturi = new JButton("Vizualizare Conturi");
        btnvizualizareconturi.setForeground(new Color(0, 0, 0));
        btnvizualizareconturi.setFont(new Font("Impact", Font.PLAIN, 30));
        btnvizualizareconturi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VizualizareConturiClienti bo = null;
                try {
                    bo = new VizualizareConturiClienti(userSes);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                bo.setTitle("Vizualizare Conturi");
                bo.setVisible(true);
            }
        });
        btnvizualizareconturi.setBounds(550, 330, 300, 50);
        contentPane.add(btnvizualizareconturi);


        JButton btnlichidarecont = new JButton("Lichidare Cont");
        btnlichidarecont.setForeground(new Color(0, 0, 0));
        btnlichidarecont.setFont(new Font("Impact", Font.PLAIN, 30));
        btnlichidarecont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LichidareCont bo = null;
                try {
                    bo = new LichidareCont(userSes);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                bo.setTitle("Lichidare Cont");
                bo.setVisible(true);
            }
        });
        btnlichidarecont.setBounds(550, 390, 300, 50);
        contentPane.add(btnlichidarecont);

    }
}