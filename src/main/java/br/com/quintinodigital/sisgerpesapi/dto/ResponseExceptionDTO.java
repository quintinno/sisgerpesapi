package br.com.quintinodigital.sisgerpesapi.dto;

import java.util.Date;

public class ResponseExceptionDTO {

    private Date data;

    private String mensagem;

    private int situacao;

    public ResponseExceptionDTO() { }

    public ResponseExceptionDTO(String mensagem, int situacao) {
        this.data = new Date();
        this.mensagem = mensagem;
        this.situacao = situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

}
