import javax.swing.*;                   //imports all the swing components
import java.awt.event.ActionEvent;      //imports the ActionEvent class
import java.awt.event.ActionListener;   //imports the ActionListener interface
import java.awt.*;                      //imports all the classes in the awt package

/** COPYRIGHT (C) 2021 Supun Wijesooriya. All Rights Reserved.
 * MainFrame which is a JFrame to house all the components in the main window.
 * Solves 5COSC019C.1 Object Oriented Programming Coursework Question #3
 * @author Supun Wijesooriya
 * @version 1.0 2021-12-15
 */


//Extending the MainFrame class with JFrame, so it inherits the features of a JFrame
public class MainFrame extends JFrame implements  ActionListener {

    //making the swing component (JLabel) global, defining it outside the constructor
    private static JLabel labelWelcome;

    //making the swing components (JButtons) global, defining it outside the constructor
    private static JButton btnEntDriver;
    private static JButton btnDisplayDriver;
    private static JButton btnSortPoints;
    private static JButton btnSortDate;

    //constructor
    MainFrame(){

        //creating a new JPanel to be placed on the JFrame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        //declaration of JLabel labelWelcome
        labelWelcome = new JLabel();
        labelWelcome.setText("Welcome To Championship Manager Program!");  //set a title
        labelWelcome.setBounds(150,20,400,60);   //set up the dimensions
        mainPanel.add(labelWelcome);   //adding the JLabel to the JPanel

        //declaration of JButton btnEntDriver
        btnEntDriver = new JButton();
        btnEntDriver.setBounds(180,100,200,40);  //set up the dimensions
        btnEntDriver.setFocusable(false);  //setting the text on the JButton to be not highlighted
        btnEntDriver.addActionListener(this);  //adding the ActionListener
        btnEntDriver.setText("Enter Driver");  //adding text to the JButton
        btnEntDriver.setBackground(Color.cyan);  //changing the background color of the JButton
        btnEntDriver.setForeground(Color.blue);  //changing the text color on the JButton
        btnEntDriver.setFont(new Font( "Helvetica", Font.BOLD,27));  //editing the text style on the JButton
        mainPanel.add(btnEntDriver);   //adding the JButton to the JPanel

        //declaration of JButton btnDisplayDriver
        btnDisplayDriver = new JButton();
        btnDisplayDriver.setBounds(110,160,350,40);   //set up the dimensions
        btnDisplayDriver.setFocusable(false);   //setting the text on the JButton to be not highlighted
        btnDisplayDriver.addActionListener(this);   //adding the ActionListener
        btnDisplayDriver.setText("Display Driver Details");  //adding text to the JButton
        btnDisplayDriver.setBackground(Color.cyan);  //changing the background color of the JButton
        btnDisplayDriver.setForeground(Color.blue);  //changing the text color on the JButton
        btnDisplayDriver.setFont(new Font( "Helvetica", Font.BOLD,27));   //editing the text style on the JButton
        mainPanel.add(btnDisplayDriver);  //adding the JButton to the JPanel

        //declaration of JButton btnSortPoints
        btnSortPoints = new JButton();
        btnSortPoints.setBounds(100,220,370,40);  //set up the dimensions
        btnSortPoints.setFocusable(false);   //setting the text on the JButton to be not highlighted
        btnSortPoints.addActionListener(this);  //adding the ActionListener
        btnSortPoints.setText("Sort According to Points");  //adding text to the JButton
        btnSortPoints.setBackground(Color.cyan);   //changing the background color of the JButton
        btnSortPoints.setForeground(Color.blue);   //changing the text color on the JButton
        btnSortPoints.setFont(new Font( "Helvetica", Font.BOLD,27));  //editing the text style on the JButton
        mainPanel.add(btnSortPoints);  //adding the JButton to the JPanel

        //declaration of JButton btnSortDate
        btnSortDate = new JButton();
        btnSortDate.setBounds(100,280,370,40);  //set up the dimensions
        btnSortDate.setFocusable(false);  //setting the text on the JButton to be not highlighted
        btnSortDate.addActionListener(this);   //adding the ActionListener
        btnSortDate.setText("Sort According to Date");  //adding text to the JButton
        btnSortDate.setBackground(Color.cyan);    //changing the background color of the JButton
        btnSortDate.setForeground(Color.blue);    //changing the text color on the JButton
        btnSortDate.setFont(new Font( "Helvetica", Font.BOLD,27));   //editing the text style on the JButton
        mainPanel.add(btnSortDate);   //adding the JButton to the JPanel

        //setting up the MainFrame JFrame
        this.setTitle("Formula One Championship"); //set a title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this will exit out the application
        this.setSize(600,480); //sets x and y dimensions
        this.add(mainPanel);  //adding the JPanel to the JFrame
        ImageIcon myImage = new ImageIcon("src/logo.jpg"); //create an ImageIcon
        this.setIconImage(myImage.getImage()); //change icon of the frame
        this.setVisible(true); //make frame visible
    }




    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnEntDriver){
            //creating an object from the DriverFrame
            DriverFrame drFrame = new DriverFrame();
            drFrame.setVisible(true);  //setting the visibility to True
            this.setVisible(false);    //setting the visibility to False

        }
        else if (e.getSource()== btnDisplayDriver){
            //creating an object from the SearchFrame
            SearchFrame searchFrame = new SearchFrame();
            searchFrame.setVisible(true); //setting the visibility to True
            this.setVisible(false);       //setting the visibility to False
        }
    }
}