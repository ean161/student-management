package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in); // Receive data for keyboard
        ArrayList<Student> list = new ArrayList<>(
            Arrays.asList(
                new Student("00001", "Nguyen Van A", 3, 5),
                new Student("00002", "Nguyen Van B", 1, 2),
                new Student("00003", "Nguyen Hoai An", 9, 10)
            )
        ); // Student obj arr with input template
        double highestScore = 0; // Storage highest GPA
        String select = "",
            student = "",
            line = "+-----+-------+-------------------+------+-----+-----+\n";
        
        do {
            System.out.print(
                "----- STUDENT MANAGEMENT V1.0 -----\n"
                + "1. Adds new student.\n"
                + "2. Shows all students.\n"
                + "3. Quit.\n"
                + "Please select a function: "
            ); // Menu print
            
            select = keyboard.nextLine();
            switch(select){
                case "1":
                    while(true){
                        System.out.print(
                            "---- STUDENT MANAGEMENT V1.0 [ADD NEW STUDENT] ----\n"
                            + "Please enter Student Information: "
                        ); // Print header
                        
                        student = keyboard.nextLine();
                        if(student.equalsIgnoreCase("")){ // If input is null
                            System.out.println("--> You must enter data!");
                        } else { // If case except "quit"
                            String[] studentExplode = student.split("@"); // Explode elements from input by @
                            list.add(new Student(
                                studentExplode[0],
                                studentExplode[1],
                                Double.parseDouble(studentExplode[2]),
                                Double.parseDouble(studentExplode[3])
                            )); // Create obj from exploded data and add to list
                            System.out.println("--> Student created and added to list of student successful!");
                            break;
                        }
                    }
                    break;
                case "2":
                    System.out.print(
                        "----- STUDENT MANAGEMENT V1.0 [List of student] -----\n"
                        + "| No. | ID    | Student name      | Math | Lit | GPA |\n"
                        + line
                    ); // Table header print out
                    
                    int iItem = 0;
                    for(Student item : list){ // Foreach item in list
                        if(item.getGPA() > highestScore)
                            highestScore = item.getGPA(); // Get highest GPA score
                        System.out.printf(
                            "| %-4s| %-6s| %-18s| %-5s| %-4s| %-4s|\n"
                            + line,
                            ++iItem,
                            item.getID(),
                            item.getFullName(),
                            String.format("%.1f", item.getMath()),
                            String.format("%.1f", item.getLiterature()),
                            String.format("%.1f", item.getGPA())); // Print out getters as template
                    }
                    
                    System.out.println("The best student of this class is/are:");
                    iItem = 0;
                    for(Student item : list){
                        /*
                        Bellow logic:
                            We cant use item.getGPA() == highestScore cause avoid round number system:
                            If we use:
                                When highest score is 5.55 will display 5.5 and student
                                who score 5.54 will not display as a best student
                            So, we use string and format it for round and compare with other score that formtatted
                        */
                        if(String.format("%.1f", item.getGPA()).equalsIgnoreCase(String.format("%.1f", highestScore)))
                            System.out.println(
                                ++iItem + ". "
                                + item.getFullName()
                                + " (GPA: " + String.format("%.1f", item.getGPA()) + ")"
                            ); // Print out best students result
                    }
                    break;
                case "3":
                    System.out.println(
                        "THANK FOR USING OUR APPLICATION!\n"
                        + "SEE YOU AGAIN!"
                    );
                    break;
                default:
                    System.out.println("The function of application must be from 1 to 3!");
                    break;
            }
        } while(!select.equalsIgnoreCase("3")); // If input == "3" => break
    }
}
