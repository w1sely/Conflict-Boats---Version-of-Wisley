import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class LeftField extends JPanel{
   
 JButton[][] jb = new JButton[15][15];
 int cash = 4000;
 public LeftField(){
  init();
 }



 private void init() {
  setLayout(new BorderLayout());
  JLabel title = new JLabel("                                               Player 1");
  add(title, BorderLayout.NORTH);
  
  JPanel middlePanel = new JPanel();
  middlePanel.setLayout(new GridLayout(15,15));
  ActionListener buttonListen = new buttonListener();
  for (int i = 0; i < 15; i++){
   for (int j = 0 ; j < 15; j++){
    jb[i][j] = new JButton();
    jb[i][j].setPreferredSize(new Dimension(10,10));
    ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
    jb[i][j].setIcon(Water);
    jb[i][j].addActionListener(buttonListen);
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

bombardmentB.addActionListener(new ActionListener (){
 public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog (null, "But let's be efficient as of right now");
  }
  
  
  }); 
  

missileB.addActionListener(new ActionListener (){
  
  public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog (null, "Hi im probably going to reinstall");
  
  }
  
  
  }); 

missileB.addActionListener(new ActionListener (){
  
  public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog (null, "Hi im probably going to reinstall");
  
  }
  
  
  }); 

airStrikeB.addActionListener(new ActionListener (){
 public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog (null, "CSGO I mean let's be honest");
  }
  });
 
bombardmentB.addActionListener(new ActionListener (){
 public void actionPerformed(ActionEvent e){
  JOptionPane.showMessageDialog (null, "But let's be efficient as of right now");
  }
  
  
  }); 
  
  
  
  



  
  //Cash Panel
  cashPanel.setLayout(new GridLayout(2,1));
  JLabel cashDisplay = new JLabel("                                        CASH: $" + cash);
  JButton done = new JButton("DONE");
  cashPanel.add(cashDisplay);
  cashPanel.add(done);
  add(bottomPanel, BorderLayout.SOUTH);
  
  
 }
 class buttonListener implements ActionListener {
   public void actionPerformed(ActionEvent event) {
     for(int i=0;i<jb.length;i++){
       for(int j=0;j<jb[0].length;j++){
         if(jb[i][j]==event.getSource()){
           jb[i][j].setEnabled(false);
           ImageIcon xImage=new ImageIcon (this.getClass().getResource("x.jpg"));
           jb[i][j].setIcon(xImage);
         }
       }
     }
   }
 } 

}
