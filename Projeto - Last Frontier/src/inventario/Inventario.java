package inventario;

import java.util.ArrayList;
import interfaces.InventoryActions;
import itens.*;
import personagens.*;

public class Inventario implements InventoryActions {
    //Atributos da classe:
    private ArrayList<Item> listaItens;
    private int pesoSuportado;
    private int capacidadeInventario;

    //Metodo construtor:
    public Inventario(ArrayList<Item> listaItens, int pesoSuportado, int capacidadeInventario) {
        this.listaItens = new ArrayList<>(capacidadeInventario); //Inicializamos o ArrayList e definimos sua capacidade inicial
        this.pesoSuportado = pesoSuportado;
        this.capacidadeInventario = capacidadeInventario;

    }

    //Metodos acessores:
    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public ArrayList<Item> getListaItens() { //Esse metodo tem que ser privado?
        return listaItens;
    }

    public void setPesoSuportado(int pesoSuportado) {
        this.pesoSuportado = pesoSuportado;
    }

    public int getPesoSuportado() { //Precisamos fazer uma verificação em relação ao peso do Inventário/Itens
        return pesoSuportado;
    }

    public void setCapacidadeInventario(int capacidadeInventario) {
        this.capacidadeInventario = capacidadeInventario;
    }

    public int getCapacidadeInventario() { //Se refere ao número de itens
        return capacidadeInventario;
    }

    //Metodos implementados:
    @Override
    public void adicionarItem(Item itemAdicionado) { //Adicionar um verificador para limitar a quantidade de itens com relação à capacidade do inventário
        if (this.getPesoSuportado() >= itemAdicionado.getPesoItem()) {
            this.setPesoSuportado(this.getPesoSuportado() - itemAdicionado.getPesoItem());
            this.getListaItens().add(itemAdicionado);
            System.out.println("O item " + itemAdicionado.getNomeItem() + " foi adicionado!");
        } else {
            System.out.println(" Não foi possível adicionar o item, seu inventário está muito pesado!!");
        }
    }

    @Override
    public void descartarItem(Item itemDescartado) { //Adicionar um verificador para limitar a quantidade de itens com relação à capacidade do inventário
        this.setPesoSuportado(this.getPesoSuportado() + itemDescartado.getPesoItem());
        this.getListaItens().remove(itemDescartado);
        System.out.println("O item " + itemDescartado.getNomeItem() + " foi descartado!");
    }

    @Override
    public void selecionarItem(int posicaoItemSelecionado, Personagem personagemEscolhido) { //Esse metodo ainda irá evoluir
        Item itemSelecionado = this.getListaItens().get(posicaoItemSelecionado);
        //Verificando o Tipo do Item:
        if (itemSelecionado instanceof Agua || itemSelecionado instanceof Alimentos || itemSelecionado instanceof Remedios) { //Consumíveis
            itemSelecionado.usar(itemSelecionado, personagemEscolhido);
            System.out.println("O item " + itemSelecionado.getNomeItem() + " foi consumido!");
            this.getListaItens().remove(itemSelecionado);
        } else if (itemSelecionado instanceof Materiais) { //Irá se desenvolver com o sistema de Craft - Combináveis
            System.out.println("Material selecionado, escolha outro para poder combinar!");
            this.mostrarInventario();
        } else if (itemSelecionado instanceof Armas) { //Temos que desenvolver um slot especial do inventário para Armas - Equipáveis
            System.out.println("Arma selecionada!");
        } else if (itemSelecionado instanceof  Ferramentas) { //Temos que desenvolver um slot especial do inventário para Ferramentas - Equipáveis
            System.out.println("Ferramenta pronta para uso!");
        }
    }

    @Override
    public void mostrarInventario () { //Metodo testado e funcionando!!
        System.out.println("Inventário:");
        for (int contador = 0; contador < listaItens.size(); contador++) {
            System.out.println(contador + " - " + listaItens.get(contador).getNomeItem());
        }
    }

