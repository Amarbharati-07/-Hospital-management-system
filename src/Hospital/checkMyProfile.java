package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class checkMyProfile implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
    JButton bt1, bt2;
    public int login__id;
    ResultSet rest0, rest;
    String q2;

    public checkMyProfile(String admin_id, int login_id) {
        login__id = login_id;
        try {
            ConnectionClass obj = new ConnectionClass();
            if (login__id == 1) {
                String q = "select * from doctor where doc_id='" + admin_id + "'";
                rest0 = obj.stm.executeQuery(q);
            } else if (login__id == 2) {
                String q = "select * from patient where pat_id='" + admin_id + "'";
                rest0 = obj.stm.executeQuery(q);
            } else if (login__id == 3) {
                String q = "select * from receptionist where res_id='" + admin_id + "'";
                rest0 = obj.stm.executeQuery(q);
            } else if (login__id == 4) {
                String q = "select * from admin where admin_id='" + admin_id + "'";
                rest0 = obj.stm.executeQuery(q);
            }
            if (rest0.next()) {
                f = new JFrame("My Profile");
                f.setBackground(Color.white);
                f.setLayout(null);

                l1 = new JLabel();
                l1.setBounds(0, 0, 900, 450);
                l1.setLayout(null);
                ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/admin.jpg"));
                Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i1);
                l1.setIcon(img1);

                l2 = new JLabel("Edit My Details");
                l2.setBounds(280, 30, 500, 50);
                l2.setFont(new Font("Arial", Font.BOLD, 30));
                l2.setForeground(Color.black);
                l1.add(l2);
                f.add(l1);

                l3 = new JLabel("My id");
                l3.setBounds(50, 150, 150, 30);
                l3.setFont(new Font("Arial", Font.BOLD, 20));
                l3.setForeground(Color.black);
                l1.add(l3);

                t1 = new JTextField();
                t1.setBounds(200, 150, 150, 30);
                t1.setEnabled(false);
                l1.add(t1);

                l4 = new JLabel("Username");
                l4.setBounds(450, 150, 200, 30);
                l4.setFont(new Font("Arial", Font.BOLD, 20));
                l4.setForeground(Color.black);
                l1.add(l4);

                t2 = new JTextField();
                t2.setBounds(600, 150, 150, 30);
                t2.setEnabled(false);
                l1.add(t2);

                l5 = new JLabel("Name");
                l5.setBounds(50, 200, 100, 30);
                l5.setFont(new Font("Arial", Font.BOLD, 20));
                l5.setForeground(Color.black);
                l1.add(l5);

                t3 = new JTextField();
                t3.setBounds(200, 200, 150, 30);
                l1.add(t3);

                l6 = new JLabel("Age");
                l6.setBounds(450, 200, 200, 30);
                l6.setFont(new Font("Arial", Font.BOLD, 20));
                l6.setForeground(Color.black);
                l1.add(l6);

                t4 = new JTextField();
                t4.setBounds(600, 200, 150, 30);
                l1.add(t4);

                l7 = new JLabel("Phone");
                l7.setBounds(50, 250, 100, 30);
                l7.setFont(new Font("Arial", Font.BOLD, 20));
                l7.setForeground(Color.black);
                l1.add(l7);

                t5 = new JTextField();
                t5.setBounds(200, 250, 150, 30);
                l1.add(t5);

                l8 = new JLabel("City");
                l8.setBounds(450, 250, 100, 30);
                l8.setFont(new Font("Arial", Font.BOLD, 20));
                l8.setForeground(Color.black);
                l1.add(l8);

                t6 = new JTextField();
                t6.setBounds(600, 250, 150, 30);
                l1.add(t6);

                l9 = new JLabel("Email");
                l9.setBounds(50, 300, 100, 30);
                l9.setFont(new Font("Arial", Font.BOLD, 20));
                l9.setForeground(Color.black);
                l1.add(l9);

                t7 = new JTextField();
                t7.setBounds(200, 300, 150, 30);
                l1.add(t7);

                l10 = new JLabel("Gender");
                l10.setBounds(450, 300, 100, 30);
                l10.setFont(new Font("Arial", Font.BOLD, 20));
                l10.setForeground(Color.black);
                l1.add(l10);

                t8 = new JTextField();
                t8.setBounds(600, 300, 150, 30);
                t8.setEnabled(false);
                l1.add(t8);

                try {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q = "";
                    if (login_id == 4) {
                        q = "select * from admin where admin_id='" + admin_id + "'";
                    } else if (login_id == 3) {
                        q = "select * from receptionist where res_id='" + admin_id + "'";
                    } else if (login_id == 2) {
                        q = "select * from patient where pat_id='" + admin_id + "'";
                    } else if (login_id == 1) {
                        q = "select * from doctor where doc_id='" + admin_id + "'";
                    }
                    rest = obj.stm.executeQuery(q);

                    while (rest.next()) {
                        if (login_id == 1) {
                            t1.setText(rest.getString("doc_id"));

                        } else if (login_id == 2) {
                            t1.setText(rest.getString("pat_id"));

                        } else if (login_id == 3) {
                            t1.setText(rest.getString("res_id"));

                        } else if (login_id == 4) {
                            t1.setText(rest.getString("admin_id"));

                        }
                        t2.setText(rest.getString("username"));
                        t3.setText(rest.getString("name"));
                        t4.setText(rest.getString("age"));
                        t5.setText(rest.getString("phone"));
                        t6.setText(rest.getString("city"));
                        t7.setText(rest.getString("email"));
                        t8.setText(rest.getString("gender"));
                    }
                    rest.close();
                    obj1.stm.close();
                    obj1.con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                bt1 = new JButton("Update");
                bt1.setBackground(Color.black);
                bt1.setForeground(Color.white);
                bt1.setBounds(250, 400, 150, 40);
                l1.add(bt1);

                bt2 = new JButton("Cancel");
                bt2.setBackground(Color.red);
                bt2.setForeground(Color.white);
                bt2.setBounds(450, 400, 150, 40);
                l1.add(bt2);

                bt1.addActionListener(this);
                bt2.addActionListener(this);

                f.setVisible(true);
                f.setSize(900, 600);
                f.setLocation(300, 100);
            } else {
                JOptionPane.showMessageDialog(null, "Record not found, please fill the right admin id!");
                f.setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            String id = t1.getText();
            String name = t3.getText();
            String age = t4.getText();
            String phone = t5.getText();
            String city = t6.getText();
            String email = t7.getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                if (login__id == 4) {
                    q2 = "UPDATE admin SET name=?, age=?, phone=?, city=?, email=? WHERE admin_id=?";

                } else if (login__id == 3) {
                    q2 = "UPDATE receptionist SET name=?, age=?, phone=?, city=?, email=? WHERE res_id=?";

                } else if (login__id == 2) {
                    q2 = "UPDATE patient SET name=?, age=?, phone=?, city=?, email=? WHERE pat_id=?";

                } else if (login__id == 1) {
                    q2 = "UPDATE doctor SET name=?, age=?, phone=?, city=?, email=? WHERE doc_id=?";

                }

                PreparedStatement pst = obj.con.prepareStatement(q2);
                pst.setString(1, name);
                pst.setString(2, age);
                pst.setString(3, phone);
                pst.setString(4, city);
                pst.setString(5, email);
                pst.setString(6, id);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Details Successfully Updated");

                pst.close();
                obj.con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == bt2) {
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new checkMyProfile("86243", 3);
    }
}
