package com.maximelanosx.PP_3_1_2_spring_boot_crud.service;


import com.maximelanosx.PP_3_1_2_spring_boot_crud.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void create(User user);
    User read(Long id);
    void update(User user);
    User delete(Long id);
}
