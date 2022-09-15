package com.omnipotent.work.mapper;

import com.omnipotent.work.entity.Money;

public interface MoneyMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Money record);

    int insertSelective(Money record);

    Money selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Money record);

    int updateByPrimaryKey(Money record);
}