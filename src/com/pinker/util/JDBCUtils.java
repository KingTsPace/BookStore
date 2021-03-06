package com.pinker.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCUtils {
    /**
     * 静态连接池
     */
    private static DataSource dataSource=null;

    static {
        String c3p0Conf=null;
        if(LoadDatabase.getDatabaseType().equals("SQLServer")){
            c3p0Conf="SQLServerC3p0Config";
        }else  if(LoadDatabase.getDatabaseType().equals("mysql")){
            c3p0Conf="mysqlC3p0Config";
        }
       dataSource=new  ComboPooledDataSource(c3p0Conf);
    }

    private  static  QueryRunner runn=new QueryRunner();

    /**
     * 获取数据库链接
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
             conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭连接方法
     */
public static void close(ResultSet rs,PreparedStatement ps,Connection conn){

    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if (ps != null) {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


}


