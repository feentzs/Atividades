package com.example.crudcliente.model;

import com.example.crudcliente.dto.DadosAtualizarCliente;
import com.example.crudcliente.dto.DadosCadastroCliente;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String cpf;
    
    private String telefone;
    
    private Boolean ativo;

    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
    }

    public void atualizarInformacoes(DadosAtualizarCliente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
