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
import java.util.Random;

public class GameScreen extends JPanel implements Screen, MouseListener{
    
    private GameState gameState;    
    private ArrayList<String> grid = new ArrayList<String>(Arrays.asList("", "", "", "", "", "", "", "", ""));
    
    private Boolean player1Turn;
    
    private BufferedImage XImage;
    private BufferedImage OImage;
    private BufferedImage player1Icon;
    private BufferedImage player2Icon;
    private BufferedImage score0Icon;
    private BufferedImage score1Icon;
    private BufferedImage score2Icon;
    private BufferedImage score3Icon;
    private BufferedImage scoreLine;
    
    private ImageIcon gameScreenBackground;
    private ImageIcon player1Avatar;
    private ImageIcon player2Avatar;
    private ImageIcon player1MaleWin;
    private ImageIcon player1FemaleWin;
    private ImageIcon player2MaleWin;
    private ImageIcon player2FemaleWin;
    private ImageIcon playerMaleWinAgainstRobot;
    private ImageIcon playerFemaleWinAgainstRobot;
    private ImageIcon RobotWin;

    private int turnNumber = 0;

    public GameScreen(GameState state) {
        this.gameState = state;
        // determining which player moves first depending on which round it is
        if (gameState.roundNumber % 2 == 1) {
            player1Turn = true;
        } else {
            player1Turn = false;
        }

        // importing all of the required images/gifs and mouselistener
        try {
            if (gameState.theme == "default") {
                gameScreenBackground = new ImageIcon("default-gamescreenbackground.gif");
                
                XImage = ImageIO.read(new File("default-x.png"));
                OImage = ImageIO.read(new File("default-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "sunset") {
                gameScreenBackground = new ImageIcon("sunset-gamescreenbackground.gif");
                
                XImage = ImageIO.read(new File("sunset-x.png"));
                OImage = ImageIO.read(new File("sunset-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "snowy") {
                gameScreenBackground = new ImageIcon("snowy-gamescreenbackground.gif");
                
                XImage = ImageIO.read(new File("snowy-x.png"));
                OImage = ImageIO.read(new File("snowy-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "rainy") {
                gameScreenBackground = new ImageIcon("rainy-gamescreenbackground.gif");
                
                XImage = ImageIO.read(new File("rainy-x.png"));
                OImage = ImageIO.read(new File("rainy-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "night") {
                gameScreenBackground = new ImageIcon("night-gamescreenbackground.gif");
                
                XImage = ImageIO.read(new File("night-x.png"));
                OImage = ImageIO.read(new File("night-o.png"));
                addMouseListener(this);
            }
            else if (gameState.theme == "adventure") {
                gameScreenBackground = new ImageIcon("adventure-gamescreenbackground.gif");
                
                XImage = ImageIO.read(new File("adventure-x.png"));
                OImage = ImageIO.read(new File("adventure-o.png"));
                addMouseListener(this);
            }
            
            if (gameState.players == 1) {
                if (gameState.player1 == 0) {
                    player1Icon = ImageIO.read(new File("male-icon.png"));
                    player1Avatar = new ImageIcon("male-avatar.gif");
                } else if (gameState.player1 == 1) {
                    player1Icon = ImageIO.read(new File("female-icon.png"));
                    player1Avatar = new ImageIcon("female-avatar.gif");
                }
                player2Icon = ImageIO.read(new File("robot-icon.png"));
                player2Avatar = new ImageIcon("robot-avatar.gif");
            } else if (gameState.players == 2) {
                if (gameState.player1 == 0) {
                    player1Icon = ImageIO.read(new File("male-icon.png"));
                    player1Avatar = new ImageIcon("male-avatar.gif");
                } else if (gameState.player1 == 1) {
                    player1Icon = ImageIO.read(new File("female-icon.png"));
                    player1Avatar = new ImageIcon("female-avatar.gif");
                }
                if (gameState.player2 == 0) {
                    player2Icon = ImageIO.read(new File("male-icon.png"));
                    player2Avatar = new ImageIcon("male-avatar-flipped.gif");
                } else if (gameState.player2 == 1) {
                    player2Icon = ImageIO.read(new File("female-icon.png"));
                    player2Avatar = new ImageIcon("female-avatar.gif");
                }
            }
            scoreLine = ImageIO.read(new File("score-line.png"));
            score0Icon = ImageIO.read(new File("score-0.png"));
            score1Icon = ImageIO.read(new File("score-1.png"));
            score2Icon = ImageIO.read(new File("score-2.png"));
            score3Icon = ImageIO.read(new File("score-3.png"));
            
            player1MaleWin = new ImageIcon("player1-male-win.gif");
            player1FemaleWin = new ImageIcon("player1-female-win.gif");
            player2MaleWin = new ImageIcon("player2-male-win.gif");
            player2FemaleWin = new ImageIcon("player2-female-win.gif");
            playerMaleWinAgainstRobot = new ImageIcon("player-win-male.gif");
            playerFemaleWinAgainstRobot = new ImageIcon("player-win-female.gif");
            RobotWin = new ImageIcon("robot-win.gif");
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
    //
    public Component getComponent(){
        return this;
    }
    
    @Override
    // used to paint all the components of the screen, including background, players, and score. all the visuals:
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(!(gameState.scorePlayer1 == (gameState.rounds/2+1)) || !(gameState.scorePlayer2 == (gameState.rounds/2+1))) {
            gameScreenBackground.paintIcon(this, g, 0, 0);
            player1Avatar.paintIcon(this, g, 11, 335);
            player2Avatar.paintIcon(this, g, 698, 335);
            
            g.drawImage(player1Icon, 287, 65, this);
            g.drawImage(player2Icon, 555, 65, this);
            g.drawImage(scoreLine, 0, 0, this);
            if(grid.get(0) == "x") {
                g.drawImage(XImage, 241, 241, this);
            } else if(grid.get(0) == "o") {
                g.drawImage(OImage, 241, 241, this);
            }
            if(grid.get(1) == "x") {
                g.drawImage(XImage, 396, 241, this);
            } else if(grid.get(1) == "o") {
                g.drawImage(OImage, 396, 241, this);
            }
            if(grid.get(2) == "x") {
                g.drawImage(XImage, 551, 241, this);
            } else if(grid.get(2) == "o") {
                g.drawImage(OImage, 551, 241, this);
            }
            if(grid.get(3) == "x") {
                g.drawImage(XImage, 241, 396, this);
            } else if(grid.get(3) == "o") {
                g.drawImage(OImage, 241, 396, this);
            }
            if(grid.get(4) == "x") {
                g.drawImage(XImage, 396, 396, this);
            } else if(grid.get(4) == "o") {
                g.drawImage(OImage, 396, 396, this);
            }
            if(grid.get(5) == "x") {
                g.drawImage(XImage, 551, 396, this);
            } else if(grid.get(5) == "o") {
                g.drawImage(OImage, 551, 396, this);
            }
            if(grid.get(6) == "x") {
                g.drawImage(XImage, 241, 551, this);
            } else if(grid.get(6) == "o") {
                g.drawImage(OImage, 241, 551, this);
            }
            if(grid.get(7) == "x") {
                g.drawImage(XImage, 396, 551, this);
            } else if(grid.get(7) == "o") {
                g.drawImage(OImage, 396, 551, this);
            }
            if(grid.get(8) == "x") {
                g.drawImage(XImage, 551, 551, this);
            } else if(grid.get(8) == "o") {
                g.drawImage(OImage, 551, 551, this);
            }

            if (gameState.scorePlayer1 == 0) {
                g.drawImage(score0Icon, 351, 54, this);
            } else if (gameState.scorePlayer1 == 1) {
                g.drawImage(score1Icon, 351, 54, this);
            } else if (gameState.scorePlayer1 == 2) {
                g.drawImage(score2Icon, 351, 54, this);
            } else if (gameState.scorePlayer1 == 3) {
                g.drawImage(score3Icon, 351, 54, this);
            }

            if (gameState.scorePlayer2 == 0) {
                g.drawImage(score0Icon, 482, 54, this);
            } else if (gameState.scorePlayer2 == 1) {
                g.drawImage(score1Icon, 482, 54, this);
            } else if (gameState.scorePlayer2 == 2) {
                g.drawImage(score2Icon, 482, 54, this);
            } else if (gameState.scorePlayer2 == 3) {
                g.drawImage(score3Icon, 482, 54, this);
            }
        }

        // showing win/lose screens if the score does equal the number of rounds needed to win
        if (gameState.scorePlayer1 == (gameState.rounds/2 + 1) && gameState.player1 == 0) {
            player1MaleWin.paintIcon(this, g, 0, 0);
        } else if (gameState.scorePlayer1 == (gameState.rounds/2 + 1) && gameState.player1 == 1) {
            player1FemaleWin.paintIcon(this, g, 0, 0);
        } else if (gameState.scorePlayer2 == (gameState.rounds/2 + 1) && gameState.players == 2 && gameState.player2 == 0) {
            player2MaleWin.paintIcon(this, g, 0, 0);
        } else if (gameState.scorePlayer2 == (gameState.rounds/2 + 1) && gameState.players == 2 && gameState.player2 == 1) {
            player2FemaleWin.paintIcon(this, g, 0, 0);
        } else if(gameState.scorePlayer2 == (gameState.rounds/2 + 1) && gameState.players == 1) {
            RobotWin.paintIcon(this, g, 0, 0);
        } else if (gameState.scorePlayer1 == (gameState.rounds/2 + 1) && gameState.player1 == 0 && gameState.players == 1) {
            playerMaleWinAgainstRobot.paintIcon(this, g, 0, 0);
        } else if (gameState.scorePlayer1 == (gameState.rounds/2 + 1) && gameState.player1 == 1 && gameState.players == 1) {
            playerFemaleWinAgainstRobot.paintIcon(this, g, 0, 0);
        }

    }
    
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        System.out.println("mouse click detected at " + x + ", " + y);

        if (x >= 229 && x <= 362 && y >= 229 && y <= 362) {
            System.out.println("top left square clicked");
            if(!player1Turn) {
                if(grid.get(0) == "") {
                    grid.set(0, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(0) == "") {
                    grid.set(0, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 384 && x <= 516 && y >= 229 && y <= 362) {
            System.out.println("top middle square clicked");
            if(!player1Turn) {
                if(grid.get(1) == "") {
                    grid.set(1, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(1) == "") {
                    grid.set(1, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 538 && x <= 671 && y >= 229 && y <= 362) {
            System.out.println("top right square clicked");
            if(!player1Turn) {
                if(grid.get(2) == "") {
                    grid.set(2, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(2) == "") {
                    grid.set(2, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 229 && x <= 362 && y >= 384 && y <= 516) {
            System.out.println("middle left square clicked");
            if(!player1Turn) {
                if(grid.get(3) == "") {
                    grid.set(3, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(3) == "") {
                    grid.set(3, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 384 && x <= 516 && y >= 384 && y <= 516) {
            System.out.println("middle middle square clicked");
            if(!player1Turn) {
                if(grid.get(4) == "") {
                    grid.set(4, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(4) == "") {
                    grid.set(4, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 538 && x <= 671 && y >= 384 && y <= 516) {
            System.out.println("middle right square clicked");
            if(!player1Turn) {
                if(grid.get(5) == "") {
                    grid.set(5, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(5) == "") {
                    grid.set(5, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 229 && x <= 362 && y >= 538 && y <= 671) {
            System.out.println("bottom left square clicked");
            if(!player1Turn) {
                if(grid.get(6) == "") {
                    grid.set(6, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(6) == "") {
                    grid.set(6, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 384 && x <= 516 && y >= 538 && y <= 671) {
            System.out.println("bottom middle square clicked");
            if(!player1Turn) {
                if(grid.get(7) == "") {
                    grid.set(7, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(7) == "") {
                    grid.set(7, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }
        
        if (x >= 538 && x <= 671 && y >= 538 && y <= 671) {
            System.out.println("bottom right square clicked");
            if(!player1Turn) {
                if(grid.get(8) == "") {
                    grid.set(8, "x");
                    player1Turn = false;
                    turnNumber += 1;
                }
            } else if (gameState.players == 2) {
                if(grid.get(8) == "") {
                    grid.set(8, "o");
                    player1Turn = true;
                    turnNumber += 1;
                }
            } else if (gameState.players == 1) {
                grid.set(findBestMove(grid, gameState.difficulty), "o");
                player1Turn = true;
                turnNumber += 1;
            }
        }

        if(player1Turn) {
            if(isWinning(grid, "o")) {
                gameState.scorePlayer2 += 1;
                gameState.roundNumber += 1;
                delay(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Main.switchScreen(new GameScreen(gameState));
                    }
                });
            }
        } else {
            if(isWinning(grid, "x")) {
                gameState.scorePlayer1 += 1;
                gameState.roundNumber += 1;
                delay(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Main.switchScreen(new GameScreen(gameState));
                    }
                });
            }
        }

        if (turnNumber == 9) {
                delay(1500, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Main.switchScreen(new GameScreen(gameState));
                    }
                });
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
    
    public static void delay(int milliseconds, ActionListener action) {
        Timer timer = new Timer(milliseconds, action);
        timer.setRepeats(false);
        timer.start();
    }
    
    public int findBestMove(ArrayList<String> grid, int difficulty) {
        if (difficulty == 0) {
            return findRandomMove(grid);
        } else if (difficulty == 1) {
            return findMediumMove(grid);
        } else if (difficulty == 2) {
            return findHardMove(grid);
        }
        return -1;
    }

    private int findRandomMove(ArrayList<String> grid) {
        Random rand = new Random();
        ArrayList<Integer> emptyPositions = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).equals("")) {
                emptyPositions.add(i);
            }
        }
        if (emptyPositions.isEmpty()) {
            return -1;
        }
        return emptyPositions.get(rand.nextInt(emptyPositions.size()));
    }

    private int findMediumMove(ArrayList<String> grid) {
        int move = findWinningMove(grid, "x");
        if (move != -1) {
            return move;
        }
        return findRandomMove(grid);
    }

    private int findWinningMove(ArrayList<String> grid, String player) {
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).equals("")) {
                grid.set(i, player);
                if (isWinning(grid, player)) {
                    grid.set(i, "");
                    return i;
                }
                grid.set(i, "");
            }
        }
        return -1;
    }

    private boolean isWinning(ArrayList<String> grid, String player) {
        for (int i = 0; i < 3; i++) {
            if (grid.get(i * 3).equals(player) && grid.get(i * 3 + 1).equals(player) && grid.get(i * 3 + 2).equals(player)) {
                return true;
            }
            if (grid.get(i).equals(player) && grid.get(i + 3).equals(player) && grid.get(i + 6).equals(player)) {
                return true;
            }
        }
        if (grid.get(0).equals(player) && grid.get(4).equals(player) && grid.get(8).equals(player)) {
            return true;
        }
        if (grid.get(2).equals(player) && grid.get(4).equals(player) && grid.get(6).equals(player)) {
            return true;
        }
        return false;
    }

    private int findHardMove(ArrayList<String> grid) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).equals("")) {
                grid.set(i, "o");
                int score = minimax(grid, 0, false);
                grid.set(i, "");
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    private int minimax(ArrayList<String> grid, int depth, boolean isMaximizing) {
        String result = checkWinner(grid);
        if (result.equals("x")) return -10;
        if (result.equals("o")) return 10;
        if (result.equals("draw")) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < grid.size(); i++) {
                if (grid.get(i).equals("")) {
                    grid.set(i, "o");
                    int score = minimax(grid, depth + 1, false);
                    grid.set(i, "");
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < grid.size(); i++) {
                if (grid.get(i).equals("")) {
                    grid.set(i, "x");
                    int score = minimax(grid, depth + 1, true);
                    grid.set(i, "");
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }
    
    private String checkWinner(ArrayList<String> grid) {
        for (int i = 0; i < 3; i++) {
            if (!grid.get(i * 3).equals("") && grid.get(i * 3).equals(grid.get(i * 3 + 1)) && grid.get(i * 3 + 1).equals(grid.get(i * 3 + 2))) {
                return grid.get(i * 3);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!grid.get(i).equals("") && grid.get(i).equals(grid.get(i + 3)) && grid.get(i + 3).equals(grid.get(i + 6))) {
                return grid.get(i);
            }
        }

        if (!grid.get(0).equals("") && grid.get(0).equals(grid.get(4)) && grid.get(4).equals(grid.get(8))) {
            return grid.get(0);
        }
        if (!grid.get(2).equals("") && grid.get(2).equals(grid.get(4)) && grid.get(4).equals(grid.get(6))) {
            return grid.get(2);
        }

        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).equals("")) {
                return "";
            }
        }

        return "draw";
    }
}
