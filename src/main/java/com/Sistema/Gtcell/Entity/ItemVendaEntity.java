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
@Table(name = "item_venda")
public class ItemVendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Vários itens podem estar relacionados ao mesmo produto
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    // Vários itens pertencem a uma única venda
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private VendaEntity venda;

    private int quantidade;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    private BigDecimal subTotal;
}