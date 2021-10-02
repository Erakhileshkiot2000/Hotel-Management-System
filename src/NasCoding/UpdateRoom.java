package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;

    UpdateRoom(){


        JLabel l1 = new JLabel("Guest Id");
        l1.setFont(new Font("Arial",Font.PLAIN,17));
        l1.setBounds(40,60,150,30);
        add(l1);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            String str = "select *from customer";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()){
                c1.add(rs.getString("number"));
            }
        } catch (Exception e) {

        }
        c1.setBounds(220,60,200,30);
        add(c1);

        JLabel l2 = new JLabel("Room Number");
        l2.setFont(new Font("Arial",Font.PLAIN,17));
        l2.setBounds(40,120,150,30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(220,120,200,25);
        add(t1);


        JLabel l3 = new JLabel("Availablity");
        l3.setFont(new Font("Arial",Font.PLAIN,17));
        l3.setBounds(40,180,150,30);
        add(l3);

        t2 = new JTextField();
        t2.setBounds(220,180,200,25);
        add(t2);


        JLabel l4 = new JLabel("Clean Status");
        l4.setFont(new Font("Arial",Font.PLAIN,17));
        l4.setBounds(40,240,150,30);
        add(l4);

        t3 = new JTextField();
        t3.setBounds(220,240,200,25);
        add(t3);

        b2 = new JButton("UpdateRoom");
        b2.setBackground(Color.GREEN);
        b2.addActionListener(this);
        b2.setBounds(150,340,110,30);
        b2.setFont(new Font("Arial",Font.TYPE1_FONT,12));
        add(b2);

        b1 = new JButton("Check");
        b1.setBackground(Color.GREEN);
        b1.addActionListener(this);
        b1.setBounds(265,340,80,30);
        b1.setFont(new Font("Arial",Font.TYPE1_FONT,12));
        add(b1);

        b3 = new JButton("Back");
        b3.setBackground(Color.GREEN);
        b3.addActionListener(this);
        b3.setBounds(350,340,80,30);
        b3.setFont(new Font("Arial",Font.TYPE1_FONT,12));
        add(b3);


        setLayout(null);
        setBounds(500,200,1000,500);
        getContentPane().setBackground(Color.white);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            String room = null;
            String s1 = c1.getSelectedItem();
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select *from customer where number = '"+s1+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                    room = rs.getString("room");
                }
                ResultSet rs2 = c.s.executeQuery("select *from room where room_number = '"+room+"'");
                while (rs2.next()) {
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("status"));
                }

            } catch (Exception exception) {

                System.out.println(exception);
            }

        }else if (e.getSource() == b2){


        }else if (e.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);

        }

    }

    public static void main(String[] args) {
        new UpdateRoom().setVisible(true);
    }
}
