import java.util.*;
public class solveSudoku{
    private int[][] solution;
    private int[][] puzzle=new int[9][9];
    private Random randgen;

    // contructor with difficulty and no seed
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
   	// contructor with difficulty and seed
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
   	//creates an identical copy of solution into puzzle
   	public void copy(){
   		for(int r=0;r<9;r++){
	    	for (int c=0; c<9; c++){
	    		puzzle[r][c]=solution[r][c];
	    	}
	    }
   	}
   	public void generatePuzzle(int dif){
   		copy(); //makes puzzle full
   		while (countNums(puzzle)>dif){  //checks how many nums are left
   			int r = randgen.nextInt(9);
   			int c = randgen.nextInt(9);
   			int old = puzzle[r][c];
   			if (old!=0){ //chooses a random number in the puzzle and removes it from a temporary grid to check if the puzzle is still solvable
   				int[][] temp = new int[9][9];
   				for (int row =0; row < 9; row++){
					for (int col =0; col < 9; col++){
						temp[row][col]=puzzle[row][col];
					}
				}
				temp[r][c]=0;
				if (solve(temp)){ //if temp is solvable make change to the actual puzzle
					puzzle[r][c]=0;
				}
   			}
   		}
   	}
   	//adds a random number to each row
   	public void addRandom(){ 
   		for(int i =0;i<9;i++){
   			int c = randgen.nextInt(9);
   			int num = randgen.nextInt(9);
   			if (isSafe(solution,i,c,num)){
   				solution[i][c]=num;
   			}
   		}
   	}
   	// counts how many numbers are filled in on the int[][]
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
    // checks if a number is allowed to be put in the certain box
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
    // checks if it is safe to put a number
    public boolean isSafe(int[][]grid,int row, int col, int num){
	return rowsafe(grid,row,num)&&colsafe(grid,col,num)&&boxSafe(grid,row, col, num);
    }
    //finds the row number of the next empty cell
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
    //finds the col number of the next empty cell
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
    // checks if the int[][] completely filled in
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
    //solves the int[][] to create a filled in solution
    public boolean solve(int[][] grid){
    	if (full(grid)){ //checks if full
	    	return true;
		}
		int row=nextRow(grid);   //finds next empty cell
		int col=nextCol(grid);
		//puts a number in the empty cell and repeats till it either finishes or reaches a point where no number can be put in
	    for (int num = 1; num <= 9; num++){   
			if (isSafe(grid,row, col, num)){
	    		grid[row][col] = num;
	    		if (solve(grid)){
					return true;
	    		}
	    		grid[row][col]=0; // if it doesn't work reverse the changes
			}
    	}
    	return false; 
	}
	// returns a copy of the puzzle
	public String[][] getPuzzle(){
		String[][] ans = new String[9][9];
		for (int row =0; row < 9; row++){
			for (int col =0; col < 9; col++){
				ans[row][col]=""+puzzle[row][col];
			}
		}
		return ans;
	}
	//returns a copy of the solution
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
}