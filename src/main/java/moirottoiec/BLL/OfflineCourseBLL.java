/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.BLL;

import java.util.Vector;
import moirottoiec.DAL.OfflineCourseDAL;
import moirottoiec.DTO.OfflineCourse;
/**
 *
 * @author minhv
 */
public class OfflineCourseBLL {
    OfflineCourseDAL offDAL;
    
    public OfflineCourseBLL(){
        offDAL = new OfflineCourseDAL();
    }
    
    
    public Vector<OfflineCourse> getAllOfflineCourse(){
        return offDAL.getAllOfflineCourse();
    }
    
    public OfflineCourse getOfflineCourseByID(int ID){
        return offDAL.getOfflineCourseByID(ID);
        
    }
    
    public Vector<OfflineCourse> findOfflineCourse(String tuKhoa){
        return offDAL.findOfflineCourse(tuKhoa);
    }
    
    public void addOfflineCourse(OfflineCourse offlineCourse){
        offDAL.addOfflineCourse(offlineCourse);
    }
    
    public void updateOfflineCourse(OfflineCourse offlineCourse){
        offDAL.updateOfflineCourse(offlineCourse);
    }
    
    public void deleteOfflineCourse(int courseID){
        offDAL.deleteOfflineCourse(courseID);
    }
}
