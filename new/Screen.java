import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Component;

// here is our interface for our screen like a blueprint
public interface Screen{
    void showScreen();
    void hideScreen();
    void repaint(Graphics g);
    void update(GameState gameState);
    Component getComponent();
}
