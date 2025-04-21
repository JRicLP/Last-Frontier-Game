package itens;

import personagens.Personagem;

public class Remedios extends Item {
    //Atributos da subclasse:
    private String tipoRemedio;
    private String efeitoRemedio;
    //Metodo construtor:
    public Remedios(String nomeItem, double pesoItem, double durabilidadeItem, String tipoRemedio, String efeitoRemedio){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoRemedio = tipoRemedio;
        this.efeitoRemedio = efeitoRemedio;
    }
    //Metodos acessores:
    public void setTipoRemedio(String tipoRemedio){
        this.tipoRemedio = tipoRemedio;
    }
    public String getTipoRemedio(){
        return tipoRemedio;
    }
    public void setEfeitoRemedio(String efeitoRemedio){
        this.efeitoRemedio = efeitoRemedio;
    }
    public String getEfeitoRemedio() {
        return efeitoRemedio;
    }

    //Metodo sobrescrito:
    public boolean usar(Personagem personagem) {
        if (personagem.getContaminacaoPersonagem()) {// implementar os pontos acrescentados em cada cura, e retornar esse valor pra vida do personagem
            personagem.setContaminacaoPersonagem(false); //cura a contaminação

            switch (tipoRemedio) {
                case "Antibiótico":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem()+10);
                    System.out.println("Você usou o antibiótico! Sua infecção foi curada!Você ganhou 10 pontos de vida");
                    System.out.println("Continue sua jornada...");
                    break;
                case "Analgésico":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem()+10);
                    System.out.println("Você usou o Analgésico! Agora suas dores irão sanar! Você ganhou 10 pontos de vida");
                    System.out.println("Sua vida atual :"+ personagem.getVidaPersonagem());
                    System.out.println("Continue sua jornada...");
                    break;
                case "Bandagem":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem()+10);
                    System.out.println("Você usou a Bandagem! Seus ferimentos irão cicatrizar, você ganhou 10 pontos de vida");
                    System.out.println("Sua vida atual: "+personagem.getVidaPersonagem());
                    System.out.println("Continue sua jornada...");
                    break;
                case "Antídoto":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem()+10);
                    System.out.println(" Você usou o Antídoto! Você foi curado!");
                    System.out.println("Sua vida atual: "+ personagem.getVidaPersonagem());
                    System.out.println("Continue sua jornada...");
                    break;
                default:
                    System.out.println("Ainda está perdendo vida!!!");
                    return false;
            }
            return true;

        }else{
            System.out.println("Você não está contaminado, não precisa usar os remédios!");
            return false;
        }
    }
}
