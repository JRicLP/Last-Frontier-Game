package itens;

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
  public void beber(Personagem personagem, Remedios antidoto) {
        personagem.setSedePersonagem(0);
        if(this.getPurezaAgua()>=7){
            System.out.println("Sede saciada! Continue sua jornada");
        }else{
            System.out.println("Sua sede foi restaurada mas era água contaminada!!!");
            System.out.println("Você precisa de um antídoto!!!");
            if (!antidoto.getUsado() && antidoto.usar(personagem)){
                System.out.println("Antídoto usado com sucesso! Vida estabilizada.");
                System.out.println("Vida remanescente: "+ personagem.getVidaPersonagem());
            }
            else{
                danoPorContaminacao(personagem);
            }
        }
    }
    private void danoPorContaminacao(Personagem personagem) {
        while (personagem.getVidaPersonagem() > 0) {
            System.out.println("Seus pontos de vida estão baixando...: " + personagem.getVidaPersonagem());
            personagem.setVidaPersonagem(personagem.getVidaPersonagem() - 2);

            if (personagem.getVidaPersonagem() <= 0) {
                System.out.println("Você morreu por causa da água contaminada!");
                break;
            }

        }

    }
}
