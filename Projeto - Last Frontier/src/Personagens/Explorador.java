package personagens;

public class Explorador {
    private String nomeExplorador;
    private int vidaExplorador;
    private int sedeExplorador;
    private int fomeExplorador;
    private int energiaExplorador;
    private int sanidadeExplorador;
    private String inventarioExplorador;
    private String habilidadesExplorador;
    private String localizacaoExplorador;

    public Explorador(String nomeExplorador, int vidaExplorador, int sedeExplorador, int fomeExplorador, int energiaExplorador,
                   int sanidadeExplorador, String inventarioExplorador, String habilidadesExplorador, String localizacaoExplorador ){
        this.nomeExplorador=nomeExplorador;
        this.vidaExplorador=vidaExplorador;
        this.sedeExplorador=sedeExplorador;
        this.fomeExplorador=fomeExplorador;
        this.energiaExplorador=energiaExplorador;
        this.sanidadeExplorador=sanidadeExplorador;
        this.inventarioExplorador=inventarioExplorador;
        this.habilidadesExplorador=habilidadesExplorador;
        this.localizacaoExplorador=localizacaoExplorador;
    }
    //Métodos getter, para acessar os valores dos atributos
    public String getNomeExplorador(){
        return nomeExplorador;
    }
    public int getVidaExploradro(){
        return vidaExplorador;
    }
    public int getEnergiaExplorador() {
        return energiaExplorador;
    }
    public int getSedeExplorador(){
        return sedeExplorador;
    }
    public int getFomeExplorador() {
        return fomeExplorador;
    }
    public int getSanidadeExplorador() {
        return sanidadeExplorador;
    }
    public String getHabilidadesExplorador() {
        return habilidadesExplorador;
    }
    public String getInventarioExplorador() {
        return inventarioExplorador;
    }
    public void getLocalizacaoExplorador(String localizacaoExplorador) {
        this.localizacaoExplorador = localizacaoExplorador;
    }
    //Método para mostrar status
    public void mostrarStatus(){
        System.out.println("Nome: " + nomeExplorador);
        System.out.println("Vida: " + vidaExplorador);
        System.out.println("Sede: " + sedeExplorador);
        System.out.println("Fome: "+ fomeExplorador);
        System.out.println("Energia: "+ energiaExplorador);
        System.out.println("Sanidade: "+ sanidadeExplorador);
        System.out.println(" Inventário: "+ inventarioExplorador);
        System.out.println("Localização: "+ localizacaoExplorador);
    }
}
