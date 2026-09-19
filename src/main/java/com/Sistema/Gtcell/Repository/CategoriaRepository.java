package com.Sistema.Gtcell.Repository;

import com.Sistema.Gtcell.Entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, UUID> {

    boolean existsByNome(String nome);
    Optional<CategoriaEntity> findByNome(String nome);

}
