package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {

        Connection con = null;     // connection으로 통로를 만드는 과정

        try {
            /* 사용할 Driver 등록 */
            Class.forName("com.mysql.cj.jdbc.Driver");        //forName에 대해 try/catch문 사용

            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost/employee", "ohgiraffers","ohgiraffers");

            System.out.println("con = " + con);      // soutv

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
