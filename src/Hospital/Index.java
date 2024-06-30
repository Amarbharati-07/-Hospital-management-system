package Hospital;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class RoundedButton extends JButton {

    public RoundedButton(String text, Color bgColor) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setBackground(bgColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground().darker());
        } else {
            g.setColor(getBackground());
        }

        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.fillRoundRect(0, 0, width, height, 20, 20);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.white);
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawRoundRect(0, 0, width, height, 20, 20);
    }
}

public class Index extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4;
    RoundedButton b1, b2, b3, b4;
    public int loginId;

    Index() {
        f = new JFrame("Index Page");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 1200, 800);
        l1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/Icons/firstpage.jpg"));
        Image il = img.getImage().getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(il);
        l1.setIcon(img1);

        l2 = new JLabel("Medical Group");
        l2.setBounds(150, 400, 800, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 40));
        l2.setForeground(Color.white);
        l1.add(l2);

        l3 = new JLabel("Provide best quality healthcare for you");
        l3.setBounds(186, 440, 800, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.white);
        l1.add(l3);

        b1 = new RoundedButton("DOCTOR", new Color(46, 204, 113)); // Green
        b1.setBounds(100, 500, 200, 50);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new RoundedButton("Patient", new Color(231, 76, 60)); // Red
        b2.setBounds(350, 500, 200, 50);
        b2.addActionListener(this);
        l1.add(b2);

        b3 = new RoundedButton("Reception", new Color(52, 152, 219)); // Blue
        b3.setBounds(100, 570, 200, 50);
        b3.addActionListener(this);
        l1.add(b3);

        b4 = new RoundedButton("Admin", new Color(241, 196, 15)); // Yellow
        b4.setBounds(350, 570, 200, 50);
        b4.addActionListener(this);
        l1.add(b4);

        f.add(l1);

        f.setSize(1200, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1 || ae.getSource() == b2 || ae.getSource() == b3 || ae.getSource() == b4) {
            loginId = ae.getSource() == b1 ? 1 : ae.getSource() == b2 ? 2 : ae.getSource() == b3 ? 3 : 4;
            f.setVisible(false);
            new LoginPage(loginId); // Make sure LoginPage class handles login properly
        }
    }

    public static void main(String[] args) {
        new Index();
    }
}

