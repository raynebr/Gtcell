package com.Sistema.Gtcell.Entity;

import com.Sistema.Gtcell.Enum.FormaDePagamentoEnum;
import com.Sistema.Gtcell.Enum.StatusVendaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_venda")
public class VendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @JoinColumn(name = "funcionario_id")
    private FuncionarioEntity funcionario;
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    private LocalDateTime data;
    private BigDecimal total;
    private BigDecimal desconto;
    private FormaDePagamentoEnum formaDePagamento;
    private StatusVendaEnum statusVenda;
    private List<ItemVendaEntity> itemVendaEntitylist;
}
