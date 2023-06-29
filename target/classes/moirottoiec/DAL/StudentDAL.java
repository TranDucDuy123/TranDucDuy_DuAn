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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import moirottoiec.DTO.Student;


/**
 *
 * @author Binh PC
 */
public class StudentDAL extends DatabaseManager{
    Student student;
    public StudentDAL(){
        super();
        ConnectDB();
        student = new Student();
    }
    
    public Vector<Student> getAllStudent(){
        ResultSet rs=null;
        Vector<Student> arr = new Vector<Student>();
        try {
            String sql = "SELECT * FROM person WHERE EnrollmentDate > 0";
            Connection conn = getConn();
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Student stu = new Student();
                stu.setPersonID(rs.getInt("PersonID"));
                stu.setLastName(rs.getString("LastName"));
                stu.setFirstName(rs.getString("FirstName"));
                stu.setEnrollmentDate(rs.getDate("EnrollmentDate")); 
                arr.add(stu); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public Student getStudentByID(int ID){
        String sql = "SELECT * FROM person WHERE PersonID = ?";
        
        try {
            Connection conn = getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Student stu = new Student();
                stu.setPersonID(rs.getInt("PersonID"));
                stu.setLastName(rs.getString("LastName"));
                stu.setFirstName(rs.getString("FirstName"));
                stu.setEnrollmentDate(rs.getDate("EnrollmentDate")); 
                return stu;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Vector<Student> findStudent(String tuKhoa){
        ResultSet rs = null;
        Statement st = null;
        Vector<Student> arr = new Vector<Student>();  
        try {
            //String sql = "SELECT * FROM person WHERE LastName like '%"+tuKhoa+"%'  OR FirstName like '%"+tuKhoa+"%' AND IN (SELECT * FROM person WHERE HireDate > 0)";
            String sql = "SELECT * FROM person WHERE EnrollmentDate > 0  AND (LastName like '%"+tuKhoa+"%'  OR FirstName like '%"+tuKhoa+"%') ";
            Connection conn = getConn();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Student stu = new Student();
                stu.setPersonID(rs.getInt(1));
                stu.setLastName(rs.getString(2));
                stu.setFirstName(rs.getString(3));
                stu.setEnrollmentDate(rs.getDate(4)); 
                arr.add(stu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public int addStudent (Student student){
        String sql = "INSERT INTO person(LastName, FirstName, EnrollmentDate) VALUES(?, ?, ?)";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, student.getLastName());
            st.setString(2, student.getFirstName());
            st.setDate(3, student.getEnrollmentDate());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int updateStudent (Student student){
        String sql = "UPDATE person SET LastName = ?, FirstName = ?, EnrollmentDate = ? WHERE personID = ?";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, student.getLastName());
            st.setString(2, student.getFirstName());
            st.setDate(3, student.getEnrollmentDate());
            st.setInt(4, student.getPersonID());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    public int deleteStudent (int personID){
        String sql = "DELETE FROM person WHERE PersonID = ?";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, personID);
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    
}
