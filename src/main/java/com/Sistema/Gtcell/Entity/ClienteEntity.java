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
@Table(name = "cliente")
public class ClienteEntity extends UsuarioEntity{

    @Id
   @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
   @Column(length = 150)
    private String nome;
   @Column(length = 20)
    private String telefone;
   @Column(length = 18)
    private String cpf;

}
