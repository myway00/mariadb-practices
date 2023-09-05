package bookmall.dao;

import bookmall.common.CommonVar;
import bookmall.vo.MemberVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    public List<MemberVo> findAll() {
        String sql = "select no, name, phone, email, password from member;";
        try (Connection con = DriverManager.getConnection(CommonVar.URL, CommonVar.USER, CommonVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<MemberVo> list = new ArrayList<>();
                do {
                    list.add(getMembers(rs));
                } while (rs.next());
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private MemberVo getMembers(ResultSet rs) throws SQLException {
        int no = rs.getInt("no");
        String name = rs.getString("name");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String password = rs.getString("password");
        return new MemberVo(no, name, phone, email, password);
    }

    public int insert(MemberVo vo) {
        String sql = "insert into member values(null, ?,?,?,password(?))";
        try (Connection con = DriverManager.getConnection(CommonVar.URL, CommonVar.USER, CommonVar.PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPhone());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getPassword());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}