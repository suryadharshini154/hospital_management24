package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame{

    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(255, 255, 255, 255));
        add(panel);

        ImageIcon i111=new ImageIcon(ClassLoader.getSystemResource("icon/1.png"));
        Image image2=i111.getImage().getScaledInstance(500,500,Image.SCALE_SMOOTH);
        ImageIcon i221=new ImageIcon(image2);
        JLabel label2=new JLabel(i111);
        label2.setBounds(500,50,500,500);
        panel.add(label2);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(0, 255, 247));
        add(panel1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/medi.png"));
Image image=i1.getImage().getScaledInstance(128,128,Image.SCALE_DEFAULT);
ImageIcon i2=new ImageIcon(image);
JLabel label=new JLabel(i2);
label.setBounds(1300,0,250,150);
panel1.add(label);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/ambulance.png"));
        Image image1=i11.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i22=new ImageIcon(image1);
        JLabel label1=new JLabel(i22);
        label1.setBounds(1150,50,300,100);
        panel1.add(label1);







        JButton btn1=new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(169, 246, 118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btn2=new JButton("room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(169, 246, 118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
new Room();
            }
        });

        JButton btn3=new JButton("department");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(169, 246, 118));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
new Department();
            }
        });

        JButton btn4=new JButton("all employee info");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(169, 246, 118));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
new Employee_info();
            }
        });

        JButton btn5=new JButton("add patient");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(new Color(169, 246, 118));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new All_Patient_Info();

            }
        });

        JButton btn6=new JButton("patient discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(new Color(169, 246, 118));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
new patient_discharge();
            }
        });

        JButton btn7=new JButton("update patient details");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(169, 246, 118));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new update_patient_details();
            }
        });

        JButton btn8=new JButton("hospital ambulance");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(new Color(169, 246, 118));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
 new Ambulance();
            }
        });

        JButton btn9=new JButton("search room");
        btn9.setBounds(510,100,200,30);
        btn9.setBackground(new Color(169, 246, 118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new SearchRoom();
            }
        });

        JButton btn10=new JButton("log out");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(new Color(169, 246, 118));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
setVisible(false);
new login();
            }
        });

        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
         new Reception();

    }
}



