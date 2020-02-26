package com.allen.datasource.druid;

import com.allen.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 完成添加操作，给account添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //1、获取连接
            conn = JDBCUtils.getConnection();
            //2、定义sql
            String sql = "insert into account values(null,?,?)";
            //3、获取pstmt对象
            pstm = conn.prepareStatement(sql);
            //4、给？赋值
            pstm.setString(1,"王五");
            pstm.setDouble(2,3000);
            //5、执行sql
            int count = pstm.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6、释放资源
            JDBCUtils.close(pstm,conn);
        }
    }
}
