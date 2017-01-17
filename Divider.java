import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Divider extends JPanel {
  
  static JButton[] boatButtons = new JButton[5];
  
  public final String[] size = new String[1];
  
  LeftField leftField;
  
  public Divider(LeftField fieldLeft)
  {
    leftField = fieldLeft;
    init();
  }
  
  private void init() {
    
    //Creates and stores -1 in a reference array
              int [][] referenceBoard= new int [15][15];
              for(int row=0 ; row < 15 ; row++){
                for(int column=0 ; column < 15 ; column++ ){
                referenceBoard[row][column]=-1;
                }
              }
    
    ImageIcon ac=new ImageIcon (this.getClass().getResource("aircraftcarrier.jpg"));
    ImageIcon destroyer=new ImageIcon (this.getClass().getResource("destroyer.jpg"));
    ImageIcon sub=new ImageIcon (this.getClass().getResource("submarine.jpg"));
    ImageIcon patrol=new ImageIcon (this.getClass().getResource("patrol.jpg"));
    
    setLayout(new BorderLayout());
    JPanel divider = new JPanel();
    add(divider, BorderLayout.NORTH);
    
    
    JLabel title = new JLabel("                                                                                                 Ships");
    add(title, BorderLayout.NORTH);
    
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(6 , 1));
    // ActionListener buttonListen = new ActionListener();
    for (int i = 4; i >= 0; i--){
        boatButtons[i] = new JButton();
        
        //GOOD ACTION LISTENER
    boatButtons[i].addActionListener(new ActionListener (){
      public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 15; i++){
      for (int j = 0 ; j < 15; j++){

        leftField.jb[i][j].setEnabled(true);
      }
        }
        
        String Direction = null;
            
      //Gives user option to choose what direction to place their ships
      Direction = JOptionPane.showInputDialog (null, "Please choose a direction");
      
     
      
    }
    });
        
        boatButtons[i].setName((i+1)+"");
        boatButtons[i].setPreferredSize(new Dimension(10,10));                                
        middlePanel.add(boatButtons[i]);
        boatButtons[i].addActionListener(new ActionListener(){
          
          public void actionPerformed(ActionEvent event) {
            
            
            System.out.println(((JButton)event.getSource()).getName());
            size[0] = ((JButton)event.getSource()).getName();
            
          }
          
        });
      
    }
    boatButtons[4].setIcon(ac);
    boatButtons[3].setIcon(destroyer);
    boatButtons[2].setIcon(sub);
    boatButtons[1].setIcon(patrol);
    
    add(middlePanel, BorderLayout.CENTER);
    
  }
}
  




