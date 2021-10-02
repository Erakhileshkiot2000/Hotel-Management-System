package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    ManagerInfo(){

        l1 = new JLabel("NAME");
        l1.setBounds(10,10,100,30);
        l1.setFont(new Font("Arial",Font.BOLD,15));
        add(l1);

        l2 = new JLabel("AGE");
        l2.setBounds(160,10,100,30);
        l2.setFont(new Font("Arial",Font.BOLD,15));
        add(l2);

        l3 = new JLabel("GENDER");
        l3.setBounds(300,10,100,30);
        l3.setFont(new Font("Arial",Font.BOLD,15));
        add(l3);

        l4 = new JLabel("JOB");
        l4.setBounds(438,10,100,30);
        l4.setFont(new Font("Arial",Font.BOLD,17));
        add(l4);

        l5 = new JLabel("SALARY");
        l5.setBounds(587,10,100,30);
        l5.setFont(new Font("Arial",Font.BOLD,17));
        add(l5);

        l6 = new JLabel("PHONE");
        l6.setBounds(740,10,100,30);
        l6.setFont(new Font("Arial",Font.BOLD,17));
        add(l6);

        l7 = new JLabel("AADHAR");
        l7.setBounds(875,10,100,30);
        l7.setFont(new Font("Arial",Font.BOLD,17));
        add(l7);

        l8 = new JLabel("EMAIL");
        l8.setBounds(1020,10,200,30);
        l8.setFont(new Font("Arial",Font.BOLD,17));
        add(l8);


        t1 = new JTable();
        t1.setRowHeight(27);
        t1.setFont(new Font("Arial",Font.PLAIN,16));
        t1.setBounds(10,50,1150, 500);
        add(t1);

        b1  = new JButton("Load Data");
        b1.addActionListener(this);
        b1.addActionListener(this);
        b1.setBounds(400,560,95,30);
        add(b1);

        b2  = new JButton("Cancel");
        b2.addActionListener(this);
        b2.addActionListener(this);
        b2.setBounds(500,560,95,30);
        add(b2);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        //setFocusableWindowState(true);
        setBounds(400,200,1200,650);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerInfo().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1){
            try{
                Conn c = new Conn();
                String str = "select * from employee where job = 'Manager'";
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
