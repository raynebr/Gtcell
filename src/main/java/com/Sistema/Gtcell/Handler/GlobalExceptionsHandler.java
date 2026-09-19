package com.Sistema.Gtcell.Handler;


import com.Sistema.Gtcell.Exception.CategoriaJaCadastrada;

import com.Sistema.Gtcell.Exception.ProdutoJaCadastrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(CategoriaJaCadastrada.class)
    public ResponseEntity<ErroResposta> tratarCategoriaJaCadastrada(
            CategoriaJaCadastrada ex) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Categoria já Cadastrada",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }

    @ExceptionHandler(ProdutoJaCadastrado.class)
    public ResponseEntity<ErroResposta> tratarProdutoJaCadastrado(
            ProdutoJaCadastrado ex) {
        ErroResposta erro = new ErroResposta(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Produto Já Cadastrado",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }
}
