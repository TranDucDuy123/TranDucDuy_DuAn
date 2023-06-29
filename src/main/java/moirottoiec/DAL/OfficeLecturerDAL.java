 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import moirottoiec.DTO.Course;
import moirottoiec.DTO.Lecturer;
import moirottoiec.DTO.OfficeLecturer;



/**
 *
 * @author Duy
 */
public class OfficeLecturerDAL extends DatabaseManager{
    String sqlEmptyLecturer ="SELECT person.PersonID,person.Lastname,person.Firstname FROM person "
            + "WHERE person.PersonID NOT IN (SELECT person.PersonID FROM person,courseinstructor WHERE person.PersonID = courseinstructor.PersonID)";
    String sqlEmptyCourse = "SELECT CourseID,Title FROM course WHERE CourseID NOT IN "
                         +"(SELECT course.CourseID FROM course, courseinstructor WHERE course.CourseID = courseinstructor.CourseID)";
    String sqlOnsiteCourse = "SELECT person.PersonID,person.Lastname,person.Firstname,course.Title,onsitecourse.Location,onsitecourse.Days, onsitecourse.Time FROM courseinstructor "
                    + "JOIN course ON course.CourseID = courseinstructor.CourseID "
                    + "JOIN person ON person.PersonID = courseinstructor.PersonID "
                    + "JOIN onsitecourse ON onsitecourse.CourseID = courseinstructor.CourseID ";
    
    String sqlOnlineCourse = "SELECT person.PersonID,person.Lastname,person.Firstname,course.Title,onlinecourse.url FROM courseinstructor "
                    + "JOIN course ON course.CourseID = courseinstructor.CourseID "
                    + "JOIN person ON person.PersonID = courseinstructor.PersonID "
                    + "JOIN onlinecourse ON onlinecourse.CourseID = courseinstructor.CourseID ";
    String sqlOffcieLecturer ="INSERT INTO courseinstructor (CourseID, PersonID) VALUES ('3141', '2');";
    public List<OfficeLecturer> onlinelist ;
    public List<OfficeLecturer> onsitelist ;
    public List<Lecturer> instructorlist;
    public List<Course> courselist;
    public OfficeLecturerDAL(){
        super();
        ConnectDB();
    }

// List Instructor (List<String>)
    public List<Lecturer> getAllLecturerEmpty (){
        instructorlist = new ArrayList<Lecturer>();
        try { 
            Connection conn =getConn();  
            PreparedStatement stmt=conn.prepareStatement(sqlEmptyLecturer);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
               Lecturer l = new Lecturer();
               l.setPersonID(rs.getInt("PersonID"));
               l.setLastName(rs.getString("Lastname"));
               l.setFirstName(rs.getString("Firstname"));
              
               instructorlist.add(l);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeLecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return instructorlist;
    }
// List Course (List<String>)
    public List<Course> getAllCourseEmpty(){
        courselist = new ArrayList<Course>();
        try {  
            Connection conn =getConn();  
            PreparedStatement stmt=conn.prepareStatement(sqlEmptyCourse);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Course c = new Course();
//               String strtamp ;               
//               strtamp = " "+rs.getInt("CourseID")+" - "+rs.getString("Title");
                c.setCourseID(rs.getInt("CourseID"));
                c.setTitle(rs.getString("Title"));
                courselist.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeLecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courselist;
    }
// List OnsiteCourse (List(OfficeAssignment))
    public List<OfficeLecturer> getAllOnsiteCourse(){
       onsitelist = new ArrayList<OfficeLecturer>();
        try {  
            
            Connection conn =getConn();  
            PreparedStatement stmt=conn.prepareStatement(sqlOnsiteCourse);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                OfficeLecturer onl = new OfficeLecturer();
                onl.setPersonID(rs.getInt("PersonID"));
                onl.setLastName(rs.getString("Lastname"));
                onl.setFirstName(rs.getString("Firstname"));
                onl.setCourse(rs.getString("Title"));
                onl.setLocation(rs.getString("Location"));
                onl.setDays(rs.getString("Days"));
                onl.setTime(rs.getTimestamp("Time"));
                
                onsitelist.add(onl);         
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeLecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return onsitelist;
    }
//List OnlineCourse (List<OfficeAssignment>)
     public List<OfficeLecturer> getAllOnlineCourse(){
        onlinelist = new ArrayList<OfficeLecturer>();
        try {  
            
            Connection conn =getConn();  
            PreparedStatement stmt=conn.prepareStatement(sqlOnlineCourse);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                OfficeLecturer onl = new OfficeLecturer();
                onl.setPersonID(rs.getInt("PersonID"));
                onl.setLastName(rs.getString("Lastname"));
                onl.setFirstName(rs.getString("Firstname"));
                onl.setCourse(rs.getString("Title"));
                onl.setUrl(rs.getString("url"));
                
                onlinelist.add(onl);         
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfficeLecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return onlinelist;
    }
// thêm phân công giảng dạy
     public int addOfficeLecturer(OfficeLecturer obj){
         String sql = "INSERT INTO courseinstructor(CourseID, PersonID) VALUES(?, ?)";
         OfficeLecturer office = new OfficeLecturer();
         office = obj;
         int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, office.getCourseID());
            st.setInt(2, office.getPersonID());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
     }
     public int deleteOfficeLecturer(int id){
         String sql = "DELETE FROM courseinstructor WHERE PersonID ="+id;
        
         int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
     }
}


 








   

