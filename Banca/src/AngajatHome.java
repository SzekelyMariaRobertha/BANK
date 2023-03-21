import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AngajatHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AngajatHome frame = new AngajatHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AngajatHome() {

    }

    /**
     * Create the frame.
     */

    public static void viewDetails(Connection con, JPanel contentPane, String username) throws SQLException {
        String query = "select nume, prenume, sucursala, norma, salariu, departament, nrContract, valoareCont from utilizator  where nrContract = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nume = rs.getString("nume");
                JTextField numee = new JTextField("Nume --> " + nume);
                numee.setBounds(100, 200, 300, 40);
                numee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                numee.setBackground(Color.BLUE);
                numee.setBorder(null);
                numee.setVisible(true);
                numee.setForeground(Color.white);
                contentPane.add(numee);

                String prenume = rs.getString("prenume");
                JTextField prenumee = new JTextField("Prenume --> " + prenume);
                prenumee.setBounds(100, 230, 300, 40);
                prenumee.setFont(new Font("Rockwell", Font.PLAIN, 20));
                prenumee.setBackground(Color.BLUE);
                prenumee.setBorder(null);
                prenumee.setVisible(true);
                prenumee.setForeground(Color.white);
                contentPane.add(prenumee);

                String sucursala = rs.getString("sucursala");
                JTextField sucursalaa = new JTextField("Sucursala --> " + sucursala);
                sucursalaa.setBounds(100, 260, 300, 40);
                sucursalaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
                sucursalaa.setBackground(Color.BLUE);
                sucursalaa.setBorder(null);
                sucursalaa.setVisible(true);
                sucursalaa.setForeground(Color.white);
                contentPane.add(sucursalaa);

                String norma = rs.getString("norma");
                JTextField normaa = new JTextField("Norma --> " + norma);
                normaa.setBounds(100, 290, 300, 40);
                normaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
                normaa.setBackground(Color.BLUE);
                normaa.setBorder(null);
                normaa.setVisible(true);
                normaa.setForeground(Color.white);
                contentPane.add(normaa);

                String salariu = rs.getString("salariu");
                JTextField salariuu = new JTextField("Salariu --> " + salariu);
                salariuu.setBounds(100, 320, 300, 40);
                salariuu.setFont(new Font("Rockwell", Font.PLAIN, 20));
                salariuu.setBackground(Color.BLUE);
                salariuu.setBorder(null);
                salariuu.setVisible(true);
                salariuu.setForeground(Color.white);
                contentPane.add(salariuu);

                String departament = rs.getString("departament");
                JTextField departamentt = new JTextField("Departament --> " + departament);
                departamentt.setBounds(100, 350, 300, 40);
                departamentt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                departamentt.setBackground(Color.BLUE);
                departamentt.setBorder(null);
                departamentt.setVisible(true);
                departamentt.setForeground(Color.white);
                contentPane.add(departamentt);

                String nrContract= rs.getString("nrContract");
                JTextField nrContarctt = new JTextField("Nr Contract --> " + nrContract);
                nrContarctt.setBounds(100, 380, 300, 40);
                nrContarctt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                nrContarctt.setBackground(Color.BLUE);
                nrContarctt.setBorder(null);
                nrContarctt.setVisible(true);
                nrContarctt.setForeground(Color.white);
                contentPane.add(nrContarctt);

                String valoareCont= rs.getString("valoareCont");
                JTextField valoareContt = new JTextField("Valoare Cont --> " + valoareCont);
                valoareContt.setBounds(100, 410, 300, 40);
                valoareContt.setFont(new Font("Rockwell", Font.PLAIN, 20));
                valoareContt.setBackground(Color.BLUE);
                valoareContt.setBorder(null);
                valoareContt.setVisible(true);
                valoareContt.setForeground(Color.white);
                contentPane.add(valoareContt);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public AngajatHome(String userSes) throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(180, 80, 1000, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.BLUE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("Deconectare");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Impact", Font.PLAIN, 30));
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
        btnNewButton.setBounds(780, 5, 200, 50);
        contentPane.add(btnNewButton);

        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                "root", "Cureamov1!");

        JLabel detalii = new JLabel("Detalii cont:");
        detalii.setForeground(Color.WHITE);
        detalii.setBackground(Color.BLACK);
        detalii.setFont(new Font("Impact", Font.PLAIN, 30));
        detalii.setBounds(100, 150, 300, 30);
        contentPane.add(detalii);
        viewDetails(connection, contentPane, userSes);

        JButton conturi = new JButton("Vizualizare Client și Conturi");
        conturi.setForeground(Color.BLACK);
        conturi.setFont(new Font("Impact", Font.PLAIN, 30));
        conturi.setBounds(450, 250, 500, 50);
        contentPane.add(conturi);
        conturi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VizualizareConturiClienti bo  = null;
                try {
                    bo = new VizualizareConturiClienti(userSes);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                bo.setTitle("Vizualizare Client și Conturi");
                bo.setVisible(true);
            }
        });

        JButton bell = new JButton(new ImageIcon("bell.png"));
        bell.setFont(new Font("Impact", Font.PLAIN, 30));
        bell.setBounds(0, 0, 70, 80);
        contentPane.add(bell);
        bell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Notificari bo = new Notificari();
            }
        });



    }


}