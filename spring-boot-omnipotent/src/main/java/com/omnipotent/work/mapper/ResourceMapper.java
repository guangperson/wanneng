package com.omnipotent.work.mapper;

import com.omnipotent.work.entity.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resid);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resid);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}