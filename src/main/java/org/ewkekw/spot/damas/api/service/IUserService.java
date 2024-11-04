package org.ewkekw.spot.damas.api.service;

import org.ewkekw.spot.damas.api.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    User getUserById(Long id);
}
