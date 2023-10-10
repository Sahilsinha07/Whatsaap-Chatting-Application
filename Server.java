import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar; // this is for calender
import java.text.SimpleDateFormat; // simple date format to format the date

public class Server extends JFrame implements ActionListener { // inheritance
    JTextField text; // here we are gloabbly declaring the text field and not locally so that we can
                     // use the ActionListner class public method as earlier it was declared inside
                     // the constructor
    JPanel textingArea;
    Box vertical = Box.createVerticalBox(); // because messages ik ke neeche ik aaienge

    Server() {

        // constructor for class server. when the compiler comes it finds main fxn and
        // see a object of class Server and the constructor is initilalized immediately.
        // jaise hi run kare waise hi frame dikhna start ho jaie
        setLayout(null);

        JPanel Header = new JPanel(); // panel is used to make frame on the existing frame
        Header.setBackground(new Color(7, 94, 84));
        Header.setBounds(0, 0, 450, 70); // setting panel coordinates
        add(Header); // add fxn is used to add anything on frame
        Header.setLayout(null); // used to make the layout null by java, so fxns work properly

        // this is for back button image setting and mouse click

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png")); // used to pick images from the
                                                                                    // system directory
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); // this is used to scale image to the
                                                                                 // default

        // image is in i1 but scalled image is in i2 so
        ImageIcon i3 = new ImageIcon(i2); // converting image into image icon

        JLabel back = new JLabel(i3); // passing imageicon through this

        back.setBounds(0, 20, 25, 25);
        Header.add(back); // adding image on the panel

        back.addMouseListener(new MouseAdapter() { // here we are adding mosue click on back image icon and overriding a
                                                   // abstract method in
                                                   // the class
            public void mouseClicked(MouseEvent ae) {
                System.exit(0); // this will end the program
            }
        });

        // this is for profile picture

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);

        ImageIcon i6 = new ImageIcon(i5);

        JLabel profilePicture = new JLabel(i6);

        profilePicture.setBounds(40, 10, 50, 50);
        Header.add(profilePicture);

        // for video call

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);

        ImageIcon i9 = new ImageIcon(i8);

        JLabel videoCall = new JLabel(i9);

        videoCall.setBounds(300, 20, 30, 30);
        Header.add(videoCall);

        // for phone
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);

        ImageIcon i12 = new ImageIcon(i11);

        JLabel phone = new JLabel(i12);

        phone.setBounds(360, 20, 35, 30);
        Header.add(phone);

        // for more icon 3 dots
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);

        ImageIcon i15 = new ImageIcon(i14);

        JLabel moreoption = new JLabel(i15);

        moreoption.setBounds(420, 20, 10, 25);
        Header.add(moreoption);

        // now we have to write the name. to write any name on the frame we use JLabel
        JLabel name = new JLabel("Sahil");
        name.setForeground(Color.WHITE);
        name.setBounds(110, 15, 100, 18);
        name.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        Header.add(name);

        // Active now status
        JLabel status = new JLabel("Active Now");
        status.setForeground(Color.WHITE);
        status.setBounds(110, 37, 100, 14);
        status.setFont(new Font("SANS SERIF", Font.BOLD, 11));
        Header.add(status);

        // Now we are creating the messaging area
        textingArea = new JPanel();
        textingArea.setBounds(5, 75, 440, 570);
        add(textingArea);
        textingArea.setLayout(null); // if this wont be there then rest other designs wont be applied
        setUndecorated(true);

        // Text field area where user can enter their messages
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SANS SERIF", Font.PLAIN, 16));
        add(text);

        // send button
        JButton send = new JButton("SEND");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SANS SERIF", Font.PLAIN, 14));
        add(send);

        setSize(450, 700);
        setLocation(200, 50);
        getContentPane().setBackground(Color.WHITE); // getContentPane is to pick up the whole frame. Color is a class
                                                     // of AWT so import java.awt.*
        setVisible(true);
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String out = text.getText();
        textingArea.setLayout(new BorderLayout()); // place around the border
        JPanel right = new JPanel(new BorderLayout());
        JPanel p2 = formatLabel(out);
        right.add(p2, BorderLayout.LINE_END); // this would align the mesage to the right
        // we cannot pass a string here but a panel can be passed
        vertical.add(right); // to align the multiple mesages one below the another.
        vertical.add(Box.createVerticalStrut(15)); // to tell height between two messages

        textingArea.add(vertical, BorderLayout.PAGE_START); // adding to texting area
        text.setText(" "); // to make the text field empty after message sent
        repaint();
        invalidate();
        validate();
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // we are basically making a box around the message
        JLabel output = new JLabel("<html><p style=\" width : 150px\">" + out + "</p><html>");
        // here we are implementing html tag with java so we can get a defined width of
        // the message box
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true); // this function is to make the background color visibile
        output.setBorder(new EmptyBorder(15, 15, 15, 50)); // we are giving padding to the messages.

        // Now we want time of the message so we can use calender class
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // chaneg time format
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime())); // dynamically sets time in the label time

        panel.add(time);

        panel.add(output);
        return panel;
    }

    public static void main(String args[]) {
        new Server(); // this is an anynomous object
    }
}