/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;
import java.sql.*;
/**
 *
 * @author Erick
 */
public class ConnectionDB {
//    private Connection cnn;
    public static Connection getConnectionDB() {
        Connection cnn = null;
        try {
            String url ="jdbc:sqlserver://localhost;databaseName=QuanLiKhachSan1";
            String user = "sa";
            String pass = "12345678";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(url, user, pass);
//            System.out.println("Ket Noi Thanh Cong");
        } catch (Exception e) {
            System.out.println("Khong Ket Noi Duoc");
        }
        return cnn;
    }
}
