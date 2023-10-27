package dao;

import java.sql.*;

public class DaoCurso {

    public static void inserirCurso(String codigo, String nome, String carga_horaria, Connection connection) throws SQLException {

        String insertSql = "INSERT INTO public.curso (codigo, nome, carga_horaria) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, codigo);
        preparedStatement.setString(2, nome);
        preparedStatement.setString(3, carga_horaria);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public static void mostrarCursos(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        String selectSql = "SELECT codigo, nome, carga_horaria FROM public.curso";
        ResultSet rs = stmt.executeQuery(selectSql);

        // Exibe os alunos.
        while (rs.next()) {
            String codigo = rs.getString("codigo");
            String nome = rs.getString("nome");
            String carga_horaria = rs.getString("carga_horaria");
            System.out.println("\nCódigo: " + codigo + ", Nome: " + nome + ", Carga Horária: " + carga_horaria);
        }

        rs.close();
        stmt.close();

    }

    public static void mostarAlunosdoCurso(Connection connection, String codigo_curso) throws SQLException{
        String selectSql = "SELECT matricula, nome FROM public.aluno WHERE codigo_curso = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setString(1,codigo_curso);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String matricula = rs.getString("matricula");
            String nome = rs.getString("nome");
            System.out.println("\nMatricula: " + matricula + ", Nome: " + nome);
        }

        rs.close();
        preparedStatement.close();
    }

}
