/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moirottoiec.DAL;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import moirottoiec.DTO.Lecturer;
/**
 *
 * @author anhph
 */
public class LecturerDAL extends DatabaseManager {
    Lecturer lecturer;
    public LecturerDAL(){
        super();
        ConnectDB();
        lecturer = new Lecturer();
    }
    
    public Vector<Lecturer> getAllLecturer(){
        ResultSet rs=null;
        Vector<Lecturer> arr = new Vector<Lecturer>();
        try {
            String sql = "SELECT * FROM person WHERE HireDate > 0";
            Connection conn = getConn();
            Statement stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Lecturer lec = new Lecturer();
                lec.setPersonID(rs.getInt("PersonID"));
                lec.setLastName(rs.getString("LastName"));
                lec.setFirstName(rs.getString("FirstName"));
                lec.setHireDate(rs.getDate("HireDate")); 
                arr.add(lec); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public Lecturer getLecturerByID(int ID){
        String sql = "SELECT * FROM person WHERE PersonID = ?";
        
        try {
            Connection conn = getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Lecturer lec = new Lecturer();
                lec.setPersonID(rs.getInt("PersonID"));
                lec.setLastName(rs.getString("LastName"));
                lec.setFirstName(rs.getString("FirstName"));
                lec.setHireDate(rs.getDate("HireDate")); 
                return lec;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Vector<Lecturer> findLecturer(String tuKhoa){
        ResultSet rs = null;
        Statement st = null;
        Vector<Lecturer> arr = new Vector<Lecturer>();  
        try {
            //String sql = "SELECT * FROM person WHERE LastName like '%"+tuKhoa+"%'  OR FirstName like '%"+tuKhoa+"%' AND IN (SELECT * FROM person WHERE HireDate > 0)";
            String sql = "SELECT * FROM person WHERE HireDate > 0  AND (LastName like '%"+tuKhoa+"%'  OR FirstName like '%"+tuKhoa+"%') ";
            Connection conn = getConn();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Lecturer lec = new Lecturer();
                lec.setPersonID(rs.getInt(1));
                lec.setLastName(rs.getString(2));
                lec.setFirstName(rs.getString(3));
                lec.setHireDate(rs.getDate(4)); 
                arr.add(lec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public int addLecturer (Lecturer lecturer){
        String sql = "INSERT INTO person(LastName, FirstName, HireDate) VALUES(?, ?, ?)";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, lecturer.getLastName());
            st.setString(2, lecturer.getFirstName());
            st.setDate(3, lecturer.getHireDate());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int updateLecturer (Lecturer lecturer){
        String sql = "UPDATE person SET LastName = ?, FirstName = ?, HireDate = ? WHERE personID = ?";
        int result = 0;
        try{
            Connection conn = getConn();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, lecturer.getLastName());
            st.setString(2, lecturer.getFirstName());
            st.setDate(3, lecturer.getHireDate());
            st.setInt(4, lecturer.getPersonID());
            result = st.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(LecturerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    public int deleteLecturer (int personID){
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