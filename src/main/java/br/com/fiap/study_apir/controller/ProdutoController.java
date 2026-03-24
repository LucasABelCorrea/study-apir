package br.com.fiap.study_apir.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;

@RestController
@RequestMapping("api/${api.version}/produtos")
public class ProdutoController {

    // Instanciamos um repositry para utilizar os métodos
    private RepositoryProdutoMockup mockup = new RepositoryProdutoMockup();

    @PostMapping("")
    public ResponseEntity <String> create() {
        
        // Essa linha utiliza o ResponseEntity para pegar o status de criado e também retorna o valor "Produto criado"
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");

    }

    @GetMapping("/{id}")
    // O @PathVariable serve para o método acessar o argumento presente na rota
    public ResponseEntity<Produto> findById(@PathVariable Long id) {

        Produto produto = mockup.findById(id);

        // Também é possível criar dessa forma (maneira menos verbosa)
        return ResponseEntity.ok(produto);
    }

    // Note que agora temos dois @GetMapping, porém com rotas diferentes
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {

        return ResponseEntity.ok(mockup.finalAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update() {
        return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete() {
    
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluído");
    }

}
