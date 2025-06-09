   public static Livro buscarLivro(List<Livro> livros, int isbn) {
        // Percorre a lista de livros
        for (Livro livro : livros) { // Usando um for-each loop para maior clareza
            // Verifica se o ISBN do livro atual é igual ao ISBN procurado
            if (livro.getIsbn() == isbn) {
                return livro; // Retorna o livro assim que o encontra
            }
        }
        return null; // Se o loop terminar e o livro não for encontrado, retorna null
    }