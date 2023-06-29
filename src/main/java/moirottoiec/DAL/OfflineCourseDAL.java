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
import moirottoiec.DTO.OfflineCourse;

/**
 *
 * @author minhv
 */
public class OfflineCourseDAL extends DatabaseManager{
    OfflineCourse offlineCourse;
    public OfflineCourseDAL(){
        super();
        ConnectDB();
        offlineCourse = new OfflineCourse();
    }
    
    public Vector<OfflineCourse> getAllOfflineCourse(){
        ResultSet rs=null;
        Vector<OfflineCourse> arr = new Vector<OfflineCourse>();
        try {
            String sql = "SELECT * FROM onsitecourse";
            Connection conn = getConn();
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                OfflineCourse off = new OfflineCourse();
                off.setCourseID(rs.getInt("CourseID"));
                off.setLocation(rs.getString("Location"));
                off.setDays(rs.getString("Days"));
                off.setTime(rs.getDate("Time")); 
                arr.add(off); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfflineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public OfflineCourse getOfflineCourseByID(int ID){
        String sql = "SELECT * FROM onsitecourse WHERE CourseID = ?";
        
        try {
            Connection conn = getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                OfflineCourse off = new OfflineCourse();
                off.setCourseID(rs.getInt("CourseID"));
                off.setLocation(rs.getString("Location"));
                off.setDays(rs.getString("Days"));
                off.setTime(rs.getDate("Time")); 
                return off;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfflineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Vector<OfflineCourse> findOfflineCourse(String tuKhoa){
        ResultSet rs = null;
        Statement st = null;
        Vector<OfflineCourse> arr = new Vector<OfflineCourse>();  
        try {
            String sql = "SELECT * FROM onsitecourse WHERE Location like '%"+tuKhoa+"%' OR Days like '%"+tuKhoa+"%' ";
            Connection conn = getConn();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                OfflineCourse off = new OfflineCourse();
                off.setCourseID(rs.getInt("CourseID"));
                off.setLocation(rs.getString("Location"));
                off.setDays(rs.getString("Days"));
                off.setTime(rs.getDate("Time")); 
                arr.add(off);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OfflineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public int addOfflineCourse (OfflineCourse offlineCourse){
        String sql = "INSERT INTO onsitecourse(CourseID,Location, Days, Time) VALUES(?,?, ?, ?)";
        int Id = (int) Math.floor(Math.random()*(9999-1000+1)+1000);
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, Id);
            st.setString(2, offlineCourse.getLocation());
            st.setString(3, offlineCourse.getDays());
            st.setDate(4, offlineCourse.getTime());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(OfflineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int updateOfflineCourse (OfflineCourse offlineCourse){
        String sql = "UPDATE onsitecourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ? ";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, offlineCourse.getLocation());
            st.setString(2, offlineCourse.getDays());
            st.setDate(3, offlineCourse.getTime());
            st.setInt(4, offlineCourse.getCourseID());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(OfflineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    public int deleteOfflineCourse (int CourseID){
        String sql = "DELETE FROM onsitecourse WHERE CourseID = ?";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, CourseID);
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(OfflineCourseDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
