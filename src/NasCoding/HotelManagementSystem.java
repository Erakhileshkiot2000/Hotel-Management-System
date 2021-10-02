package NasCoding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("NasCoding/images/home.jpg"));
        JLabel I1 = new JLabel(i1);
        I1.setBounds(0,0,2000,1000);
        add(I1);

        JLabel I2 = new JLabel("Welcome To Hotel Management System");
        I2.setBounds(10,800,700,40);
        I2.setForeground(Color.orange);
        I2.setFont(new Font("Astral", Font.BOLD,35));
        I1.add(I2);

        JButton B1 = new JButton("Next");
        B1.setBackground(Color.CYAN);
        B1.setForeground(Color.black);
        B1.addActionListener(this);
        B1.setBounds(1700,850,100,50);
        B1.setFont(new Font("Astral",Font.BOLD,24));
        I1.add(B1);



        setBounds(0,0,2000,1000);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        //setVisible(true);

        while (true){
            I2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            I2.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e) {

            }
        }


    }

    public static void main(String[] args) {

        new HotelManagementSystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new Login().setVisible(true);
        this.setVisible(false);
    }
}
