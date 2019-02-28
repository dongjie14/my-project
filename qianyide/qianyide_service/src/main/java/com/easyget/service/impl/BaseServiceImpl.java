package com.easyget.service.impl;

import com.easyget.configuration.BaseMapper;
import com.easyget.service.BaseService;
import com.easyget.service.TSysReturnCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Autowired
    public TSysReturnCodeService sysReturnCodeService;

    public void setbaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        // TODO Auto-generated method stub
        return baseMapper.insertSelective(record);
    }

    @Override
    public int insertList(List<T> recordList) {
        // TODO Auto-generated method stub
        return baseMapper.insertList(recordList);
    }

    @Override
    public int insertUseGeneratedKeys(T record) {
        // TODO Auto-generated method stub
        return baseMapper.insertUseGeneratedKeys(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        // TODO Auto-generated method stub
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        // TODO Auto-generated method stub
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<T> selectAll() {
        // TODO Auto-generated method stub
        return baseMapper.selectAll();
    }

    @Override
    public List<T> select(T record) {
        // TODO Auto-generated method stub
        return baseMapper.select(record);
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        // TODO Auto-generated method stub
        return baseMapper.selectByPrimaryKey(key);
    }

    @Override
    public int selectCount(T record) {
        // TODO Auto-generated method stub
        return baseMapper.selectCount(record);
    }

    @Override
    public T selectOne(T record) {
        // TODO Auto-generated method stub
        return baseMapper.selectOne(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        // TODO Auto-generated method stub
        return baseMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int delete(T record) {
        // TODO Auto-generated method stub
        return baseMapper.delete(record);
    }

}
