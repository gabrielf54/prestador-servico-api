package com.gabriel.prestadorservicosapi.model.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private long servicosContratados;
}
