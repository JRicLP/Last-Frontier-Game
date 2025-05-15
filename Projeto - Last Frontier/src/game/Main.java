package game;

import ambientes.AmbienteCaverna;
import ambientes.AmbienteFloresta;
import ambientes.Ambientes;
import eventos.EventoDescoberta;
import gerenciadores.GerenciadorDeAmbientes;
import inventario.Inventario;
import itens.Agua;
import itens.Alimentos;
import personagens.Cacador;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Inventario inventarioTeste = new Inventario(new ArrayList<>(), 10, 10);

        Alimentos melancia = new Alimentos("Melancia Grande", 5, 10, 10, "Fruta", 10);
        Agua garrafaAgua = new Agua("Garrafa de Água", 2, 10, 100, 100 );

        Cacador hunterBoss = new Cacador("Flynn Tracker", 100, 100, 65, 85, 85, " ", " ",
                false, 65, 100, " ");

        AmbienteCaverna cavernaProfunda = new AmbienteCaverna("Caverna Profunda", "Uma caverna escura, perigosa e cheia de desafios", 10, "Itens perdidos, Água, Monstros para Combate",
                3, "Clima de Caverna", false,false ,false);
        AmbienteFloresta floresta = new AmbienteFloresta("Amazônia", "Uma floresta densa e perigosa", 5, "Água, Alimentos e Animais para Combate",
                4, "Clima Chuvoso", false, false, false);

        EventoDescoberta bauPerdido = new EventoDescoberta("Bau Perdido", "Um antigo baú esquecido pelos corajosos exploradores de uma era passada",3,
                "Descobertas recuperam o folego do personagem, um pouco de energia e sede serão regenerados", true, "Tesouro Antigo","Materiais", false);
        EventoDescoberta caixaDeSuprimentos = new EventoDescoberta("Caixa de Suprimentos", "Uma caixa de suprimentos deixada pelos antigos exploradores, parece até um milagre!", 4,
                "Caixas de Suprimentos recuperam Sede, Fome e um pouco de Sanidade!",true, "Consumíveis","Alimentos, Agua",false);
        EventoDescoberta kitMedico = new EventoDescoberta("Kit Médico", "Parece que algum médico passou por aqui. O que ele estava fazendo?", 3,
                "Kit's Médicos recuperam a Saúde do personagem e dão um pouco de esperança, recuperando a Sanidade", true, "Consumíveis", "Remédios", false);

        EventoDescoberta[] listaEventosDescobertas = {bauPerdido, bauPerdido, bauPerdido, caixaDeSuprimentos, caixaDeSuprimentos, caixaDeSuprimentos, caixaDeSuprimentos, kitMedico, kitMedico, kitMedico};

        String[] listaAmbientes = new String[2];
        GerenciadorDeAmbientes gerenciadorDeAmbientes = new GerenciadorDeAmbientes(listaAmbientes," ",new ArrayList<Ambientes>(5));

        gerenciadorDeAmbientes.mudarAmbiente(hunterBoss, cavernaProfunda);
        System.out.println(gerenciadorDeAmbientes.getHistoricoMovimentacao().getFirst().getNomeAmbiente());
        gerenciadorDeAmbientes.mudarAmbiente(hunterBoss, floresta);
        System.out.println(gerenciadorDeAmbientes.getHistoricoMovimentacao().get(1).getNomeAmbiente());


        //Random escolhaEventoDescoberta = new Random();
        //int eventoEscolhido = escolhaEventoDescoberta.nextInt(10);
        //System.out.println(listaEventosDescobertas[eventoEscolhido].getNomeEvento());
        //listaEventosDescobertas[eventoEscolhido].executar(hunterBoss, cavernaProfunda, listaEventosDescobertas[eventoEscolhido]);

    }
}
