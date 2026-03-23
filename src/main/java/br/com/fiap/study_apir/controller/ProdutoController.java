package br.com.fiap.study_apir.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PostMapping("")
    public ResponseEntity <String> create() {
        
        // Essa linha utiliza o ResponseEntity para pegar o status de criado e também retorna o valor "Produto criado"
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");

    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById() {

        // Também é possível criar dessa forma (maneira menos verbosa)
        return ResponseEntity.ok("Maça");
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
