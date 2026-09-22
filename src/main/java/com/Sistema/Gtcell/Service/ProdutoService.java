package com.Sistema.Gtcell.Service;

import com.Sistema.Gtcell.Entity.CategoriaEntity;
import com.Sistema.Gtcell.Entity.ProdutoEntity;
import com.Sistema.Gtcell.Exception.CategoriaNaoEncontrada;
import com.Sistema.Gtcell.Exception.ProdutoJaCadastrado;
import com.Sistema.Gtcell.Exception.ProdutoNaoEncontrado;
import com.Sistema.Gtcell.Repository.CategoriaRepository;
import com.Sistema.Gtcell.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service      //cria a classe do service
public class ProdutoService {

    //define duas costantes que serao usadas
    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;

    //cria os construtores
    public ProdutoService(
            CategoriaRepository categoriaRepository,
            ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }
    //cria o metodo de cadastrar produto
    public ProdutoEntity cadastrarProduto(
            //passa os parametros
            ProdutoEntity produto,
            String categoriaNome) {

        //se produto existir lança exception
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

    public List<ProdutoEntity> listar(){
        return produtoRepository.findAll();
    }

    public  ProdutoEntity buscarPorId(Long id){
        return produtoRepository.findByid(id)
                .orElseThrow(()->
                new ProdutoNaoEncontrado("Produto Não Encontrado"));

    }

}