import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;


/**
 * @author Msaad Albryah
 *
 * Description: My Phone Cantact program.
 */

public class PhoneMainActivity extends javax.swing.JPanel {
private static javax.swing.JTable jMyTable;
private javax.swing.JScrollPane jScrollPane;
private javax.swing.JPanel jShape1;
private javax.swing.JPanel jShape;
private javax.swing.JFrame frame;
javax.swing.JFrame jFrame ;
private javax.swing.JButton Add_contact;
private javax.swing.JButton Edit_Cantact;
private javax.swing.JButton Delete_Cantact;
private javax.swing.JButton CloseWindow;
private javax.swing.JButton Sorting; 
private static int rowLine = 0;
JPanel panel;
ButtonGroup group;
JTextField jTextsearch;
File phoneContact = new File("Contact1.txt");
File loggingContact = new File("logging1.txt");
DefaultTableModel TableModel;
BufferedReader ReaderBuffer;
static Object[][] ContactInfo = new Object[80][2];
javax.swing.JButton Search;
static LinkedList<String> language = new LinkedList<String>(); 
JRadioButton redButton;
 JRadioButton greenButton;
 JRadioButton blueButton ;
 ActionListener listener;

/**
* Constracter
*/
public PhoneMainActivity() {
frame = new JFrame();
frame.setLayout(new FlowLayout(FlowLayout.CENTER));
JLabel J = new JLabel("for english press 1 Ou 2 pour le fran�ais ");
JPanel L = new JPanel();
JPanel L2 = new JPanel();
javax.swing.JButton English = new javax.swing.JButton("1");
English.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
control_language("English");
frame.dispose();
javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
jFrame = new javax.swing.JFrame(language.get(0));
jFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
jFrame.add(CreateTable());
jFrame.setResizable(false);

jFrame.pack();
jFrame.setLocationRelativeTo(null);
jFrame.setVisible(true);
}
});
javax.swing.JButton French = new javax.swing.JButton("2");
French.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
control_language("French");
javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
jFrame = new javax.swing.JFrame(language.get(0));
jFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
jFrame.add(CreateTable());
jFrame.setResizable(false);
jFrame.pack();
jFrame.setLocationRelativeTo(null);
jFrame.setVisible(true);
}
});
L2.add(J);
L.add(English);
L.add(French);
add(L2);
add(L);
frame.add(L2);
frame.add(L);
frame.setSize(400,150);
frame.setResizable(false);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
}

/**
* This is the add cantact method to put it in the right row of the JTable. 
* @param phoneSetting
*/
public static void AddContact(PhoneSetting phoneSetting) {
ContactInfo[rowLine][0]=phoneSetting.getName();
ContactInfo[rowLine][1]=phoneSetting.getNumber();
jMyTable.setModel(new DefaultTableModel(
ContactInfo,
new String[] {
language.get(1), language.get(2)
}
));
rowLine++;

}
/**
* Here Edit method to edit the cantact by opening the add window :) 
* @param phoneSetting
*/
public static void editContact(PhoneSetting phoneSetting) {
jMyTable.setValueAt(phoneSetting.getName(), jMyTable.getSelectedRow(), 0);
jMyTable.setValueAt(phoneSetting.getNumber(), jMyTable.getSelectedRow(), 1);
ContactInfo[jMyTable.getSelectedRow()][0]=phoneSetting.getName();
ContactInfo[jMyTable.getSelectedRow()][1]=phoneSetting.getNumber();
}
/**
* Here is the remove method to remove any selected cantact from my phone. 
*/
public void removeContact() {
for(int i = jMyTable.getSelectedRow(); i < rowLine; i++) {
jMyTable.setValueAt(jMyTable.getValueAt(i + 1, 0), i, 0);
jMyTable.setValueAt(jMyTable.getValueAt(i + 1, 1), i, 1);
ContactInfo[jMyTable.getSelectedRow()][0]=null;
ContactInfo[jMyTable.getSelectedRow()][1] =null;
}
rowLine--;
}
/**
* The MenueBar that display file, new, open, save, save as. 
* Here is how we add file menue but still need to work on it a little bit. 
* Almost done. I add JFrame in canstracter so if it doesn't work then that is one of the reason. 
* @return 
*/
  public Component showMenu(){
     //create a menu bar
     JMenuBar menuBar = new JMenuBar();
     JMenu fileMenu = new JMenu(language.get(3));
     
    
     //create menu items`
     JMenuItem newMenuItem = new JMenuItem(language.get(4));
     
     newMenuItem.setActionCommand("New");

     JMenuItem openMenuItem = new JMenuItem(language.get(5));
     openMenuItem.setActionCommand("Open");
     openMenuItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
readContactListFile();
}
});
     

     JMenuItem saveMenuItem = new JMenuItem(language.get(6));
     saveMenuItem.setActionCommand("Save");
     saveMenuItem.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
