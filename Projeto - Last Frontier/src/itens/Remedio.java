package itens;

import exceptions.SanidadeAcimaDoLimiteException;
import exceptions.VidaAcimaDoLimiteException;
import personagens.Personagem;

public class Remedio extends Item {
    //Atributos da subclasse:
    private String tipoRemedio;
    private String efeitoRemedio;
    private int curaRemedio;

    //Metodo construtor:
    public Remedio(String nomeItem, int pesoItem, int durabilidadeItem, String tipoRemedio, String efeitoRemedio, int curaRemedio) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoRemedio = tipoRemedio;
        this.efeitoRemedio = efeitoRemedio;
        this.curaRemedio=curaRemedio;
    }

    //Metodos acessores:
    public String getTipoRemedio() {
        return tipoRemedio;
    }
    public void setTipoRemedio(String tipoRemedio) {
        this.tipoRemedio = tipoRemedio;
    }
    public String getEfeitoRemedio() {
        return efeitoRemedio;
    }
    public void setEfeitoRemedio(String efeitoRemedio) {
        this.efeitoRemedio = efeitoRemedio;
    }

    public int getCuraRemedio() {
        return curaRemedio;
    }

    public void setCuraRemedio(int curaRemedio) {
        this.curaRemedio = curaRemedio;
    }

    //Metodo Sobrescrito:
    @Override
    public void usar(Item itemUsado, Personagem personagem) {

        //Variaveis modificadoras:
        int novaVida;
        int novaSanidade;

        System.out.println(personagem.getNomePersonagem() + " usa " + this.getNomeItem() + "...");
        boolean usouComSucesso = false; //Flag para indicar se o remédio teve algum efeito

        try{
            switch (this.getTipoRemedio()) {
                case "Antibiótico": // Corresponde ao 'tipoRemedio' passado no construtor para "Myrsillblóð"
                    if (personagem.getContaminacaoPersonagem()) {
                        personagem.setContaminacaoPersonagem(false);
                        System.out.println("A infecção cedeu com o " + this.getNomeItem() + "!");
                        usouComSucesso = true;
                    }
                    novaVida = personagem.getVidaPersonagem() + this.getCuraRemedio();
                    if (novaVida > personagem.getVidaInicialPersonagem()) {
                        throw new VidaAcimaDoLimiteException("A vida não pode ultrapassar o valor máximo!.");

                    }else {
                        personagem.setVidaPersonagem(novaVida);
                    }
                    System.out.println("Você recuperou " + this.getCuraRemedio() + " pontos de vida.");
                    usouComSucesso = true;
                    break;

                case "Analgésico": // Corresponde ao 'tipoRemedio' passado no construtor para "Draumrlyng"
                    int bonusSanidadeAnalgesico = 5;
                    novaVida = personagem.getVidaPersonagem() + this.getCuraRemedio();
                    novaSanidade = personagem.getSanidadePersonagem() + bonusSanidadeAnalgesico;
                    if(novaVida>personagem.getVidaInicialPersonagem()){
                        throw new VidaAcimaDoLimiteException("A vida não pode ultrapassar o valor máximo!");
                    }else {
                        personagem.setVidaPersonagem(novaVida);
                    }
                    if (novaSanidade > personagem.getSanidadeInicialPersonagem()) {
                        throw new SanidadeAcimaDoLimiteException("A sanidade não pode ultrapassar o valor Máximo.");
                    } else {
                        personagem.setSanidadePersonagem(novaSanidade);
                    }
                    System.out.println("A dor diminui com o " + this.getNomeItem() + ". Você recuperou " + this.getCuraRemedio() + " de vida e " + bonusSanidadeAnalgesico + " de sanidade.");
                    usouComSucesso = true;
                    break;

                case "Bandagem": // Corresponde ao 'tipoRemedio' passado no construtor para "Vefrbind"
                    novaVida=personagem.getVidaPersonagem()+this.getCuraRemedio();
                    if(novaVida> personagem.getVidaInicialPersonagem()){
                        throw new VidaAcimaDoLimiteException("A vida não pode ultrapassar o valor máximo!");
                    }else{
                        personagem.setVidaPersonagem((novaVida));
                    }
                    System.out.println("Você aplicou " + this.getNomeItem() + ". Seus ferimentos parecem melhores. Você recuperou " + this.getCuraRemedio() + " pontos de vida.");
                    usouComSucesso = true;
                    break;

                case "Antídoto": // Corresponde ao 'tipoRemedio' passado no construtor para "Eitrskjarr"
                    if (personagem.getContaminacaoPersonagem()) {
                        personagem.setContaminacaoPersonagem(false);
                        System.out.println("O veneno foi neutralizado pelo " + this.getNomeItem() + "!");

                        int bonusSanidadeAntidoto = 8;
                        novaVida=personagem.getVidaPersonagem() + this.getCuraRemedio();
                        novaSanidade=personagem.getSanidadePersonagem() + bonusSanidadeAntidoto;
                        if(novaVida> personagem.getVidaInicialPersonagem()){
                            throw new VidaAcimaDoLimiteException("A vida não pode ultrapassar o valor máximo!");
                        }else{
                            personagem.setVidaPersonagem(novaVida);
                        }
                        if(novaSanidade>personagem.getSanidadeInicialPersonagem()){
                            throw new SanidadeAcimaDoLimiteException("A sanidade não pode ultrapassar o valor máximo!");
                        }else{
                            personagem.setSanidadePersonagem(novaSanidade);
                        }
                        System.out.println("Você se sente muito melhor! Recuperou " + this.getCuraRemedio() + " de vida e " + bonusSanidadeAntidoto + " de sanidade.");
                        usouComSucesso = true;
                    } else {
                        System.out.println("Você não está envenenado ou contaminado. O " + this.getNomeItem() + " não teve efeito aparente agora.");
                        usouComSucesso = true;
                    }
                    break;

                case "Panaceia":
                    System.out.println("Você sente um poder imenso fluindo através de você!");
                    novaVida=(personagem.getVidaPersonagem() + this.getCuraRemedio());

                    novaSanidade=(personagem.getSanidadePersonagem() + 20);
                    if(novaVida>personagem.getVidaInicialPersonagem()){

                        throw new VidaAcimaDoLimiteException("A vida não pode ultrapassar o valor máximo!");
                    }else{
                        personagem.setVidaPersonagem(novaVida);
                    }
                    if(novaSanidade> personagem.getSanidadeInicialPersonagem()){
                        throw new SanidadeAcimaDoLimiteException("A sanidade não pode ultrapassar o valor máximo!");
                    }else{
                        personagem.setSanidadePersonagem(novaSanidade);
                    }
                    if (personagem.getContaminacaoPersonagem()) {
                        personagem.setContaminacaoPersonagem(false);
                        System.out.println("Qualquer contaminação desaparece!");
                    }
                    usouComSucesso = true;
                    break;

                default:
                    System.out.println("Este é um tipo de remédio desconhecido ('" + this.getTipoRemedio() + "'). Nenhum efeito específico ocorreu, mas você o consumiu.");
                    usouComSucesso = true;
                    return;
            }
        }catch (VidaAcimaDoLimiteException e) {
            System.out.println("Aviso: " + e.getMessage());
            personagem.setVidaPersonagem(personagem.getVidaInicialPersonagem());
        }catch(SanidadeAcimaDoLimiteException e){
            System.out.println("Aviso: "+e.getMessage());
            personagem.setSanidadePersonagem(personagem.getSanidadeInicialPersonagem());
        }
        if (usouComSucesso) {
            System.out.println("Vida atual: " + personagem.getVidaPersonagem());
            System.out.println("Sanidade atual: " + personagem.getSanidadePersonagem());
        }
    }
}