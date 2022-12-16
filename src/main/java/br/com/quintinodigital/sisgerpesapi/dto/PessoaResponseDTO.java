package br.com.quintinodigital.sisgerpesapi.dto;

public class PessoaResponseDTO {

    private Long codigo;

    private String tipoPessoa;

    private String nome;

    public PessoaResponseDTO() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
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
