package org.ewkekw.spot.damas.api.service;

import org.ewkekw.spot.damas.api.model.DTO.CityDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationService {

    List<CityDTO> searchCities(String search);
}
