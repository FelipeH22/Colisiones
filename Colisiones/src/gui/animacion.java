package gui;
import java.awt.Graphics;
import javax.swing.JPanel;

public class animacion extends JPanel implements Runnable{

    Thread hilo; 
    int  x=0;
    int p=0;
    boolean limite = false;
    
    public animacion()
    {
        hilo = new Thread(this);
        hilo.start();
    }
    public void paint(Graphics g)
    {
       super.paint(g);
       g.fillOval(x,p,100,100);
    }
    
    public void run()
    {
        while(hilo.isAlive())
        {
            if(!limite)
            {
                x++;
                p++;
                if(x == getBounds().width - 100 || p == getBounds().height - 100)
                {
                    limite=true;
                }
            }
            else
            {
                x--;
                p--;
                if(x==0 || p==0)
                {
                    limite=false;   
                }
            }
            repaint();
            try{
                Thread.sleep(2);
            }catch (InterruptedException ex)
            {
                System.err.println("Error");
            }
            
        }
    }
}
