package animaciones;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Cuadrado
{
   private static final int WITH = 30;
    private static final int HEIGHT = 60;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Juego game;

    public Cuadrado(Juego game)
    {
        this.game= game;
    }

    void move() 
    {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - WITH)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - HEIGHT)
            ya = -1;
        if (collision())
            game.gameOver();
        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g)
    {
        g.fillRect(x, y, WITH, HEIGHT);
    }
    private boolean collision() 
    {
        return game.Cuadrado2.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds()
    {            
        return new Rectangle(x, y, WITH, HEIGHT);
    }
    

	
}
