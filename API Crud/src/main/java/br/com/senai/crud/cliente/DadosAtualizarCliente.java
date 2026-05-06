package br.com.senai.crud.cliente;

import br.com.senai.crud.endereco.DadosAtualizarEndereco;
import br.com.senai.crud.endereco.DadosCadastroEndereco;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCliente(
        Long id,

        @Size(min = 3, max = 100)
        String nome,

        @Size(max = 255)
        @Column(unique = true)
        String email,

        @Size(max = 20)
        @Pattern(regexp = "\\d{10,11}")
        String telefone,

        @Valid
        DadosAtualizarEndereco endereco
) {
}
