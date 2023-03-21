import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdaugareClient extends JFrame {

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

    public boolean TestareCNP(Connection connection, PreparedStatement pstmt, JButton btnNewButtonOk, JTextField cnpp) throws SQLException {
        String account = "SELECT cnp, COUNT(*) FROM utilizator WHERE cnp = ?";
        PreparedStatement ps = connection.prepareStatement(account);
        ps.setString(1, cnpp.getText());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int numberAccounts = rs.getInt("COUNT(*)");
            if (numberAccounts < 5) {
                pstmt.executeUpdate();
                pstmt.close();
                JOptionPane.showMessageDialog(btnNewButtonOk, "Contul a fost creat cu succes!");
                return true;
            } else {
                JOptionPane.showMessageDialog(btnNewButtonOk, "Clientul are deja 5 conturi!");
            }
        }
        return false;
    }

    public boolean TestareCNP2(Connection connection, JButton btnNewButtonOk, JTextField cnpp) throws SQLException {
        String account = "SELECT cnp, COUNT(*) FROM utilizator WHERE cnp = ?";
        PreparedStatement ps = connection.prepareStatement(account);
        ps.setString(1, cnpp.getText());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int numberAccounts = rs.getInt("COUNT(*)");
            if (numberAccounts < 5) {
                JOptionPane.showMessageDialog(btnNewButtonOk, "Contul a fost creat cu succes!");
                return true;
            } else {
                JOptionPane.showMessageDialog(btnNewButtonOk, "Clientul are deja 5 conturi!");
            }
        }
        return false;
    }

    public AdaugareClient() {

    }

    public void adaugare(String aprob) throws SQLException {
        setBounds(180, 80, 1000, 700);
        setResizable(false);
        //setVisible(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JLabel idUtilizator = new JLabel("Id Utilizator: ");
        idUtilizator.setBounds(30, 20, 200, 30);
        idUtilizator.setFont(new Font("Impact", Font.PLAIN, 30));
        idUtilizator.setBackground(Color.BLUE);
        idUtilizator.setBorder(null);
        idUtilizator.setVisible(true);
        idUtilizator.setForeground(Color.WHITE);
        contentPane.add(idUtilizator);

        JLabel cnp = new JLabel("CNP: ");
        cnp.setBounds(30, 90, 200, 30);
        cnp.setFont(new Font("Impact", Font.PLAIN, 30));
        cnp.setBackground(Color.BLUE);
        cnp.setBorder(null);
        cnp.setVisible(true);
        cnp.setForeground(Color.WHITE);
        contentPane.add(cnp);

        JLabel nume = new JLabel("Nume: ");
        nume.setBounds(30, 160, 200, 30);
        nume.setFont(new Font("Impact", Font.PLAIN, 30));
        nume.setBackground(Color.BLUE);
        nume.setBorder(null);
        nume.setVisible(true);
        nume.setForeground(Color.WHITE);
        contentPane.add(nume);

        JLabel prenume = new JLabel("Prenume: ");
        prenume.setBounds(30, 230, 200, 30);
        prenume.setFont(new Font("Impact", Font.PLAIN, 30));
        prenume.setBackground(Color.BLUE);
        prenume.setBorder(null);
        prenume.setVisible(true);
        prenume.setForeground(Color.WHITE);
        contentPane.add(prenume);

        JLabel adresa = new JLabel("Adresa: ");
        adresa.setBounds(30, 300, 200, 30);
        adresa.setFont(new Font("Impact", Font.PLAIN, 30));
        adresa.setBackground(Color.BLUE);
        adresa.setBorder(null);
        adresa.setVisible(true);
        adresa.setForeground(Color.WHITE);
        contentPane.add(adresa);

        JLabel nrTelefon = new JLabel("Nr. Telefon: ");
        nrTelefon.setBounds(30, 370, 200, 30);
        nrTelefon.setFont(new Font("Impact", Font.PLAIN, 30));
        nrTelefon.setBackground(Color.BLUE);
        nrTelefon.setBorder(null);
        nrTelefon.setVisible(true);
        nrTelefon.setForeground(Color.WHITE);
        contentPane.add(nrTelefon);

        JLabel email = new JLabel("Email: ");
        email.setBounds(30, 440, 200, 30);
        email.setFont(new Font("Impact", Font.PLAIN, 30));
        email.setBackground(Color.BLUE);
        email.setBorder(null);
        email.setVisible(true);
        email.setForeground(Color.WHITE);
        contentPane.add(email);

        JLabel contIban = new JLabel("Cont IBAN: ");
        contIban.setBounds(30, 510, 200, 30);
        contIban.setFont(new Font("Impact", Font.PLAIN, 30));
        contIban.setBackground(Color.BLUE);
        contIban.setBorder(null);
        contIban.setVisible(true);
        contIban.setForeground(Color.WHITE);
        contentPane.add(contIban);

        JLabel nrContract = new JLabel("Nr. Contract: ");
        nrContract.setBounds(550, 20, 200, 30);
        nrContract.setFont(new Font("Impact", Font.PLAIN, 30));
        nrContract.setBackground(Color.BLUE);
        nrContract.setBorder(null);
        nrContract.setVisible(true);
        nrContract.setForeground(Color.WHITE);
        contentPane.add(nrContract);

        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(550, 90, 200, 30);
        pin.setFont(new Font("Impact", Font.PLAIN, 30));
        pin.setBackground(Color.BLUE);
        pin.setBorder(null);
        pin.setVisible(true);
        pin.setForeground(Color.WHITE);
        contentPane.add(pin);

        JLabel dataNasterii = new JLabel("Data Nasterii: ");
        dataNasterii.setBounds(550, 160, 200, 30);
        dataNasterii.setFont(new Font("Impact", Font.PLAIN, 30));
        dataNasterii.setBackground(Color.BLUE);
        dataNasterii.setBorder(null);
        dataNasterii.setVisible(true);
        dataNasterii.setForeground(Color.WHITE);
        contentPane.add(dataNasterii);

        JLabel venit = new JLabel("Venit: ");
        venit.setBounds(550, 230, 200, 30);
        venit.setFont(new Font("Impact", Font.PLAIN, 30));
        venit.setBackground(Color.BLUE);
        venit.setBorder(null);
        venit.setVisible(true);
        venit.setForeground(Color.WHITE);
        contentPane.add(venit);

        JLabel statusOnline = new JLabel("Status Online: ");
        statusOnline.setBounds(550, 300, 200, 30);
        statusOnline.setFont(new Font("Impact", Font.PLAIN, 30));
        statusOnline.setBackground(Color.BLUE);
        statusOnline.setBorder(null);
        statusOnline.setVisible(true);
        statusOnline.setForeground(Color.WHITE);
        contentPane.add(statusOnline);

        JLabel detaliiCont = new JLabel("Detalii Cont: ");
        detaliiCont.setBounds(550, 370, 200, 30);
        detaliiCont.setFont(new Font("Impact", Font.PLAIN, 30));
        detaliiCont.setBackground(Color.BLUE);
        detaliiCont.setBorder(null);
        detaliiCont.setVisible(true);
        detaliiCont.setForeground(Color.WHITE);
        contentPane.add(detaliiCont);

        JLabel expirare = new JLabel("Expirare: ");
        expirare.setBounds(550, 440, 200, 30);
        expirare.setFont(new Font("Impact", Font.PLAIN, 30));
        expirare.setBackground(Color.BLUE);
        expirare.setBorder(null);
        expirare.setVisible(true);
        expirare.setForeground(Color.WHITE);
        contentPane.add(expirare);

        JLabel valoareCont = new JLabel("Suma: ");
        valoareCont.setBounds(550, 510, 200, 30);
        valoareCont.setFont(new Font("Impact", Font.PLAIN, 30));
        valoareCont.setBackground(Color.BLUE);
        valoareCont.setBorder(null);
        valoareCont.setVisible(true);
        valoareCont.setForeground(Color.WHITE);
        contentPane.add(valoareCont);

        JLabel tipDepozit = new JLabel("Tip Depozit: ");
        tipDepozit.setBounds(30, 580, 200, 30);
        tipDepozit.setFont(new Font("Impact", Font.PLAIN, 30));
        tipDepozit.setBackground(Color.BLUE);
        tipDepozit.setBorder(null);
        tipDepozit.setVisible(true);
        tipDepozit.setForeground(Color.WHITE);
        contentPane.add(tipDepozit);

        JLabel s = new JLabel("(*) Completați cu 0 dacă nu doriți depozit");
        s.setBounds(30, 620, 500, 20);
        s.setFont(new Font("Impact", Font.PLAIN, 10));
        s.setBackground(Color.BLUE);
        s.setBorder(null);
        s.setVisible(true);
        s.setForeground(Color.WHITE);
        contentPane.add(s);

        JTextField idUtilizatorr = new JTextField();
        idUtilizatorr.setFont(new Font("Rockwell", Font.PLAIN, 30));
        idUtilizatorr.setBounds(200, 18, 200, 40);
        contentPane.add(idUtilizatorr);
        idUtilizatorr.setColumns(10);

        JTextField cnpp = new JTextField();
        cnpp.setBounds(200, 88, 200, 40);
        cnpp.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(cnpp);
        cnpp.setColumns(10);

        JTextField numee = new JTextField();
        numee.setBounds(200, 158, 200, 40);
        numee.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(numee);
        numee.setColumns(10);

        JTextField prenumee = new JTextField();
        prenumee.setBounds(200, 228, 200, 40);
        prenumee.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(prenumee);
        prenumee.setColumns(10);

        JTextField adresaa = new JTextField();
        adresaa.setBounds(200, 298, 200, 40);
        adresaa.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(adresaa);
        adresaa.setColumns(10);

        JTextField nrTelefonn = new JTextField();
        nrTelefonn.setBounds(200, 368, 200, 40);
        nrTelefonn.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(nrTelefonn);
        nrTelefonn.setColumns(10);

        JTextField emaill = new JTextField();
        emaill.setBounds(200, 438, 200, 40);
        emaill.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(emaill);
        emaill.setColumns(10);

        JTextField contIbann = new JTextField();
        contIbann.setBounds(200, 508, 200, 40);
        contIbann.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(contIbann);
        contIbann.setColumns(10);

        JTextField nrContractt = new JTextField();
        nrContractt.setBounds(750, 18, 200, 40);
        nrContractt.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(nrContractt);
        nrContractt.setColumns(10);

        JTextField pinn = new JTextField();
        pinn.setBounds(750, 88, 200, 40);
        pinn.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(pinn);
        pinn.setColumns(10);

        JTextField dataNasteriii = new JTextField();
        dataNasteriii.setBounds(750, 158, 200, 40);
        dataNasteriii.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(dataNasteriii);
        dataNasteriii.setColumns(10);

        JTextField venitt = new JTextField();
        venitt.setBounds(750, 228, 200, 40);
        venitt.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(venitt);
        venitt.setColumns(10);

        JTextField statusOnlinee = new JTextField();
        statusOnlinee.setBounds(750, 298, 200, 40);
        statusOnlinee.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(statusOnlinee);
        statusOnlinee.setColumns(10);

        JTextField detaliiContt = new JTextField();
        detaliiContt.setBounds(750, 368, 200, 40);
        detaliiContt.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(detaliiContt);
        detaliiContt.setColumns(10);

        JTextField expiraree = new JTextField();
        expiraree.setBounds(750, 438, 200, 40);
        expiraree.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(expiraree);
        expiraree.setColumns(10);

        JTextField valoareContt = new JTextField();
        valoareContt.setBounds(750, 508, 200, 40);
        valoareContt.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(valoareContt);
        valoareContt.setColumns(10);

        JTextField tipDepozitt = new JTextField();
        tipDepozitt.setBounds(200, 578, 200, 40);
        tipDepozitt.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contentPane.add(tipDepozitt);
        tipDepozitt.setColumns(10);


        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonOk.setBounds(750, 578, 200, 40);
        contentPane.add(btnNewButtonOk);
        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JOptionPane.showMessageDialog(btnNewButtonOk, "Cerere este în așteptare!");
                Connection connection = null;
                try {
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");
                    if (detaliiContt.getText().equals("economii")) {
                        String sql = "INSERT INTO utilizator(idUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, " +
                                "contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, expirare, tipUtilizator, valoareCont) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'client', ?)";
                        PreparedStatement pstmt = null;
                        try {
                            pstmt = connection.prepareStatement(sql);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        pstmt.setString(1, (idUtilizatorr.getText()));
                        pstmt.setString(2, cnpp.getText());
                        pstmt.setString(3, numee.getText());
                        pstmt.setString(4, prenumee.getText());
                        pstmt.setString(5, adresaa.getText());
                        pstmt.setString(6, nrTelefonn.getText());
                        pstmt.setString(7, emaill.getText());
                        pstmt.setString(8, contIbann.getText());
                        pstmt.setString(9, nrContractt.getText());
                        pstmt.setString(10, pinn.getText());
                        pstmt.setString(11, dataNasteriii.getText());
                        pstmt.setString(12, venitt.getText());
                        pstmt.setString(13, statusOnlinee.getText());
                        pstmt.setString(14, (detaliiContt.getText()));
                        pstmt.setString(15, (expiraree.getText()));

                        double suma = Double.parseDouble(valoareContt.getText());
                        double dobanda = suma * 0.5;
                        suma = (suma + dobanda);
                        pstmt.setDouble(16, suma);
                        TestareCNP(connection, pstmt, btnNewButtonOk, cnpp);
                    }
                    if (detaliiContt.getText().equals("curent")) {
                        String sql = "INSERT INTO utilizator(idUtilizator, cnp, nume, prenume, adresa, nrTelefon, email, " +
                                "contIban, nrContract, pin, dataNasterii, venit, statusOnline, detaliiCont, expirare, tipUtilizator, valoareCont) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'client', ?)";
                        PreparedStatement pstmt = null;
                        try {
                            pstmt = connection.prepareStatement(sql);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        pstmt.setString(1, (idUtilizatorr.getText()));
                        pstmt.setString(2, cnpp.getText());
                        pstmt.setString(3, numee.getText());
                        pstmt.setString(4, prenumee.getText());
                        pstmt.setString(5, adresaa.getText());
                        pstmt.setString(6, nrTelefonn.getText());
                        pstmt.setString(7, emaill.getText());
                        pstmt.setString(8, contIbann.getText());
                        pstmt.setString(9, nrContractt.getText());
                        pstmt.setString(10, pinn.getText());
                        pstmt.setString(11, dataNasteriii.getText());
                        pstmt.setString(12, venitt.getText());
                        pstmt.setString(13, statusOnlinee.getText());
                        pstmt.setString(14, (detaliiContt.getText()));
                        pstmt.setString(15, (expiraree.getText()));
                        pstmt.setDouble(16, Double.parseDouble(valoareContt.getText()));

                        TestareCNP(connection, pstmt, btnNewButtonOk, cnpp);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}

