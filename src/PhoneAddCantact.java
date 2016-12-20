import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

/**
 * @author Msaad Albryah
 
 * Description: My Phone add cantact program.
 */

public class PhoneAddCantact extends javax.swing.JFrame {
private javax.swing.JLabel Person_name_label;
private javax.swing.JLabel Phone_number_label;
private javax.swing.JFrame jFrame;

private javax.swing.JTextField Person_name_TextF;
private javax.swing.JTextField Phone_number_TextF;
private javax.swing.JButton Add_Button;
private javax.swing.JButton Done_Button;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JPanel jPanel3;
private javax.swing.JPanel jPanel4;
private javax.swing.JPanel jPanel5;

public PhoneAddCantact(){

setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);

setResizable(true);

Person_name_label = new javax.swing.JLabel(PhoneMainActivity.language.get(1));
Phone_number_label = new javax.swing.JLabel(PhoneMainActivity.language.get(2));
/**
* Add the JTextField for Name and Number. 
*/
Person_name_TextF = new javax.swing.JTextField(15);
Phone_number_TextF = new javax.swing.JTextField(10);
/**
* Add two btn for add and cancel 
*/
Add_Button = new javax.swing.JButton(PhoneMainActivity.language.get(21));
Done_Button = new javax.swing.JButton(PhoneMainActivity.language.get(22));
/**
* Add two JPanels for name and number. 
*/
jPanel1 = new javax.swing.JPanel(new java.awt.GridLayout(4, 1, 1, 5));

jPanel1.add(Person_name_label);
jPanel1.add(Phone_number_label);

jPanel2 = new javax.swing.JPanel(new java.awt.GridLayout(4, 1));

jPanel2.add(Person_name_TextF);
jPanel2.add(Phone_number_TextF);

jPanel3 = new javax.swing.JPanel(new java.awt.FlowLayout());

jPanel3.add(jPanel1);
jPanel3.add(jPanel2);

jPanel4 = new javax.swing.JPanel(new java.awt.FlowLayout());

jPanel4.add(Add_Button);
jPanel4.add(Done_Button);

/**
* Here when a user click on add buttom it will open a new window which is cantain 
* two TextField for (name, number). 
*/
Add_Button.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
if(Phone_number_TextF.getText().matches("^\\d+$")){
PhoneMainActivity.AddContact(new PhoneSetting(Person_name_TextF.getText(), Phone_number_TextF.getText()));
file_logging(PhoneMainActivity.language.get(21));
dispose();
}
else{
JOptionPane.showMessageDialog(jFrame,
PhoneMainActivity.language.get(23),
PhoneMainActivity.language.get(12),
   JOptionPane.ERROR_MESSAGE);
Phone_number_TextF.setText("");
}
}
});
/**
* Here the DONE btn.So, when a user add all the cantact he or she needs, then, 
* they can just click on done btn to close the add window.  
* 
*/
Done_Button.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
setVisible(true);
dispose();
}
});
/**
* Panel location "Center and South. 
*/
jPanel5 = new javax.swing.JPanel(new java.awt.BorderLayout());

jPanel5.add(jPanel3, java.awt.BorderLayout.CENTER);
jPanel5.add(jPanel4, java.awt.BorderLayout.SOUTH);

getContentPane().add(jPanel5);

pack();
setVisible(true);
}
/**
* Main method 
* @param args
*/
public static void main(String args[]) {
javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);

new PhoneAddCantact().setVisible(true);
}
public void file_logging(String Action){
    
Logger logger = Logger.getLogger("MyLog");  
   FileHandler fh;  

   try {  

       // This block configure the logger with handler and formatter  
       fh = new FileHandler("MyLogFile.log");  
       logger.addHandler(fh);
       SimpleFormatter formatter = new SimpleFormatter();  
       fh.setFormatter(formatter);  

       // the following statement is used to log any messages  
       logger.info(Action);  

   } catch (SecurityException e) {  
       e.printStackTrace();  
   } catch (IOException e) {  
       e.printStackTrace();  
   }  

  
}
}
