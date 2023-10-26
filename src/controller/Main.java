package controller;

import dao.Conexao;
import dao.DaoAluno;
import dao.DaoCurso;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado1 = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);

        System.out.println("\nSelecione uma opção: ");
        System.out.println("\n1 - Cadastrar Curso");
        System.out.println("\n2 - Consultar Cursos");
        System.out.println("\n3 - Cadastrar Aluno");
        System.out.println("\n4 - Consultar Alunos");
        System.out.println("\n5 - Sair");

        int opcao = teclado1.nextInt();


        switch (opcao) {
            case 1:
                try {
                    Connection connection = Conexao.estabelecerConexao();
                    System.out.println("\nInsira o código do curso: ");
                    String codigo = teclado2.nextLine();
                    System.out.println("\nInsira o nome do curso: ");
                    String nome = teclado2.nextLine();
                    System.out.println("\nInsira a carga horária do curso: ");
                    String carga_horaria = teclado2.nextLine();

                    DaoCurso.inserirCurso(codigo, nome, carga_horaria, connection);
                    Conexao.encerrarConexao(connection);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Connection connection = Conexao.estabelecerConexao();
                    DaoCurso.mostrarCursos(connection);
                    Conexao.encerrarConexao(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Connection connection = Conexao.estabelecerConexao();
                    System.out.println("\nInsira a matrícula do aluno: ");
                    String matricula = teclado2.nextLine();
                    System.out.println("\nInsira o nome do aluno: ");
                    String nome = teclado2.nextLine();
                    DaoCurso.mostrarCursos(connection);
                    System.out.println("\nInsira o código do curso ao qual se deseja matrícular o aluno: ");
                    String codigo_curso = teclado2.nextLine();
                    DaoAluno.inserirAluno(matricula, nome, codigo_curso, connection);
                    Conexao.encerrarConexao(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 4:
                try {
                    Connection connection = Conexao.estabelecerConexao();
                    DaoAluno.mostrarAlunos(connection);
                    Conexao.encerrarConexao(connection);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }


    }

}
