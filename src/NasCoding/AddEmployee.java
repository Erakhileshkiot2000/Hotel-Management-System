package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class AddEmployee extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3;
    JComboBox c1;
    JButton b1;
    JLabel j1;
    JTextField t1 ,t2, t3,t4,t5,t6;


    AddEmployee(){

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial",Font.BOLD,20));
        name.setBounds(60,30,120,25);
        add(name);

        t1 = new JTextField();
        t1.setBounds(150,30,150,25);
        add(t1);


        JLabel age = new JLabel("Age");
        age.setFont(new Font("Arial",Font.BOLD,20));
        age.setBounds(60,65,120,25);
        add(age);

        t2 = new JTextField();
        t2.setBounds(150,65,150,25);
        add(t2);

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(60,100,120,25);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial",Font.PLAIN,15));
        r1.setBounds(150,100,60,30);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Arial",Font.PLAIN,15));
        r2.setBounds(210,100,90,30);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Arial",Font.PLAIN,15));
        r3.setBounds(300,100,70,30);
        r3.setBackground(Color.white);
        add(r3);


        JLabel job = new JLabel("Job");
        job.setFont(new Font("Arial",Font.BOLD,20));
        job.setBounds(60,140,120,25);
        add(job);

        String str[] = {"Front Desk Clerk","Porters","House Keeping","Kitchen staff","Room Service","Waiters/Waitresses","Manager","Accountant",};
        c1 =new JComboBox(str);
        c1.setBackground(Color.white);
        c1.setBounds(150,140,150,25);
        add(c1);

        JLabel salary = new JLabel("Salary");
        salary.setFont(new Font("Arial",Font.BOLD,20));
        salary.setBounds(60,175,120,25);
        add(salary);

        t3 = new JTextField();
        t3.setBounds(150,175,150,25);
        add(t3);

        JLabel adhar = new JLabel("Aadhar");
        adhar.setFont(new Font("Arial",Font.BOLD,20));
        adhar.setBounds(60,245,120,25);
        add(adhar);

        t5 = new JTextField();
        t5.setBounds(150,245,150,25);
        add(t5);

        JLabel number = new JLabel("Phone");
        number.setFont(new Font("Arial",Font.BOLD,20));
        number.setBounds(60,210,120,25);
        add(number);

        t4 = new JTextField();
        t4.setBounds(150,210,150,25);
        add(t4);

        JLabel email = new JLabel("Email");
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(60,280,120,25);
        add(email);

        t6 = new JTextField();
        t6.setBounds(150,280,150,25);
        add(t6);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/doublebed.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel I1 = new JLabel(i3);
        I1.setBounds(380,33,400,450);
        add(I1);
        getContentPane().setBackground(Color.white);

        b1 = new JButton("Submit");
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setBounds(120,320,120,30);
        add(b1);

        j1  = new JLabel("Add Employee Details");
        j1.setBounds(420,0,350,35);
        j1.setFont(new Font("Arial",Font.BOLD,22));
        add(j1);


        setLayout(null);
        setBounds(400,300,800,500);
        //setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String Name = t1.getText();
        String Age = t2.getText();
        String Salary = t3.getText();
        String Phone = t4.getText();
        String Aadhar = t5.getText();
        String Email = t6.getText();

        String Gender = null;
        if (r1.isSelected()){
            Gender = "Male";
        }else if (r2.isSelected()){
            Gender = "Female";
        }else if (r3.isSelected()){
            Gender = "Other";
        }

        String Job = (String) c1.getSelectedItem();
        Conn c= new Conn();
        String str = "insert into employee values('"+Name+"','"+Age+"','"+Gender+"','"+Job+"','"+Salary+"','"+Phone+"','"+Aadhar+"','"+Email+"')";

        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Employee detail added Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
