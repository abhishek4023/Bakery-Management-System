/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dbutil;

import java.sql.*;
/**
 *
 * @author ABHISHEK MAURYA
 */
public class CrudOperation {
    
    private static Connection con;
    
    public static Connection createConnection()
    {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbs", "root", "root");
            
        }
        
        catch(ClassNotFoundException|SQLException se)
        {
            System.out.println(se);
            
        }
        
        return con;
    }
    
    
    
}
