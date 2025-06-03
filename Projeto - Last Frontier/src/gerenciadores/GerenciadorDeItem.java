package gerenciadores;

import itens.*;

import java.util.Random;

public class GerenciadorDeItem {

    public Agua gerarItemAgua(){

        //Objetos de Água:
        Agua cantilDeAgua = new Agua("Cantil de Água", 1, 10,9,4);
        Agua aguaPotavelDoLago = new Agua("Água Potável do Lago",1,10,10,3);
        Agua barrilDeAgua = new Agua("Barril de Água", 5,8,8,10);
        Agua poteSujoDeAgua = new Agua("Pote de Água Suja", 2,2,2,5);

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Agua[] listaItensAgua = {cantilDeAgua, aguaPotavelDoLago,barrilDeAgua, poteSujoDeAgua};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensAgua.length);

        //Aqui, estaremos obtendo o elemento da lista que foi sorteado, iremos mostrar ao usuário!
        Agua aguaSorteada = listaItensAgua[indiceSorteado];
        System.out.println("Você achou " + aguaSorteada.getNomeItem()  + "!");
        System.out.println("Volume: " + aguaSorteada.getVolumeAgua() + "L");
        return aguaSorteada;


    }

    public Alimento gerarItemAlimento(){

        //Objetos de Alimentos:
        Alimento mel = new Alimento("Ramos de Mel Silvestre", 1, 2, 8, "Ramos Vegetais", 8);
        Alimento carneAnimal = new Alimento("Pedaço de Carne de Animal", 5, 6, 15, "Carne Animal", 5);
        Alimento fruta = new Alimento("Punhado de Frutas Variadas", 4, 7, 10, "Frutas Variadas", 8);
        Alimento poteAlimento = new Alimento("Pote de Vaelra Selado", 3, 6, 20, "Pote de Vaelra", 10);
        Alimento peixe = new Alimento("Peixe Fresco Grelhado", 4, 8, 12, "Carne de Peixe", 10);
        Alimento carnePodre = new Alimento("Carcaça Apodrecida", 5, 1, 5, "Carne Apodrecida", 2);

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Alimento[] listaItensAlimentos = {mel, carneAnimal, fruta, poteAlimento, peixe, carnePodre};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensAlimentos.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar o seu nome e descrição:
        Alimento alimentoSorteado = listaItensAlimentos[indiceSorteado];
        System.out.println("Você achou: " + alimentoSorteado.getNomeItem() + "!");
        System.out.println("Tipo: " + alimentoSorteado.getTipoAlimento());
        return alimentoSorteado;

    }

    public Remedio gerarItemRemedio(){

        //Objetos de Remedio:
        Remedio antibiotico = new Remedio("Myrsillblóð",2,4,"Antibiótico","Um extrato espesso e amargo retirado de raízes que crescem apenas nas encostas sombreadas do Fjellgraad. Quando ingerido ou aplicado em feridas," +
                " \nimpede que infecções se espalhem, mesmo aquelas causadas por criaturas corrompidas. Tem cheiro de terra molhada e cobre.", 15 );
        Remedio analgesico = new Remedio("Draumrlyng", 2,4,"Analgésico", "Uma infusão feita com pétalas azuis e sementes negras." +
                " \nAlivia dores físicas ao induzir uma calma sonolência, quase onírica." +
                " Xamãs dizem que o espírito “sai por um instante” e retorna mais leve.", 10);
        Remedio antidoto = new Remedio("Eitrskjarr",2,4,"Antídoto", "Uma pasta verde viva feita com folhas fervidas de Skjarrun, planta que cresce perto de tocas de víboras." +
                " \nQuando ingerida ou aplicada sobre feridas venenosas, neutraliza toxinas naturais e arcanas em minutos." +
                " Seu gosto é descrito como “ferro com trovão”", 5);
        Remedio bandagem = new Remedio("Vefrbind",2,4,"Bandagem", "Tiras de linho consagrado embebidas em seiva de árvore antiga. A bandagem acelera a cicatrização e gruda levemente na pele ao toque," +
                " \ncomo se estivesse viva. Quando removida, queima as impurezas da ferida suavemente.", 20);

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Remedio[] listaItensRemedios = {antibiotico, analgesico, antidoto, bandagem};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensRemedios.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar o seu nome, tipo e efeito:
        Remedio remedioSorteado = listaItensRemedios[indiceSorteado];
        System.out.println("Você achou: " + remedioSorteado.getNomeItem() + "-" + remedioSorteado.getTipoRemedio());
        System.out.println("Efeito: " + remedioSorteado.getEfeitoRemedio());
        return remedioSorteado;

    }

    public Arma gerarItemArmas(){

        //Objetos de armas:
        Arma cajado = new Arma("Vetrkvistr - Cajado", 4,9,"Arma à distância",10,10);
        Arma arco = new Arma("Naustrál - Arco",5,8,"Arma à distância",8,10);
        Arma espada = new Arma("Deyðrblóð - Espada",7,9,"Arma corpo a corpo",10,2);
        Arma lanca = new Arma("Skjalfheimr - Lança ",4,6,"Arma à distância",8,10);
        Arma gancho = new Arma("Hyrndrgrip - Gancho",4,8,"Arma corpo a corpo",8,2);
        Arma faca = new Arma("Kviðskera - Faca",4,9,"Arma corpo a corpo",9,2);
        Arma escudo = new Arma("Vardstein - Escudo",5, 8, "Arma corpo a corpo", 4, 2);

        //O Randomizador de Armas deve ser tratado posteriormente!!

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Arma[] listaItensArmas = {cajado, arco, espada, lanca, gancho, faca, escudo};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensArmas.length);

        //Aqui, estaremos obtendo o elemento da lista que foi sorteado, iremos mostrar ao usuário!
        Arma armaSorteada = listaItensArmas[indiceSorteado];
        System.out.println("Você achou " + armaSorteada.getNomeItem()  + "!");
        System.out.println("Tipo de Arma: " + armaSorteada.getTipoArma());
        return armaSorteada;

    }

    public Ferramenta gerarItemFerramentas(){

        //Objetos de Ferramentas:
        Ferramenta machado = new Ferramenta("Skallhjǫrr - Machado",7,9,"Um machado de duas lâminas negras, forjado com ferro retirado de túmulos de gigantes." +
                "\n Dizem que ele nunca lasca e corta até através de magia. Vibrar com ele nas mãos causa calafrios… mesmo ao empunhador.",9);
        Ferramenta picareta = new Ferramenta("Grjótkló - Picareta", 1,6,"Tem dentes de metal azulado, capazes de cortar qualquer rocha, até as encantadas." +
                " Cada batida deixa um rastro cintilante que brilha por poucos segundos — útil em passagens escuras.",8);
        Ferramenta lanterna = new Ferramenta("Ljósmodir - Lanterna",2,8,"Uma lanterna de latão antigo que emite uma chama azulada, alimentada não por óleo," +
                "\n mas por fragmentos de sonhos." +
                " Sua luz afasta ilusões, espectros e revela inscrições ocultas.",9);
        Ferramenta chave = new Ferramenta("Lásvísa - Chave",4,8,"Pequena e ornamentada, feita de prata viva. Molda-se a qualquer fechadura antiga," +
                "\n mas só funciona uma vez por noite." +
                " Fala com seu portador em sussurros, revelando segredos das portas que abre.",9);
        Ferramenta martelo = new Ferramenta("Dundrhamarr - Martelo",4,8,"Um martelo de construção e combate que emite uma pancada seca sem som," +
                "\n como se o ar se curvasse. Pode quebrar pedra sem eco — ideal para ruínas ou cavernas onde barulho atrairia horrores.",10);
        Ferramenta corda = new Ferramenta("Seidrreip - Corda",4,8,"Uma corda trançada com fios de pelo de criatura mágica e seda de aranha espiritual. Estica ou encolhe conforme a vontade do usuário." +
                "\n Pode se firmar sozinha em superfícies ou prender inimigos brevemente." ,10);

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Ferramenta[] listaItensFerramentas = {machado, picareta, lanterna, chave, martelo, corda};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensFerramentas.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar ao usuário nome, eficiência e descrição
        Ferramenta ferramentaSorteada = listaItensFerramentas[indiceSorteado];
        System.out.println("Você achou " + ferramentaSorteada.getNomeItem()  + " - Eficiência:" + ferramentaSorteada.getEficienciaFerramenta());
        System.out.println("Tipo da Ferramenta: "  + ferramentaSorteada.getTipoFerramenta());
        return ferramentaSorteada;
    }

    public Material gerarItemMateriais(){

        //Objetos de Materiais:
        Material madeira = new Material("Asktreplate - Madeira",6,7,"Recurso de construção, Tábua resistente feita da madeira de Dravnir, a árvore primordial",7);
        Material ferro = new Material("Járnstykket - Ferro",8,9,"Pedaço de ferro forjado nas chamas de Eldthórr ",9);
        Material pedra = new Material("Steinblokk - Pedra",8,9,"Bloco bruto de pedra extraído das montanhas de Hrafntindr",9);
        Material couro = new Material("Úlfarskinn - Couro",5,7,"Couro espesso tratado com óleos, vindo de lobos da floresta de Skógrheimr.",10);
        Material arame = new Material("Línvǫrr - Arame",3,7,"Fio metálico trançado, usado em armadilhas e mecanismos rúnicos.",9);
        Material pilha = new Material("Eldgnista - Pilha",2,9,"Fonte de energia portátil, usada pelos anões para alimentar engenhocas mágicas.",9);

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Material[] listaItensMateriais = {madeira, ferro, pedra, couro, arame, pilha};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensMateriais.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar o seu nome, tipo e efeito:
        Material materialSorteado = listaItensMateriais[indiceSorteado];
        System.out.println("Você achou: " + materialSorteado.getNomeItem() + "!");
        System.out.println("Tipo de Material: " + materialSorteado.getTipoMaterial());
        return materialSorteado;
    }

    public Item gerarItemAleatorioGlobal() {
        Random sorteadorCategoria = new Random();
        int categoriaSorteada = sorteadorCategoria.nextInt(6);

        Item itemGerado = null;

        System.out.println("Você vasculha os arredores em busca de algo útil...");

        switch (categoriaSorteada) {
            case 0:
                itemGerado = gerarItemAgua();
                break;
            case 1:
                itemGerado = gerarItemAlimento();
                break;
            case 2:
                itemGerado = gerarItemRemedio();
                break;
            case 3:
                itemGerado = gerarItemArmas();
                break;
            case 4:
                itemGerado = gerarItemFerramentas();
                break;
            case 5:
                itemGerado = gerarItemMateriais();
                break;
            default:
                System.out.println("Estranhamente, você não encontrou nada desta vez.");
                return null;
        }
        return itemGerado;
    }
}
