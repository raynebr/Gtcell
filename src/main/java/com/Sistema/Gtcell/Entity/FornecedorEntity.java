package com.Sistema.Gtcell.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name =  "tb_fornecedor")
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "Razao_Social")
    private String razaoSocial;
    @Column(length = 18,unique = true)
    private String cnpj;
    @Column(length = 150)
    private String email;
    @Column(length = 20)
    private String telefone;
}
