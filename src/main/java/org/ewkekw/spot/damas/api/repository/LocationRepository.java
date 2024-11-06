package org.ewkekw.spot.damas.api.repository;

import org.apache.ibatis.annotations.Mapper;
import org.ewkekw.spot.damas.api.model.DTO.CityDTO;

import java.util.List;

@Mapper
public interface LocationRepository {

    List<CityDTO> findCitiesByName(String search);
}
