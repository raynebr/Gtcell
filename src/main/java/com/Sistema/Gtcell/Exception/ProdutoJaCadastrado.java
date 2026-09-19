package com.Sistema.Gtcell.Exception;

public class ProdutoJaCadastrado extends RuntimeException {
    public ProdutoJaCadastrado(String message) {
        super(message);
    }
    public ProdutoJaCadastrado(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
