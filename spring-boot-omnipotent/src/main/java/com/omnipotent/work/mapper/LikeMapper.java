package com.omnipotent.work.mapper;

import com.omnipotent.work.entity.Like;

public interface LikeMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(Like record);

    int insertSelective(Like record);

    Like selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(Like record);

    int updateByPrimaryKey(Like record);
}