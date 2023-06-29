/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moirottoiec.DTO;

/**
 *
 * @author Duy
 */
public class StudentGrade {
    private int EnrollmentID; 
    private int CourseID;
    private int StudentID;
    private String CoursTitle;
    private String LastName;
    private String FirstName;
    private float Grade;

    public StudentGrade(int EnrollmentID, int CourseID, int StudentID, String CoursTitle, String LastName, String FirstName, float Grade) {
        this.EnrollmentID = EnrollmentID;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.CoursTitle = CoursTitle;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Grade = Grade;
    }

    
    
    
    public StudentGrade(){
        
    }

    

    

    public int getEnrollmentID() {
        return EnrollmentID;
    }

    public void setEnrollmentID(int EnrollmentID) {
        this.EnrollmentID = EnrollmentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }


    public float getGrade() {
        return Grade;
    }

    public void setGrade(float Grade) {
        this.Grade = Grade;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getCoursTitle() {
        return CoursTitle;
    }

    public void setCoursTitle(String CoursTitle) {
        this.CoursTitle = CoursTitle;
    }

    

    public String getFullName() {
        return FirstName + " " +LastName; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
