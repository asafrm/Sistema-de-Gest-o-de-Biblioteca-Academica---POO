import java.time.LocalDate;
        
public class Emprestimo {
    //Atributos
    private int idEmprestimo;
    private Usuario usuario;
    private Livro livro;
    private LocalDate data;
    private boolean status;
    
    //Metodos

    public Emprestimo(int idEmprestimo, Usuario usuario, Livro livro, LocalDate data, boolean status) {
        this.idEmprestimo = idEmprestimo;
        this.usuario = usuario;
        this.livro = livro;
        this.data = data;
        this.status = status;
    }

    public void realizarEmprestimo(){
        
    }
    
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
