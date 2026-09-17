package com.Sistema.Gtcell.Entity;

import com.Sistema.Gtcell.Enum.TipoMovimentacao;

import java.time.LocalDateTime;
import java.util.UUID;

public class MovimentacaoEstoque {
    private UUID id;
    private ProdutoEntity produto;
    private int quantidade;
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime data;
    private FuncionarioEntity funcionario;
}
