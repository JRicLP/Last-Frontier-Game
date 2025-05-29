package gerenciadores;

import itens.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciadorDeItens {

    public List<Agua> listaAgua = new ArrayList<>();
    public List<Alimentos> listaAlimentos = new ArrayList<>();
    public List<Remedios> listaRemedios = new ArrayList<>();
    public List<Armas> listaArmas = new ArrayList<>();
    public List<Ferramentas> listaFerramentas = new ArrayList<>();
    public List<Materiais> listaMateriais = new ArrayList<>();

    public GerenciadorDeItens() {
        // Água
        Agua cantil = new Agua("Cantil de Água", 1, 10, 9, 4);
        Agua lago = new Agua("Água Potável do Lago", 1, 10, 10, 3);
        Agua barril = new Agua("Barril de Água", 5, 8, 8, 10);
        Agua suja = new Agua("Pote de Água Suja", 2, 2, 2, 5);

        listaAgua.add(cantil);
        listaAgua.add(lago);
        listaAgua.add(barril);
        listaAgua.add(suja);

        // Alimentos
        Alimentos ramos = new Alimentos("Ramos Vegetais", 1, 2, 5, "Ramos Vegetais que ficam " +
                "na Floresta de Skógrheimr.", 8);
        Alimentos carneAnimal = new Alimentos("Carne Animal", 5, 6, 15, "Carne Animal, tão forte " +
                "quanto os seus provedores", 5);
        Alimentos frutas = new Alimentos("Frutas Variadas", 4, 7, 10, "Frutas Variadas que ficam na " +
                "Floresta de Skógrheimr", 8);
        Alimentos vaelra = new Alimentos("Pote de Vaelra", 3, 6, 20, "O Pote de Vaelra é um item muito " +
                "raro, restaura todas as condições", 10);
        Alimentos peixe = new Alimentos("Carne de Peixe", 4, 8, 12, "Carne de Peixe, nutritiva e saborosa," +
                " contribuirá na sua jornada", 10);
        Alimentos podre = new Alimentos("Carne Apodrecida", 5, 1, 15, "Carne Apodrecida, irá contaminar você", 4);

        listaAlimentos.add(ramos);
        listaAlimentos.add(carneAnimal);
        listaAlimentos.add(frutas);
        listaAlimentos.add(vaelra);
        listaAlimentos.add(peixe);
        listaAlimentos.add(podre);

        // Remédios
        Remedios myrsill = new Remedios("Myrsillblóð",2,4,"Antibiótico","Um extrato espesso e " +
                "amargo retirado de raízes que crescem apenas nas encostas sombreadas do Fjellgraad. Quando ingerido ou aplicado em feridas," +
                " impede que infecções se espalhem, mesmo aquelas causadas por criaturas corrompidas. Tem cheiro de terra molhada e cobre." );
        Remedios draumr = new Remedios("Draumrlyng", 2,4,"Analgésico", "Uma infusão feita com pétalas azuis e " +
                "sementes negras. Alivia dores físicas ao induzir uma calma sonolência, quase onírica." +
                " Xamãs dizem que o espírito “sai por um instante” e retorna mais leve.");
        Remedios eitr = new Remedios("Eitrskjarr",2,4,"Antídoto", "Uma pasta verde viva feita com folhas " +
                "fervidas de Skjarrun, planta que cresce perto de tocas de víboras. Quando ingerida ou aplicada sobre feridas venenosas, " +
                "neutraliza toxinas naturais e arcanas em minutos." +
                " Seu gosto é descrito como “ferro com trovão”");
        Remedios vefr = new Remedios("Vefrbind",2,4,"Bandagem", "Tiras de linho consagrado embebidas em " +
                "seiva de árvore antiga. A bandagem acelera a cicatrização e gruda levemente na pele ao toque," +
                " como se estivesse viva. Quando removida, queima as impurezas da ferida suavemente.");
        listaRemedios.add(myrsill);
        listaRemedios.add(draumr);
        listaRemedios.add(eitr);
        listaRemedios.add(vefr);

        // Armas
        Armas vetrkvistr = new Armas("Vetrkvistr", 4, 9, "Arma à distância", 10, 10);
        Armas naustral = new Armas("Naustrál", 5, 8, "Arma à distância", 8, 10);
        Armas deydrblood = new Armas("Deyðrblóð", 7, 9, "Arma corpo a corpo", 10, 2);
        Armas skjalf = new Armas("Skjalfheimr", 4, 6, "Arma à distância", 8, 10);
        Armas hyrndr = new Armas("Hyrndrgrip", 4, 8, "Arma corpo a corpo", 8, 2);
        Armas kv = new Armas("Kviðskera", 4, 9, "Arma corpo a corpo", 9, 2);//faca
        Armas vardstein = new Armas("Vardstein", 5, 8, "Arma corpo a corpo", 4, 2);

        listaArmas.add(vetrkvistr);
        listaArmas.add(naustral);
        listaArmas.add(deydrblood);
        listaArmas.add(skjalf);
        listaArmas.add(hyrndr);
        listaArmas.add(kv);
        listaArmas.add(vardstein);

        // Ferramentas
        Ferramentas skallhjorr = new Ferramentas("Skallhjǫrr",7,9,"Um machado de duas lâminas negras, " +
                "forjado com ferro retirado de túmulos de gigantes. Dizem que ele nunca lasca e corta até através de magia." +
                " Vibrar com ele nas mãos causa calafrios… mesmo ao empunhador.",9);
        Ferramentas grjotklo = new Ferramentas("Grjótkló", 1,6,"Tem dentes de metal azulado, " +
                "capazes de cortar qualquer rocha, até as encantadas." +
                " Cada batida deixa um rastro cintilante que brilha por poucos segundos — útil em passagens escuras.",8);
        Ferramentas lj = new Ferramentas("Ljósmodir",2,8,"Uma lanterna de latão antigo que emite uma" +
                " chama azulada, alimentada não por óleo, mas por fragmentos de sonhos." +
                " Sua luz afasta ilusões, espectros e revela inscrições ocultas.",9);
        Ferramentas las = new Ferramentas("Lásvísa",4,8,"Pequena e ornamentada, feita de prata viva. " +
                "Molda-se a qualquer fechadura antiga, mas só funciona uma vez por noite." +
                " Fala com seu portador em sussurros, revelando segredos das portas que abre.",9);
        Ferramentas dundr = new Ferramentas("Dundrhamarr",4,8,"Um martelo de construção e combate que emite" +
                " uma pancada seca sem som, como se o ar se curvasse." +
                " Pode quebrar pedra sem eco — ideal para ruínas ou cavernas onde barulho atrairia horrores.",10);
        Ferramentas seidr= new Ferramentas("Seidrreip",4,8,"Uma corda trançada com fios de pelo de criatura" +
                " mágica e seda de aranha espiritual. Estica ou encolhe conforme a vontade do usuário." +
                " Pode se firmar sozinha em superfícies ou prender inimigos brevemente." ,10);
        listaFerramentas.add(skallhjorr);
        listaFerramentas.add(grjotklo);
        listaFerramentas.add(lj);
        listaFerramentas.add(las);
        listaFerramentas.add(dundr);
        listaFerramentas.add(seidr);

        // Materiais
        Materiais ask = new Materiais("Asktreplate",6,7,"Recurso de construção, Tábua resistente feita da " +
                "madeira de Dravnir, a árvore primordial",7);
        Materiais jarn = new Materiais("Járnstykket",8,9,"Pedaço de ferro forjado nas chamas de " +
                "Eldthórr ",9);
        Materiais stein = new Materiais("Steinblokk",8,9,"Bloco bruto de pedra extraído das montanhas " +
                "de Hrafntindr",9);
        Materiais ulfar = new Materiais("Úlfarskinn",5,7,"Couro espesso tratado com óleos, vindo de lobos " +
                "da floresta de Skógrheimr.",10);
        Materiais lin = new Materiais("Línvǫrr",3,7,"Fio metálico trançado, usado em armadilhas e " +
                "mecanismos rúnicos.",9);
        Materiais eld = new Materiais("Eldgnista",2,9,"Fonte de energia portátil, usada pelos anões para " +
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
}
