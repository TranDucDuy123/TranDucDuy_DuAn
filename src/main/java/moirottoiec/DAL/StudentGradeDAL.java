/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moirottoiec.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moirottoiec.DTO.StudentGrade;

/**
 *
 * @author Duy
 */
public class StudentGradeDAL extends DatabaseManager{
    public StudentGradeDAL() {
        super();
        ConnectDB();
    }
    public List<StudentGrade> getALLStudentGrade(){
        List<StudentGrade> studentgs = new ArrayList <StudentGrade>();
        
        
        try {  
//            String sql = "select * from studentgrade";
            String sql = "SELECT studentgrade.*,person.Lastname,person.Firstname,course.Title FROM studentgrade "
                    + "JOIN person on person.PersonID = studentgrade.StudentID "
                    + "JOIN course on course.CourseID = studentgrade.CourseID" ;

            Connection conn =getConn();  
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                StudentGrade sg= new StudentGrade();
                
                sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                sg.setCourseID(rs.getInt("CourseID"));
                sg.setCoursTitle(rs.getString("Title"));
                sg.setStudentID(rs.getInt("StudentID"));
                sg.setFirstName(rs.getString("Firstname"));
                sg.setLastName(rs.getString("Lastname"));
                sg.setGrade(rs.getFloat("Grade"));
                
                studentgs.add(sg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentgs;
    }

   public List<StudentGrade> findStudentGrade(String keyword){
       List<StudentGrade> ls = new ArrayList<StudentGrade>();
        try {
            String sql = "SELECT *"
                    + "FROM studentgrade LEFT JOIN person on person.PersonID = studentgrade.StudentID "
                    + "LEFT JOIN course on course.CourseID = studentgrade.CourseID "
                    + "where Lastname like '%"+keyword+"%' or FirstName like '%"+keyword+"%' "
                    + "or Title like '%"+keyword+"%' or CONCAT(Firstname,' ',Lastname) like '%"+keyword+"%'";
            
            Connection conn =getConn();  
            PreparedStatement stmt=conn.prepareStatement(sql);
//            stmt.setString(1, keyword);
//            stmt.setString(2, keyword);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                StudentGrade sg= new StudentGrade();
                
                sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                sg.setCourseID(rs.getInt("CourseID"));
                sg.setStudentID(rs.getInt("StudentID"));
                sg.setCoursTitle(rs.getString("Title"));   
                sg.setFirstName(rs.getString("Firstname"));
                sg.setLastName(rs.getString("Lastname"));
                sg.setGrade(rs.getFloat("Grade"));
                
                ls.add(sg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGradeDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ls;
   }
}
