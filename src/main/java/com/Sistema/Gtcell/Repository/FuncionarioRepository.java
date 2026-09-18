package com.Sistema.Gtcell.Repository;

import com.Sistema.Gtcell.Entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, UUID> {
}
