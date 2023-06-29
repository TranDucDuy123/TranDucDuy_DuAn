/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.DTO;

/**
 *
 * @author minhv
 */
public class OnlineCourse {
    private int CourseID;
    private String URL;

    public OnlineCourse(int CourseID, String URL) {
        this.CourseID = CourseID;
        this.URL = URL;
    }

    public OnlineCourse() {
    }

    public int getCourseID() {
        return CourseID;
    }

    public String getURL() {
        return URL;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
