package gerenciadores;

import itens.*;
import personagens.Personagem;
import util.NotificacaoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciadorDeItens {

    public List<Agua> listaAgua = new ArrayList<>();
    public List<Alimento> listaAlimentos = new ArrayList<>();
    public List<Remedio> listaRemedios = new ArrayList<>();
    public List<Arma> listaArmas = new ArrayList<>();
    public List<Ferramenta> listaFerramentas = new ArrayList<>();
    public List<Material> listaMateriais = new ArrayList<>();
    NotificacaoUtil notificacaoUtil = new NotificacaoUtil();
    private Personagem personagem;

    public GerenciadorDeItens(Personagem personagem) {
        this.personagem=personagem;
        // Água
        Agua cantil = new Agua("Cantil de Água", 1, 10, 9, 5,null);
        Agua lago = new Agua("Água Potável do Lago", 1, 10, 10, 10,null);
        Agua barril = new Agua("Barril de Água", 5, 8, 8, 10,null);
        Agua suja = new Agua("Pote de Água Suja", 2, 2, 2, 5,notificacaoUtil);

        listaAgua.add(cantil);
        listaAgua.add(lago);
        listaAgua.add(barril);
        listaAgua.add(suja);

        // Alimentos
        Alimento ramos = new Alimento("Ramos Vegetais", 1, 2, 10, "Ramos Vegetais que ficam " +
                "na Floresta de Skógrheimr.", 8,null);
        Alimento carneAnimal = new Alimento("Carne Animal", 5, 6, 15, "Carne Animal, tão forte " +
                "quanto os seus provedores", 5,null);
        Alimento frutas = new Alimento("Frutas Variadas", 4, 7, 10, "Frutas Variadas que ficam na " +
                "Floresta de Skógrheimr", 8,null);
        Alimento vaelra = new Alimento("Pote de Vaelra", 3, 6, 15, "O Pote de Vaelra é um item muito " +
                "raro, restaura todas as condições", 10,null);
        Alimento peixe = new Alimento("Carne de Peixe", 4, 8, 12, "Carne de Peixe, nutritiva e saborosa," +
                " contribuirá na sua jornada", 10,null);
        Alimento podre = new Alimento("Carne Apodrecida", 5, 1, 15, "Carne Apodrecida, irá contaminar você", 4,notificacaoUtil);

        listaAlimentos.add(ramos);
        listaAlimentos.add(carneAnimal);
        listaAlimentos.add(frutas);
        listaAlimentos.add(vaelra);
        listaAlimentos.add(peixe);
        listaAlimentos.add(podre);

        // Remédios
        Remedio myrsill = new Remedio("Myrsillblóð",2,4,"Antibiótico","Um extrato espesso e " +
                "amargo retirado de raízes que crescem apenas nas encostas sombreadas do Fjellgraad. Quando ingerido ou aplicado em feridas," +
                " impede que infecções se espalhem, mesmo aquelas causadas por criaturas corrompidas. Tem cheiro de terra molhada e cobre." );
        Remedio draumr = new Remedio("Draumrlyng", 2,4,"Analgésico", "Uma infusão feita com pétalas azuis e " +
                "sementes negras. Alivia dores físicas ao induzir uma calma sonolência, quase onírica." +
                " Xamãs dizem que o espírito “sai por um instante” e retorna mais leve.");
        Remedio eitr = new Remedio("Eitrskjarr",2,4,"Antídoto", "Uma pasta verde viva feita com folhas " +
                "fervidas de Skjarrun, planta que cresce perto de tocas de víboras. Quando ingerida ou aplicada sobre feridas venenosas, " +
                "neutraliza toxinas naturais e arcanas em minutos." +
                " Seu gosto é descrito como “ferro com trovão”");
        Remedio vefr = new Remedio("Vefrbind",2,4,"Bandagem", "Tiras de linho consagrado embebidas em " +
                "seiva de árvore antiga. A bandagem acelera a cicatrização e gruda levemente na pele ao toque," +
                " como se estivesse viva. Quando removida, queima as impurezas da ferida suavemente.");
        listaRemedios.add(myrsill);
        listaRemedios.add(draumr);
        listaRemedios.add(eitr);
        listaRemedios.add(vefr);

        // Armas
        Arma vetrkvistr = new Arma("Vetrkvistr", 4, 9, "Arma à distância", 10, 10);
        Arma naustral = new Arma("Naustrál", 5, 8, "Arma à distância", 8, 10);
        Arma deydrblood = new Arma("Deyðrblóð", 7, 9, "Arma corpo a corpo", 10, 2);
        Arma skjalf = new Arma("Skjalfheimr", 4, 6, "Arma à distância", 8, 10);
        Arma hyrndr = new Arma("Hyrndrgrip", 4, 8, "Arma corpo a corpo", 8, 2);
        Arma kv = new Arma("Kviðskera", 4, 9, "Arma corpo a corpo", 9, 2);//faca
        Arma vardstein = new Arma("Vardstein", 5, 8, "Arma corpo a corpo", 4, 2);

        listaArmas.add(vetrkvistr);
        listaArmas.add(naustral);
        listaArmas.add(deydrblood);
        listaArmas.add(skjalf);
        listaArmas.add(hyrndr);
        listaArmas.add(kv);
        listaArmas.add(vardstein);

        // Ferramentas
        Ferramenta skallhjorr = new Ferramenta("Skallhjǫrr",7,9,"Um machado de duas lâminas negras, " +
                "forjado com ferro retirado de túmulos de gigantes. Dizem que ele nunca lasca e corta até através de magia." +
                " Vibrar com ele nas mãos causa calafrios… mesmo ao empunhador.",9);
        Ferramenta grjotklo = new Ferramenta("Grjótkló", 1,6,"Tem dentes de metal azulado, " +
                "capazes de cortar qualquer rocha, até as encantadas." +
                " Cada batida deixa um rastro cintilante que brilha por poucos segundos — útil em passagens escuras.",8);
        Ferramenta lj = new Ferramenta("Ljósmodir",2,8,"Uma lanterna de latão antigo que emite uma" +
                " chama azulada, alimentada não por óleo, mas por fragmentos de sonhos." +
                " Sua luz afasta ilusões, espectros e revela inscrições ocultas.",9);
        Ferramenta las = new Ferramenta("Lásvísa",4,8,"Pequena e ornamentada, feita de prata viva. " +
                "Molda-se a qualquer fechadura antiga, mas só funciona uma vez por noite." +
                " Fala com seu portador em sussurros, revelando segredos das portas que abre.",9);
        Ferramenta dundr = new Ferramenta("Dundrhamarr",4,8,"Um martelo de construção e combate que emite" +
                " uma pancada seca sem som, como se o ar se curvasse." +
                " Pode quebrar pedra sem eco — ideal para ruínas ou cavernas onde barulho atrairia horrores.",10);
        Ferramenta seidr= new Ferramenta("Seidrreip",4,8,"Uma corda trançada com fios de pelo de criatura" +
                " mágica e seda de aranha espiritual. Estica ou encolhe conforme a vontade do usuário." +
                " Pode se firmar sozinha em superfícies ou prender inimigos brevemente." ,10);
        listaFerramentas.add(skallhjorr);
        listaFerramentas.add(grjotklo);
        listaFerramentas.add(lj);
        listaFerramentas.add(las);
        listaFerramentas.add(dundr);
        listaFerramentas.add(seidr);

        // Materiais
        Material ask = new Material("Asktreplate",6,7,"Recurso de construção, Tábua resistente feita da " +
                "madeira de Dravnir, a árvore primordial",7);
        Material jarn = new Material("Járnstykket",8,9,"Pedaço de ferro forjado nas chamas de " +
                "Eldthórr ",9);
        Material stein = new Material("Steinblokk",8,9,"Bloco bruto de pedra extraído das montanhas " +
                "de Hrafntindr",9);
        Material ulfar = new Material("Úlfarskinn",5,7,"Couro espesso tratado com óleos, vindo de lobos " +
                "da floresta de Skógrheimr.",10);
        Material lin = new Material("Línvǫrr",3,7,"Fio metálico trançado, usado em armadilhas e " +
                "mecanismos rúnicos.",9);
        Material eld = new Material("Eldgnista",2,9,"Fonte de energia portátil, usada pelos anões para " +
                "alimentar engenhocas mágicas.",9);
        listaMateriais.add(ask);
        listaMateriais.add(jarn);
        listaMateriais.add(stein);
        listaMateriais.add(ulfar);
        listaMateriais.add(lin);
        listaMateriais.add(eld);
    }
    public Item sortearItemAleatorio() {
        Random random = new Random();

        // Lista com todas as listas de itens
        List<List<? extends Item>> todasAsListas = List.of(
                listaAgua,
                listaAlimentos,
                listaRemedios,
                listaArmas,
                listaFerramentas,
                listaMateriais
        );

        // Sorteia uma das listas
        List<? extends Item> listaEscolhida = todasAsListas.get(random.nextInt(todasAsListas.size()));

        // Sorteia um item dentro da lista escolhida
        if (!listaEscolhida.isEmpty()) {
            return listaEscolhida.get(random.nextInt(listaEscolhida.size()));
        }

        return null; // caso algo dê errado
    }

    public boolean verificarVitoria() {
        return personagem.temItem("Asktreplate") &&//madeira
                personagem.temItem("Eldgnista") && //pilha
                personagem.temItem("Dundrhamarr") && //martelo
                personagem.temItem("Línvǫrr") &&// arame
                personagem.temItem("Lásvísa"); //chave
    }

    public List<Item> itensFaltandoParaVitoria() {
        List<Item> faltando = new ArrayList<>();
        if (!personagem.temItem("Asktreplate")){
            Item ask=new Material("Asktreplate",6,7,"Recurso de construção, Tábua resistente feita da " +
                "madeira de Dravnir, a árvore primordial",7);
            ask.setCaminhoImagem("imagens/materiais/Asktreplate.png");
            faltando.add(ask);
        }

        if (!personagem.temItem("Eldgnista")) {
            Item eld = new Material("Eldgnista",2,9,"Fonte de energia portátil, usada pelos anões para " +
                    "alimentar engenhocas mágicas.",9);
            eld.setCaminhoImagem("imagens/materiais/Eldgnista.png");
            faltando.add(eld);
        }
        if (!personagem.temItem("Dundrhamarr")) {
            Item dundr = new Ferramenta("Dundrhamarr",4,8,"Um martelo de construção e combate que emite" +
                    " uma pancada seca sem som, como se o ar se curvasse." +
                    " Pode quebrar pedra sem eco — ideal para ruínas ou cavernas onde barulho atrairia horrores.",10);
            dundr.setCaminhoImagem("imagens/ferramentas/Dundrhamarr.png");
            faltando.add(dundr);
        }
        if (!personagem.temItem("Línvǫrr")) {
            Item lin = new Material("Línvǫrr",3,7,"Fio metálico trançado, usado em armadilhas e " +
                    "mecanismos rúnicos.",9);
            lin.setCaminhoImagem("imagens/materiais/Línvǫrr.png");
            faltando.add(lin);
        }
        if(!personagem.temItem("Lásvísa")){
            Item las = new Ferramenta("Lásvísa",4,8,"Pequena e ornamentada, feita de prata viva. " +
                    "Molda-se a qualquer fechadura antiga, mas só funciona uma vez por noite." +
                    " Fala com seu portador em sussurros, revelando segredos das portas que abre.",9);
            las.setCaminhoImagem("imagens/ferramentas/Lásvísa.png");
            faltando.add(las);
        }
        return faltando;
    }
    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

}
