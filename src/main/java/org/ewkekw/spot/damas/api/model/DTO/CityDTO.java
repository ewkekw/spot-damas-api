package org.ewkekw.spot.damas.api.model.DTO;

import lombok.Data;

@Data
public class CityDTO {
    private Long id;
    private String nome;
    private Long stateId;
    private String sigla;
}
