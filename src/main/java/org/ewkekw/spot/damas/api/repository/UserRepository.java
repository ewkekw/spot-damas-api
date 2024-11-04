package org.ewkekw.spot.damas.api.repository;

import org.apache.ibatis.annotations.Param;
import org.ewkekw.spot.damas.api.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User findById(@Param("id") Long id);
}
