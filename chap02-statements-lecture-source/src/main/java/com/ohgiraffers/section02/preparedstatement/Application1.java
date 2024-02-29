package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            /*Statement 와 달리 PreparedStatement는 생성 당시에 쿼리가 있어야 한다. */
            pstmt = con.prepareStatement("SELECT EMP_ID,EMP_NAME FROM EMPLOYEE");

            rset = pstmt.executeQuery();

            //다중행이므로 while 문 사용
            while(rset.next()){
                System.out.println(rset.getString("EMP_ID")
                       +", " +rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);    //preparedstatement 는 statement를 상속받는다. 따라서 statement close 메소드를 상속받았다.
            close(con);
        }
    }
}
