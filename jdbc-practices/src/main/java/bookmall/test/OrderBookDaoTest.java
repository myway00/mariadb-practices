package bookmall.test;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;

import java.util.List;

public class OrderBookDaoTest {

    public static void main(String[] args) {
        insertTest();
        findAllTest();

    }

    public static void findAllTest() {
        List<OrderBookVo> list = new OrderBookDao().findAll();
        for (OrderBookVo vo : list) {
            System.out.println(vo);
        }
    }

    public static void insertTest() {
        OrderBookVo vo = null;
        vo = new OrderBookVo();
        vo.setBookNo(1);
        vo.setOrderNo(1);
        vo.setQuantity(1);
        new OrderBookDao().insert(vo);
        vo = new OrderBookVo();
        vo.setBookNo(2);
        vo.setOrderNo(1);
        vo.setQuantity(1);
        new OrderBookDao().insert(vo);

    }

}