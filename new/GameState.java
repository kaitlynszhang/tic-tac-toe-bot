public class GameState {
    int players; // either 1 or 2
    int mode; // 2, 3 (2 for 2d and 3 for 3d)
    int boardSize; // 3, 4, 5 (3x3, 4x4, 5x5)
    int difficulty; // 0 for easy, 1 for medium, 2 for hard (only when computer is chosen)
    int rounds; // 1, 3, 5
    int player1; //0 for male, 1 for female
    int player2; //0 for male, 1 for female
    String theme; // sunset, snowy, rainy, night, adventure
    int roundNumber = 1; // for keeping track of which round we are on
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
}