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


public class MainScreen extends JPanel implements Screen, MouseListener {

    private GameState gameState;
    private JLabel backgroundLabel;
    
    // here is our constructor for MainScreen
    // here we initialize our mainscreen (buttons, background, and etc)
    public MainScreen(GameState state) {
        this.gameState = state;
        if (gameState.theme == "default") {
            ImageIcon mainScreenBackground = new ImageIcon("default-mainscreenbackground.gif");
            backgroundLabel = new JLabel(mainScreenBackground);
            add(backgroundLabel, BorderLayout.CENTER);
            addMouseListener(this);
        }
        else if (gameState.theme == "sunset") {
            ImageIcon mainScreenBackground = new ImageIcon("sunset-mainscreenbackground.gif");
            backgroundLabel = new JLabel(mainScreenBackground);
            add(backgroundLabel, BorderLayout.CENTER);
            addMouseListener(this);
        }
        else if (gameState.theme == "snowy") {
            ImageIcon mainScreenBackground = new ImageIcon("snowy-mainscreenbackground.gif");
            backgroundLabel = new JLabel(mainScreenBackground);
            add(backgroundLabel, BorderLayout.CENTER);
            addMouseListener(this);
        }
        else if (gameState.theme == "rainy") {
            ImageIcon mainScreenBackground = new ImageIcon("rainy-mainscreenbackground.gif");
            backgroundLabel = new JLabel(mainScreenBackground);
            add(backgroundLabel, BorderLayout.CENTER);
            addMouseListener(this);
        }
        else if (gameState.theme == "night") {
            ImageIcon mainScreenBackground = new ImageIcon("night-mainscreenbackground.gif");
            backgroundLabel = new JLabel(mainScreenBackground);
            add(backgroundLabel, BorderLayout.CENTER);
            addMouseListener(this);
        }
        else if (gameState.theme == "adventure") {
            ImageIcon mainScreenBackground = new ImageIcon("adventure-mainscreenbackground.gif");
            backgroundLabel = new JLabel(mainScreenBackground);
            add(backgroundLabel, BorderLayout.CENTER);
            addMouseListener(this);
        }
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
    
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        
        //theme selection
        if (x >= 268 && x <= 322 && y >= 668 && y <= 722) {
            if (gameState.theme == "sunset") {
                gameState.theme = "default";
                Main.switchScreen(new MainScreen(gameState));
            } else {
                gameState.theme = "sunset";
                Main.switchScreen(new MainScreen(gameState));
            }
        }
        
        else if (x >= 346 && x <= 400 && y >= 668 && y <= 722) {
            if (gameState.theme == "snowy") {
                gameState.theme = "default";
                Main.switchScreen(new MainScreen(gameState));
            } else {
                gameState.theme = "snowy";
                Main.switchScreen(new MainScreen(gameState));
            }
        }
        
        else if (x >= 423 && x <= 477 && y >= 668 && y <= 722) {
            if (gameState.theme == "rainy") {
                gameState.theme = "default";
                Main.switchScreen(new MainScreen(gameState));
            } else {
                gameState.theme = "rainy";
                Main.switchScreen(new MainScreen(gameState));
            }
        }
        
        else if (x >= 501 && x <= 554 && y >= 668 && y <= 722) {
            if (gameState.theme == "night") {
                gameState.theme = "default";
                Main.switchScreen(new MainScreen(gameState));
            } else {
                gameState.theme = "night";
                Main.switchScreen(new MainScreen(gameState));
            }
        }
        
        else if (x >= 578 && x <= 632 && y >= 668 && y <= 722) {
            if (gameState.theme == "adventure") {
                gameState.theme = "default";
                Main.switchScreen(new MainScreen(gameState));
            } else {
                gameState.theme = "adventure";
                Main.switchScreen(new MainScreen(gameState));
            }
        }
        
        //first rectangle of play button
        if (x >= 310 && x <= 588 && y >= 506 && y <= 515) {
            Main.switchScreen(new Options(gameState));
        }
        
        //second rectangle of play button
        if (x >= 302 && x <= 596 && y >= 516 && y <= 524) {
            Main.switchScreen(new Options(gameState));
        }
        
        //third rectangle of play button
        if (x >= 293 && x <= 605 && y >= 524 && y <= 532) {
            Main.switchScreen(new Options(gameState));
        }
        
        //fourth rectangle of play button
        if (x >= 285 && x <= 614 && y >= 532 && y <= 550) {
            Main.switchScreen(new Options(gameState));
        }
        
        // Play Button Big Rectangle (in the middle)
        if (x >= 268 && x <= 631 && y >= 550 && y <= 594) {
            Main.switchScreen(new Options(gameState));
        }
        
        //sixth rectangle of play button
        if (x >= 284 && x <= 614 && y >= 594 && y <= 611) {
            Main.switchScreen(new Options(gameState));
        }
        
        //seventh rectangle of play button
        if (x >= 293 && x <= 605 && y >= 612 && y <= 620) {
            Main.switchScreen(new Options(gameState));
        }
        
        //eigth rectangle of play button
        if (x >= 302 && x <= 597 && y >= 621 && y <= 629) {
            Main.switchScreen(new Options(gameState));
        }
        
        //ninth rectangle of play button
        if (x >= 311 && x <= 588 && y >= 629 && y <= 637) {
            Main.switchScreen(new Options(gameState));
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