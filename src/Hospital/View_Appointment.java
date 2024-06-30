package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class View_Appointment extends JFrame implements ActionListener {

    String x[] = {"Appointment Id", "Username", "Name", "Email", "Father Name", "Phone", "Material Status", "City", "Gender", "Blood Group", "Age", "DOB", "Decease", "Doctor", "Appointment Date", "Appointment Time", "Appointment Status"};
    String y[][] = new String[20][17];
    int i = 0, j = 0;
    JTable t;
    JLabel l1, l2;
    JTextField tf1;
    JButton bt, bt1;
    JPanel p1, p2, p3;
    Font f, f1;
    String q;

    View_Appointment(String username, int login_id) {
        super("Appointment Information");
        setSize(1500, 400);
        setLocation(1, 1);

        f = new Font("MS UI Gothic", Font.BOLD, 15);

        try {
            ConnectionClass obj = new ConnectionClass();
            if (login_id == 1) {
                q = "SELECT * FROM appointement WHERE doctor_username='" + username + "'";
            } else if (login_id == 2) {
                q = "SELECT * FROM appointement WHERE p_username='" + username + "'";
            } else {
                q = "SELECT * FROM appointement";
            }
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("app_id");
                y[i][j++] = rest.getString("p_username");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("fname");
                y[i][j++] = rest.getString("phone");
                y[i][j++] = rest.getString("material_status");
                y[i][j++] = rest.getString("city");
                y[i][j++] = rest.getString("gender");
                y[i][j++] = rest.getString("blood");
                y[i][j++] = rest.getString("age");
                y[i][j++] = rest.getString("dob");
                y[i][j++] = rest.getString("decease");
                y[i][j++] = rest.getString("doctor_username");
                y[i][j++] = rest.getString("appointement_date");
                y[i][j++] = rest.getString("appoitement_time");
                y[i][j++] = rest.getString("appoitement_status");

                i++;
                j = 0;
            }
            t = new JTable(y, x);
            t.setFont(f);
            t.setBackground(Color.black);
            t.setForeground(Color.white);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        f1 = new Font("Lucida Fax", Font.BOLD, 25);
        l1 = new JLabel("Complete or Cancel any Appointment Status?");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.yellow);

        l2 = new JLabel("Appointment Id");
        l2.setFont(f1);
        l2.setForeground(Color.gray);

        tf1 = new JTextField();
        tf1.setFont(f1);

        bt = new JButton("Complete Appointment");
        bt1 = new JButton("Cancel Appointment");

        bt.addActionListener(this);
        bt1.addActionListener(this);
        bt.setBackground(Color.black);
        bt1.setBackground(Color.black);
        bt.setForeground(Color.red);
        bt1.setForeground(Color.red);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 4, 10, 10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(bt);
        p2.add(bt1);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 1, 10, 10));
        p3.add(p1);
        p3.add(p2);

        p1.setBackground(Color.black);
        p2.setBackground(Color.black);
        p3.setBackground(Color.black);

        add(p3, "South");

        add(sp);
    }

    public void actionPerformed(ActionEvent ae) {
        String app_id = tf1.getText();
        if (ae.getSource() == bt) {
            if (app_id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the appointment ID");
            } else {
                try {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q2 = "UPDATE appointement SET appoitement_status='complete' WHERE app_id = '" + app_id + "'";
                    JOptionPane.showMessageDialog(null, "Appointment completed ");
                    int aa = obj1.stm.executeUpdate(q2);
                    if (aa == 0) {
                        JOptionPane.showMessageDialog(null, "Appointment ID not found");
                    }
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        if (ae.getSource() == bt1) {
            if (app_id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in the appointment ID");
            } else {
                try {
                    ConnectionClass obj1 = new ConnectionClass();
                    String q2 = "UPDATE appointement SET appoitement_status='cancel' WHERE app_id = '" + app_id + "'";
                    JOptionPane.showMessageDialog(null, "Appointment cancel ");
                    int aa = obj1.stm.executeUpdate(q2);
                    if (aa == 0) {
                        JOptionPane.showMessageDialog(null, "Appointment ID not found");
                    }
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //public static void main(String[] args) {
        //new View_Appointment().setVisible(true);
    /// }
}
