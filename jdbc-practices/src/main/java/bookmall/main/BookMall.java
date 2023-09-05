package bookmall.main;

import bookmall.test.*;

public class BookMall {

//    1. 회원 리스트 – 2명
//    2. 카테고리 리스트 – 3개
//    3. 상품리스트 – 3개
//    4. 카트 리스트 – 2개
//    5. 주문 리스트 – 1개
//    6. 주문 도서 리스트 – 2개

    public static void main(String[] args) {

        System.out.println("## 회원리스트");
        MemberDaoTest.insertTest();
        MemberDaoTest.findAllTest();

        System.out.println("\n## 카테고리");
        CategoryDaoTest.insertTest();
        CategoryDaoTest.findAllTest();


        System.out.println("\n## 도서 상품");
        BookDaoTest.insertTest();
        BookDaoTest.findAllTest();


        System.out.println("\n## 카트");
        CartDaoTest.insertTest();
        CartDaoTest.findAllTest();


        System.out.println("\n## 주문");
        OrdersDaoTest.insertTest();
        OrdersDaoTest.findAllTest();

        System.out.println("\n## 주문도서");
        OrderBookDaoTest.insertTest();
        OrderBookDaoTest.findAllTest();
    }
}