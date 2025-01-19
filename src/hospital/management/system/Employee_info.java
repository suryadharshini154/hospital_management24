package hospital.management.system;

import net.proteanit.sql.DbUtils;
import net.proteanit.sql.JTableUpdateDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Employee_info extends JFrame {
    Employee_info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(61, 166, 205));
panel.setLayout(null);
add(panel);


        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBackground(new Color(61, 166, 205));
        panel.add(table);

        try{
            conn c = new conn();
            String q= "select * from EMP_INFO";
            ResultSet resultSet= c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setBounds(41, 9, 70, 20);
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setBounds(180, 9, 70, 20);
        panel.add(label2);

        JLabel label3 = new JLabel("Phone Number");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setBounds(350, 9, 150, 20);
        panel.add(label3);

        JLabel label4 = new JLabel("Salary");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setBounds(550, 9, 150, 20);
        panel.add(label4);

        JLabel label5 = new JLabel("Gmail");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setBounds(730, 9, 150, 20);
        panel.add(label5);

        JLabel label6 = new JLabel("Aadhar Number");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setBounds(830, 9, 150, 20);
        panel.add(label6);

        JButton button = new JButton("Back");

        button.setBounds(350,490,120,30);
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
                setSize(1000, 550);
                setLayout(null);
                setLocation(250, 230);
                setVisible(true);
            }


            public static void main(String[] args) {
                new Employee_info();
            }
        }
