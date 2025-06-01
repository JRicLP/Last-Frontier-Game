package itens;

import personagens.Personagem;

public class Agua extends Item {
    //Atributos da Subclasse:
    private int purezaAgua;
    private int volumeAgua;

    //Metodo Construtor:
    public Agua(String nomeItem, int pesoItem, int durabilidadeItem, int purezaAgua, int volumeAgua) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.purezaAgua = purezaAgua;
        this.volumeAgua = volumeAgua;
    }

    //Metodos Acessores:
    public int getPurezaAgua() {
        return purezaAgua;
    }

    public void setPurezaAgua(int purezaAgua) {
        this.purezaAgua = purezaAgua;
    }

    public int getVolumeAgua() {
        return volumeAgua;
    }

    public void setVolumeAgua(int volumeAgua) {
        this.volumeAgua = volumeAgua;
    }

    //Metodo sobrescrito refatorado:
    @Override
    public void usar(Item itemUsado, Personagem personagem) {
        System.out.println(personagem.getNomePersonagem() + " bebe " + this.getNomeItem() + ".");

        //Cálculo da hidratação
        int sedeAtual = personagem.getSedePersonagem();
        int novaSede = sedeAtual + this.getVolumeAgua();

        //Garante que não ultrapasse o limite máximo de sede (hidratação)
        if (novaSede > personagem.getSedeInicialPersonagem()) {
            novaSede = personagem.getSedeInicialPersonagem();
        }
        personagem.setSedePersonagem(novaSede);

        if (this.getPurezaAgua() >= 7) { //Supondo 7 como um limiar de pureza
            System.out.println("Sua sede foi saciada! Você se sente revigorado(a).");
        } else {
            System.out.println("A água estava um pouco turva... Sua sede foi parcialmente restaurada.");
            personagem.setContaminacaoPersonagem(true);
            System.out.println("Você se sente mal! É altamente recomendável encontrar um antídoto.");
            this.aplicarDanoPorContaminacao(personagem);
        }
        System.out.println("Nível de Hidratação Atual: " + personagem.getSedePersonagem() + "/" + personagem.getSedeInicialPersonagem());
    }

    private void aplicarDanoPorContaminacao(Personagem personagem) {

        int danoContaminacao = 15;
        System.out.println("ALERTA: CONTAMINAÇÃO! Os efeitos da água impura se manifestam.");
        System.out.println("Você perderá " + danoContaminacao + " pontos de vida devido à contaminação!");

        personagem.setVidaPersonagem(personagem.getVidaPersonagem() - danoContaminacao);
        System.out.println(personagem.getNomePersonagem() + " perdeu " + danoContaminacao + " de vida. Vida atual: " + personagem.getVidaPersonagem());

        if (personagem.getVidaPersonagem() <= 0) {
            System.out.println(personagem.getNomePersonagem() + " sucumbiu à doença causada pela água contaminada!");
        }
    }
}