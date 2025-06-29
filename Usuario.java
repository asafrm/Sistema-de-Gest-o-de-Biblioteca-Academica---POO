import java.time.LocalDate;
public class Usuario {
    private int matricula;
    private String nome;
    private String cpf;
    private String email;
    private TipoUsuario tipoUsuario;

    public Usuario(int matricula, String nome, String cpf, String email, TipoUsuario tipoUsuario) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public enum TipoUsuario {
        PROFESSOR,
        ALUNO
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}