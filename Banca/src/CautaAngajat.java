import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CautaAngajat extends JFrame {

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
        String query = "select idUtilizator, nume, prenume, sucursala, norma, salariu, departament, nrContract, pin from utilizator  where nrContract = ?";
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

                String nume = rs.getString("nume");
                JTextField numee = new JTextField("Nume --> " + nume);
                numee.setBounds(380, 150, 300, 40);
                numee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                numee.setBackground(Color.BLUE);
                numee.setBorder(null);
                numee.setVisible(true);
                numee.setForeground(Color.white);
                contentPane.add(numee);

                String prenume = rs.getString("prenume");
                JTextField prenumee = new JTextField("Prenume --> " + prenume);
                prenumee.setBounds(380, 180, 1000, 40);
                prenumee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                prenumee.setBackground(Color.BLUE);
                prenumee.setBorder(null);
                prenumee.setVisible(true);
                prenumee.setForeground(Color.white);
                contentPane.add(prenumee);

                String sucursala = rs.getString("sucursala");
                JTextField sucursalaa = new JTextField("Sucursala --> " + sucursala);
                sucursalaa.setBounds(380, 210, 1000, 40);
                sucursalaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
                sucursalaa.setBackground(Color.BLUE);
                sucursalaa.setBorder(null);
                sucursalaa.setVisible(true);
                sucursalaa.setForeground(Color.white);
                contentPane.add(sucursalaa);

                String norma = rs.getString("norma");
                JTextField normaa = new JTextField("Norma --> " + norma);
                normaa.setBounds(380, 240, 1000, 40);
                normaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
                normaa.setBackground(Color.BLUE);
                normaa.setBorder(null);
                normaa.setVisible(true);
                normaa.setForeground(Color.white);
                contentPane.add(normaa);

                String salariu = rs.getString("salariu");
                JTextField salariuu = new JTextField("Salariu --> " + salariu);
                salariuu.setBounds(380, 270, 1000, 30);
                salariuu.setFont(new Font("Rockwell", Font.PLAIN, 20));
                salariuu.setBackground(Color.BLUE);
                salariuu.setBorder(null);
                salariuu.setVisible(true);
                salariuu.setForeground(Color.white);
                contentPane.add(salariuu);

                String departament = rs.getString("departament");
                JTextField departamentt = new JTextField("Departament --> " + departament);
                departamentt.setBounds(380, 300, 1000, 30);
                departamentt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                departamentt.setBackground(Color.BLUE);
                departamentt.setBorder(null);
                departamentt.setVisible(true);
                departamentt.setForeground(Color.white);
                contentPane.add(departamentt);

                String nrContract= rs.getString("nrContract");
                JTextField nrContarctt = new JTextField("Nr Contract --> " + nrContract);
                nrContarctt.setBounds(380, 330, 1000, 30);
                nrContarctt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                nrContarctt.setBackground(Color.BLUE);
                nrContarctt.setBorder(null);
                nrContarctt.setVisible(true);
                nrContarctt.setForeground(Color.white);
                contentPane.add(nrContarctt);

                String pin = rs.getString("pin");
                JTextField pinn = new JTextField("PIN --> " + pin);
                pinn.setBounds(380, 360, 1000, 30);
                pinn.setFont(new Font("Rockwell", Font.PLAIN, 20));
                pinn.setBackground(Color.BLUE);
                pinn.setBorder(null);
                pinn.setVisible(true);
                pinn.setForeground(Color.white);
                contentPane.add(pinn);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public CautaAngajat(String userses) throws SQLException {
        setBounds(180, 80, 1000, 450);
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