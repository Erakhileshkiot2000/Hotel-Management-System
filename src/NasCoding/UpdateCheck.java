package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    Choice c1;

    UpdateCheck(){

        JLabel l1 = new JLabel("Customer_ID");
        l1.setBounds(40,60,150,30);
        l1.setFont(new Font("Arial",Font.PLAIN,17));
        add(l1);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer");
            while (rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception exception){
            System.out.println(exception);
        }
        c1.setBounds(260,60,200,30);
        add(c1);


        JLabel l2 = new JLabel("Room_No");
        l2.setBounds(40,120,150,30);
        l2.setFont(new Font("Arial",Font.PLAIN,17));
        add(l2);

        t1 = new JTextField();
        t1.setBounds(260,120,200,25);
        add(t1);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(40,180,150,30);
        l3.setFont(new Font("Arial",Font.PLAIN,17));
        add(l3);

        t2 = new JTextField();
        t2.setBounds(260,180,200,25);
        add(t2);

        JLabel l4 = new JLabel("Check_In");
        l4.setBounds(40,240,150,30);
        l4.setFont(new Font("Arial",Font.PLAIN,17));
        add(l4);

        t3 = new JTextField();
        t3.setBounds(260,240,200,25);
        add(t3);

        JLabel l5 = new JLabel("Amount_Paid");
        l5.setBounds(40,300,150,30);
        l5.setFont(new Font("Arial",Font.PLAIN,17));
        add(l5);

        t4 = new JTextField();
        t4.setBounds(260,300,200,25);
        add(t4);

        JLabel l6 = new JLabel("Amount_Pending");
        l6.setBounds(40,360,150,30);
        l6.setFont(new Font("Arial",Font.PLAIN,17));
        add(l6);

        t5 = new JTextField();
        t5.setBounds(260,360,200,25);
        add(t5);

        b1 = new JButton("Check");
        b1.addActionListener(this);
        b1.setFont(new Font("Arial",Font.PLAIN,15));
        b1.setBounds(150,430,80,30);
        b1.setBackground(Color.cyan);
        add(b1);

        b2 = new JButton("Update");
        b2.addActionListener(this);
        b2.setFont(new Font("Arial",Font.PLAIN,15));
        b2.setBounds(235,430,80,30);
        b2.setBackground(Color.GREEN);
        add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Arial",Font.PLAIN,15));
        b3.setBounds(320,430,80,30);
        b3.setBackground(Color.red);
        add(b3);


        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setForeground(Color.BLACK);
        setBackground(Color.white);
        setBounds(400,200,1000,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try{
                String room = null;
                int ammountPaid;
                String deposit = null;
                String price = null;
                Conn c = new Conn();
                String id = c1.getSelectedItem();
                String str = "select *from customer where number = '"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));
                    price = rs.getString("price");
                    deposit = rs.getString("deposit");

                }

               // ResultSet rs2 = c.s.executeQuery("select *from room where room_number = '"+room+"'");
                String str1 = "select *from room where room_number = '"+room+"'";
                ResultSet rs2 = c.s.executeQuery(str1);


                while(rs2.next()){
                   price = rs2.getString("price");

                   ammountPaid = (Integer.parseInt(price) - Integer.parseInt(deposit));
                   if (ammountPaid == 0 ) {
                       t5.setText(Integer.toString(0));
                   }else {
                       t5.setText(Integer.toString(ammountPaid));
                   }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }else if (e.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateCheck().setVisible(true);
    }
}
