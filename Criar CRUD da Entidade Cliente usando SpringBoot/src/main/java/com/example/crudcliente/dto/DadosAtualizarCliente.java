package com.example.crudcliente.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCliente(
        @NotNull
        Long id,

        @Size(min = 3, max = 100)
        String nome,

        @Size(max = 20)
        String telefone
) {
}
