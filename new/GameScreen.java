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
    
    private Boolean player1Turn = true;
    
    private BufferedImage XImage;
    private BufferedImage OImage;
    
    public GameScreen(GameState state) {
        this.gameState = state;
        try {
            if (gameState.theme == "default") {
                ImageIcon gameScreenBackground = new ImageIcon("default-gamescreenbackground.gif");
                backgroundLabel = new JLabel(gameScreenBackground);
                GridLayout layout = new GridLayout(1, 1);
                setLayout(layout);
                add(backgroundLabel);
                
                XImage = ImageIO.read(new File("default-x.png"));
                OImage = ImageIO.read(new File("default-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "sunset") {
                ImageIcon gameScreenBackground = new ImageIcon("sunset-gamescreenbackground.gif");
                backgroundLabel = new JLabel(gameScreenBackground);
                GridLayout layout = new GridLayout(1, 1);
                setLayout(layout);
                add(backgroundLabel);
                
                XImage = ImageIO.read(new File("sunset-x.png"));
                OImage = ImageIO.read(new File("sunset-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "snowy") {
                ImageIcon gameScreenBackground = new ImageIcon("snowy-gamescreenbackground.gif");
                backgroundLabel = new JLabel(gameScreenBackground);
                GridLayout layout = new GridLayout(1, 1);
                setLayout(layout);
                add(backgroundLabel);
                
                XImage = ImageIO.read(new File("snowy-x.png"));
                OImage = ImageIO.read(new File("snowy-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "rainy") {
                ImageIcon gameScreenBackground = new ImageIcon("rainy-gamescreenbackground.gif");
                backgroundLabel = new JLabel(gameScreenBackground);
                GridLayout layout = new GridLayout(1, 1);
                setLayout(layout);
                add(backgroundLabel);
                
                XImage = ImageIO.read(new File("rainy-x.png"));
                OImage = ImageIO.read(new File("rainy-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "night") {
                ImageIcon gameScreenBackground = new ImageIcon("night-gamescreenbackground.gif");
                backgroundLabel = new JLabel(gameScreenBackground);
                GridLayout layout = new GridLayout(1, 1);
                setLayout(layout);
                add(backgroundLabel);
                
                XImage = ImageIO.read(new File("night-x.png"));
                OImage = ImageIO.read(new File("night-o.png"));
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
        } catch(IOException ex) {
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(grid.get(0) == "x") {
            g.drawImage(XImage, 0, 0, this);
        } else if(grid.get(0) == "o") {
            g.drawImage(OImage, 0, 0, this);
        }
    }
    
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        System.out.println("mouse click detected at " + x + ", " + y);
        
        if (x >= 229 && x <= 362 && y >= 209 && y <= 342) {
            System.out.println("top left square clicked");
            if(player1Turn) {
                if(grid.get(0) == "") {
                    grid.set(0, "x");
                    player1Turn = false;
                }
            } else {
                if(grid.get(0) == "") {
                    grid.set(0, "o");
                    player1Turn = true;
                }
            }

        }
        repaint();
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
