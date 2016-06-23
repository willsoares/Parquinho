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
public class Venda {
    private int idVenda;
    private int idFuncionario;
    private int idLoja;
    private ArrayList<ItemVenda> itensVenda;

    
    
    
    @Override
    public String toString() {
        return "Venda{" + "idVenda=" + idVenda + ", idFuncionario=" + idFuncionario + ", idLoja=" + idLoja + ", itensVenda=" + itensVenda + '}';
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public Venda() {
    }
    
    
    
}
