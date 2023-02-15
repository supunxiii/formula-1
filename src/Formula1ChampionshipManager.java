import java.io.*;   //imports all the classes in io package
import java.util.*; //imports all the classes in util package
import java.lang.*; //imports all the classes in lang package

/** COPYRIGHT (C) 2021 Supun Wijesooriya. All Rights Reserved.
 * Implemented a class Formula1ChampionshipManager which extends interface
 * ChampionshipManager. The Formula1ChampionshipManager class maintains a number of
 * drivers who play in the Formula 1 championship. The class provides the user
 * options to manipulate the program.
 * Solves 5COSC019C.1 Object Oriented Programming Coursework Question #2
 * @author Supun Wijesooriya
 * @version 1.0 2021-12-15
 */

//declaration of interface ChampionshipManager
interface ChampionshipManager {
    public static void insertDrivers(){

    }

    public static void deleteDriver(){

    }
}


//declaration of Formula1Championship class which extends ChampionshipManager
public class Formula1ChampionshipManager implements ChampionshipManager  {
    public static Formula1Driver driverArr[] = new Formula1Driver[10];


    //the main method
    public static void main(String args[]) {
        showOptions();
        initiateOptions();

    }


    //this method will display the options provided by the program
    public static void showOptions(){
        System.out.println();
        System.out.println("Follow the Options.");
        System.out.println("1: Create a New Driver");
        System.out.println("2: Delete a Driver");
        System.out.println("3: Change a Driver");
        System.out.println("4: View the Points of a Driver");
        System.out.println("5: Display Driver Statistics");
        System.out.println("6: Store Program Data into File");
        System.out.println("7: Load Program Data from File");
        System.out.println("8: Sort Points in Ascending Order");
        System.out.println("9: Sort Points in Descending Order");
        System.out.println("10: Show Options Menu");
        System.out.println("0: To Exit");

    }



    //this method will initiate the relevant method according to the user input
    public static void initiateOptions(){
        Scanner userInput = new Scanner(System.in);
        String choice = userInput.nextLine();
        if ((choice.equals("1"))){
            insertDrivers();
        }
        else if ((choice.equals("2"))){
            deleteDriver();
        }
        else if ((choice.equals("3")) ) {
            changeDriver();
        }
        else if ((choice.equals("4"))) {
            viewPoints();
        }

        else if ((choice.equals("5"))) {
            displayDriver();
        }

        else if ((choice.equals("6"))) {
            storeData();
        }
        else if ((choice.equals("7"))) {
            loadData();
        }
        else if ((choice.equals("8"))) {
            sortAscPoints();
        }
        else if ((choice.equals("9"))) {
            sortDscPoints();
        }
        else if ((choice.equals("10"))) {
            showOptions();
            initiateOptions();
        }
        else if ((choice.equals("0"))) {
            System.exit(0);
        } else  {
            System.out.println("Invalid User Input.");
            showOptions();
            initiateOptions();
        }
    }


    //this method will insert drivers by prompting the user to input relevant details of the driver
    public static void insertDrivers(){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter Driver Name, Location, Team, Date & Position: ");
        String driveName = scannerObj.nextLine();
        String driveLocation = scannerObj.nextLine();
        String driveTeam = scannerObj.nextLine();
        String raceDate = scannerObj.nextLine();
        String racePosition = scannerObj.nextLine();
        Formula1Driver.addPositions();

        int j = 0;
        while(j < 10) {
            if (Objects.isNull(driverArr[j])) {
                driverArr[j] = new Formula1Driver(driveName, driveLocation, driveTeam, raceDate, racePosition, Formula1Driver.calPoints());
                showOptions();
                initiateOptions();
            }
            j++;
        }
        showOptions();
        initiateOptions();
    }


    //this method will delete the driver from the formula 1 championship alongside the details of the driver
    public static void deleteDriver(){
        Scanner userInput =  new Scanner(System.in);
        System.out.println("Enter the Driver You Want to Delete: ");
        String driverName = userInput.nextLine();
        for(int i=0; i < 10; i++){
            if(driverArr[i].name.equals(driverName)){
                System.out.println("Deletion Complete!");
                driverArr[i].name = null;
                driverArr[i].location = null;
                driverArr[i].team = null;
                driverArr[i].date = null;
                driverArr[i].position = null;
                driverArr[i].points = 0;
                showOptions();
                initiateOptions();
            }
        }
    }


    //this method will change the driver of a particular constructor team
    public static void changeDriver(){
        Scanner userInput =  new Scanner(System.in);
        System.out.println("Enter the name of the new Driver : ");
        String driverName = userInput.nextLine();
        System.out.println("Enter the team name : ");
        String teamName = userInput.nextLine();
        for(int i=0; i < 10; i++){
            if(driverArr[i].team.equals(teamName)){
                driverArr[i].name = driverName;
                showOptions();
                initiateOptions();
            }
        }
        System.out.println("Driver Cannot be Found!");
        showOptions();
        initiateOptions();
    }


