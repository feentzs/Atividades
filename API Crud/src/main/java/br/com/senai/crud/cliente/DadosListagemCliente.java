package br.com.senai.crud.cliente;

public record DadosListagemCliente(Long id, String nome, String email) {
    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(),
            cliente.getNome(),
            cliente.getEmail());
    }
}
