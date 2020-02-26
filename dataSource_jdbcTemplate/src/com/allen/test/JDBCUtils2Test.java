package com.allen.test;

import com.allen.utils.JDBCUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试JDBCUtils2
 */
public class JDBCUtils2Test {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from account";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                System.out.println(id + "--" + name + "--" + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.close(rs,pstmt,conn);
        }
    }
}
