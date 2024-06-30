package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.Random;

public class ReceptionistRegistrationPage implements ActionListener, ItemListener {

    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16;
    JTextField t1, t2, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    JPasswordField t3;
    JButton bt1, bt2;
    JComboBox<String> genderComboBox, bloodComboBox;

    ReceptionistRegistrationPage() {
        f = new JFrame("Receptionist Registration");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/reg.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);

        l2 = new JLabel("Registration Receptionist");
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

        l6 = new JLabel("Email");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.black);
        l1.add(l6);

        t4 = new JTextField();
        t4.setBounds(600, 200, 150, 30);
        l1.add(t4);

        l7 = new JLabel("Father Name");
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

        l9 = new JLabel("Qualification");
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

        // Creating a Gender JComboBox
        String[] genders = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genders);
        genderComboBox.setBounds(200, 350, 150, 30);
        l1.add(genderComboBox);

        l12 = new JLabel("Blood Group");
        l12.setBounds(450, 350, 140, 30);
        l12.setFont(new Font("Arial", Font.BOLD, 20));
        l12.setForeground(Color.black);
        l1.add(l12);

        // Creating a Blood Group JComboBox
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        bloodComboBox = new JComboBox<>(bloodGroups);
        bloodComboBox.setBounds(600, 350, 150, 30);
        l1.add(bloodComboBox);

        l13 = new JLabel("Joining date");
        l13.setBounds(450, 400, 150, 30);
        l13.setFont(new Font("Arial", Font.BOLD, 20));
        l13.setForeground(Color.black);
        l1.add(l13);

        t11 = new JTextField();
        t11.setBounds(600, 400, 150, 30);
        l1.add(t11);

        l14 = new JLabel("Age");
        l14.setBounds(450, 450, 150, 30);
        l14.setFont(new Font("Arial", Font.BOLD, 20));
        l14.setForeground(Color.black);
        l1.add(l14);

        t12 = new JTextField();
        t12.setBounds(600, 450, 150, 30);
        l1.add(t12);

        l15 = new JLabel("Address");
        l15.setBounds(50, 400, 120, 30);
        l15.setFont(new Font("Arial", Font.BOLD, 20));
        l15.setForeground(Color.black);
        l1.add(l15);

        t13 = new JTextField();
        t13.setBounds(200, 400, 150, 30);
        l1.add(t13);

        l16 = new JLabel("Date of Birth");
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
            // Code to handle the submit button click

            String name = t1.getText();
            String username = t2.getText();
            String password = new String(t3.getPassword());
            String email = t4.getText();
            String fname = t5.getText();
            String phone = t6.getText();
            String qualification = t7.getText();
            String city = t8.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            String blood = (String) bloodComboBox.getSelectedItem();
            String joining_data = t11.getText();
            String age = t12.getText();
            String address = t13.getText();
            String dob = t14.getText();

            // Validate if any field is empty
            if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty() || fname.isEmpty()
                    || phone.isEmpty() || qualification.isEmpty() || city.isEmpty() || gender.isEmpty()
                    || blood.isEmpty() || joining_data.isEmpty() || age.isEmpty() || address.isEmpty() || dob.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the details", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
            } else {
                // Validate Date of Birth format (assuming MM/DD/YYYY)
                if (!dob.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d$")) {
                    JOptionPane.showMessageDialog(null, "Invalid Date of Birth format. Please use MM/DD/YYYY.", "Invalid Format", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Validate Joining Date format (assuming MM/DD/YYYY)
                    if (!joining_data.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(19|20)\\d\\d$")) {
                        JOptionPane.showMessageDialog(null, "Invalid Joining Date format. Please use MM/DD/YYYY.", "Invalid Format", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // Validate Password format (assuming at least 8 characters with at least one uppercase, one lowercase, and one digit)
                        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                            JOptionPane.showMessageDialog(null, "Invalid Password format. It must contain at least 8 characters with at least one uppercase letter, one lowercase letter, and one digit.", "Invalid Format", JOptionPane.WARNING_MESSAGE);
                        } else {
                            // Validate Email format
                            if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
                                JOptionPane.showMessageDialog(null, "Invalid Email format. Please enter a valid email address.", "Invalid Format", JOptionPane.WARNING_MESSAGE);
                            } else {
                                // Validate Phone number format (assuming 10 digits)
                                if (!phone.matches("^\\d{10}$")) {
                                    JOptionPane.showMessageDialog(null, "Invalid Phone number format. Please enter a 10-digit phone number.", "Invalid Format", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    // Check for duplicate entries
                                    String duplicateEntryMessage = checkDuplicateEntries(username, email, phone);
                                    if (duplicateEntryMessage != null) {
                                        JOptionPane.showMessageDialog(null, "Registration failed. " + duplicateEntryMessage, "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        // Continue with the insertion logic
                                        Random r = new Random();
                                        String res_id = "" + Math.abs(r.nextInt() % 100000);

                                        try {
                                            ConnectionClass obj = new ConnectionClass();
                                            String q = "INSERT INTO receptionist (res_id, name, username, password, email, father_name, phone, qualification, city, gender, blood, joining_date, age, address, dob) VALUES('" + res_id + "', '" + name + "', '" + username + "', '" + password + "', '" + email + "','" + fname + "', '" + phone + "', '" + qualification + "', '" + city + "', '" + gender + "', '" + blood + "', '" + joining_data + "', '" + age + "', '" + address + "', '" + dob + "')";
                                            obj.stm.executeUpdate(q);
                                            JOptionPane.showMessageDialog(null, "Receptionist Detail Successfully Inserted");
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (e.getSource() == bt2) {
            f.dispose();
            new Index();
        }
    }

    // Function to check duplicate entries
    private String checkDuplicateEntries(String username, String email, String phone) {
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "SELECT * FROM receptionist WHERE username='" + username + "' OR email='" + email + "' OR phone='" + phone + "'";
            ResultSet rs = obj.stm.executeQuery(q);

            if (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    return "Username is already registered.";
                } else if (rs.getString("email").equals(email)) {
                    return "Email is already registered.";
                } else if (rs.getString("phone").equals(phone)) {
                    return "Phone number is already registered.";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void itemStateChanged(ItemEvent e) {
       if (e.getSource() == genderComboBox) {
            // Code to handle Gender JComboBox item state change
            String selectedGender = (String) genderComboBox.getSelectedItem();
            System.out.println("Selected Gender: " + selectedGender);
        } else if (e.getSource() == bloodComboBox) {
            // Code to handle Blood Group JComboBox item state change
            String selectedBloodGroup = (String) bloodComboBox.getSelectedItem();
            System.out.println("Selected Blood Group: " + selectedBloodGroup);
        }
    }

    public static void main(String[] args) {
        new ReceptionistRegistrationPage();
    }
}
