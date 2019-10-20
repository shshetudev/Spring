package com.shetu.multipledboperation_jackrutorial.service;

import com.shetu.multipledboperation_jackrutorial.dao.UserDaoImpl;
import com.shetu.multipledboperation_jackrutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
    private UserDaoImpl userDao;
public List<User> getAllUser(){
    return userDao.getAllUser();
}
}
