import java.util.Scanner;

public class Livro {

    //Atributos
    private int isbn;
    private String titulo;
    private String autor;
    private String editora;
    private String data;
    private boolean status;

    //Métodos

    //Construtor
    public Livro(int isbn, String titulo, String autor, String editora, String data) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.data = data;
        this.status = true;
    }

    // Getters e Setters
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Representação
    @Override
    public String toString() {
        return "Livro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", data='" + data + '\'' +
                ", status=" + status +
                '}';
    }
}
