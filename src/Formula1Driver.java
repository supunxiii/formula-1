import java.util.Scanner; //importing the Scanner class

/** COPYRIGHT (C) 2021 Supun Wijesooriya. All Rights Reserved.
 * Designed and implemented classes abstract class Driver and Formula1Driver to include
 * appropriate methods and hold information about the name of the driver, their
 * location, the team they belong to and various statistics about the drivers.
 * Solves 5COSC019C.1 Object Oriented Programming Coursework Question #1
 * @author Supun Wijesooriya
 * @version 1.0 2021-12-15
 */

//declaration of the abstract class Driver
abstract class Driver {
    String name;
    String location;
    String team;
    String date;
    String position;
    int points;

    //parameterized constructor
    public Driver(String name, String location, String team, String date, String position, int points){
        setValues(name, location, team, date, position, points);
    }



    public void setValues(String name, String location, String team, String date, String position, int points){
        setName(name);
        setLocation(location);
        setTeam(team);
        setDate(date);
        setPosition(position);
        setPoints(points);
    }


    //All the getters
    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public String getTeam(){
        return team;
    }

    public String getDate() {
        return date;
    }

    public String getPosition() {
        return position;
    }

    public int getPoints (){
        return points;
    }


    //All the setters
    public void setName(String name){
        this.name = name;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setTeam(String team){
        this.team = team;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setPoints(int points){
        this.points = points;
    }


    public int compareTo(Formula1Driver o){
        return this.points - o.points;
    }




    //this method will display the data of the driver
    public void displayData(){
        System.out.println("Driver Name: "+ name);
        System.out.println("Driver Location: "+ location);
        System.out.println("Driver Team: "+ team);
        System.out.println("Race Date: "+ date);
        System.out.println("Race Position: "+ position);
        System.out.println("Points: "+ points);
    }
}

//declaration of Formula1Driver class which extends the abstract class Driver
public class Formula1Driver extends Driver implements Comparable<Formula1Driver>{

    //parameterized constructor
    public Formula1Driver(String name, String location, String team, String date, String position, int points){
        super(name, location, team, date, position, points);
    }

    public static int positionArr[] = new int[10];     //declaration of global position array

    //this method will add the particular number of each position achieved by the driver
    public static void addPositions(){
        Scanner userInput =  new Scanner(System.in);
        for(int i=0; i < positionArr.length; i++){
            int q = i + 1;
            System.out.println("Enter number of " + q + " positions achieved by the Driver: ");
            int positionNum = userInput.nextInt();
            positionArr[i] = positionNum;
        }

    }

    //this method will calculate the total points from multiplying each number of positions by the relevant point allocated to the position
    public static int calPoints(){
        int Total = 0;
        int pointArr[] = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        for (int i=0; i < positionArr.length; i++){
            int q = i + 1;
            Total = Total + positionArr[i] * pointArr[i];
        }
        return Total;
    }

    //this method will prompt the user to input driver details
    public static void main(String[] args){
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter Driver Name, Location, Team, Date & Position: ");
        String driveName = scannerObj.nextLine();
        String driveLocation = scannerObj.nextLine();
        String driveTeam = scannerObj.nextLine();
        String raceDate = scannerObj.nextLine();
        String racePosition = scannerObj.nextLine();
        int racePoints = calPoints();
        new Formula1Driver(driveName, driveLocation, driveTeam, raceDate, racePosition, racePoints);
        addPositions();
        System.out.println(calPoints());
    }
}