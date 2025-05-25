import java.time.LocalDate;

public class Livro {
    // Atributos
    private int isbn;
    private String titulo;
    private String autor;
    private LocalDate data;
    private String editora;
    private boolean disponivel;
    
    //Métodos
    public Livro(int isbn, String titulo, String autor, LocalDate data, String editora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.editora = editora;
        this.disponivel = true;
    }

    
    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getEditora() {
        return editora;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    
    
}
