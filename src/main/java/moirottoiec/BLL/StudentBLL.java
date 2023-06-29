/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moirottoiec.BLL;

import java.util.Vector;
import moirottoiec.DAL.StudentDAL;
import moirottoiec.DTO.Lecturer;
import moirottoiec.DTO.Student;

/**
 *
 * @author Binh PC
 */
public class StudentBLL {
    StudentDAL stuDAL;
    public StudentBLL(){
        stuDAL = new StudentDAL();
    }
     public Vector<Student> getAllStudent(){
        return stuDAL.getAllStudent();
    }
    
    public Student getStudentByID(int ID){
        return stuDAL.getStudentByID(ID);
        
    }
    
    public Vector<Student> findStudent(String tuKhoa){
        return stuDAL.findStudent(tuKhoa);
    }
    
    public void addStudent(Student student){
        stuDAL.addStudent(student);
    }
    
    public void updateStudent(Student student){
        stuDAL.updateStudent(student);
    }
    
    public void deleteStudent(int personID){
        stuDAL.deleteStudent(personID);
    }
}
