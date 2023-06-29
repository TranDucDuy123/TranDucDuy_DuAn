/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.DTO;

import java.sql.Date;


/**
 *
 * @author minhv
 */
public class OfflineCourse {
    private int CourseID;
    private String Location;
    private String Days;
    private Date Time;
    

    public OfflineCourse() {
    }

    public OfflineCourse(int CourseID, String Location, String Days, Date Time) {
        this.CourseID = CourseID;
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    public int getCourseID() {
        return CourseID;
    }

    public String getLocation() {
        return Location;
    }

    public String getDays() {
        return Days;
    }

    public Date getTime() {
        return Time;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public void setTime(Date Time) {
        this.Time = Time;
    }
    
    
}
