package bookmall.dao;

import bookmall.common.JdbcVar;
import bookmall.vo.BookVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public List<BookVo> findAll() {

        String sql = "select no, title, price, categoryNo from book";
        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<BookVo> list = new ArrayList<>();
                do {
                    list.add(getBooks(rs));
                } while (rs.next());
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BookVo getBooks(ResultSet rs) throws SQLException {
        int no = rs.getInt("no");
        String title = rs.getString("title");
        int price = rs.getInt("price");
        int categoryNo = rs.getInt("categoryNo");
        return new BookVo(no, title, price, categoryNo);
    }


    public int insert(BookVo vo) {
        String sql = "insert into book values(null, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, vo.getTitle());
            pstmt.setInt(2, vo.getPrice());
            pstmt.setInt(3, vo.getCategoryNo());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}