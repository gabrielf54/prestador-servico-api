package com.gabriel.prestadorservicosapi.model.service;

import com.gabriel.prestadorservicosapi.model.dto.ClienteDTO;
import com.gabriel.prestadorservicosapi.model.entity.Cliente;
import com.gabriel.prestadorservicosapi.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<ClienteDTO> buscarClientes() {
        return repository.findAll().stream()
                .map(this::converteParaDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarClientePorId(Long id) {
        return repository.findById(id)
                .map(this::converteParaDTO)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = converteParaEntidade(clienteDTO);
        cliente = repository.save(cliente);
        return converteParaDTO(cliente);
    }

    private ClienteDTO converteParaDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setTelefone(cliente.getTelefone());
        clienteDTO.setServicosContratados(cliente.getServicosContratados());
        return clienteDTO;
    }

    private Cliente converteParaEntidade(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setServicosContratados(clienteDTO.getServicosContratados());
        return cliente;
    }
}
