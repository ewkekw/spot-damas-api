package org.ewkekw.spot.damas.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.ewkekw.spot.damas.api.model.DTO.CityDTO;
import org.ewkekw.spot.damas.api.service.ILocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Location", description = "Operações de localização")
@RestController
@RequestMapping("/location")
public class LocationController {

    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @Operation(summary = "Busca de cidades", description = "Busca cidades com base em uma sequência de caracteres")
    @GetMapping
    public List<CityDTO> searchCities(
            @Parameter(description = "Texto para buscar cidades") @RequestParam("search") String search) {
        return locationService.searchCities(search);
    }
}