saveContactList();
}
});
      

     
     JMenuItem saveMenuItemAS = new JMenuItem(language.get(7));
     saveMenuItemAS.setActionCommand("Save As");
     saveMenuItemAS.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
saveFileByname();
}
});
     
     
     
     JMenuItem About = new JMenuItem(language.get(8));
     About.setActionCommand("About");
     About.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFrame aboutPrg = new JFrame(); 
    aboutPrg.setTitle(language.get(9)); 
    aboutPrg.setSize(250,250); 
    aboutPrg.setLocationRelativeTo(null); 
    JLabel theAbout = new JLabel(language.get(10), JLabel.CENTER);
    aboutPrg.add(theAbout); 
    aboutPrg.setVisible(true); 
     
}
});
     
    
    
     fileMenu.add(newMenuItem);
     fileMenu.add(openMenuItem);
     fileMenu.add(saveMenuItem);
     fileMenu.add(saveMenuItemAS);
     fileMenu.add(About);
         
     menuBar.add(fileMenu);
return add(menuBar);   
  }
/**
* Here is how to get the right selected cantact in JTable to edit or delete 
* However, it also recognize which part of the cantact you are editing. 
* @return
*/

public static void main(String args[]) {
new PhoneMainActivity();
}
  
    
    public void saveContactList(){
try{
if (!phoneContact.exists()) {
phoneContact.createNewFile();
}
FileWriter fileWriter = new FileWriter(phoneContact.getAbsoluteFile());
            BufferedWriter bufferwriter = new BufferedWriter(fileWriter);
            for(int row = 0; row < rowLine ; row++){
                for(int col = 0; col < 2; col++){
                    bufferwriter.write(jMyTable.getModel().getValueAt(row, col)+",");
                }  
                bufferwriter.write("\n");
            }
            bufferwriter.close();
            fileWriter.close();
JOptionPane.showMessageDialog(this, language.get(11), language.get(6), JOptionPane.INFORMATION_MESSAGE);
}catch(Exception ex){
JOptionPane.showMessageDialog(this, ex.getMessage(), language.get(12), JOptionPane.ERROR_MESSAGE);
return;
}
}
    
    

    public void saveFileByname(){
JFileChooser filesave = new JFileChooser();
int returnVal = filesave.showSaveDialog(PhoneMainActivity.this);
if (returnVal == JFileChooser.APPROVE_OPTION) { 
  try {
      File file = filesave.getSelectedFile(); 
      FileWriter FileWriter = new FileWriter(file.getAbsoluteFile());
      BufferedWriter Writer = new BufferedWriter(FileWriter);
      for (int row = 0; row < rowLine; row++) {
      for (int col = 0; col < 2; col++) { 
      Writer.write(jMyTable.getModel().getValueAt(row, col)+","); 
          } 
      Writer.write("\n");
       } 
      Writer.close();
      FileWriter.close(); 
      JOptionPane.showMessageDialog(this, language.get(13), language.get(6), JOptionPane.INFORMATION_MESSAGE); 
  } catch (IOException e1) {
  JOptionPane.showMessageDialog(this, e1.getMessage(), language.get(12), JOptionPane.ERROR_MESSAGE); 
  } 
}
}
    

    
    public void readContactListFile(){
JFileChooser fileload = new JFileChooser();
//jTable.setModel(new DefaultTableModel());
if (fileload.showOpenDialog(PhoneMainActivity.this)==JFileChooser.APPROVE_OPTION)
try{
String line;
File file = fileload.getSelectedFile();
ReaderBuffer = new BufferedReader(new FileReader(file));
TableModel = (DefaultTableModel) jMyTable.getModel();
       while((line = ReaderBuffer.readLine()) != null){
        TableModel.addRow(line.split(",")); 
       }
       ReaderBuffer.close();
}catch(Exception ex){
JOptionPane.showMessageDialog(this, ex.getMessage(), language.get(14), JOptionPane.ERROR_MESSAGE);
}
}
    
    
    public Component CreateTable(){
    JPanel styleGroupPanel = createRadioButtons();
jMyTable = new javax.swing.JTable(new DefaultTableModel());
jMyTable.setModel(new DefaultTableModel(
ContactInfo,
new String[] {
language.get(1), language.get(2)
}
));
//Table Column size
//javax.swing.table.TableColumn column = null;
//for(int i = 0; i < 2; i++) {
//column = jTable.getColumnModel().getColumn(i);
//column.setPreferredWidth(100);
 
// }
jScrollPane = new javax.swing.JScrollPane(jMyTable);

jShape1 = new javax.swing.JPanel(new java.awt.GridLayout());

jShape1.add(jScrollPane, java.awt.BorderLayout.CENTER);
/**
* Creating buttoms in the window (Add Cantact, Edit Cantact, Delete, Close)
*/
Add_contact = new javax.swing.JButton(language.get(15));
Edit_Cantact = new javax.swing.JButton(language.get(16));
Delete_Cantact = new javax.swing.JButton(language.get(17));
Search =  new javax.swing.JButton(language.get(18));
jTextsearch = new javax.swing.JTextField(30);
CloseWindow = new javax.swing.JButton(language.get(19));

jShape = new javax.swing.JPanel(new java.awt.FlowLayout());

jShape.add(Add_contact);
jShape.add(Edit_Cantact);
jShape.add(Delete_Cantact);
jShape.add(CloseWindow);
jShape.add(Search); 
jShape.add(jTextsearch);
jShape.add(showMenu());
//jShape.add(styleGroupPanel);
JPanel color = new JPanel();
color.add(styleGroupPanel);
jShape.add(color);
/**
* Here we call the class "PhoneAddCantact" in order to make the buttom add elements 
* because the method of add is in the phone add cantact class. 
*/
Add_contact.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
new PhoneAddCantact().setVisible(true);
}
});
/**
* Here I call also the class of phone Edit cantact in order to use the method and edit the cantact 
* that a user select. 
*/

