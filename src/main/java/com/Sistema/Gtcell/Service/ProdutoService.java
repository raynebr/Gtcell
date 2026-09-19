package com.Sistema.Gtcell.Service;

import com.Sistema.Gtcell.Entity.CategoriaEntity;
import com.Sistema.Gtcell.Entity.ProdutoEntity;
import com.Sistema.Gtcell.Exception.CategoriaNaoEncontrada;
import com.Sistema.Gtcell.Exception.ProdutoJaCadastrado;
import com.Sistema.Gtcell.Repository.CategoriaRepository;
import com.Sistema.Gtcell.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;

    public ProdutoService(
            CategoriaRepository categoriaRepository,
            ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoEntity cadastrarProduto(
            ProdutoEntity produto,
            String categoriaNome) {

        if (produtoRepository.existsByNome(produto.getNome())) {
            throw new ProdutoJaCadastrado("Produto já existe!");
        }

        CategoriaEntity categoria = categoriaRepository
                .findByNome(categoriaNome)
                .orElseThrow(() ->
                        new CategoriaNaoEncontrada("Categoria não encontrada")
                );

        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }
}