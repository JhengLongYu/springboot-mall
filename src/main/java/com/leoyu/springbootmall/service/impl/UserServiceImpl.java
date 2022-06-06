package com.leoyu.springbootmall.service.impl;
import com.leoyu.springbootmall.dao.UserDao;
import com.leoyu.springbootmall.dto.UserRegisterRequest;
import com.leoyu.springbootmall.model.User;
import com.leoyu.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
