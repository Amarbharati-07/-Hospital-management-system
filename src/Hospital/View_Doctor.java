package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class View_Doctor extends JFrame implements ActionListener {

    String x[] = {"Name", "Username", "DOB", "Address", "Phone", "Email", "City", "gender", "Blood group", "Age", "ClinicNo", "Joining Date", "Specialization", "Availability"};
    JButton bt, bt1;
    String y[][] = new String[20][14];
    int i = 0, j = 0;
    JTable t;
    JLabel l1, l2;
    JTextField tf1;
    JPanel p1, p2, p3;
    Font f, f1;
    int login_id;

    View_Doctor(int login_id) {
        super("Doctor Information");
        setSize(1500, 400);
        setLocation(1, 1);

        this.login_id = login_id;

        f = new Font("MS UI Gothic", Font.BOLD, 15);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from doctor";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("username");
                y[i][j++] = rest.getString("dob");
                y[i][j++] = rest.getString("address");
                y[i][j++] = rest.getString("phone");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("city");
                y[i][j++] = rest.getString("gender");
                y[i][j++] = rest.getString("blood");
                y[i][j++] = rest.getString("age");
                y[i][j++] = rest.getString("clinic_number");
                y[i][j++] = rest.getString("joining_date");
                y[i][j++] = rest.getString("specialization");
                y[i][j++] = rest.getString("availability");
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

        if (login_id == 4) { // Assuming admin has login_id 4
            f1 = new Font("Lucida Fax", Font.BOLD, 25);
            l1 = new JLabel("Doctor Username");
            l2 = new JLabel("Delete or Edit any Doctor?");
            l2.setHorizontalAlignment(JLabel.CENTER);

            l1.setForeground(Color.gray);
            l2.setForeground(Color.yellow);
            l1.setFont(f1);
            l2.setFont(f1);

            bt = new JButton("Delete Doctor");
            bt1 = new JButton("Edit Doctor Record");

            bt.addActionListener(this);
            bt1.addActionListener(this);

            bt.setBackground(Color.black);
            bt1.setBackground(Color.black);

            bt.setForeground(Color.red);
            bt1.setForeground(Color.red);

            tf1 = new JTextField();
            tf1.setFont(f);

            p1 = new JPanel();
            p1.setLayout(new GridLayout(1, 1, 10, 10));
            p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1, 4, 10, 10));
            p2.add(l1);
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
        }

        JScrollPane sp = new JScrollPane(t);
        add(sp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = tf1.getText();
        if (ae.getSource() == bt) {
            try {
                ConnectionClass obj1 = new ConnectionClass();
                String q = "DELETE FROM doctor WHERE username='" + username + "'";
                JOptionPane.showMessageDialog(null,"Doctor deleted sucessfullyc");
                obj1.stm.executeUpdate(q);
                String q2 = "UPDATE appointement SET appoitement_status='Cancel' WHERE doctor_username='" + username + "' AND appoitement_status='Open'";
                obj1.stm.executeUpdate(q2);
                //obj1.connectionClose(); // close the connection
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (ae.getSource() == bt1) {
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill doctor username!");
            } else {
                setVisible(false);
                new Edit_Doctor(username).setVisible(true);
            }
        }
    }

    //public static void main(String[] args) {
       // new View_Doctor(4).setVisible(true); // Assuming login_id for admin is 4
    //}
}
