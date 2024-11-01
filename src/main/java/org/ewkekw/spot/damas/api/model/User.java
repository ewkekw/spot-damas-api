package org.ewkekw.spot.damas.api.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private Long estadoId;
    private Long cidadeId;
}
