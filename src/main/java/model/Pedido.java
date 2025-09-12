package model;

import java.time.LocalDateTime;
import model.StatusPedido;


public class Pedido {
    private int id;
    private int clienteId;
    private LocalDateTime dataPedido;
    private double volumeM3;
    private double pesoKg;
    private StatusPedido status;

    public Pedido(int id, int clienteId, LocalDateTime dataPedido,
                  double volumeM3, double pesoKg, StatusPedido status) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public double getVolumeM3() {
        return volumeM3;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public StatusPedido getStatus() {
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setVolumeM3(double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
