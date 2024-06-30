package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChangeMyPassword extends JFrame implements ActionListener {

    JFrame f;
    JPanel panel;
    JLabel l1, l2, l3, l4;
    JTextField tf;
    JPasswordField pf;
    JButton bt1, bt2;
    public String admin_id2, doctor_id2, recepnist_id, patinet_id;

    ChangeMyPassword(String admin_id) {

        f = new JFrame("Change my Password");
        f.setBackground(Color.white);
        f.setLayout(null);
        admin_id2 = admin_id;

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/login1.jpg"));
        Image i = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);

        l2 = new JLabel("Change My Password");
        l2.setBounds(198, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.black);
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Old Password: ");
        l3.setBounds(130, 120, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.black);
        l1.add(l3);

        l4 = new JLabel("New Password : ");
        l4.setBounds(130, 170, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.black);
        l1.add(l4);

        tf = new JTextField();
        tf.setBounds(310, 120, 150, 30);
        l1.add(tf);

        pf = new JPasswordField();
        pf.setBounds(310, 170, 150, 30);
        l1.add(pf);

        bt1 = new JButton("Change Password");
        bt1.setBackground(Color.black);
        bt1.setForeground(Color.white);
        bt1.setBounds(130, 220, 150, 40);
        l1.add(bt1);

        bt2 = new JButton("Close");
        bt2.setBackground(Color.black);
        bt2.setForeground(Color.white);
        bt2.setBounds(310, 220, 150, 40);
        l1.add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setLocation(300, 100);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            // Code to handle changing the password
            String oldPassword = tf.getText(); // Get the old password from the text field
            String newPassword = new String(pf.getPassword()); // Get the new password from the password field

            // Add validation for special characters, uppercase, and lowercase letters, and numbers
            if (!newPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
                JOptionPane.showMessageDialog(null, "Password must contain at least 8 characters, including at least one digit, one lowercase letter, one uppercase letter, and one special character (@#$%^&+=)");
                return;
            }

            try {
                ConnectionClass obj = new ConnectionClass();

                String q = "UPDATE admin SET password='" + newPassword + "' WHERE admin_id='" + admin_id2 + "' AND password='" + oldPassword + "'";
                int ss = obj.stm.executeUpdate(q);
                if (ss == 1) {
                    JOptionPane.showMessageDialog(null, "Your password is successfully updated");
                    f.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered the wrong password!");
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }

        } else if (e.getSource() == bt2) {
            // Code to handle closing the window
            {
            }
        }
    }
}
