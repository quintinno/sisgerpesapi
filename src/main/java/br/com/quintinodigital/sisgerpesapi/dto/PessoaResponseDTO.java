package br.com.quintinodigital.sisgerpesapi.dto;

import java.util.UUID;

public class PessoaResponseDTO {

    private UUID codigo;

    private String tipoPessoa;

    private String nome;

    public PessoaResponseDTO() { }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
