package com.allen.jdbc;

import java.sql.*;

/**
 * 执行DDL语句
 */
public class JdbcDemo7 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///jdbc?useSSL=false&serverTimezone=UTC","root","991104");
            String sql = "select * from account";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            //处理结果

            while(rs.next()){
                //循环判断游标是否是最后一行末尾
                //获取数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balabce = rs.getDouble(3);
                System.out.println(id + "---" + name + "---" + balabce);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
