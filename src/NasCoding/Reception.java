package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;

    Reception() {
        b1 = new JButton("New Customer Form");
        b1.addActionListener(this);
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setFont(new Font("Arial", Font.PLAIN, 15));
        b1.setBounds(50, 20, 180, 30);
        add(b1);

        b2 = new JButton("Room");
        b2.addActionListener(this);
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setFont(new Font("Arial", Font.PLAIN, 15));
        b2.setBounds(50, 60, 180, 30);
        add(b2);

        b3 = new JButton("Department");
        b3.addActionListener(this);
        b3.setFont(new Font("Arial", Font.PLAIN, 15));
        b3.setBackground(Color.LIGHT_GRAY);
        b3.setBounds(50, 100, 180, 30);
        add(b3);

        b4 = new JButton("All Employee Info");
        b4.addActionListener(this);
        b4.setBackground(Color.LIGHT_GRAY);
        b4.setFont(new Font("Arial", Font.PLAIN, 15));
        b4.setBounds(50, 140, 180, 30);
        add(b4);

        b5 = new JButton("Customer Info");
        b5.addActionListener(this);
        b5.setBackground(Color.LIGHT_GRAY);
        b5.setFont(new Font("Arial", Font.PLAIN, 15));
        b5.setBounds(50, 180, 180, 30);
        add(b5);

        b6 = new JButton("Manager Info");
        b6.setBackground(Color.LIGHT_GRAY);
        b6.addActionListener(this);
        b6.setFont(new Font("Arial", Font.PLAIN, 15));
        b6.setBounds(50, 220, 180, 30);
        add(b6);

        b7 = new JButton("Check Out");
        b7.setBackground(Color.LIGHT_GRAY);
        b7.addActionListener(this);
        b7.setFont(new Font("Arial", Font.PLAIN, 15));
        b7.setBounds(50, 260, 180, 30);
        add(b7);

        b8 = new JButton("Update Check Status");
        b8.setBackground(Color.LIGHT_GRAY);
        b8.addActionListener(this);
        b8.setFont(new Font("Arial", Font.PLAIN, 15));
        b8.setBounds(50, 300, 180, 30);
        add(b8);

        b9 = new JButton("Update Room Status");
        b9.setBackground(Color.LIGHT_GRAY);
        b9.addActionListener(this);
        b9.setFont(new Font("Arial", Font.PLAIN, 15));
        b9.setBounds(50, 340, 180, 30);
        add(b9);


        b10 = new JButton("PickUp Service");
        b10.addActionListener(this);
        b10.setBackground(Color.LIGHT_GRAY);
        b10.setFont(new Font("Arial", Font.PLAIN, 15));
        b10.setBounds(50, 380, 180, 30);
        add(b10);

        b11 = new JButton("Search Room");
        b11.addActionListener(this);
        b11.setBackground(Color.LIGHT_GRAY);
        b11.setFont(new Font("Arial", Font.PLAIN, 15));
        b11.setBounds(50, 420, 180, 30);
        add(b11);

        b12 = new JButton("Logout");
        b12.setBackground(Color.LIGHT_GRAY);
        b12.addActionListener(this);
        b12.setFont(new Font("Arial", Font.PLAIN, 15));
        b12.setBounds(50, 460, 85, 30);
        add(b12);

        b13 = new JButton("Cancel");
        b13.setBackground(Color.LIGHT_GRAY);
        b13.addActionListener(this);
        b13.setFont(new Font("Arial", Font.PLAIN, 15));
        b13.setBounds(145, 460, 85, 30);
        add(b13);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images"));
        JLabel I1 = new JLabel(i1);
        I1.setBounds(450, 20, 500, 500);
        add(I1);


        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(500, 200, 1000, 600);
        setVisible(true);


    }


    public static void main(String[] args) {
        new Reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new AddCustomer().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource() == b2) {
            new Room().setVisible(true);
            this.setVisible(false);
        }else if (e.getSource() == b3) {

        }else if (e.getSource() == b4) {
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource() == b5) {

        }else if (e.getSource() == b6) {
            new ManagerInfo().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource() == b7) {
            new CheckOut().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource() == b8) {

            new UpdateCheck().setVisible(true);
            this.setVisible(false);
        }else if (e.getSource() == b9) {
            new UpdateRoom().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource() == b10) {

        }else if (e.getSource() == b11) {
            new SearchRoom().setVisible(true);
            this.setVisible(false);

        }else if (e.getSource() == b12) {
            setVisible(false);
        }else if (e.getSource() == b13) {
            setVisible(false);
        }
    }
}
