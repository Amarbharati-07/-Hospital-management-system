package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class Add_Appointment extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
    JButton bt1, bt2, bt3;
    JPanel p1, p2, p3;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, tf11, tf12;
    Font f, f1;
    Choice ch, ch1, ch2;
    String q;

    Add_Appointment() {
        super("Add appointment");
        setLocation(450, 10);
        setSize(740, 730);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 18);

        ch = new Choice();
        ch1 = new Choice();
        ch2 = new Choice();

        ch2.add("10AM");
        ch2.add("11AM");
        ch2.add("12AM");
        ch2.add("2AM");
        ch2.add("3AM");
        ch2.add("4AM");
        ch2.add("5AM");

        try {
            ConnectionClass obj = new ConnectionClass();
            q = "SELECT * FROM patient";
            ResultSet rest = obj.stm.executeQuery(q);

            while (rest.next()) {
                ch.add(rest.getString("username"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        l1 = new JLabel("Add Appointment");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Father Name");
        l6 = new JLabel("Phone");
        l7 = new JLabel("Material status");
        l8 = new JLabel("City");
        l9 = new JLabel("Gender");
        l10 = new JLabel("Blood");
        l11 = new JLabel("Age");
        l12 = new JLabel("Date Of Birth");
        l13 = new JLabel("Deceased");
        l14 = new JLabel("Check Doctor Availability");
        l15 = new JLabel("Select Doctor");
        l16 = new JLabel("Appointment Date");
        l17 = new JLabel("Appointment Time");
        l18 = new JLabel("");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        tf11 = new JTextField();
        tf12 = new JTextField();

        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        tf7.setEditable(false);
        tf8.setEditable(false);
        tf9.setEditable(false);
        tf10.setEditable(false);

        bt1 = new JButton("Book Appointment");
        bt2 = new JButton("Back");
        bt3 = new JButton("Check");

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);

        bt1.setBackground(Color.blue);
        bt2.setBackground(Color.red);
        bt3.setBackground(Color.black);

        bt1.setForeground(Color.white);
        bt2.setForeground(Color.white);
        bt3.setForeground(Color.white);
        l1.setHorizontalAlignment(JLabel.CENTER);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);
        l13.setFont(f1);
        l14.setFont(f1);
        l15.setFont(f1);
        l16.setFont(f1);
        l17.setFont(f1);
        l18.setFont(f1);

        ch.setFont(f1);
        ch1.setFont(f1);
        ch2.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        tf9.setFont(f1);
        tf10.setFont(f1);
        tf11.setFont(f1);
        tf12.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(17, 2, 10, 10));

        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(tf7);
        p2.add(l10);
        p2.add(tf8);
        p2.add(l11);
        p2.add(tf9);
        p2.add(l12);
        p2.add(tf10);
        p2.add(l13);
        p2.add(tf11);
        p2.add(l14);
        p2.add(bt3);
        p2.add(l15);
        p2.add(ch1);
        p2.add(l16);
        p2.add(tf12);
        p2.add(l17);
        p2.add(ch2);
        p2.add(bt1);
        p2.add(bt2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 10, 10));

        try {
            ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("Hospital/Icons/a.jpg"));
            Image img1 = img.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img1);
            l18.setIcon(ic1);
        } catch (NullPointerException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        p3.add(l18);

        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj2 = new ConnectionClass();
                    String username = ch.getSelectedItem();
                    String q1 = "SELECT * FROM patient WHERE username='" + username + "'";
                    ResultSet rest1 = obj2.stm.executeQuery(q1);
                    while (rest1.next()) {
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("email"));
                        tf3.setText(rest1.getString("father_name"));
                        tf4.setText(rest1.getString("phone"));
                        tf5.setText(rest1.getString("marital_status"));
                        tf6.setText(rest1.getString("city"));
                        tf7.setText(rest1.getString("gender"));
                        tf8.setText(rest1.getString("blood"));
                        tf9.setText(rest1.getString("age"));
                        tf10.setText(rest1.getString("dob"));
                        tf11.setText(rest1.getString("deceased"));
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt3) {
            ch1.removeAll();
            try {
                ConnectionClass obj3 = new ConnectionClass();
                String q1 = "SELECT * FROM doctor WHERE specialization='" + tf11.getText() + "' and availability='yes'";
                ResultSet rest4 = obj3.stm.executeQuery(q1);
                while (rest4.next()) {
                    ch1.add(rest4.getString("username"));
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        } else if (e.getSource() == bt1) {
            String username = ch.getSelectedItem();
            String name = tf1.getText();
            String email = tf2.getText();
            String fname = tf3.getText();
            String phone = tf4.getText();
            String mstatus = tf5.getText();
            String city = tf6.getText();
            String gender = tf7.getText();
            String blood = tf8.getText();
            String age = tf9.getText();
            String dob = tf10.getText();
            String deceased = tf11.getText();
            String doctor = ch1.getSelectedItem();
            String app_date = tf12.getText();
            String app_time = ch2.getSelectedItem();
            String app_status = "Open";
            Random r = new Random();
            String app_id = "" + Math.abs(r.nextInt() % 10000);

            ConnectionClass obj3 = null;
            try {
                obj3 = new ConnectionClass();
                String q1 = "INSERT INTO appointement (app_id, p_username, name, email, fname, phone, material_status, city, gender, blood, age, dob, decease, doctor_username, appointement_date,appoitement_time,appoitement_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pst = obj3.con.prepareStatement(q1)) {
                    pst.setString(1, app_id);
                    pst.setString(2, username);
                    pst.setString(3, name);
                    pst.setString(4, email);
                    pst.setString(5, fname);
                    pst.setString(6, phone);
                    pst.setString(7, mstatus);
                    pst.setString(8, city);
                    pst.setString(9, gender);
                    pst.setString(10, blood);
                    pst.setString(11, age);
                    pst.setString(12, dob);
                    pst.setString(13, deceased);
                    pst.setString(14, doctor);
                    pst.setString(15, app_date);
                    pst.setString(16, app_time);
                    pst.setString(17, app_status);

                    int aa = pst.executeUpdate();
                    if (aa == 1) {
                        JOptionPane.showMessageDialog(null, "Appointment booked successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to book appointment");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (obj3 != null) {
                    try {
                        obj3.stm.close();
                        obj3.con.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } else if (e.getSource() == bt2) {
            dispose();
        }
    }
    

    //public static void main(String[] args) {
        //new Add_Appointment().setVisible(true);
    //}
}
