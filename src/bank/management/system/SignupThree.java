
package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JRadioButton sav,curr,fix,recurr;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton b1,b2;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 24));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        l2 = new JLabel("Account Type :");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(100,140,200,30);
        add(l2);
        
        sav = new JRadioButton("Savings Accouunt ");
        sav.setFont(new Font("Raleway", Font.BOLD, 14));
        sav.setBackground(Color.WHITE);
        sav.setBounds(100,200,200,30);
        add(sav);

        fix = new JRadioButton("Fixed Deposit Account ");
        fix.setFont(new Font("Raleway", Font.BOLD, 14));
        fix.setBackground(Color.WHITE);
        fix.setBounds(350,200,200,30);
        add(fix);

        curr = new JRadioButton("Current Account ");
        curr.setFont(new Font("Raleway", Font.BOLD, 14));
        curr.setBackground(Color.WHITE);
        curr.setBounds(100,250,200,30);
        add(curr );

        recurr = new JRadioButton("Recurring Deposit Accouunt ");
        recurr.setFont(new Font("Raleway", Font.BOLD, 14));
        recurr.setBackground(Color.WHITE);
        recurr.setBounds(350,250,250,30);
        add(recurr);

        ButtonGroup acc =new ButtonGroup();
        acc.add(sav);
        acc.add(fix);
        acc.add(curr);
        acc.add(recurr);
        
        l3 = new JLabel("Card Number :");
        l3.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.setBounds(100,300,200,30);
        add(l3);
        
        l4 = new JLabel("(your 16-digit Card Number)");
        l4.setFont(new Font("Raleway", Font.BOLD, 12));
        l4.setBounds(100,330,200,30);
        add(l4);
        
        l4 = new JLabel("it would appear on ATM Card/Cheque Book and Statements");
        l4.setFont(new Font("Raleway", Font.BOLD, 12));
        l4.setBounds(350,330,400,30);
        add(l4);
        
        l6 = new JLabel("XXXX-XXXX-XXXX-4184");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(350,300,300,30);
        add(l6);
        
        l5 = new JLabel("PIN:");
        l5.setFont(new Font("Raleway", Font.BOLD, 22));
        l5.setBounds(100,380,200,30);
        add(l5);
        
        l7 = new JLabel("XXXX");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(350,380,200,30);
        add(l7);
        
        l8 = new JLabel("Services Required:");
        l8.setFont(new Font("Raleway", Font.BOLD, 22));
        l8.setBounds(100,430,400,30);
        add(l8);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,480,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,480,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,530,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,530,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,580,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,580,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,620,500,30);
        add(c7);
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,670,100,30);
        b1.addActionListener(this); 
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,670,100,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
         
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String atype = null;
        if(sav.isSelected()){ 
            atype = "Saving Account";
        }
        else if(fix.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(curr.isSelected()){ 
            atype = "Current Account";
        }else if(recurr.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        Random ran = new Random();
        String cardno = "" + Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);
        
        String pin = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        String facilities = "";
        if(c1.isSelected()){ 
            facilities = facilities + " ATM Card";
        }
        if(c2.isSelected()){ 
            facilities = facilities + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facilities = facilities + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facilities = facilities + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facilities = facilities + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facilities = facilities + " E-Statement";
        }
        
        try{
            if(ae.getSource()==b1){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facilities+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin: "+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==b2){
                System.exit(0);
            }
            
        }catch(Exception ex){
            System.out.println(ex);;
        }
        
        }else if(ae.getSource() == b2){
            setVisible(false);
            new Login().setVisible(true);
            
        }
    
    }
    
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
 