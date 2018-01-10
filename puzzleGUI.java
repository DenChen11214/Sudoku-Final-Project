import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class puzzleGUI extends JFrame implements ActionListener{
  private JLabel seed;
  private JTextField seedNumber;
  private JTextField[][] puzzle = new JTextField[9][9];
  private JTextField checkText;
  private JButton hint;
  private JButton check;
  private JButton solution;
  private JButton backToMenu;
  private JButton reset;
  private Container pane;
  private JLabel result;
  public puzzleGUI(){
    //setting fields up
    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());
    this.setTitle("Sudoku");
    this.setSize(300,400);
    this.setLocation(0,0);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    seed = new JLabel("Seed:");
    result = new JLabel("Result:");
    seedNumber = new JTextField(10);
    checkText = new JTextField(20);
    checkText.setEditable(false);
    hint = new JButton("hint");
    check = new JButton("check");
    solution = new JButton("solution");
    backToMenu = new JButton("backToMenu");
    reset = new JButton("reset");
    //putting values of a sudoku puzzle into the textfields
    readPuzzle read = new readPuzzle();
    String[][] grid = read.getPuzzle();
    for (int i=0;i<9;i++){
	    for (int ii=0; ii<9; ii++){
        if(!grid[i][ii].equals("0")){
          puzzle[i][ii]=new JTextField(grid[i][ii],2);
          puzzle[i][ii].setEditable(false);
          pane.add(puzzle[i][ii]);
        }
        else{
          puzzle[i][ii] = new JTextField(2);
          puzzle[i][ii].setEditable(true);
          pane.add(puzzle[i][ii]);
        }
      
	    }
    }
    //adding action listeners
    check.addActionListener(this);
    hint.addActionListener(this);
    solution.addActionListener(this);
    backToMenu.addActionListener(this);
    reset.addActionListener(this);
    //adding everything
    pane.add(check);
    pane.add(result);
    pane.add(checkText);
    pane.add(hint);
    pane.add(solution);
    pane.add(backToMenu);
    pane.add(reset);
    pane.add(seed);
    pane.add(seedNumber);
  }
  //returns a String[][] of the field puzzle
  public String[][] getPuzzle(){
    String[][] puz = new String[9][9];
    for(int i = 0; i < puzzle.length;i++){
      for(int n = 0; n < puzzle[0].length; n++){
        puz[i][n] = puzzle[i][n].getText();
      }
    }
    return puz;
  }
  //sets textfields to that of the solution
  public void showSolution(){
    readPuzzle solution = new readPuzzle();
    String[][] solutionGrid = solution.getSolution();
    for (int i=0;i<9;i++){
	    for (int ii=0; ii<9; ii++){
        puzzle[i][ii].setText(solutionGrid[i][ii]);
      }
    }
  }
  //resets the non-given values to blanks
  public void resetBoard(){
    for (int i=0;i<9;i++){
	    for (int ii=0; ii<9; ii++){
        if(puzzle[i][ii].isEditable()){
          puzzle[i][ii].setText(" ");
        }
      }
    }
  }
  //checks if the current board matches the solution
  public boolean checkBoard(){
    readPuzzle solution = new readPuzzle();
    String[][] solutionGrid = solution.getSolution();
    for (int i=0;i<9;i++){
	    for (int ii=0; ii<9; ii++){
        if(!puzzle[i][ii].getText().equals(solutionGrid[i][ii])){
          return false;
        }
      }
    }
    return true;
  }
  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    if(s.equals("solution")){
      showSolution();
    }
    if(s.equals("reset")){
      resetBoard();
    }
    if(s.equals("check")){
      if(checkBoard()){
        checkText.setText("You Win!");
      }
      else{
        checkText.setText("Something's Wrong...");
      }
    }
  }
  public static void main(String[] args) {
    puzzleGUI m = new puzzleGUI();
    m.setVisible(true);

  }
}
	
	
