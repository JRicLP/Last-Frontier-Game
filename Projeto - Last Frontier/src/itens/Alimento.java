package itens;
import interfaces.AcoesItens;
import personagens.Personagem;

public class Alimentos extends Item implements AcoesItens {
    //Atributos da subclasse
    private int valorNutricional;
    private String tipoAlimento;
    private int prazoValidade;
    //Metodo construtor:
    public Alimentos(String nomeItem, int pesoItem, int durabilidadeItem, int valorNutricional, String tipoAlimento, int prazoValidade) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.valorNutricional = valorNutricional;
        this.tipoAlimento = tipoAlimento;
        this.prazoValidade = prazoValidade;
    }
    //Metodos acessores:
    public void setValorNutricional(int valorNutricional){
        this.valorNutricional = valorNutricional;
    }
    public int getValorNutricional(){
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
    @Override
    public void usar (Item item,Personagem personagem) {
        if(!(item instanceof Alimentos)){
            System.out.println("ERRO");
            System.out.println("Este item não é um Alimento!");
            return;
        }

        int fomeAtual= personagem.getFomePersonagem();
        int novaFome= fomeAtual+(int) this.getValorNutricional();

        if(novaFome>personagem.getFomeInicialPersonagem()){
            novaFome=personagem.getFomeInicialPersonagem(); // Não vai ultrapassar o limite de fome de cada personagem
        }
        personagem.setFomePersonagem(novaFome);
        switch(tipoAlimento){
            case "Carne Animal":
                System.out.println("Você comeu carne Animal! Restaurou 15 pontos de fome");
                break;
            case "Frutas Variadas":
                System.out.println("Você comeu uma fruta! Restaurou 10 pontos de fome");
                break;
            case " Carne de Peixe":
                System.out.println("Você comeu peixe! Restaurou 10 pontos de fome");
                break;
            case "Carne Apodrecida":
                System.out.println("Você comeu uma carne Podre! Restaurou 15 pontos de fome");
                break;
            case "Pote de Vaelra":
                System.out.println("Você achou uma lata com comida!! Restaurou 8 pontos de fome e 10 pontos de Sanidade");
                personagem.setSanidadePersonagem(personagem.getSanidadePersonagem()+10);
                break;
            case "Ramos Vegetais":
                System.out.println(" Você achou Ramos Vegetais! Restaurou 8 pontos de fome e 10 pontos de energia!");
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

        System.out.println("Você está contaminado!");
        System.out.println("Você perderá 15 pontos de vida se não tomar um antídoto");

        if(personagem.getContaminacaoPersonagem()) {
            personagem.setVidaPersonagem(personagem.getVidaPersonagem() - 15);
            if (personagem.getVidaPersonagem() <= 0) {
                System.out.println("Você morreu por Intoxicação!");
            }
        }else{
            System.out.println("Você foi curado! O dano foi interrompido.");
        }


    }
}
