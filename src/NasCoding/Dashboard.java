package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard(){
        mb = new JMenuBar();
        add(mb);

        m1 = new JMenu("Hotel Management");
        m1.setForeground(Color.BLUE);
        mb.add(m1);

        m2 = new JMenu("Admin");
        m2.setForeground(Color.magenta);
        mb.add(m2);

        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("Add Drivers");
        m2.add(i4);
        i4.addActionListener(this);

        mb.setBounds(0,0,1900,30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/hotel2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1900,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel I1 = new JLabel(i3);
        I1.setBounds(0,0,1900,1000);
        add(I1);



        setLayout(null);
        setBounds(0,0,1900,1000);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);
        }else if (e.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }else if (e.getActionCommand().equals("Add Rooms")){
            new AddRoom().setVisible(true);
        }else if (e.getActionCommand().equals("Add Drivers")){
            new AddDriver().setVisible(true);
        }
    }
}
