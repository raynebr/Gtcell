package com.Sistema.Gtcell.Entity;

import com.Sistema.Gtcell.Enum.FormaDePagamentoEnum;
import com.Sistema.Gtcell.Enum.StatusVendaEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class VendaEntity {
    private UUID id;
    private FuncionarioEntity funcionario;
    private ClienteEntity cliente;
    private LocalDateTime data;
    private BigDecimal total;
    private BigDecimal desconto;
    private FormaDePagamentoEnum formaDePagamento;
    private StatusVendaEnum statusVenda;
    private List<ItemVendaEntity> itemVendaEntitylist;
}
