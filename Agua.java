package itens;

import personagens.Personagem;

public class Agua extends Item {
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
    public void beber(Personagem personagem) {
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
        while (personagem.getVidaPersonagem() > 0 && personagem.getContaminacaoPersonagem()) {
            System.out.println("Seus pontos de vida estão baixando...: " + personagem.getVidaPersonagem());
            personagem.setVidaPersonagem(personagem.getVidaPersonagem() - 2);

            if (personagem.getVidaPersonagem() <= 0) {
                System.out.println("Você morreu por causa da água contaminada!");
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
