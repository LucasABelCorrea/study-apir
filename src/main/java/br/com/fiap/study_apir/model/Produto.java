package br.com.fiap.study_apir.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Essas anotações geram automaticamente os Gettes e Setters na minha aplicação
/*
@Getter
@Setter
@RequiredArgsConstructor // Gera um construtor automático para os atributos do tipo "final"
*/

@Data // O @Data já possui o @Getter, @Setter e @RequiredArgsConstructor
@Entity // Informa que a classe irá representar uma Entidade (Tabela)
@NoArgsConstructor // Serve para não precisar definir um construtor sem argumentos (para não dar erro)
@Table(name = "produtos") // Serve para mudar o nome da tabela na BASE DE DADOS (Crio uma tabela nova)
public class Produto {

    @Id // Informa que o próximo atributo será o ID (Primary Key)
    private Long id; // O final indica que o atributo é obrigatório

    @Column(name = "nome_produto_char", length = 100, columnDefinition = "char(100)", nullable = false) // Mudo o nome da coluna na BASE DE DADOS e defino o tamanho MÁXIMO (VARCHAR) de caracteres na coluna (Crio uma coluna nova)
    //Também criei um exemplo de coluna do tipo CHAR de 70 caracteres
    // Também defino a coluna como not null
    private String nome;

    // Usamos o BigDecimal para tornar os valores decimais precisos, para representar valores monetários
    private BigDecimal valor;
    
    /* 
    public Produto() {
    }
    */

    public Produto(Long id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }
    
}