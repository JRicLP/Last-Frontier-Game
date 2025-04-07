package game;

import ambientes.AmbienteFloresta;
import ambientes.AmbienteMontanha;
import gerenciadores.GerenciadorDeAmbientes;
import personagens.Nomade;

public class Main {
    public static void main(String[] args) {

        AmbienteFloresta florestaRasa = new AmbienteFloresta("Floresta Rasa","Uma floresta espaçosa com " +
                "grande presença de arbustos e gramíneas, mas pouca árvores. A exposição ao sol aqui é maior e possui menor disponibilidade de água",
                0.2,"Madeira, Rocha, Agua, Frutas", 0.4, "Ensolarado brando", "A vegetação é mais rasa nesse local",
                "Há grande presença de roedores, aves e rastejantes", "As chuvas são um pouco escassas aqui");

        AmbienteMontanha monteCongelante = new AmbienteMontanha("Monte Congelante", "Uma montanha fria e esbranquiçada pelas fortes nevascas que acontecem",
                0.7, "Rochas, Minérios, Água congelada", 0.4, "Neve branda e contínua",
                "O terreno é íngrime e apresenta rochas soltas.", "O clima aqui é instável, pode nevar muito em pouco tempo", "Quase não há plantas aqui devido ao frio");

        Nomade russoPerdido = new Nomade("Jack Nomad", 100, 100, 65, 100, 100, "Vazio",
                " ", "Possui grande resistência e adaptabilidade à mudanças climáticas");

        String[] listaAmbientes = {florestaRasa.getNomeAmbiente(), monteCongelante.getNomeAmbiente()};
        String[] ambientesPercorridos = {florestaRasa.getNomeAmbiente()};

        GerenciadorDeAmbientes lista = new GerenciadorDeAmbientes(listaAmbientes, "Nevasca", ambientesPercorridos);

        russoPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
        russoPerdido.statusPersonagem();
        lista.mudarAmbiente(russoPerdido, monteCongelante);
        russoPerdido.statusPersonagem();
    }
}
