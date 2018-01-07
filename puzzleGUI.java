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
    public puzzleGUI(){
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	this.setTitle("Sudoku");
	this.setSize(900, 800);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	seed = new JLabel("Seed:");
	seedNumber = new JTextField("seedNumber");
	checkText = new JTextField("checkText");
	hint = new JButton("hint");
	check = new JButton("check");
	solution = new JButton("solution");
	backToMenu = new JButton("backToMenu");
	reset = new JButton("reset");
	pane.add(seed);
	pane.add(seedNumber);
	for (int i=0;i<9;i++){
		for (int ii=0; ii<9; ii++){
			pane.add(puzzle[i][ii]);
		}
	}
	pane.add(checkText);
	pane.add(hint);
	pane.add(check);
	pane.add(solution);
	pane.add(backToMenu);
	pane.add(reset);
    }
    public void actionPerformed(ActionEvent e){
    }
}
	
	
