package bookmall.dao;

import bookmall.common.JdbcVar;
import bookmall.vo.OrdersVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
    public List<OrdersVo> findAll() {

        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD)) {
            String sql = "SELECT CAST(o.orderNo AS SIGNED) AS orderNo, m.name AS name, price, address FROM `orders` o, member m WHERE o.memberNo = m.no";

            try (PreparedStatement pstmt = con.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                List<OrdersVo> list = new ArrayList<>();

                while (rs.next()) {
                    list.add(getOrders(rs));
                }

                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private OrdersVo getOrders(ResultSet rs) throws SQLException {
        int orderNo = rs.getInt("orderNo");
        String name = rs.getString("name");
        int price = rs.getInt("price");
        String address = rs.getString("address");
        return new OrdersVo(orderNo, name, price, address);
    }

    public int insert(OrdersVo vo) {
        try (Connection con = DriverManager.getConnection(JdbcVar.URL, JdbcVar.USER, JdbcVar.PASSWORD)) {
            String sql = "INSERT INTO `orders`(no, price, address, memberNo) VALUES (null, ?, ?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, vo.getPrice());
                pstmt.setString(2, vo.getAddress());
                pstmt.setInt(3, vo.getMemberNo());
                return pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
