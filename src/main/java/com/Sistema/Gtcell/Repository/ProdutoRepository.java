package com.Sistema.Gtcell.Repository;

import com.Sistema.Gtcell.Entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

   boolean existsByNome(String nome);
}
