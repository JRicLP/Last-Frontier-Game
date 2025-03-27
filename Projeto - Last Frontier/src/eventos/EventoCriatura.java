package eventos;

public class EventoCriatura extends Eventos{
    //Atributos da subclasse:
    private String tipoCriatura;
    private double nivelPerigo;
    private String opcaoAcao;
    //Métodos da subclasse:
    public EventoCriatura(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                          String impactoEvento, String condicaoEvento, String tipoCriatura, double nivelPerigo,
                          String opcaoAcao) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoCriatura = tipoCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcaoAcao = opcaoAcao;
    }
    public void setTipoCriatura(){
        this.tipoCriatura = tipoCriatura;
    }
    public String getTipoCriatura(){
        return tipoCriatura;
    }
    public void setNivelPerigo(double nivelPerigo){
        this.nivelPerigo = nivelPerigo;
    }
    public double getNivelPerigo(){
        return nivelPerigo;
    }
    public void setOpcaoAcao(){
        this.opcaoAcao = opcaoAcao;
    }
    public String getOpcaoAcao(){
        return opcaoAcao;
    }
     public void exibirCriatura() {
        System.out.println("Criatura: " + tipoCriatura);
        System.out.println("Nível de Perigo: " + nivelPerigo);
        System.out.println("Opção de Ação: " + opcaoAcao);
        System.out.println("-------------------------------");
    }

    public void criarCriaturaDinamica(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                                      String impactoEvento, String condicaoEvento, String tipoCriatura,
                                      double nivelPerigo, String opcaoAcao) {
        EventoCriatura criatura = new EventoCriatura(  nomeEvento, descricaoEvento, probabilidadeEvento,
                impactoEvento, condicaoEvento, tipoCriatura, nivelPerigo, opcaoAcao);

        criatura.exibirCriatura();
    }

    public void gerarCriaturasIniciais() {
        criarCriaturaDinamica("Invasão Parasita", "Um parasita se prende ao personagem.", 0.7,
                "Redução progressiva de energia", "Ocorre se o personagem ficar muito tempo ferido", "Parasita", 10,
                "Drena a energia do personagem progressivamente em 10.");

        criarCriaturaDinamica("Ataque de Múmia", "O personagem está no deserto e a múmia o ataca", 0.5,
                "drena energia", " Ocorre aleatoriamente se o personagem estiver nas ruínas desertas", "Múmia", 8,
                "Drena energia, o personagem perde 10 pontos");

        criarCriaturaDinamica("Ataque de Yet", "O yet ataca o personagem nas montanhas geladas", 0.4,
                "Redução de vida no ataque", "Ocorre se o personagem ficar muito tempo nas montanhas geladas", "Yet", 9,
                "Perde 10 pontos de vida a cada ferimento");

        criarCriaturaDinamica("Sereia", "A sereia canta para o personagem quando ele estiver próximos de alguns rios", 0.6,
                "Redução da sanidade", "Ocorre se o personagem ficar perto de alguns rios", "Sereia", 10,
                " Perde a sanidade progressivamente em 10 pontos"); // personagem precisa sair do ambiente rio o mais rápido ou construir fones de ouvido para cortar o efeito.
    }
}
