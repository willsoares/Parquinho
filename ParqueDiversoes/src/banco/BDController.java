/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import classes.Atracao;
import classes.Funcionario;
import classes.Loja;
import classes.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author will
 */
public class BDController {

    private ConexaoBD conn;
    public static BDController instance;
    
    public static BDController getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new BDController();
        }
        
        return instance;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Funcionario">
    
    public void insereFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {
        String n, sn, cg, cpf, sx;
        int idG;
        double sl;
        n = f.getNome();
        sn = f.getSobrenome();
        sl = f.getSalario();
        cg = f.getCargo();
        cpf = f.getCpf();
        sx = f.getSexo();
        idG = f.getIdGerente();

        String query = "INSERT INTO Funcionario (nome, sobrenome, salario, cargo, cpf, sexo, idGerente) values "
                + "('" + n + "', '" + sn + "', '" + sl + "', '" + cg + "', '" + cpf + "', '" + sx + "', '" + idG + "');";
        this.conn = ConexaoBD.getInstance();
        conn.executaSQL(query);
        conn.fechaConexao();

    }
    
    public Funcionario selectFuncionarioById(int id) throws ClassNotFoundException, SQLException {
        String query;
        this.conn = ConexaoBD.getInstance();

        query = "SELECT * FROM Funcionario WHERE idFuncionario = " + id;
        ResultSet r = conn.executaSQL(query);
        r.next();

        r.next();
        
        Funcionario f = new Funcionario();
        f.setIdFuncionario(Integer.parseInt(r.getString("idFuncionario")));
        f.setNome(r.getString("nome"));
        f.setSobrenome(r.getString("sobrenome"));
        f.setCargo(r.getString("cargo"));
        f.setSalario(r.getDouble("salario"));
        f.setSexo(r.getString("sexo"));
        f.setCpf(r.getString("cpf"));
        f.setIdGerente(r.getInt("idGerente"));

        conn.fechaConexao();

        return f;
    }

    public Funcionario selectFuncionarioByCpf(String cpf) throws ClassNotFoundException, SQLException {
        String query;
        this.conn = ConexaoBD.getInstance();

        query = "SELECT * FROM Funcionario WHERE idFuncionario like " + cpf;
        ResultSet r = conn.executaSQL(query);
        r.next();
        
        Funcionario f = new Funcionario();
        f.setIdFuncionario(r.getInt("idFuncionario"));
        f.setNome(r.getString("nome"));
        f.setSobrenome(r.getString("sobrenome"));
        f.setCargo(r.getString("cargo"));
        f.setSalario(r.getInt("salario"));
        f.setSexo(r.getString("sexo"));
        f.setCpf(r.getString("cpf"));
        f.setIdGerente(r.getInt("idGerente"));


        conn.fechaConexao();

        return f;
    }
    
    public void removeFuncionario(int id) throws ClassNotFoundException, SQLException{
        this.conn = ConexaoBD.getInstance();
        
        String query = "DELETE FROM Funcionario WHERE idFuncionario = '"+id+"'";
        this.conn.executaSQL(query);
        this.conn.fechaConexao();
    }
    
    public ArrayList selectAllFuncionario() throws ClassNotFoundException, SQLException{
        this.conn = ConexaoBD.getInstance();

        ArrayList<Funcionario> funcionarios = new ArrayList();
        String query = "SELECT * FROM Funcionario";
        ResultSet r = this.conn.executaSQL(query);
        
        while(r.next()){
            Funcionario f = new Funcionario();
            f.setIdFuncionario(r.getInt("idFuncionario"));
            f.setNome(r.getString("nome"));
            f.setSobrenome(r.getString("sobrenome"));
            f.setCargo(r.getString("cargo"));
            f.setSalario(r.getInt("salario"));
            f.setSexo(r.getString("sexo"));
            f.setCpf(r.getString("cpf"));
            f.setIdGerente(r.getInt("idGerente"));
            funcionarios.add(f);
        }
        
        return funcionarios;
    }
    
    public void atualizaFuncionario(Funcionario f) throws ClassNotFoundException, SQLException{
        this.conn = ConexaoBD.getInstance();
        
        String query = "UPDATE Funcionario SET "
                + "nome = '"+f.getNome()+"', "
                + "sobrenome = '"+f.getSobrenome()+"', "
                + "cargo = '"+f.getCargo()+"', "
                + "salario = '"+f.getSalario()+"', "
                + "cpf = '"+f.getCpf()+"', "
                + "idGerente = '"+f.getIdGerente()+"', "
                + "sexo = '"+f.getSexo()+"', "
                + " WHERE idFuncionario = '"+f.getIdFuncionario()+"'";
        
        conn.executaSQL(query);
        conn.fechaConexao();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Loja">
    public void insereLoja(Loja l) throws ClassNotFoundException, SQLException {
        String categoria, nome, local;

        categoria = l.getCategoria();
        nome = l.getNome();
        local = l.getLocal();

        String query = "INSERT INTO Loja(categoria, nome, local) values "
                + "('" + categoria + "', '" + nome + "', '" + local + "');";

        this.conn = ConexaoBD.getInstance();
        conn.executaSQL(query);
        conn.fechaConexao();
    }
    
    public ArrayList<Loja> selectAllLoja() throws ClassNotFoundException, SQLException{
        this.conn = ConexaoBD.getInstance();

        ArrayList<Loja> lojas = new ArrayList();
        String query = "SELECT * FROM Loja";
        ResultSet r = this.conn.executaSQL(query);
        
        while(r.next()){
            Loja l = new Loja();
            l.setCategoria(r.getString("categoria"));
            l.setIdLoja(r.getInt("idLoja"));
            l.setLocal(r.getString("local"));
            l.setNome(r.getString("nome"));
            lojas.add(l);
        }
        
        return lojas;
    }
    
    

    public void insereProduto(Produto p) throws ClassNotFoundException, SQLException {
        String nome, marca, tipo;
        double preco;

        nome = p.getNome();
        marca = p.getMarca();
        tipo = p.getTipo();
        preco = p.getPreco();

        String query = "INSERT INTO Produto(nome, marca, tipo, preco) values "
                + "('" + nome + "', '" + marca + "', '" + tipo + "', '" + preco + "');";

        this.conn = ConexaoBD.getInstance();
        conn.executaSQL(query);
        conn.fechaConexao();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Atração">
    
    public void insereAtracao(Atracao a) throws ClassNotFoundException, SQLException {
        String nome, tipo;
        Date dataManutencao;
        int status;

        nome = a.getNome();
        tipo = a.getTipo();
        dataManutencao = a.getDataManutencao();
        status = a.getStatus();

        String query = "INSERT INTO Atracao(nome, tipo, dataManutencao, status) values "
                + "('" + nome + "', '" + tipo + "', '" + dataManutencao + "', '" + status + "');";

        this.conn = ConexaoBD.getInstance();
        conn.executaSQL(query);
        conn.fechaConexao();
    }
    //</editor-fold>

}
