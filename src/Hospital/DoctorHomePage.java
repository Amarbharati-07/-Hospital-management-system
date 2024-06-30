package Hospital;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DoctorHomePage extends JFrame implements ActionListener {
    JPanel contentPane;  // JPanel to hold the background image
    JLabel l1;
    Font f, f1, f2;
    
    public String doctor_id2;
    int login__id;
    String username2;

    public DoctorHomePage(String doctorname, String doctor_id, int login_id,String username) {
        super("Doctor Home Page");
        setLocation(0, 0);
        setSize(1500, 730);
        doctor_id2 = doctor_id;
        login__id = login_id;
        username2=username;

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/doctor.jpg"));
                Image img = ic.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        setContentPane(contentPane);

        f = new Font("Lucida fax", Font.BOLD, 20);
        f1 = new Font("Gaudai", Font.BOLD, 35);
        f2 = new Font("MS UI Gothic", Font.BOLD, 20);

        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Doctor");
        JMenuItem ment2 = new JMenuItem("View Doctor");

        JMenu men2 = new JMenu("Patient");
        JMenuItem ment4 = new JMenuItem("View Patient");

        JMenu men3 = new JMenu("Receptionist");
        JMenuItem ment6 = new JMenuItem("View Receptionist");

        JMenu men4 = new JMenu("Appointment");
        JMenuItem ment8 = new JMenuItem("View Appointment");

        JMenu men5 = new JMenu("Hi, Doctor (" + doctorname + ")");
        JMenuItem ment9 = new JMenuItem("My Profile");
        JMenuItem ment10 = new JMenuItem("Change Password");

        JMenu men8 = new JMenu("Exit");
        JMenuItem ment14 = new JMenuItem("Exit");

        men1.add(ment2);
        men2.add(ment4);
        men3.add(ment6);
        men4.add(ment8);
        men5.add(ment9);
        men5.add(ment10);
        men8.add(ment14);

        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men8);

        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men8.setFont(f);

        ment2.setFont(f1);
        ment4.setFont(f1);
        ment6.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment14.setFont(f1);

        m1.setBackground(Color.black);

        men1.setForeground(Color.gray);
        men2.setForeground(Color.gray);
        men3.setForeground(Color.gray);
        men4.setForeground(Color.gray);
        men5.setForeground(Color.gray);
        men8.setForeground(Color.red);

        ment9.setForeground(Color.yellow);
        ment14.setForeground(Color.red);

        ment2.addActionListener(this);
        ment4.addActionListener(this);
        ment6.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment14.addActionListener(this);

        setJMenuBar(m1);

        setLayout(new BorderLayout());

        // Add the JLabel and set layout
        l1 = new JLabel();
        add(l1);

        setSize(1500, 730);
        setLocation(0, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String comnd = ae.getActionCommand();
        if (comnd.equals("View Doctor")) {
            new View_Doctor(login__id).setVisible(true);
        } else if (comnd.equals("View Patient")) {
            new View_Patient(username2,login__id).setVisible(true);
        } else if (comnd.equals("View Receptionist")) {
            new View_Receptionist(login__id).setVisible(true);
        } else if (comnd.equals("View Appointment")) {
            new View_Appointment(username2,login__id).setVisible(true);
        } else if (comnd.equals("My Profile")) {
            new checkMyProfile(doctor_id2,login__id);
        } else if (comnd.equals("Change Password")) {
            new ChangeMyPassword(doctor_id2);
        } else if (comnd.equals("Exit")) {
            this.setVisible(false);
            new Index();
        }
    }

    //public static void main(String[] args) {
        //new DoctorHomePage("John Doe", "123", 1).setVisible(true);
    //}
}
