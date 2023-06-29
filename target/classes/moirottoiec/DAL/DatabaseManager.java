/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moirottoiec.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
//abc
public class DatabaseManager {
    private Connection conn;
    private Statement s;
    private PreparedStatement p;
    
    private String host, port, dbName, dbUser, dbPassword;

    public DatabaseManager() {
        host="localhost";
        port="3306";
        dbUser="root";
        dbName="school";
        dbPassword="";
    }
    public void ConnectDB() {
        String dbPath = "jdbc:mysql://" + host + ":" + port + "/"
        + dbName + "?useUnicode=yes&characterEncoding=UTF-8";
        try{
            conn=(Connection) DriverManager.getConnection(dbPath, dbUser, dbPassword);
            s=conn.createStatement();
            System.out.println("Connected");
        }   
        catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public Connection getConn() {
        return conn;
    }
    
    public ResultSet doReadQuery(String sql){
        ResultSet rs = null;
        try{
            rs=s.executeQuery(sql);
        }
        catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        return rs;
    }
    public void doUpdateQuery() throws SQLException{
        try{
            p.executeUpdate();
        }
        catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
