package com.gabriel.prestadorservicosapi.model.entity;

import com.gabriel.prestadorservicosapi.model.enums.StatusServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "prestador_id", nullable = false)
    private PrestadorServico prestadorServico;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusServico status;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "descricao")
    private String descricao;

}

