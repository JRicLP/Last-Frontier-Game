package itens;
import personagens.Personagem;

public class Alimentos extends Item  {
    //Atributos da subclasse
    private double valorNutricional;
    private String tipoAlimento;
    private int prazoValidade;
    //Metodo construtor:
    public Alimentos(String nomeItem, double pesoItem, double durabilidadeItem, double valorNutricional, String tipoAlimento, int prazoValidade) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.valorNutricional = valorNutricional;
        this.tipoAlimento = tipoAlimento;
        this.prazoValidade = prazoValidade;
    }
    //Metodos acessores:
    public void setValorNutricional(double valorNutricional){
        this.valorNutricional = valorNutricional;
    }
    public double getValorNutricional(){
        return valorNutricional;
    }
    public void setTipoAlimento(String tipoAlimento){
        this.tipoAlimento = tipoAlimento;
    }
    public String getTipoAlimento(){
        return tipoAlimento;
    }
    public void setPrazoValidade(int prazoValidade){
        this.prazoValidade = prazoValidade;
    }
    public int getPrazoValidade(){
        return prazoValidade;
    }

    //Metodo sobrescrito
    public void consumir(Personagem personagem) {
        double fomeAtual= personagem.getFomePersonagem();
        double novaFome= fomeAtual- (int) this.getValorNutricional();

        if(novaFome<0){
            novaFome=0; // Não vai ultrapassar o limite de fome de cada personagem
        }
        personagem.setFomePersonagem(novaFome);
        switch(tipoAlimento){
            case "Carne":
                System.out.println("Você comeu carne! Restaurou 20 pontos de fome");
                break;
            case "Fruta":
                System.out.println("Você comeu uma fruta! Restaurou 15 pontos de fome");
                break;
            case "Peixe":
                System.out.println("Você comeu peixe! Restaurou 20 pontos de fome");
                break;
            case "Fruta Podre":
                System.out.println("Você comeu uma fruta Podre! Restaurou 15 pontos de fome");
                break;
            case "lata com comida":
                System.out.println("Você achou uma lata com comida!! Restaurou 20 pontos de fome");
                break;
            case "Mel":
                System.out.println(" Você achou Mel! Restaurou 10 pontos de fome e 10 pontos de energia!");
                personagem.setEnergiaPersonagem(personagem.getEnergiaPersonagem()+10);
                break;
            default:
                System.out.println("Comida não identificada");
        }

        if(this.getPrazoValidade()>=6){
            System.out.println("Fome saciada! Continue sua jornada...");
        }else{
            System.out.println("Sua fome foi restaurada mas você comeu comida vencida!");
            personagem.setContaminacaoPersonagem(true);
            System.out.println("Você precisa de um antídoto!");
            danoPorContaminacao(personagem);
        }
    }

    private void danoPorContaminacao(Personagem personagem){
        while (personagem.getVidaPersonagem() > 0 && personagem.getContaminacaoPersonagem()) {
            System.out.println("Seus pontos de vida estão baixando...: " + personagem.getVidaPersonagem());
            personagem.setVidaPersonagem(personagem.getVidaPersonagem() - 2);

            if (personagem.getVidaPersonagem() <= 0) {
                System.out.println("Você morreu por Intoxicação Alimentar!");
                break;
            }
            try {
                Thread.sleep(2000); // espera 2 segundos antes de continuar o dano
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!personagem.getContaminacaoPersonagem()) {
            System.out.println("Você foi curado! O dano foi interrompido.");
        }


    }
}
