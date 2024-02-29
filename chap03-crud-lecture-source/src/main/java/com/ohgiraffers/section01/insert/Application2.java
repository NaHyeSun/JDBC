package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매여부를 입력 받기 (Scanner 이용) */

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴의 이름을 입력하세요 :");
        String menuName = sc.nextLine();
        System.out.println("메뉴 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();
        System.out.println("카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        System.out.println("판매 여부를 결정해주세요(Y/N) : ");
        sc.nextLine();    //버퍼에 개행문자가 남아 있기 때문에 제거하기 위해 작성
        String orderableStatus = sc.nextLine().toUpperCase();

        /* MenuDTO 객체를 생성하여 입력받은 값으로 Setting */

        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);
        newMenu.setOrderablestatus(orderableStatus);

        /* insertController 의 insertMenu() 메소드 호출 */

        insertController isc = new insertController();
        int result = isc.insertMenu(newMenu);

        /* insert 결과에 따라서 성공이면 '메뉴 등록 성공!' , 실패이면 '메뉴 등록 실패!' 출력하기  */

        if(result > 0){
            System.out.println("메뉴 등록 성공!");
        }else {
            System.out.println("메뉴 등록 실패ㅠㅠ ");
        }

    }
}
