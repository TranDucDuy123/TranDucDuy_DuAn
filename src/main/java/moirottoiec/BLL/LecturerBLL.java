/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moirottoiec.BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import moirottoiec.DAL.LecturerDAL;
import moirottoiec.DTO.Lecturer;

/**
 *
 * @author anhph
 */
public class LecturerBLL {
    LecturerDAL lecDAL;
    
    public LecturerBLL(){
        lecDAL = new LecturerDAL();
    }
    
    
    public Vector<Lecturer> getAllLecturer(){
        return lecDAL.getAllLecturer();
    }
    
    public Lecturer getLecturerByID(int ID){
        return lecDAL.getLecturerByID(ID);
        
    }
    
    public Vector<Lecturer> findLecturer(String tuKhoa){
        return lecDAL.findLecturer(tuKhoa);
    }
    
    public void addLecturer(Lecturer lecturer){
        lecDAL.addLecturer(lecturer);
    }
    
    public void updateLecturer(Lecturer lecturer){
        lecDAL.updateLecturer(lecturer);
    }
    
    public void deleteLecturer(int personID){
        lecDAL.deleteLecturer(personID);
    }
}