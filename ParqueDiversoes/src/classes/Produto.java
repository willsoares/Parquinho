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
public class Produto {
    private int idProduto;
    private String nome;
    private String marca;
    private String tipo;
    private double preco;

    public Produto(int idProduto, String nome, String marca, String tipo, double preco) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.preco = preco;
    }

    public Produto(String nome, String marca, String tipo, double preco) {
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
