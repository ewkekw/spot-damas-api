package org.ewkekw.spot.damas.api.service;

import org.ewkekw.spot.damas.api.model.DTO.CityDTO;

import java.util.List;

public interface ILocationService {
    List<CityDTO> searchCities(String search);
}
