package com.Sistema.Gtcell.Service;

import com.Sistema.Gtcell.Entity.ProdutoEntity;
import com.Sistema.Gtcell.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private  final ProdutoRepository produto;

    public ProdutoService(ProdutoRepository produto){
        this.produto = produto;
    }

}
