package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
    JButton b1, b2;
    JLabel l1,mini,card,balance;
    
    MiniStatement(String pin){
    setTitle("Mini Statement");
    setLayout(null);
    
    
    l1 = new JLabel("Indian Bank");
    l1.setBounds(150,20,100,20 );
    add(l1);
    
    mini = new JLabel();
    mini.setBounds(20 , 140, 400, 200);
    add(mini);
    
    card = new JLabel();
    card.setBounds(20, 80, 300, 20);
    add(card);
    
    balance = new JLabel();
    balance.setBounds(20, 400, 300, 20);
    add(balance);
    
    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pin+"'");
        while(rs.next()){
            card.setText("Card Number:   " + rs.getString("cardNumber").substring(0 ,4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
        }
    }catch(Exception e){
        System.out.println(e);;
    }
    
    
    try{
        int bal = 0;
        Conn c1  = new Conn();
        ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
        while(rs.next()){
        mini.setText(mini.getText() + "<html>"+rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");    
        if(rs.getString("type").equals("Deposit")){
            bal += Integer.parseInt(rs.getString("amount"));
        }else{
            bal -= Integer.parseInt(rs.getString("amount"));
        }
        }
    balance.setText("Your total Balance is Rs "+bal);
    }catch(Exception e){
        System.out.println(e);
    }
    
    
    getContentPane().setBackground(Color.WHITE);
    setSize(400,600);
    setLocation(20,20);
    setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
    
    }
    
    public static void main(String[] args) {
    new MiniStatement("");
    }
}
