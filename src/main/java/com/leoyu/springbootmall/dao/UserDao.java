package com.leoyu.springbootmall.dao;

import com.leoyu.springbootmall.dto.UserRegisterRequest;
import com.leoyu.springbootmall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userid);
}
