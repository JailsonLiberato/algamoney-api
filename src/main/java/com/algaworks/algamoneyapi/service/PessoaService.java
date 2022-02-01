package com.algaworks.algamoneyapi.service;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa){
        Pessoa pessoaSalva = buscarPessoa(codigo);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }

    private Pessoa buscarPessoa(Long codigo) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(codigo);
        if(!pessoaOptional.isPresent()){
            throw new EmptyResultDataAccessException(1);
        }
        Pessoa pessoaSalva = pessoaOptional.get();
        return pessoaSalva;
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPessoa(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }
}
