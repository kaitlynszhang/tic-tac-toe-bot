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
    //player mode
    private BufferedImage onePlayerImage;
    private BufferedImage twoPlayerImage;
    private boolean onePlayerSelected = false;
    private boolean twoPlayerSelected = false;
    // difficulty
    private BufferedImage easyDifficultyImage;
    private BufferedImage mediumDifficultyImage;
    private BufferedImage hardDifficultyImage;
    private boolean easyDifficultySelected = false;
    private boolean mediumDifficultySelected = false;
    private boolean hardDifficultySelected = false;
    // dimensions
    private BufferedImage TwoDimImage;
    private BufferedImage ThreeDimImage;
    private boolean TwoDimSelected = false;
    private boolean ThreeDimSelected = false;
    // board size
    private BufferedImage ThreexThreeImage;
    private BufferedImage FourxFourImage;
    private BufferedImage FivexFiveImage;
    private boolean ThreexThreeSelected = false;
    private boolean FourxFourSelected = false;
    private boolean FivexFiveSelected = false;
    // number of rounds
    private BufferedImage bestOf1Image;
    private BufferedImage bestOf3Image;
    private BufferedImage bestOf5Image;
    private boolean bestOf1Selected = false;
    private boolean bestOf3Selected = false;
    private boolean bestOf5Selected = false;
    //player 1 gender
    private BufferedImage p1MaleImage;
    private BufferedImage p1FemaleImage;
    private boolean p1MaleSelected = false;
    private boolean p1FemaleSelected = false;
    //player 2 gender
    private BufferedImage p2MaleImage;
    private BufferedImage p2FemaleImage;
    private boolean p2MaleSelected = false;
    private boolean p2FemaleSelected = false;
    
    public Options(GameState state) {
        this.gameState = state;
        try {
            background = ImageIO.read(new File("options-page.png"));
            onePlayerImage = ImageIO.read(new File("oneplayer.png"));
            twoPlayerImage = ImageIO.read(new File("twoplayer.png"));
            
            easyDifficultyImage = ImageIO.read(new File("easy.png"));
            mediumDifficultyImage = ImageIO.read(new File("medium.png"));
            hardDifficultyImage = ImageIO.read(new File("hard.png"));
            
            TwoDimImage = ImageIO.read(new File("2d.png"));
            ThreeDimImage = ImageIO.read(new File("3d.png"));
            
            ThreexThreeImage = ImageIO.read(new File("3x3.png"));
            FourxFourImage = ImageIO.read(new File("4x4.png"));
            FivexFiveImage = ImageIO.read(new File("5x5.png"));
            
            bestOf1Image = ImageIO.read(new File("best of 1.png"));
            bestOf3Image = ImageIO.read(new File("best of 3.png"));
            bestOf5Image = ImageIO.read(new File("best of 5.png"));
            
            p1MaleImage = ImageIO.read(new File("p1 male.png"));
            p1FemaleImage = ImageIO.read(new File("p1 female.png"));
            
            p2MaleImage = ImageIO.read(new File("p2 male.png"));
            p2FemaleImage = ImageIO.read(new File("p2 female.png"));
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
            if (easyDifficultySelected) {
                g.drawImage(easyDifficultyImage, 0, 0, this);
                if (ThreexThreeSelected) {
                    g.drawImage(ThreexThreeImage, 0, 0, this);
                }
                if (FourxFourSelected) {
                    g.drawImage(FourxFourImage, 0, 0, this);
                }
                if (FivexFiveSelected) {
                    g.drawImage(FivexFiveImage, 0, 0, this);
                }
            } else if (mediumDifficultySelected) {
                g.drawImage(mediumDifficultyImage, 0, 0, this);
                if (ThreexThreeSelected) {
                    g.drawImage(ThreexThreeImage, 0, 0, this);
                }
            } else if (hardDifficultySelected) {
                g.drawImage(hardDifficultyImage, 0, 0, this);
                if (ThreexThreeSelected) {
                    g.drawImage(ThreexThreeImage, 0, 0, this);
                }
            }
            
            if (bestOf1Selected) {
                g.drawImage(bestOf1Image, 0, 0, this);
            } else if (bestOf3Selected) {
                g.drawImage(bestOf3Image, 0, 0, this);
            } else if (bestOf5Selected) {
                g.drawImage(bestOf5Image, 0, 0, this);
            }
            
            if (p1MaleSelected) {
                g.drawImage(p1MaleImage, 0, 0, this);
            } else if (p1FemaleSelected) {
                g.drawImage(p1FemaleImage, 0, 0, this);
            }
        }
    
        if (twoPlayerSelected) {
            g.drawImage(twoPlayerImage, 0, 0, this);
            if (TwoDimSelected) {
                g.drawImage(TwoDimImage, 0, 0, this);
                if (ThreexThreeSelected) {
                    g.drawImage(ThreexThreeImage, 0, 0, this);
                }
                if (FourxFourSelected) {
                    g.drawImage(FourxFourImage, 0, 0, this);
                }
                if (FivexFiveSelected) {
                    g.drawImage(FivexFiveImage, 0, 0, this);
                }
            } else if (ThreeDimSelected) {
                g.drawImage(ThreeDimImage, 0, 0, this);
                if (ThreexThreeSelected) {
                    g.drawImage(ThreexThreeImage, 0, 0, this);
                }
            }
            
            if (bestOf1Selected) {
                g.drawImage(bestOf1Image, 0, 0, this);
            } else if (bestOf3Selected) {
                g.drawImage(bestOf3Image, 0, 0, this);
            } else if (bestOf5Selected) {
                g.drawImage(bestOf5Image, 0, 0, this);
            }
            
            if (p1MaleSelected) {
                g.drawImage(p1MaleImage, 0, 0, this);
            } else if (p1FemaleSelected) {
                g.drawImage(p1FemaleImage, 0, 0, this);
            }
            
            if (p2MaleSelected) {
                g.drawImage(p2MaleImage, 0, 0, this);
            } else if (p2FemaleSelected) {
                g.drawImage(p2FemaleImage, 0, 0, this);
            }
        }
    }
    
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("mouse click detected at " + x + ", " + y);
        // one and two player button
        if (x >= 98 && x <= 388 && y >= 204 && y <= 294) {
            gameState.players = 1;
            onePlayerSelected = true;
            twoPlayerSelected = false;
            System.out.println("1 player selected");
        } else if (x >= 502 && x <= 802 && y >= 203 && y <= 293) {
            gameState.players = 2;
            onePlayerSelected = false;
            twoPlayerSelected = true;
            System.out.println("2 players selected");
        }
        
        if (onePlayerSelected) {
            // difficulty buttons
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
            // board size buttons
            if (x >= 98 && x <= 320 && y >= 485 && y <= 575) {
                gameState.boardSize = 3;
                ThreexThreeSelected = true;
                FourxFourSelected = false;
                FivexFiveSelected = false;
            } else if (x >= 335 && x <= 557 && y >= 485 && y <= 575 && easyDifficultySelected == true) {
                gameState.boardSize = 4;
                ThreexThreeSelected = false;
                FourxFourSelected = true;
                FivexFiveSelected = false;
            } else if (x >= 572 && x <= 795 && y >= 485 && y <= 575 && easyDifficultySelected == true) {
                gameState.boardSize = 5;
                ThreexThreeSelected = false;
                FourxFourSelected = false;
                FivexFiveSelected = true;
            }
            // p1 gender buttons
            if (x >= 158 && x <= 199 && y >= 764 && y <= 813) {
                gameState.player1 = 0;
                p1MaleSelected = true;
                p1FemaleSelected = false;
            } else if (x >= 224 && x <= 268 && y >= 764 && y <= 813) {
                gameState.player1 = 1;
                p1MaleSelected = false;
                p1FemaleSelected = true;
            }
        }
    
        if (twoPlayerSelected) {
            // dimensions buttons
            if (x >= 502 && x <= 646 && y >= 350 && y <= 440) {
                gameState.mode = 2;
                TwoDimSelected = true;
                ThreeDimSelected = false;
            } else if (x >= 653 && x <= 795 && y >= 350 && y <= 440) {
                gameState.mode = 3;
                TwoDimSelected = false;
                ThreeDimSelected = true;
            }
            // board sizes buttons
            if (x >= 98 && x <= 320 && y >= 485 && y <= 575) {
                gameState.boardSize = 3;
                ThreexThreeSelected = true;
                FourxFourSelected = false;
                FivexFiveSelected = false;
            } else if (x >= 335 && x <= 557 && y >= 485 && y <= 575 && TwoDimSelected == true) {
                gameState.boardSize = 4;
                ThreexThreeSelected = false;
                FourxFourSelected = true;
                FivexFiveSelected = false;
            } else if (x >= 572 && x <= 795 && y >= 485 && y <= 575 && TwoDimSelected == true) {
                gameState.boardSize = 5;
                ThreexThreeSelected = false;
                FourxFourSelected = false;
                FivexFiveSelected = true;
            }
            // p1 gender buttons
            if (x >= 158 && x <= 199 && y >= 764 && y <= 813) {
                System.out.println("Player 1 selected male");
                gameState.player1 = 0;
                p1MaleSelected = true;
                p1FemaleSelected = false;
            } else if (x >= 224 && x <= 268 && y >= 764 && y <= 813) {
                System.out.println("Player 1 selected female");
                gameState.player1 = 1;
                p1MaleSelected = false;
                p1FemaleSelected = true;
            }
            // p2 gender buttons
            if (x >= 316 && x <= 357 && y >= 764 && y <= 813) {
                System.out.println("Player 2 selected male");
                gameState.player2 = 0;
                p2MaleSelected = true;
                p2FemaleSelected = false;
            } else if (x >= 381 && x <= 425 && y >= 764 && y <= 813) {
                System.out.println("Player 2 selected female");
                gameState.player2 = 1;
                p2MaleSelected = false;
                p2FemaleSelected = true;
            }
        }
        // number of rounds buttons
        if (x >= 98 && x <= 320 && y >= 621 && y <= 713) {
            gameState.rounds = 1;
            bestOf1Selected = true;
            bestOf3Selected = false;
            bestOf5Selected = false;
        } else if (x >= 335 && x <= 557 && y >= 621 && y <= 713) {
            gameState.rounds = 3;
            bestOf1Selected = false;
            bestOf3Selected = true;
            bestOf5Selected = false;
        } else if (x >= 572 && x <= 795 && y >= 621 && y <= 713) {
            gameState.rounds = 5;
            bestOf1Selected = false;
            bestOf3Selected = false;
            bestOf5Selected = true;
        }
        repaint();
        
        // continue button
        if (x >= 583 && x <= 743 && y >= 741 && y <= 839) {
            if (gameState.players == 1 && gameState.rounds != -1 && gameState.player1 != -1) {
                Main.switchScreen(new GameScreen(gameState));
            } else if (gameState.players == 2 && gameState.rounds != -1 && gameState.player1 != -1 && gameState.player2 != -1) {
                Main.switchScreen(new GameScreen(gameState));
            }
        }
        else if (x >= 720 && x <= 812 && y >= 771 && y <= 839) {
            if (gameState.players == 1 && gameState.rounds != -1 && gameState.player1 != -1) {
                Main.switchScreen(new GameScreen(gameState));
            } else if (gameState.players == 2 && gameState.rounds != -1 && gameState.player1 != -1 && gameState.player2 != -1) {
                Main.switchScreen(new GameScreen(gameState));
            }
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
