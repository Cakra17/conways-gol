import com.raylib.Colors;
import com.raylib.Raylib;

public class Main {
  static final int SCREEN_WIDTH = 800;
  static final int SCREEN_HEIGHT = 600;
  static final int FPS = 60;

  static final int CELL_SIZE = 20;
  static final int COLS = SCREEN_WIDTH / CELL_SIZE;
  static final int ROWS = SCREEN_HEIGHT / CELL_SIZE;

  public static void main(String[] args) {
    Raylib.InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "Conway's Game of Life");
    Raylib.SetTargetFPS(1);
    while(!Raylib.WindowShouldClose()) {
      Raylib.BeginDrawing();
      Raylib.ClearBackground(Colors.BLACK);
      drawGrid();
      play(initGameState(COLS, ROWS));
      Raylib.EndDrawing();
    }
    Raylib.CloseWindow();
  }

  static void drawGrid() {
    for (int i = 0; i <= COLS; i++) {
      int posx = i * CELL_SIZE;
      Raylib.DrawLine(posx, 0, posx, ROWS * CELL_SIZE, Colors.GRAY);
    }

    for (int i = 0; i <= ROWS; i++) {
      int posy = i * CELL_SIZE;
      Raylib.DrawLine(0, posy, COLS * CELL_SIZE, posy, Colors.GRAY);
    }
  }

  static void drawCell(int x, int y) {
      Raylib.DrawRectangle(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, Colors.WHITE);
  }

  static int[][] initGameState(int row_count, int col_count) {
    int[][] state = new int[row_count][col_count];
    for (int i = 0; i < row_count; i++) {
      for (int j = 0; j < col_count; j++) {
        state[i][j] = (int) (Math.random() * 2);
      }
    }

    return state;
  }

  static void play(int[][] gameState) {
    for (int i = 0; i < gameState.length; i++) {
      for (int j = 0; j < gameState[i].length; j++) {
        if (gameState[i][j] == 1) {
          drawCell(i, j);
        }
      }
    }
  }
}