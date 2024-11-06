package org.ewkekw.spot.damas.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @JsonProperty("estado_id")
    private Long estadoId;

    @JsonProperty("cidade_id")
    private Long cidadeId;
}