    public void gerarItemAgua(){
        //Objetos de Agua
        Agua garrafaDeAgua=new Agua("Garrafa de água", 3, 5,9,7);
        Agua aguaPotavelRio=new Agua("Água Potável do Rio",3,6,10,9);
        Agua aguaPotavelCacto=new Agua("Água de cacto", 4,5,8,5);
        Agua aguaContaminadaRio=new Agua("Água de rio contaminada", 3,3,3,7);

    }
    public void gerarItemAlimento(){
        //Objetos de Alimentos
        Alimentos mel=new Alimentos("Mel", 1,2,5,"Mel consumível",8);
        Alimentos carne=new Alimentos("Carne", 5,6,15," Carne consumível", 5);
        Alimentos fruta=new Alimentos("Fruta", 4,7,10,"Fruta comestível",8);
        Alimentos lata=new Alimentos("Lata com comida milagrosa",3,6,20,"A lata com comida milagrosa é o item mais raro a se achar,100% consumível",10);
        Alimentos peixe=new Alimentos("Peixe",4,8,12,"Peixe",10);
        Alimentos carnePodre=new Alimentos(" Carne podre",5,1,15,"Carne podre, terá que tomar um remédio", 4);

    }
    public void gerarItemRemedio(){
        //Objetos de Remedio
        Remedios antibiotico=new Remedios("Nicisina",2,4,"Antibiótico","O antibiótico Nicisina é usado para curar infecções " );
        Remedios analgesico=new Remedios("Dorfluz", 2,4,"Analgésico", "O Analgésico Dorfluz cura a dor do personagem");
        Remedios antidoto=new Remedios("Elixir",2,4,"Antídoto", "O antídoto Elixir cura envenenamentos");
        Remedios bandagem=new Remedios("Bandagem",2,4,"bandagem", "A bandagem ajuda no tratamento de ferimentos superficiais");

    }
    public void gerarItemArmas(){
        //Objetos de armas
        Armas revolver=new Armas(" Revólver à distância", 4,9,"Arma à distância",10,8);
        Armas arco=new Armas("Arco e flecha",5,8,"À distância",8,10);
        Armas espada=new Armas("Espada",7,9,"Corpo a corpo",10,2);
        Armas lanca=new Armas("Lança",4,6,"à distância",8,10);
        Armas granda=new Armas("Granada",2,9,"à distância",10,10);
        Armas gancho=new Armas("Gancho de ferro",4,8,"Corpo a corpo",8,2);
        Armas facao=new Armas("Facão",4,9,"corpo à corpo",9,2);

    }
    public void gerarItemFerramentas(){
        //Objetos de ferramentas
        Ferramentas machado=new Ferramentas("Vedhoggr",7,9,"Machado de aço rúnico usado para cortar madeira sagrada em Midgard.",9);
        Ferramentas isqueiro=new Ferramentas("Eldrgnista", 1,6,"Isqueiro rústico encantado com brasas eternas de Muspelheim.",8);
        Ferramentas lanterna=new Ferramentas("Ljóslykla",2,8,"Lanterna alimentada por pedras de luz dos anões.",9);
        Ferramentas faca=new Ferramentas("Kjǫtvigr",4,8,"Faca forjada com precisão pelos elfos, afiada como o frio de Niflheim.",9);
        Ferramentas tesoura=new Ferramentas("Blódkutt",2,10,"Tesoura de precisão usada para colher ervas raras com mínimo dano.",10);
        Ferramentas martelo=new Ferramentas("Myrkholt",4,8,"Martelo de precisão dos anões, usado para construção de mecanismos.",10);
        Ferramentas agulha=new Ferramentas("Véftvinna",1,9,"Agulha de tecelagem rúnica para consertar tecidos mágicos.",7);
    }
    public void gerarItemMateriais(){
        //Objetos de materiais
        Materiais madeira=new Materiais("Asktreplate",6,7,"Recurso de construção, Tábua resistente feita da madeira de Ask, a árvore primordial",7);
        Materiais ferro=new Materiais("Járnstykket",8,9,"Pedaço de ferro forjado nas chamas de Nidavellir",9);
        Materiais pedra=new Materiais("Steinblokk",8,9,"Bloco bruto de pedra extraído das montanhas de Jotunheim",9);
        Materiais couro=new Materiais("Úlfarskinn",5,7,"Couro espesso tratado com óleos élficos, vindo de lobos das florestas sombrias.",10);
        Materiais arame=new Materiais("Línvǫrr",3,7,"Fio metálico trançado pelos anões de Nidavellir, usado em armadilhas e mecanismos rúnicos.",9);
        Materiais pilha=new Materiais("Eldgnista",2,9,"Fonte de energia portátil, usada pelos anões para alimentar engenhocas mágicas.",9);
    }
}