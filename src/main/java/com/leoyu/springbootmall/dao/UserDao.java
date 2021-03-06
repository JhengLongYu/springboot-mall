package com.leoyu.springbootmall.dao;

import com.leoyu.springbootmall.dto.UserRegisterRequest;
import com.leoyu.springbootmall.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserByEmail(String email);

    User getUserById(Integer userid);
}
