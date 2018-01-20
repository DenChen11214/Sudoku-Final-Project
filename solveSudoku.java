import java.util.*;
public class solveSudoku{
    private int[][] grid;

    public solveSudoku(){
    	grid = new int[9][9];
    	grid[1][2]=3;
   	}
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
	return rowsafe(row,num)&&colsafe(col,num)&&boxSafe(row, col, num);
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
    public boolean solve(){
	int row = nextRow();
	int col = nextCol();
	if (row==-1){
	    return true;
	}
	else{
	    for (int num = 1; num <= 9; num++){
		if (isSafe(row, col, num)){
		    grid[row][col] = num;
		    if (solve()){
			return true;
		    }
		    grid[row][col] = 0;
		}
	    }
	}
    return false;
}
	public String toString() {
      return Arrays.deepToString(grid);
   }
	public static void main(String[] args) {
		solveSudoku a = new solveSudoku();
		a.solve();
		System.out.println(a);
	}
}
