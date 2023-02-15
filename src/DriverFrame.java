import java.awt.*;                     //imports all the classes in the awt package
import java.awt.event.ActionEvent;     //imports the ActionEvent class
import java.awt.event.ActionListener;  //imports the ActionListener interface
import java.util.Objects;              //imports the Objects class
import javax.swing.*;                  //imports all the swing components
import java.util.Random;               //imports the Random class
import java.util.GregorianCalendar;    //imports the GregorianCalendar class

/** COPYRIGHT (C) 2021 Supun Wijesooriya. All Rights Reserved.
 * DriverFrame which is a JFrame to house all the components in the "adding driver
 * details" window.
 * Solves 5COSC019C.1 Object Oriented Programming Coursework Question #3
 * @author Supun Wijesooriya
 * @version 1.0 2021-12-15
 */


//Extending the DriverFrame class with JFrame, so it inherits the features of a JFrame
public class DriverFrame extends JFrame implements ActionListener {

    //declaration of an array of objects which has a length of 10
    public static Formula1Driver driverArr[] = new Formula1Driver[10];

    //making the swing components (JLabels) global, defining it outside the constructor
    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel label6;
    private static JLabel label7;

    //making the swing components (JTextFields) global, defining it outside the constructor
    private static JTextField textField1;
    private static JTextField textField2;
    private static JTextField textField3;
    private static JTextField textField4;
    private static JTextField textField5;
    private static JTextField textField6;

    //making the swing components (JButtons) global, defining it outside the constructor
    private static JButton btnEnt;
    private static JButton btnClear;
    private static JButton btnMenu1;
    private static JButton btnGenDate;
    private static JButton btnGenPos;
    private static JButton btnGenPoints;

