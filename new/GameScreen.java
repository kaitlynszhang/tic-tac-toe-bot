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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GameScreen extends JPanel implements Screen, MouseListener{
    
    private GameState gameState;
    private JLabel backgroundLabel;
    
    private ArrayList<String> grid = new ArrayList<String>(Arrays.asList("", "", "", "", "", "", "", "", ""));
    private BufferedImage defaultXImage;
    private BufferedImage defaultOImage;
    private BufferedImage sunsetXImage;
    private BufferedImage sunsetOImage;
    private BufferedImage snowyXImage;
    private BufferedImage snowyOImage;
    private BufferedImage rainyXImage;
    private BufferedImage rainyOImage;
    private BufferedImage nightXImage;
    private BufferedImage nightOImage;
    private BufferedImage adventureXImage;
    private BufferedImage adventureOImage;
    
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
        
        try {
            defaultXImage = ImageIO.read(new File("default-x.png"));
            defaultOImage = ImageIO.read(new File("default-o.png"));
            
            sunsetXImage = ImageIO.read(new File("sunset-x.png"));
            sunsetOImage = ImageIO.read(new File("sunset-o.png"));
            
            snowyXImage = ImageIO.read(new File("snowy-x.png"));
            snowyOImage = ImageIO.read(new File("snowy-o.png"));
            
            rainyXImage = ImageIO.read(new File("rainy-x.png"));
            rainyOImage = ImageIO.read(new File("rainy-o.png"));
            
            nightXImage = ImageIO.read(new File("night-x.png"));
            nightOImage = ImageIO.read(new File("night-o.png"));
            
            adventureXImage = ImageIO.read(new File("adventure-x.png"));
            adventureOImage = ImageIO.read(new File("adventure-o.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
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
        
        if (x >= 229 && x <= 362 && y >= 209 && y <= 342) {
            System.out.println("top left square clicked");
        }
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
