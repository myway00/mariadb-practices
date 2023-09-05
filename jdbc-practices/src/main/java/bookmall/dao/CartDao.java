package bookmall.dao;

import bookmall.common.CommonVar;
import bookmall.vo.CartVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public int insert(CartVo vo) {
        String sql = "insert into cart (bookNo, memberNo, quantity) values (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(CommonVar.URL, CommonVar.USER, CommonVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, vo.getBookNo());
            pstmt.setInt(2, vo.getMemberNo());
            pstmt.setInt(3, vo.getQuantity());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<CartVo> findAll() {
        String sql = "select m.name as name, b.title as title, quantity, b.price*quantity as price "
                + " from cart c , book b, member m where b.no=c.bookNo and m.no = c.memberNo";
        try (Connection con = DriverManager.getConnection(CommonVar.URL, CommonVar.USER, CommonVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<CartVo> list = new ArrayList<>();
                do {
                    list.add(getCarts(rs));
                } while (rs.next());
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private CartVo getCarts(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String title = rs.getString("title");
        int quantity = rs.getInt("quantity");
        int price = rs.getInt("price");
        return new CartVo(quantity, name, title, price);
    }

}