package model;

import java.time.LocalDateTime;

public class HistoricoEntrega {
    private int id;
    private int entregaId;
    private LocalDateTime dataEvento;
    private String descricao;

    public HistoricoEntrega(int id, int entregaId, LocalDateTime dataEvento, String descricao) {
        this.id = id;
        this.entregaId = entregaId;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public int getEntregaId() {
        return entregaId;
    }

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEntregaId(int entregaId) {
        this.entregaId = entregaId;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
