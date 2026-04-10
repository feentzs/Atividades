package com.example.crudcliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCliente(
        @NotBlank
        @Size(min = 3, max = 100)
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 11, max = 11) /* Podem ser usados patterns de regex, mas para ser direto na regra de 11 char */
        String cpf,

        @Size(max = 20)
        String telefone
) {
}
