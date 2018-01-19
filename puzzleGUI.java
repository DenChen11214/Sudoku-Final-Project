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
  private readPuzzle puz;
  private JPanel puzzlePanel;
  private JPanel[] boxes = new JPanel[9];
  private JPanel features;
  private JPanel[] boxRows = new JPanel[3];
  public puzzleGUI(String dif){
    //setting fields up
    pane = this.getContentPane();
    pane.setBackground(Color.WHITE);
    features = new JPanel();
    pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
    this.setTitle("Sudoku");
    this.setSize(400,500);
    this.setLocation(0,0);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    seed = new JLabel("Seed:");
    result = new JLabel("Result:");
    seedNumber = new JTextField(10);
    seedNumber.setEditable(false);
    checkText = new JTextField(20);
    checkText.setEditable(false);
    hint = new JButton("Hint");
    check = new JButton("Check");
    solution = new JButton("Solution");
    backToMenu = new JButton("Back To Menu");
    reset = new JButton("Reset");
    for(int i=0;i<9;i++){
      boxes[i] = new JPanel();
      boxes[i].setLayout(new GridLayout(3,3));
      boxes[i].setBorder(BorderFactory.createLineBorder(Color.black));
      
    }
    for(int i=0;i<3;i++){
      boxRows[i] = new JPanel();
      boxRows[i].setLayout(new GridLayout(1,3));
    }
    //putting values of a sudoku puzzle into the textfields
    puz = new readPuzzle(dif);
    String[][] grid = puz.getPuzzle();
    for (int i=0;i<9;i++){
      for (int ii=0; ii<9; ii++){
        if(!grid[i][ii].equals("0")){
          puzzle[i][ii]=new JTextField(grid[i][ii],1);
          puzzle[i][ii].setEditable(false);
          puzzle[i][ii].setHorizontalAlignment(JTextField.CENTER);
          
          
        }
        else{
          puzzle[i][ii] = new JTextField(1);
          puzzle[i][ii].setEditable(true);
          puzzle[i][ii].setHorizontalAlignment(JTextField.CENTER);
        }
      }
    }
    //placing textfields into boxes and boxes into boxrows
    for(int r = 1;r <= 7; r +=3){
      for(int c =1; c<= 7; c+=3){
        addToBox(r,c);
      }
    }
    for(int i = 0; i< 3;i++){
      boxRows[0].add(boxes[i]);
    }
    for(int i = 3; i< 6;i++){
      boxRows[1].add(boxes[i]);
    }
    for(int i = 6; i< 9;i++){
       boxRows[2].add(boxes[i]);
    }
    for(int i =0; i< 3;i++){
      pane.add(boxRows[i]);
    }
    //editing fields
    seedNumber.setMinimumSize(new Dimension(200,25));
    seedNumber.setPreferredSize(new Dimension(200,25));
    seedNumber.setMaximumSize(new Dimension(200,25));
    checkText.setMinimumSize(new Dimension(200,25));
    checkText.setPreferredSize(new Dimension(200,25));
    checkText.setMaximumSize(new Dimension(200,25));
    seed.setAlignmentX(Component.CENTER_ALIGNMENT);
    seedNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
    checkText.setAlignmentX(Component.CENTER_ALIGNMENT);
    hint.setAlignmentX(Component.CENTER_ALIGNMENT);
    check.setAlignmentX(Component.CENTER_ALIGNMENT);
    solution.setAlignmentX(Component.CENTER_ALIGNMENT);
    backToMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    reset.setAlignmentX(Component.CENTER_ALIGNMENT);
    result.setAlignmentX(Component.CENTER_ALIGNMENT);
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
  //adds textfields to a certain box based on its starting row and col
  private void addToBox(int row, int col){
    int boxNumber = 0;
    for(int r = row; r > 1;r -= 3){
      boxNumber += 3;
    }
    for(int c = col;c > 1; c -= 3){
      boxNumber += 1;
    }
    for(int i = row; i < row + 3;i++){
      for(int n = col; n < col + 3;n++){
        boxes[boxNumber].add(puzzle[i - 1][n - 1]);
      }
    }
  }
  public puzzleGUI(int seedNum , String dif){
    //setting fields up
    pane = this.getContentPane();
    puzzlePanel = new JPanel();
    puzzlePanel.setLayout(new GridLayout(9,9));
    features = new JPanel();
    features.setLayout(new BoxLayout(features, BoxLayout.Y_AXIS));
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    this.setTitle("Sudoku");
    this.setSize(500,500);
    this.setLocation(0,0);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    seed = new JLabel("Seed:");
    result = new JLabel("Result:");
    seedNumber = new JTextField("" + seedNum,10);
    seedNumber.setEditable(false);
    checkText = new JTextField(20);
    checkText.setEditable(false);
    hint = new JButton("Hint");
    check = new JButton("Check");
    solution = new JButton("Solution");
    backToMenu = new JButton("Back To Menu");
    reset = new JButton("Reset");
    //putting values of a sudoku puzzle into the textfields
    puz = new readPuzzle(seedNum,dif);
    String[][] grid = puz.getPuzzle();
    for (int i=0;i<9;i++){
      for (int ii=0; ii<9; ii++){
        if(!grid[i][ii].equals("0")){
          puzzle[i][ii]=new JTextField(grid[i][ii],2);
          puzzle[i][ii].setEditable(false);
          puzzle[i][ii].setHorizontalAlignment(JTextField.CENTER);
        }
        else{
          puzzle[i][ii] = new JTextField(2);
          puzzle[i][ii].setEditable(true);
          puzzle[i][ii].setHorizontalAlignment(JTextField.CENTER);
        }
      }
    }
    //editing fields
    seedNumber.setMinimumSize(new Dimension(200,25));
    seedNumber.setPreferredSize(new Dimension(200,25));
    seedNumber.setMaximumSize(new Dimension(200,25));
    checkText.setMinimumSize(new Dimension(200,25));
    checkText.setPreferredSize(new Dimension(200,25));
    checkText.setMaximumSize(new Dimension(200,25));
    seed.setAlignmentX(Component.CENTER_ALIGNMENT);
    seedNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
    checkText.setAlignmentX(Component.CENTER_ALIGNMENT);
    hint.setAlignmentX(Component.CENTER_ALIGNMENT);
    check.setAlignmentX(Component.CENTER_ALIGNMENT);
    solution.setAlignmentX(Component.CENTER_ALIGNMENT);
    backToMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    reset.setAlignmentX(Component.CENTER_ALIGNMENT);
    result.setAlignmentX(Component.CENTER_ALIGNMENT);
    //adding action listeners
    check.addActionListener(this);
    hint.addActionListener(this);
    solution.addActionListener(this);
    backToMenu.addActionListener(this);
    reset.addActionListener(this);
    //adding everything
    features.add(check);
    features.add(result);
    features.add(checkText);
    features.add(hint);
    features.add(solution);
    features.add(backToMenu);
    features.add(reset);
    features.add(seed);
    features.add(seedNumber);
    pane.add(puzzlePanel);
    pane.add(features);
  }
  //sets textfields to that of the solution
  public void showSolution(){
    String[][] solutionGrid = puz.getSolution();
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
          puzzle[i][ii].setText("");
        }
      }
    }
  }
  //checks if the current board matches the solution
  public boolean checkBoard(){
    String[][] solutionGrid = puz.getSolution();
    for (int i=0;i<9;i++){
      for (int ii=0; ii<9; ii++){
        if(puzzle[i][ii].getText().length() == 0){
          return false;
        }
        else if(!puzzle[i][ii].getText().substring(0,1).equals(solutionGrid[i][ii].substring(0,1))){
          return false;
        }
      
      }
    }
    return true;
  }
  public boolean full(){
    boolean ans = true;
    for (int row=0;row<9;row++){
      for (int col=0;col<9;col++){
        if (puzzle[row][col].getText().equals("")){
          ans=false;
        }
      }
    }
    return ans;
  }
   //sets the value of an empty box to the right number
  public boolean hint(){
    if (!full()){
    Random r = new Random();
    Random c = new Random();
    int row = r.nextInt(9);
    int col = c.nextInt(9);
    if(puzzle[row][col].getText().equals("")){
      puzzle[row][col].setText(puz.getSolution()[row][col]);
    }
    else{
      hint();
    }
  }
    return true;
  }
  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    if(s.equals("Solution")){
      showSolution();
    }
    if(s.equals("Reset")){
      resetBoard();
    }
    if(s.equals("Check")){
      if(checkBoard()){
        checkText.setText("You Win!");
      }
      else{
        checkText.setText("Something's Wrong...");
      }
    }
    if(s.equals("Hint")){
      hint();
    }
    if(s.equals("Back To Menu")){
      this.setVisible(false);
      MenuGui m = new MenuGui();
      m.setVisible(true);
    }
  }
}
