package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

    public static void main(String[] args) {

        insertTest();
        findAllTest();

    }

    public static void findAllTest() {
        List<CategoryVo> list = new CategoryDao().findAll();
        for (CategoryVo vo : list) {
            System.out.println(vo);
        }
    }

    public static void insertTest() {
        CategoryVo vo = null;
        vo = new CategoryVo();
        vo.setName("요리");
        new CategoryDao().insert(vo);
        vo = new CategoryVo();

        vo.setName("여행");
        new CategoryDao().insert(vo);
        vo = new CategoryVo();

        vo.setName("판타지 소설");
        new CategoryDao().insert(vo);
    }

}