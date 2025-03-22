package personagens;

public class Infiltrador {
    private String nomeInfiltrador;
    private int vidaInfiltrador;
    private int sedeInfiltrador;
    private int fomeInfiltrador;
    private int energiaInfiltrador;
    private int sanidadeInfiltrador;
    private String inventarioInfiltrador;
    private String habilidadesInfiltrador;
    private String localizacaoInfiltrador;

    public Infiltrador(String nomeInfiltrador, int vidaInfiltrador, int sedeInfiltrador, int fomeInfiltrador, int energiaInfiltrador,
                  int sanidadeInfiltrador, String inventarioInfiltrador, String habilidadesInfiltrador, String localizacaoInfiltrador ){
        this.nomeInfiltrador="Malik Ghost";
        this.vidaInfiltrador=85;
        this.sedeInfiltrador=100;
        this.fomeInfiltrador=65;
        this.energiaInfiltrador=100;
        this.sanidadeInfiltrador=100;
        this.inventarioInfiltrador="dardos paralizantes,granada de fumaça, revólver";
        this.habilidadesInfiltrador="Camuflagem";
        this.localizacaoInfiltrador=localizacaoInfiltrador;
    }
    //Métodos getter para acessar os valores dos atributos
    public String getNomeInfiltrador() {
        return nomeInfiltrador;
    }
    public int getFomeInfiltrador() {
        return fomeInfiltrador;
    }
    public int getVidaInfiltrador() {
        return vidaInfiltrador;
    }
    public int getSedeInfiltrador() {
        return sedeInfiltrador;
    }
    public int getSanidadeInfiltrador() {
        return sanidadeInfiltrador;
    }
    public int getEnergiaInfiltrador() {
        return energiaInfiltrador;
    }
    public String getInventarioInfiltrador() {
        return inventarioInfiltrador;
    }
    public String getHabilidadesInfiltrador() {
        return habilidadesInfiltrador;
    }
    public String getLocalizacaoInfiltrador() {
        return localizacaoInfiltrador;
    }
    //Método para mostrar status
    public void mostrarStatus(){
        System.out.println("Nome: " + nomeInfiltrador);
        System.out.println("Vida: " + vidaInfiltrador);
        System.out.println("Sede: " + sedeInfiltrador);
        System.out.println("Fome: "+ fomeInfiltrador);
        System.out.println("Energia: "+ energiaInfiltrador);
        System.out.println("Sanidade: "+ sanidadeInfiltrador);
        System.out.println(" Inventário: "+ inventarioInfiltrador);
        System.out.println("Localização: "+ localizacaoInfiltrador);
    }
}
