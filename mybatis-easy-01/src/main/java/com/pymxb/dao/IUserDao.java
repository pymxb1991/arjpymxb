package com.pymxb.dao;

import com.pymxb.domain.User;

import java.util.List;

/**
 * This is Description
 *
 * @author Mr.Mao
 * @date 2020/04/09
 */
public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
}
