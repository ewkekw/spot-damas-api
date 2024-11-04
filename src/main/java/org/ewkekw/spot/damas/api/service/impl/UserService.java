package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.User;
import org.ewkekw.spot.damas.api.repository.UserRepository;
import org.ewkekw.spot.damas.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.findById(id);
    }
}
