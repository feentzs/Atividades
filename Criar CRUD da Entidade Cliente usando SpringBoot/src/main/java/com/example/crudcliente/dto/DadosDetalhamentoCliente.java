package com.example.crudcliente.dto;

import com.example.crudcliente.model.Cliente;

public record DadosDetalhamentoCliente(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Boolean ativo
) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getTelefone(), cliente.getAtivo());
    }
}
