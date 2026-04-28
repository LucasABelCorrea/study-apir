package br.com.fiap.study_apir.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table (name = "clientes")
public class Cliente {
    @Id
    Long id;

    @Column (name = "nome_cliente", length = 100, nullable = false)
    String nome;
}
