package com.Sistema.Gtcell.Dto.Response;

import com.Sistema.Gtcell.Entity.CategoriaEntity;

import java.math.BigDecimal;

public record ProdutoResponse(
        long id,
        String nome,
        BigDecimal precoCompra,
        BigDecimal precoVenda,
        CategoriaEntity categoria
) {
}
