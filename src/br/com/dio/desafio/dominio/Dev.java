package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        bootcamp.getDevInscritos().add(this);
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
    }

    public void progredir(){
        Optional<Conteudo> primeiroConteudo = this.conteudosInscritos.stream().findFirst();
        if(primeiroConteudo.isPresent()){
            this.conteudosConcluidos.add(primeiroConteudo.get());
            this.conteudosInscritos.remove(primeiroConteudo.get());
        } else{
            System.err.println("Dev não está matriculado em nenhum conteúdo.");
        }
    }

    public double calcularTotalXp(){
        return this.conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }
}
