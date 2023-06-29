/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.BLL;
import java.util.ArrayList;
import java.util.List;
import moirottoiec.DAL.OfficeLecturerDAL;
import moirottoiec.DTO.Course;
import moirottoiec.DTO.Lecturer;
import moirottoiec.DTO.OfficeLecturer;
/**
 *
 * @author Duy
 */
public class OfficeLecturerBLL {
    private OfficeLecturerDAL officeDAL;
    private OfficeLecturer officeDTO;
    public OfficeLecturerBLL(){
        officeDAL = new OfficeLecturerDAL();
    }
// List Lecturer Empty
    public List<Lecturer> getAllLecturerEmpty(){
        return officeDAL.getAllLecturerEmpty();
    }
// List Corse Empty
    public List<Course> getAllCourseEmpty(){
        return officeDAL.getAllCourseEmpty();
    }
// List OnsiteCourse
    public List<OfficeLecturer> getAllOnsiteCourse(){
        return officeDAL.getAllOnsiteCourse();
    }
// List OnlineCourse
    public List<OfficeLecturer> getAllOnlineCourse(){
        return officeDAL.getAllOnlineCourse();
    }
    public void addOfficeLecturer(OfficeLecturer obj){
        officeDAL.addOfficeLecturer(obj);
    }
    public void deleteOfficeLecturer(int idCourse){
        officeDAL.deleteOfficeLecturer(idCourse);
    }
}