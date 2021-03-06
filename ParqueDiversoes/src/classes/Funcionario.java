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
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String sobrenome;
    private double salario;
    private String cargo;
    private String cpf;
    private String sexo;
    private int idGerente;

    
    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public Funcionario(int idFuncionario, String nome, String sobrenome, double salario, String cargo, String cpf, String sexo, int idGerente){
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.cargo = cargo;
        this.cpf = cpf;
        this.sexo = sexo;
        this.idGerente = idGerente;
    }

    public Funcionario(String nome, String sobrenome, double salario, String cargo, String cpf, String sexo, int idGerente) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.cargo = cargo;
        this.cpf = cpf;
        this.sexo = sexo;
        this.idGerente = idGerente;
    }

    public Funcionario() {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }
    
    public String getNomeCompleto(){
        return this.nome+" "+this.sobrenome;
    }
    
    //</editor-fold>
    
    @Override
    public String toString(){
        String s ="\nFuncionario "+idFuncionario+"\n"
                + "Nome: "+getNomeCompleto()+"\n"
                + "CPF: "+cpf+"\n"
                + "Salario: R$: "+salario+"  |  Cargo: "+cargo+"\n"
                + "Sexo: "+sexo+"\n"
                + "Gerente: "+idGerente+"\n";
        return s;
    }

}
