package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT  extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textFieldName, textFieldDisease, textFieldDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;

    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(61, 166, 205));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelID.setForeground(Color.BLACK);
        panel.add(labelID);

        comboBox = new JComboBox(new String[]{"Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(253, 253, 253));
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelNumber.setForeground(Color.BLACK);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelName1.setForeground(Color.BLACK);
        panel.add(labelName1);

        textFieldName = new JTextField();
        textFieldName.setBounds(271, 151, 150, 20);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelGender.setForeground(Color.BLACK);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 15));
        r1.setForeground(Color.BLACK);
        r1.setBounds(271, 191, 80, 15);
        r1.setBackground(new Color(253, 253, 253));
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 15));
        r2.setForeground(Color.BLACK);
        r2.setBounds(350, 191, 80, 15);
        r2.setBackground(new Color(253, 253, 253));
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelDisease.setForeground(Color.BLACK);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelRoom.setForeground(Color.BLACK);
        panel.add(labelRoom);

        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
    }catch (Exception e){
        e.printStackTrace();
        }

c1.setBounds(271,274,150,20);
c1.setFont(new Font("Tahoma", Font.BOLD, 18));
c1.setForeground(Color.BLACK);
c1.setBackground(new Color(253, 245, 248));
panel.add(c1);


        JLabel labelDate = new JLabel("Time");
        labelDate.setBounds(35, 316, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelDate.setForeground(Color.BLACK);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 316, 250, 14);
        date.setFont(new Font("Tahoma", Font.BOLD, 15));
        date.setForeground(Color.BLACK);
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit");
        labelDeposit.setBounds(35, 359, 200, 17);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelDeposit.setForeground(Color.BLACK);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposit);

        b1 = new JButton("Add");
        b1.setBounds(100, 430, 120, 30);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260, 430, 120, 30);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);
setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if (e.getSource()==b1){

    conn c=new conn();
    String radioBTN=null;
    if(r1.isSelected()) {
        radioBTN = "Male";
    }else if(r2.isSelected()) {
        radioBTN = "Female";
    }
    String s1=(String)comboBox.getSelectedItem();
    String s2=(String)textFieldNumber.getText();
    String s3=(String)textFieldName.getText();
    String s4=(String)radioBTN;
    String s5=(String)textFieldDisease.getText();
    String s6=(String)c1.getSelectedItem();
    String s7=(String)date.getText();
    String s8=(String)textFieldDeposit.getText();

    try {
        String q="insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
        String q1="update Room set Availability='Occupied'where room_no="+s6;
        c.statement.execute(q);
        c.statement.executeUpdate(q1);
        JOptionPane.showMessageDialog(null, "Added Successfully");
        setVisible(false);

    }catch (Exception e1) {
        e1.printStackTrace();
    }

    }else{
    setVisible(false);
    }

}
public static void main(String[] args) {
        new NEW_PATIENT();
    }
}
