package itens;

import interfaces.AcoesItens;
import personagens.Personagem;

public class Remedios extends Item  implements AcoesItens {
    //Atributos da subclasse:
    private String tipoRemedio;
    private String efeitoRemedio;

    //Metodo construtor:
    public Remedios(String nomeItem, int pesoItem, int durabilidadeItem, String tipoRemedio, String efeitoRemedio) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoRemedio = tipoRemedio;
        this.efeitoRemedio = efeitoRemedio;
    }

    //Metodos acessores:
    public void setTipoRemedio(String tipoRemedio) {
        this.tipoRemedio = tipoRemedio;
    }

    public String getTipoRemedio() {
        return tipoRemedio;
    }

    public void setEfeitoRemedio(String efeitoRemedio) {
        this.efeitoRemedio = efeitoRemedio;
    }

    public String getEfeitoRemedio() {
        return efeitoRemedio;
    }

    //Metodo sobrescrito:
    @Override
    public void usar(Item item, Personagem personagem) {
        if (!(item instanceof Remedios)){
            System.out.println("ERRO");
            System.out.println("Este item não é um remédio!");
            return;
        }

        if (personagem.getContaminacaoPersonagem()) {
            personagem.setContaminacaoPersonagem(false); // Cura a contaminação

            switch (tipoRemedio) {
                case "Myrsillblóð":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem() + 10);
                    System.out.println("Você usou um tipo de antibiótico, o Myrsillblóð! Sua infecção foi curada. Você ganhou 10 pontos de vida.");
                    break;
                case "Draumrlyng":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem() + 10);
                    System.out.println("Você usou um tipo de analgésico, o Draumrlyng! Agora suas dores irão passar. Você ganhou 10 pontos de vida.");
                    break;
                case "Vefrbind":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem() + 10);
                    System.out.println("Você usou um tipo de bandagem, a Vefrbind! Seus ferimentos começaram a cicatrizar. Você ganhou 10 pontos de vida.");
                    break;
                case "Eitrskjarr":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem() + 10);
                    personagem.setSanidadePersonagem(personagem.getSanidadePersonagem()+8);
                    System.out.println("Você usou um tipo de antídoto,o Eitrskjarr! Você foi curado e ganhou 10 pontos de vida e 8 pontos de sanidade.");
                    break;
                default:
                    System.out.println("Tipo de remédio desconhecido. Nenhum efeito ocorreu.");
                    return;
            }

            System.out.println("Sua vida atual: " + personagem.getVidaPersonagem());
            System.out.println("Continue sua jornada...");
        } else {
            System.out.println("Você não está contaminado. Não há necessidade de usar remédios agora.");
        }
    }
}
