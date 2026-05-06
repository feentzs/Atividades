package br.com.senai.crud.cliente;

import br.com.senai.crud.endereco.DadosCadastroEndereco;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroCliente(
    @NotBlank
    @Size(min = 3, max = 100)
    String nome,

    @NotBlank
    @Size(max = 255)
    @Column(unique = true)
    @Email
    String email,

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(unique = true)
    @CPF
    String cpf,

    @Size(max = 20)
    @Pattern(regexp = "\\d{10,11}")
    String telefone,

    @NotNull @Valid DadosCadastroEndereco endereco
) {
}
