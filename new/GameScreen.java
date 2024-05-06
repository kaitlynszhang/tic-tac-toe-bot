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
import java.util.ArrayList;
import java.util.Arrays;

public class GameScreen extends JPanel implements Screen, MouseListener{
    
    private GameState gameState;
    private JLabel backgroundLabel;
    
    private ArrayList<String> grid = new ArrayList<String>(Arrays.asList("", "", "", "", "", "", "", "", ""));
    
    public GameScreen(GameState state) {
        this.gameState = state;
        if (gameState.theme == "default") {
            ImageIcon gameScreenBackground = new ImageIcon("default-gamescreenbackground.gif");
            backgroundLabel = new JLabel(gameScreenBackground);
            GridLayout layout = new GridLayout(1, 1);
            setLayout(layout);
            add(backgroundLabel);
            addMouseListener(this);
        }
        else if (gameState.theme == "sunset") {
            ImageIcon gameScreenBackground = new ImageIcon("sunset-gamescreenbackground.gif");
            backgroundLabel = new JLabel(gameScreenBackground);
            GridLayout layout = new GridLayout(1, 1);
            setLayout(layout);
            add(backgroundLabel);
            addMouseListener(this);
        }
        else if (gameState.theme == "snowy") {
            ImageIcon gameScreenBackground = new ImageIcon("snowy-gamescreenbackground.gif");
            backgroundLabel = new JLabel(gameScreenBackground);
            GridLayout layout = new GridLayout(1, 1);
            setLayout(layout);
            add(backgroundLabel);
            addMouseListener(this);
        }
        else if (gameState.theme == "rainy") {
            ImageIcon gameScreenBackground = new ImageIcon("rainy-gamescreenbackground.gif");
            backgroundLabel = new JLabel(gameScreenBackground);
            GridLayout layout = new GridLayout(1, 1);
            setLayout(layout);
            add(backgroundLabel);
            addMouseListener(this);
        }
        else if (gameState.theme == "night") {
            ImageIcon gameScreenBackground = new ImageIcon("night-gamescreenbackground.gif");
            backgroundLabel = new JLabel(gameScreenBackground);
            GridLayout layout = new GridLayout(1, 1);
            setLayout(layout);
            add(backgroundLabel);
            addMouseListener(this);
        }
        else if (gameState.theme == "adventure") {
            ImageIcon gameScreenBackground = new ImageIcon("adventure-gamescreenbackground.gif");
            backgroundLabel = new JLabel(gameScreenBackground);
            GridLayout layout = new GridLayout(1, 1);
            setLayout(layout);
            add(backgroundLabel);
            addMouseListener(this);
        }
    }
    
    // here i set the visibility of the main screen to true and start any animations, music and etc
    public void showScreen() {
        this.setVisible(true);
    }
    
    // after i hide screen we want to set visibility to false and stop animations, music and etc
    public void hideScreen() {
        this.setVisible(false);
    }
    
    // all of the game drawing happens here
    public void repaint(Graphics G) {
        
    }
    
    // here i change what is shown based off of game state
    public void update(GameState gameState) {
        
    }
    
    @Override
    public Component getComponent(){
        return this;
    }
    
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        System.out.println("mouse click detected at " + x + ", " + y);
    }
    
    public void mousePressed(MouseEvent e){
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    public void mouseEntered(MouseEvent e){
        
    }
    
    public void mouseExited(MouseEvent e){
        
    }
}
