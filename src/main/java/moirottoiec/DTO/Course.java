/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.DTO;

/**
 *
 * @author Admin
 */
public class Course {
    private  String Title ;
    private int CourseID;

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public String getTitle() {
        return Title;
    }

    public int getCourseID() {
        return CourseID;
    }
}
