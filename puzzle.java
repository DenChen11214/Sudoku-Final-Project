import java.util.*;
public class puzzle{
    private int[][] grid = new int[9][9];
    private Random randgen;
    public puzzle(){
	generateFull();
    }
    public puzzle(int randSeed){
	this();
	randgen = new Random(randSeed);
    }
    public void generateFull(){
    }
}
    
	
	
