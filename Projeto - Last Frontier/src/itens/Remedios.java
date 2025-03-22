package itens;

public class Remedios extends Item {
    //Atributos da subclasse:
    private String tipoRemedio;
    private String efeitoRemedio;
    //Metodos da subclasse:
    public Remedios(String nomeItem, double pesoItem, double durabilidadeItem, String tipoRemedio,
                    String efeitoRemedio){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoRemedio = tipoRemedio;
        this.efeitoRemedio = efeitoRemedio;
    }
    public void usarRemedio(){

    }
}
