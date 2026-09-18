package com.Sistema.Gtcell.Repository;

import com.Sistema.Gtcell.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
}
