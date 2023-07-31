
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    
    JTextField aadhar,qual,pan,occupation;
    JButton next;
    JRadioButton sno,syes,eno,eyes;
    JComboBox religion,category,income;
    String formno;
    
    SignupTwo(String formno){
    this.formno = formno;
    setLayout(null);
    
    
    setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
    
    JLabel additionalDetails = new JLabel("PAGE 2 : ADDITIONAL DETAILS" );
    additionalDetails.setFont(new Font("Raleway" , Font.BOLD ,22));
    additionalDetails.setBounds(290,80,400,30);
    add(additionalDetails);
    
    JLabel name = new JLabel("Religion :" );
    name.setFont(new Font("Raleway" , Font.BOLD ,20));
    name.setBounds(100,140,100,30);
    add(name);
    String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
    religion = new JComboBox (valReligion);
    religion.setBounds(300,140,400,30);
    religion.setBackground(Color.WHITE);
    add(religion);
    
    JLabel fname = new JLabel("Category :" );
    fname.setFont(new Font("Raleway" , Font.BOLD ,20));
    fname.setBounds(100,190,200,30);
    add(fname);
    String valCategory[] = {"General","OBC","SC","ST","Other"};
    category = new JComboBox(valCategory);
    category.setBackground(Color.WHITE); 
    category.setBounds(300,190,400,30);
    add(category);
    
    JLabel dob = new JLabel("Income :" );
    dob.setFont(new Font("Raleway" , Font.BOLD ,20));
    dob.setBounds(100,240,200,30);
    add(dob);
    String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
    income = new JComboBox(valIncome);
    income.setBackground(Color.WHITE); 
    income.setBounds(300,240,400,30);
    add(income);
     
    JLabel gender = new JLabel("Educational" );
    gender.setFont(new Font("Raleway" , Font.BOLD ,20));
    gender.setBounds(100,290,200,30);
    add(gender);

    JLabel email = new JLabel("Qualification :" );
    email.setFont(new Font("Raleway" , Font.BOLD ,20));
    email.setBounds(100,320,200,30);
    add(email);
    qual = new JTextField();
    qual.setFont(new Font("Raleway", Font.BOLD, 14));
    qual.setBounds(300,320,400,30);
    add(qual);
    
    JLabel martial = new JLabel("Occupation:" );
    martial.setFont(new Font("Raleway" , Font.BOLD ,20));
    martial.setBounds(100,375,200,30);
    add(martial);
    occupation = new JTextField();
    occupation.setFont(new Font("Raleway", Font.BOLD, 14));
    occupation.setBounds(300,375,400,30);
    add(occupation);
    
    JLabel address = new JLabel("PAN Number :");
    address.setFont(new Font("Raleway", Font.BOLD, 20));
    address.setBounds(100,440,200,30);
    add(address);
    pan = new JTextField();
    pan.setFont(new Font("Raleway", Font.BOLD, 14));
    pan.setBounds(300,440,400,30);
    add(pan);
    
    JLabel city = new JLabel("Aadhar Number :");
    city.setFont(new Font("Raleway", Font.BOLD, 20));
    city.setBounds(100,490,200,30);
    add(city);
    aadhar = new JTextField();
    aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
    aadhar.setBounds(300,490,400,30);
    add(aadhar);
   
    JLabel state = new JLabel("Senior Citizen :" );
    state.setFont(new Font("Raleway" , Font.BOLD ,20));
    state.setBounds(100,540,200,30);
    add(state);
    syes = new JRadioButton("Yes");
    syes.setFont(new Font("Raleway", Font.BOLD, 14));
    syes.setBackground(Color.WHITE);
    syes.setBounds(350,540,100,30);
    add(syes);
        
    sno = new JRadioButton("No");
    sno.setFont(new Font("Raleway", Font.BOLD, 14));
    sno.setBackground(Color.WHITE);
    sno.setBounds(460,540,100,30);
    add(sno);
       
    ButtonGroup senior =new ButtonGroup();
    senior.add(sno);
    senior.add(syes);
  
    JLabel eAcc = new JLabel("Existing Account :" );
    eAcc.setFont(new Font("Raleway" , Font.BOLD ,20));
    eAcc.setBounds(100,590,200,30);
    add(eAcc);
   
    eyes = new JRadioButton("Yes");
    eyes.setFont(new Font("Raleway", Font.BOLD, 14));
    eyes.setBackground(Color.WHITE);
    eyes.setBounds(350,590,100,30);
    add(eyes);
        
    eno = new JRadioButton("No");
    eno.setFont(new Font("Raleway", Font.BOLD, 14));
    eno.setBackground(Color.WHITE);
    eno.setBounds(460,590,100,30);
    add(eno);
       
    ButtonGroup existing =new ButtonGroup();
    existing.add(eno);
    existing.add(eyes);
    
    
    
    next = new JButton("Next");
    next.setForeground(Color.WHITE);
    next.setBackground(Color.BLACK);
    next.setFont(new Font("Raleway", Font.BOLD, 14));
    next.setBounds(620,660,80,30);
    next.addActionListener(this);
    add(next);
    
    
    getContentPane().setBackground(Color.white);
    
   
    setSize(850 , 800);
    setLocation(350, 10);
    setVisible(true);
       
}
    public void actionPerformed(ActionEvent ae){
    
    //String formno = "" + random;
    String sreligion = (String)religion.getSelectedItem();
    String scategory = (String) category.getSelectedItem();
    String sincome = (String) income.getSelectedItem();
    String squal = qual.getText();
    String soccu = occupation.getText();
    String span = pan.getText();
    String saadhar = aadhar.getText();
    
    
    String scitizen = null;
    if(syes.isSelected()){
       scitizen = "Yes" ;
    }else if (sno.isSelected()){
        scitizen = "No" ;
    }
    
    String eAccount = null;
    if(eyes.isSelected()){
        eAccount  = "Yes";
    }else if (eno.isSelected()){
        eAccount  = "No";
    }

        try{
           
        Conn c = new Conn();
        String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squal+"','"+soccu+"','"+span+"','"+saadhar+"','"+scitizen+"','"+eAccount+"')";
        c.s.executeUpdate(query);
        setVisible(false);
        new SignupThree(formno).setVisible(true);
        } catch(Exception e){
             System.out.println(e);
        }
    
    }

   
    public static void main(String args[]){
    new SignupTwo("");
}
}   