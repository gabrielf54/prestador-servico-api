package com.gabriel.prestadorservicosapi.model.controller;

import com.gabriel.prestadorservicosapi.model.dto.ClienteDTO;
import com.gabriel.prestadorservicosapi.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscar() {
        return ResponseEntity.ok().body(service.buscarClientes());
    }

    @GetMapping("/cliente_id")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable(value = "cliente_id") Long id) {
        return ResponseEntity.ok().body(service.buscarClientePorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok().body(service.criarCliente(cliente));
    }
}
