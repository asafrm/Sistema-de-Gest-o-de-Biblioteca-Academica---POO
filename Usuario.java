import java.time.LocalDate;
        
public class Usuario {
    //Atributos
    private int matricula;
    private String nome;
    private String tipo;
    private String cpf;
    private String email;
    
    //Métodos
    public Usuario(int matricula, String nome, String tipo, String cpf, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.tipo = tipo;
        this.cpf = cpf;
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
