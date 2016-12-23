import java.awt.*;
import javax.swing.*;

public class RightField extends JPanel {
 
 JButton[][] jb = new JButton[15][15];
 int cash = 4000;
 public RightField(){
  init();
 }

 private void init() {
  setLayout(new BorderLayout());
  JLabel title = new JLabel("                                               Player 2");
  add(title, BorderLayout.NORTH);
  
  JPanel middlePanel = new JPanel();
  middlePanel.setLayout(new GridLayout(15,15));
  for (int i = 0; i < 15; i++){
   for (int j = 0 ; j < 15; j++){
    jb[i][j] = new JButton();
    jb[i][j].setPreferredSize(new Dimension(10,10));
    ImageIcon trump=new ImageIcon (this.getClass().getResource("donald trump.jpg"));
     jb[i][j].setIcon(Trump);
    middlePanel.add(jb[i][j]);
   }
  }
  
  add(middlePanel, BorderLayout.CENTER);
  
  JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,2));
  JPanel bombPanel = new JPanel ();
  JPanel cashPanel = new JPanel ();
  
  bottomPanel.add(bombPanel);
  bottomPanel.add(cashPanel);
  //Bomb Panel
  bombPanel.setLayout(new GridLayout(3,1));
  
JRadioButton missileB = new JRadioButton("Missile ($1000)");
JRadioButton airStrikeB = new JRadioButton("Air Strike ($3000)");
JRadioButton bombardmentB = new JRadioButton("Bombardment ($10000)");
bombPanel.add(missileB);
bombPanel.add(airStrikeB);
bombPanel.add(bombardmentB);


  
  //Cash Panel
  cashPanel.setLayout(new GridLayout(2,1));
  JLabel cashDisplay = new JLabel("                                        CASH: $" + cash);
  JButton done = new JButton("DONE");
  cashPanel.add(cashDisplay);
  cashPanel.add(done);
  add(bottomPanel, BorderLayout.SOUTH);
  
 }

}
