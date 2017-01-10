import java.awt.*;
import javax.swing.*;
public class MainMenu {
  
  
  public static void main(String[] args) { 
    
  JFrame MainMenu = new JFrame("Main Menu");
  MainMenu.setLocationRelativeTo(null);
  MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  MainMenu.setVisible(true);
  MainMenu.setExtendedState(MainMenu.getExtendedState() | JFrame.MAXIMIZED_BOTH);
  MainMenu.setLayout(new BorderLayout());
  }
  

  
}
