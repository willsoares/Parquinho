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
public class Estoque {
    private int idLoja;
    private int idProduto;
    private double quantidade;

    
    public Estoque() {
    }

    public Estoque(int idLoja, int idProduto, double quantidade) {
        this.idLoja = idLoja;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }
    
    

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
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
        return "Estoque{" + "idLoja=" + idLoja + ", idProduto=" + idProduto + ", quantidade=" + quantidade + '}';
    }
    
    
}
