package itens;

public class Alimentos extends Item  {
    //Atributos da subclasse
    private double valorNutricional;
    private String tipoAlimento;
    private int prazoValidade;
    //Metodo construtor:
    public Alimentos(String nomeItem, double pesoItem, double durabilidadeItem, double valorNutricional, String tipoAlimento, int prazoValidade) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.valorNutricional = valorNutricional;
        this.tipoAlimento = tipoAlimento;
        this.prazoValidade = prazoValidade;
    }
    //Metodos acessores:
    public void setValorNutricional(double valorNutricional){
        this.valorNutricional = valorNutricional;
    }
    public double getValorNutricional(){
        return valorNutricional;
    }
    public void setTipoAlimento(String tipoAlimento){
        this.tipoAlimento = tipoAlimento;
    }
    public String getTipoAlimento(){
        return tipoAlimento;
    }
    public void setPrazoValidade(int prazoValidade){
        this.prazoValidade = prazoValidade;
    }
    public int getPrazoValidade(){
        return prazoValidade;
    }
    //Metodo sobrescrito
    public void usar(String nomeItem) {

    }
}
