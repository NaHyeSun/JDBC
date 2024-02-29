package com.ohgiraffers.section03.sqlinjection;

import java.sql.*;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

/* PreparedStatement는 Statement와 달리 placeholder(?)를 통해 sql injection 공격을 막을 수 있게 작성되어 있어
*  보안적 측면에서도 우수하다.
*  빠르고 안전하므로 특수 케이스가 아니면 PreparedStatement 사용을 권장한다. */

public class Application3 {
    private static String empId = "210";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";
    public static void main(String[] args) {

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?";
        System.out.println("query= " + query);

        /* 아래 sql과 같이 PreparedStatement는 placeholder로 입력되는 값에 single quotation(')이 있다면
        *  single quotation을 하나 더 붙여주고 , setString으로 값이 들어갈 때 , 양 옆에도 single quotation을 붙여준다.
        *  */
        //  SELECT * FROM EMPLOYEE WHERE EMP_ID = '210' AND EMP_NAME = ''' OR 1=1 AND EMP_ID = ''200'


        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);      //쿼리문의 물음표 부분으로 들어가게 됨.
            pstmt.setString(2,empName);

            rset = pstmt.executeQuery();
            if(rset.next()){
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            }else {
                System.out.println("회원 정보가 없습니다. ");  //injection 공격을 막았으므로 회원정보 없음으로 결과값이 나오게 된다.
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
