/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awtsheduling;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DELL
 */
public class Main_class extends Frame implements ActionListener{
    
    Label l1;
    TextField tf1;
    Button b1;
    Panel p1;
    Choice ch;
    void no_of_process()
    {
       p1=new Panel();
       add(p1);
       l1=new Label("Enter no of process ");
       p1.add(l1);
       tf1=new TextField(20);
       p1.add(tf1);
       b1=new Button("Submit");
       p1.add(b1);
       
       Label chlvl = new Label("Algorithem");
       p1.add(chlvl);
       ch=new Choice();
       ch.add("FCFS");
       ch.add("Round Robin(Variable)");
       p1.add(ch);
       
       b1.addActionListener(this);
       setVisible(true);
       setSize(400,400);
    }
    public void actionPerformed(ActionEvent evt)
    {
        Object obj=evt.getSource();
        if(obj==b1)
        {
            if(ch.getSelectedItem().equals("FCFS"))
            {
                int n=Integer.parseInt(tf1.getText());
            Awtsheduling a=new  Awtsheduling();
            a.initialize(n);
            }
            if(ch.getSelectedItem().equals("Round Robin(Variable)"))
            {
                int n=Integer.parseInt(tf1.getText());
            RoundRobinVariable a=new  RoundRobinVariable();
            a.initialize(n);
            }
           
        }
    }
     public static void main(String[] args) {
        // TODO code application logic here
        Main_class m=new Main_class();
        m.no_of_process();
    }
}
