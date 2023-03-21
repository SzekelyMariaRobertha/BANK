import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CautaClient extends JFrame {

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

    public static void viewDetails(Connection con, JPanel contentPane, String text) throws SQLException {
        String query = "select idUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, expirare from utilizator  where nrContract = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, text);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){

                String idUtilizator = rs.getString("idUtilizator");
                JTextField idUtilizatorr = new JTextField("Id Utilizator --> " + idUtilizator);
                idUtilizatorr.setBounds(380, 120, 300, 40);
                idUtilizatorr.setFont(new Font("Rockwell", Font.PLAIN, 20));
                idUtilizatorr.setBackground(Color.BLUE);
                idUtilizatorr.setBorder(null);
                idUtilizatorr.setVisible(true);
                idUtilizatorr.setForeground(Color.white);
                contentPane.add(idUtilizatorr);

                String cnp = rs.getString("cnp");
                JTextField cnpp = new JTextField("CNP --> " + cnp);
                cnpp.setBounds(380, 150, 300, 40);
                cnpp.setFont(new Font("Rockwell", Font.PLAIN, 20));
                cnpp.setBackground(Color.BLUE);
                cnpp.setBorder(null);
                cnpp.setVisible(true);
                cnpp.setForeground(Color.white);
                contentPane.add(cnpp);

                String nume = rs.getString("nume");
                JTextField numee = new JTextField("Nume --> " + nume);
                numee.setBounds(380, 180, 1000, 40);
                numee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                numee.setBackground(Color.BLUE);
                numee.setBorder(null);
                numee.setVisible(true);
                numee.setForeground(Color.white);
                contentPane.add(numee);

                String prenume = rs.getString("prenume");
                JTextField prenumee = new JTextField("Prenume --> " + prenume);
                prenumee.setBounds(380, 210, 1000, 40);
                prenumee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                prenumee.setBackground(Color.BLUE);
                prenumee.setBorder(null);
                prenumee.setVisible(true);
                prenumee.setForeground(Color.white);
                contentPane.add(prenumee);

                String adresa = rs.getString("adresa");
                JTextField adresaa = new JTextField("Adresa --> " + adresa);
                adresaa.setBounds(380, 240, 1000, 40);
                adresaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
                adresaa.setBackground(Color.BLUE);
                adresaa.setBorder(null);
                adresaa.setVisible(true);
                adresaa.setForeground(Color.white);
                contentPane.add(adresaa);

                String nrTelefon = rs.getString("nrTelefon");
                JTextField nrTelefonn = new JTextField("Nr.Telefon --> " + nrTelefon);
                nrTelefonn.setBounds(380, 270, 1000, 40);
                nrTelefonn.setFont(new Font("Rockwell", Font.PLAIN, 20));
                nrTelefonn.setBackground(Color.BLUE);
                nrTelefonn.setBorder(null);
                nrTelefonn.setVisible(true);
                nrTelefonn.setForeground(Color.white);
                contentPane.add(nrTelefonn);

                String email = rs.getString("email");
                JTextField emaill = new JTextField("Email --> " + email);
                emaill.setBounds(380, 300, 1000, 30);
                emaill.setFont(new Font("Rockwell", Font.PLAIN, 20));
                emaill.setBackground(Color.BLUE);
                emaill.setBorder(null);
                emaill.setVisible(true);
                emaill.setForeground(Color.white);
                contentPane.add(emaill);

                String contIban = rs.getString("contIban");
                JTextField contIbann = new JTextField("Cont IBAN --> " + contIban);
                contIbann.setBounds(380, 330, 1000, 30);
                contIbann.setFont(new Font("Rockwell", Font.PLAIN, 20));
                contIbann.setBackground(Color.BLUE);
                contIbann.setBorder(null);
                contIbann.setVisible(true);
                contIbann.setForeground(Color.white);
                contentPane.add(contIbann);

                String nrContract= rs.getString("nrContract");
                JTextField nrContarctt = new JTextField("Nr Contract --> " + nrContract);
                nrContarctt.setBounds(380, 360, 1000, 30);
                nrContarctt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                nrContarctt.setBackground(Color.BLUE);
                nrContarctt.setBorder(null);
                nrContarctt.setVisible(true);
                nrContarctt.setForeground(Color.white);
                contentPane.add(nrContarctt);

                String pin = rs.getString("pin");
                JTextField pinn = new JTextField("PIN --> " + pin);
                pinn.setBounds(380, 390, 1000, 30);
                pinn.setFont(new Font("Rockwell", Font.PLAIN, 20));
                pinn.setBackground(Color.BLUE);
                pinn.setBorder(null);
                pinn.setVisible(true);
                pinn.setForeground(Color.white);
                contentPane.add(pinn);

                String dataNasterii = rs.getString("dataNasterii");
                JTextField dataNasteriii = new JTextField("Data nasterii --> " + dataNasterii);
                dataNasteriii.setBounds(380, 420, 1000, 30);
                dataNasteriii.setFont(new Font("Rockwell", Font.PLAIN, 20));
                dataNasteriii.setBackground(Color.BLUE);
                dataNasteriii.setBorder(null);
                dataNasteriii.setVisible(true);
                dataNasteriii.setForeground(Color.white);
                contentPane.add(dataNasteriii);

                String venit = rs.getString("venit");
                JTextField venitt = new JTextField("Venit --> " + venit);
                venitt.setBounds(380, 450, 1000, 30);
                venitt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                venitt.setBackground(Color.BLUE);
                venitt.setBorder(null);
                venitt.setVisible(true);
                venitt.setForeground(Color.white);
                contentPane.add(venitt);

                String statusOnline = rs.getString("statusOnline");
                JTextField statusOnlinee = new JTextField("Status Online --> " + statusOnline);
                statusOnlinee.setBounds(380, 480, 1000, 30);
                statusOnlinee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                statusOnlinee.setBackground(Color.BLUE);
                statusOnlinee.setBorder(null);
                statusOnlinee.setVisible(true);
                statusOnlinee.setForeground(Color.white);
                contentPane.add(statusOnlinee);

                String detaliiCont = rs.getString("detaliiCont");
                JTextField detaliiContt = new JTextField("Tip Cont --> " + detaliiCont);
                detaliiContt.setBounds(380, 510, 1000, 30);
                detaliiContt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                detaliiContt.setBackground(Color.BLUE);
                detaliiContt.setBorder(null);
                detaliiContt.setVisible(true);
                detaliiContt.setForeground(Color.white);
                contentPane.add(detaliiContt);

                String expirare = rs.getString("expirare");
                JTextField expiraree = new JTextField("Expirare --> " + expirare);
                expiraree.setBounds(380, 540, 1000, 30);
                expiraree.setFont(new Font("Rockwell", Font.PLAIN, 20));
                expiraree.setBackground(Color.BLUE);
                expiraree.setBorder(null);
                expiraree.setVisible(true);
                expiraree.setForeground(Color.white);
                contentPane.add(expiraree);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public CautaClient(String userses) throws SQLException {
        setBounds(180, 60, 1000, 600);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JLabel nrContract = new JLabel("Nr. Contract: ");
        nrContract.setBounds(100, 60, 300, 40);
        nrContract.setFont(new Font("Impact", Font.PLAIN, 40));
        nrContract.setBackground(Color.BLUE);
        nrContract.setBorder(null);
        nrContract.setVisible(true);
        nrContract.setForeground(Color.WHITE);
        contentPane.add(nrContract);

        JTextField nrContractt = new JTextField();
        nrContractt.setBounds(380, 60, 200, 40);
        nrContractt.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(nrContractt);
        nrContractt.setColumns(10);

        JButton btnNewButtonOk = new JButton("Cauta");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 40));
        btnNewButtonOk.setBounds(700, 60, 200, 40);
        contentPane.add(btnNewButtonOk);
        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    viewDetails(connection, contentPane, nrContractt.getText());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}