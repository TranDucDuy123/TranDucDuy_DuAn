/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.BLL;

import java.util.Vector;
import moirottoiec.DAL.CourseDAL;
import moirottoiec.DTO.Course;

/**
 *
 * @author minhv
 */
public class CourseBLL {
    CourseDAL courseDAL;
    
    public CourseBLL(){
        courseDAL = new CourseDAL();
    }
    
    
    public Vector<Course> getAllCourses(){
        return courseDAL.getAllOnlineCourses();
    }
}
