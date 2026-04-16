package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class ExemploController {

    private Acervo acervo;

    @Autowired
    public ExemploController(Acervo acervo) {
        this.acervo = acervo;
    }

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return acervo.getAll(); // Delegando a responsabilidade para o Acervo
    }

    @GetMapping("/titulos")
    public List<String> getTitulos() {
        return acervo.getTitulos();
    }

    @GetMapping("/autores")
    public List<String> getAutores() {
        return acervo.getAutores();
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivrosPorAutorQuery(@RequestParam String autor) {
        return acervo.getLivrosPorAutor(autor);
    }

    @GetMapping("/livrosautorano/{autor}/ano/{ano}")
    public List<Livro> getLivrosPorAutorEAno(@PathVariable String autor, @PathVariable int ano) {
        return acervo.getLivrosPorAutorEAno(autor, ano);
    }

    @PostMapping("/novolivro")
    public void cadastrarNovoLivro(@RequestBody Livro novoLivro) {
        acervo.adicionarLivro(novoLivro);
    }
    
    @GetMapping("/livrotitulo/{titulo}")
    public ResponseEntity<Livro> getLivroPorTitulo(@PathVariable String titulo) {
        Livro livro = acervo.getLivroPorTitulo(titulo);
        if (livro != null) {
            return ResponseEntity.ok(livro); 
        }
        return ResponseEntity.notFound().build(); 
    }

    
    @DeleteMapping("/livrosano/{ano}")
    public boolean removerLivrosPorAno(@PathVariable int ano) {
        return acervo.removerPorAno(ano);
    }
}
