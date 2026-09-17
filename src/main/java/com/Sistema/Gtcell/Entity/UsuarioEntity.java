package com.Sistema.Gtcell.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.util.UUID;

@Entity
@Getter
@Setter
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String senha;
}
