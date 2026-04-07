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
    public Produto(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    private Long id; // O final indica que o atributo é obrigatório
    private String nome;

    // Usamos o BigDecimal para tornar os valores decimais precisos, para representar valores monetários
    private BigDecimal valor;
    
    /*public Produto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }*/
    
}