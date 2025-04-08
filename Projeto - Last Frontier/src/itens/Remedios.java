package itens;

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
    //Metodo sobrescrito:
    public void usar(String nomeItem){ //Metodo que será sobrescrito
    }
}
