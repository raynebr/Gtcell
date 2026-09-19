package com.Sistema.Gtcell.Controller;

import com.Sistema.Gtcell.Dto.Request.ProdutoRequest;
import com.Sistema.Gtcell.Dto.Response.ProdutoResponse;
import com.Sistema.Gtcell.Entity.ProdutoEntity;
import com.Sistema.Gtcell.Service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }
    //cadastrar produto
    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(
            @RequestBody ProdutoRequest request) {

        ProdutoEntity produto = new ProdutoEntity();

        produto.setNome(request.nome());
        produto.setPrecoCompra(request.precoCompra());
        produto.setPrecoVenda(request.precoVenda());

        ProdutoEntity produtoSalvo =
                produtoService.cadastrarProduto(
                        produto,
                        request.categoriaNome()
                );

        ProdutoResponse response = new ProdutoResponse(
                produtoSalvo.getId(),
                produtoSalvo.getNome(),
                produtoSalvo.getPrecoCompra(),
                produtoSalvo.getPrecoVenda(),
                produtoSalvo.getCategoria()
        );

        return ResponseEntity.ok(response);
    }
}
