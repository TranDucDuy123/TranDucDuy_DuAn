/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.BLL;

import java.util.Vector;
import moirottoiec.DAL.OfflineCourseDAL;
import moirottoiec.DAL.OnlineCourseDAL;
import moirottoiec.DTO.OfflineCourse;
import moirottoiec.DTO.OnlineCourse;

/**
 *
 * @author minhv
 */
public class OnlineCourseBLL {
    OnlineCourseDAL onlDAL;
    
    public OnlineCourseBLL(){
        onlDAL = new OnlineCourseDAL();
    }
    
    
    public Vector<OnlineCourse> getAllOnlineCourses(){
        return onlDAL.getAllOnlineCourses();
    }
    
    public OnlineCourse getOfflineCourseByID(int ID){
        return onlDAL.getOnlineCourseByID(ID);
        
    }
    
    public Vector<OnlineCourse> findOnlineCourses(String tuKhoa){
        return onlDAL.findOnlineCourses(tuKhoa);
    }
    
    public void addOnlineCourse(OnlineCourse onlineCourse){
        onlDAL.addOnlineCourse(onlineCourse);
    }
    
    public void updateOnlineCourse(OnlineCourse onlineCourse){
        onlDAL.updateOnlineCourse(onlineCourse);
    }
    
    public void deleteOnlineCourse(int courseID){
        onlDAL.deleteOnlineCourse(courseID);
    }
}
