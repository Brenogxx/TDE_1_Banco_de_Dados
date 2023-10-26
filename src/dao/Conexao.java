package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection estabelecerConexao() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/escola";
        String user = "postgres";
        String password = "123";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexão estabelecida!");

        return connection;

    }

    public static void encerrarConexao(Connection connection) throws SQLException {
        connection.close();
    }

}
