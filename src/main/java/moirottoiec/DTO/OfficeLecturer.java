/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.DTO;

import java.sql.Timestamp;


/**
 *
 * @author Duy
 */
public class OfficeLecturer {
    private int PersonID;
    private String FirstName;
    private String LastName;
    private int CourseID;
    private String Course;
    private String Location = null ;
    private String Url = null ;
    private String Days;
    private Timestamp Time;
    public OfficeLecturer(){
        
    }
    
    public OfficeLecturer(int id, String location ,Timestamp time){
        this.PersonID = id;
        this.Location = location;
        this.Time = time;   
    }
  

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int InstructorID) {
        this.PersonID = InstructorID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FistName) {
        this.FirstName = FistName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp Time) {
        this.Time = Time;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }
    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    
}
