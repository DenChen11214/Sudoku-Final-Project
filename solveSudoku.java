import java.util.*;
public class solveSudoku{
    private int[][] solution;
    private int[][] puzzle=new int[9][9];
    private Random randgen = new Random();
    public solveSudoku(){
    	solution = new int[9][9];
    	addRandom();
    	solve(solution);
    	generatePuzzle();
   	}
   	public void copy(){
   		for(int r=0;r<9;r++){
	    	for (int c=0; c<9; c++){
	    		puzzle[r][c]=solution[r][c];
	    	}
	    }
   	}
   	public void generatePuzzle(){
   		for (int row =0; row < 9; row++){
			for (int col =0; col < 9; col++){
				puzzle[row][col]=solution[row][col];
			}
		}
   		while (countNums(puzzle)>25){
   			int r = randgen.nextInt(9);
   			int c = randgen.nextInt(9);
   			int old = puzzle[r][c];
   			if (old!=0){
   				int[][] temp = new int[9][9];
   				for (int row =0; row < 9; row++){
					for (int col =0; col < 9; col++){
						temp[row][col]=puzzle[row][col];
					}
				}
				temp[r][c]=0;
				if (solve(temp)){
					puzzle[r][c]=0;
				}
   			}
   		}
   	}
   	public void addRandom(){
   		while (countNums(solution)<12){
   			int r = randgen.nextInt(9);
   			int c = randgen.nextInt(9);
   			int num = randgen.nextInt(9);
   			if (isSafe(solution,r,c,num)){
   				solution[r][c]=num;
   			}
   		}
   	}
   	public int countNums(int[][] grid){
   		int ans=0;
   		for(int r=0;r<9;r++){
	    	for (int c=0; c<9; c++){
	    		if (grid[r][c]!=0){
	    			ans++;
	    		}
	    	}
	    }
	    return ans;
   	}
    //checks whether or not a certain number (num) is already in the row
    public boolean rowsafe(int[][] grid,int row, int num){
	for (int col =0; col < 9; col++){
	    if (grid[row][col] == num){
		return false;
	    }
	}
	return true;
    }
    //checks whether or not a certain number (num) is already in the column
    public boolean colsafe(int[][] grid,int col, int num){
	for (int row =0; row < 9; row++){
	    if (grid[row][col] == num){
		return false;
	    }
	}
	return true;
    }
    public boolean boxSafe(int[][] grid,int row, int col, int num){
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
    public boolean isSafe(int[][]grid,int row, int col, int num){
	return rowsafe(grid,row,num)&&colsafe(grid,col,num)&&boxSafe(grid,row, col, num);
    }
    public int nextRow(int[][] grid){
	for(int r=0;r<9;r++){
	    for (int c=0; c<9; c++){
		if (grid[r][c]==0){
		    return r;
		}
	    }
	}
	return -1;
    }
    public int nextCol(int[][] grid){
	for(int r=0;r<9;r++){
	    for (int c=0; c<9; c++){
		if (grid[r][c]==0){
		    return c;
		}
	    }
	}
	return -1;
    }
    public boolean solve(int[][] grid){
	int row = nextRow(grid);
	int col = nextCol(grid);
	if (row==-1){
	    return true;
	}
	else{
	    for (int num = 1; num <= 9; num++){
		if (isSafe(grid,row, col, num)){
		    grid[row][col] = num;
		    if (solve(grid)){
			return true;
		    }
		    solution[row][col] = 0;
		}
	    }
	}
    return false;
}
	public String toString() {
      return Arrays.deepToString(puzzle);
   }
	public static void main(String[] args) {
		solveSudoku a = new solveSudoku();
		System.out.println(a);
	}
}
