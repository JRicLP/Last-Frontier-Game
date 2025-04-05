package eventos;

public class EventoSobreviventes extends Eventos {

    private String tipoSobreviventes;
    private double nivelPerigo;
    private String opcaoAcao;

    public EventoSobreviventes(String nomeEvento, String descricaoEvento, double probabilidadeEvento, String impactoEvento, String condicaoEvento, String tipoSobreviventes,
                               double nivelPerigo, String opcaoAcao) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoSobreviventes=tipoSobreviventes;
        this.nivelPerigo=nivelPerigo;
        this.opcaoAcao=opcaoAcao;

    }

    public void exibirSobreviventes() {
        System.out.println("Tipo de sobrevivente: ");
        System.out.println("Nível de Perigo: ");
        System.out.println(" Opção de Ação: ");
        System.out.println("-----------------------------------");
    }

    public void criarSobreviventeDinamico(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                                          String impactoEvento, String condicaoEvento, String tipoSobreviventes,
                                          double nivelPerigo, String opcaoAcao) {
        EventoSobreviventes sobreviventes = new EventoSobreviventes(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento, tipoSobreviventes, nivelPerigo, opcaoAcao);
        sobreviventes.exibirSobreviventes();
    }

    public void gerarSobreviventes() {
        EventoSobreviventes aliados = new EventoSobreviventes("Aparição de sobreviventes aliados", "O aliados ajudam dando suprimentos e armas", 0.5,
                "Aumento de suprimentos", "Ocorre quando o personagem estiver no ambiente Ruínas Abandonadas",
                "Sobreviventes Aliados", 0, "Aumenta estoque de comida e encontra local seguro para descansar");
        EventoSobreviventes hostis= new EventoSobreviventes("Aparição de sobreviventes hostis"," Os hostis atacam o personagem e roubam seus suprimentos",0.5,
                "Redução de vida","Acontece quando o personagem está no ambiente Ruínas abandonadas","Sobreviventes Hostis", 6,"Redução de 2 pontos de vida a cada ataque");
    }
}
