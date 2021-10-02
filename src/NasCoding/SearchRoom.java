package NasCoding;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JTable t1;
    JButton b1,b2;
    SearchRoom(){

        JLabel l1 = new JLabel("Search For room");
        l1.setBounds(10,50,150,30);
        l1.setFont(new Font("Arial",Font.PLAIN,17));
        add(l1);

        c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(200,50,150,25);
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Only Display Available");
        c2.setBounds(500,50,150,25);
        c2.setBackground(Color.white);
        add(c2);

        t1 = new JTable();
        t1.setBounds(10,150,790,330);
        add(t1);

        b1 = new JButton("Submit");
        b1.setBounds(300,500,100,30);
        b1.setFont(new Font("Arial",Font.PLAIN,17));
        b1.setBackground(Color.green);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

       // room_number | available | status  | price | type

        JLabel s1 = new JLabel("Room_number");
        s1.setBounds(10,120,100,30);
        add(s1);

        JLabel s2 = new JLabel("Available");
        s2.setBounds(170,120,100,30);
        add(s2);

        JLabel s3 = new JLabel("Status");
        s3.setBounds(330,120,100,30);
        add(s3);

        JLabel s4 = new JLabel("Price");
        s4.setBounds(485,120,100,30);
        add(s4);

        JLabel s5 = new JLabel("Type");
        s5.setBounds(640,120,100,30);
        add(s5);

        b2 = new JButton("Back");
        b2.setBounds(410,500,100,30);
        b2.setFont(new Font("Arial",Font.PLAIN,17));
        b2.setBackground(Color.green);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        setBounds(500,200,800,600);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == b1){
            try {
                Conn c = new Conn();
                String str = "select *from room where type = '"+c1.getSelectedItem()+"'";
                String str1 = "select *from room where available = 'Available' and type = '"+c1.getSelectedItem()+"'";
                ResultSet rs ;
                if (c2.isSelected()){
                    rs = c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

                }else {
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }else if (event.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String arg[]){
        new SearchRoom().setVisible(true);
    }
}
