package Compra;

import java.util.Date;
import java.util.List;
public class Compra {
    private int identificador;
    private Date data;
    private double valorTotal;
    private String cpfCnpjCliente;
    private double totalPago;
    private List<ItemCompra> itensCompra;

    public Compra(int identificador, Date data, double valorTotal, String cpfCnpjCliente, double totalPago, List<ItemCompra> itensCompra) {
        this.identificador = identificador;
        this.data = data;
        this.valorTotal = valorTotal;
        this.cpfCnpjCliente = cpfCnpjCliente;
        this.totalPago = totalPago;
        this.itensCompra = itensCompra;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCpfCnpjCliente() {
        return cpfCnpjCliente;
    }

    public void setCpfCnpjCliente(String cpfCnpjCliente) {
        this.cpfCnpjCliente = cpfCnpjCliente;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public List<ItemCompra> getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(List<ItemCompra> itensCompra) {
        this.itensCompra = itensCompra;
    }
}
