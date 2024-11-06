package org.ewkekw.spot.damas.api.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ewkekw.spot.damas.api.model.User;

@Mapper
public interface UserRepository {

    User findById(@Param("id") Long id);
}
