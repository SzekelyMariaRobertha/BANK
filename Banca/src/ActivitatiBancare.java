import javax.swing.*;
import java.awt.*;

public class ActivitatiBancare extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientHome frame = new ClientHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ActivitatiBancare(String userName) {
    }

    /**
     * Create the frame.
     */


    
}
