package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {


    update_patient_details(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(61, 166, 205));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1= new JLabel("Update Patient Details");
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(124, 11, 260, 25);
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        JLabel label2= new JLabel("Name");
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setBounds(25, 88, 100, 14);
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        Choice choice= new Choice();
        choice.setBounds(248, 85, 150, 25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from Patient_Info");
while(resultSet.next()) {
    choice.add(resultSet.getString("Name"));
}
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3= new JLabel("Room Number");
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setBounds(24, 129, 150, 14);
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JTextField textFieldR= new JTextField();
        textFieldR.setBounds(248, 129, 140, 20);
        panel.add(textFieldR);

        JLabel label4= new JLabel("In Time");
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setBounds(24, 174, 140, 20);
        label4.setForeground(Color.BLACK);
        panel.add(label4);

        JTextField textFieldINTime= new JTextField();
        textFieldINTime.setBounds(248, 174, 140, 20);
        panel.add(textFieldINTime);

        JLabel label5= new JLabel("Amount Paid (Rs)");
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setBounds(25, 216, 150, 20);
        label5.setForeground(Color.BLACK);
        panel.add(label5);

        JTextField textFieldAmount= new JTextField();
        textFieldAmount.setBounds(248, 216, 140, 20);
        panel.add(textFieldAmount);

        JLabel label6= new JLabel("Pending Amount (Rs)");
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setBounds(25, 261, 160, 20);
        label6.setForeground(Color.BLACK);
        panel.add(label6);

        JTextField textFieldPending= new JTextField();
        textFieldPending.setBounds(248, 261, 140, 20);
        panel.add(textFieldPending);

JButton check = new JButton("Check");
check.setBounds(281,378,89,23);
check.setForeground(Color.BLACK);
check.setBackground(Color.WHITE);
panel.add(check);
check.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
     String id=choice.getSelectedItem();
     String q="select * from Patient_Info where Name='"+id+"'";
     try{
      conn c = new conn();
      ResultSet resultSet=c.statement.executeQuery(q);
      while(resultSet.next()) {
          textFieldR.setText(resultSet.getString("Room_Number"));
          textFieldINTime.setText(resultSet.getString("Time"));
      textFieldAmount.setText(resultSet.getString("Deposit"));
      }

ResultSet resultSet11=c.statement.executeQuery("select * from room where room_no='"+textFieldR.getText()+"'");
while(resultSet11.next()) {
    String price=resultSet11.getString("Price");
    int amountPaid=Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
textFieldPending.setText(""+amountPaid);
}
     }catch (Exception e1){
         e1.printStackTrace();
     }
    }


});
        JButton update = new JButton("Update");
       update.setBounds(56,378,89,23);
        update.setForeground(Color.BLACK);
        update.setBackground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            try{
                conn c = new conn();
                String q=choice.getSelectedItem();
                String room=textFieldR.getText();
                String time=textFieldINTime.getText();
                String amount=textFieldAmount.getText();
                c.statement.executeUpdate("update Patient_Info set Room_Number='"+room+"',Time='"+time+"',Deposit='"+amount+"'where name='"+q+"'");
                JOptionPane.showMessageDialog(null,"updated successfully");
            setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
            }
        });

        JButton back = new JButton("Back");
       back.setBounds(168,378,89,23);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              setVisible(false);
            }
        });





setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new update_patient_details();

    }
}
