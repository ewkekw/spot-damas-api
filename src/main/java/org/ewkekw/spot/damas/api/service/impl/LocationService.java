package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.DTO.CityDTO;
import org.ewkekw.spot.damas.api.repository.LocationRepository;
import org.ewkekw.spot.damas.api.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    @Autowired
    private LocationRepository locationMapper;

    @Override
    public List<CityDTO> searchCities(String search) {
        return locationMapper.findCitiesByName(search);
    }
}
