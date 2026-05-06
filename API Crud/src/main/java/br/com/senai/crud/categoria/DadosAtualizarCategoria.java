package br.com.senai.crud.categoria;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCategoria(
        Long id,

        @Size(min=3, max=60)
        @Column(unique = true)
        String nome,

        @Size(max=255)
        String descricao
) {
}
