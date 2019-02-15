package com.easyget.service.impl;

import com.easyget.configuration.BaseDao;
import com.easyget.service.BaseSerivce;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T> implements BaseSerivce<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int insert(T record) {
        return baseDao.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        // TODO Auto-generated method stub
        return baseDao.insertSelective(record);
    }

    @Override
    public int insertList(List<T> recordList) {
        // TODO Auto-generated method stub
        return baseDao.insertList(recordList);
    }

    @Override
    public int insertUseGeneratedKeys(T record) {
        // TODO Auto-generated method stub
        return baseDao.insertUseGeneratedKeys(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        // TODO Auto-generated method stub
        return baseDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        // TODO Auto-generated method stub
        return baseDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<T> selectAll() {
        // TODO Auto-generated method stub
        return baseDao.selectAll();
    }

    @Override
    public List<T> select(T record) {
        // TODO Auto-generated method stub
        return baseDao.select(record);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        // TODO Auto-generated method stub
        return baseDao.selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(T record) {
        // TODO Auto-generated method stub
        return baseDao.selectCount(record);
    }

    @Override
    public T selectOne(T record) {
        // TODO Auto-generated method stub
        return baseDao.selectOne(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        // TODO Auto-generated method stub
        return baseDao.deleteByPrimaryKey(key);
    }

    @Override
    public int delete(T record) {
        // TODO Auto-generated method stub
        return baseDao.delete(record);
    }

}
