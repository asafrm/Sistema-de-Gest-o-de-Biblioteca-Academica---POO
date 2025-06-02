import java.util.ArrayList;
import java.util.Scanner;
public class Servicos {

    private Scanner sc;

    public Servicos(Scanner sc) {
        this.sc = sc; // usa o mesmo Scanner da main
    }
    public int opcao(){
        System.out.println("Digite a opção desejada: ");
        System.out.println("[1] - Cadastrar livro");
        System.out.println("[2] - Listar livros");
        System.out.println("[3] - Excluir livro");
        System.out.println("[4] - Emprestar livro");
        System.out.println("[5] - Devolver livro");
        System.out.println("[0] - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    //OPCAO 1 Função que cadastra um livro novo
    public Livro adicionarLivro(int isbn) {
        System.out.println("--- Adicionando novo livro ---");

        System.out.print("Digite o ISBN do livro: ");
        isbn = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o título do livro: ");
        String titulo = sc.nextLine();

        System.out.print("Digite o nome do autor do livro: ");
        String autor = sc.nextLine();

        System.out.print("Digite o nome da editora do livro: ");
        String editora = sc.nextLine();

        System.out.print("Digite a data de publicação do livro: ");
        String data = sc.nextLine();

        Livro livro = new Livro(isbn, titulo, autor, editora, data);
        System.out.println("Livro cadastrado com sucesso!");
        return livro;
    }

    //OPCAO 2 Função que lista os livros cadastrados
    public void listarLivros(ArrayList<Livro> livros){
        if(livros.isEmpty()){
            System.out.println();
            System.out.println("Nenhum livro cadastrado! Tente novamente!");
            System.out.println();
        }else {
            System.out.println();
            System.out.println("--- Lista de livros ---");
            System.out.println();
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("ISBN: " + livros.get(i).getIsbn());
                System.out.println("Titulo: " + livros.get(i).getTitulo());
                System.out.println("Autor: " + livros.get(i).getAutor());
                System.out.println("Editora: " + livros.get(i).getEditora());
                System.out.println("Data de Publicação: " + livros.get(i).getData());
                System.out.println("Status: " + (livros.get(i).getStatus() ? "Disponível" : "Indisponível"));
                System.out.println();
            }
        }
        System.out.println();
    }

    //OPCAO 3 Funcao que exclui um livro cadastrado
    public void excluirLivro(ArrayList<Livro> livros, int isbn){
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

    //OPCAO 4 Função que realiza um empréstimo de livro
    public void emprestarLivro(ArrayList<Livro> livros, int isbn /* Acessa o livro pelo ISBN */ ){
        //Vai buscar entre todos os livros cadastrados se o livro que se deseja emprestar está disponível
        for(Livro livro : livros){
            // Verifica se o livro com o ISBN inserido está cadastrado
            if (livro.getIsbn() == isbn){
                //Verifica se o livro está disponível
                if(livro.getStatus()){
                    livro.setStatus(false);
                    System.out.println();
                    System.out.println("Livro " + livro.getTitulo() + ", emprestado com sucesso!");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Este livro já foi emprestado! Tente novamente com outro livro!");
                    System.out.println();
                }
                return;
            }
        }
        System.out.println();
        System.out.println("Nenhum livro com ISBN: " + isbn + "  foi encontrado! Tente novamente com outro livro!");
        System.out.println();
    }

    //OPCAO 5 Funcao que realiza a devoluco de um livro emprestado
    public void devolverLivro(ArrayList<Livro> livros, int isbn  ){
        for(Livro livro : livros){
            // Verifica se o livro com o ISBN inserido está cadastrado
            if (livro.getIsbn() == isbn){
                if(!livro.getStatus()){
                    livro.setStatus(true);
                    System.out.println();
                    System.out.println("Livro " + livro.getTitulo() + " devolvido com sucesso!");
                    System.out.println();
                }else{
                    System.out.println();
                    System.out.println("Este livro não está emprestado! Tente novamente com outro livro! ");
                    System.out.println();
                }
                return;
            }
        }
        System.out.println();
        System.out.println("Nenhum livro com ISBN: " + isbn + "  foi encontrado! Tente novamente com outro livro!");
        System.out.println();
    }
}
