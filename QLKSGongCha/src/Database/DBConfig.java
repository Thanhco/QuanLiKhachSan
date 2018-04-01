/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sony Vaio
 */
public class DBConfig {

    private String userName = "sa";
    private String password = "1234";
    Statement statement;
    Connection m_Connection = null;

    public void dbConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        m_Connection = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=QuanLiKhachSan", userName, password);
        if (m_Connection != null) {
            System.out.println("connected");
        }
    }

    public Connection getCon() {
        return m_Connection;
    }
}
