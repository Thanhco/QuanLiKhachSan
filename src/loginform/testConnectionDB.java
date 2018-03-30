/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginform;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class testConnectionDB {

    static ConnectionDB kn = new ConnectionDB();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection cn = kn.getConnectionDB();
        String sql = "SELECT * FROM TaiKhoan";
        Statement stm = null;
        ResultSet rs = null;
        try {
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Name: " + rs.getString(1) + "\tPass: "
                        + rs.getString(2) + "\tid: " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("Loi roi ne " + e);
        }
    }
}
