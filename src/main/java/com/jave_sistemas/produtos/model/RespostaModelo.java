package com.jave_sistemas.produtos.model;


import org.springframework.stereotype.Component;

@Component // pode fazer injeção de dempendencia
public class RespostaModelo {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
