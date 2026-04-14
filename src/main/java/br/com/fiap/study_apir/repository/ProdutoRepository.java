package br.com.fiap.study_apir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.study_apir.model.Produto;

@Repository // Anotação para o JPA entender que poderá fazer operações de Insert, Update...
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
    //Nos parâmetros do JpaRepository -> Classe que representa a entidade e tipo do ID (PK)

}
