/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hugo
 */
public class ConexaoBD {

    private Connection connection;
    public static ConexaoBD instance;
    
    public static ConexaoBD getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new ConexaoBD();
        }
        
        return instance;
    }
    
    public ConexaoBD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://www2.bcc.unifal-mg.edu.br:3306/a14034", "a14034", "a14034");
    }

    public ResultSet executaSQL(String query) throws SQLException {
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        preparedStatement.execute(query);
        
        return preparedStatement.getResultSet();
    }
    
    public void fechaConexao() throws SQLException {
        this.connection.close();
    }

}
