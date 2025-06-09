import java.util.Scanner;
import java.util.List;


public class Livro {
    //Atributos
    private int isbn;
    private String titulo;
    private String autor;
    private String editora;
    private String dataPublicacao;
    private boolean disponivel;

    //Métodos

    //Construtor
    public Livro(int isbn, String titulo, String autor, String editora, String dataPublicacao, boolean disponivel) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
        this.disponivel = true;
    }

    //OPCAO 1 Função que cadastra um livro novo
    public static Livro cadastrarLivro(Scanner sc) {
        System.out.println("--- Adicionando novo livro ---");

        System.out.print("Digite o ISBN do livro: ");
        int isbn = Integer.parseInt(sc.nextLine());

        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();

        System.out.print("Digite o nome do autor do livro: ");
        String autor = sc.nextLine();

        System.out.print("Digite o nome da editora do livro: ");
        String editora = sc.nextLine();

        System.out.print("Digite a data de publicação do livro: ");
        String dataPublicacao = sc.nextLine();

        System.out.println("Livro cadastrado com sucesso!");
        return new Livro(isbn, titulo, autor, editora, dataPublicacao, true);
    }

    //OPCAO 2 Função que lista os livros cadastrados
    public static void listarLivros(List<Livro> livros){
        if(livros.isEmpty()){
            System.out.println();
            System.out.println("Nenhum livro cadastrado! Tente novamente!");
            System.out.println();
        }else {
            System.out.println();
            System.out.println("--- Lista de livros cadastrados ---");
            System.out.println();
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("ISBN: " + livros.get(i).getIsbn());
                System.out.println("Titulo: " + livros.get(i).getTitulo());
                System.out.println("Autor: " + livros.get(i).getAutor());
                System.out.println("Editora: " + livros.get(i).getEditora());
                System.out.println("Data de Publicação: " + livros.get(i).getDataPublicacao());
                System.out.println("Status: " + (livros.get(i).getDisponivel() ? "Disponível" : "Indisponível"));
                System.out.println();
            }
        }
        System.out.println();
    }

    //OPCAO 3 Funcao que exclui um livro cadastrado
    public static void excluirLivro(List<Livro> livros, int isbn){
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIsbn() == isbn) {
                System.out.println();
                System.out.println("Livro " +livros.get(i).getTitulo() + " removido com sucesso!");
                System.out.println();
                livros.remove(i);
                return;
            }
        }
        System.out.println();
        System.out.println("Nenhum livro com ISBN: " + isbn + "  foi encontrado! Tente novamente com outro livro!");
        System.out.println();
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

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Representação
    @Override
    public String toString() {
        return "Livro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", dataPublicacao='" + dataPublicacao + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}
