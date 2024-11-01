package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IAuthService {

    User registerUser(User user);

    User authenticateUser(String email, String senha);
}
