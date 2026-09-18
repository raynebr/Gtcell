package com.Sistema.Gtcell.Exception;

public class CategoriaJaCadastrada extends RuntimeException {
    public CategoriaJaCadastrada(String mensagem) {
        super(mensagem);
    }

    public CategoriaJaCadastrada(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
