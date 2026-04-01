/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_que4;

/**
 *
 * @author root
 */
public class TestConnection {
    
    public static void main(String[] args) throws Exception {
        if(DBConnection.getConnection() != null)
            System.out.println("Database Connected Successfully");
        else
            System.out.println("Connection Failed");
    }
    
}
