package org.ewkekw.spot.damas.api.repository;

import org.ewkekw.spot.damas.api.model.DTO.CityDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository {

    List<CityDTO> findCitiesByName(String search);
}
