/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author will
 */
public class Loja {

    private int idLoja;
    private String categoria;
    private String nome;
    private String local;
    private ArrayList<Estoque> estoque;

    public Loja() {

    }

    public Loja(int idLoja, String categoria, String nome, String local) {
        this.idLoja = idLoja;
        this.categoria = categoria;
        this.nome = nome;
        this.local = local;
    }

    public Loja(String categoria, String nome, String local) {
        this.categoria = categoria;
        this.nome = nome;
        this.local = local;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Loja " + idLoja + "\nCategoria: " + categoria + "\nNome: " + nome + "\nLocal: " + local + "\n\n";
    }
}
