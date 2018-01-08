public class solveSudoku{
	private int[][] grid;

	//checks whether or not a certain number (num) is already in the row
	public boolean rowsafe(int row, int num){
		for (int col =0; col < 9; col++){
			if (grid[row][col] == num){
				return false;
			}
		}
		return true;
	}
	//checks whether or not a certain number (num) is already in the column
	public boolean colsafe(int col, int num){
		for (int row =0; row < 9; row++){
			if (grid[row][col] == num){
				return false;
			}
		}
		return true;
	}
  //checks whether or not a certain number is already in the box
  //the box number goes horizontally to the next row
  public boolean boxSafe(int box, int num){
    int boxRow = 0;
    int boxCol = 0;
    for(int i = box; i >0 ;i -= 3){
      boxRow ++;
      if(i <= 0){
        i = 0;
      }
    }
    if(box <= 3){
      boxCol = box;
    }
    for(int i = box; i > 0;i-=3){
      boxCol = i;
    }
    boxRow = 1 + (boxRow - 1) * 3;
    boxCol = 1 + (boxCol - 1) * 3;
    for(int r = boxRow; r <= boxRow + 2;r++){
      for(int c = boxCol;c <= boxCol + 2;c++ ){
        if(grid[r][c] == num ){
          return false;
        }
      }
    }
    return true;
  }
  public static void main(String[] args){
    grid = new int[9][9];
    System.out.println(this.boxSafe(1,4));
  }
}
