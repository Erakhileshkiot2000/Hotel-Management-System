package NasCoding;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    JRadioButton r1,r2;
    JComboBox c1;
    Choice c2 ;
    AddCustomer(){
        JLabel L1 = new JLabel("NEW CUSTOMER FORM");
        L1.setFont(new Font("Arial",Font.BOLD,25));
        L1.setForeground(Color.BLACK);
        L1.setBounds(100,10,300,30);
        add(L1);

        JLabel l1 = new JLabel("ID");
        l1.setFont(new Font("Arial",Font.PLAIN,17));
        l1.setBounds(30,60,100,30);
        add(l1);

        c1 = new JComboBox(new String[]{"VoterIdCard","DrivingLisence","AdharCard","PanCrad"});
        c1.setBounds(280,60,200,25);
        c1.setBackground(Color.white);
        c1.setForeground(Color.BLACK);
        add(c1);


        JLabel l2 = new JLabel("Number");
        l2.setFont(new Font("Arial",Font.PLAIN,17));
        l2.setBounds(30,100,100,30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(280,100,200,25);
        add(t1);


        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("Arial",Font.PLAIN,17));
        l3.setBounds(30,140,100,30);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(280,140,200,25);
        add(t2);

        JLabel l4 = new JLabel("Gender");
        l4.setFont(new Font("Arial",Font.PLAIN,17));
        l4.setBounds(30,180,100,30);
        add(l4);

        r1 = new JRadioButton("Male");
        r1.setBounds(280,180,70,25);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setBounds(350,180,70,25);
        add(r2);

        JLabel l5 = new JLabel("Country");
        l5.setFont(new Font("Arial",Font.PLAIN,17));
        l5.setBounds(30,220,100,30);
        add(l5);

        t3 = new JTextField();
        t3.setBounds(280,220,200,25);
        add(t3);

        JLabel l6 = new JLabel("Allocated Room Number");
        l6.setFont(new Font("Arial",Font.PLAIN,17));
        l6.setBounds(30,260,200,30);
        add(l6);

        JLabel l7 = new JLabel("Checked In");
        l7.setFont(new Font("Arial",Font.PLAIN,17));
        l7.setBounds(30,300,100,30);
        add(l7);

        t4 = new JTextField();
        t4.setBounds(280,300,200,25);
        add(t4);



        JLabel l8 = new JLabel("Deposit");
        l8.setFont(new Font("Arial",Font.PLAIN,17));
        l8.setBounds(30,340,100,30);
        add(l8);

        t5 = new JTextField();
        t5.setBounds(280,340,200,25);
        add(t5);


        b1 = new JButton("Add Customer");
        b1.setForeground(Color.black);
        b1.setBackground(Color.green);
        b1.addActionListener(this);
        b1.setBounds(160,420,120,30);
        add(b1);

        b3 = new JButton("Reset");
        b3.addActionListener(this);
        b3.setBackground(Color.darkGray);
        b3.setForeground(Color.white);
        b3.setBounds(285,420,100,30);
        add(b3);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBackground(Color.PINK);
        b2.setBounds(390,420,100,30);
        add(b2);

        c2  = new Choice();
        try {
            Conn c = new Conn();
            String str = "select *from room";
            ResultSet rs  = c.s.executeQuery(str);
            while (rs.next()){
                c2.add(rs.getString("room_number"));
            }

        } catch (Exception e) {
        }
        c2.setBounds(280,260,200,25);
        add(c2);


        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(400,200,1000,540);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String id = (String) c1.getSelectedItem();
            String number = t1.getText();
            String name = t2.getText();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }
            String country = t3.getText();
            String room = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();

            String str = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + status + "','" + deposit + "')";
            String str1 = "update room set available = 'occupied' where room_number = '" + room + "'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "New Customer Added Succssfully");
                new Reception().setVisible(true);
                this.setVisible(false);

            } catch (Exception exception) {
                System.out.println(exception);
            }
        }else if (ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddCustomer().setVisible(true);
    }
}
