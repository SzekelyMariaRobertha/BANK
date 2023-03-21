import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ModificaNumele extends JFrame {

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

    public ModificaNumele(String userses) throws SQLException {
        setBounds(180, 130, 1000, 300);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JLabel numec = new JLabel("Nume Client: ");
        numec.setBounds(220, 150, 300, 40);
        numec.setFont(new Font("Impact", Font.PLAIN, 40));
        numec.setBackground(Color.BLUE);
        numec.setBorder(null);
        numec.setVisible(true);
        numec.setForeground(Color.WHITE);
        contentPane.add(numec);

        JTextField numecc = new JTextField();
        numecc.setBounds(520, 150, 200, 40);
        numecc.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(numecc);
        numecc.setColumns(10);

        JLabel nrContract = new JLabel("Nr. Contract: ");
        nrContract.setBounds(220, 80, 300, 40);
        nrContract.setFont(new Font("Impact", Font.PLAIN, 40));
        nrContract.setBackground(Color.BLUE);
        nrContract.setBorder(null);
        nrContract.setVisible(true);
        nrContract.setForeground(Color.WHITE);
        contentPane.add(nrContract);

        JTextField nrContractt = new JTextField();
        nrContractt.setBounds(520, 80, 200, 40);
        nrContractt.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(nrContractt);
        nrContractt.setColumns(10);

        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 40));
        btnNewButtonOk.setBounds(850, 200, 100, 40);
        contentPane.add(btnNewButtonOk);
        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nume = numecc.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE utilizator set nume = ? WHERE nrContract = ?");
                    st.setString(1, nume);
                    st.setString(2, nrContractt.getText());
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButtonOk, "Numele a fost schimbat cu succes!");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

    }
}