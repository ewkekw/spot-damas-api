package org.ewkekw.spot.damas.api.controller;

import org.ewkekw.spot.damas.api.model.DTO.CityDTO;
import org.ewkekw.spot.damas.api.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private ILocationService locationService;

    @GetMapping
    public List<CityDTO> searchCities(@RequestParam("search") String search) {
        return locationService.searchCities(search);
    }
}
