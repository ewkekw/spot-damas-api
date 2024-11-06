package org.ewkekw.spot.damas.api.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ewkekw.spot.damas.api.model.User;

@Mapper
public interface AuthRepository {
    User save(User user);

    User findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
