import com.raylib.Helpers;
import com.raylib.Raylib;

public class Main {
  static final int SCREEN_WIDTH = 800;
  static final int SCREEN_HEIGHT = 600;
  static final int FPS = 12;
  static final int CELL_SIZE = 4;

  static final Raylib.Color BACKGROUND = Helpers.newColor(40, 40, 40, 255);
  static final Raylib.Color ALIVE = Helpers.newColor(0, 255, 0, 255);
  static final Raylib.Color DEATH = Helpers.newColor(55, 55, 55, 255);

  public static void main(String[] args) {
    Raylib.InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "Conway's Game of Life");
    Raylib.SetTargetFPS(FPS);
    Simulation simulation = new Simulation(SCREEN_WIDTH, SCREEN_HEIGHT, CELL_SIZE, ALIVE, DEATH);

    while(!Raylib.WindowShouldClose()) {
      simulation.Update();

      Raylib.BeginDrawing();
      Raylib.ClearBackground(BACKGROUND);
      simulation.Draw();
      Raylib.EndDrawing();
    }
    Raylib.CloseWindow();
  }
}