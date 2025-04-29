package game;

import gerenciadores.GerenciadorDePersonagens;
import inventario.Inventario;
import itens.Agua;
import itens.Alimentos;
import itens.Armas;
import itens.Ferramentas;
import personagens.Personagem;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Alimentos melancia = new Alimentos("Melancia", 3, 10, 3, "Fruta",10);
        Agua garrafaAgua = new Agua("Garrafa de Agua", 2,10, 0.9, 1);
        Ferramentas picaretaFerro = new Ferramentas("Picareta de Ferro", 2, 10, "Picareta", 8);
        Armas espadaAfiada = new Armas("Espada Afiada", 10, 10, "Espada", 5, 5 );

        Inventario inventarioTest = new Inventario(new ArrayList<>(), 10, 10);

        GerenciadorDePersonagens gerenciador= new GerenciadorDePersonagens("Nômade", "");
        gerenciador.escolherPersonagem();
        Personagem nomadePerdido = gerenciador.getPersonagem();

        inventarioTest.adicionarItem(melancia);
        inventarioTest.adicionarItem(garrafaAgua);
        inventarioTest.adicionarItem(picaretaFerro);
        inventarioTest.mostrarInventario();
        inventarioTest.descartarItem(garrafaAgua);
        inventarioTest.mostrarInventario();
        inventarioTest.adicionarItem(espadaAfiada);
        inventarioTest.mostrarInventario();
        inventarioTest.selecionarItem(1, nomadePerdido);
        inventarioTest.mostrarInventario();

    }
}
