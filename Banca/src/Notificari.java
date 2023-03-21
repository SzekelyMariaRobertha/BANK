import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Notificari extends JFrame {

    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;

    Notificari() {

        frame2 = new JFrame("Notificari");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(1000, 600);

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(900, 400));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("Nume");
        defaultTableModel.addColumn("Prenume");
        defaultTableModel.addColumn("Cont IBAN");
        defaultTableModel.addColumn("Detalii");


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat", "root", "Cureamov1!");
            statement = connection.createStatement();
            String query = "select * from useless ";
            ResultSet resultSet = statement.executeQuery(query);
            String id = null;

            while (resultSet.next()) {
                id = resultSet.getString("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String contiban = resultSet.getString("contiban");
                String cerere = resultSet.getString("cerere");

                defaultTableModel.addRow(new Object[]{id, nume, prenume, contiban, cerere});
                frame2.setVisible(true);
                frame2.validate();
            }


            JButton btnNewButtonYES = new JButton("YES");
            btnNewButtonYES.setFont(new Font("Impact", Font.PLAIN, 40));
            btnNewButtonYES.setBounds(400, 500, 200, 40);
            frame2.add(btnNewButtonYES);
            String finalId = id;
            btnNewButtonYES.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sql = "DELETE FROM useless WHERE id = ?";
                    PreparedStatement pr = null;
                    try {
                        pr = connection.prepareStatement(sql);
                        pr.setString(1, finalId);
                        pr.execute();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    String sql1 = "UPDATE cerere_angajat SET aprobare_angajat = 'True'";
                    try {
                        PreparedStatement st = connection.prepareStatement(sql1);
                        st.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    AdaugareClient adaugareClient = new AdaugareClient();
                    try {
                        adaugareClient.adaugare("True");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            JButton btnNewButtonNO = new JButton("NO");
            btnNewButtonNO.setFont(new Font("Impact", Font.PLAIN, 40));
            btnNewButtonNO.setBounds(400, 500, 200, 40);
            frame2.add(btnNewButtonNO);
            btnNewButtonNO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String sql = "DELETE FROM useless WHERE id = ?";
                    PreparedStatement pr = null;
                    try {
                        pr = connection.prepareStatement(sql);
                        pr.setString(1, finalId);
                        pr.execute();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    String sql1 = "UPDATE cerere_angajat SET aprobare_angajat = 'False'";
                    try {
                        PreparedStatement st = connection.prepareStatement(sql1);
                        st.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    AdaugareClient adaugareClient = new AdaugareClient();
                    try {
                        adaugareClient.adaugare("False");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}