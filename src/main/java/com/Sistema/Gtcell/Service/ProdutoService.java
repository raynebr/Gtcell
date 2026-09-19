package com.Sistema.Gtcell.Service;


import com.Sistema.Gtcell.Dto.Request.ProdutoRequest;
import com.Sistema.Gtcell.Dto.Response.ProdutoResponse;
import com.Sistema.Gtcell.Entity.ProdutoEntity;
import com.Sistema.Gtcell.Exception.ProdutoJaCadastrado;
import com.Sistema.Gtcell.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity cadastrarProduto(ProdutoEntity produto) {

        if (produtoRepository.existsBycodigo(produto.getCodigo())) {
            throw new ProdutoJaCadastrado("Este produto ja esta cadastrado");
        }

        return produtoRepository.save(produto);
    }
}
