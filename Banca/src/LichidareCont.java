import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LichidareCont extends JFrame {

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

    public LichidareCont(String userses) throws SQLException {
        setBounds(180, 130, 1000, 300);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JLabel nrContract = new JLabel("Cont de lichidat: ");
        nrContract.setBounds(220, 120, 300, 40);
        nrContract.setFont(new Font("Impact", Font.PLAIN, 40));
        nrContract.setBackground(Color.BLUE);
        nrContract.setBorder(null);
        nrContract.setVisible(true);
        nrContract.setForeground(Color.WHITE);
        contentPane.add(nrContract);

        JTextField ibandestinatiee = new JTextField();
        ibandestinatiee.setBounds(520, 120, 200, 40);
        ibandestinatiee.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(ibandestinatiee);
        ibandestinatiee.setColumns(10);

        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 40));
        btnNewButtonOk.setBounds(650, 200, 200, 40);
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

                String sql1 = "SELECT detaliiCont FROM utilizator WHERE contIban = ?";
                try {
                    PreparedStatement stmt9 = connection.prepareStatement(sql1);
                    stmt9.setString(1, ibandestinatiee.getText());
                    ResultSet rs = stmt9.executeQuery();
                    if (rs.next()) {
                        String detalii = rs.getString("detaliiCont");
                        if (detalii.equals("economii")) {

                            String sql2 = "SELECT valoareCont FROM utilizator WHERE contIban = ?";
                            PreparedStatement stmt10 = connection.prepareStatement(sql2);
                            stmt10.setString(1, ibandestinatiee.getText());
                            ResultSet rs1 = stmt10.executeQuery();
                            double valoare = 0;
                            if (rs1.next()) {
                                valoare = rs1.getDouble("valoareCont");
                                valoare = valoare - (0.02 * valoare);
                            }

                            String sql3 = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE nrContract = ?";
                            PreparedStatement statement = connection.prepareStatement(sql3);
                            statement.setDouble(1, valoare);
                            statement.setString(2, userses);
                            statement.executeUpdate();

                            String sql8 = "DELETE FROM utilizator WHERE contIban = ?";
                            try (PreparedStatement stmt8 = connection.prepareStatement(sql8)) {
                                stmt8.setString(1, ibandestinatiee.getText());
                                stmt8.execute();

                            } catch (SQLException ee) {
                                ee.printStackTrace();
                            }
                        }
                        if (detalii.equals("depozit")) {
                            String sql2 = "SELECT tipDepozit FROM utilizator WHERE contIban = ?";
                            PreparedStatement stmt10 = connection.prepareStatement(sql2);
                            stmt10.setString(1, ibandestinatiee.getText());
                            ResultSet rs1 = stmt10.executeQuery();
                            String depozit = null;
                            if(rs1.next()){
                                depozit = rs1.getString(1);
                            }
                            if(depozit.equals("1")){
                                String sql = "SELECT valoareCont FROM utilizator WHERE contIban = ?";
                                PreparedStatement stmt1 = connection.prepareStatement(sql);
                                stmt1.setString(1, ibandestinatiee.getText());
                                ResultSet rss = stmt1.executeQuery();
                                double valoare = 0;
                                if (rss.next()) {
                                    valoare = rss.getDouble("valoareCont");
                                    valoare = valoare + (0.05 * valoare);
                                }

                                String sql3 = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE nrContract = ?";
                                PreparedStatement statement = connection.prepareStatement(sql3);
                                statement.setDouble(1, valoare);
                                statement.setString(2, userses);
                                statement.executeUpdate();

                                String sql8 = "DELETE FROM utilizator WHERE contIban = ?";
                                try (PreparedStatement stmt8 = connection.prepareStatement(sql8)) {
                                    stmt8.setString(1, ibandestinatiee.getText());
                                    stmt8.execute();

                                } catch (SQLException ee) {
                                    ee.printStackTrace();
                                }
                            }

                            if(depozit.equals("3")){
                                String sql = "SELECT valoareCont FROM utilizator WHERE contIban = ?";
                                PreparedStatement stmt1 = connection.prepareStatement(sql);
                                stmt1.setString(1, ibandestinatiee.getText());
                                ResultSet rss = stmt1.executeQuery();
                                double valoare = 0;
                                if (rss.next()) {
                                    valoare = rss.getDouble("valoareCont");
                                    valoare = valoare + (0.10 * valoare);
                                }

                                String sql3 = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE nrContract = ?";
                                PreparedStatement statement = connection.prepareStatement(sql3);
                                statement.setDouble(1, valoare);
                                statement.setString(2, userses);
                                statement.executeUpdate();

                                String sql8 = "DELETE FROM utilizator WHERE contIban = ?";
                                try (PreparedStatement stmt8 = connection.prepareStatement(sql8)) {
                                    stmt8.setString(1, ibandestinatiee.getText());
                                    stmt8.execute();

                                } catch (SQLException ee) {
                                    ee.printStackTrace();
                                }
                            }

                            if(depozit.equals("6")){
                                String sql = "SELECT valoareCont FROM utilizator WHERE contIban = ?";
                                PreparedStatement stmt1 = connection.prepareStatement(sql);
                                stmt1.setString(1, ibandestinatiee.getText());
                                ResultSet rss = stmt1.executeQuery();
                                double valoare = 0;
                                if (rss.next()) {
                                    valoare = rss.getDouble("valoareCont");
                                    valoare = valoare + (0.15 * valoare);
                                }

                                String sql3 = "UPDATE utilizator SET valoareCont = valoareCont + ? WHERE nrContract = ?";
                                PreparedStatement statement = connection.prepareStatement(sql3);
                                statement.setDouble(1, valoare);
                                statement.setString(2, userses);
                                statement.executeUpdate();

                                String sql8 = "DELETE FROM utilizator WHERE contIban = ?";
                                try (PreparedStatement stmt8 = connection.prepareStatement(sql8)) {
                                    stmt8.setString(1, ibandestinatiee.getText());
                                    stmt8.execute();

                                } catch (SQLException ee) {
                                    ee.printStackTrace();
                                }
                            }
                        }
                    }
                    } catch(SQLException ex){
                        ex.printStackTrace();
                    }
            }
        });

    }
}