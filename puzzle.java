import java.util.*;
public class puzzle{
    private int[][] grid = new int[9][9];
    private Random randgen;
    public puzzle(){
	generateFull();
    }
    public puzzle(int randSeed){
	this();
	randgen.setSeed(randSeed);
    }
    public void generateFull(){
	for (int row=0 ; row<9; row++){
	    int[] numsLeft = {1,2,3,4,5,6,7,8,9};
	    for (int col=0; col< 9; col++){
		grid[row][col]
    }
}
    
	
	
