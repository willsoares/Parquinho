/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author will
 */
public class ItemVenda {
    private int idVenda;
    private int idProduto;
    private double quantidade;

    public ItemVenda() {
    }

    public ItemVenda(int idVenda, int idProduto, double quantidade) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "idVenda=" + idVenda + ", idProduto=" + idProduto + ", quantidade=" + quantidade + '}';
    }

    

}


