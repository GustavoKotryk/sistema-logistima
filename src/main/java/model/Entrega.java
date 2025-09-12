package model;

import java.time.LocalDateTime;

public class Entrega {
    private int id;
    private int pedidoId;
    private int motoristaId;
    private LocalDateTime dataSaida;
    private LocalDateTime dataEntrega;
    private String status;

    public Entrega(int id, int pedidoId, int motoristaId,
                   LocalDateTime dataSaida, LocalDateTime dataEntrega,
                   String status) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.motoristaId = motoristaId;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public int getMotoristaId() {
        return motoristaId;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public void setMotoristaId(int motoristaId) {
        this.motoristaId = motoristaId;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
