package com.cdut.test;

import com.cdut.utils.JDBCUtils;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
    }
}
