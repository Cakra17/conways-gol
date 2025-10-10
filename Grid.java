import com.raylib.Raylib;

public class Grid {
  private int rows;
  private int cols;
  private int cellSize;
  private Raylib.Color alive;
  private Raylib.Color death;
  public int[][] cells;

  public Grid (int width, int height, int cellSize, Raylib.Color alive, Raylib.Color death) {
    this.rows = height / cellSize;
    this.cols = width / cellSize;
    this.cellSize = cellSize;
    this.alive = alive;
    this.death = death;
    this.cells = new int[rows][cols];

    FillRandom();
  }

  public void Draw() {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        Raylib.Color color = cells[row][col] == 1 ? alive : death;
        Raylib.DrawRectangle(col * cellSize, row * cellSize, cellSize - 1, cellSize - 1, color);
      }
    }
  }

  public void SetState(int row, int col, boolean state) {
    if (row >= 0 && row < rows && col >= 0 && col < cols)
      cells[row][col] = state ? 1 : 0;
  }

  public int GetState(int row, int col) {
    if (row >= 0 && row <= rows && col >= 0 && col <= cols)
      return cells[row][col];
    return 0;
  }

  public int GetRows() {
    return this.rows;
  }

  public int GetCols() {
    return this.cols;
  }

  public void FillRandom() {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int random = (int) (Math.random() * 2);
        cells[row][col] = random;
      }
    }
  }
}
