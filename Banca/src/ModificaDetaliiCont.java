import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ModificaDetaliiCont extends JFrame {

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

    public ModificaDetaliiCont(String userses) throws SQLException {
        setBounds(180, 130, 1000, 300);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JLabel expirare = new JLabel("Data expirare: ");
        expirare.setBounds(220, 190, 300, 40);
        expirare.setFont(new Font("Impact", Font.PLAIN, 40));
        expirare.setBackground(Color.BLUE);
        expirare.setBorder(null);
        expirare.setVisible(true);
        expirare.setForeground(Color.WHITE);
        contentPane.add(expirare);

        JTextField expiraree = new JTextField();
        expiraree.setBounds(520, 190, 200, 40);
        expiraree.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(expiraree);
        expiraree.setColumns(10);

        JLabel contIban = new JLabel("IBAN: ");
        contIban.setBounds(220, 120, 300, 40);
        contIban.setFont(new Font("Impact", Font.PLAIN, 40));
        contIban.setBackground(Color.BLUE);
        contIban.setBorder(null);
        contIban.setVisible(true);
        contIban.setForeground(Color.WHITE);
        contentPane.add(contIban);

        JTextField contIbann = new JTextField();
        contIbann.setBounds(520, 120, 200, 40);
        contIbann.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(contIbann);
        contIbann.setColumns(10);

        JLabel nrContract = new JLabel("Nr. Contract: ");
        nrContract.setBounds(220, 50, 300, 40);
        nrContract.setFont(new Font("Impact", Font.PLAIN, 40));
        nrContract.setBackground(Color.BLUE);
        nrContract.setBorder(null);
        nrContract.setVisible(true);
        nrContract.setForeground(Color.WHITE);
        contentPane.add(nrContract);

        JTextField nrContractt = new JTextField();
        nrContractt.setBounds(520, 50, 200, 40);
        nrContractt.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(nrContractt);
        nrContractt.setColumns(10);

        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 40));
        btnNewButtonOk.setBounds(850, 200, 100, 40);
        contentPane.add(btnNewButtonOk);

        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String contIban = contIbann.getText();
                String expirare = expiraree.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Bancomat",
                            "root", "Cureamov1!");
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE utilizator set contIban = ?, expirare = ? WHERE nrContract = ?");
                    st.setString(1, contIban);
                    st.setString(2, expirare);
                    st.setString(3, nrContractt.getText());
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButtonOk, "Detaliile contului au fost schimbate cu succes!");

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

    }
}