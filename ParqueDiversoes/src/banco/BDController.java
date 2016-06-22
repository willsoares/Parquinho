/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import classes.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        conn.executaSQL(query);
        conn.fechaConexao();

    }

    public Funcionario selectFuncionarioById(int id) throws ClassNotFoundException, SQLException {
        String query;
        this.conn = ConexaoBD.getInstance();

        query = "SELECT * FROM Funcionario WHERE idFuncionario = " + id;
        ResultSet r = conn.executaSQL(query);

        Funcionario f = new Funcionario();
        f.setIdFuncionario(r.getInt("idFuncionario"));
        f.setNome(r.getString("nome"));
        f.setSobrenome(r.getString("sobrenome"));
        f.setCargo(r.getString("cargo"));
        f.setSalario(r.getInt("salario"));
        f.setSexo(r.getString("sexo"));
        f.setIdGerente(r.getInt("idGerente"));

        conn.fechaConexao();

        return f;
    }

    public Funcionario selectFuncionarioByCpf(String cpf) {
        return null;
    }

    //</editor-fold>
}
