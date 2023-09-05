package bookmall.test;

import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.vo.OrdersVo;

public class OrdersDaoTest {

    public static void main(String[] args) {
        insertTest();
        findAllTest();

    }

    public static void findAllTest() {
        List<OrdersVo> list = new OrdersDao().findAll();
        for (OrdersVo vo : list) {
            System.out.println(vo);
        }
    }

    public static void insertTest() {
        OrdersVo vo = new OrdersVo();
        vo.setPrice(10000);
        vo.setAddress("서울");
        vo.setMemberNo(1);
        vo.setOrderNo(1);
        new OrdersDao().insert(vo);
    }


}