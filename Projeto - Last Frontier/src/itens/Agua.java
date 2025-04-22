package itens;

import interfaces.ItensActions;
import personagens.Personagem;

public class Agua extends Item implements ItensActions {
    //Atributos da subclasse:
    private double purezaAgua;
    private double volumeAgua;
    //Métodos construtor::
    public Agua(String nomeItem, double pesoItem, double durabilidadeItem, double purezaAgua, double volumeAgua) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.purezaAgua = purezaAgua;
        this.volumeAgua = volumeAgua;
    }
    //Metodos acessores:
    public void setPurezaAgua(double purezaAgua) {
        this.purezaAgua = purezaAgua;
    }
    public double getPurezaAgua() {
        return purezaAgua;
    }
    public void setVolumeAgua(double volumeAgua) {
        this.volumeAgua = volumeAgua;
    }
    public double getVolumeAgua() {
        return volumeAgua;
    }
    //Metodo sobrescrito:
    @Override
    public void usar(Item item,Personagem personagem) {
        if(!(item instanceof Agua)) {
            System.out.println("ERRO");
            System.out.println("Este item não é nenhuma bebida!");
            return;
        }
        Agua agua=(Agua) item;
        // Cálculo da hidratação proporcional ao volume da água
        double sedeAtual = personagem.getSedePersonagem();
        double novaSede = sedeAtual - (int) this.getVolumeAgua();

        if (novaSede <0) {
            novaSede = 0; // não ultrapassa o limite máximo de sede
        }

        personagem.setSedePersonagem(novaSede);
        if(this.getPurezaAgua()>=7){
            System.out.println("Sede saciada! Continue sua jornada");
        }else{
            System.out.println("Sua sede foi restaurada mas era água contaminada!!!");
            personagem.setContaminacaoPersonagem(true);
            System.out.println("Você precisa de um antídoto!!!");
            danoPorContaminacao(personagem);
        }
    }
    private void danoPorContaminacao(Personagem personagem) {
        System.out.println("Você está contaminado!");
        System.out.println("Você perderá 15 pontos de vida se não tomar um antídoto");
        if (personagem.getContaminacaoPersonagem()) {
            personagem.setVidaPersonagem(personagem.getVidaPersonagem() - 15);
            if (personagem.getVidaPersonagem() <= 0) {
                System.out.println("Você morreu por causa da água contaminada!");
            }
        } else {
            System.out.println("Você foi curado! O dano foi interrompido.");
        }

    }
}
