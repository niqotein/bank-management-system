

package bank.management.system;
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import java.sql.*;




public class Login extends JFrame implements ActionListener{
    JButton signin , clear , signup;
    JTextField cardTextField  ;
    JPasswordField pinTextField ;
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
         setLayout(null);
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
         Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel label = new JLabel(i3);
         label.setBounds(70, 10, 100, 100);
         add(label);
         
         JLabel text = new JLabel("Welcome to ATM");
         text.setFont(new Font("Osward",Font.BOLD ,38));
         text.setBounds(200 ,40 ,400, 40);
         add(text);
         
         JLabel cardno = new JLabel("CARD NO :");
         cardno.setFont(new Font("Raleway",Font.BOLD ,28));
         cardno.setBounds(120 ,120 ,150, 30);
         add(cardno);
         cardTextField = new JTextField();
         cardTextField.setBounds(300, 120, 250, 30);
         add(cardTextField);
         
         JLabel pin = new JLabel("PIN :");
         pin.setFont(new Font("Raleway",Font.BOLD ,28));
         pin.setBounds(120 ,200 ,400, 40);
         add(pin);
         pinTextField = new JPasswordField();
         pinTextField.setBounds(300, 200, 250, 30);
         add(pinTextField);
         
        signin = new JButton("SIGN IN ");
        signin.setBounds(300,300,100,30);
        signin.setBackground(black);
        signin.setForeground(white);
        signin.addActionListener(this);
        add(signin);    
         
        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(black);
        clear.setForeground(white);
        clear.addActionListener(this);
         add(clear);
         
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(black);
        signup.setForeground(white);
        signup.addActionListener(this);
         add(signup);
          
         getContentPane().setBackground(white);
        
         setSize(800 ,500 );
         setVisible(true);
         setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        
        
        try{if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == signin){
           Conn c = new Conn();
                String cardno  = cardTextField.getText();
                String pin  = pinTextField.getText();
                String q  = "select * from login where cardNumber = '"+cardno+"' and pin = '"+pin+"'";

                try{
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                } }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            
        }else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        Login login = new Login();
    }
}

  
