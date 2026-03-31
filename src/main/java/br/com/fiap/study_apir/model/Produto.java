package br.com.fiap.study_apir.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Essas anotações geram automaticamente os Gettes e Setters na minha aplicação
/*
@Getter
@Setter
@RequiredArgsConstructor // Gera um construtor automático para os atributos do tipo "final"
*/

@Data // O @Data já possui o @Getter, @Setter e @RequiredArgsConstructor
public class Produto {
    private final Long id; // O final indica que o atributo é obrigatório
    private final String nome;

    // Usamos o BigDecimal para tornar os valores decimais precisos, para representar valores monetários
    private final BigDecimal valor;
    
    // Como eu declarei as variáveis id e nome com "final" e passei elas no construtor, o Lombok não irá gerar 
    // setter para essas duas variáveis, pois uma variável do tipo "final" não pode ser modificada após sua inicialização
    /*public Produto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }*/
    
}