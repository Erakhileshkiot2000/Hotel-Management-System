package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    Room(){

        l1 = new JLabel("Room Id");
        l1.setBounds(10,10,100,30);
        l1.setFont(new Font("Arial",Font.BOLD,15));
        add(l1);

        l2 = new JLabel("Aavailabilty");
        l2.setBounds(110,10,100,30);
        l2.setFont(new Font("Arial",Font.BOLD,15));
        add(l2);

        l3 = new JLabel("Status");
        l3.setBounds(210,10,100,30);
        l3.setFont(new Font("Arial",Font.BOLD,15));
        add(l3);

        l4 = new JLabel("price");
        l4.setBounds(310,10,100,30);
        l4.setFont(new Font("Arial",Font.BOLD,17));
        add(l4);

        l4 = new JLabel("Type");
        l4.setBounds(408,10,150,30);
        l4.setFont(new Font("Arial",Font.BOLD,17));
        add(l4);


        t1 = new JTable();
        t1.setRowHeight(27);
        t1.setFont(new Font("Arial",Font.PLAIN,16));
        t1.setBounds(10,40,500, 400);
        add(t1);

        b1  = new JButton("Load Data");
        b1.addActionListener(this);
        b1.addActionListener(this);
        b1.setBounds(150,450,95,30);
        add(b1);

        b2  = new JButton("Cancel");
        b2.addActionListener(this);
        b2.addActionListener(this);
        b2.setBounds(250,450,95,30);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/home.jpg"));
        JLabel I1 = new JLabel(i1);
        I1.setBounds(510, 20, 465, 465);
        add(I1);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(400,200,1000,540);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1){
            try{
                Conn c = new Conn();
                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
}

