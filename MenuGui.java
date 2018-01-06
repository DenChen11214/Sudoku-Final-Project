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
    //initizalizing fields and window settings
    String[] difficultyList = {"Easy","Medium","Hard"};
    pane = this.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    this.setTitle("Sudoku Menu");
    this.setSize(550,350);
    this.setLocation(0,0);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    start = new JButton("Play");
    sudoku = new JLabel("Sudoku");
    seed = new JLabel("Seed(Optional):");
    difficultyMenu = new JComboBox<>(difficultyList);
    difficultyLabel = new JLabel("Difficulty:");
    seedNumber = new JTextField(6);
    //editing fields
    sudoku.setFont(new Font("Serif Bold", Font.PLAIN, 40));
    difficultyLabel.setFont(new Font("Serif",Font.PLAIN, 20));
    seed.setFont(new Font("Serif",Font.PLAIN, 20));
    seedNumber.setMinimumSize(new Dimension(200,50));
    seedNumber.setPreferredSize(new Dimension(200,50));
    seedNumber.setMaximumSize(new Dimension(200,50));
    difficultyMenu.setMinimumSize(new Dimension(100,25));
    difficultyMenu.setPreferredSize(new Dimension(100,25));
    difficultyMenu.setMaximumSize(new Dimension(100,25));
    sudoku.setAlignmentY(Component.CENTER_ALIGNMENT);
    //adding fields to the pane
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
