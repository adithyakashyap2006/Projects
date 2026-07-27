import javax.swing.*;
import java.awt.*;
import java.awt.event .*;
public class quizlogin extends JFrame implements ActionListener
{
    JButton rules, back;
    JTextField tfname;
    quizlogin()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel();
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("Simple minds!");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 40));
        heading.setForeground(Color.blue);
        add(heading);

        JLabel name = new JLabel("Enter your name:");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("mongolian Baiti", Font.BOLD, 20));
        name.setForeground(Color.blue);
        add(name);

         tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Calibri", Font.BOLD, 20));
        add(tfname);

        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(Color.black);
        rules.setForeground(Color.white);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setLocation(200, 150);
        setSize(1200, 500);
        setVisible(true);
    }    

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == rules)
        {
            String name = tfname.getText()
            setVisible(false);
            new Rules(name);
        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
        }
    }
}
