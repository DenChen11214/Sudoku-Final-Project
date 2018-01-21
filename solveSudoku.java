import java.util.*;
public class solveSudoku{
    private int[][] solution;
    private int[][] puzzle=new int[9][9];
    private Random randgen;
    public solveSudoku(String dif){
    	int difNum=0;
    	if (dif.equals("Hard")){
    		difNum=25;
    	}
    	if (dif.equals("Medium")){
    		difNum=30;
    	}
    	if (dif.equals("Easy")){
    		difNum=35;
    	}
    	randgen = new Random();
    	solution = new int[9][9];
    	addRandom();
    	solve(solution);
    	generatePuzzle(difNum);
   	}
   	public solveSudoku(int seed, String dif){
    	int difNum=0;
    	if (dif.equals("Hard")){
    		difNum=25;
    	}
    	if (dif.equals("Medium")){
    		difNum=30;
    	}
    	if (dif.equals("Easy")){
    		difNum=35;
    	}
    	randgen = new Random(seed);
    	solution = new int[9][9];
    	addRandom();
    	solve(solution);
    	generatePuzzle(difNum);
   	}

   	public void copy(){
   		for(int r=0;r<9;r++){
	    	for (int c=0; c<9; c++){
	    		puzzle[r][c]=solution[r][c];
	    	}
	    }
   	}
   	public void generatePuzzle(int dif){
   		copy();
   		while (countNums(puzzle)>dif){
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
   		for(int i =0;i<9;i++){
   			int c = randgen.nextInt(9);
   			int num = randgen.nextInt(9);
   			if (isSafe(solution,i,c,num)){
   				solution[i][c]=num;
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
    public boolean full(int[][] grid){
    	for (int r = 0; r<9; r++){
    		for (int c = 0; c<9; c++){
    			if (grid[r][c]==0){
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public boolean solve(int[][] grid){
    	if (full(grid)){
	    	return true;
		}
		int row=-1;
		int col=-1;
		for (int i = 0; i < 9; i++){
	    	for (int ii = 0; ii < 9; ii++){
				if (grid[i][ii] == 0){
		    		row =i;
		    		col=ii;
				}
	    	}
		}
	    for (int num = 1; num <= 9; num++){
			if (isSafe(grid,row, col, num)){
	    		grid[row][col] = num;
	    		if (solve(grid)){
					return true;
	    		}
	    		grid[row][col]=0;
			}
    	}
    	return false;
	}
	public String[][] getPuzzle(){
		String[][] ans = new String[9][9];
		for (int row =0; row < 9; row++){
			for (int col =0; col < 9; col++){
				ans[row][col]=""+puzzle[row][col];
			}
		}
		return ans;
	}
	public String[][] getSolution(){
		String[][] ans = new String[9][9];
		for (int row =0; row < 9; row++){
			for (int col =0; col < 9; col++){
				ans[row][col]=""+solution[row][col];
			}
		}
		return ans;
	}
	public String toString() {
      return Arrays.deepToString(puzzle);
   }
   public static void main(String[] args) {
   	solveSudoku a =new solveSudoku("Easy");
   	System.out.println(Arrays.deepToString(a.getPuzzle()));
   }
}
