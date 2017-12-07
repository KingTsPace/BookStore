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


public interface BaseDao<T> {


    /**
     * 通用增删改
     * @param sql sql
     * @param args  可变数组接受占位符参数
     * @return
     */
     int update(String sql,Object...args);


    /**
     * 通用查询一个
     */

     T getBean(String sql,Object...args);


    /**
     * 通用查询多个
     */
     List<T> getListBean(String sql,Object...args);


}
