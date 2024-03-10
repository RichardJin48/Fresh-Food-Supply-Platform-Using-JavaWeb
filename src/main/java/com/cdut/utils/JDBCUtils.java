package com.cdut.utils;


import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class JDBCUtils {
    public static String user="root";
    public static String pwd="123456";
    public static String url="jdbc:mysql://localhost:3306/cdut?useUnicode=true&characterEncoding=utf8&useSSL=false";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pwd);
        } catch (Exception e) {
            System.out.println("Failed to obtain connection.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
