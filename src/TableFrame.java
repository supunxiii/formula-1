import javax.swing.*;                   //imports all the swing components
import java.awt.event.ActionEvent;      //imports the ActionEvent class
import java.awt.event.ActionListener;   //imports the ActionListener interface
import java.awt.*;                      //imports all the classes in the awt package

/** COPYRIGHT (C) 2021 Supun Wijesooriya. All Rights Reserved.
 * TableFrame which is a JFrame to house the Driver details JTable.
 * Solves 5COSC019C.1 Object Oriented Programming Coursework Question #3
 * @author Supun Wijesooriya
 * @version 1.0 2021-12-15
 */


//Extending the MainFrame class with JFrame, so it inherits the features of a JFrame
public class TableFrame extends JFrame implements ActionListener{

    //making the swing component (JButton) global, defining it outside the constructor
    public static JButton menuButton;

    //constructor
    TableFrame(){

        //declaration of JButton menuButton
        menuButton = new JButton();
        menuButton.setBounds(200,400,200,40); //set up the dimensions
        menuButton.setFocusable(false);  //setting the text on the JButton to be not highlighted
        menuButton.addActionListener(this);  //adding the ActionListener
        menuButton.setText("Menu");   //adding text to the JButton
        menuButton.setBackground(Color.lightGray);  //changing the background color of the JButton
        menuButton.setForeground(Color.black);   //changing the text color on the JButton
        menuButton.setFont(new Font("Helvetica", Font.ITALIC,19));  //editing the text style on the JButton
        this.add(menuButton);  //adding the JButton to the JPanel

        //converting the driverArr Array into a 2D Array
        DriverFrame df = new DriverFrame();
        String[][] driverTdArray = new String[10][6];
        for (int i = 0; i < 10; i++){
                driverTdArray [i][0] = df.driverArr[i].name;
                driverTdArray [i][1] = df.driverArr[i].location;
                driverTdArray [i][2] = df.driverArr[i].team;
                driverTdArray [i][3] = df.driverArr[i].date;
                driverTdArray [i][4] = df.driverArr[i].position;
                driverTdArray [i][5] = String.valueOf(df.driverArr[i].points);

        }

        //declaration of the table
        String column[]={"NAME", "LOCATION", "TEAM", "DATE", "POSITION", "POINTS"};
        df.setVisible(false);
        JTable drivTable =new JTable( driverTdArray, column);
        drivTable.setBounds(30,40,600,440);
        JScrollPane tableScrollPane =new JScrollPane(drivTable);
        this.add(tableScrollPane);

        //setting up the TableFrame JFrame
        this.setTitle("Formula One Championship");  //set a title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //this will exit out the application
        this.setSize(600,480); //sets x and y dimensions
        ImageIcon myImage = new ImageIcon("src/logo.jpg"); //create an ImageIcon
        this.setIconImage(myImage.getImage());  //change icon of the frame

    }



    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==menuButton){
            MainFrame mnFrame = new MainFrame();
            setVisible(false); //setting this windows visibility to False
            mnFrame.setVisible(true);  //setting MainFrame object's visibility to True
        }
    }
}