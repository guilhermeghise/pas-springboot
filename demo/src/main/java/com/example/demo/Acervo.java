package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Acervo {

    private List<Livro> livros;

    public Acervo() {
        livros = new ArrayList<>();
        livros.add(new Livro(1, "Titulo 1", "Maria da Silva", 2008));
        livros.add(new Livro(2, "Titulo 2", "Pedro da Silva", 2024));
        livros.add(new Livro(3, "Titulo 3", "Autor 2", 1999));
    }

    public List<Livro> getAll() {
        return livros;
    }

    public List<String> getTitulos() {
        List<String> titulos = new ArrayList<>();
        for (Livro livro : livros) {
            titulos.add(livro.getTitulo());
        }
        return titulos;
    }

    public List<String> getAutores() {
        List<String> autores = new ArrayList<>();
        for (Livro livro : livros) {
            autores.add(livro.getAutor());
        }
        return autores;
    }

    public List<Livro> getLivrosPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public List<Livro> getLivrosPorAutorEAno(String autor, int ano) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor) && livro.getAno() == ano) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public void adicionarLivro(Livro novoLivro) {
        livros.add(novoLivro);
    }

    public Livro getLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public boolean removerPorAno(int ano) {
        return livros.removeIf(livro -> livro.getAno() == ano);
}
}