package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.User;
import org.ewkekw.spot.damas.api.repository.UserRepository;
import org.ewkekw.spot.damas.api.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
