import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MenuGui extends JFrame implements ActionListener{
    private JButton start;
    private JComboBox<String> difficultyMenu;
    private JLabel sudoku;
    private JLabel seed;
    private JLabel difficultyLabel;
    private JTextField seedNumber;
    private Container pane;
    public MenuGui(){
	String[] difficultyList = {"Easy","Medium","Hard"};
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout()); //temporary
	this.setTitle("Sudoku Menu");
	this.setSize(800,600);
	this.setLocation(0,0);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	start = new JButton("Start");
	sudoku = new JLabel("Sudoku");
	seed = new JLabel("Seed(Optional)");
	difficultyMenu = new JComboBox<>(difficultyList);
	difficultyLabel = new JLabel("Difficulty:");
	seedNumber = new JTextField(8);
	pane.add(sudoku);
	pane.add(difficultyLabel);
	pane.add(difficultyMenu);
	pane.add(seed);
	pane.add(seedNumber);
	pane.add(start);
    }
    public void actionPerformed(ActionEvent e){
	
    }
    public static void main(String[] args){
	MenuGui m = new MenuGui();
	m.setVisible(true);
    }
}
