public class GameState {
    int players; // either 1 or 2
    int mode; // 2, 3 (2 for 2d and 3 for 3d)
    int boardSize; // 3, 4, 5 (3x3, 4x4, 5x5)
    int difficulty; // 0 for easy, 1 for medium, 2 for hard (only when computer is chosen)
    int rounds; // 1, 3, 5
    int themes; // 0, 1....
}