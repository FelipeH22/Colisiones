package animaciones;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel 
{

	Cuadrado2 Cuadrado2 = new Cuadrado2(this);
        Cuadrado Cuadrado = new Cuadrado(this);

	private void move() 
        {
		Cuadrado2.move();
                Cuadrado.move();
	}

	@Override
	public void paint(Graphics g) 
        {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            Cuadrado2.paint(g2d);
            Cuadrado.paint(g2d);
	}
        public void gameOver()
        {
            JOptionPane.showMessageDialog(this, "Colisión", "Colisión", JOptionPane.YES_NO_OPTION);
            System.exit(ABORT);
        }
	public static void main(String[] args) throws InterruptedException 
        {
            JFrame frame = new JFrame("Colisiones");
            Juego game = new Juego();
            frame.add(game);
            frame.setSize(450, 450);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            while (true)
            {
                game.move();
                game.repaint();
                Thread.sleep(10);
            }
	}

   
}