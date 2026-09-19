package com.Sistema.Gtcell.Service;


import com.Sistema.Gtcell.Entity.CategoriaEntity;
import com.Sistema.Gtcell.Exception.CategoriaJaCadastrada;
import com.Sistema.Gtcell.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Cadastrar
    public CategoriaEntity cadastrar(CategoriaEntity categoria) {

        if (categoriaRepository.existsByNome(categoria.getNome())) {
            throw new CategoriaJaCadastrada("Categoria já cadastrada");
        }

        return categoriaRepository.save(categoria);
    }

    // Listar
    public List<CategoriaEntity> listar() {

        return categoriaRepository.findAll();
    }

    // Buscar por ID
    public CategoriaEntity buscarPorId(UUID id) {

        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não encontrada"));
    }

    // Atualizar
    public CategoriaEntity atualizar(UUID id, CategoriaEntity categoria) {

        CategoriaEntity categoriaExistente = buscarPorId(id);

        if (categoriaRepository.existsByNome(categoria.getNome())
                && !categoriaExistente.getNome().equals(categoria.getNome())) {

            throw new IllegalArgumentException(
                    "Já existe uma categoria com esse nome"
            );
        }

        categoriaExistente.setNome(categoria.getNome());

        return categoriaRepository.save(categoriaExistente);
    }

    // Excluir
    public void excluir(UUID id) {

        CategoriaEntity categoria = buscarPorId(id);

        categoriaRepository.delete(categoria);
    }
}