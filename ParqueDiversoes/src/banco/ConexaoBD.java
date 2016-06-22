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
    private PreparedStatement preparedStatement;

    public ConexaoBD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = (Connection) DriverManager.getConnection("jdbc:www2.bcc.unifal-mg.edu.br", "a14034", "a14034");
    }

    public ResultSet sqlQuery(String query) throws SQLException {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
        
        return preparedStatement.getResultSet();
    }

}