Edit_Cantact.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
new PhoneEditCantact(jMyTable.getValueAt(jMyTable.getSelectedRow(), 0).toString(),
jMyTable.getValueAt(jMyTable.getSelectedRow(), 1).toString()).setVisible(true);
}
});
/**
* Here we use remove method to remove cantact. 
* The method of remove cantact is in this class :) 
*/
Delete_Cantact.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
removeContact();
}
});
/**
* Here I use exit(0); method to close the window when a user click on close. 
*/
CloseWindow.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent e) {
setVisible(true);
System.exit(0);
}
});
/**
* Size and location 
*/

Search.addActionListener(new java.awt.event.ActionListener(){
public void actionPerformed(java.awt.event.ActionEvent e) {
if(jTextsearch.getText().length()==0)
{
JOptionPane.showMessageDialog(null, language.get(20), language.get(12),  JOptionPane.ERROR_MESSAGE);
}
else{
for(int i = 0 ; i <rowLine;i++)
{
if(jTextsearch.getText().equals(ContactInfo[i][0]))
{
jMyTable.setRowSelectionInterval(i, i);
}
else if (jTextsearch.getText().equals(ContactInfo[i][1]))
{
jMyTable.setRowSelectionInterval(i, i);
}
// else if(jTextsearch.getText().equals(ContactInfo[i][0])==false) {
// JOptionPane.showMessageDialog(null, "its not in the list", "Error",  JOptionPane.ERROR_MESSAGE);
// break;
 
// }
//else if (jTextsearch.getText().equals(ContactInfo[i][1])==false){
//JOptionPane.showMessageDialog(null, "its not in the list", "Error",  JOptionPane.ERROR_MESSAGE);
// }
}
}
}
});
jShape1.add(jShape, java.awt.BorderLayout.SOUTH);
jShape1.setPreferredSize(new java.awt.Dimension(750, 300));
return add(jShape1);
}
    
 public void control_language(String user_selete){
Scanner scan = null;
try{
if(user_selete.equals("English"))
scan = new Scanner(new File("English.properties"));
else if(user_selete.equals("French"))
scan = new Scanner(new File("French.properties"));
    while(scan.hasNextLine()){
        String line = scan.nextLine();
        language.add(line);
    }
       
    
}
catch(IOException e){
 
}
 }
 
 
 public JPanel createRadioButtons()
 {
// language.get(26) means it will go to the file and then get the word in the postion 26 and replace it. 
JRadioButton redButton = new JRadioButton(language.get(26));
 redButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
jShape.setBackground(Color.RED);
}
});
 JRadioButton greenButton = new JRadioButton(language.get(27));
      greenButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
jShape.setBackground(Color.GREEN);
}
});
   
 
   JRadioButton blueButton = new JRadioButton(language.get(28));
   blueButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
jShape.setBackground(Color.BLUE);
}
});
   
   JRadioButton sorted = new JRadioButton(language.get(29));
   sorted.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {

TableRowSorter<TableModel> sorterList = new TableRowSorter<TableModel>(jMyTable.getModel());
jMyTable.setRowSorter(sorterList);

ArrayList<RowSorter.SortKey> sortkey = new ArrayList<>();
sortkey.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
sorterList.setSortKeys(sortkey);
}
});
   // Add radio buttons to button group

   //group = new ButtonGroup();
   //group.add(redButton);
   //group.add(greenButton);
   //group.add(blueButton);
   //group.add(sorted);

   panel = new JPanel();
   panel.add(redButton);
   panel.add(greenButton);
   panel.add(blueButton);
   panel.add(sorted);

   return panel;
 }
 
 
 
 
    
   
}
