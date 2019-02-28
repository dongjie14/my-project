package com.easyget.service;

import java.util.List;

public interface BaseService<T> {
    int insert(T record);

    int insertSelective(T record);

    int insertList(List<T> recordList);

    int insertUseGeneratedKeys(T record);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

    List<T> selectAll();

    List<T> select(T record);

    T selectByPrimaryKey(Object key);

    int selectCount(T record);

    T selectOne(T record);

    int deleteByPrimaryKey(Object key);

    int delete(T record);
}
