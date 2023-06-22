package com.example.exercicio1jpa.controller;

import com.example.exercicio1jpa.entity.Endereco;
import com.example.exercicio1jpa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("endereco")
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvarEndereco(endereco);
    }

    @GetMapping("endereco/{id}")
    public Endereco buscarEndereco(@PathVariable Long id) {
        return enderecoService.buscarEndereco(id);
    }

    @GetMapping("enderecos")
    public List<Endereco> listaEnderecos() {
        return enderecoService.listaEnderecos();
    }

    @GetMapping("enderecos/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
    }

    @PutMapping("endere")
    public void atualizarEndereco(@RequestBody Endereco endereco) {
        System.out.println(endereco.getCidade());
        enderecoService.atualizarEndereco(endereco);
    }

    @GetMapping("endereco/cidade/{nomeCidade}")
    public Endereco buscarEnderecoCidade(@PathVariable String nomeCidade) {
        return enderecoService.buscarEnderecoPorCidade(nomeCidade);

    }

    @GetMapping("endereco/rua/{nomeRua}")
    public Endereco buscarEnderecoRua(@PathVariable String nomeRua) {
        return enderecoService.buscarEnderecoPorRua(nomeRua);

    }

    @GetMapping("endereco/cep/{nomeCep}")
    public Endereco buscarEnderecoCep(@PathVariable String nomeCep) {
        return enderecoService.buscarEnderecoPorCep(nomeCep);
    }
}