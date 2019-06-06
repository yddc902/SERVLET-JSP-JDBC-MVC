package com.yashdesai.connection;

import java.sql.*;

public class ConnectionProvider {
    public static Connection con = null;
    public static Connection getConnection() {
        if(con != null) {
            return con;
        }else {
            try {
                String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
                String url = "jdbc:ucanaccess://C:/xampp/tomcat/webapps/mvc2/Employee.accdb";

                Class.forName(driver);
                con = DriverManager.getConnection(url);
            }catch(SQLException sqle) {
                sqle.printStackTrace();
            }catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            return con;
        }
    }
}
