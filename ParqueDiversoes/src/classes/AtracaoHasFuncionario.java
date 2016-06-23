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
public class AtracaoHasFuncionario {
    private int idAtracao;
    private int idFuncionario;
    private Date dataInicio;

    public AtracaoHasFuncionario(int idAtracao, int idFuncionario, Date dataInicio) {
        this.idAtracao = idAtracao;
        this.idFuncionario = idFuncionario;
        this.dataInicio = dataInicio;
    }

    public AtracaoHasFuncionario() {
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(int idAtracao) {
        this.idAtracao = idAtracao;
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
        return "AtracaoHasFuncionario{" + "idAtracao=" + idAtracao + ", idFuncionario=" + idFuncionario + ", dataInicio=" + dataInicio + '}';
    }
    
    
}
