import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
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
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	this.setTitle("Sudoku");
	this.setSize(900, 800);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	seed = new JLabel("Seed:");
	result = new JLabel("Result:");
	seedNumber = new JTextField(10);
	checkText = new JTextField(6);
	hint = new JButton("hint");
	check = new JButton("check");
	solution = new JButton("solution");
	backToMenu = new JButton("backToMenu");
	reset = new JButton("reset");
	for (int i=0;i<9;i++){
		for (int ii=0; ii<9; ii++){
			puzzle[i][ii]=new JTextField(8);
			pane.add(puzzle[i][ii]);
		}
	}
	pane.add(result);
	pane.add(checkText);
	pane.add(hint);
	pane.add(check);
	pane.add(solution);
	pane.add(backToMenu);
	pane.add(reset);
	pane.add(seed);
	pane.add(seedNumber);
    }
    public void actionPerformed(ActionEvent e){
    }
    public static void main(String[] args) {
    puzzleGUI m = new puzzleGUI();
    m.setVisible(true);

    }
}
	
	
