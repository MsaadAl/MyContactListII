import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Msaad Albryah
 * Description: Edit cantact program.
 */

public class PhoneEditCantact extends javax.swing.JFrame {
private javax.swing.JLabel NameLabel1;
private javax.swing.JLabel PhoeNumberLabel2;

private javax.swing.JTextField NameTextField1;
private javax.swing.JTextField PhoneNumberTextField2;
private javax.swing.JButton EditButton1;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JPanel jPanel3;
private javax.swing.JPanel jPanel4;
private javax.swing.JPanel jPanel5;

public PhoneEditCantact(String name, String number){
setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);

setResizable(true);
/**
* Add two label for name and number 
*/
NameLabel1 = new javax.swing.JLabel(PhoneMainActivity.language.get(2));
PhoeNumberLabel2 = new javax.swing.JLabel(PhoneMainActivity.language.get(3));
/**
* Here add the text for name and number of cantact. 
*/
NameTextField1 = new javax.swing.JTextField(15);
PhoneNumberTextField2 = new javax.swing.JTextField(10);
/**
* here set the text for name and number. 
*/
NameTextField1.setText(name);
PhoneNumberTextField2.setText(number);
/**
* button for EDIT and DONE
*/
EditButton1 = new javax.swing.JButton(PhoneMainActivity.language.get(24));

jPanel1 = new javax.swing.JPanel(new java.awt.GridLayout(4, 1, 1, 5));

jPanel1.add(NameLabel1);
jPanel1.add(PhoeNumberLabel2);


jPanel2 = new javax.swing.JPanel(new java.awt.GridLayout(4, 1));

jPanel2.add(NameTextField1);
jPanel2.add(PhoneNumberTextField2);

jPanel3 = new javax.swing.JPanel(new java.awt.FlowLayout());

jPanel3.add(jPanel1);
jPanel3.add(jPanel2);

jPanel4 = new javax.swing.JPanel(new java.awt.FlowLayout());

jPanel4.add(EditButton1);
/**
* Here when a user click on the button edit it will act by bringing the information that a user select to edit.
*/
EditButton1.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
PhoneMainActivity.editContact(new PhoneSetting(NameTextField1.getText(), PhoneNumberTextField2.getText()));
file_logging(PhoneMainActivity.language.get(26));
setVisible(false);
dispose();
}
});
jPanel5 = new javax.swing.JPanel(new java.awt.BorderLayout());

jPanel5.add(jPanel3, java.awt.BorderLayout.CENTER);
jPanel5.add(jPanel4, java.awt.BorderLayout.SOUTH);

getContentPane().add(jPanel5);

pack();
setVisible(true);
}
// main
public static void main(String args[]) {
javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);

new PhoneEditCantact("", "").setVisible(true);
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
