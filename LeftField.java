import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class LeftField extends JPanel{
  
  JButton[][] jb = new JButton[15][15];
  int cash = 4000;
  Player p1 = new Player();
  Divider divider;
  
  public LeftField(Divider d){
    divider = d;
    begin();
  }
  
  
  private void begin() {
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
    
    
    
    
    //CLEAR Panel
    cashPanel.setLayout(new GridLayout(2,1));
    JLabel cashDisplay = new JLabel("                                        CASH: $" + cash);
    JButton done = new JButton("CLEAR");
    cashPanel.add(cashDisplay);
    cashPanel.add(done);
    add(bottomPanel, BorderLayout.SOUTH);
    
    done.addActionListener(new ActionListener (){
      
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog (null, "I want to clear everything");
        
        for (int i = 0; i < 15; i++){
              for (int j = 0 ; j < 15; j++){
                ImageIcon Water=new ImageIcon (this.getClass().getResource("Water.jpg"));
                jb[i][j].setIcon(Water);
              }
        }
      }
      
    }); 
    
  }
  
  
  
  
  //Action listener for water buttons
  class buttonListener implements ActionListener {
    
    public void actionPerformed(ActionEvent event) {
      
      
      
      for(int i=0;i<jb.length;i++){
        for(int j=0;j<jb[0].length;j++){
          
          
          
          
          if(jb[i][j]==event.getSource()){          
            jb[i][j].setEnabled(true);
            ImageIcon xImage=new ImageIcon (this.getClass().getResource("x.jpg"));
            
            
            
               //Stores all places on the board to -1
              int [][] referenceBoard= new int [15][15];
              for(int row=0 ; row < 15 ; row++){
                for(int column=0 ; column < 15 ; column++ ){
                referenceBoard[row][column]=-1;
                }
              }

           
  
            //Boats placement 
            for(int a = 0; a < Integer.parseInt(divider.size[0]); a++){
                    ImageIcon destroyer=new ImageIcon (this.getClass().getResource("destroyer.jpg"));
           jb[i][j+a].setIcon(destroyer); 
           referenceBoard[a][j+a]=-1;
          
          }//end of for loop
            
             if(referenceBoard[i][j]==-1){   
                            
                jb[i][j].setEnabled(true);
           xImage=new ImageIcon (this.getClass().getResource("x.jpg"));
            jb[i][j].setIcon(xImage);
              
              
         
              }   
  
            
          
            
        }//end of if statement 
      }
    }//end of for loop
  }
  }//end of action listener
  
  
    
  }//end of whole THING HERE

  
  
