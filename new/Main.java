import javax.swing.JFrame;

public class Main
{
    private static JFrame frame;
    private static Screen currentScreen;
    private static GameState gameState;
    
    // here we initialize the JFrame with the function and create a gameState and show the Main Screen
    public static void main(String[] args)
    {
        gameState = new GameState();
        initializeFrame();
        gameState.theme = "default";
        switchScreen(new MainScreen(gameState));
    }
    
    private static void initializeFrame() {
        frame = new JFrame();
        frame.setBounds(0, 0, 900, 900);
        frame.setTitle("Tic Tac Toe! by Kaitlyn Zhang");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void switchScreen(Screen newScreen) {
        if (currentScreen != null) {
            frame.remove(currentScreen.getComponent());
            currentScreen.hideScreen();
        }
        
        currentScreen = newScreen;
        frame.add(currentScreen.getComponent());
        currentScreen.showScreen();
        frame.revalidate();
        frame.repaint();
    }
}