package model;

public class Cliente {
    protected int id;
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String cidade;
    protected String estado;

    public Cliente (int id, String nome, String cpf, String endereco, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cliente () {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId() {
        return id = id;
    }

    public String getNome() {
        return nome = nome;
    }

    public String getCpf() {
        return cpf = cpf;
    }

    public String getEndereco() {
        return endereco = endereco;
    }

    public String getCidade() {
        return cidade = cidade;
    }

    public String getEstado() {
        return estado = estado;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


