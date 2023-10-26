package model;

public class Curso {

    private String codigo;
    private String nome;
    private String carga_horaria;

    public Curso(String codigo, String nome, String carga_horaria) {
        this.codigo = codigo;
        this.nome = nome;
        this.carga_horaria = carga_horaria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", carga_horaria=" + carga_horaria +
                '}';
    }

}
