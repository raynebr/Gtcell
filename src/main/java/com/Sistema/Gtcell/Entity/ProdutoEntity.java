package com.Sistema.Gtcell.Entity;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoEntity {
    private UUID id;
    private String nome;
    private String descricao;
    private BigDecimal precoCompra;
    private BigDecimal precoVenda;
    private int qtdEstoque;
    private String codigo;
    private Boolean ativo;
    private CategoriaEntity categoria;
}
