
package thecalculator;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;


public class Calculator extends JFrame implements ActionListener {

        //Gia to Frame thavalw 5 katheta panel gia na valw ta buttons
        JPanel[] row = new JPanel[5]; 
        JButton[] button = new JButton[19]; //19 koubia
        String[] buttonString = {"7", "8", "9", "+", //gia na mhn grafw sto kathena tha tous dwsw to string me ena loop kai button[i].setText(buttonString[i]);..klp

                                "4", "5", "6", "-",

                                "1", "2", "3", "*",

                                ".", "/", "C", "√",

                                 "+/-", "=", "0"};
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == button[0])
        display.append("7");
    if(ae.getSource() == button[1])
        display.append("8");
    if(ae.getSource() == button[2])
        display.append("9");
   if(ae.getSource() == button[3]) {
        //add function[0]
        temporary[0] = Double.parseDouble(display.getText());
        function[0] = true;
        display.setText("");
    }
    if(ae.getSource() == button[4])
        display.append("4");
    if(ae.getSource() == button[5])
        display.append("5");
    if(ae.getSource() == button[6])
        display.append("6");
    if(ae.getSource() == button[7]) {
        //subtract function[1]
        temporary[0] = Double.parseDouble(display.getText());
        function[1] = true;
        display.setText("");
    }
    if(ae.getSource() == button[8])
        display.append("1");
    if(ae.getSource() == button[9])
        display.append("2");
    if(ae.getSource() == button[10])
        display.append("3");
    if(ae.getSource() == button[11]) {
        //multiply function[2]
        temporary[0] = Double.parseDouble(display.getText());
        function[2] = true;
        display.setText("");
    }
    if(ae.getSource() == button[12])
        display.append(".");
    if(ae.getSource() == button[13]) {
        //divide function[3]
        temporary[0] = Double.parseDouble(display.getText());
        function[3] = true;
        display.setText("");
    }
    if(ae.getSource() == button[14])
        clear();
    if(ae.getSource() == button[15])
        getSqrt();
    if(ae.getSource() == button[16])
        getPosNeg();
    if(ae.getSource() == button[17])
        getResult();
    if(ae.getSource() == button[18])
        display.append("0");

    }
    
        int[] dimW = {300, 45, 100, 90};
        int[] dimH = {35, 40};
        
        Dimension displayDimension = new Dimension(dimW[0], dimH[0]); 
        Dimension regularDimension = new Dimension(dimW[1], dimH[1]); 
        Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]); 
        Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
    
        
        boolean[] function = new boolean[4]; 

        double[] temporary = {0, 0}; 

        JTextArea display = new JTextArea(1,20);

        Font font = new Font("Times new Roman", Font.BOLD, 14);
        
        //constructor
        Calculator() {  
            
            super("Title");
            setDesign();
            setSize(380, 250);
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            GridLayout grid = new GridLayout(5,5);
            setLayout(grid);
            
            for(int i = 0; i < 4; i++)
            function[i] = false;
            
            FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
            FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1); //oi asoi einai ta kena aanamesa sta buttons
            
            for(int i = 0; i < 5; i++) //arxikopiish twn seirwn tou JPanel
              row[i] = new JPanel();
            
            row[0].setLayout(f1);
            
            for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);
            
            for(int i = 0; i < 19; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]); // dinw onoma sta buttons
            button[i].setFont(font); //gramatoseira
            button[i].addActionListener(this);

            }
            
            //gia ta buttons (gramatoseira,na mhn einai editable,kai seira apo deksia pros ta aristera)
            display.setFont(font);
            display.setEditable(false);
            display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            
            display.setPreferredSize(displayDimension);
            
            //megethos gia olla ektos tou minden
            for(int i = 0; i < 14; i++)
                button[i].setPreferredSize(regularDimension);
            for(int i = 14; i < 18; i++)
                button[i].setPreferredSize(rColumnDimension);

            button[18].setPreferredSize(zeroButDimension); // gia to 0
            
            row[0].add(display);
            add(row[0]);
            
            //add the buttons------------start
            for(int i = 0; i < 4; i++)
                row[1].add(button[i]);
            row[1].add(button[14]);
            add(row[1]);
            
            
            for(int i = 4; i < 8; i++)
                row[2].add(button[i]);
            row[2].add(button[15]);
            add(row[2]);

            for(int i = 8; i < 12; i++)
                row[3].add(button[i]);
            row[3].add(button[16]);
            add(row[3]);
            row[4].add(button[18]);

           for(int i = 12; i < 14; i++)
                row[4].add(button[i]);
            row[4].add(button[17]);
            add(row[4]);
            //finish---------------
            
            setVisible(true); //emfanisi tou Frame
        
        }

        //NimbusLookAndFeel apaitei Java 7
    private void setDesign() {
        try {
        UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch(Exception e) {  

    }

    }
    
    public void clear() {

    try {
        display.setText(""); // kanei to desplay keno
        for(int i = 0; i < 4; i++)
            function[i] = false; // oi synarthseis fevgoun
        for(int i = 0; i < 2; i++)
            temporary[i] = 0; // oles oi times 0
    } catch(NullPointerException e) { 
    }

}

public void getSqrt() {

    try {
        double value = Math.sqrt(Double.parseDouble(display.getText())); // ypologismos root
        display.setText(Double.toString(value)); //ektypwsh
    } catch(NumberFormatException e) {
    }

}

public void getPosNeg() {

    try {
        double value = Double.parseDouble(display.getText()); 
        if(value != 0) { 
            value = value * (-1); // pol me -1 gia na paroume to thetiko
            display.setText(Double.toString(value)); // emfanisi
        }
        else {
        }
    } catch(NumberFormatException e) {
    }
}

public void getResult() {

    double result = 0;  
    temporary[1] = Double.parseDouble(display.getText()); //our second temporary number from display
    
      try {
        if(function[2] == true)  //pollaplasiasmos
            result = temporary[0] * temporary[1]; 
        else if(function[3] == true)  //dieresh
            result = temporary[0] / temporary[1];
        else if(function[0] == true) //prosthesi
            result = temporary[0] + temporary[1];
        else if(function[1] == true) //aferesh
            result = temporary[0] - temporary[1];
        display.setText(Double.toString(result)); //emfanise result
        for(int i = 0; i < 4; i++)
            function[i] = false; //oles oi synarthseis false
    } catch(NumberFormatException e) {
    }
}

 

}

    

