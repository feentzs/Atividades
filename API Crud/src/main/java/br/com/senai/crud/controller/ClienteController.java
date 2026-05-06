package br.com.senai.crud.controller;

import br.com.senai.crud.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados){
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public List<DadosListagemCliente> listarClientes(){
        var lista = repository.findAllByAtivoTrue();
        return lista.stream().map(DadosListagemCliente::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DadosAtualizarCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarCliente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarCliente(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirCliente();
    }

    @GetMapping("/{id}")
    public DadosDetalhamentoCliente detalharCliente(@PathVariable Long id){
        Cliente cliente = repository.findByIdAndAtivoTrue(id).
                orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente não encontrado"
                ));
        return new DadosDetalhamentoCliente(cliente);
    }
}
