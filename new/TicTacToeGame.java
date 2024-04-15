import java.awt.*;
import java.awt.Color.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.net.URL.*;

public class TicTacToeGame extends JPanel implements MouseListener
{
    Image title;
    Image background;
    Image xImage;
    Image oImage;
    Image xWin;
    Image oWin;
    Image tie;

    int screen = 1;  // what screen we're on
    int players;     // how many players
    int turn = 1;    // whose turn it is (either 1 or 2)
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    int e1 = 0;
    int f = 0;
    int g1 = 0;
    int h = 0;
    int i = 0;
    
    public TicTacToeGame()
    {
        addMouseListener(this);
        
        //load images
        try
        {
            title = ImageIO.read(new File("Title.png"));
            background = ImageIO.read(new File("Background.png"));
            xImage = ImageIO.read(new File("Heart.png"));
            oImage = ImageIO.read(new File("Star.png"));
            xWin = ImageIO.read(new File("HeartWins.jpg"));
            oWin = ImageIO.read(new File("StarWins.jpg"));
            tie = ImageIO.read(new File("tie.jpg"));
        }
        catch (IOException e)
        {
        }
    }
    
    public void paint(Graphics g)
    {
        if (screen == 1)
        {
            startScreen(g);
        }
        else if (screen == 2)
        {
            drawBoard(g);
        }
        else if (screen == 3)
        {
            delay(25000);
            drawXWin(g);
        }
        else if (screen == 4)
        {
            delay(25000);
            drawOWin(g);
        }
        else if (screen == 5)
        {
            delay(25000);
            drawTie(g);
        }
    }
    
    public void startScreen(Graphics g)
    {
        g.drawImage(title, 0, 0, null);
        
        // draw player buttons
        g.setColor(new Color(255, 192, 203));
        g.fillRect(150, 500, 250, 100);
        g.fillRect(500, 500, 250, 100);
        g.setColor(Color.white);
        Font font = new Font("Bauhaus 93", Font.BOLD, 24);
        g.setFont(font);
        g.drawString("ONE PLAYER", 205, 555);
        g.drawString("TWO PLAYERS", 555, 555);
        
    }
    
    public void drawBoard(Graphics g)
    {
        g.drawImage(background, 0, 0, null);
        
        //draw board
        int width = 10;
        g.fillRect(300 - width/2, 20, width, 860);
        g.fillRect(600 - width/2, 20, width, 860);
        
        int length = 10;
        g.fillRect(20, 300 - length/2, 860, length);
        g.fillRect(20, 600 - length/2, 860, length);
        
        if (a == 1)
            g.drawImage(xImage, 0, 0, null);
        else if (a == 2)
            g.drawImage(oImage, 0, 0, null);
        
        if (b == 1)
            g.drawImage(xImage, 300, 0, null);
        else if (b == 2)
            g.drawImage(oImage, 307, 0, null);
            
        if (c == 1)
            g.drawImage(xImage, 600, 0, null);
        else if (c == 2)
            g.drawImage(oImage, 607, 0, null);
            
        if (d == 1)
            g.drawImage(xImage, 0, 307, null);
        else if (d == 2)
            g.drawImage(oImage, 0, 307, null);
            
        if (e1 == 1)
            g.drawImage(xImage, 300, 307, null);
        else if (e1 == 2)
            g.drawImage(oImage, 307, 307, null);
            
        if (f == 1)
            g.drawImage(xImage, 600, 307, null);
        else if (f == 2)
            g.drawImage(oImage, 607, 307, null);
            
        if (g1 == 1)
            g.drawImage(xImage, 0, 607, null);
        else if (g1 == 2)
            g.drawImage(oImage, 0, 607, null);
            
        if (h == 1)
            g.drawImage(xImage, 300, 607, null);
        else if (h == 2)
            g.drawImage(oImage, 307, 607, null);
            
        if (i == 1)
            g.drawImage(xImage, 600, 607, null);
        else if (i == 2)
            g.drawImage(oImage, 607, 607, null);
        
        checkWinner();
    }
    
    public void drawXWin(Graphics g)
    {
        g.drawImage(xWin, 0, 0, null);
    }
    
    public void drawOWin(Graphics g)
    {
        g.drawImage(oWin, 0, 0, null);
    }
    
    public void drawTie(Graphics g)
    {
        g.drawImage(tie, 0, 0, null);
    }
    
