package itens;

public class Remedios extends Item {
    //Atributos da subclasse:
    private String tipoRemedio;
    private String efeitoRemedio;
    //Metodos da subclasse:
    public Remedios(String nomeItem, double pesoItem, double durabilidadeItem, String tipoRemedio, String efeitoRemedio){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoRemedio = tipoRemedio;
        this.efeitoRemedio = efeitoRemedio;
    }
    public void setTipoRemedio(String tipoRemedio){
        this.tipoRemedio = tipoRemedio;
    }
    public String getTipoRemedio(){
        return tipoRemedio;
    }
    public void setEfeitoRemedio(String efeitoRemedio){
        this.efeitoRemedio = efeitoRemedio;
    }
    public void usarRemedio(){ //Metodo que será sobrescrito
    }
}
