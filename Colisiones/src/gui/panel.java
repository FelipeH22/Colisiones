package gui;
import javax.swing.*;

public class panel extends JFrame{
    
    animacion animacion;
    animacion2 animacion2;
    public panel()
    {        
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setTitle("Colisiones");
        
    }
    public void componentes()
    {
        animacion = new animacion();
        this.add(animacion);
        animacion2 = new animacion2();
        this.add(animacion2);
    }
}
