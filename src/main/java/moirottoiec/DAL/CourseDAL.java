/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import moirottoiec.DTO.Course;

/**
 *
 * @author minhv
 */
public class CourseDAL extends DatabaseManager {
    Course course;
    public CourseDAL(){
        super();
        ConnectDB();
        course = new Course();
    }
    
    public Vector<Course> getAllOnlineCourses(){
        ResultSet rs=null;
        Vector<Course> arr = new Vector<Course>();
        try {
            String sql = "SELECT CourseID FROM course";
            Connection conn = getConn();
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Course course = new Course();
                course.setCourseID(rs.getInt("CourseID"));
                arr.add(course); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
