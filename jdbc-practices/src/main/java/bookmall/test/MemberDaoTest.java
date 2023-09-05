package bookmall.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

    public static void main(String[] args) {

        insertTest();
        findAllTest();

    }

    public static void findAllTest() {
        List<MemberVo> list = new MemberDao().findAll();
        for (MemberVo vo : list) {
            System.out.println(vo);
        }
    }

    public static void insertTest() {
        MemberVo vo = null;
        vo = new MemberVo();
        vo.setName("myway00");
        vo.setPhone("010-1234-5678");
        vo.setEmail("myway00@mail.com");
        vo.setPassword("1234");
        new MemberDao().insert(vo);

        vo = new MemberVo();
        vo.setName("kickscar");
        vo.setPhone("010-0011-0011");
        vo.setEmail("kickscar@mail.com");
        vo.setPassword("1234");
        new MemberDao().insert(vo);
    }

}