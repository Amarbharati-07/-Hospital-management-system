package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Random;

public class DoctorRegistrationPage implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    JTextField t1, t2, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    JPasswordField t3;
    JButton bt1, bt2;

    public DoctorRegistrationPage() {
        f = new JFrame("Doctor Registration");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/reg.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Doctor Registration");
        l2.setBounds(280, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.black);
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Name");
        l3.setBounds(50, 150, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.black);
        l1.add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 150, 150, 30);
        l1.add(t1);

        l4 = new JLabel("Username");
        l4.setBounds(450, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.black);
        l1.add(l4);

        t2 = new JTextField();
        t2.setBounds(600, 150, 150, 30);
        l1.add(t2);

        l5 = new JLabel("Password");
        l5.setBounds(50, 200, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.black);
        l1.add(l5);

        t3 = new JPasswordField();
        t3.setBounds(200, 200, 150, 30);
        l1.add(t3);

        l6 = new JLabel("Date Of Birth");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.black);
        l1.add(l6);

        t4 = new JTextField();
        t4.setBounds(600, 200, 150, 30);
        l1.add(t4);

        l7 = new JLabel("Address");
        l7.setBounds(50, 250, 100, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.black);
        l1.add(l7);

        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 30);
        l1.add(t5);

        l8 = new JLabel("Phone");
        l8.setBounds(450, 250, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setForeground(Color.black);
        l1.add(l8);

        t6 = new JTextField();
        t6.setBounds(600, 250, 150, 30);
        l1.add(t6);

        l9 = new JLabel("Email ID");
        l9.setBounds(50, 300, 100, 30);
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setForeground(Color.black);
        l1.add(l9);

        t7 = new JTextField();
        t7.setBounds(200, 300, 150, 30);
        l1.add(t7);

        l10 = new JLabel("City");
        l10.setBounds(450, 300, 100, 30);
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setForeground(Color.black);
        l1.add(l10);

        t8 = new JTextField();
        t8.setBounds(600, 300, 150, 30);
        l1.add(t8);

        l11 = new JLabel("Gender");
        l11.setBounds(50, 350, 140, 30);
        l11.setFont(new Font("Arial", Font.BOLD, 20));
        l11.setForeground(Color.black);
        l1.add(l11);

        t9 = new JTextField();
        t9.setBounds(200, 350, 150, 30);
        l1.add(t9);

        l12 = new JLabel("Blood Group");
        l12.setBounds(450, 350, 140, 30);
        l12.setFont(new Font("Arial", Font.BOLD, 20));
        l12.setForeground(Color.black);
        l1.add(l12);

        t10 = new JTextField();
        t10.setBounds(600, 350, 150, 30);
        l1.add(t10);

        l13 = new JLabel("Age");
        l13.setBounds(450, 400, 100, 30);
        l13.setFont(new Font("Arial", Font.BOLD, 20));
        l13.setForeground(Color.black);
        l1.add(l13);

        t11 = new JTextField();
        t11.setBounds(600, 400, 150, 30);
        l1.add(t11);

        l14 = new JLabel("Clinic Number");
        l14.setBounds(450, 450, 150, 30);
        l14.setFont(new Font("Arial", Font.BOLD, 20));
        l14.setForeground(Color.black);
        l1.add(l14);

        t12 = new JTextField();
        t12.setBounds(600, 450, 150, 30);
        l1.add(t12);

        l15 = new JLabel("Joining Date");
        l15.setBounds(50, 400, 120, 30);
        l15.setFont(new Font("Arial", Font.BOLD, 20));
        l15.setForeground(Color.black);
        l1.add(l15);

        t13 = new JTextField();
        t13.setBounds(200, 400, 150, 30);
        l1.add(t13);

        l16 = new JLabel("Specialization");
        l16.setBounds(50, 450, 120, 30);
        l16.setFont(new Font("Arial", Font.BOLD, 20));
        l16.setForeground(Color.black);
        l1.add(l16);

        t14 = new JTextField();
        t14.setBounds(200, 450, 150, 30);
        l1.add(t14);

        bt1 = new JButton("Submit");
        bt1.setBackground(Color.black);
        bt1.setForeground(Color.white);
        bt1.setBounds(250, 500, 150, 40);
        l1.add(bt1);

        bt2 = new JButton("Cancel");
        bt2.setBackground(Color.red);
        bt2.setForeground(Color.white);
        bt2.setBounds(450, 500, 150, 40);
        l1.add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        f.setVisible(true);
        f.setSize(900, 600);
        f.setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            registerDoctor();
        } else if (e.getSource() == bt2) {
            f.dispose();
            new Index();
        }
    }

    private void registerDoctor() {
        String name = t1.getText();
        String username = t2.getText();
        String password = new String(t3.getPassword());
        String dob = t4.getText();
        String address = t5.getText();
        String phone = t6.getText();
        String email = t7.getText();
        String city = t8.getText();
        String gender = t9.getText();
        String blood = t10.getText();
        String age = t11.getText();
        String clinic = t12.getText();
        String jod = t13.getText();
        String splz = t14.getText();
        String avl = "yes";
        Random r = new Random();
        String doc_ll = "" + Math.abs(r.nextInt() % 100000);

        // Validate if any field is empty
        if (name.equals("") || username.equals("") || password.equals("") || dob.equals("") || address.equals("") ||
                phone.equals("") || email.equals("") || city.equals("") || gender.equals("") || blood.equals("") ||
                age.equals("") || clinic.equals("") || jod.equals("") || splz.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the details");
            return;
        }

        // Validate Date Format (YYYY-MM-DD)
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid date of birth in the format YYYY-MM-DD");
            return;
        }

        // Validate Joining Date Format (YYYY-MM-DD)
        if (!jod.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid joining date in the format YYYY-MM-DD");
            return;
        }

        // Validate Phone Number Format
        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid 10-digit phone number");
            return;
        }

        // Validate Email Format
        if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return;
        }

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "INSERT INTO doctor VALUES('" + doc_ll + "', '" + name + "', '" + username + "', '" + password + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + city + "', '" + gender + "', '" + blood + "', '" + age + "', '" + clinic + "', '" + jod + "', '" + splz + "', '" + avl + "')";
            obj.stm.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Doctor Registration Successful");
            f.dispose();
            new Index();
            f.setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in Doctor Registration");
        }
    }
    //public static void main(String[] args) {
      // new DoctorRegistrationPage();
    //}
}