    public void checkWinner()
    {
        if (a == 1 && b == 1 && c == 1)
            screen = 3; // player 1 wins
        else if (d == 1 && e1 == 1 && f == 1)
            screen = 3;
        else if (g1 == 1 && h == 1 && i == 1)
            screen = 3;
        else if (a == 1 && d == 1 && g1 == 1)
            screen = 3;
        else if (b == 1 && e1 == 1 && h == 1)
            screen = 3;
        else if (c == 1 && f == 1 && i == 1)
            screen = 3;
        else if (a == 1 && e1 == 1 && i == 1)
            screen = 3;
        else if (c == 1 && e1 == 1 && g1 == 1)
            screen = 3;
            
        if (a == 2 && b == 2 && c == 2)
            screen = 4; // player 2 wins
        else if (d == 2 && e1 == 2 && f == 2)
            screen = 4;
        else if (g1 == 2 && h == 2 && i == 2)
            screen = 4;
        else if (a == 2 && d == 2 && g1 == 2)
            screen = 4;
        else if (b == 2 && e1 == 2 && h == 2)
            screen = 4;
        else if (c == 2 && f == 2 && i == 2)
            screen = 4;
        else if (a == 2 && e1 == 2 && i == 2)
            screen = 4;
        else if (c == 2 && e1 == 2 && g1 == 2)
            screen = 4;
        
        else if (a + b + c + d + e1 + f + g1 + h + i == 13) // check for tie
            screen = 5;
            
        repaint();
    }
    
    public void delay(int amount) // for delay
    {
        for (int i = 1; i <= amount; i++)
        System.out.println(i);
    }
    
