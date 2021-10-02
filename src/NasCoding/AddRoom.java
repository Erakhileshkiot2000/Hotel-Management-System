package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {

    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    AddRoom(){
        JLabel l1 = new JLabel("Add Rooms");
        l1.setBounds(200,10,200,30);
        l1.setFont(new Font("Arial",Font.PLAIN,30));
        add(l1);

        JLabel room = new JLabel("Room Number");
        room.setFont(new Font("Arial",Font.PLAIN,16));
        room.setBounds(60,80,120,30);
        add(room);

        t1 = new JTextField();
        t1.setBounds(200,80,200,30);
        add(t1);



        JLabel available = new JLabel("Available");
        available.setFont(new Font("Arial",Font.PLAIN,16));
        available.setBounds(60,130,120,30);
        add(available);

        c1 = new JComboBox(new String[]{"Available","Occupied"});
        c1.setBounds(200,130,200,30);
        add(c1);

        JLabel status = new JLabel("Cleaning Status");
        status.setFont(new Font("Arial",Font.PLAIN,16));
        status.setBounds(60,180,120,30);
        add(status);

        c2 = new JComboBox(new String[]{"Cleaned","Dirty"});
        c2.setBounds(200,180,200,30);
        add(c2);

        JLabel price = new JLabel("Price");
        price.setFont(new Font("Arial",Font.PLAIN,16));
        price.setBounds(60,230,120,30);
        add(price);

        t2 = new JTextField();
        t2.setBounds(200,230,200,30);
        add(t2);

        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Arial",Font.PLAIN,16));
        type.setBounds(60,280,120,30);
        add(type);

        c3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(200,280,200,30);
        add(c3);

        b1 = new JButton("Add Room");
        b1.setBounds(160,330,95,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(260,330,90,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/doublebed.jpg"));
        JLabel I1 = new JLabel(i1);
        I1.setBounds(450,20,400,452);
        add(I1);

        setBounds(450,200,870,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String room_number  = t1.getText();
            String available = (String) c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price = t2.getText();
            String type = (String) c3.getSelectedItem();

            Conn c = new Conn();
            try{
                String str = "insert into room values('"+room_number+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null , "New Room added successfully");
            } catch (Exception exception) {
                System.out.println(e);
            }

        }else if (e.getSource() == b2){
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRoom().setVisible(true);
    }
}
