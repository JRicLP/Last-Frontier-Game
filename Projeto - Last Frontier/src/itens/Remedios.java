package itens;

public class Remedios extends Item {
    //Atributos da subclasse:
    private String tipoRemedio;
    private String efeitoRemedio;
    private boolean usado;
    //Metodo construtor:
    public Remedios(String nomeItem, double pesoItem, double durabilidadeItem, String tipoRemedio, String efeitoRemedio, boolean usado){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoRemedio = tipoRemedio;
        this.efeitoRemedio = efeitoRemedio;
        this.usado=usado;
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
    public void setUsado(boolean usado){
        this.usado=usado;
    }
    public boolean getUsado(){
        return usado;
    }    
    //Metodo sobrescrito:
   public boolean usar(Personagem personagem){
        if(!usado){
            personagem.setVidaPersonagem(personagem.getVidaPersonagem());
            switch (tipoRemedio){
                case "Antibiótico":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem());
                    System.out.println("Você usou o antibiótico! Sua infecção foi curada!");
                    System.out.println("Continue sua jornada...");
                    break;
                case "Analgésico":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem());
                    System.out.println("Você usou o Analgésico! Agora suas dores irão sanar!");
                    System.out.println("Continue sua jornada...");
                    break;
                case "Bandagem":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem());
                    System.out.println("Você usou a Bandagem! Seus ferimentos irão sicratizar");
                    System.out.println("Continue sua jornada...");
                    break;
                case "Antídoto":
                    personagem.setVidaPersonagem(personagem.getVidaPersonagem());
                    System.out.println(" Você usou o Antídoto! Você foi curado!");
                    System.out.println("Continue sua jornada...");
                    break;
                default:
                    System.out.println("Ainda está perdendo vida!!!");
            }
            usado=true;
            return true;
        }else{
            System.out.println("Remédio já foi usado!");
            return false;
        }
    }
}
