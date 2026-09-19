package com.Sistema.Gtcell.Dto.Request;

import com.Sistema.Gtcell.Entity.CategoriaEntity;

import java.math.BigDecimal;

public record ProdutoRequest(
        String nome,
        BigDecimal precoCompra,
        BigDecimal precoVenda,
        String categoriaNome
) {}
