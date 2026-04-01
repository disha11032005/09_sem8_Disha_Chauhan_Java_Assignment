/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que4;



import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author root
 */
public class DBConnection {
    
   public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/retaildb",
            "root",
            "root"
        );
    }
    
}
