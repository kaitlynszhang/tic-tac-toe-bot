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


public class Options extends JPanel implements Screen{
    
    private GameState gameState;
    private JLabel backgroundLabel;
    
    public Options(GameState state) {
        this.gameState = state;
        setLayout(new GridLayout(4, 1));
        ImageIcon mainScreenBackground = new ImageIcon("02pgV9.gif");
        backgroundLabel = new JLabel(mainScreenBackground);
        add(backgroundLabel, BorderLayout.CENTER);
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
    }
}
