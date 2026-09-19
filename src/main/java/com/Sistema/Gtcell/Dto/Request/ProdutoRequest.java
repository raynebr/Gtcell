package com.Sistema.Gtcell.Dto.Request;

import java.math.BigDecimal;

public record ProdutoRequest(
        String nome,
        String descricao,
        BigDecimal precoCompra,
        BigDecimal precoVenda,
        int qtdEstoque,
        String codigo
) {
}
