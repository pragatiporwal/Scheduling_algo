
package awtsheduling;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Awtsheduling extends Frame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    TextField bttf[],attf[];
    Button b1;
    Label process,k;
    Panel p1;
    int bt[],at[];
    int f[],it,tbt,tat1[];
    int n;
    String u1="0",t1="0",tat2="0",wt1="0";
    public void initialize(int k)
    {
        n=k;
        p1=new Panel(null);
        add(p1);
        bttf=new TextField[n+1];
        attf=new TextField[n+1];
        int v=20;
        Font font=new Font("Arial",Font.BOLD,20);
        for(int i=1;i<=n;i++)
        {
            process=new Label("Process "+i);
            p1.add(process);
            process.setBounds(5, v, 100, 30);
            process.setFont(font);
            
            bttf[i]=new TextField(20);
            p1.add(bttf[i]);
            bttf[i].setBounds(110, v, 200, 30);
            bttf[i].setFont(font);
            
            attf[i]=new TextField(20);
            p1.add(attf[i]);
            attf[i].setBounds(310, v, 200, 30);
            attf[i].setFont(font);
            v=v+30;
        }
        b1=new Button("calculate");
        b1.setBounds(200, v+10, 100, 30);
        b1.setFont(font);
        p1.add(b1);
        b1.addActionListener(this);
        Closing c=new Closing();
        addWindowListener(c);
        setSize(550,500);
        setVisible(true);
    }
     class Closing extends WindowAdapter
    {
        public void windowClosing(WindowEvent w)
        {
            System.exit(0);
        }
    }
    public void actionPerformed(ActionEvent evt)
    {
         Awtsheduling a=new  Awtsheduling();
        Object obj=evt.getSource();
        
        readProcess();
        if(obj==b1)
        {
            System.out.println("successfull");
            Font font=new Font("Arial",Font.BOLD,20);
            shedulingProcess();
            utilization();
            throughput();
            turnAroundTime();
            waitingTime();
            setVisible(true);
            Label m1=new Label(" Utilization = "+u1);
            Label m2=new Label(" Throughput = "+t1);
            Label m3=new Label(" Turn around time= "+tat2);
            Label m4=new Label(" Waiting time = "+wt1);
            m1.setBounds(5, 200, 250, 30);
            p1.add(m1);
            m1.setFont(font);
            m2.setBounds(5, 230, 250, 30);
            p1.add(m2);
            m2.setFont(font);
            m3.setBounds(5, 260, 250, 30);
            p1.add(m3);
            m3.setFont(font);
            m4.setBounds(5, 290, 250, 30);
            p1.add(m4);
            m4.setFont(font);
        }
        
    }
 
   /*public void paint(Graphics g)
   {
       g.drawString(" Utilization = "+u1+"%", 20, 200);
       g.drawString("Througnput = "+t1, 20, 220);
       g.drawString("Turn around time = " +tat2, 20, 240);
       g.drawString(" Waiting time = "+wt1, 20, 260);
   }*/
    void readProcess()
    {
        
        bt=new int[n+1];
        at=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            bt[i]=Integer.parseInt(bttf[i].getText());
            at[i]=Integer.parseInt(attf[i].getText());
        }
    }
    void displayProcess()
    {
        
        for(int i=1;i<=n;i++)
        {
            System.out.println("P"+i+" "+bt[i]+" "+at[i]);
        }
    }
    void shedulingProcess()
    {
        f=new int[n+1];
        int k,i,sum=0;
        it=0;
        tbt=0;
        for(i=1;i<=n;i++)
        {
            if(sum<at[i])
            {
                it=it+(at[i]-sum);
                k=(at[i]-sum);
                sum=sum+k;
            }
            sum=sum+bt[i];
            f[i]=sum;
            tbt=tbt+bt[i];
            System.out.println("Gant chart"+f[i]);
        }
        //System.out.println(it + " "+tbt);
    }
    void utilization()
    {
        float u=(float)tbt/(float)(tbt+it);
        u=u*100;
        u1=String.valueOf(u);
        System.out.println("Utilization = "+(int)u+"%");
        String s=Float.toString(u);
        Label p=new Label(s);
        add(p);
    }
    void throughput()
    {
        float t=(float)n/(float)(f[n]-at[1]);
        t1=String.valueOf(t);
        System.out.println("Through put = "+t);
    }
    void turnAroundTime()
    {
        int sum=0;
        tat1=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            tat1[i]=(f[i]-at[i]);
            sum=sum+tat1[i];
        }
        float tat=(float)sum/(float)n;
        tat2=String.valueOf(tat);
        System.out.println("Average turn around time = "+tat);
    }
    void waitingTime()
    {
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            sum=sum+(tat1[i]-bt[i]);
            
        }
        float wt=(float)sum/(float)n;
        wt1=String.valueOf(wt);
        System.out.println("Average waiting time = "+ wt);
    }
    
   
    
}
