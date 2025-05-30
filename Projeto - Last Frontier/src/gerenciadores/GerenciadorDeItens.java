package gerenciadores;

import itens.*;

import java.util.Random;

public class GerenciadorDeItens {

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
        return aguaSorteada;


    }

    public Alimentos gerarItemAlimento(){

        //Objetos de Alimentos:
        Alimentos mel = new Alimentos("Ramos Vegetais", 1,2,5,"Ramos Vegetais que ficam na Floresta de Skógrheimr.",8);
        Alimentos carneAnimal = new Alimentos("Carne Animal", 5,6,15,"Carne Animal, tão forte quanto os seus provedores", 5);
        Alimentos fruta = new Alimentos("Frutas Variadas", 4,7,10,"Frutas Variadas que ficam na Floresta de Skógrheimr",8);
        Alimentos poteAlimentos = new Alimentos("Pote de Vaelra",3,6,20,"O Pote de Vaelra é um item muito raro, restaura todas as condições",10);
        Alimentos peixe = new Alimentos("Carne de Peixe",4,8,12,"Carne de Peixe, nutritiva e saborosa, contribuirá na sua jornada",10);
        Alimentos carnePodre = new Alimentos("Carne Apodrecida",5,1,15,"Carne Apodrecida, irá contaminar você", 4);

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Alimentos[] listaItensAlimentos = {mel, carneAnimal, fruta, poteAlimentos, peixe, carnePodre};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensAlimentos.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar o seu nome e descrição:
        Alimentos alimentoSorteado = listaItensAlimentos[indiceSorteado];
        System.out.println("Você achou: " + alimentoSorteado.getNomeItem() + "!");
        System.out.println(alimentoSorteado.getTipoAlimento());
        return alimentoSorteado;

    }

    public Remedios gerarItemRemedio(){

        //Objetos de Remedio:
        Remedios antibiotico = new Remedios("Myrsillblóð",2,4,"Antibiótico","Um extrato espesso e amargo retirado de raízes que crescem apenas nas encostas sombreadas do Fjellgraad. Quando ingerido ou aplicado em feridas," +
                " impede que infecções se espalhem, mesmo aquelas causadas por criaturas corrompidas. Tem cheiro de terra molhada e cobre." );
        Remedios analgesico = new Remedios("Draumrlyng", 2,4,"Analgésico", "Uma infusão feita com pétalas azuis e sementes negras. Alivia dores físicas ao induzir uma calma sonolência, quase onírica." +
                " Xamãs dizem que o espírito “sai por um instante” e retorna mais leve.");
        Remedios antidoto = new Remedios("Eitrskjarr",2,4,"Antídoto", "Uma pasta verde viva feita com folhas fervidas de Skjarrun, planta que cresce perto de tocas de víboras. Quando ingerida ou aplicada sobre feridas venenosas, neutraliza toxinas naturais e arcanas em minutos." +
                " Seu gosto é descrito como “ferro com trovão”");
        Remedios bandagem = new Remedios("Vefrbind",2,4,"Bandagem", "Tiras de linho consagrado embebidas em seiva de árvore antiga. A bandagem acelera a cicatrização e gruda levemente na pele ao toque," +
                " como se estivesse viva. Quando removida, queima as impurezas da ferida suavemente.");

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Remedios[] listaItensRemedios = {antibiotico, analgesico, antidoto, bandagem};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensRemedios.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar o seu nome, tipo e efeito:
        Remedios remedioSorteado = listaItensRemedios[indiceSorteado];
        System.out.println("Você achou: " + remedioSorteado.getNomeItem() + "-" + remedioSorteado.getTipoRemedio());
        System.out.println(remedioSorteado.getEfeitoRemedio());
        return remedioSorteado;

    }

    public Armas gerarItemArmas(){

        //Objetos de armas:
        Armas cajado = new Armas("Vetrkvistr", 4,9,"Arma à distância",10,10);
        Armas arco = new Armas("Naustrál",5,8,"Arma à distância",8,10);
        Armas espada = new Armas("Deyðrblóð",7,9,"Arma corpo a corpo",10,2);
        Armas lanca = new Armas("Skjalfheimr ",4,6,"Arma à distância",8,10);
        Armas gancho = new Armas("Hyrndrgrip",4,8,"Arma corpo a corpo",8,2);
        Armas faca = new Armas("Kviðskera",4,9,"Arma corpo a corpo",9,2);
        Armas escudo = new Armas("Vardstein",5, 8, "Arma corpo a corpo", 4, 2);

        //O Randomizador de Armas deve ser tratado posteriormente!!

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Armas[] listaItensArmas = {cajado, arco, espada, lanca, gancho, faca, escudo};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensArmas.length);

        //Aqui, estaremos obtendo o elemento da lista que foi sorteado, iremos mostrar ao usuário!
        Armas armaSorteada = listaItensArmas[indiceSorteado];
        System.out.println("Você achou " + armaSorteada.getNomeItem()  + "!");
        return armaSorteada;

    }

    public Ferramentas gerarItemFerramentas(){

        //Objetos de Ferramentas:
        Ferramentas machado = new Ferramentas("Skallhjǫrr",7,9,"Um machado de duas lâminas negras, forjado com ferro retirado de túmulos de gigantes. Dizem que ele nunca lasca e corta até através de magia." +
                " Vibrar com ele nas mãos causa calafrios… mesmo ao empunhador.",9);
        Ferramentas picareta = new Ferramentas("Grjótkló", 1,6,"Tem dentes de metal azulado, capazes de cortar qualquer rocha, até as encantadas." +
                " Cada batida deixa um rastro cintilante que brilha por poucos segundos — útil em passagens escuras.",8);
        Ferramentas lanterna = new Ferramentas("Ljósmodir",2,8,"Uma lanterna de latão antigo que emite uma chama azulada, alimentada não por óleo, mas por fragmentos de sonhos." +
                " Sua luz afasta ilusões, espectros e revela inscrições ocultas.",9);
        Ferramentas chave = new Ferramentas("Lásvísa",4,8,"Pequena e ornamentada, feita de prata viva. Molda-se a qualquer fechadura antiga, mas só funciona uma vez por noite." +
                " Fala com seu portador em sussurros, revelando segredos das portas que abre.",9);
        Ferramentas martelo = new Ferramentas("Dundrhamarr",4,8,"Um martelo de construção e combate que emite uma pancada seca sem som, como se o ar se curvasse." +
                " Pode quebrar pedra sem eco — ideal para ruínas ou cavernas onde barulho atrairia horrores.",10);
        Ferramentas corda = new Ferramentas("Seidrreip",4,8,"Uma corda trançada com fios de pelo de criatura mágica e seda de aranha espiritual. Estica ou encolhe conforme a vontade do usuário." +
                " Pode se firmar sozinha em superfícies ou prender inimigos brevemente." ,10);

        //O Randomizador de Ferramentas deve ser tratado posteriormente!!

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Ferramentas[] listaItensFerramentas = {machado, picareta, lanterna, chave, martelo, corda};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensFerramentas.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar ao usuário nome, eficiência e descrição
        Ferramentas ferramentaSorteada = listaItensFerramentas[indiceSorteado];
        System.out.println("Você achou " + ferramentaSorteada.getNomeItem()  + " - Eficiência:" + ferramentaSorteada.getEficienciaFerramenta());
        System.out.println(ferramentaSorteada.getTipoFerramenta());
        return ferramentaSorteada;
    }

    public Materiais gerarItemMateriais(){

        //Objetos de Materiais:
        Materiais madeira = new Materiais("Asktreplate",6,7,"Recurso de construção, Tábua resistente feita da madeira de Dravnir, a árvore primordial",7);
        Materiais ferro = new Materiais("Járnstykket",8,9,"Pedaço de ferro forjado nas chamas de Eldthórr ",9);
        Materiais pedra = new Materiais("Steinblokk",8,9,"Bloco bruto de pedra extraído das montanhas de Hrafntindr",9);
        Materiais couro = new Materiais("Úlfarskinn",5,7,"Couro espesso tratado com óleos, vindo de lobos da floresta de Skógrheimr.",10);
        Materiais arame = new Materiais("Línvǫrr",3,7,"Fio metálico trançado, usado em armadilhas e mecanismos rúnicos.",9);
        Materiais pilha = new Materiais("Eldgnista",2,9,"Fonte de energia portátil, usada pelos anões para alimentar engenhocas mágicas.",9);

        //Lista com os Objetos, utilizaremos uma probabilidade forçada:
        Materiais[] listaItensMateriais = {madeira, ferro, pedra, couro, arame, pilha};

        //Realizador do sorteio:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaItensMateriais.length);

        //Aqui, estaremos a obter o elemento da lista que foi sorteado, iremos mostrar o seu nome, tipo e efeito:
        Materiais materialSorteado = listaItensMateriais[indiceSorteado];
        System.out.println("Você achou: " + materialSorteado.getNomeItem() + "!");
        System.out.println(materialSorteado.getTipoMaterial());
        return materialSorteado;
    }
}

