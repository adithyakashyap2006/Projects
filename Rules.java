package src;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton start, back;
    Rules(String name)
    {
        this.name = name;
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel heading = new JLabel("Welcome" + name + "to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        heading.setForeground(Color.blue);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 28));
        rules.setForeground(Color.blue);
        rules.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
        );
        add(rules);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(800, 650);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == start)
        {

        }
        else
        {
            setVisible(false);
            new quizlogin();
        }
    }
    public static void main(String args[])
    {
        new Rules("User");
    }
}
