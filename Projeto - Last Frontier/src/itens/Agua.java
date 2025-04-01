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
    //Metodo sobrescrito
    public void beber(String nomeItem) {

    }
}
