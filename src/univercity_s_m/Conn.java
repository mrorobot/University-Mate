/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univercity_s_m;
import java.sql.*;

/**
 *
 * @author Inzayn
 */

public class Conn {
    
    Connection c;
Statement s;
    Conn(){
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql:///bbau", "root", "Zayn@430");
    s=c.createStatement();
}catch(Exception e){
    e.printStackTrace();
        System.out.println("mila nhi");
}
    
}
      public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return c.prepareStatement(query);
    }
}
