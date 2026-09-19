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
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    // Construtor: recebe o ProdutoService e guarda na variável
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Cadastrar produto
    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrar(
            @RequestBody ProdutoRequest request) {

        // Cria a entidade
        ProdutoEntity produto = new ProdutoEntity();

        // Pega os dados do DTO e coloca na entidade
        produto.setNome(request.nome());
        produto.setCodigo(request.codigo());
        produto.setDescricao(request.descricao());
        produto.setPrecoCompra(request.precoCompra());
        produto.setPrecoVenda(request.precoVenda());
        produto.setQtdEstoque(request.qtdEstoque());

        // Envia a entidade para o Service salvar
        ProdutoEntity produtoSalvo =
                produtoService.cadastrarProduto(produto);

        // Converte a entidade salva para Response DTO
        ProdutoResponse response = new ProdutoResponse(
                produtoSalvo.getId(),
                produtoSalvo.getNome(),
                produtoSalvo.getDescricao(),
                produtoSalvo.getPrecoCompra(),
                produtoSalvo.getPrecoVenda(),
                produtoSalvo.getQtdEstoque(),
                produtoSalvo.getCodigo()
        );

        // Retorna HTTP 200 + produto
        return ResponseEntity.ok(response);
    }
}