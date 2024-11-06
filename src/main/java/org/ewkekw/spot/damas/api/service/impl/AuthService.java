package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.User;
import org.ewkekw.spot.damas.api.repository.AuthRepository;
import org.ewkekw.spot.damas.api.service.IAuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }


    public User registerUser(User user) {
        return authRepository.save(user);
    }


    public User authenticateUser(String email, String senha) {
        return authRepository.findByEmailAndSenha(email,senha);
    }
}
