import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.*;
import java.text.*; // the above two packages help to display the time of the text sent
import java.net.*;
import java.io.*;

import java.awt.event.*;
import java.util.Calendar;
public class Server implements ActionListener
{
    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame(); // making the functions static so as to access them in the main() function
    static DataOutputStream dot;
    Server()
    {
        f.setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(Color.GREEN);
        p1.setBounds(0,0,450,70);
        p1.setBounds(null);
        f.add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\Adithya\\Documents\\icons\\1.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,25,25); // setting image dimensions
        p1.add(back); // adding image on top of the panel

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae)
            {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\Adithya\\Documents\\icons\\1.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40,10,50,50); // the distance from x axis and y axis is changed to accomodate the photo
        p1.add(profile); 

         ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\Adithya\\Documents\\icons\\video.png"));
        Image i8 = i7.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300,20,30,30); 
        p1.add(video); // this portion of code is to display the video call button at the top right 

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\Adithya\\Documents\\icons\\phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360,20,35,35); 
        p1.add(phone); // to display the phone call button at the top corner

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\Adithya\\Documents\\icons\\3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420,20,10,25);
        p1.add(morevert); // to display the three dots which contains more options 

        JLabel name = new JLabel("Adithya");
        name.setBounds(110, 15,100, 20);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20)); // manipulation of the name text
        p1.add(name);

        JLabel status = new JLabel("Active now");
        status.setBounds(110, 35,100, 20);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14)); // Setting the status of the user
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(5, 75, 425, 570);
        f.add(a1);

        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text); // to display the text box for typing messages 

        JButton send = new JButton("send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);


        f.setSize(450, 700);
        f.setLocation(300,100);
        f.getContentPane().setBackground(Color.BLUE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String out = text.getText();
            JPanel p2 = formatLabel(out);
            a1.setLayout(new BorderLayout());
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);// alignment of the messages on the right side for the sender 
            vertical.add(Box.createVerticalStrut(15)); // the number speicifies the gap between two messages
            a1.add(vertical, BorderLayout.PAGE_START);

            dot.writeUTF(out);
            text.setText("");// this method helps to delete the text in the text box after the send button is clicked

            f.repaint();
            f.invalidate();
            f.validate(); // these functions ensure the message is sent when the send button is clicked
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static JPanel formatLabel(String out)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel output  = new JLabel(out);
        output.setFont(new Font("Tahoma", Font.PLAIN, 17));
        output.setBackground(new Color(37, 120, 100));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output); 

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime())); // this function is used to get real time data 

    }
    public static void main(String args[])
    {
        new Server();
        try
        {
            ServerSocket skt = new ServerSocket(6001);
            while(true)
            {
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dot = new DataOutputStream(s.getOutputStream());
                // the above two lines take the input and display the text for infinite messages
                while(true)
                {
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg); // to display send message text
                    JPanel left = new JPanel(new BorderLayout()); // to display recieved messages
                    left.add(panel, BorderLayout.LINE_START);// to display recieved messages at the left 
                    vertical.add(left);
                    f.validate();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
