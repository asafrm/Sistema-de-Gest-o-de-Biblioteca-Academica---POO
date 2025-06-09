import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Emprestimo {
    //Atributos
    private int idEmprestimo;
    private Usuario usuarioEmprestimo;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean status;
    private static int proximoIdEmprestimo = 1; // Contador para gerar IDs sequenciais

    // Construtor corrigido: Agora aceita Usuario e Livro como parâmetros
    public Emprestimo(int idEmprestimo, Usuario usuarioEmprestimo, Livro livro, LocalDate dataEmprestimo, boolean status) {
        this.idEmprestimo = idEmprestimo;
        this.usuarioEmprestimo = usuarioEmprestimo;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.status = status;
    }

    public static void emprestarLivro(List<Livro> livros, List<Usuario> usuarios, List<Emprestimo> emprestimos, int isbn, Scanner sc){
        //Vai buscar entre todos os livros cadastrados se o livro que se deseja emprestar está disponível
        for(Livro livro : livros){
            // Verifica se o livro com o ISBN inserido está cadastrado
            if (livro.getIsbn() == isbn){
                //Verifica se o livro está disponível
                if(livro.getDisponivel()){
                    LocalDate dataEmprestimo = LocalDate.now();
                    LocalDate dataDevolucao = dataEmprestimo.plusDays(15);
                    livro.setDisponivel(false);
                    
                    System.out.println("Digite o número de matricula do usuário que vai pegar o livro: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();

                    Usuario usuarioEmprestimo = null;
                    for (Usuario u : usuarios){
                        if (u.getMatricula() == matricula){
                            usuarioEmprestimo = u;
                            break;
                        }
                    }
                    
                    System.out.println();
                    System.out.println("Livro " + livro.getTitulo() + ", emprestado para com sucesso!");
                    System.out.println("O livro deve ser devolvido no dia: " + dataDevolucao);
                    System.out.println();
                    
                    if (usuarioEmprestimo != null){
                        // Incrementa o id antes de usar, visando garantir que cada id seja unicoo
                        int idEmprestimo = proximoIdEmprestimo++;

                        // Cria um novo objeto Emprestimo e o adiciona à lista de empréstimos
                        Emprestimo novoEmprestimo = new Emprestimo(idEmprestimo, usuarioEmprestimo, livro, dataEmprestimo, true);
                        emprestimos.add(novoEmprestimo);

                        System.out.println("Empréstimo registrado com ID: " + idEmprestimo);
                        
                    } else {
                        System.out.println("Erro: Usuário com número de matricula " + matricula + " não encontrado. Empréstimo não registrado.");
                        livro.setDisponivel(true); // se o usuario não for encontrado, torna o livro disponível paraa empréstimo novamente
                    }
                    return;
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

    public static void devolverLivro(List<Livro> livros, List<Emprestimo> emprestimos, int isbn){
        for(Livro livro : livros){
            // Verifica se o livro com o ISBN inserido está cadastrado
            if (livro.getIsbn() == isbn){
                if(!livro.getDisponivel()){
                    livro.setDisponivel(true);
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


    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public Usuario getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public void setUsuarioEmprestimo(Usuario usuarioEmprestimo) {
        this.usuarioEmprestimo = usuarioEmprestimo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
