package br.com.fiap.study_apir.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.dto.ProdutoCreateRequest;
import br.com.fiap.study_apir.dto.ProdutoMapper;
import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.service.ProdutoService;

@RestController
@RequestMapping("api/${api.version}/produtos")
public class ProdutoController {

    @Autowired // Anotação para injestão de dependência
    private ProdutoService service;

    @Autowired
    private ProdutoMapper produtoMapper;

    @PostMapping("")
    public ResponseEntity<Produto> create(@RequestBody ProdutoCreateRequest dtoRequest) { // O @RequestBody indica que o argumento
                                                                          // recebido no parâmetro
        // virá no formato JSON. Dessa forma, minha aplicação irá tratar corretamente
        // Não esquecer: O Import do RequestBody correto é do spring framework

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrUpdate(produtoMapper.toModel(dtoRequest))); // Para não utilizar o model (produto) diretamente, criamos esse método
    }

    @GetMapping("/{id}")
    // O @PathVariable serve para o método acessar o argumento presente na rota
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        // Torna a variável opcional, ou seja, pode ou não ser nula
        // Optional <Produto> optProduto = mockup.findById(id);

        /*
         * if(optProduto.isPresent()) {
         * return ResponseEntity.ok(optProduto.get());
         * } else {
         * return ResponseEntity.notFound().build();
         * }
         */

        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

        // Esse map cumpre o mesmo papel que o if else de cima, porém utilizando as
        // ferramentas do Optional e deixando o código mais eficiente
    }

    // Note que agora temos dois @GetMapping, porém com rotas diferentes
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {

        Optional<Produto> optProduto = service.findById(id); //Optional porque o produto pode não existir

        if (optProduto.isPresent()) {
            produto.setId(id);
            Produto produtoAlterado = service.createOrUpdate(produto); // O createOrUpdate retorna um objeto do tipo produto
            return ResponseEntity.ok(produtoAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        // Declarei o ResponseEntity do tipo Void para informar que essa classe não irá
        // retornar nada, somente deletar o produto com base no ID

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
