package com.allen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * count表，删除一条记录
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stm = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///jdbc?useSSL=false&serverTimezone=UTC","root","991104");
            String sql = "delete from account where id = 6";
            stm = conn.createStatement();
            int count = stm.executeUpdate(sql);
            System.out.println(count);
            if (count > 0){
                System.out.println("删除成功！");
            }else {
                System.out.println("删除失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (stm != null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
