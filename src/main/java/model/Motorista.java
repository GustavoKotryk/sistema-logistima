package model;

public class Motorista {
    protected int id_motorista;
    protected String nome;
    protected String cnh;
    protected String veiculo;
    protected String cidade_base;

    public Motorista(int id_motorista, String nome, String cnh, String veiculo, String cidade_base) {
        this.id_motorista = id_motorista;
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidade_base = cidade_base;
    }

    public Motorista() { }


    public int getId_motorista() {return id_motorista = id_motorista;}
    public String getNome() {return nome = nome;}
    public String getCnh() {return cnh = cnh;}
    public String getVeiculo() {return veiculo = veiculo;}
    public String getCidade_base() {return cidade_base = cidade_base;}

    public void setId_motorista(int id_motorista) {this.id_motorista = id_motorista;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCnh(String cnh) {this.cnh = cnh;}
    public void setVeiculo(String veiculo) {this.veiculo = veiculo;}
    public void setCidade_base(String cidade_base) {this.cidade_base = cidade_base;}
}
