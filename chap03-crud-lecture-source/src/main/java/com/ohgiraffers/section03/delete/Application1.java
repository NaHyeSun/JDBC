package com.ohgiraffers.section03.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        /* 1. 삭제할 메뉴 코드 입력받기
        *  2. DeleteController의 deleteMenu() 메소드 호출
        *  3. delete 결과에 따라 성공이면 '메뉴 삭제 성공!, 실패이면 '메뉴 삭제 실패ㅜ_ㅜ' 출력
        *  4. entry key = "deleteMenu"  */

        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 메뉴 코드를 입력하세요 : ");
        int menuCode = sc.nextInt();

        MenuDTO deleteMenu = new MenuDTO();
        deleteMenu.setMenuCode(menuCode);

        DeleteController delete = new DeleteController();
        int result = delete.deleteMenu(deleteMenu);

        if(result > 0 ){
            System.out.println("메뉴 삭제 성공! ");
        }else {
            System.out.println("메뉴 삭제 실패ㅜ_ㅜ");
        }

    }
}
