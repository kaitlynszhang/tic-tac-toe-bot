import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Component;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.Color.*;
import java.awt.event.*;
import java.net.URL.*;


public class MainScreen extends JPanel implements Screen {

    private GameState gameState;
    private Image title;
    
    // here we initialize our mainscreen (buttons, background, and etc)
    public MainScreen(GameState state) {
        this.gameState = state;
        
        try {
            title = ImageIO.read(new File("Title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO
    }
    
    // here we set the visibility of the main screen to true and start any animations, music and etc
    public void showScreen() {
        this.setVisible(true);
    }
    
    // after we hide screen we want to set visibility to false and stop animations, music and etc
    public void hideScreen() {
        this.setVisible(false);
    }
    
    // all of the game drawing happens here
    public void repaint(Graphics G) {
        
    }
    
    // here we change what is shown based off of game state
    public void update(GameState gameState) {
        
    }

    @Override
    public Component getComponent(){
        return this;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(title, 0, 0, null);
    }
}