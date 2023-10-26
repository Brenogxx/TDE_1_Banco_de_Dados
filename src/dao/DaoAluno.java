package dao;

import java.sql.*;

public class DaoAluno {

    public static void inserirAluno(String matricula, String nome, String codigo_curso, Connection connection) throws SQLException {

        String insertSql = "INSERT INTO public.aluno (matricula, nome, codigo_curso) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setString(1, matricula);
        preparedStatement.setString(2, nome);
        preparedStatement.setString(3, codigo_curso);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public static void mostrarAlunos(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        String selectSql = "SELECT matricula, nome, codigo_curso FROM public.aluno";
        ResultSet rs = stmt.executeQuery(selectSql);

        // Exibe os alunos.
        while (rs.next()) {
            String matricula = rs.getString("matricula");
            String nome = rs.getString("nome");
            String codigo_curso = rs.getString("codigo_curso");
            System.out.println("\nMatrícula: " + matricula + ", Nome: " + nome + ", Código do Curso: " + codigo_curso);
        }

        rs.close();
        stmt.close();

    }

}
