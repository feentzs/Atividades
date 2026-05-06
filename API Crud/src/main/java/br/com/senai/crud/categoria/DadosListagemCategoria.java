package br.com.senai.crud.categoria;

public record DadosListagemCategoria(Long id, String nome) {
    public DadosListagemCategoria(Categoria categoria){
        this(categoria.getId(),  categoria.getNome());
    }
}
