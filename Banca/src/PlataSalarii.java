import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PlataSalarii extends JFrame {

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

    public boolean updateCont(String contract, String valoare, JButton btnNewButtonOk, String iban1, String iban2) throws SQLException {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                    "root", "Cureamov1!");
            PreparedStatement st1 = (PreparedStatement) connection.prepareStatement("SELECT valoareCont FROM utilizator WHERE nrContract = ?");
            st1.setString(1, contract);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                int valoaree = rs.getInt("valoareCont");
                if (valoaree <  (2 * Integer.parseInt(valoare))) {

                } else {
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE utilizator SET  valoareCont = valoareCont - (2 * ?) WHERE nrContract = ? ");
                    st.setInt(1, Integer.parseInt(valoare));
                    st.setString(2, contract);
                    st.executeUpdate();

                    String sql = "SELECT valoareCont FROM utilizator WHERE contIban = ?";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, iban1);
                    ResultSet rs1 = ps.executeQuery();

                    while (rs1.next()) {
                        String sql1 = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE contIban = ?";
                        PreparedStatement ps1 = connection.prepareStatement(sql1);
                        ps1.setInt(1, Integer.parseInt(valoare));
                        ps1.setString(2, iban1);
                        ps1.executeUpdate();
                    }

                    String sql2 = "SELECT valoareCont FROM utilizator WHERE contIban = ?";
                    PreparedStatement ps2 = connection.prepareStatement(sql2);
                    ps.setString(1, iban2);
                    ResultSet rs2 = ps.executeQuery();

                    while (rs2.next()) {
                        String sql3 = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE contIban = ?";
                        PreparedStatement ps1 = connection.prepareStatement(sql3);
                        ps1.setInt(1, Integer.parseInt(valoare));
                        ps1.setString(2, iban2);
                        ps1.executeUpdate();
                    }

                    JOptionPane.showMessageDialog(btnNewButtonOk, "Salariile au fost plătite");
                    return true;
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }

    public PlataSalarii(String name) throws SQLException {
        setBounds(180, 150, 1000, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JTextField contSursa = new JTextField();
        contSursa.setFont(new Font("Rockwell", Font.PLAIN, 30));
        contSursa.setBounds(550, 50, 281, 40);
        contentPane.add(contSursa);
        contSursa.setColumns(10);

        JTextField iban1 = new JTextField();
        iban1.setFont(new Font("Rockwell", Font.PLAIN, 30));
        iban1.setBounds(550, 120, 281, 40);
        contentPane.add(iban1);
        iban1.setColumns(10);

        JTextField iban2 = new JTextField();
        iban2.setFont(new Font("Rockwell", Font.PLAIN, 30));
        iban2.setBounds(550, 190, 281, 40);
        contentPane.add(iban2);
        iban2.setColumns(10);

        JTextField textFieldPret = new JTextField();
        textFieldPret.setFont(new Font("Rockwell", Font.PLAIN, 30));
        textFieldPret.setBounds(550, 250, 281, 40);
        contentPane.add(textFieldPret);
        textFieldPret.setColumns(10);

        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonOk.setBounds(355, 300, 162, 40);
        contentPane.add(btnNewButtonOk);
        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (updateCont(name, textFieldPret.getText(), btnNewButtonOk, iban1.getText(), iban2.getText())) {

                    } else {
                        JOptionPane.showMessageDialog(btnNewButtonOk, "Nu aveți suficienți bani in cont pentru a efectua plata!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JLabel lblFurnizor = new JLabel("Introduceți contul sursă:");
        lblFurnizor.setBackground(Color.BLACK);
        lblFurnizor.setForeground(Color.WHITE);
        lblFurnizor.setFont(new Font("Impact", Font.PLAIN, 30));
        lblFurnizor.setBounds(100, 50, 500, 30);
        contentPane.add(lblFurnizor);

        JLabel lblFactura = new JLabel("Introduceți IBAN:");
        lblFactura.setForeground(Color.WHITE);
        lblFactura.setBackground(Color.BLACK);
        lblFactura.setFont(new Font("Impact", Font.PLAIN, 30));
        lblFactura.setBounds(100, 120, 500, 30);
        contentPane.add(lblFactura);

        JLabel lblDetalii = new JLabel("Introduceți IBAN:");
        lblDetalii.setForeground(Color.WHITE);
        lblDetalii.setBackground(Color.BLACK);
        lblDetalii.setFont(new Font("Impact", Font.PLAIN, 30));
        lblDetalii.setBounds(100, 190, 500, 30);
        contentPane.add(lblDetalii);

        JLabel lblpret = new JLabel("Introduceți suma:");
        lblpret.setForeground(Color.WHITE);
        lblpret.setBackground(Color.BLACK);
        lblpret.setFont(new Font("Impact", Font.PLAIN, 30));
        lblpret.setBounds(100, 250, 500, 30);
        contentPane.add(lblpret);
    }
}