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
    
    ButtonGroup group = new ButtonGroup();
    
    group.add(missileB);
    group.add(airStrikeB);
    group.add(bombardmentB);
    
    bombPanel.add(missileB);
    bombPanel.add(airStrikeB);
    bombPanel.add(bombardmentB);
    
    bombardmentB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "First action listener");
      }
      
      
    }); 
    
    missileB.addActionListener(new ActionListener (){
      
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Second action listener");
        
      }
      
      
    }); 
    
    airStrikeB.addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "Third action listener");
      }
    });
    
    
    
    
    //Cash Panel
    cashPanel.setLayout(new GridLayout(2,1));
    JLabel cashDisplay = new JLabel("                                        CASH: $" + cash);
    JButton done = new JButton("CLEAR");
    cashPanel.add(cashDisplay);
    cashPanel.add(done);
    add(bottomPanel, BorderLayout.SOUTH);
    
    done.addActionListener(new ActionListener (){
      
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "I want to clear everything");
      }
      
      
    }); 
    
  }
  
  
  //Action listener for water buttons
  class buttonListener implements ActionListener {
    
    int buttonpress=1;
    
    int[] storea = new int[5];
    int[] storeb = new int[5];
    
    int reference [][]; {
      reference = new int [15][15];
      
      
     //Creating the reference array and setting all values to -1 
      for(int a=0;a<15;a++){
        for(int b=0;b<15;b++){
          
          reference[a][b]=-1;
          
        }
      }
    }
    
    
    public void actionPerformed(ActionEvent event) {
      
      
      
      for(int i=0;i<jb.length;i++){
        for(int j=0;j<jb[0].length;j++){
          
          
          if(jb[i][j]==event.getSource()){
            buttonpress++;//Add one to button press after button is clicked
            jb[i][j].setEnabled(true);
            ImageIcon xImage=new ImageIcon (this.getClass().getResource("x.jpg"));
            jb[i][j].setIcon(xImage);
            
                                             
            reference[i][j]=0;
            
            JOptionPane.showMessageDialog (null, reference[1][1]);
            
            storea[buttonpress] = i;
            storeb[buttonpress] = j;      
            JOptionPane.showMessageDialog (null, "The value of i is: " + storea[buttonpress] + "The value of j is: " + storeb[buttonpress]);//Test to see if values are stored
            
          }
          
          
          if (buttonpress >= 5){ //if button press more than 5 times
            JPanel middlePanel = new JPanel();
            middlePanel.setLayout(new GridLayout(15,15));
            for (i = 0; i < 15; i++){
              for (j = 0 ; j < 15; j++){
                jb[i][j] = new JButton();
                jb[i][j].setPreferredSize(new Dimension(10,10));
                ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
                jb[i][j].setIcon(Water);
                
                if (reference[i][j]==0){
                Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
                jb[i][j].setIcon(Water);
                }
                middlePanel.add(jb[i][j]);                
              }     
            }
            
            
            
            
            
          }
        }
        
        
      }
    } 
    
  }
}

