package com.Sistema.Gtcell.Dto.Response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponse(
        UUID id,
        String nome,
        String descricao,
        BigDecimal precoCompra,
        BigDecimal precoVenda,
        int qtdEstoque,
        String codigo
) {
}
