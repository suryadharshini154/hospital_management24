package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(61, 166, 205));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBackground(new Color(61, 166, 205));
        panel.add(table);

        try{
            conn c = new conn();
            String q= "select * from Ambulance";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setBounds(31, 11, 100, 14);
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setBounds(225, 11, 100, 14);
        panel.add(label2);

        JLabel label3 = new JLabel("Car Name");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setBounds(366, 11, 100, 14);
        panel.add(label3);

        JLabel label4 = new JLabel("Available");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setBounds(550, 11, 100, 14);
        panel.add(label4);

        JLabel label5= new JLabel("Location");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setBounds(725, 11, 100, 14);
        panel.add(label5);

        JButton button = new JButton("Back");

        button.setBounds(400,500,120,30);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 200);
        setVisible(true);

    }
    public static void main(String[] args) {

    }
}