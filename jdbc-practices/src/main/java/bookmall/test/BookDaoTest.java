package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

    public static void main(String[] args) {
        insertTest();
        findAllTest();

    }

    public static void findAllTest() {
        List<BookVo> list = new BookDao().findAll();
        for (BookVo vo : list) {
            System.out.println(vo);
        }
    }


    public static void insertTest() {
        BookVo vo = null;
        vo = new BookVo();
        vo.setTitle("베이킹 책");
        vo.setPrice(10000);
        vo.setCategoryNo(1);
        new BookDao().insert(vo);
        vo = new BookVo();
        vo.setTitle("스위스 여행 일대기");
        vo.setPrice(20000);
        vo.setCategoryNo(2);
        new BookDao().insert(vo);
        vo = new BookVo();
        vo.setTitle("해리포터");
        vo.setPrice(30000);
        vo.setCategoryNo(3);
        new BookDao().insert(vo);
    }



}