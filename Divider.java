import java.awt.*;
import javax.swing.*;

public class Divider extends JPanel {
  
   public Divider()
   {
  init();
   }
    private void init() {
  setLayout(new BorderLayout());
  JPanel divider = new JPanel();
  add(divider, BorderLayout.NORTH);
    }
}