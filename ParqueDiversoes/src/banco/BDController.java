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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author will
 */
public class BDController {

    private ConexaoBD conn;

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
        this.conn.executaSQL(query);
        this.conn.fechaConexao();

    }

    public Funcionario selectFuncionarioById(int id) throws ClassNotFoundException, SQLException {
        String query;
        this.conn = ConexaoBD.getInstance();

        query = "SELECT * FROM Funcionario WHERE idFuncionario = " + id;
        ResultSet r = this.conn.executaSQL(query);

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

        this.conn.fechaConexao();

        return f;
    }

    public Funcionario selectFuncionarioByCpf(String cpf) throws ClassNotFoundException, SQLException {
        String query;
        this.conn = ConexaoBD.getInstance();

        query = "SELECT * FROM Funcionario WHERE idFuncionario like " + cpf;
        ResultSet r = this.conn.executaSQL(query);
        this.conn.fechaConexao();

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

        return f;
    }

    public void removeFuncionario(int id) throws ClassNotFoundException, SQLException {
        this.conn = ConexaoBD.getInstance();

        String query = "DELETE FROM Funcionario WHERE idFuncionario = '" + id + "'";
        this.conn.executaSQL(query);
        this.conn.fechaConexao();
    }

    public ArrayList selectAllFuncionario() throws ClassNotFoundException, SQLException {
        this.conn = ConexaoBD.getInstance();

        ArrayList<Funcionario> funcionarios = new ArrayList();
        String query = "SELECT * FROM Funcionario";
        ResultSet r = this.conn.executaSQL(query);

        while (r.next()) {
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

        this.conn.fechaConexao();

        return funcionarios;
    }

    public void atualizaFuncionario(Funcionario f) throws ClassNotFoundException, SQLException {

        String query = "UPDATE Funcionario SET "
                + "nome = '" + f.getNome() + "', "
                + "sobrenome = '" + f.getSobrenome() + "', "
                + "cargo = '" + f.getCargo() + "', "
                + "salario = '" + f.getSalario() + "', "
                + "cpf = '" + f.getCpf() + "', "
                + "idGerente = '" + f.getIdGerente() + "', "
                + "sexo = '" + f.getSexo() + "' "
                + "WHERE idFuncionario = '" + f.getIdFuncionario() + "'";

        this.conn = new ConexaoBD();
        this.conn.executaSQL(query);
        this.conn.fechaConexao();
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

        this.conn = new ConexaoBD();
        conn.executaSQL(query);
        conn.fechaConexao();
    }

    public ArrayList<Loja> selectAllLoja() throws ClassNotFoundException, SQLException {
        this.conn = ConexaoBD.getInstance();

        ArrayList<Loja> lojas = new ArrayList();
        String query = "SELECT * FROM Loja";
        ResultSet r = this.conn.executaSQL(query);

        while (r.next()) {
            Loja l = new Loja();
            l.setCategoria(r.getString("categoria"));
            l.setIdLoja(r.getInt("idLoja"));
            l.setLocal(r.getString("local"));
            l.setNome(r.getString("nome"));
            lojas.add(l);
        }
        return lojas;
    }

    public Loja selectLoja(int id) throws ClassNotFoundException, SQLException {
        String query;
        this.conn = ConexaoBD.getInstance();

        query = "SELECT * FROM Loja WHERE idLoja = " + id;
        ResultSet r = conn.executaSQL(query);
        r.next();

        Loja l = new Loja();
        l.setCategoria(r.getString("categoria"));
        l.setIdLoja(r.getInt("idLoja"));
        l.setLocal(r.getString("local"));
        l.setNome(r.getString("nome"));

        conn.fechaConexao();
        return l;
    }

    public void atualizaLoja(Loja l) throws ClassNotFoundException, SQLException {

        String query = "UPDATE Loja SET "
                + "nome = '" + l.getNome() + "', "
                + "categoria = '" + l.getCategoria() + "', "
                + "local = '" + l.getLocal() + "' "
                + " WHERE idLoja = '" + l.getIdLoja() + "'";

        this.conn = new ConexaoBD();
        conn.executaSQL(query);
        conn.fechaConexao();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Produto">
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

    public ArrayList<Produto> selectAllProduto() throws ClassNotFoundException, SQLException {
        this.conn = ConexaoBD.getInstance();

        ArrayList<Produto> produtos = new ArrayList();
        String query = "SELECT * FROM Produto";
        ResultSet r = this.conn.executaSQL(query);

        while (r.next()) {
            Produto p = new Produto();
            p.setIdProduto(r.getInt("idProduto"));
            p.setMarca(r.getString("marca"));
            p.setNome(r.getString("nome"));
            p.setPreco(r.getDouble("preco"));
            p.setTipo(r.getString("tipo"));
            produtos.add(p);
        }
        conn.fechaConexao();
        return produtos;

    }

    public Produto selectProduto(int id) throws ClassNotFoundException, SQLException {
        this.conn = ConexaoBD.getInstance();

        String query = "SELECT * FROM Produto WHERE idProduto = '" + id + "';";
        ResultSet r = this.conn.executaSQL(query);
        r.next();

        Produto p = new Produto();
        p.setIdProduto(r.getInt("idProduto"));
        p.setMarca(r.getString("marca"));
        p.setNome(r.getString("nome"));
        p.setPreco(r.getDouble("preco"));
        p.setTipo(r.getString("tipo"));

        conn.fechaConexao();
        return p;
    }

    public void atualizaProduto(Produto p) throws ClassNotFoundException, SQLException {

        String query = "UPDATE Produto SET "
                + "nome = '" + p.getNome() + "', "
                + "marca = '" + p.getMarca() + "', "
                + "preco = '" + p.getPreco() + "', "
                + "tipo = '" + p.getTipo() + "'"
                + " WHERE idProduto = '"
                + p.getIdProduto() + "'";

        this.conn = new ConexaoBD();
        conn.executaSQL(query);
        conn.fechaConexao();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Atração">
    public void insereAtracao(Atracao a) throws ClassNotFoundException, SQLException {
        String nome, tipo;
        Date date;
        int status;

        nome = a.getNome();
        date = a.getDataManutencao();
        tipo = a.getTipo();
        status = a.getStatus();

        String query = "INSERT INTO Produto(nome, dataManutencao, tipo, status) values "
                + "('" + nome + "', '" + date + "', '" + tipo + "', '" + status + "');";

        this.conn = ConexaoBD.getInstance();
        conn.executaSQL(query);
        conn.fechaConexao();
    }

    public ArrayList<Atracao> selectAllAtracao() throws ClassNotFoundException, SQLException {
        this.conn = ConexaoBD.getInstance();

        ArrayList<Atracao> atracoes = new ArrayList();
        String query = "SELECT * FROM Atracao";
        ResultSet r = this.conn.executaSQL(query);

        while (r.next()) {
            Atracao a = new Atracao();
            a.setIdAtracao(r.getInt("idAtracao"));
            a.setDataManutencao(r.getDate("dataManutencao"));
            a.setNome(r.getString("nome"));
            a.setStatus(r.getInt("status"));
            a.setTipo(r.getString("tipo"));
            atracoes.add(a);
        }
        conn.fechaConexao();
        return atracoes;
    }

    public Atracao selectAtracao(int id) throws ClassNotFoundException, SQLException {
        this.conn = ConexaoBD.getInstance();

        String query = "SELECT * FROM Atracao WHERE idAtracao = '" + id + "';";
        ResultSet r = this.conn.executaSQL(query);
        r.next();

        Atracao a = new Atracao();
        a.setIdAtracao(r.getInt("idAtracao"));
        a.setDataManutencao(r.getDate("dataManutencao"));
        a.setNome(r.getString("nome"));
        a.setStatus(r.getInt("status"));
        a.setTipo(r.getString("tipo"));

        conn.fechaConexao();
        return a;
    }

    public void atualizaAtracao(Atracao a) throws ClassNotFoundException, SQLException {
        String query = "UPDATE Atracao SET "
                + "nome = '" + a.getNome() + "', "
                + "tipo = '" + a.getTipo() + "', "
                + "dataManutencao = '" + a.getDataManutencao() + "', "
                + "status = '" + a.getStatus()+ "' "
                + "WHERE idAtracao = '" + a.getIdAtracao() + "'";

        this.conn = new ConexaoBD();
        conn.executaSQL(query);
        conn.fechaConexao();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Funcionario_Loja">
<<<<<<< HEAD
    public void adicionaFuncionarioLoja(Funcionario f, Loja l) throws ClassNotFoundException, SQLException{
        int idLoja = l.getIdLoja();
        int idFuncionario = f.getIdFuncionario();
        Date dataInicio = Date.from(Instant.now());
        
        String query = "INSERT INTO Loja_has_Funcionario(idLoja, idFuncionario, dataInicio) values "
                + "('" + idLoja + "', '" + idFuncionario + "', '" + dataInicio + "');";
        
        this.conn = ConexaoBD.getInstance();
        conn.executaSQL(query);
        conn.fechaConexao();
    }
    
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Estoque">
    public void adicionaEstoque(Loja l, Produto p, double q) throws ClassNotFoundException, SQLException{
        int idLoja = l.getIdLoja();
        int idProduto = p.getIdProduto();
        
        String query = "INSERT INTO Estoque(idLoja, idProduto, quantidade) values "
                + "('" + idLoja + "', '" + idProduto + "', '" + q + "');";
        
        this.conn = ConexaoBD.getInstance();
        conn.executaSQL(query);
        conn.fechaConexao();
    }
    
    //</editor-fold>

    
}
