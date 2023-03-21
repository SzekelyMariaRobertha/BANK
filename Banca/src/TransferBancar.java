import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TransferBancar extends JFrame {

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

    public TransferBancar(String name) throws SQLException {
        setBounds(180, 150, 1000, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JTextField textFieldNume = new JTextField();
        textFieldNume.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldNume.setBounds(550, 40, 281, 50);
        contentPane.add(textFieldNume);
        textFieldNume.setColumns(10);

        JTextField textFieldPrenume = new JTextField();
        textFieldPrenume.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldPrenume.setBounds(550, 130, 281, 50);
        contentPane.add(textFieldPrenume);
        textFieldPrenume.setColumns(10);

        JTextField textFieldIban = new JTextField();
        textFieldIban.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldIban.setBounds(550, 220, 281, 50);
        contentPane.add(textFieldIban);
        textFieldIban.setColumns(10);

        JTextField textFieldSuma = new JTextField();
        textFieldSuma.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldSuma.setBounds(360, 300, 180, 50);
        contentPane.add(textFieldSuma);
        textFieldSuma.setColumns(10);

        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonOk.setBounds(650, 300, 162, 50);
        contentPane.add(btnNewButtonOk);
        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (updateCont(name, textFieldSuma.getText(), btnNewButtonOk, textFieldIban)) {

                    } else {
                        JOptionPane.showMessageDialog(btnNewButtonOk, "Nu aveți suficienți bani in cont pentru a efectua plata! ERROR!!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JLabel lblNume = new JLabel("Introduceți numele titularului");
        lblNume.setBackground(Color.BLACK);
        lblNume.setForeground(Color.WHITE);
        lblNume.setFont(new Font("Impact", Font.PLAIN, 30));
        lblNume.setBounds(100, 50, 500, 30);
        contentPane.add(lblNume);

        JLabel lblPrenume = new JLabel("Introduceți prenumele titularului");
        lblPrenume.setForeground(Color.WHITE);
        lblPrenume.setBackground(Color.BLACK);
        lblPrenume.setFont(new Font("Impact", Font.PLAIN, 30));
        lblPrenume.setBounds(100, 140, 500, 30);
        contentPane.add(lblPrenume);

        JLabel lblIban = new JLabel("Introduceți Iban-ul titularului");
        lblIban.setForeground(Color.WHITE);
        lblIban.setBackground(Color.BLACK);
        lblIban.setFont(new Font("Impact", Font.PLAIN, 30));
        lblIban.setBounds(100, 230, 500, 30);
        contentPane.add(lblIban);

        JLabel lblSuma = new JLabel("Introduceți suma");
        lblSuma.setBackground(Color.BLACK);
        lblSuma.setForeground(Color.WHITE);
        lblSuma.setFont(new Font("Impact", Font.PLAIN, 30));
        lblSuma.setBounds(100, 310, 500, 30);
        contentPane.add(lblSuma);
    }

    public boolean updateCont(String contract, String valoare, JButton btnNewButtonOk, JTextField ibanTitular) throws SQLException {
        try {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                    "root", "Cureamov1!");
            PreparedStatement st1 = (PreparedStatement) connection.prepareStatement("SELECT valoareCont FROM utilizator WHERE nrContract = ?");
            st1.setString(1, contract);
            ResultSet rs = st1.executeQuery();
            while (rs.next()) {
                double valoaree = rs.getDouble("valoareCont");
                if (valoaree < Double.parseDouble(valoare)) {
                    return false;
                } else {
                    String query = "select idUtilizator from utilizator  where nrContract = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(query)) {
                        stmt.setString(1, contract);
                        ResultSet rs1 = stmt.executeQuery();
                        String idUtilizator = null;
                        if (rs1.next()) {
                            idUtilizator = rs1.getString("idUtilizator");
                        }
                        JOptionPane.showMessageDialog(btnNewButtonOk, "Created!");

                        String sql = "insert into cerere_angajat(denumireCerere, utilizator_idd) values (\"Transfer Bancar\", ?);";
                        try (PreparedStatement st = connection.prepareStatement(sql)) {
                            st.setString(1, (idUtilizator));
                            st.executeUpdate();
                        }
                        String sql1 = "SELECT  nume, prenume, contIban, denumireCerere FROM utilizator, cerere_angajat WHERE idUtilizator = ? ";
                        PreparedStatement ps = connection.prepareStatement(sql1);
                        ps.setString(1, idUtilizator);
                        ResultSet rs2 = ps.executeQuery();
                        String nume = null;
                        String prenume = null;
                        String contIban = null;
                        String denumireCerere = null;

                        while (rs2.next()) {
                            nume = rs2.getString(1);
                            prenume = rs2.getString(2);
                            contIban = rs2.getString(3);
                            denumireCerere = rs2.getString(4);
                        }

                        String sql2 = "INSERT INTO useless(id, nume, prenume, contiban, cerere) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement pstmt = connection.prepareStatement(sql2);
                        pstmt.setString(1, idUtilizator);

                        pstmt.setString(2, nume);
                        pstmt.setString(3, prenume);
                        pstmt.setString(4, contIban);
                        pstmt.setString(5, denumireCerere);
                        pstmt.executeUpdate();

                        String sql3 = "SELECT aprobare_angajat FROM cerere_angajat";
                        PreparedStatement ps1 = connection.prepareStatement(sql3);
                        ResultSet rs3 = ps1.executeQuery();
                        if (rs3.next()) {
                            String aprobare = rs3.getString(1);
                            if (aprobare.equals("True")) {
                                String pt11 = null;
                                String queryy = "select contIban, nrContract from utilizator where nrContract = ?";
                                try (PreparedStatement stmtt = connection.prepareStatement(queryy)) {
                                    stmtt.setString(1, contract);
                                    ResultSet rss = stmtt.executeQuery();
                                    while (rss.next()) {
                                        String linee = rss.getString("contIban");
                                        String[] arrr = linee.split("\\d+", 2);
                                        pt11 = arrr[0].trim();
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                String pt22 = null;
                                String lineee = ibanTitular.getText();
                                String[] arrr = lineee.split("\\d+", 2);
                                pt22 = arrr[0].trim();
                                if (pt11.equals(pt22)) {
                                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE utilizator SET  valoareCont = valoareCont - ? WHERE nrContract = ? ");
                                    st.setDouble(1, Double.parseDouble(valoare));
                                    st.setString(2, contract);
                                    st.executeUpdate();
                                    String sqll = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE contIban = ?";
                                    PreparedStatement stt = connection.prepareStatement(sqll);
                                    stt.setDouble(1, Double.parseDouble(valoare));
                                    stt.setString(2, ibanTitular.getText());
                                    stt.executeUpdate();
                                } else {
                                    JOptionPane.showMessageDialog( btnNewButtonOk, "Aveti comision de 1%!");
                                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE utilizator SET  valoareCont = valoareCont - (? * 0.1) - ? WHERE nrContract = ? ");
                                    st.setDouble(1, Double.parseDouble(valoare));
                                    st.setDouble(2, Double.parseDouble(valoare));
                                    st.setString(3, contract);
                                    st.executeUpdate();
                                    String sqll = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE contIban = ?";
                                    System.out.println(contIban);
                                    PreparedStatement stt = connection.prepareStatement(sqll);
                                    stt.setDouble(1, Double.parseDouble(valoare));
                                    stt.setString(2, ibanTitular.getText());
                                    stt.executeUpdate();
                                }
                            }
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    return true;
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }
}