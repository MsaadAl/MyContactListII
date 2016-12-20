import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * this is a color view class which is changing the colors in the jtable
 * @author msaad albryah 
 *
 */
public class ColorViewer extends JPanel implements ActionListener {
/**
 * creating buttons 
 */
  JButton yellowButton = new JButton("Yellow");
  JButton blueButton = new JButton("Blue");
  JButton redButton = new JButton("Red");
  JButton OrangeButton = new JButton("Orange");
  JButton GrayButton = new JButton("Gray");
  JButton PinkButton = new JButton("Pink");
/**
 * adding the button
 */
  public ColorViewer() {
    add(yellowButton);
    add(blueButton);
    add(redButton);
    add(OrangeButton);
    add(GrayButton);
    add(PinkButton);

    yellowButton.addActionListener(this);
    blueButton.addActionListener(this);
    redButton.addActionListener(this);
    PinkButton.addActionListener(this);
    GrayButton.addActionListener(this);
    OrangeButton.addActionListener(this);
    setVisible(true);
  }
/**
 * action performed it the method that make the button act as i want it. 
 * so, if a user click on yellow the jtable to change to yellow and so on.
 */
  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    Color color = getBackground();
    if (source == yellowButton)
      color = Color.yellow;
    else if (source == blueButton)
      color = Color.blue;
    else if (source == redButton)
      color = Color.red;
    else if (source == PinkButton)
        color = Color.PINK;
    else if (source == GrayButton)
        color = Color.gray;
    else if (source == OrangeButton)
        color = Color.ORANGE;
    setBackground(color);
    repaint();
  }
/**
 * 
 * @param args
 */
  public static void main(String[] args) {
    JFrame frame = new JFrame("ButtonTest");
    frame.setSize(250, 250);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    Container contentPane = frame.getContentPane();
    contentPane.add(new ColorViewer());

    frame.setVisible(true);
  }
}
  