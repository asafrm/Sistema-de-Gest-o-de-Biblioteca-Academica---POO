//Subclasse de usuário
public class Aluno extends Usuario {

    // Atributos específicos do Aluno
    private String Curso;
    private String grauCurso;

    // Construtor
    public Aluno(int matricula, String nome, String cpf, String email, String Curso, String grauCurso) {
        super(matricula, nome, cpf, email, TipoUsuario.ALUNO);
        this.Curso = Curso;
        this.grauCurso = grauCurso;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public String getGrauCurso() {
        return grauCurso;
    }

    public void setGrauCurso(String grauCurso) {
        this.grauCurso = grauCurso;
    }
}
