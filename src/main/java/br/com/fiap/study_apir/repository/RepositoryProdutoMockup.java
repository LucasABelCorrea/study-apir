package br.com.fiap.study_apir.repository;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fiap.study_apir.model.Produto;

public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();
    private long ID = 0L; // Valor do ID mockado inicialmente para simular um "Sequence", ou seja, ser um auto increment

    public RepositoryProdutoMockup() {

        /*
         * Produto produto = new Produto(1L, "Caqui", BigDecimal.valueOf(10.75));
         * produtos.add(produto);
         * 
         * produto = new Produto(30L, "Uva", BigDecimal.valueOf(15.20));
         * produtos.add(produto);
         */

        // Note que foi utilizado "produto" duas vezes - (não foi preciso criar outra
        // variável para incluir dois produtos).
        // Isso acontece porque nós criamos um novo objeto em memória para cada produto
        // (através da utilização do new Produto),
        // ou seja, a cada "new" que utilizamos, alocamos um espaço diferente na memória
        // para o produto, portanto, o que é incluído
        // na lista é o que está no ENDEREÇO DE MEMÓRIA, logo, os objetos que serão
        // incluídos são diferentes.

        // Resumindo... A variável produto recebe um endereço de memória a cada "new
        // Produto", quando fazemos um add na lista, esse endereço
        // de memória que é incluído, referenciando um espaço na memória que há as
        // informações dos objetos que queremos.

        produtos.add(new Produto(++ID, "Caqui", BigDecimal.valueOf(10.75)));
        produtos.add(new Produto(++ID, "Uva", BigDecimal.valueOf(15.20)));
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public Optional<Produto> findById(Long id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public boolean deleteById(Long id) {
        return produtos.removeIf(p -> p.getId().equals(id));
    }

    public Produto create(Produto produto) {
        // 1. Gerar o id e atribuir o id novo ao produto a ser cadastrado
        produto.setId(++ID);

        // 2. Salvar no BD
        produtos.add(produto);
        
        // 3. Retornar o produto novo
        return produto;
    }

    public void update(long id, Produto produto) {

    }
}
