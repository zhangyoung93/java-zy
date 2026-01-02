package com.zy.demo.jdbc;

import com.zy.demo.util.SnowflakeIdGenerator;

import java.sql.*;

public class JdbcConn {

    private static final String INSERT_SQL = "insert into zy_user(user_id,user_full_name,login_name,login_pwd) values(?,?,?,?);";

    private static final String SELECT_SQL = "select user_id,user_full_name,login_name,login_pwd from zy_user;";

    public void jdbcHandler() {
        JdbcConfig jdbcConfig = JdbcConfigFactory.getJdbcConfig("mysql");
        //需要释放的资源
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载并注册数据库驱动，创建数据库连接
            conn = DriverManager.getConnection(jdbcConfig.getUrl(), jdbcConfig.getUsername(), jdbcConfig.getPassword());
            //预编译SQL，占位符传参
            ps = conn.prepareStatement(INSERT_SQL);
            ps.setLong(1, SnowflakeIdGenerator.getInstance().nextId());
            ps.setString(2, "李四");
            ps.setString(3, "lisi");
            ps.setString(4, "lisi123456");
            int updateRows = ps.executeUpdate();
            System.out.println("finish execute SQL,update rows=" + updateRows);
            rs = ps.executeQuery(SELECT_SQL);
            while (rs.next()) {
                System.out.println("query result:row=" + rs.getRow()
                        + ",user_id=" + rs.getLong(1)
                        + ",user_full_name=" + rs.getString(2)
                        + ",login_name=" + rs.getString(3)
                        + ",login_pwd=" + rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
