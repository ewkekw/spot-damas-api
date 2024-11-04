package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.User;
import org.ewkekw.spot.damas.api.repository.AuthRepository;
import org.ewkekw.spot.damas.api.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private AuthRepository authMapper;


    public User registerUser(User user) {
        return authMapper.save(user);
    }


    public User authenticateUser(String email, String senha) {
        return authMapper.findByEmailAndSenha(email,senha);
    }
}
