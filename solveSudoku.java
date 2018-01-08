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
  public static int boxSafe(int box, int num){
    int boxRow = 0;
    int boxCol = 0;
    for(int i = box; i >0 ;i -= 3){
      boxRow++;
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
    return boxCol;
  }
  public static void main(String[] args){
    System.out.println(boxSafe(1,0));
    System.out.println(boxSafe(2,0));
    System.out.println(boxSafe(3,0));
    System.out.println(boxSafe(4,0));
    System.out.println(boxSafe(5,0));
    System.out.println(boxSafe(6,0));
    System.out.println(boxSafe(7,0));
    System.out.println(boxSafe(8,0));
    System.out.println(boxSafe(9,0));
  }
}
