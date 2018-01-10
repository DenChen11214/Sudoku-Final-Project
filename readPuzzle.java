import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class readPuzzle{
private String[][] puzzle =new String[9][9];
private String[][] solution = new String[9][9];
    public readPuzzle(){
    	try{
	    File f = new File("1.csv");//can combine
	    Scanner in = new Scanner(f).useDelimiter(",");//into one line
	    	for (int i=0;i<9;i++){
		    for (int ii=0;ii<9;ii++){
			if (in.hasNext()){
			    puzzle[i][ii]= in.next();
			}
		    }
	    	}
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}
	try{
	    File f = new File("1 solution.csv");//can combine
	    Scanner in = new Scanner(f).useDelimiter(",");//into one line
	    	for (int i=0;i<9;i++){
		    for (int ii=0;ii<9;ii++){
			if (in.hasNext()){
			    solution[i][ii]= in.next();
			}
		    }
	    	}
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	    System.exit(1);
	}
    }
    public String toString(){
	String ans="";
	for (int row = 0; row < 9; row++){
	    for (int col = 0; col < 9; col++){
		ans+="" + solution[row][col];
		ans+=("\n");
	    }
	}
	return ans;
    }
    public String[][] getPuzzle(){
		String[][] ans= new String[9][9];
		for (int i=0;i<9;i++){
		    for (int ii=0;ii<9;ii++){
		    	ans[i][ii]=puzzle[i][ii];
		    }
		}
		return ans;
	}
	public String[][] getSolution(){
		String[][] ans= new String[9][9];
		for (int i=0;i<9;i++){
		    for (int ii=0;ii<9;ii++){
		    	ans[i][ii]=solution[i][ii];
		    }
		}
		return ans;
	}
	public static void main(String[] args){
    	readPuzzle a = new readPuzzle();
    	System.out.println(a);
    }
}
	