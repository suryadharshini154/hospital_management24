package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textfield;
    JPasswordField jpasswordfield;
    JButton b1,b2;

    login(){
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

        textfield = new JTextField();
        textfield.setBounds(150,20,150,30);
        textfield.setFont(new Font("Tahoma",Font.PLAIN,15));
        textfield.setBackground(new Color(0, 255, 247, 255));
        add(textfield);


        jpasswordfield = new JPasswordField();
        jpasswordfield.setBounds(150,70,150,30);
        jpasswordfield.setFont(new Font("Tahoma",Font.PLAIN,15));
        jpasswordfield.setBackground(new Color(0,255,247));
        add(jpasswordfield);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/1.png"));
        Image i1=imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30 );
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);




        getContentPane().setBackground(new Color(255, 255, 255, 255));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

if(e.getSource()==b1) {
    try {
        conn c = new conn();
        String user = textfield.getText();
        String pass = jpasswordfield.getText();

        String q="select*from login where ID='"+user+"' and PW='"+pass+"'";
        ResultSet resultSet=c.statement.executeQuery(q);
        if(resultSet.next()){
            new Reception();
            setVisible(false);
        }else {
            JOptionPane.showMessageDialog(null,"Invalid Username or Password");
        }

    }catch(Exception E){
        E.printStackTrace();
    }
}else{
System.exit(0);
}
    }

public static void main(String[] args) {
    new login();

}
}