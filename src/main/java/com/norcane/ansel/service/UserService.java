package com.norcane.ansel.service;

import com.norcane.ansel.model.User;

public interface UserService {

    void save(User user);

    User findByEmail(String email);
}
