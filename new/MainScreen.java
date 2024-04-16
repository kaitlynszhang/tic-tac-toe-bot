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
    
    // here is our ___________ for MainScreen
    // here we initialize our mainscreen (buttons, background, and etc)
    public MainScreen(GameState state) {
        this.gameState = state;
        ImageIcon mainScreenBackground = new ImageIcon("mainscreenbackground.gif");
        backgroundLabel = new JLabel(mainScreenBackground);
        add(backgroundLabel, BorderLayout.CENTER);
        addMouseListener(this);
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
    }
    
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        
        // Big Rectangle (in the middle)
        if (x >= 268 && x <= 631 && y >= 519 && y <= 563) {
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