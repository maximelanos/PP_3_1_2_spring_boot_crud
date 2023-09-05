package com.maximelanosx.PP_3_1_2_spring_boot_crud.service;


import com.maximelanosx.PP_3_1_2_spring_boot_crud.dao.UserDao;
import com.maximelanosx.PP_3_1_2_spring_boot_crud.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User read(Long id) {
        return userDao.read(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User delete(Long id) {
        return userDao.delete(id);
    }
}
