package itens;

import personagens.Personagem;

public class Remedio extends Item {
    //Atributos da subclasse:
    private String tipoRemedio;
    private String efeitoRemedio;

    //Metodo construtor:
    public Remedio(String nomeItem, int pesoItem, int durabilidadeItem, String tipoRemedio, String efeitoRemedio) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoRemedio = tipoRemedio;
        this.efeitoRemedio = efeitoRemedio;
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

    //Metodo Sobrescrito:
    @Override
    public void usar(Item itemUsado, Personagem personagem) {

        System.out.println(personagem.getNomePersonagem() + " usa " + this.getNomeItem() + "...");
        boolean usouComSucesso = false; //Flag para indicar se o remédio teve algum efeito

        switch (this.getTipoRemedio()) {
            case "Antibiótico": // Corresponde ao 'tipoRemedio' passado no construtor para "Myrsillblóð"
                if (personagem.getContaminacaoPersonagem()) {
                    personagem.setContaminacaoPersonagem(false);
                    System.out.println("A infecção cedeu com o " + this.getNomeItem() + "!");
                    usouComSucesso = true;
                }
                int curaAntibiotico = 15;
                personagem.setVidaPersonagem(personagem.getVidaPersonagem() + curaAntibiotico);
                System.out.println("Você recuperou " + curaAntibiotico + " pontos de vida.");
                usouComSucesso = true;
                break;

            case "Analgésico": // Corresponde ao 'tipoRemedio' passado no construtor para "Draumrlyng"
                int curaAnalgesico = 10;
                int bonusSanidadeAnalgesico = 5;
                personagem.setVidaPersonagem(personagem.getVidaPersonagem() + curaAnalgesico);
                personagem.setSanidadePersonagem(personagem.getSanidadePersonagem() + bonusSanidadeAnalgesico);
                System.out.println("A dor diminui com o " + this.getNomeItem() + ". Você recuperou " + curaAnalgesico + " de vida e " + bonusSanidadeAnalgesico + " de sanidade.");
                usouComSucesso = true;
                break;

            case "Bandagem": // Corresponde ao 'tipoRemedio' passado no construtor para "Vefrbind"
                int curaBandagem = 20;
                personagem.setVidaPersonagem(personagem.getVidaPersonagem() + curaBandagem);
                System.out.println("Você aplicou " + this.getNomeItem() + ". Seus ferimentos parecem melhores. Você recuperou " + curaBandagem + " pontos de vida.");
                usouComSucesso = true;
                break;

            case "Antídoto": // Corresponde ao 'tipoRemedio' passado no construtor para "Eitrskjarr"
                if (personagem.getContaminacaoPersonagem()) {
                    personagem.setContaminacaoPersonagem(false);
                    System.out.println("O veneno foi neutralizado pelo " + this.getNomeItem() + "!");
                    int curaAntidoto = 5;
                    int bonusSanidadeAntidoto = 8;
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem() + curaAntidoto);
                    personagem.setSanidadePersonagem(personagem.getSanidadePersonagem() + bonusSanidadeAntidoto);
                    System.out.println("Você se sente muito melhor! Recuperou " + curaAntidoto + " de vida e " + bonusSanidadeAntidoto + " de sanidade.");
                    usouComSucesso = true;
                } else {
                    System.out.println("Você não está envenenado ou contaminado. O " + this.getNomeItem() + " não teve efeito aparente agora.");
                    usouComSucesso = true;
                }
                break;

            case "Panaceia":
                System.out.println("Você sente um poder imenso fluindo através de você!");
                personagem.setVidaPersonagem(personagem.getVidaPersonagem() + 50);
                if (personagem.getContaminacaoPersonagem()) {
                    personagem.setContaminacaoPersonagem(false);
                    System.out.println("Qualquer contaminação desaparece!");
                }
                personagem.setSanidadePersonagem(personagem.getSanidadePersonagem() + 20);
                usouComSucesso = true;
                break;

            default:
                System.out.println("Este é um tipo de remédio desconhecido ('" + this.getTipoRemedio() + "'). Nenhum efeito específico ocorreu, mas você o consumiu.");
                usouComSucesso = true;
                return;
        }
        if (usouComSucesso) {
            System.out.println("Vida atual: " + personagem.getVidaPersonagem());
            System.out.println("Sanidade atual: " + personagem.getSanidadePersonagem());
        }
    }
}