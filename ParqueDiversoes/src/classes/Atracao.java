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
public class Atracao {
    private int idAtracao;
    private String nome;
    private String tipo;
    private Date dataManutencao;
    private int status;

    public Atracao(int idAtracao, String nome, String tipo, Date dataManutencao, int status) {
        this.idAtracao = idAtracao;
        this.nome = nome;
        this.tipo = tipo;
        this.dataManutencao = dataManutencao;
        this.status = status;
    }

    public Atracao(String nome, String tipo, Date dataManutencao, int status) {
        this.nome = nome;
        this.tipo = tipo;
        this.dataManutencao = dataManutencao;
        this.status = status;
    }

    public Atracao() {
    }
    
    

    public int getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(int idAtracao) {
        this.idAtracao = idAtracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(Date dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Atracao{" + "idAtracao=" + idAtracao + ", nome=" + nome + ", tipo=" + tipo + ", dataManutencao=" + dataManutencao + ", status=" + status + '}';
    }
    
    
    
}
