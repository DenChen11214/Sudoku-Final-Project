import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class readPuzzle{
    private String[][] solution = new String[9][9];
    public readPuzzle(){
    	try{
	    	File f = new File("1.csv");//can combine
	    	Scanner in = new Scanner(f).useDelimiter(",");//into one line
	    	for (int i=0;i<9;i++){
	    		for (int ii=0;ii<9;ii++){
	    			solution[i][ii]= in.next();
	    		}
	    	}
		}catch(FileNotFoundException e){
	    	System.out.println("File not found");
	    	System.exit(1);
		}
    }
}
	