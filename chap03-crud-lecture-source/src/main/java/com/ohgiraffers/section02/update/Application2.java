package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        /*  1.변경할 메뉴 코드, 이름, 가격을 입력 받기
         *  2.MenuDTO 객체를 생성하여 입력받은 값으로 Setting
         *  3.UpdateController의 updateMenu() 메소드 호출
         *  4.update 결과에 따라 성공, 실패 메세지 출력  */

        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 메뉴 코드를 입력하세요 : ");
        int menuCode = sc.nextInt();
        System.out.println("변경할 메뉴의 이름을 입력하세요 :");
        sc.nextLine();
        String menuName = sc.nextLine();
        System.out.println("변경할 메뉴의 가격을 입력하세요 :");
        int menuPrice = sc.nextInt();

        MenuDTO updateMenu = new MenuDTO();
        updateMenu.setMenuCode(menuCode);
        updateMenu.setMenuName(menuName);
        updateMenu.setMenuPrice(menuPrice);

        UpdateController upcontroller = new UpdateController();
        int result = upcontroller.updateMenu(updateMenu);

        if (result > 0) {
            System.out.println("메뉴 변경 성공!");
        } else {
            System.out.println("메뉴 변경 실패ㅠㅠ ");

        }
    }
}
