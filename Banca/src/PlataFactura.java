import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PlataFactura extends JFrame {

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

    public boolean updateCont(String contract, String valoare, JButton btnNewButtonOk) throws SQLException {
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
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("UPDATE utilizator SET  valoareCont = valoareCont - ? WHERE nrContract = ? ");
                    st.setDouble(1, Double.parseDouble(valoare));
                    st.setString(2, contract);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButtonOk, "Plata a fost efectuată!");
                    return true;
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return false;
    }

    public PlataFactura(String name) throws SQLException {
        setBounds(180, 150, 1000, 400);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLUE);

        JTextField textFieldFurnizor = new JTextField();
        textFieldFurnizor.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldFurnizor.setBounds(550, 40, 281, 50);
        contentPane.add(textFieldFurnizor);
        textFieldFurnizor.setColumns(10);

        JTextField textFieldCodFactura = new JTextField();
        textFieldCodFactura.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldCodFactura.setBounds(550, 110, 281, 50);
        contentPane.add(textFieldCodFactura);
        textFieldCodFactura.setColumns(10);

        JTextField textFieldDetalii = new JTextField();
        textFieldDetalii.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldDetalii.setBounds(550, 180, 281, 50);
        contentPane.add(textFieldDetalii);
        textFieldDetalii.setColumns(10);

        JTextField textFieldPret = new JTextField();
        textFieldPret.setFont(new Font("Rockwell", Font.PLAIN, 40));
        textFieldPret.setBounds(550, 250, 281, 50);
        contentPane.add(textFieldPret);
        textFieldPret.setColumns(10);

        JButton btnNewButtonOk = new JButton("OK");
        btnNewButtonOk.setFont(new Font("Impact", Font.PLAIN, 30));
        btnNewButtonOk.setBounds(355, 300, 162, 50);
        contentPane.add(btnNewButtonOk);
        btnNewButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Factura bo;
                try {
                    if (updateCont(name, textFieldPret.getText(), btnNewButtonOk)) {
                        bo = new Factura(name, textFieldFurnizor.getText(), textFieldCodFactura.getText(), textFieldDetalii.getText(), textFieldPret.getText());
                        bo.setTitle("Factura");
                        bo.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(btnNewButtonOk, "Nu aveți suficienți bani in cont pentru a efectua plata!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JLabel lblFurnizor = new JLabel("Introduceți furnizorul:");
        lblFurnizor.setBackground(Color.BLACK);
        lblFurnizor.setForeground(Color.WHITE);
        lblFurnizor.setFont(new Font("Impact", Font.PLAIN, 30));
        lblFurnizor.setBounds(100, 50, 500, 30);
        contentPane.add(lblFurnizor);

        JLabel lblFactura = new JLabel("Introduceți codul facturii:");
        lblFactura.setForeground(Color.WHITE);
        lblFactura.setBackground(Color.BLACK);
        lblFactura.setFont(new Font("Impact", Font.PLAIN, 30));
        lblFactura.setBounds(100, 120, 500, 30);
        contentPane.add(lblFactura);

        JLabel lblDetalii = new JLabel("Introduceți detalii plată:");
        lblDetalii.setForeground(Color.WHITE);
        lblDetalii.setBackground(Color.BLACK);
        lblDetalii.setFont(new Font("Impact", Font.PLAIN, 30));
        lblDetalii.setBounds(100, 190, 500, 30);
        contentPane.add(lblDetalii);

        JLabel lblpret = new JLabel("Introduceți prețul facturii:");
        lblpret.setForeground(Color.WHITE);
        lblpret.setBackground(Color.BLACK);
        lblpret.setFont(new Font("Impact", Font.PLAIN, 30));
        lblpret.setBounds(100, 250, 500, 30);
        contentPane.add(lblpret);
    }
}