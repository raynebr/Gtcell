package com.Sistema.Gtcell.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String descricao;

    private BigDecimal precoCompra;

    private BigDecimal precoVenda;

    private int qtdEstoque;

    private String codigo;

    // Muitos produtos podem pertencer a uma mesma categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;
}