    public void mouseClicked(MouseEvent e)
    {
        // Get x and y coordinates
        int x = e.getX();
        int y = e.getY();
        
        if (screen == 1) // on the title screen
        {
            if (x >= 150 && x <= 400 && y >= 500 && y <= 600) // 1 player button
            {
                players = 1;
                screen = 2;
            }
            else if (x >= 500 && x <= 750 && y >= 500 && y <= 600) // 2 player button
            {
                players = 2;
                screen = 2;
            }
        }
        else if (screen == 2 && players == 2)  // on the playing board and 2 players
        {
            if (x <= 300 && y < 300 && a == 0)  // clicked on box a
            {
                if (turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
                else
                {
                    a = 2;
                    turn = 1;
                }
            }
            if (x >= 300 && x <= 600 && y >= 0 && y <= 300 && b == 0) // box b
            {
                if (turn == 1)
                {
                    b = 1;
                    turn = 2;
                }
                else
                {
                    b = 2;
                    turn = 1;
                }
            }
            if (x >= 600 && y >= 0 && y <= 300 && c == 0) // box c
            {
                if (turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
                else
                {
                    c = 2;
                    turn = 1;
                }
            }
            if (x <= 300 && y >= 300 && y <= 600 && d == 0) // box d
            {
                if (turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
                else
                {
                    d = 2;
                    turn = 1;
                }
            }
            if (x >= 300 && x <= 600 && y >= 300 && y <= 600 && e1 == 0) // box e
            {
                if (turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }
                else
                {
                    e1 = 2;
                    turn = 1;
                }
            }
            if (x >= 600 && y >= 300 && y <= 600 && f == 0) // box f
            {
                if (turn == 1)
                {
                    f = 1;
                    turn = 2;
                }
                else
                {
                    f = 2;
                    turn = 1;
                }
            }
            if (x <= 300 && y >= 600 && g1 == 0) // box g
            {
                if (turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }
                else
                {
                    g1 = 2;
                    turn = 1;
                }
            }
            if (x >= 300 && x <= 600 && y >= 600 && h == 0) // box h
            {
                if (turn == 1)
                {
                    h = 1;
                    turn = 2;
                }
                else
                {
                    h = 2;
                    turn = 1;
                }
            }
            if (x >= 600 && y >= 600 && i == 0) // box i
            {
                if (turn == 1)
                {
                    i = 1;
                    turn = 2;
                }
                else
                {
                    i = 2;
                    turn = 1;
                }
            }
        }
        
        else if (screen == 2 && players == 1)  // on the playing board and 1 player
        {
            if (x <= 300 && y < 300 && a == 0)  // clicked on box a
            {
                if (turn == 1)
                {
                    a = 1;
                    turn = 2;
                }
            }
            if (x >= 300 && x <= 600 && y >= 0 && y <= 300 && b == 0) // box b
            {
                if (turn == 1)
                {
                    b = 1;
                    turn = 2;
                }
            }
            if (x >= 600 && y >= 0 && y <= 300 && c == 0) // box c
            {
                if (turn == 1)
                {
                    c = 1;
                    turn = 2;
                }
            }
            if (x <= 300 && y >= 300 && y <= 600 && d == 0) // box d
            {
                if (turn == 1)
                {
                    d = 1;
                    turn = 2;
                }
            }
            if (x >= 300 && x <= 600 && y >= 300 && y <= 600 && e1 == 0) // box e
            {
                if (turn == 1)
                {
                    e1 = 1;
                    turn = 2;
                }
            }
            if (x >= 600 && y >= 300 && y <= 600 && f == 0) // box f
            {
                if (turn == 1)
                {
                    f = 1;
                    turn = 2;
                }
            }
            if (x <= 300 && y >= 600 && g1 == 0) // box g
            {
                if (turn == 1)
                {
                    g1 = 1;
                    turn = 2;
                }
            }
            if (x >= 300 && x <= 600 && y >= 600 && h == 0) // box h
            {
                if (turn == 1)
                {
                    h = 1;
                    turn = 2;
                }
            }
            if (x >= 600 && y >= 600 && i == 0) // box i
            {
                if (turn == 1)
                {
                    i = 1;
                    turn = 2;
                }
            }
            
            computerMove();
        }
        
        repaint();
    }

    public void computerMove()
    {
        //offensive
        if (e1 == 0) // go for middle first
            e1 = 2;
        else if(a == 2 && b == 2 && c == 0)
            c = 2;
        else if (a == 2 && b == 0 && c == 2)
            b = 2;
        else if (a == 0 && b == 2 && c == 2)
            a = 2;
            //middle row
        else if (d == 2 && e1 == 2 && f == 0)
            f = 2;
        else if (d == 2 && e1 == 0 && f == 2)
            e1 = 2;
        else if (d == 0 && e1 == 2 && f == 2)
            d = 2;
            //bottom row
        else if (g1 == 2 && h == 2 && i == 0)
            i = 2;
        else if (g1 == 2 && h == 0 && i == 2)
            h = 2;
        else if (g1 == 0 && h == 2 && i == 2)
            g1 = 2;
            //left column
        else if (a == 2 && d == 2 && g1 == 0)
            g1 = 2;
        else if (a == 2 && d == 0 && g1 == 2)
            d = 2;
        else if (a == 0 && d == 2 && g1 == 2)
            a = 2;
            //middle column
        else if (b == 2 && e1 == 2 && h == 0)
            h = 2;
        else if (b == 2 && e1 == 0 && h == 2)
            e1 = 2;
        else if (b == 0 && e1 == 2 && h == 2)
            b = 2;
            //right column
        else if (c == 2 && f == 2 && i == 0)
            i = 2;
        else if (c == 2 && f == 0 && i == 2)
            f = 2;
        else if (c == 0 && f == 2 && i == 2)
            c = 2;
            //left to right diagonal
        else if (a == 2 && e1 == 2 && i == 0)
            i = 2;
        else if (a == 2 && e1 == 0 && i == 2)
            e1 = 2;
        else if (a == 0 && e1 == 2 && i == 2)
            a = 2;
            //right to left diagonal
        else if (c == 2 && e1 == 2 && g1 == 0)
            g1 = 2;
        else if (c == 2 && e1 == 0 && g1 == 2)
            e1 = 2;
        else if (c == 0 && e1 == 2 && g1 == 2)
            c = 2;
        //defensive
        //top row
        else if (a == 1 && b == 1 && c == 0)
            c = 2;
        else if (a == 1 && b == 0 && c == 1)
            b = 2;
        else if (a == 0 && b == 1 && c == 1)
            a = 2;
            //middle row
        else if (d == 1 && e1 == 1 && f == 0)
            f = 2;
        else if (d == 1 && e1 == 0 && f == 1)
            e1 = 2;
        else if (d == 0 && e1 == 1 && f == 1)
            d = 2;
            //bottom row
        else if (g1 == 1 && h == 1 && i == 0)
            i = 2;
        else if (g1 == 1 && h == 0 && i == 1)
            h = 2;
        else if (g1 == 0 && h == 1 && i == 1)
            g1 = 2;
            //left column
        else if (a == 1 && d == 1 && g1 == 0)
            g1 = 2;
        else if (a == 1 && d == 0 && g1 == 1)
            d = 2;
        else if (a == 0 && d == 1 && g1 == 1)
            a = 2;
            //middle column
        else if (b == 1 && e1 == 1 && h == 0)
            h = 2;
        else if (b == 1 && e1 == 0 && h == 1)
            e1 = 2;
        else if (b == 0 && e1 == 1 && h == 1)
            b = 2;
            //right column
        else if (c == 1 && f == 1 && i == 0)
            i = 2;
        else if (c == 1 && f == 0 && i == 1)
            f = 2;
        else if (c == 0 && f == 1 && i == 1)
            c = 2;
            //left to right diagonal
        else if (a == 1 && e1 == 1 && i == 0)
            i = 2;
        else if (a == 1 && e1 == 0 && i == 1)
            e1 = 2;
        else if (a == 0 && e1 == 1 && i == 1)
            a = 2;
            //right to left diagonal
        else if (c == 1 && e1 == 1 && g1 == 0)
            g1 = 2;
        else if (c == 1 && e1 == 0 && g1 == 1)
            e1 = 2;
        else if (c == 0 && e1 == 1 && g1 == 1)
            c = 2;
        else if (a == 0)
            a = 2;
        else if (g1 == 0)
            b = 2;
            
        turn = 1;
    }
    
    public void mousePressed(MouseEvent e)
    {
        
    }
    
    public void mouseReleased(MouseEvent e)
    {
        
    }
    
    public void mouseEntered(MouseEvent e)
    {
        
    }
    
    public void mouseExited(MouseEvent e)
    {
        
    }
}