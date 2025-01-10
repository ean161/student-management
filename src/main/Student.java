package main;


/**
 *
 * @author Nguyen Hoai An - CE190990
 */
public class Student {
    // Declare vars
    private String ID;
    private String fullName;
    private double math;
    private double literature;
    
    Student(String ID, String fullName, double math, double literature){
        this.ID = ID;
        this.fullName = fullName;
        this.math = math;
        this.literature = literature;
    }
    
    // Getters:
    
    public String getID(){
        return this.ID;
    }
    
    public String getFullName(){
        return this.fullName;
    }
    
    public double getMath(){
        return this.math;
    }
    
    public double getLiterature(){
        return this.literature;
    }
    
    public double getGPA(){
        return (this.math + this.literature) / 2;
    }
    
    // Setters:
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    public void setMath(double math){
        this.math = math;
    }
    
    public void setLiterature(double literature){
        this.literature = literature;
    }
}
