import javax.swing.*;                 //imports all the swing components
import java.awt.event.ActionEvent;    //imports the ActionEvent class
import java.awt.event.ActionListener; //imports the ActionListener interface
import java.awt.*;                    //imports all the classes in the awt package

/** COPYRIGHT (C) 2021 Supun Wijesooriya. All Rights Reserved.
 * SearchFrame which is a JFrame to choose the options how to view the Driver details.
 * Solves 5COSC019C.1 Object Oriented Programming Coursework Question #3
 * @author Supun Wijesooriya
 * @version 1.0 2021-12-15
 */

//Extending the SearchFrame class with JFrame, so it inherits the features of a JFrame
public class SearchFrame extends JFrame implements  ActionListener{

    //making the swing component (JLabel) global, defining it outside the constructor
    private static JLabel labelSearch;

    //making the swing components (JButtons) global, defining it outside the constructor
    private static JButton btnSearch;
    private static JButton btnViewAll;
    private static JButton btnBacktoMenu;

    //making the swing component (JTextField) global, defining it outside the constructor
    private static JTextField textFieldSearch;

    //constructor
    SearchFrame(){

        //creating a new JPanel to be placed on the JFrame
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(null);

        //declaration of JLabel labelSearch
        labelSearch = new JLabel();
        labelSearch.setText("Enter the Driver Name to View Statistics."); //set a title
        labelSearch.setBounds(170,20,400,60);  //set up the dimensions
        searchPanel.add(labelSearch);  //adding the JLabel to the JPanel

        //declaration of JTextField textFieldSearch
        textFieldSearch = new JTextField("Driver_Name");  //passing text to the text field
        textFieldSearch.setBounds(110,160,350,40);  //set up the dimensions
        textFieldSearch.setBackground(Color.WHITE); //changing the background color of the JTextField
        searchPanel.add(textFieldSearch);  //adding the JLabel to the JPanel

        //declaration of JButton btnSearch
        btnSearch = new JButton();
        btnSearch.setBounds(180,220,200,40);  //set up the dimensions
        btnSearch.setFocusable(false);   //setting the text on the JButton to be not highlighted
        btnSearch.addActionListener(this);  //adding the ActionListener
        btnSearch.setText("Search");  //adding text to the JButton
        ImageIcon searchIcon = new ImageIcon("src/search_icon.png");  //create an ImageIcon
        Image img = searchIcon.getImage();
        Image imgScale = img.getScaledInstance(40,40, Image.SCALE_SMOOTH); //scaling the image icon
        ImageIcon scaledIcon = new ImageIcon(imgScale);  //passing the scaled image icon to the ImageIcon
        btnSearch.setIcon(scaledIcon);  //setting the ImageIcon
        btnSearch.setBackground(Color.cyan);  //changing the background color of the JButton
        btnSearch.setForeground(Color.blue);  //changing the text color on the JButton
        btnSearch.setFont(new Font( "Helvetica", Font.BOLD,20));  //editing the text style on the JButton
        searchPanel.add(btnSearch);  //adding the JButton to the JPanel

        //declaration of JButton btnViewAll
        btnViewAll = new JButton();
        btnViewAll.setBounds(180,290,200,40); //set up the dimensions
        btnViewAll.setFocusable(false);  //setting the text on the JButton to be not highlighted
        btnViewAll.addActionListener(this);  //adding the ActionListener
        btnViewAll.setText("View All");  //adding text to the JButton
        btnViewAll.setBackground(Color.cyan);  //changing the background color of the JButton
        btnViewAll.setForeground(Color.blue);  //changing the text color on the JButton
        btnViewAll.setFont(new Font( "Helvetica", Font.BOLD,20));  //editing the text style on the JButton
        searchPanel.add(btnViewAll);  //adding the JButton to the JPanel

        //declaration of JButton btnBacktoMenu
        btnBacktoMenu = new JButton();
        btnBacktoMenu.setBounds(180,360,200,40); //set up the dimensions
        btnBacktoMenu.setFocusable(false);  //setting the text on the JButton to be not highlighted
        btnBacktoMenu.addActionListener(this);  //adding the ActionListener
        btnBacktoMenu.setText("Menu");  //adding text to the JButton
        btnBacktoMenu.setBackground(Color.cyan); //changing the background color of the JButton
        btnBacktoMenu.setForeground(Color.blue); //changing the text color on the JButton
        btnBacktoMenu.setFont(new Font( "Helvetica", Font.BOLD,20));  //editing the text style on the JButton
        searchPanel.add(btnBacktoMenu);  //adding the JButton to the JPanel

        //setting up the SearchFrame JFrame
        this.setTitle("Formula One Championship"); //set a title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this will exit out the application
        this.setSize(600,480); //sets x and y dimensions
        this.add(searchPanel); //adding the JPanel to the JFrame
        ImageIcon myImage = new ImageIcon("src/logo.jpg"); //create an ImageIcon
        this.setIconImage(myImage.getImage()); //change icon of the frame
        this.setVisible(true); //make frame visible
    }




    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnViewAll){

            this.setVisible(false);
            TableFrame tbFrame = new TableFrame();
            tbFrame.setVisible(true);



        } else if (e.getSource()==btnSearch){
            String name = textFieldSearch.getText();

            //declaration of JButton menuButton
            JButton menuButton;
            menuButton = new JButton();
            menuButton.setBounds(200,400,200,40); //set up the dimensions
            menuButton.setFocusable(false);  //setting the text on the JButton to be not highlighted
            menuButton.addActionListener(this);  //adding the ActionListener
            menuButton.setText("Menu");  //adding text to the JButton
            menuButton.setBackground(Color.lightGray);  //changing the background color of the JButton
            menuButton.setForeground(Color.black);  //changing the text color on the JButton
            menuButton.setFont(new Font("Helvetica", Font.ITALIC,19)); //editing the text style on the JButton
            this.add(menuButton); //adding the JButton to the JPanel

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
            this.setSize(600,480);  //sets x and y dimensions
            ImageIcon myImage = new ImageIcon("src/logo.jpg"); //create an ImageIcon
            this.setIconImage(myImage.getImage()); //change icon of the frame

        } else if (e.getSource()==btnBacktoMenu){
            this.setVisible(false); //setting the visibility to False
            MainFrame frame = new MainFrame();
            frame.setVisible(true);  //setting the visibility to True
        }
    }
}


