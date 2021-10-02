package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;

    AddDriver(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/doublebed.jpg"));
        JLabel I1 = new JLabel(i1);
        I1.setBounds(450,20,400,452);
        add(I1);


        JLabel l1 = new JLabel("Add Driver");
        l1.setFont(new Font("Arial",Font.BOLD,25));
        l1.setBounds(250,0,200,30);
        add(l1);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial",Font.PLAIN,20));
        name.setBounds(60,60,100,30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(250,60,200,25);
        add(t1);

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Arial",Font.PLAIN,20));
        age.setBounds(60,120,100,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(250,120,200,25);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Arial",Font.PLAIN,20));
        gender.setBounds(60,180,100,30);
        add(gender);

        c1 = new JComboBox(new String[]{"Male","Female","Other"});
        c1.setBackground(Color.white);
        c1.setBounds(250,180,200,25);
        add(c1);

        JLabel company = new JLabel("Car Company");
        company.setFont(new Font("Arial",Font.PLAIN,20));
        company.setBounds(60,240,150,30);
        add(company);

        t3 = new JTextField();
        t3.setBounds(250,240,200,25);
        add(t3);

        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("Arial",Font.PLAIN,20));
        model.setBounds(60,300,150,30);
        add(model);

        t4 = new JTextField();
        t4.setBounds(250,300,200,25);
        add(t4);

        JLabel available = new JLabel("Available");
        available.setFont(new Font("Arial",Font.PLAIN,20));
        available.setBounds(60,360,100,30);
        add(available);

        c2 = new JComboBox(new String[]{"Available","Occupied"});
        c2.setBackground(Color.white);
        c2.setBounds(250,360,200,25);
        add(c2);


        JLabel location = new JLabel("Location");
        location.setFont(new Font("Arial",Font.PLAIN,20));
        location.setBounds(60,420,100,30);
        add(location);

        t5 = new JTextField();
        t5.setBounds(250,420,200,25);
        add(t5);


        b1 = new JButton("Add Driver");
        b1.addActionListener(this);
        b1.setBounds(300,465,100,30);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(400,465,100,30);
        b2.addActionListener(this);
        add(b2);


        setBounds(450,200,870,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
       new AddDriver().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1){
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String) c1.getSelectedItem();
            String company = t3.getText();
            String model = t4.getText();
            String available = (String) c2.getSelectedItem();
            String location = t5.getText();

            Conn c = new Conn();
            try {
            String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver Detail updated successfully");
            } catch (Exception e) {
                System.out.println(e);
            }

        }else if (ae.getSource() == b2){
            this.setVisible(false);
        }
    }
}