    //this method will display the points of a particular driver
    public static void viewPoints(){
        try{
            Scanner userInput =  new Scanner(System.in);
            System.out.println("Enter the name of the Driver you want to see the points of: ");
            String driverName = userInput.nextLine();
            for(int i=0; i < 10; i++){
                if(driverArr[i].name.equals(driverName)){
                    System.out.println(driverArr[i].points);
                }
            }
            showOptions();
            initiateOptions();
        } catch (NullPointerException e){  //handling the NullPointerException
            System.err.println("Null Point Exception Found!");

        }

    }


    //this method will store data of the driver in the DriverDetails.txt file
    public static void storeData(){
        try{
            File driverFile = new File("DriverDetails.txt");
            PrintStream writer = new PrintStream(driverFile);

            int index = 0;
            while(index < driverArr.length){
                if (driverArr[index] != null){
                    writer.println(driverArr[index].name);
                    writer.println(driverArr[index].location);
                    writer.println(driverArr[index].team);
                    writer.println(driverArr[index].date);
                    writer.println(driverArr[index].position);
                    writer.println(driverArr[index].points);
                }
                index = index + 1;
            }
            writer.close();
            System.out.println("Driver details successfully added to the file!");
        }
        catch (FileNotFoundException fnf){   //handling the FileNotFoundException
            System.err.println("Sorry! File not found.");
        }
        showOptions();
        initiateOptions();
    }


    //this method will load driver details stored in DriverDetails.txt file
    public static void loadData(){
        try{
            File driverFile = new File("DriverDetails.txt");
            Scanner fileReader = new Scanner(driverFile);
            String name, location, team, date, position, points;
            int index = 0;
            while (fileReader.hasNext()){
                name = fileReader.nextLine();
                location = fileReader.nextLine();
                team = fileReader.nextLine();
                date = fileReader.nextLine();
                position = fileReader.nextLine();
                points = fileReader.nextLine();

                System.out.println("Driver's Name: "+ name + " Location: "+ location + " Team: "+ team + " Date: "+ date + " Position: "+ position + " Total Points: "+ Integer.parseInt(points));
                index = index + 1;
            }
            fileReader.close();
        }
        catch (FileNotFoundException fnf){
            System.err.println("Sorry! The file wasn't found.");
        }
        showOptions();
        initiateOptions();
    }


    //this method will display the statistics of the driver
    public static void displayDriver(){
        try{
            System.out.println("Statistics of All Drivers: ");
            for(int i=0; i < 10; i++){
                System.out.println("Driver " + i + " Statistics: " + " (" + driverArr[i].name + ", " + driverArr[i].location + ", " + driverArr[i].team + ", " + driverArr[i].date  + ", " +  driverArr[i].position + ", " + driverArr[i].points + ")");
            }
            showOptions();
            initiateOptions();

        }
        catch (NullPointerException e){  //handling the NullPointerException
            System.err.println("Done!");
        }  catch (ArrayIndexOutOfBoundsException a){  //handling the ArrayIndexOutOfBoundsException
            System.err.println("Done!");
        }
    }

    //method to sort Driver details according ascending order of points
    public static void sortAscPoints(){
        System.out.println("Some Statistics of the Drivers (Name, Team, Points)");
        for(Formula1Driver s:driverArr){
            System.out.println("Name: " + s.name + " " + "Team: "+ s.team + " " + "Points: " + s.points);

        }
        System.out.println();
        //Sorting the array in natural order
        Arrays.sort(driverArr);
        System.out.println("Sorted in Ascending Order");
        for(Formula1Driver s:driverArr){
            System.out.println("Name: " + s.name + " " + "Team: "+ s.team + " " + "Points: " + s.points);
        }
        showOptions();
        initiateOptions();
    }

    //method to sort Driver details according descending order of points
    public static void sortDscPoints(){
        System.out.println("Some Statistics of the Drivers (Name, Team, Points)");
        for(Formula1Driver s:driverArr){
            System.out.println("Name: " + s.name + " " + "Team: "+ s.team + " " + "Points: " + s.points);

        }
        System.out.println();
        //Sorting the array in descending order
        Arrays.sort(driverArr, Collections.reverseOrder());
        System.out.println("Sorted in Descending Order");
        for(Formula1Driver s:driverArr){
            System.out.println("Name: " + s.name + " " + "Team: "+ s.team + " " + "Points: " + s.points);
        }
        showOptions();
        initiateOptions();
    }

}
