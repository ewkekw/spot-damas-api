package org.ewkekw.spot.damas.api.service.impl;

import org.ewkekw.spot.damas.api.model.DTO.CityDTO;
import org.ewkekw.spot.damas.api.repository.LocationRepository;
import org.ewkekw.spot.damas.api.service.ILocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<CityDTO> searchCities(String search) {
        return locationRepository.findCitiesByName(search);
    }
}
