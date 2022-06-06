package com.leoyu.springbootmall.service;

import com.leoyu.springbootmall.dto.UserRegisterRequest;
import com.leoyu.springbootmall.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
