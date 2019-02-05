package animaciones;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Cuadrado2 {
    private static final int WITH = 30;
    private static final int HEIGHT = 60;
    int x = (int) (Math.random() * 300) + 1;;
    int y = (int) (Math.random() * 300) + 1;;
    int xa = 1;
    int ya = 1;
    private Juego game;
    

    public Cuadrado2(Juego game) 
    {
        this.game= game;
    }
    void move() 
    {
        if (x + xa < 0)
                xa = 1;
        if (x + xa > game.getWidth() - 30)
                xa = -1;
        if (y + ya < 0)
                ya = 1;
        if (y + ya > game.getHeight() - 60)
                ya = -1;

        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) 
    {
        g.fillRect(x, y, 30, 60);
    }

    public Rectangle getBounds() 
    {
        return new Rectangle(x, y, WITH, HEIGHT);
    }
    public int getTopY()
    {
        return y - HEIGHT;
    }
    public int getTopX() 
    {
        return x - WITH;
    }
}