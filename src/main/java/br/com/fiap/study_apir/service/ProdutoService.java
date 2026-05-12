package br.com.fiap.study_apir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public Produto createOrUpdate (Produto produto) { //Iremos utilizar esse método tanto para inserir quanto para atualizar algo na base de dados
        return repository.save(produto);
    }

    public Optional<Produto> findById(Long id) { //Precisamos do método optional porque pode haver ou não um retorno
        return repository.findById(id);
    }

    public List<Produto> findAll () {
        return repository.findAll();
    }

    public void deleteById (Long id) {
        repository.deleteById(id);
    }
}
