package gui;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class animacion2 extends JPanel implements Runnable{

    Thread hilo; 
    int x = 0;
    int p = 0;
    int xa = 1;
    int pa = 1;
    boolean limite = false;
    
    public animacion2()
    {
        hilo = new Thread(this);
        hilo.start();
    }
    public void paint(Graphics g)
    {
       super.paint(g);
       g.fillOval(x,p,30,30);
    }
    
    public void run()
    {
        while(hilo.isAlive())
        {
            if(!limite)
            {
               if (x + xa < 0)
			xa = 1;
		if (x + xa > getWidth() - 30)
			xa = -1;
		if (p + pa < 0)
			pa = 1;
		if (p + pa > getHeight() - 30)
			pa = -1;
		
		x = x + xa;
		p = p + pa;
                
                //Cambio de direccion
                if (x + xa < 0)
			xa = 10;
		if (x + xa > getWidth() - 30)
			xa = -10;
		if (p + pa < 0)
			pa = 10;
		if (p + pa > getHeight() - 30)
			pa = -10;

		x = x + xa;
		p = p + pa;
                //
                if(x == getBounds().width - 30 || p == getBounds().height - 30)
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
                Thread.sleep(10);
            }catch (InterruptedException ex)
            {
                System.err.println("Error");
            }
            
        }
    }
}
