package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class AdminRegisterPage implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JTextField t1, t2, t3, t4, t5, t6, t8;
    JComboBox<String> genderComboBox;
    JButton bt1, bt2;

    public AdminRegisterPage() {
        f = new JFrame("Admin Registration");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/reg.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Admin Registration");
        l2.setBounds(280, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.black);
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Username");
        l3.setBounds(50, 150, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.black);
        l1.add(l3);

        t1 = new JTextField();
        t1.setBounds(200, 150, 150, 30);
        l1.add(t1);

        l4 = new JLabel("Name");
        l4.setBounds(450, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.black);
        l1.add(l4);

        t2 = new JTextField();
        t2.setBounds(600, 150, 150, 30);
        l1.add(t2);

        l5 = new JLabel("Age");
        l5.setBounds(50, 200, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.black);
        l1.add(l5);

        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 30);
        l1.add(t3);

        l6 = new JLabel("Phone");
        l6.setBounds(450, 200, 100, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.black);
        l1.add(l6);

        t4 = new JTextField();
        t4.setBounds(600, 200, 150, 30);
        l1.add(t4);

        l7 = new JLabel("City");
        l7.setBounds(50, 250, 100, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.black);
        l1.add(l7);

        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 30);
        l1.add(t5);

        l8 = new JLabel("Email");
        l8.setBounds(450, 250, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setForeground(Color.black);
        l1.add(l8);

        t6 = new JTextField();
        t6.setBounds(600, 250, 150, 30);
        l1.add(t6);

        // Adding a dropdown for gender selection
        l9 = new JLabel("Gender");
        l9.setBounds(50, 300, 100, 30);
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setForeground(Color.black);
        l1.add(l9);

        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(200, 300, 150, 30);
        l1.add(genderComboBox);

        // Adding fields for password
        l10 = new JLabel("Password");
        l10.setBounds(450, 300, 100, 30);
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setForeground(Color.black);
        l1.add(l10);

        t8 = new JTextField();
        t8.setBounds(600, 300, 150, 30);
        l1.add(t8);

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
            registerAdmin();
        } else if (e.getSource() == bt2) {
            f.dispose();
            new Index();
            
        }
    }

    private void registerAdmin() {
        String username = t1.getText();
        String name = t2.getText();
        String age = t3.getText();
        String phone = t4.getText();
        String city = t5.getText();
        String email = t6.getText();
        String gender = Objects.requireNonNull(genderComboBox.getSelectedItem()).toString();
        String password = t8.getText();

        if (!validateFields(username, name, age, phone, city, email, password)) {
            return;
        }

        // Check if username, phone, or email already exists
        if (usernameExists(username)) {
            JOptionPane.showMessageDialog(null, "Username already exists. Please use a different username.");
            return;
        }

        if (phoneExists(phone)) {
            JOptionPane.showMessageDialog(null, "Phone number already exists. Please use a different phone number.");
            return;
        }

        if (emailExists(email)) {
            JOptionPane.showMessageDialog(null, "Email already exists. Please use a different email address.");
            return;
        }

        // admin_id is excluded from the columns to insert as it's auto-incremented
        String q = "INSERT INTO admin (username, name, age, phone, city, email, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ConnectionClass obj = new ConnectionClass();
            try (PreparedStatement pst = obj.con.prepareStatement(q)) {
                pst.setString(1, username);
                pst.setString(2, name);
                pst.setString(3, age);
                pst.setString(4, phone);
                pst.setString(5, city);
                pst.setString(6, email);
                pst.setString(7, gender);
                pst.setString(8, password);

                pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Admin Successfully Registered");
            f.dispose();
            new Index();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean validateFields(String username, String name, String age, String phone, String city, String email, String password) {
        if (username.equals("") || name.equals("") || age.equals("") || phone.equals("") || city.equals("") || email.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the details");
            return false;
        }

        if (!isValidAge(age)) {
            JOptionPane.showMessageDialog(null, "Invalid age. Please enter a valid age.");
            return false;
        }

        if (!isValidPhone(phone)) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter a valid 10-digit phone number.");
            return false;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(null, "Invalid email. Please enter a valid email address.");
            return false;
        }

        return true;
    }

    private boolean isValidAge(String age) {
        try {
            int ageInt = Integer.parseInt(age);
            return ageInt > 0 && ageInt < 150; // Assuming a reasonable age range
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }

    private boolean usernameExists(String username) {
        return checkIfExists("SELECT * FROM admin WHERE username=?", username);
    }

    private boolean phoneExists(String phone) {
        return checkIfExists("SELECT * FROM admin WHERE phone=?", phone);
    }

    private boolean emailExists(String email) {
        return checkIfExists("SELECT * FROM admin WHERE email=?", email);
    }

    private boolean checkIfExists(String query, String value) {
        try {
            ConnectionClass obj = new ConnectionClass();
            try (PreparedStatement pst = obj.con.prepareStatement(query)) {
                pst.setString(1, value);
                try (ResultSet rs = pst.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //public static void main(String[] args) {
        //new AdminRegisterPage();
   // }
}
