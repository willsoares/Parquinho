/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Date;

/**
 *
 * @author will
 */
public class LojaHasFuncionario {
    private int idLoja;
    private int idFuncionario;
    private Date dataInicio;

    public LojaHasFuncionario(int idLoja, int idFuncionario, Date dataInicio) {
        this.idLoja = idLoja;
        this.idFuncionario = idFuncionario;
        this.dataInicio = dataInicio;
    }

    public LojaHasFuncionario() {
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "LojaHasFuncionario{" + "idLoja=" + idLoja + ", idFuncionario=" + idFuncionario + ", dataInicio=" + dataInicio + '}';
    }
    
    
    
    
}
