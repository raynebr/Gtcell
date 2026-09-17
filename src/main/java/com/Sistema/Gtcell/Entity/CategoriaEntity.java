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
@Table(name = "tb_categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="categoria_id")
    private UUID id;
    @Column(unique = true, length = 100)
    private String nome;
}
