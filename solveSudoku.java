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
    public boolean boxSafe(int row, int col, int num){
	int startRow = row/3*3;
	int startCol = col/3*3;
	for (int i=0; i<3; i++){
	    for (int ii=0; ii<3; ii++){
		if (grid[startRow+i][startCol+ii]==num){
		    return false;
		}
	    }
	}
	return true;
    }
    public boolean isSafe(int row, int col, int num){
	return rowSafe(row,num)&&colSafe(col,num)&&boxSafe(row, col, num);
    }
    public int nextRow(){
	for(int r=0;r<9;r++){
	    for (int c=0; c<9; c++){
		if (grid[r][c]==0){
		    return r;
		}
	    }
	}
	return -1;
    }
    public int nextCol(){
	for(int r=0;r<9;r++){
	    for (int c=0; c<9; c++){
		if (grid[r][c]==0){
		    return c;
		}
	    }
	}
	return -1;
    }
    public void solve(){
	int row;
	int col;
	for 
}
