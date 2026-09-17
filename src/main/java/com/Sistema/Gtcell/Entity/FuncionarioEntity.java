package com.Sistema.Gtcell.Entity;

import com.Sistema.Gtcell.Enum.CargoEnum;
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
@Table(name = "tb_Funcionario")
public class FuncionarioEntity extends UsuarioEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 150)
    private String nome;
    @Column(length = 20)
    private String telefone;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private CargoEnum cargoEnum;
    @JoinColumn(unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UsuarioEntity usuario;
}
