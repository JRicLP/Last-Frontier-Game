package eventos;

public class EventoAnimais extends EventoCriatura{
    public EventoAnimais(String nomeEvento, String descricaoEvento, double probabilidadeEvento, String impactoEvento, String condicaoEvento, String tipoCriatura,
                         double nivelPerigo, String opcaoAcao) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento, tipoCriatura, nivelPerigo, opcaoAcao);
    }

    public void exibirAnimal(){
        System.out.println("Animal: ");
        System.out.println("Nível de Perigo: ");
        System.out.println(" Opção de Ação: ");
        System.out.println("-----------------------------------");
    }

    public void criarAnimalDinamico(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                                    String impactoEvento, String condicaoEvento, String tipoCriatura,
                                    double nivelPerigo, String opcaoAcao){
        EventoAnimais animal=new EventoAnimais(nomeEvento, descricaoEvento, probabilidadeEvento,
                impactoEvento, condicaoEvento, tipoCriatura, nivelPerigo, opcaoAcao);

        animal.exibirAnimal();
    }

    public void gerarAnimais(){
        EventoAnimais lobo=new EventoAnimais("Ataque de Lobo", "O lobo ataca o personagem em busca de comida", 0.8,
                "Redução de vida", "Ocorre quando o personagem estiver com muita comida na floresta",
                "Lobo Selvagem", 9, "Perde 15 pontos de vida no ataque e perde comida");

        EventoAnimais cobra=new EventoAnimais("Ataque de Cobra","A cobra pica o personagem", 0.7,
                "Redução de vida"," Ocorre quando o personagem estiver dentro de cavernas ou buracos",
                " Cobra Venenosa", 10, "perde 10 pontos de vida progressivamente até achar antídoto");

        EventoAnimais corvos=new EventoAnimais("Ataque de Corvos", " Os corvos ficam o rodeado e gerando alucinações",
                0.8, " Redução de sanidade", "Ocorre quando ele estiver nas montanhas",
                " Corvos Furtivos", 9, "Faz a sanidade diminuir 20 pontos ");

        EventoAnimais serpente=new EventoAnimais("Surpresa de Serpente", "A serpente das areias podem picar rapidamente o personagem",
                0.5, "Redução de vida", " Ocorre quando ele estiver nas ruinas", "Serpente das areias",
                5, "Picada rápida e com dor momentânea, o personagem perde 5 pontos de vida");

        EventoAnimais javali=new EventoAnimais("Aparição de Javali", "Os javalis vivem na florestam e servem de comida", 0.8,
                "Aumento de comida", "Ocorre quando o jogador estiver com muita fome", "Javali",
                0, " inofensivo, serve de caça na floresta, serve de comida");

        EventoAnimais cervo=new EventoAnimais("Aparição de cervo", "O cervo aparece nas florestas para guiar o personagem em ambientes escuros", 0.9,
                "Encontrar sáida", " Acontece quando o personagem está perdido nas partes escuras dos ambientes",
                "Cervo Brilhante", 0, " Guia nos ambientes escuros");

        EventoAnimais tartaruga=new EventoAnimais("Aparição de Tartaruga ", "A tartaruga medicinal ajuda o personagem a encontrar ervas medicinais para antídotos",
                0.8, "Conserva a vida"," Ocorre quando o personagem estiver muito de antídotos, e quando ele estiver pelos rios e florestas",
                "Tartaruga Medicinal", 0," pode carregar ervas raras na sua carapaça, também indica o local dessas plantas");

        EventoAnimais peixe=new EventoAnimais(" Aparição de peixe", "Os peixes estão nos rios prontos para a pesca",0.9,
                " Aumento de comida", "Ocorre quando o personagem estiver em rios e lagos", " Peixe",
                0, " Serve de comida, o personagem irá pescá-lo");
    }
}
