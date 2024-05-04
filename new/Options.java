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

public class Options extends JPanel implements Screen, MouseListener{
    
    private GameState gameState;
    private BufferedImage background;
    
    private BufferedImage onePlayerImage;
    private BufferedImage twoPlayerImage;
    private boolean onePlayerSelected = false;
    private boolean twoPlayerSelected = false;
    
    // For each set of options add a bufferedimage for each options and a boolean for each option
    // ...
    private BufferedImage easyDifficultyImage;
    private BufferedImage mediumDifficultyImage;
    private BufferedImage hardDifficultyImage;
    private boolean easyDifficultySelected = false;
    private boolean mediumDifficultySelected = false;
    private boolean hardDifficultySelected = false;
    
    public Options(GameState state) {
        this.gameState = state;
        try {
            background = ImageIO.read(new File("options-page.png"));
            onePlayerImage = ImageIO.read(new File("oneplayer.png"));
            twoPlayerImage = ImageIO.read(new File("twoplayer.png"));
            // here you have to load in the rest of the images for the buttons
            easyDifficultyImage = ImageIO.read(new File("easy.png"));
            mediumDifficultyImage = ImageIO.read(new File("medium.png"));
            hardDifficultyImage = ImageIO.read(new File("hard.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addMouseListener(this);
        setPreferredSize(new Dimension(background.getWidth(), background.getHeight()));
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
        g.drawImage(background, 0, 0, this);
        if (onePlayerSelected) {
            g.drawImage(onePlayerImage, 0, 0, this);
        }
        if (twoPlayerSelected) {
            g.drawImage(twoPlayerImage, 0, 0, this);
        }
        
        if (onePlayerSelected) {
            // add if statement for each of the rest of the buttons (15)
            if (easyDifficultySelected) {
                g.drawImage(easyDifficultyImage, 0, 0, this);
            } else if (mediumDifficultySelected) {
                g.drawImage(mediumDifficultyImage, 0, 0, this);
            } else if (hardDifficultySelected) {
                g.drawImage(hardDifficultyImage, 0, 0, this);
            }
        }
        
        
    }
    
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("mouse click detected at " + x + ", " + y);

        if (x >= 98 && x <= 388 && y >= 204 && y <= 294) {
            gameState.players = 1;
            onePlayerSelected = true;
            twoPlayerSelected = false;
            System.out.println("1 player selected");
        } else if (x >= 502 && x <= 802 && y >= 203 && y <= 293) {
            gameState.players = 2;
            onePlayerSelected = false;
            twoPlayerSelected = true;
            System.out.println("1 players selected");
        }
        /*
         easy: x >= 100, x <= 190, y >= 350, y <= 440 
         medium: x >= 200, x <= 290, y >= 350, y <= 440
         hard: x >= 300, x <= 390, y >= 350, y <= 440
         */
        if (onePlayerSelected) {
            if (x >= 100 && x <= 190 && y >= 350 && y <= 440) {
                gameState.difficulty = 0;
                easyDifficultySelected = true;
                mediumDifficultySelected = false;
                hardDifficultySelected = false;
            } else if (x >= 200 && x <= 290 && y >= 350 && y <= 440) {
                gameState.difficulty = 1;
                easyDifficultySelected = false;
                mediumDifficultySelected = true;
                hardDifficultySelected = false;
            } else if (x >= 300 && x <= 390 && y >= 350 && y <= 440) {
                gameState.difficulty = 2;
                easyDifficultySelected = false;
                mediumDifficultySelected = false;
                hardDifficultySelected = true;
            }
        }
        
        // add if/else if conditionals for each of the sets
        
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
