import com.raylib.Raylib;

public class Simulation {
  private Grid grid;
  private Grid tmp;

  static final int[][] neighborOffset = {
    {-1, -1}, // top left
    {-1, 0},  // top
    {-1, 1},  // top right
    {0, -1},  // left
    {0, 1},   // right
    {1, -1},  // bottom left
    {1, 0},   // bottom
    {1, 1}    // bottom right
  };

  public Simulation(int width, int height, int cellSize, Raylib.Color alive, Raylib.Color death) {
    this.grid = new Grid(width, height, cellSize, alive, death);
    this.tmp = this.grid;
  }

  public void Draw() {
    grid.Draw();
  }

  public void SetState(int x, int y, boolean state) {
    grid.SetState(x, y, state);
  }

  public int GetState(int x, int y) {
    return grid.GetState(x, y);
  }

  public int CountAliveNeighbor(int x, int y) {
    int count = 0;
    for (final int[] n : neighborOffset) {
      int xn = (x + n[0] + grid.GetRows()) % grid.GetRows();
      int yn = (y + n[1] + grid.GetCols()) % grid.GetCols();
      count += grid.GetState(xn, yn);
    }
    return count;
  }

  public void Update() {
    for (int row = 0; row < grid.GetRows(); row++) {
      for (int col = 0; col < grid.GetCols(); col++) {
        int n = CountAliveNeighbor(row, col);
        int state = GetState(row, col);

        if (state == 1 && n < 2) {
          this.tmp.SetState(row, col, false);
        } else if ((n == 2 || n == 3) && (state == 1)) {
          this.tmp.SetState(row, col+1, false);
        } else if (state == 1 && n > 3) {
          this.tmp.SetState(row, col, false);
        } else if (state == 0 && n == 3) {
          this.tmp.SetState(row, col, true);
        }
      }
    }

    this.grid = this.tmp;
  }
}
