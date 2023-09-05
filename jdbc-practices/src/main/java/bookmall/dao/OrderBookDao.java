package bookmall.dao;

import bookmall.common.JdbcVar;
import bookmall.vo.OrderBookVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderBookDao {
    public int insert(OrderBookVo vo) {
        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD)) {
            String sql = "insert into orderBook (bookNo, orderNo, quantity) values (?, ?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, vo.getBookNo());
                pstmt.setLong(2, vo.getOrderNo());
                pstmt.setInt(3, vo.getQuantity());
                return pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<OrderBookVo> findAll() {
        String sql = "select b.no as no, b.title as title, b.price*quantity as price, ob.quantity as quantity, cast(o.orderNo as int) as orderNo "
                + " from book b, `orders` o, orderBook ob "
                + " where ob.bookNo = b.no and ob.orderNo = o.no";
        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<OrderBookVo> list = new ArrayList<>();
                do {
                    list.add(getOrderBooks(rs));
                } while (rs.next());
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private OrderBookVo getOrderBooks(ResultSet rs) throws SQLException {
        int no = rs.getInt("no");
        String name = rs.getString("title");
        int price = rs.getInt("price");
        int quantity = rs.getInt("quantity");
        long orderNo = rs.getLong("orderNo");
        return new OrderBookVo(no, name, price, quantity, orderNo);
    }

}