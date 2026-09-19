package com.Sistema.Gtcell.Entity;
import com.Sistema.Gtcell.Enum.CargoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_funcionario")
public class FuncionarioEntity extends UsuarioEntity {

    @Column(length = 20)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private CargoEnum cargoEnum;
}