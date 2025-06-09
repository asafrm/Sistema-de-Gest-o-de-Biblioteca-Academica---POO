//Subclasse de Usuario
public class Professor extends Usuario {

    // Atributos específicos do Professor
    private String departamento;
    private String titulacao;
    private String disciplinasLecionadas;

    // Construtor
    public Professor(int matricula, String nome, String cpf, String email, String departamento, String titulacao, String disciplinasLecionadas) {
        super(matricula, nome, cpf, email, TipoUsuario.PROFESSOR);
        this.departamento = departamento;
        this.titulacao = titulacao;
        this.disciplinasLecionadas = disciplinasLecionadas;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getDisciplenasLecionadas() {
        return disciplinasLecionadas;
    }

    public void setDisciplenasLecionadas(String disciplenasLecionadas) {
        this.disciplinasLecionadas = disciplenasLecionadas;
    }
}