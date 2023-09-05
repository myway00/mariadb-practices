package bookmall.dao;

import bookmall.common.JdbcVar;
import bookmall.vo.CategoryVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public int insert(CategoryVo vo) {
        String sql = "insert into category values(null, ?)";
        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
//			pstmt.setInt(1, vo.getNo());
            pstmt.setString(1, vo.getName());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<CategoryVo> findAll() {
        String sql = "select categoryNo, name from category";
        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<CategoryVo> list = new ArrayList<>();
                do {
                    list.add(getCategorys(rs));
                } while (rs.next());
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CategoryVo getCategorys(ResultSet rs) throws SQLException {
        int no = rs.getInt("categoryNo");
        String name = rs.getString("name");
        return new CategoryVo(no, name);
    }
}