package com.pinker.dao;

import com.pinker.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BaseDao<T> {

    QueryRunner runn=new QueryRunner();

    private  Class<T> type;

    public BaseDao(){

        //UserDao extends BaseDao<User>
        //获取当前类的带泛型的父类
        ParameterizedType pt= (ParameterizedType) this.getClass().getGenericSuperclass();

        //获取泛型里具体的类，返回值为数组，获取第一个
        Type[] types =pt.getActualTypeArguments();
        this.type= (Class<T>) types[0];

    }

    /**
     * 通用增删改
     */
    public int update(String sql,Object...args){
        int count=0;
        Connection conn= JDBCUtils.getConnection();
        try {
             count=runn.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    /**
     * 通用查询一个
     */

    public T getBean(String sql,Object...args){
        T t=null;
        Connection conn=JDBCUtils.getConnection();
        try {
          t=  runn.query(conn,sql,new BeanHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,null,conn);
        }
        return t;
    }


    /**
     * 通用查询多个
     */
    public List<T> getListBean(String sql,Object...args){
        List<T> list=new ArrayList<T>();
        Connection conn=JDBCUtils.getConnection();


        try {
            list=runn.query(conn,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,null,conn);
        }
        return list;
    }


}
