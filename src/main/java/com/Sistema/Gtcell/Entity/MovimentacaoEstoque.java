package com.Sistema.Gtcell.Entity;

import com.Sistema.Gtcell.Enum.TipoMovimentacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Audited;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_movimentacaoEstoque")
public class MovimentacaoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;
    private int quantidade;
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime data;
    @JoinColumn(name = "funcionario_id")
    @OneToOne
    private FuncionarioEntity funcionario;
}
