package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {

    JFrame f;
    JPanel panel;
    JLabel l1, l2, l3, l4;
    JTextField tf;
    JPasswordField pf;
    JButton bt1, bt2, registerButton;
    int loginId;

    LoginPage(int login_id) {
        f = new JFrame("Login Page");
        f.setBackground(Color.white);
        f.setLayout(null);

        loginId = login_id;

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/login.jpg"));
        Image i = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);

        l2 = new JLabel("Hospital Management System");
        l2.setBounds(70, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.white);
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Username: ");
        l3.setBounds(130, 120, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.white);
        l1.add(l3);

        l4 = new JLabel("Password: ");
        l4.setBounds(130, 170, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.white);
        l1.add(l4);

        tf = new JTextField();
        tf.setBounds(310, 120, 150, 30);
        l1.add(tf);

        pf = new JPasswordField();
        pf.setBounds(310, 170, 150, 30);
        l1.add(pf);

        bt1 = new JButton("Login");
        bt1.setBackground(new Color(30, 144, 255)); // Dodger Blue
        bt1.setForeground(Color.white);
        bt1.setBounds(130, 220, 150, 40);
        l1.add(bt1);

        bt2 = new JButton("Back");
        bt2.setBackground(new Color(255, 69, 0)); // Red-Orange
        bt2.setForeground(Color.white);
        bt2.setBounds(310, 220, 150, 40);
        l1.add(bt2);

        registerButton = new JButton("Register");
        registerButton.setBackground(new Color(50, 205, 50)); // Lime Green
        registerButton.setForeground(Color.white);
        registerButton.setBounds(200, 280, 150, 40);
        l1.add(registerButton);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        registerButton.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setLocation(300, 100);
        f.setResizable(false);
    }

    private void handleLogin(String role, String name, String pass) {
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from " + role + " where username='" + name + "' and password='" + pass + "'";
            ResultSet rs = obj.stm.executeQuery(q);

            if (rs.next()) {
                String userName = rs.getString("name");
                String userId = rs.getString(role.toLowerCase() + "_id");
                String userUsername = rs.getString("username");

                switch (role) {
                    case "Doctor":
                        new DoctorHomePage(userName, userId, loginId, userUsername).setVisible(true);
                        break;
                    case "Patient":
                        new PatientHomePage(userName, userId, loginId, userUsername).setVisible(true);
                        break;
                    case "Receptionist":
                        new ReceptionistHomePage(userName, userId, loginId, userUsername).setVisible(true);
                        break;
                    case "Admin":
                        new AdminHomePage(userName, userId, loginId, userUsername).setVisible(true);
                        break;
                    default:
                        // Handle unknown role
                        break;
                }

                f.setVisible(false);
            } else {
                showInvalidCredentials();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showInvalidCredentials() {
        JOptionPane.showMessageDialog(null, "Invalid login credentials");
        tf.setText("");
        pf.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt1) {
            try {
                ConnectionClass obj = new ConnectionClass();
                String name = tf.getText();
                String pass = pf.getText();
                ResultSet rs;

                if (loginId == 1) {
                    String q = "select * from doctor where username='" + name + "' and password='" + pass + "'";
                    rs = obj.stm.executeQuery(q);
                    if (rs.next()) {
                        String doctorname = rs.getString("name");
                        String doctor_id = rs.getString("doc_id");
                        String doctor_username = rs.getString("username");
                        JOptionPane.showMessageDialog(null, "login successfull");
                        new DoctorHomePage(doctorname, doctor_id, loginId, doctor_username).setVisible(true);
                        f.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login credentials");
                        tf.setText("");
                        pf.setText("");
                    }
                } else if (loginId == 2) {
                    String q = "select * from patient where username='" + name + "' and password='" + pass + "'";
                    rs = obj.stm.executeQuery(q);
                    if (rs.next()) {
                        String patientname = rs.getString("name");
                        String patient_id = rs.getString("pat_id");
                        String patient_username = rs.getString("username");
                        JOptionPane.showMessageDialog(null, "login successfull");

                        new PatientHomePage(patientname, patient_id, loginId, patient_username).setVisible(true);
                        f.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login credentials");
                        tf.setText("");
                        pf.setText("");
                    }
                } else if (loginId == 3) {
                    String q = "select * from receptionist where username='" + name + "' and password='" + pass + "'";
                    rs = obj.stm.executeQuery(q);
                    if (rs.next()) {
                        String receptionistname = rs.getString("name");
                        String receptionistId = rs.getString("res_id");
                        String receptionist_username = rs.getString("username");
                        JOptionPane.showMessageDialog(null, "login successfull");

                        new ReceptionistHomePage(receptionistname, receptionistId, loginId, receptionist_username)
                                .setVisible(true);
                        f.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login credentials");
                        tf.setText("");
                        pf.setText("");
                    }
                } else if (loginId == 4) {
                    String q = "select * from admin where username='" + name + "' and password='" + pass + "'";
                    rs = obj.stm.executeQuery(q);
                    if (rs.next()) {
                        String adminname = rs.getString("name");
                        String admin_id = rs.getString("admin_id");
                        String admin_username = rs.getString("username");
                        JOptionPane.showMessageDialog(null, "login successfull");
                        new AdminHomePage(adminname, admin_id, loginId, admin_username).setVisible(true);
                        f.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login credentials");
                        tf.setText("");
                        pf.setText("");
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == bt2) {
            f.setVisible(false);
            new Index();
        } else if (ae.getSource() == registerButton) {
            // Open the registration window for the respective role when the "Register" button is clicked
            switch (loginId) {
                case 1:
                    new DoctorRegistrationPage();
                    break;
                case 2:
                    new PatientRegistrationPage();
                    break;
                case 3:
                    new ReceptionistRegistrationPage();
                    break;
                case 4:
                    new AdminRegisterPage();
                    break;
                default:
                    // Handle unknown role
                    break;
            }
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        // Change the argument to 2, 3, or 4 for patient, receptionist, or admin login
        new LoginPage(1);
    }
}
