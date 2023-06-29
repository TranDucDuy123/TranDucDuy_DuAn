/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moirottoiec.DTO;

import java.sql.Date;

/**
 *
 * @author anhph
 */
public class Lecturer {
    private int PersonID;
    private String LastName;
    private String FirstName;
    private Date HireDate;
    
    public Lecturer(){
    
    }
    
    public Lecturer(int PersonID, String LastName, String FirstName, Date HireDate) {
        this.PersonID = PersonID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.HireDate = HireDate;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date HireDate) {
        this.HireDate = HireDate;
    }
    public String getFullName(){
        return FirstName+' '+LastName;
    }
    
}