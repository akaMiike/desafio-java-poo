import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Curso Java");
        cursoJava.setDescricao("Curso de java para iniciantes");
        cursoJava.setCargaHoraria(4);

        Curso cursoJavascript = new Curso();
        cursoJavascript.setTitulo("Curso Javascript");
        cursoJavascript.setDescricao("Curso de Javascript para iniciantes");
        cursoJavascript.setCargaHoraria(4);

        Mentoria mentoriaAws = new Mentoria();
        mentoriaAws.setTitulo("Mentoria AWS");
        mentoriaAws.setDescricao("Mentoria de introdução a AWS");
        mentoriaAws.setData(LocalDate.now());

        Bootcamp bootcampJavaDeveloper = new Bootcamp();
        bootcampJavaDeveloper.setNome("Bootcamp Java Developer");
        bootcampJavaDeveloper.setDescricao("Bootcamp Java Developer");
        bootcampJavaDeveloper.getConteudos().add(cursoJava);
        bootcampJavaDeveloper.getConteudos().add(cursoJavascript);
        bootcampJavaDeveloper.getConteudos().add(mentoriaAws);

        Dev dev1 = new Dev();
        dev1.inscreverBootcamp(bootcampJavaDeveloper);
        dev1.setNome("Michael");
        System.out.println(dev1.getConteudosInscritos());
        dev1.progredir();
        System.out.println(dev1.getConteudosConcluidos());
        System.out.println("Total xp dev1: " + dev1.calcularTotalXp());

        Dev dev2 = new Dev();
        dev2.inscreverBootcamp(bootcampJavaDeveloper);
        dev2.setNome("Nicholas");
        System.out.println(dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        System.out.println("Total xp dev2: " + dev2.calcularTotalXp());

    }
}
