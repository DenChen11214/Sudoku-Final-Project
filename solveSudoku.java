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
}