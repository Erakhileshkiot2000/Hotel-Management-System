package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {
    Choice c1;
    JButton b1,b2,b3;
    JTextField t1;
    JCheckBox cb;

    CheckOut(){

        JLabel l1 = new JLabel("Check Out");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.setBounds(100,0,150,30);
        add(l1);

        JLabel l2 = new JLabel("Customer Id");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer");;
            while(rs.next()){
                c1.add(rs.getString("number"));

            }

        }catch (Exception exception){
            System.out.println(exception);
        }
        c1.setBounds(150,80,150,25);
        add(c1);

        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);

        t1 =new JTextField();
        t1.setBounds(150,130,172,25);
        add(t1);

        b1 = new JButton("CheckOut");
        b1.addActionListener(this);
        b1.setBounds(100,200,90,30);
        add(b1);


        b2 = new JButton("Back" );
        b2.addActionListener(this);
        b2.setBounds(200,200,80,30);
        add(b2);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/hotel2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(20,22,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.addActionListener(this);
        b3.setBounds(300,80,20,22);
        add(b3);

       /*
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/hotel2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1900,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel I1 = new JLabel(i3);
        I1.setBounds(0,0,1900,1000);
        add(I1);
        */



        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(550,300,700,400);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1){
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number = '"+id+"'";
            String str1 = "update room set available  = 'Available' where room = '"+room+"'";
            Conn c = new Conn();
            try{
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Successfully Preformed CheckOut Operation");
                new Reception().setVisible(true);
                this.setVisible(false);
                }catch (Exception exception){
                System.out.println(exception);
            }



        }else if (e.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource() == b3){
            Conn c = new Conn();
            String id = c1.getSelectedItem();

            try{
                ResultSet rs = c.s.executeQuery("select *from customer where number = '"+id+"'");
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                }
            }catch (Exception ae){
                System.out.println(ae);
            }

        }

    }

    public static void main(String[] args) {
        new CheckOut().setVisible(true);
    }
}
