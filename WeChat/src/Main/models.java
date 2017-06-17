/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HanHan
 */
public class models {
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt;
    public models(){
        connectDatabase();
    }
     private void  connectDatabase(){
            try {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:wechat.db");
                stmt = conn.createStatement();
                System.out.println("Connection Success");
            } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                System.out.println("Connection failed: "+e);
            }
        }
}
