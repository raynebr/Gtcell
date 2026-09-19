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
@Table(name = "tb_cliente")
public class ClienteEntity extends UsuarioEntity {

    @Column(length = 150)
    private String nome;

    @Column(length = 20)
    private String telefone;

    @Column(length = 18, unique = true)
    private String cpf;
}