    //constructor
    DriverFrame(){

        //creating a new JPanel to be placed on the JFrame
        JPanel driverPanel = new JPanel();
        driverPanel.setLayout(null);

        //declaration of JLabel label1
        label1 = new JLabel();
        label1.setText("Driver Name: ");  //set a title
        label1.setBounds(10,20,80,25);  //set up the dimensions
        driverPanel.add(label1);   //adding the JLabel to the JPanel

        //declaration of JTextField textField1
        textField1 = new JTextField("Driver_Name");  //passing text to the text field
        textField1.setBounds(100,20,223,27);  //set up the dimensions
        textField1.setBackground(Color.WHITE);  //changing the background color of the JTextField
        driverPanel.add(textField1);   //adding the JTextField to the JPanel

        //declaration of JLabel label2
        label2 = new JLabel();
        label2.setText("Location: ");  //set a title
        label2.setBounds(10,50,80,25);  //set up the dimensions
        driverPanel.add(label2); //adding the JLabel to the JPanel

        //declaration of JTextField textField2
        textField2 = new JTextField("Driver_Location");  //passing text to the text field
        textField2.setBounds(100,50,223,27);  //set up the dimensions
        textField2.setBackground(Color.WHITE);  //changing the background color of the JTextField
        driverPanel.add(textField2);

        //declaration of JLabel label3
        label3 = new JLabel();
        label3.setText("Team: ");  //set a title
        label3.setBounds(10,80,80,25);  //set up the dimensions
        driverPanel.add(label3); //adding the JLabel to the JPanel

        //declaration of JTextField textField3
        textField3 = new JTextField("Team_Name");  //passing text to the text field
        textField3.setBounds(100,80,223,27);  //set up the dimensions
        textField3.setBackground(Color.WHITE); //changing the background color of the JTextField
        driverPanel.add(textField3);

        //declaration of JLabel label4
        label4 = new JLabel();
        label4.setText("Date: ");  //set a title
        label4.setBounds(10,110,80,25);  //set up the dimensions
        driverPanel.add(label4); //adding the JLabel to the JPanel

        //declaration of JTextField textField4
        textField4 = new JTextField("mm/dd/yy");  //passing text to the text field
        textField4.setBounds(100,110,223,27);  //set up the dimensions
        textField4.setBackground(Color.WHITE); //changing the background color of the JTextField
        driverPanel.add(textField4); //adding the JLabel to the JPanel

        //declaration of JLabel label5
        label5 = new JLabel();
        label5.setText("Position: "); //set a title
        label5.setBounds(10,140,80,25);  //set up the dimensions
        driverPanel.add(label5); //adding the JLabel to the JPanel

        //declaration of JTextField textField5
        textField5 = new JTextField("1-10");  //passing text to the text field
        textField5.setBounds(100,140,223,27);  //set up the dimensions
        textField5.setBackground(Color.WHITE); //changing the background color of the JTextField
        driverPanel.add(textField5); //adding the JLabel to the JPanel

        //declaration of JLabel label6
        label6 = new JLabel();
        label6.setText("Points: "); //set a title
        label6.setBounds(10,170,80,25);  //set up the dimensions
        driverPanel.add(label6); //adding the JLabel to the JPanel

        //declaration of JTextField textField6
        textField6 = new JTextField("0");  //passing text to the text field
        textField6.setBounds(100,170,223,27);  //set up the dimensions
        textField6.setBackground(Color.WHITE); //changing the background color of the JTextField
        driverPanel.add(textField6); //adding the JLabel to the JPanel

        //declaration of JLabel label7
        label7 = new JLabel();
        label7.setText(" ");  //passing text to the text field
        label7.setBounds(110,370,200,40);  //set up the dimensions
        driverPanel.add(label7); //adding the JLabel to the JPanel

        //declaration of JButton btnEnt
        btnEnt = new JButton();
        btnEnt.setBounds(110,220,200,40);  //set up the dimensions
        btnEnt.setFocusable(false); //setting the text on the JButton to be not highlighted
        btnEnt.addActionListener(this); //adding the ActionListener
        btnEnt.setText("Enter");  //adding text to the JButton
        btnEnt.setBackground(Color.RED);  //changing the background color of the JButton
        btnEnt.setForeground(Color.white);  //changing the text color on the JButton
        btnEnt.setFont(new Font("Helvetica", Font.ITALIC,19));  //editing the text style on the JButton
        driverPanel.add(btnEnt); //adding the JButton to the JPanel

        //declaration of JButton btnClear
        btnClear = new JButton();
        btnClear.setBounds(110,270,200,40);  //set up the dimensions
        btnClear.setFocusable(false); //setting the text on the JButton to be not highlighted
        btnClear.addActionListener(this); //adding the ActionListener
        btnClear.setText("Clear"); //adding text to the JButton
        btnClear.setBackground(Color.YELLOW);  //changing the background color of the JButton
        btnClear.setForeground(Color.black);  //changing the text color on the JButton
        btnClear.setFont(new Font("Helvetica", Font.ITALIC,19)); //editing the text style on the JButton
        driverPanel.add(btnClear); //adding the JButton to the JPanel

        //declaration of JButton btnMenu1
        btnMenu1 = new JButton();
        btnMenu1.setBounds(110,320,200,40);  //set up the dimensions
        btnMenu1.setFocusable(false); //setting the text on the JButton to be not highlighted
        btnMenu1.addActionListener(this); //adding the ActionListener
        btnMenu1.setText("Menu"); //adding text to the JButton
        btnMenu1.setBackground(Color.lightGray); //changing the background color of the JButton
        btnMenu1.setForeground(Color.black);  //changing the text color on the JButton
        btnMenu1.setFont(new Font("Helvetica", Font.ITALIC,19)); //editing the text style on the JButton
        driverPanel.add(btnMenu1); //adding the JButton to the JPanel

        //declaration of JButton btnGenDate
        btnGenDate = new JButton();
        btnGenDate.setBounds(350,110,140,27);  //set up the dimensions
        btnGenDate.setFocusable(false); //setting the text on the JButton to be not highlighted
        btnGenDate.addActionListener(this);  //adding the ActionListener
        btnGenDate.setText("Generate Date");  //adding text to the JButton
        btnGenDate.setBackground(Color.cyan);  //changing the background color of the JButton
        btnGenDate.setForeground(Color.blue);  //changing the text color on the JButton
        btnGenDate.setFont(new Font("Helvetica", Font.PLAIN,13)); //editing the text style on the JButton
        driverPanel.add(btnGenDate); //adding the JButton to the JPanel

        //declaration of JButton btnGenPos
        btnGenPos = new JButton();
        btnGenPos.setBounds(350,140,140,27);  //set up the dimensions
        btnGenPos.setFocusable(false);  //setting the text on the JButton to be not highlighted
        btnGenPos.addActionListener(this); //adding the ActionListener
        btnGenPos.setText("Generate Position"); //adding text to the JButton
        btnGenPos.setBackground(Color.cyan); //changing the background color of the JButton
        btnGenPos.setForeground(Color.blue);  //changing the text color on the JButton
        btnGenPos.setFont(new Font("Helvetica", Font.PLAIN,13));  //editing the text style on the JButton
        driverPanel.add(btnGenPos); //adding the JButton to the JPanel

        //declaration of JButton btnGenPoints
        btnGenPoints = new JButton();
        btnGenPoints.setBounds(350,170,140,27);  //set up the dimensions
        btnGenPoints.setFocusable(false); //setting the text on the JButton to be not highlighted
        btnGenPoints.addActionListener(this); //adding the ActionListener
        btnGenPoints.setText("Generate Points"); //adding text to the JButton
        btnGenPoints.setBackground(Color.cyan); //changing the background color of the JButton
        btnGenPoints.setForeground(Color.blue); //changing the text color on the JButton
        btnGenPoints.setFont(new Font("Helvetica", Font.PLAIN,13)); //editing the text style on the JButton
        driverPanel.add(btnGenPoints); //adding the JButton to the JPanel

        //setting up the DriverFrame JFrame
        this.setTitle("Formula One Championship"); //set a title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this will exit out the application
        this.setSize(600,480); //sets x and y dimensions
        this.add(driverPanel);  //adding the JPanel to the JFrame
        ImageIcon myImage = new ImageIcon("src/logo.jpg"); //create an ImageIcon
        this.setIconImage(myImage.getImage()); //change icon of the frame
        this.setVisible(true); //make frame visible

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnEnt){
            String driveName = textField1.getText(); //getting the user input from the text field and assign it to a variable
            String driveLoc = textField2.getText();  //getting the user input from the text field and assign it to a variable
            String driveTeam = textField3.getText();  //getting the user input from the text field and assign it to a variable
            String driveDate = textField4.getText();  //getting the user input from the text field and assign it to a variable
            String drivePosition = textField5.getText();  //getting the user input from the text field and assign it to a variable
            String drivePoints = textField6.getText();  //getting the user input from the text field and assign it to a variable

            //adding the user input into an array
            try{
                for (int i=0; i<10; i++) {
                    if (Objects.isNull(driverArr[i])) {
                        driverArr[i] = new Formula1Driver(driveName, driveLoc, driveTeam, driveDate, drivePosition, Integer.parseInt(drivePoints));
                        label7.setText("Driver Successfully Added!");
                        break;
                    }
                }
            } catch (NumberFormatException n){    //handling the NumberFormatException
                label7.setText("Please Enter Valid Details.");
            } catch (NullPointerException k){    //handling the NullPointerException
                label7.setText("Sorry! All Tracks Are Full.");
            }
        }   else if(e.getSource()== btnMenu1){
            this.setVisible(false);  //setting the visibility to False
            MainFrame frame = new MainFrame();
            frame.setVisible(true);  //setting the visibility to True

        }    else if(e.getSource()== btnClear){
             textField1.setText(" ");  //setting text field values to an empty string
             textField2.setText(" ");  //setting text field values to an empty string
             textField3.setText(" ");  //setting text field values to an empty string
             textField4.setText(" ");  //setting text field values to an empty string
             textField5.setText(" ");  //setting text field values to an empty string
             textField6.setText(" ");  //setting text field values to an empty string
             label7.setText(" ");  //setting the label text to an empty string

        }    else if (e.getSource() == btnGenDate){
             GregorianCalendar gre = new GregorianCalendar();
             textField4.setText(gre.getTime().toString()); //generates time

        }    else if (e.getSource() == btnGenPos){
             Random rdm = new Random();
             int random = rdm.nextInt(10)+1;
             textField5.setText(Integer.toString(random)); //generate a random number between 1 to 10

        }    else if (e.getSource() == btnGenPoints){
             Random rdm = new Random();
             int randomPoint = rdm.nextInt(100)+1;
             textField6.setText(Integer.toString(randomPoint)); //generate a random number between 1 to 100
        }
    }
}
