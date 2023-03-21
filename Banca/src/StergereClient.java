import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ConvolveOp;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StergereClient extends JFrame {

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

    public StergereClient(String userses) throws SQLException {
        setBounds(180, 130, 1000, 300);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JLabel nrContract = new JLabel("Nr. Contract: ");
        nrContract.setBounds(220, 120, 300, 40);
        nrContract.setFont(new Font("Impact", Font.PLAIN, 40));
        nrContract.setBackground(Color.BLUE);
        nrContract.setBorder(null);
        nrContract.setVisible(true);
        nrContract.setForeground(Color.WHITE);
        contentPane.add(nrContract);

        JTextField nrContractt = new JTextField();
        nrContractt.setBounds(520, 120, 200, 40);
        nrContractt.setFont(new Font("Rockwell", Font.PLAIN, 40));
        contentPane.add(nrContractt);
        nrContractt.setColumns(10);

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
                String sql = "DELETE FROM utilizator WHERE nrContract = ?";
                try (PreparedStatement stmt = connection.prepareStatement(sql)){
                    stmt.setString(1, nrContractt.getText());
                    stmt.execute();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(btnNewButtonOk, "Clientul a fost șters cu succes!");
            }
        });

    }
}