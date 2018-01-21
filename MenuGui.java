import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
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
    pane.setBackground(Color.WHITE);
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    this.setTitle("Sudoku Menu");
    this.setSize(550,400);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    start = new JButton("Play");
    sudoku = new JLabel("Sudoku");
    seed = new JLabel("Seed(Optional):");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    difficultyMenu = new JComboBox<>(difficultyList);
    difficultyLabel = new JLabel("Difficulty:");
    seedNumber = new JTextField(6);

    //editing fields
    sudoku.setFont(new Font("Serif Bold", Font.PLAIN, 40));
    difficultyLabel.setFont(new Font("Serif",Font.PLAIN, 20));
    seed.setFont(new Font("Serif",Font.PLAIN, 20));
    seedNumber.setMinimumSize(new Dimension(200,25));
    seedNumber.setPreferredSize(new Dimension(200,25));
    seedNumber.setMaximumSize(new Dimension(200,25));
    difficultyMenu.setMinimumSize(new Dimension(100,25));
    difficultyMenu.setPreferredSize(new Dimension(100,25));
    difficultyMenu.setMaximumSize(new Dimension(100,25));
    start.setMinimumSize(new Dimension(140,40));
    start.setPreferredSize(new Dimension(140,40));
    start.setMaximumSize(new Dimension(140,40));
    sudoku.setAlignmentX(Component.CENTER_ALIGNMENT);
    start.setAlignmentX(Component.CENTER_ALIGNMENT);
    difficultyMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    difficultyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    seedNumber.setAlignmentX(Component.CENTER_ALIGNMENT);
    seed.setAlignmentX(Component.CENTER_ALIGNMENT);
    start.addActionListener(this);
    
    //adding fields to the pane
    pane.add(sudoku);
    pane.add(Box.createRigidArea(new Dimension(0,20))); 
    pane.add(difficultyLabel);
    pane.add(Box.createRigidArea(new Dimension(0,10)));
    pane.add(difficultyMenu);
    pane.add(Box.createRigidArea(new Dimension(0,20)));
    pane.add(seed);
    pane.add(Box.createRigidArea(new Dimension(0,10)));
    pane.add(seedNumber);
    pane.add(Box.createRigidArea(new Dimension(0,50)));
    pane.add(start);
  }
  public void actionPerformed(ActionEvent e){
      String s = e.getActionCommand();
      if(s.equals("Play")){
        if (seedNumber.getText().equals("")){
          puzzleGUI p = new puzzleGUI((String)difficultyMenu.getSelectedItem());
          p.setVisible(true);
          this.setVisible(false);
        }
        else{
          try{
          puzzleGUI p = new puzzleGUI(Integer.parseInt(seedNumber.getText()),(String)difficultyMenu.getSelectedItem());
          p.setVisible(true);
          this.setVisible(false);
        }
        catch(NumberFormatException error){
          seedNumber.setText("Please enter an integer");
        }
        }
      }
  }
  public static void main(String[] args){
    MenuGui m = new MenuGui();
    m.setVisible(true);
  }
}
