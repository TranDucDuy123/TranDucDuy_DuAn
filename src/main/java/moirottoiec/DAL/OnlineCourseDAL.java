/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import moirottoiec.DTO.Lecturer;
import moirottoiec.DTO.OnlineCourse;

/**
 *
 * @author minhv
 */
public class OnlineCourseDAL extends DatabaseManager{
    OnlineCourse onlineCourse;
    public OnlineCourseDAL(){
        super();
        ConnectDB();
        onlineCourse = new OnlineCourse();
    }
    
    public Vector<OnlineCourse> getAllOnlineCourses(){
        ResultSet rs=null;
        Vector<OnlineCourse> arr = new Vector<OnlineCourse>();
        try {
            String sql = "SELECT * FROM onlinecourse";
            Connection conn = getConn();
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                OnlineCourse onl = new OnlineCourse();
                onl.setCourseID(rs.getInt("CourseID"));
                onl.setURL(rs.getString("url"));
                arr.add(onl); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public OnlineCourse getOnlineCourseByID(int ID){
        String sql = "SELECT * FROM onlinecourse WHERE CourseID = ?";
        
        try {
            Connection conn = getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                OnlineCourse onl = new OnlineCourse();
                onl.setCourseID(rs.getInt("CourseID"));
                onl.setURL(rs.getString("url"));
                return onl;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Vector<OnlineCourse> findOnlineCourses(String tuKhoa){
        ResultSet rs = null;
        Statement st = null;
        Vector<OnlineCourse> arr = new Vector<OnlineCourse>();  
        try {
            //String sql = "SELECT * FROM person WHERE LastName like '%"+tuKhoa+"%'  OR FirstName like '%"+tuKhoa+"%' AND IN (SELECT * FROM person WHERE HireDate > 0)";
            String sql = "SELECT * FROM onlinecourse WHERE url like '%"+tuKhoa+"%' ";
            Connection conn = getConn();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                OnlineCourse onl = new OnlineCourse();
                onl.setCourseID(rs.getInt(1));
                onl.setURL(rs.getString(2));
                arr.add(onl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public int addOnlineCourse (OnlineCourse onlineCourse){
        String sql = "INSERT INTO onlinecourse(CourseID, url) VALUES(?, ?)";
        int Id = (int) Math.floor(Math.random()*(9999-1000+1)+1000);
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,Id);
            st.setString(2, onlineCourse.getURL());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int updateOnlineCourse (OnlineCourse onlineCourse){
        String sql = "UPDATE onlinecourse SET url = ? WHERE CourseID = ?";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, onlineCourse.getURL());
            st.setInt(2, onlineCourse.getCourseID());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    public int deleteOnlineCourse (int CourseID){
        String sql = "DELETE FROM onlinecourse WHERE CourseID = ?";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,CourseID);
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(OnlineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
